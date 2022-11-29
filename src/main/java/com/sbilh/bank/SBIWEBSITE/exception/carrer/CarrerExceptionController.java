package com.sbilh.bank.SBIWEBSITE.exception.carrer;

import com.sbilh.bank.SBIWEBSITE.exception.CarrerException;
import com.sbilh.bank.SBIWEBSITE.exception.NotFoundException;
import com.sbilh.bank.SBIWEBSITE.extra.carrer.ResponseCarrer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class CarrerExceptionController {
    @ExceptionHandler(value = CarrerException.class)
    public ResponseEntity<Object> exception(CarrerException e){
        Map<String,Object> res = new HashMap<>();
        res.put("error", e.getMessage());
        res.put("status", "error");
        res.put("code", HttpStatus.NOT_FOUND.value());
        log.error("get carrer by {} doesn't found",res);
        return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> exception(Exception e){
        Map<String,Object> res = new HashMap<>();
        res.put("error", e.getMessage());
        res.put("status", "error");
        res.put("code", HttpStatus.NOT_FOUND.value());
        log.error("get carrer by {} doesn't found",res);
        return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<Object> exception(NotFoundException e){
        Map<String, Object> res = new HashMap<>();
        res.put("error", e.getMessage());
        res.put("status", "error");
        res.put("code", HttpStatus.NOT_FOUND.value());
        log.error("get carrer by {} doesn't found",res);
        return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
    }


    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<Object> response(HttpServletResponse httpServletResponse){
        return new ResponseEntity<>(new ResponseCarrer(HttpStatus.OK.value(),"success",httpServletResponse.getLocale()), HttpStatus.NOT_FOUND);
    }

}
