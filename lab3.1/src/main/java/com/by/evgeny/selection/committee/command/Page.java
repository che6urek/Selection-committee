package com.by.evgeny.selection.committee.command;

public class Page {

    public static final String MAIN_PAGE_PATH = "/pages/common/main.jsp";
    public static final String FACULTIES_PAGE_PATH = "/pages/common/faculties.jsp";
    public static final String SPECIALITIES_PAGE_PATH  = "/pages/common/specialities.jsp";
    public static final String STUDENTS_PAGE_PATH  = "/pages/common/students.jsp";
    public static final String ENROLLEES_PAGE_PATH  = "/pages/common/enrollees.jsp";

    private final String pageUrl;
    private final boolean isRedirect;

    public Page(String pageUrl, boolean isRedirect) {
        this.pageUrl = pageUrl;
        this.isRedirect = isRedirect;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public boolean isRedirect() {
        return isRedirect;
    }
}
