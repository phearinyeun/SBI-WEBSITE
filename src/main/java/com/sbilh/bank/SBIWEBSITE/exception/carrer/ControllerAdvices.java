package com.sbilh.bank.SBIWEBSITE.exception.carrer;

import com.sbilh.bank.SBIWEBSITE.exception.CarrerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class ControllerAdvices {
    @ResponseBody
    @ExceptionHandler(CarrerNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)

    String carrerNotFoundHandle(CarrerNotFoundException cx){
        return cx.getMessage();
    }
}
