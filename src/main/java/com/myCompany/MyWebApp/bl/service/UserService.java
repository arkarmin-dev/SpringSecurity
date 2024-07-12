package com.myCompany.MyWebApp.bl.service;


import com.myCompany.MyWebApp.persistance.entity.User;
import com.myCompany.MyWebApp.web.form.UserForm;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public List<User> listAll();
    void addUser(UserForm userForm);
    User getUserById(Long id);
    void updateUser(UserForm userForm);
    void deleteUserById(Long id);
}
