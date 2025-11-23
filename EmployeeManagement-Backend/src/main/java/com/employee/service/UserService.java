package com.employee.service;

import com.employee.dao.UserDao;
import com.employee.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User addUser(User user) {
        return userDao.save(user);
    }

    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    public User login(String email, String password) {
        User exist = userDao.findByEmail(email);
        if (exist != null && exist.getPassword().equals(password)) {
            return exist;
        }
        throw new RuntimeException("Password or email is incorrect");
    }
}
