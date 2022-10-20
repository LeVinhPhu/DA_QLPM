/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.configs.handlers;

import com.vpdq.utils.Search;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;

/**
 *
 * @author vinhp
 */
public class LogoutHandler implements org.springframework.security.web.authentication.logout.LogoutSuccessHandler {
    
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication a) throws IOException, ServletException {
        request.getSession().removeAttribute("currentUser");
        Search.setIdCus(0);
        response.sendRedirect("/Web_QuanLyPhongMach/");
    }
    
}
