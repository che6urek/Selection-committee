package com.by.evgeny.selection.committee.exceptions;

public class InvalidFileException extends Exception{

    public InvalidFileException(String message, Exception e) {
        super(message, e);
    }
}
