package com.aleksandrbogomolov.jdbc_training.dao;

import com.aleksandrbogomolov.jdbc_training.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public class UserDaoImpl implements UserDao {

    private final RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);

    private final JdbcTemplate template;

    @Autowired
    public UserDaoImpl(JdbcTemplate template) {
        this.template = template;
    }

    @Transactional
    @Override
    public User save(User user) {
        template.update("INSERT INTO users (id, name, email, role) VALUES (?, ?, ?, ?)",
                user.isNew()? null : user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole().toString());
        return user;
    }

    @Override
    public User getOne(int id) {
        List<User> users = template.query("SELECT * FROM users WHERE id=?", rowMapper, id);
        return users.get(0);
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Transactional
    @Override
    public boolean delete(int id) {
        return false;
    }
}
