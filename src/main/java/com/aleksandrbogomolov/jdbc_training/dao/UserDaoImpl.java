package com.aleksandrbogomolov.jdbc_training.dao;

import com.aleksandrbogomolov.jdbc_training.entity.Role;
import com.aleksandrbogomolov.jdbc_training.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Repository
@Transactional(readOnly = true)
public class UserDaoImpl implements UserDao {

    private final JdbcTemplate jdbcTemplate;

    private final NamedParameterJdbcTemplate namedTemplate;

    private final SimpleJdbcInsert jdbcInsert;

    private final RowMapper<User> userRowMapper = (rs, i) -> new User(
            rs.getInt("id"), rs.getString("name"),
            rs.getString("email"), rs.getDate("create_date").toLocalDate());

    @Autowired
    public UserDaoImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate template, DataSource dataSource) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedTemplate = template;
        this.jdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("users").usingGeneratedKeyColumns("id");
    }

    @Transactional
    @Override
    public User saveOrUpdate(User user) {
        Map<String, Object> namedParam = new HashMap<>();
        namedParam.put("id", user.getId());
        namedParam.put("name", user.getName());
        namedParam.put("email", user.getEmail());
        if (user.isNew()) {
            Number key = jdbcInsert.executeAndReturnKey(namedParam);
            user.setId(key.intValue());
            setRole(user);
        }
        return user;
    }

    @Override
    public User getOne(int id) {
        Map<String, Object> namedParam = new HashMap<>();
        namedParam.put("id", id);
        List<User> users = namedTemplate.query("SELECT * FROM users WHERE id=:id", namedParam, userRowMapper);
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

    private void setRole(User user) {
        Iterator<Role> iterator = user.getRoles().iterator();
        jdbcTemplate.batchUpdate("INSERT INTO user_role (user_id, role) VALUES (?, ?)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        ps.setInt(1, user.getId());
                        ps.setString(2, iterator.next().name());
                    }

                    @Override
                    public int getBatchSize() {
                        return user.getRoles().size();
                    }
                });
    }
}
