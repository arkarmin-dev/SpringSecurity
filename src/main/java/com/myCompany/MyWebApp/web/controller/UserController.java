package com.myCompany.MyWebApp.web.controller;

import com.myCompany.MyWebApp.bl.service.UserService;
import com.myCompany.MyWebApp.persistance.entity.User;
import com.myCompany.MyWebApp.web.form.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/users")
@Controller
public class UserController {
    @Autowired private UserService service;

    //READ
    @GetMapping("/list")
    public String showUserList(Model model) {
        List<User> listUsers = service.listAll();
        model.addAttribute("listUsers", listUsers);
        model.addAttribute("metaTitle", "Users List | My Web App");
        return "users/list";
    }



    //CREATE
    @GetMapping("/add")
    public String showNewForm(Model model) {
        model.addAttribute("UserForm", new UserForm());
        model.addAttribute("metaTitle", "Add User | My Web App");
        return "users/addForm";
    }

    @PostMapping("addSuccess")
    public String addUser(UserForm userForm) {
        service.addUser(userForm);
        return "redirect:/users/list";
    }

    //UPDATE
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        User user = service.getUserById(id);
        model.addAttribute("userForm", user);
        model.addAttribute("metaTitle", "Edit User | My Web App");
        return "users/editForm";
    }

    @PostMapping("/update")
    public String editUser(@ModelAttribute("userForm") UserForm userForm) {
        service.updateUser(userForm);
        return "redirect:/users/list";
    }

    //DELETE
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        service.deleteUserById(id);
        return "redirect:/users/list";
    }
}
