/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.configs.handlers;

import com.vpdq.pojo.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import com.vpdq.service.UserService;

/**
 *
 * @author vinhp
 */
@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private UserService userDetailsService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse respones, Authentication a) throws IOException, ServletException {

        User user = this.userDetailsService.getUserByUsername(a.getName());
        //lay user
        if (user.getUserRole().equals("ROLE_ADMIN")) {
            request.getSession().setAttribute("currentUser", user);
            respones.sendRedirect("/Web_QuanLyPhongMach/admins/adminIndex");
        }

        if (user.getUserRole().equals("ROLE_SUPERADMIN")) {
            request.getSession().setAttribute("currentUser", user);
            respones.sendRedirect("/Web_QuanLyPhongMach/admins/adminIndex");
        }

        if (user.getUserRole().equals("ROLE_DOCTOR")) {
            request.getSession().setAttribute("currentUser", user);
            respones.sendRedirect("/Web_QuanLyPhongMach/employees/doctorsIndex");
        }

        if (user.getUserRole().equals("ROLE_NURSE")) {
            request.getSession().setAttribute("currentUser", user);
            respones.sendRedirect("/Web_QuanLyPhongMach/employees/nursesIndex");
        }

        if (user.getUserRole().equals("ROLE_CUSTOMER")) {
            request.getSession().setAttribute("currentUser", user);
            respones.sendRedirect("/Web_QuanLyPhongMach/customers/customersIndex");
        }
    }
}
