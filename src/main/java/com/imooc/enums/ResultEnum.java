package com.imooc.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum  ResultEnum {
    RM2001(-1,"未知错误"),
    SUCCESS(0, "成功");

    @Getter
    private Integer code;
    @Getter
    private String msg;
}
