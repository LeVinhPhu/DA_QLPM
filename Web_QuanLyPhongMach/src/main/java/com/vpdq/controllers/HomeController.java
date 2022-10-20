/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author vinhp
 */
@Controller
public class HomeController {

    // Lien ket voi Service
    @GetMapping("/")
    public String home(Model model) {
        return "login";
    }
//    
//    @PostMapping("/")
//    public String registers(Model model,
//            @RequestParam(value = "role") String role){
//        UserRole.setRole(role);
//        return "login";
//    }

    @GetMapping("/home")
    public String uѕerGuide(Model model) {
        return "home";
    }
}
