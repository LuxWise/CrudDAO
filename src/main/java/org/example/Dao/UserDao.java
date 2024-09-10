package org.example.Dao;

import org.example.Model.User;

import java.util.List;

public interface UserDao {
    User getUserById(Integer id);
    List<User> getAllUsers();
    void insertUser(User user);
    void updateUser(User user);
    void deleteUser(Integer id);
}
