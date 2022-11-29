package com.sbilh.bank.SBIWEBSITE.exception;

public class CarrerException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    private String message;
    public CarrerException(String message){
        super(message);
        this.message = message;
    }

}
