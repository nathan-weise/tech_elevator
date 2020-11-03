package com.techelevator.example.dao;

import com.techelevator.example.model.User;

import java.util.List;

public interface UserDAO {

    User findByUsername(String username);

    boolean create(String username, String password, String role);
}
