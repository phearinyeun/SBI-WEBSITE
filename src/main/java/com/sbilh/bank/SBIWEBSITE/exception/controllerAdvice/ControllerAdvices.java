package com.sbilh.bank.SBIWEBSITE.exception.controllerAdvice;

import com.sbilh.bank.SBIWEBSITE.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class ControllerAdvices {
    @ResponseBody
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)

    String carrerNotFoundHandle(NotFoundException cx){
        return cx.getMessage();
    }
}
