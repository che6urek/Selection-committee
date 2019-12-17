package com.by.evgeny.selection.committee.command.common;

import com.by.evgeny.selection.committee.command.Command;
import com.by.evgeny.selection.committee.command.Page;

import javax.servlet.http.HttpServletRequest;

public class HomePageCommand implements Command {

    public Page execute(HttpServletRequest request) {
        return new Page(Page.MAIN_PAGE_PATH, false);
    }
}