package com.spring.work.mvc.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String display(Model model) {
	model.addAttribute("message", "Vikas");
	return "index";
    }

    @RequestMapping("/login")
    public String login(@ModelAttribute("loginData") Login loginData, Model model) {
	model.addAttribute("message", "Vikas");
	model.addAttribute("users", new ArrayList());
	return "home";
    }
}
