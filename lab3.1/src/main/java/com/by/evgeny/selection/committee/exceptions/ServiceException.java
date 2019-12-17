package com.by.evgeny.selection.committee.exceptions;

public class ServiceException extends Exception {

    public ServiceException(String message, Exception e) {
        super(message, e);
    }
}
