package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLUsersDao implements Users {
    Connection connection;

    public MySQLUsersDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException sqlException) {
            throw new RuntimeException("Error connecting to the database!", sqlException);
        }
    }

    @Override
    public User findByUsername(String username) {
        String query = "SELECT * FROM users WHERE username LIKE ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, username);
            stmt.executeQuery();
            ResultSet res = stmt.getResultSet();
            if (res.next())
                return new User(
                        res.getLong("id"),
                        res.getString("username"),
                        res.getString("email"),
                        res.getString("password")
                );
            else return null;
        } catch (SQLException sqlException) {
            throw new RuntimeException("cannot find user");
        }
    }

    @Override
    public Long insert(User user) {
        String query = "INSERT INTO users(password, email, username) values (?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getPassword());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getUsername());
            stmt.executeUpdate();
            ResultSet keys = stmt.getGeneratedKeys();
            keys.next();
            return keys.getLong(1);
        } catch (SQLException sqlException) {
            throw new RuntimeException("cannot create account.");
        }
    }
}