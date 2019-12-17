package com.by.evgeny.selection.committee.command;

import com.by.evgeny.selection.committee.exceptions.ServiceException;

import javax.servlet.http.HttpServletRequest;

public interface Command {
    Page execute(HttpServletRequest request) throws ServiceException;
}
