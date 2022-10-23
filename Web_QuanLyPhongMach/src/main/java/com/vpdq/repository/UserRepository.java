/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.vpdq.repository;

import com.vpdq.pojo.User;
import java.util.List;
import java.util.Map;

/**
 *
 * @author vinhp
 */
public interface UserRepository {

    //User
    boolean addUser(User user);

    boolean updateUser(int id, User user);

    boolean deleteUser(int userId);

    User getUserByID(int userId);

    boolean updateImageUser(int userId, String image);

    List<User> getUserByRole(Map<String, String> params, int page, String role);
    
    List<User> getAllUsername();
    
    User getUserByUsername(String username);
    
    List<User> getUserEmployee(Map<String, String> params, int page);
    
    List<User> getUserAdmin(Map<String, String> params, int page);
    //------------Chuc nang cua vai tro Admin--------------

    int countAdmin();

    //----------Chuc nang cua vai tro Employee-------------

    int countEmployee();

    //----------Chuc nang cua vai tro Customer-------------

    List<Object[]> patientStatistics();

    List<Object[]> patientStatisticsByYear();

    List<Object[]> patientStatisticsByQuater(int year);

    List<Object[]> patientStatisticsByMonth(int year);
    
    boolean checkUsernameExists(String u);
}
