package ru.venkispb.server.vo;

import ru.venkispb.server.entity.PagesEntity;

public class  Page {

    public String title;
    public String reference;
    public String content;

    public static Page of(PagesEntity entity) {
        Page page = new Page();
        page.title = entity.title;
        page.reference = entity.reference;
        return page;
    }

}
