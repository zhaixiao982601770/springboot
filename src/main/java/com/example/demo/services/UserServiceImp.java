package com.example.demo.services;

import com.example.demo.commen.HttpCode;
import com.example.demo.commen.MyException;
import com.example.demo.commen.PageParam;
import com.example.demo.dao.UserDao;
import com.example.demo.model.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@Slf4j
@Transactional      //添加事务
public class UserServiceImp implements UserService{

    @Autowired
    UserDao userDao;

    //查询所有
    @Override
    @Transactional(readOnly = true)
    public Object getAllUser(PageParam<User> pageParam) {

        //分页
        PageHelper.startPage(pageParam.getPageNum(),pageParam.getPageSize());
        for(int i=0;i<pageParam.getOrderParams().length;i++){
            //排序
            PageHelper.orderBy(pageParam.getOrderParams()[i]);
        }

        List<User> userList =userDao.getAllUser(pageParam.getModel());
        PageInfo<User> userPageInfo =new PageInfo<User>(userList);
        return userPageInfo;
    }

    //删除
    @Override
    public boolean deleteUser(int id){
        return  userDao.deleteUser(id)==1;
    }

    //添加
    @Override
    public boolean addUser(User user) {
        user.setRoleId("general");
        return userDao.addUser(user)==1;
    }

    //修改
    @Override
    public boolean updateUser(User user) {
        if (StringUtils.isEmpty(user.getId())){
            throw new MyException(HttpCode.ERROR).msg("通过id用户查询的时,id不能为空");
        }
        return userDao.updateUser(user)==1;
    }

    //根据ID进行查询
    @Cacheable(key = "#p0",value = "users")
    @Override
    @Transactional(readOnly = true)
    public User getAllUserById(int id) {
        log.info("走的是数据库查询");
        return userDao.getAllUserById(id);
    }

    //用户登录
    @Override
    public User login(String userName, String password) {
        User con =new User();
        con.setUserName(userName);
        con.setPassword(password);

        List<User> userList =userDao.getAllUser(con);
        User user =null;
        if (userList.size()!=0){
            user=userList.get(0);
        }
        return user;
    }

    //用户注册
    @Override
    public User register(User user) {
        user.setIsActive(0);
        user.setRoleId("general");
        userDao.addUser(user);

        return userDao.getAllUserById(user.getId());
    }

    @Override
    public User userNameIsReged(String userName) {
        return userDao.getAllUserByName(userName);
    }
}
