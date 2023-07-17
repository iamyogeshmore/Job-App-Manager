package com.jobappmanager.exception;

public class JobAppManagerException extends RuntimeException {
    String message;

    public JobAppManagerException(String message) {
        this.message = message;
    }

    public JobAppManagerException() {

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
