package com.example.demo.controller;

import com.example.demo.commen.HttpCode;
import com.example.demo.commen.MyException;
import com.example.demo.commen.MyRsp;
import com.example.demo.commen.PageParam;
import com.example.demo.model.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;//@valid校验注解
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;
    /**
     * 查询所有用户

  @PostMapping(value = "/getAllUser")
    public List<User> getAllUser(@RequestBody(required = false) User u){

        return userService.getAllUser(u);
    }
*/
    @PostMapping(value = "/getAllUser")
    public Object getAllUser(@RequestBody PageParam<User> pageParam){

        return userService.getAllUser(pageParam);
    }


    //
    @RequestMapping(value = "/getAllUserById/{id}",method = RequestMethod.GET)
    public Object getAllUserById(@PathVariable("id") int id){

        User user =userService.getAllUserById(id);
        return user!=null?MyRsp.success(user):MyRsp.wrapper(new MyException(HttpCode.ERROR));
    }
    /**
     删除用户
     */
    //@PathVariable标准映射的功能
    @RequestMapping(value = "/deleteUser/{id}",method = RequestMethod.GET)
    public  Object deleteUser(@PathVariable("id") int id){
        return userService.deleteUser(id);
    }

    /**
     *添加用户*/

    @PostMapping("/addUser")
    public Object addUser(@RequestBody @Valid User user){
        return userService.addUser(user)?MyRsp.success(null)
                .msg("添加成功"):MyRsp.error().msg("添加失败");
    }

    //修改用户
    @RequestMapping(value = "/updateUser",method = RequestMethod.PUT)
    public Object updateUser(@RequestBody @Valid User user){
        return userService.updateUser(user)?MyRsp.success(null).msg("修改成功"):MyRsp.error().msg("添加成功");
    }

}
