package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

public interface Users {
    User findByUsername(String username);
    Long insert(User user);
    String getUserNameByAdId(Long AdId);
    int updateEmail(String newEmail, long userId);
    int updatePassword(String newPassword, long userId);
}
