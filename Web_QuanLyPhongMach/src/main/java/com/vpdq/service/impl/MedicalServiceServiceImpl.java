/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.service.impl;

import com.vpdq.pojo.MedicalService;
import com.vpdq.repository.MedicalServiceRepository;
import com.vpdq.service.MedicalServiceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vinhp
 */
@Service
public class MedicalServiceServiceImpl implements MedicalServiceService {

    @Autowired
    private MedicalServiceRepository medicalServiceRepository;

    @Override
    public List<MedicalService> getService() {
        return this.medicalServiceRepository.getService();
    }

}
