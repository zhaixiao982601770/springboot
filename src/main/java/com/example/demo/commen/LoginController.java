package com.example.demo.commen;

import com.example.demo.model.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("login")
@CrossOrigin
public class LoginController {

    @Autowired
    UserService userService;

    @PostMapping("/user")
    public Object user(@RequestBody User user){

        User u =userService.login(user.getUserName(),user.getPassword());

        return u!=null? MyRsp.success(u):MyRsp.error().msg("登录失败");
    }



}
