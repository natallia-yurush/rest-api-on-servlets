package com.vladbudan.app.service;

import com.vladbudan.app.model.User;

import java.util.List;

public interface UserService {

    void addUser(User user);
    void updateUser(User user);
    User getUserById(Integer id);
    void deleteUser(Integer id);
    List<User> getAllUsers();
}
