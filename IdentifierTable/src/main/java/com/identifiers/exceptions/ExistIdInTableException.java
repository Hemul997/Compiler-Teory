package com.identifiers.exceptions;

public class ExistIdInTableException extends Exception {
    private Throwable throwable;
    private final String message = "The transmitted identifier exists in the table";

    public ExistIdInTableException() {
        this.throwable = new Throwable(this.message);
        initCause(this.throwable);
    }
}
