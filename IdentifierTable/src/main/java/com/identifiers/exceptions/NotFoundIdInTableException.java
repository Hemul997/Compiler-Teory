package com.identifiers.exceptions;

public class NotFoundIdInTableException extends Exception {
    private final String message = "The transmitted identifier not found in the table";
    private Throwable throwable;

    public NotFoundIdInTableException() {
        this.throwable = new Throwable(this.message);
        initCause(this.throwable);
    }
}
