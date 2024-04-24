package com.studentManagement.Exception;

public class IOException extends RuntimeException {
    private String message;
    public IOException(String message, int errorCode)
    {
        super(message);
        this.message = message;
    }
}
