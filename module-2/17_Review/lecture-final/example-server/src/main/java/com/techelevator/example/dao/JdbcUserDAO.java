package com.techelevator.example.dao;

import com.techelevator.example.model.User;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.IncorrectResultSetColumnCountException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcUserDAO implements UserDAO {

    private JdbcTemplate jdbcTemplate;

    public JdbcUserDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    @Override
    public User findByUsername(String username) throws UsernameNotFoundException {
        String sql = "SELECT user_id, username, password_hash, role FROM users WHERE username = ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, username);
        if (rowSet.next()){
            return mapRowToUser(rowSet);
        }
        throw new UsernameNotFoundException("User " + username + " was not found.");
    }

    @Override
    public boolean create(String username, String password, String role) {
        if (role == null || role.isEmpty()) {
            role = "ROLE_USER"; //default
        } else {
            role = "ROLE_" + role.toUpperCase();
        }

        String sql = "INSERT INTO users (username, password_hash, role) VALUES (?, ?, ?)";
        String password_hash = new BCryptPasswordEncoder().encode(password);
        try {
            int count = jdbcTemplate.update(sql, username, password_hash, role);
            return (count == 1);
        } catch (DataAccessException e) {
            return false;
        }
    }

    private User mapRowToUser(SqlRowSet rowSet) {
        User user = new User();
        user.setId(rowSet.getLong("user_id"));
        user.setUsername(rowSet.getString("username"));
        user.setPassword(rowSet.getString("password_hash"));
        user.setAuthorities(rowSet.getString("role"));
        user.setActivated(true);
        return user;
    }
}
