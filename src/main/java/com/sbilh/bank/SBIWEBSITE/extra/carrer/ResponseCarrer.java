package com.sbilh.bank.SBIWEBSITE.extra.carrer;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@AllArgsConstructor
@Data
public class ResponseCarrer implements Serializable {
    private int code;
    private String status;
    private Object data;
}
