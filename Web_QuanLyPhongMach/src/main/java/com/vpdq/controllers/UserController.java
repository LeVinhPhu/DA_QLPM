/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.controllers;

import com.vpdq.pojo.User;
import com.vpdq.service.UserService;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

    //đăng ký tài khoản
    @PostMapping("/register")
    public String registers(Model model,
            @ModelAttribute(value = "customers") @Valid User customer, BindingResult rs) {
        //lấy ngày hiện tại
        LocalDateTime localDateTime = LocalDateTime.now();
        Date day = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        Date day2 = customer.getDateOfBirth();

        String errMsg = "";
        String errMsg2 = "";
        String errMsg3 = "";

        if (rs.hasErrors()) {
            if (this.userService.checkUsernameExists(customer.getUsername()) == true) {
                errMsg2 = "Tên tài khoản đã tồn tại.";
                model.addAttribute("errMsg2", errMsg2);
            }
            if (customer.getConfirmPassword().isEmpty() == false && customer.getPassword().equals(customer.getConfirmPassword()) == false) {
                errMsg = "Mật khẩu xác nhận không chính xác.";
                model.addAttribute("errMsg", errMsg);
            }
            if (day2 != null && day.compareTo(day2) < 0) {
                errMsg3 = "Ngày sinh không hợp lệ.";
                model.addAttribute("errMsg3", errMsg3);
            }
            return "register";
        }

        if (day.compareTo(day2) < 0) {
            errMsg3 = "Ngày sinh không hợp lệ.";
            model.addAttribute("errMsg3", errMsg3);
            if (this.userService.checkUsernameExists(customer.getUsername()) == true) {
                errMsg2 = "Tên tài khoản đã tồn tại.";
                model.addAttribute("errMsg2", errMsg2);
            }
            if (customer.getPassword().equals(customer.getConfirmPassword()) == false) {
                errMsg = "Mật khẩu xác nhận không chính xác.";
                model.addAttribute("errMsg", errMsg);
            }
            return "register";
        }

        if (this.userService.checkUsernameExists(customer.getUsername()) == true) {
            errMsg2 = "Tên tài khoản đã tồn tại.";
            model.addAttribute("errMsg2", errMsg2);
            return "register";
        }
        
        if (customer.getPassword().equals(customer.getConfirmPassword())) {
            customer.setUserRole("ROLE_CUSTOMER");
            customer.setPosition("Khách hàng");
            if (this.userService.addUser(customer) == true)
            {
                return "redirect:/login";
            }
        } else {
            errMsg = "Mật khẩu xác nhận không chính xác.";
            model.addAttribute("errMsg", errMsg);
        }

        return "register";
    }
}
