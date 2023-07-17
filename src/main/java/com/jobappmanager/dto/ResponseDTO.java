package com.jobappmanager.dto;

import com.jobappmanager.model.Application;

public class ResponseDTO {
    String message;
    Object obj;

    public ResponseDTO(Object obj, String message) {
        this.obj = obj;
        this.message = message;
    }

    public ResponseDTO(String obj, Application newApplicationData) {

    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
