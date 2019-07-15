package com.example.demo.commen;

import lombok.Data;

@Data
public class MyRsp {


    private int code;
    private String msg;
    private Object content;


    public MyRsp(int code, String msg, Object content) {
        this.code = code;
        this.msg = msg;
        this.content = content;
    }

    public static MyRsp wrapper(MyException e){
        MyRsp myRsp =new MyRsp();
        myRsp.setCode(e.getCode());
        myRsp.setMsg(e.getMsg());
        myRsp.setContent(null);
        return  myRsp;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public MyRsp() {
    }

    /**
     * 给信息失败异常进行处理
     * @return
     */
    public static MyRsp error(){
        MyRsp myRsp=new MyRsp();
        myRsp.setCode(HttpCode.ERROR.getCode());
        myRsp.setMsg(HttpCode.ERROR.getMsg());
        myRsp.setContent(null);

        return myRsp;
    }

    /**
     * 给信息成功进行处理
     * @return
     */

    public static MyRsp success(Object content){
        MyRsp myRsp=new MyRsp();
        myRsp.setCode(HttpCode.SUCCESS.getCode());
        myRsp.setMsg(HttpCode.SUCCESS.getMsg());
        myRsp.setContent(content);

        return myRsp;
    }

    public MyRsp msg(String msg){  // 自定义msg  链式函数
        this.msg=msg;
        return this;
    }
}
