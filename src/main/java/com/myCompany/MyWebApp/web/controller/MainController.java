package com.myCompany.MyWebApp.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @GetMapping("/")
    public ModelAndView showHomePage() {
        ModelAndView model = new ModelAndView("/index");
        model.addObject("metaTitle", "Home | My Web App");
        return model;
    }
}
