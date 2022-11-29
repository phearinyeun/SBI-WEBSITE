package com.sbilh.bank.SBIWEBSITE.extra.carrer;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class NotFoundException implements Serializable {
    private int code;
    private String status;
    private Object data;
}
