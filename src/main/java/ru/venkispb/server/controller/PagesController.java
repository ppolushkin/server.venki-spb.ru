package ru.venkispb.server.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping(path = "/{reference}/content", produces = "text/plain")
    public String getPageContent(@PathVariable String application, @PathVariable String reference) {
        return pagesService.getPage(application, reference).content;
    }

    @PutMapping(path = "/{reference}/content", consumes = "text/plain")
    public ResponseEntity updatePageContent(@PathVariable String application, @PathVariable String reference, @RequestBody String content) {
        Page page = pagesService.getPage(application, reference);
        page.content = content;
        pagesService.updatePage(application, reference, page);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/{reference}")
    public Page updatePage(@PathVariable String application, @PathVariable String reference,
                           @RequestBody Page page) {
        return pagesService.updatePage(application, reference, page);
    }

    @PostMapping
    public Page createPage(@PathVariable String application, @RequestBody Page page) {
        return pagesService.createPage(application, page);
    }

    @DeleteMapping(value = "/{reference}")
    public ResponseEntity deletePage(@PathVariable String application, @PathVariable String reference) {
        pagesService.deletePage(application, reference);
        return ResponseEntity.ok().build();
    }

}
