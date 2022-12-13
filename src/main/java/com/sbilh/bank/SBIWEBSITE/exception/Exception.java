package com.sbilh.bank.SBIWEBSITE.exception;

public class Exception extends RuntimeException{
    private static final long serialVersionUID = 1L;
    private String message;
    public Exception(String message){
        super(message);
        this.message = message;
    }

}
