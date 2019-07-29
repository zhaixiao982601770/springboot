package com.example.demo.dao;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDao {

    /*查询所有*/
    List<User> getAllUser(User u);
    //按照id进行删除
    int deleteUser(int id);
    //添加
    int addUser(User user);
    //修改
    int updateUser(User user);

    User getAllUserById(int id);


    @Select("select * from users where userName=#{userName}")
    User getAllUserByName(String userName);
}
