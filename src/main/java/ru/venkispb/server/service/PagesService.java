package ru.venkispb.server.service;

import org.springframework.stereotype.Service;
import ru.venkispb.server.entity.PagesEntity;
import ru.venkispb.server.exception.NotFoundRuntimeException;
import ru.venkispb.server.repository.PagesRepository;
import ru.venkispb.server.repository.RevisionsRepository;
import ru.venkispb.server.vo.Page;

@Service
public class PagesService {

    private final PagesRepository pagesRepository;

    private final RevisionsRepository revisionsRepository;

    public PagesService(PagesRepository pagesRepository, RevisionsRepository revisionsRepository) {
        this.pagesRepository = pagesRepository;
        this.revisionsRepository = revisionsRepository;
    }

    public Page getPage(String applicationId, String pageReference) {

        PagesEntity pagesEntity = pagesRepository.findByReferenceAndApplicationName(pageReference, applicationId).
                orElseThrow(NotFoundRuntimeException::new);

        Page page = new Page();

        page.reference = pagesEntity.reference;
        page.title = pagesEntity.title;

        return page;

    }


}
