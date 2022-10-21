/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.service.impl;

import com.vpdq.pojo.User;
import com.vpdq.repository.UserRepository;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.vpdq.service.UserService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author vinhp
 */
@Service("UserDetailsService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //Phân quyền user
        User user = this.userRepository.getUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Không tồn tại!");
        }

        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(user.getUserRole()));
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(), authorities);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    //-----------------User-----------------
    @Override
    public boolean addUser(User user) {
        String pass = user.getPassword();
        user.setPassword(this.passwordEncoder.encode(pass));
        //cần xử lý việc lấy ảnh
        if (user.getImage() == null) {
            user.setImage("https://res.cloudinary.com/vinhphuvtv2/image/upload/v1661085367/Web_QLPM/Avatar/360_F_259394679_GGA8JJAEkukYJL9XXFH2JoC3nMguBPNH_q8wpm9.jpg");
        }
        //chuyên định dạng ngày h cho phù hợp với database
        Date temp = user.getDateOfBirth();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.format(temp);
        user.setDateOfBirth(temp);
        //
        return this.userRepository.addUser(user);
    }

    @Override
    public boolean updateUser(int id, User user) {
        //chuyên định dạng ngày h cho phù hợp với database
        Date temp = user.getDateOfBirth();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.format(temp);
        user.setDateOfBirth(temp);
        //
        return this.userRepository.updateUser(id, user);
    }

    @Override
    public boolean deleteUser(int userId) {
        return this.userRepository.deleteUser(userId);
    }

    @Override
    public User getUserByID(int userId) {
        return this.userRepository.getUserByID(userId);
    }

    @Override
    public boolean updateImageUser(int userId, String image) {
        return this.userRepository.updateImageUser(userId, image);
    }

    @Override
    public List<User> getUserByRole(Map<String, String> params, int page, String role) {
        return this.userRepository.getUserByRole(params, page, role);
    }

    @Override
    public List<User> getAllUsername() {
        return this.userRepository.getAllUsername();
    }

    @Override
    public boolean check(String phone) {
        return this.userRepository.check(phone);
    }

    @Override
    public User getUserByUsername(String username) {
        return this.userRepository.getUserByUsername(username);
    }

    //------------Chuc nang cua vai tro Admin--------------
    @Override
    public int countAdmin() {
        return this.userRepository.countAdmin();
    }

    @Override
    public List<User> getUserAdmin(Map<String, String> params, int page) {
        return this.userRepository.getUserAdmin(params, page);
    }

    //----------Chuc nang cua vai tro Employee-------------

    @Override
    public List<User> getUserEmployee(Map<String, String> params, int page) {
        return this.userRepository.getUserEmployee(params, page);
    }

    @Override
    public int countEmployee() {
        return this.userRepository.countEmployee();
    }

    //----------Chuc nang cua vai tro Customer-------------
    @Override
    public List<Object[]> patientStatistics() {
        return this.userRepository.patientStatistics();
    }

    @Override
    public List<Object[]> patientStatisticsByYear() {
        return this.userRepository.patientStatisticsByYear();
    }

    @Override
    public List<Object[]> patientStatisticsByQuater(int year) {
        return this.userRepository.patientStatisticsByQuater(year);
    }

    @Override
    public List<Object[]> patientStatisticsByMonth(int year) {
        return this.userRepository.patientStatisticsByMonth(year);
    }
}
