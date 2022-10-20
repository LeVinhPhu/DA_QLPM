/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.service.impl;

import com.vpdq.pojo.Prescription;
import com.vpdq.repository.PrescriptionRepository;
import com.vpdq.service.PrescriptionService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author phamt
 */
@Service
public class PrescriptionServiceImpl implements PrescriptionService {
    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @Override
    public List<Object[]> getPrescription() {
        return this.prescriptionRepository.getPrescription();
    }       

    @Override
    public boolean addPrescription(Prescription p) {
        return this.prescriptionRepository.addPrescription(p);
    }

    @Override
    public List<Object[]> getPreByMedicalRecordID(int id) {
        return this.prescriptionRepository.getPreByMedicalRecordID(id);
    }
}
