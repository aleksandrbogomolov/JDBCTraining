package com.aleksandrbogomolov.jdbc_training.service;

import com.aleksandrbogomolov.jdbc_training.entity.User;

import java.util.List;

public interface UserService {

    User save(User user);

    void update(User user);

    User getOne(int id);

    void delete(int id);

    List<User> getAll();
}
