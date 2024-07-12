package com.myCompany.MyWebApp.bl.service;

import com.myCompany.MyWebApp.persistance.dao.UserDAO;
import com.myCompany.MyWebApp.persistance.entity.User;
import com.myCompany.MyWebApp.web.form.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired private UserDAO repo;

    @Override
    public List<User> listAll() {
        return (List<User>) repo.findAll();
    }

    @Override
    public void addUser(UserForm userForm) {
        User user = new User(userForm);
        this.repo.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void updateUser(UserForm userForm) {
        repo.save(new User(userForm));
    }

    @Override
    public void deleteUserById(Long id) {
        repo.deleteById(id);
    }



}
