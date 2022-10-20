package com.vpdq.service.impl;


import com.vpdq.pojo.Department;
import com.vpdq.repository.DepartmentRepository;
import com.vpdq.service.DepartmentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author vinhp
 */
@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;
    
    @Override
    public List<Department> getDepartment() {
        return this.departmentRepository.getDepartment();
    }
    
}
