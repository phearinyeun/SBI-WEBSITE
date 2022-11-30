package com.sbilh.bank.SBIWEBSITE.exception;

public class CarrerNotFoundException extends RuntimeException{
    public CarrerNotFoundException(Long id){
        super("Coudl not found Carrer id " + id);
    }
}
