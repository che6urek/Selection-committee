package com.by.evgeny.selection.committee.exceptions;

public class DataBaseException extends Exception{

    public DataBaseException(String message, Exception e) {
        super(message, e);
    }
}
