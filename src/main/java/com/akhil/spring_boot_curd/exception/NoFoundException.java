package com.akhil.spring_boot_curd.exception;

public class NoFoundException extends RuntimeException{

    private String message;

    public NoFoundException() {}

    public NoFoundException(String msg) {
        super(msg);
        this.message=msg;
    }
}
