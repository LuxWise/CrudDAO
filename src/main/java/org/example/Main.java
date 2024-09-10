package org.example;



import org.example.Dao.UserDao;
import org.example.Dao.UserDaoImpl;
import org.example.Model.User;


public class Main {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();

        User newUser = new User();
        newUser.setName("John Doe");
        newUser.setEmail("john@example.com");
        userDao.insertUser(newUser);

        User user = userDao.getUserById(1);
        System.out.println("Name: " + user.getName());
        System.out.println("Email: " + user.getEmail());

    }
}