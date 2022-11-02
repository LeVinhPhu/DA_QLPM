/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.controllers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.vpdq.pojo.Appointment;
import com.vpdq.pojo.User;
import com.vpdq.service.AppointmentService;
import com.vpdq.service.UserService;
import com.vpdq.utils.Search;
import java.io.IOException;
import java.util.Map;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author vinhp
 */
@Controller
@RequestMapping("/customers")
@ControllerAdvice //dung trong khai bao thuoc tinh dung chung
public class CustomerController {

    @Bean
    public Cloudinary cloudinary2() {
        Cloudinary cloudinary
                = new Cloudinary(ObjectUtils.asMap(
                        "cloud_name", "vinhphuvtv2",
                        "api_key", "335115886111226",
                        "api_secret", "Y4A5vCe_8f-liruLKg5FRmjl9tw",
                        "secure", true));
        return cloudinary;
    }

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private UserService userService;

    @Autowired
    private Cloudinary cloudinary;

    @GetMapping("/customersIndex")
    public String index() {
        return "customersIndex";
    }

    @GetMapping("/appointments")
    public String showAppointments(Model model, HttpSession session) {
        model.addAttribute("setAppointments", new Appointment());
        model.addAttribute("currentUser", session.getAttribute("currentUser"));

        User c1 = (User) session.getAttribute("currentUser");
        int check = 1;
        if (this.appointmentService.checkAppointmentExists(c1.getId()) == false) {
            check = 0;
        }
        if (this.appointmentService.checkAppointmentExists(c1.getId()) == true) {
            check = 1;
        }

        model.addAttribute("check", check);

        User cs = (User) session.getAttribute("currentUser");
        Search.setIdCus(cs.getId());
        return "appointments";
    }

    //Đặt lịch khám
    @PostMapping("/appointments")
    public String addAppointments(Model model, HttpSession session,
            @ModelAttribute(value = "setAppointments") Appointment a) {
        User c = (User) session.getAttribute("currentUser");

        a.setCustomerId(c);

        if (this.appointmentService.addAppointment(a)) {
            return "redirect:appointments";
        }
        return "redirect:appointments";
    }

    //
    @GetMapping("/customersProfile")
    public String customersProfile(Model model, HttpSession session) {
        model.addAttribute("updateProfileCustomer", session.getAttribute("currentUser"));;
        return "customersProfile";
    }

    //Trang cá nhân Customer
    @PostMapping("/customersProfile")
    public String updateProfileCustomer(HttpSession session,
            @ModelAttribute(value = "updateProfileCustomer") @Valid User c,
            BindingResult rs) throws IOException {

        if (c.getFile().isEmpty() == false) {
            try {
                Map r = this.cloudinary.uploader().upload(c.getFile().getBytes(),
                        ObjectUtils.asMap("resource_type", "auto"));
                String img = (String) r.get("secure_url");
                c.setImage(img);
            } catch (IOException ex) {
                System.err.println("UPDATE ADMIN " + ex.getMessage());
            }
        }

        if (c.getNote().isEmpty()) {
            c.setNote(null);
        }

        if (rs.hasErrors()) {
            return "customersProfile";
            //return lổi
        }

        User ct = (User) session.getAttribute("currentUser");
        c.setUserRole("ROLE_CUSTOMER");
        c.setPosition("Khách hàng");
        if (this.userService.updateUser(ct.getId(), c) == true) {
            return "customersIndex"; //return về trang gì đó
        }
        return "customersProfile";
    }

    //
    @GetMapping("/changePasswordCustomer")
    public String changePasswordCustomer(Model model) {
        model.addAttribute("changePasswordCustomer", new User());
        return "changePasswordCustomer";
    }

    @PostMapping("/changePasswordCustomer")
    public String changePasswordCustomer(HttpSession session,
            @ModelAttribute(value = "changePasswordCustomer") @Valid User c,
            BindingResult rs) throws IOException {

        if (c.getNote().isEmpty()) {
            c.setNote(null);
        }

        if (rs.hasErrors()) {
            return "customersProfile";
            //return lổi
        }

        User ct = (User) session.getAttribute("currentUser");
        if (c.getPassword().equals(c.getConfirmPassword())) {
            if (this.userService.updatePasswordUser(ct.getId(), c) == true) {
                return "customersIndex";
            }
        }
        return "customersProfile";
    }

}
