package com.example.demo.controller;

import com.example.demo.commen.HttpCode;
import com.example.demo.commen.MyException;
import com.example.demo.commen.MyRsp;
import com.example.demo.commen.PageParam;
import com.example.demo.model.User;
import com.example.demo.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;//@valid校验注解
import java.util.List;

@RestController
@CrossOrigin
@Api(value = "user接口",description = "这是一个用户接口模块")
public class UserController {

    @Autowired
    UserService userService;
    /**
     * 查询所有用户
     *

  @PostMapping(value = "/getAllUser")
    public List<User> getAllUser(@RequestBody(required = false) User u){

        return userService.getAllUser(u);
    }

*/  //@RequiresPermissions("admin")
    //@RequiresRoles("general")
    @ApiOperation("查询所有用户")
    @PostMapping(value = "/getAllUser")
    public Object getAllUser(@RequestBody PageParam<User> pageParam){

        return userService.getAllUser(pageParam);
    }


    //通过ID查询
    @ApiOperation("通过ID查询一个用户的所有信息")
    @RequestMapping(value = "/getAllUserById/{id}",method = RequestMethod.GET)
    public Object getAllUserById(@PathVariable("id") int id){

        User user =userService.getAllUserById(id);
        return user!=null?MyRsp.success(user):MyRsp.wrapper(new MyException(HttpCode.ERROR));
    }
    /**
     删除用户
     */
    //@PathVariable标准映射的功能
    @ApiOperation("根据ID对用户进行删除")
    @RequestMapping(value = "/deleteUser/{id}",method = RequestMethod.GET)
    public  Object deleteUser(@PathVariable("id") int id){
        return userService.deleteUser(id);
    }

    /**
     *添加用户*/

    @ApiOperation("查询所有用户")
    @PostMapping("/addUser")
    public Object addUser(@RequestBody @Valid User user){
        return userService.addUser(user)?MyRsp.success(null)
                .msg("添加成功"):MyRsp.error().msg("添加失败");
    }

    //修改用户
    @ApiOperation("修改用户")
    @RequestMapping(value = "/updateUser",method = RequestMethod.PUT)
    public Object updateUser(@RequestBody @Valid User user){
        user.setUserName(null);
        User u =userService.getAllUserById(user.getId());
        user.setIsActive(u.getIsActive());

        return userService.updateUser(user)?MyRsp.success(null).msg("修改成功"):MyRsp.error().msg("添加成功");
    }

}
