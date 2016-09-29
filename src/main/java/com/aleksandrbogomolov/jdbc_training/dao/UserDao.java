package com.aleksandrbogomolov.jdbc_training.dao;

import com.aleksandrbogomolov.jdbc_training.entity.User;

import java.util.List;

public interface UserDao {

    User save(User user);

    User getOne(int id);

    List<User> getAll();

    boolean delete(int id);
}
