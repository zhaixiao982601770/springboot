package com.example.demo.commen;

import lombok.Data;

@Data
public class MyException extends RuntimeException {

    private int code;
    private String msg;

    public MyException(HttpCode httpCode) {
        this.code = httpCode.getCode();
        this.msg = httpCode.getMsg();
    }


    public MyException msg(String msg){//自定义this  链式han's
        this.msg=msg;
        return this;
    }
}
