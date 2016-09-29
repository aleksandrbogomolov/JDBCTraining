package com.aleksandrbogomolov.jdbc_training.dao;

import com.aleksandrbogomolov.jdbc_training.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Transactional(readOnly = true)
public class UserDaoImpl implements UserDao {

    private final NamedParameterJdbcTemplate template;

    private final RowMapper<User> userRowMapper = (rs, i) -> new User(
            rs.getInt("id"), rs.getString("name"),
            rs.getString("email"), rs.getDate("create_date").toLocalDate());

    @Autowired
    public UserDaoImpl(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    @Transactional
    @Override
    public User save(User user) {
//        template.update("INSERT INTO users (id, name, email) VALUES (?, ?, ?)",
//                user.isNew() ? null : user.getId(),
//                user.getName(),
//                user.getEmail());
        return user;
    }

    @Override
    public User getOne(int id) {
        Map<String, Object> namedParam = new HashMap<>();
        namedParam.put("id", id);
        List<User> users = template.query("SELECT * FROM users WHERE id=:id", namedParam, userRowMapper);
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
