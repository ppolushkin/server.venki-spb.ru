package ru.venkispb.server.service;

import org.springframework.stereotype.Service;
import ru.venkispb.server.entity.PagesEntity;
import ru.venkispb.server.entity.RevisionsEntity;
import ru.venkispb.server.exception.NotFoundRuntimeException;
import ru.venkispb.server.repository.PagesRepository;
import ru.venkispb.server.repository.RevisionsRepository;
import ru.venkispb.server.vo.Page;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class PagesService {

    private final PagesRepository pagesRepository;

    private final RevisionsRepository revisionsRepository;

    public PagesService(PagesRepository pagesRepository, RevisionsRepository revisionsRepository) {
        this.pagesRepository = pagesRepository;
        this.revisionsRepository = revisionsRepository;
    }

    public List<Page> getPages(String applicationId) {
        return pagesRepository.findByApplicationName(applicationId).stream().
                map(Page::of).collect(toList());
    }

    public Page getPage(String applicationId, String pageReference) {
        PagesEntity pagesEntity = pagesRepository.findByApplicationNameAndReference(applicationId, pageReference).
                orElseThrow(NotFoundRuntimeException::new);

        Page page = Page.of(pagesEntity);

        revisionsRepository.findByPageId(pagesEntity.id);


        page.content = revisionsRepository.findTopByPageIdOrderByIdDesc(pagesEntity.id).
                map(r -> r.content).orElse("No content on that page");

        return page;
    }

    @Transactional
    public void deletePage(String applicationId, String pageReference) {
        PagesEntity pagesEntity = pagesRepository.findByApplicationNameAndReference(applicationId, pageReference).
                orElseThrow(NotFoundRuntimeException::new);

        List<RevisionsEntity> revisions = revisionsRepository.findByPageId(pagesEntity.id);
        revisions.forEach(revisionsRepository::delete);

        pagesRepository.delete(pagesEntity);
    }

    @Transactional
    public Page updatePage(String applicationId, String pageReference, Page page) {
        PagesEntity pagesEntity = pagesRepository.findByApplicationNameAndReference(applicationId, pageReference).
                orElseThrow(NotFoundRuntimeException::new);

        pagesEntity.title = page.title;
        pagesEntity.reference = page.reference;

        pagesRepository.save(pagesEntity);

        RevisionsEntity revisionsEntity = revisionsRepository.findTopByPageIdOrderByIdDesc(pagesEntity.id).get();
        revisionsEntity.content = page.content;
        revisionsEntity.updatedAt = new Timestamp(System.currentTimeMillis());

        revisionsRepository.save(revisionsEntity);
        return page;
    }

    @Transactional
    public Page createPage(String applicationId, Page page) {

        PagesEntity pagesEntity = new PagesEntity();
        pagesEntity.applicationName = applicationId;
        pagesEntity.reference = page.reference;
        pagesEntity.title = page.title;
        pagesEntity.createdAt = new Timestamp(System.currentTimeMillis());
        pagesEntity.updatedAt = new Timestamp(System.currentTimeMillis());

        pagesRepository.save(pagesEntity);

        RevisionsEntity revisionsEntity = new RevisionsEntity();
        revisionsEntity.pageId = pagesEntity.id;
        revisionsEntity.content = page.content;
        revisionsEntity.createdAt = new Timestamp(System.currentTimeMillis());
        revisionsEntity.updatedAt = new Timestamp(System.currentTimeMillis());

        revisionsRepository.save(revisionsEntity);

        return page;
    }

}
