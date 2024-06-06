package com.chirags.usermgt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.chirags.usermgt.model.UserDetails;
import com.chirags.usermgt.service.UserService;

import jakarta.servlet.http.HttpSession;


@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index() {
        return  "index";
    }

    @GetMapping("/signin")
    public String login() {
        return  "login";
    }

    @GetMapping("/register")
    public String register() {
        return  "register";
    }

    @PostMapping("/createUser")
    public String createuser(@ModelAttribute UserDetails user, HttpSession session)
    {
        //System.out.println(user);
        boolean emailExist = userService.checkEmail(user.getEmail());
        if(emailExist){
            session.setAttribute("message", "Email Id is already Exists");
        } else {
            UserDetails userDetails = userService.createUser(user);
            if(userDetails != null){
                session.setAttribute("message", "Registered successfully");
            } else {
                session.setAttribute("message", "Something goes wrong.");
            }
        }
        return "redirect:/register";
    }
    
    
}
