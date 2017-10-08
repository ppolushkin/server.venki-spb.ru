package ru.venkispb.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.venkispb.server.service.PagesService;
import ru.venkispb.server.vo.Page;

import java.util.List;

import static java.util.Comparator.comparing;

@RestController
@RequestMapping("/{application}/pages")
public class PagesController {

    private final PagesService pagesService;

    public PagesController(PagesService pagesService) {
        this.pagesService = pagesService;
    }

    @GetMapping
    public List<Page> getApplicationPages(@PathVariable String application) {
        List<Page> pages = pagesService.getPages(application);
        pages.sort(comparing(p -> p.reference));
        return pages;
    }

    @GetMapping(value = "/{reference}")
    public Page getPage(@PathVariable String application, @PathVariable String reference) {
        return pagesService.getPage(application, reference);
    }

}
