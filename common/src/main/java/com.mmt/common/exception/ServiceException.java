package com.mmt.common.exception;

public class ServiceException extends RuntimeException {
    private String msg;
    public ServiceException(String msg){
        super();
        this.msg = msg;
    }
}
