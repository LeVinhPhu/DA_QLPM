/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.vpdq.configs.handlers.LoginSuccessHandler;
import com.vpdq.configs.handlers.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

/**
 *
 * @author phamt
 */
@Configuration//bien thanh ro
@EnableTransactionManagement
@EnableWebSecurity
@ComponentScan(basePackages = {
    "com.vpdq.controllers",
    "com.vpdq.repository",
    "com.vpdq.service",})
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationSuccessHandler loginSuccessHandler;

    @Autowired
    private LogoutSuccessHandler logoutHandler;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationSuccessHandler loginSucceccHandler() {
        return new LoginSuccessHandler();
    }

    @Bean
    public LogoutSuccessHandler logoutHandler() {
        return new LogoutHandler();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().usernameParameter("username").passwordParameter("password")
                .loginPage("/login");
        http.formLogin().failureUrl("/login?erorr"); // defaultSuccessUrl("/") cần thay thế hàm có giá trí phân quyền
        http.formLogin().successHandler(this.loginSuccessHandler);
//        http.logout().logoutSuccessUrl("/");
        http.logout().logoutSuccessHandler(this.logoutHandler);
        http.exceptionHandling()
                .accessDeniedPage("/?accessDenied");

        http.authorizeRequests().antMatchers("/").permitAll();
        http.authorizeRequests().antMatchers("/admins/**").access("hasRole('ROLE_ADMIN')or hasRole('ROLE_SUPERADMIN')");
        http.authorizeRequests().antMatchers("/employees/nursesIndex").access("hasRole('ROLE_NURSE')");
        http.authorizeRequests().antMatchers("/employees/billsManager").access("hasRole('ROLE_NURSE')");
        http.authorizeRequests().antMatchers("/employees/appointmentsManager").access("hasRole('ROLE_NURSE')");
        http.authorizeRequests().antMatchers("/employees/doctorsIndex").access("hasRole('ROLE_DOCTOR')");
        http.authorizeRequests().antMatchers("/employees/medicalRecord").access("hasRole('ROLE_DOCTOR')");
        http.authorizeRequests().antMatchers("/employees/prescription").access("hasRole('ROLE_DOCTOR')");
        http.authorizeRequests().antMatchers("/customers/**").access("hasRole('ROLE_CUSTOMER')");

        http.csrf().disable();
    }
}
