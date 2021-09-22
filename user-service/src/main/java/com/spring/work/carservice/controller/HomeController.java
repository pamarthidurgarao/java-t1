package com.spring.work.carservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.work.carservice.service.UserService;

@Controller
public class HomeController {

    @Autowired
    private UserService service;

    @GetMapping
    public String getHome(Model model) {

	model.addAttribute("users", service.getAll());
	return "users";

    }

}
