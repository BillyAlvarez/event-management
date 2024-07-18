package com.devops.eventmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(@RequestParam(value = "error",required = false) String error,@RequestParam(value="logout",required = false) String logout, Model model , Principal principal, RedirectAttributes redirectAttributes){

        if(error != null){
            model.addAttribute("error","Invalid username or password");
        }

        if(principal != null){
           redirectAttributes.addFlashAttribute("warning","You are logged in");
           return "redirect:/index";
        }

        if(logout != null){
            model.addAttribute("success","You have logged out");
        }

        return "login";
    }
}
