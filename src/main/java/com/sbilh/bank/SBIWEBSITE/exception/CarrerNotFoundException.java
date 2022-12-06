package com.sbilh.bank.SBIWEBSITE.exception;

import org.springframework.lang.Nullable;

public class CarrerNotFoundException extends RuntimeException{
    private String message;
    private String result;
    public CarrerNotFoundException( Long id,String... message){
        super(message.length > 0 ? String.join("\n",message) : "Could not find id: " + id.toString());
//        if(!message.equals(null))
    }
}
