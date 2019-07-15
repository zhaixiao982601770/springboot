package com.example.demo.commen;

public enum HttpCode {

    SUCCESS(200,"访问成功。。。。"),
    ERROR(500,"服务器好像出问题了.....")
    ;


    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    HttpCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
