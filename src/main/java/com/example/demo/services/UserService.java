package com.example.demo.services;

import com.example.demo.commen.PageParam;
import com.example.demo.model.User;

import java.util.List;

public interface UserService {
    Object getAllUser(PageParam<User> pageParam);

    boolean deleteUser(int id);

    boolean addUser(User user);

    boolean updateUser(User user);

    User getAllUserById(int id);
}
