package com.example.demo.model;


import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {


    private  String userName;

    private  String password;
    /*public static void main(String[] args) {
        User user = new User();
        user.setUserName("hhh");
        user.setPassWord("123");
        System.out.println(user);
    }*/
    private int id;

    private String roleId;
}
