/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.controllers;

import com.vpdq.pojo.User;
import com.vpdq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author phamt
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/register")
    public String registerView(Model model) {
        model.addAttribute("customers", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registers(Model model,
            @ModelAttribute(value = "customers") User customer) {
        String errMsg = "";
        if (customer.getPassword().equals(customer.getConfirmPassword())) {
            if (this.userService.addUser(customer) == true) {
                return "redirect:/login";
            } else {
                errMsg = "Đã có lỗi xảy ra!";
            }
        } else {
            errMsg = "TON TAI!";
        }

        model.addAttribute("errMsg", errMsg);
        return "register";
    }

}
