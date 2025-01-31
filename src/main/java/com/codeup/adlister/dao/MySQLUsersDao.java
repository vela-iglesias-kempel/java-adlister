package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Password;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class MySQLUsersDao implements Users {
    private Connection connection;

    public MySQLUsersDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }


    @Override
    public User findByUsername(String username) {

        String query = "SELECT * FROM users WHERE username = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, username);
            return extractUser(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a user by username", e);
        }
    }

    @Override
    public Long insert(User user) {
        MySQLUsersDao adConnection = new MySQLUsersDao(new Config());
        User duplicateUser = adConnection.findByUsername(user.getUsername());
        if (duplicateUser != null) {
            return -1L;

        } else {
            String query = "INSERT INTO users(username, email, password) VALUES (?, ?, ?)";
            try {
                PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                stmt.setString(1, user.getUsername());
                stmt.setString(2, user.getEmail());
                stmt.setString(3, user.getPassword());
                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();
                rs.next();
                return rs.getLong(1);
            } catch (SQLException e) {
                throw new RuntimeException("Error creating new user", e);
            }
        }
    }

    private User extractUser(ResultSet rs) throws SQLException {
        if (!rs.next()) {
            return null;
        }
        return new User(
                rs.getLong("id"),
                rs.getString("username"),
                rs.getString("email"),
                rs.getString("password")
        );
    }

    @Override
    public String getUserNameByAdId(Long adId) {
        String query = "SELECT username FROM users JOIN ads ON ads.user_id = users.id And ads.id = ? ";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, adId);
            stmt.executeQuery();
            ResultSet rs = stmt.getResultSet();
//            System.out.println("executed query");
//            System.out.println("ad id = " + adId);
//            System.out.println(rs);
//            while (rs.next())
//                System.out.println(rs.getString("username"));
//            User u = new User(
//                    rs.getLong("id"),
//                    rs.getString("username"),
//                    rs.getString("email"),
//                    rs.getString("password")
//            );
//            return u.getUsername();
            while (rs.next())
                return rs.getString("username");
            return "no username found";
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a user by username", e);
        }
    }

    public int updateEmail(String newEmail, long userId) {

        try {
            String updateQuery = "update users set email = ? where  id = ?";
            PreparedStatement stmt = connection.prepareStatement(updateQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, newEmail);
            stmt.setLong(2, userId);
            int row = stmt.executeUpdate();

            // rows affected
//            System.out.println(row);
            return row;
        } catch (SQLException e) {
            throw new RuntimeException("Error updating email", e);
        }
    }
    public int updatePassword(String newPassword, long userId) {

        try {
            String updateQuery = "update users set password = ? where  id = ?";
            PreparedStatement stmt = connection.prepareStatement(updateQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, Password.hash(newPassword));
            stmt.setLong(2, userId);
            int row = stmt.executeUpdate();

            // rows affected
//            System.out.println(row);
            return row;
        } catch (SQLException e) {
            throw new RuntimeException("Error updating password", e);
        }
    }

}

