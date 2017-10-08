package ru.venkispb.server.service;

import org.springframework.stereotype.Service;
import ru.venkispb.server.entity.PagesEntity;
import ru.venkispb.server.exception.NotFoundRuntimeException;
import ru.venkispb.server.repository.PagesRepository;
import ru.venkispb.server.repository.RevisionsRepository;
import ru.venkispb.server.vo.Page;

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

        page.content = revisionsRepository.findByPageId(pagesEntity.id).
                map(r -> r.content).orElse("No content on that page");

        return page;
    }


}
