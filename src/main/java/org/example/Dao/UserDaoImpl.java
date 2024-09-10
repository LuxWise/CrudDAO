package org.example.Dao;

import org.example.Model.User;
import org.example.Util.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public User getUserById(Integer id) {
        User user = null;
        try (Connection conn = DbConnection.getConnection()) {
            String sql = "SELECT * FROM Users WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setObject(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try (Connection conn = DbConnection.getConnection()) {
            String sql = "SELECT * FROM Users";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void insertUser(User user) {
        try (Connection conn = DbConnection.getConnection()) {
            String sql = "INSERT INTO Users (name, email) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUser(User user) {
        try (Connection conn = DbConnection.getConnection()) {
            String sql = "UPDATE Users SET name = ?, email = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setObject(3, user.getId(), java.sql.Types.OTHER);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(Integer id) {
        try (Connection conn = DbConnection.getConnection()) {
            String sql = "DELETE FROM Users WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setObject(1, id, java.sql.Types.OTHER);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}