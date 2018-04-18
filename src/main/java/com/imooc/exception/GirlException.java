package com.imooc.exception;

import lombok.Data;

@Data
public class GirlException extends RuntimeException {
    private Integer code;

    public GirlException(Integer code,String message){
        super(message);
        this.code = code;
    }
}
