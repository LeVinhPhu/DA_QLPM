/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.service.impl;

import com.vpdq.pojo.MedicalRecord;
import com.vpdq.repository.MedicalRecordRepository;
import com.vpdq.service.MedicalRecordService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author phamt
 */
@Service
public class MedicalRecordServiceImpl implements MedicalRecordService {
    @Autowired
    MedicalRecordRepository medicalRecordRepository;
    
    @Override
    public List<Object[]> revenueStatistics() {
        return this.medicalRecordRepository.revenueStatistics();
    }

    @Override
    public List<Object[]> revenueStatisticsByQuarter(int year) {
        return this.medicalRecordRepository.revenueStatisticsByQuarter(year);
    }

    @Override
    public List<Object[]> revenueStatisticsByMonth(int year) {
        return this.medicalRecordRepository.revenueStatisticsByMonth(year);
    }

    @Override
    public List<Object[]> totalRevenueStatistics() {
        return this.medicalRecordRepository.totalRevenueStatistics();
    }

    @Override
    public boolean addMedicalRecord(MedicalRecord m) {
        return this.medicalRecordRepository.addMedicalRecord(m);
    }

    @Override
    public List<Object[]> getMedicalRecord(String name) {
        return this.medicalRecordRepository.getMedicalRecord(name);
    }

    @Override
    public MedicalRecord getMedicalRecordByID(int id) {
        return this.medicalRecordRepository.getMedicalRecordByID(id);
    }

    @Override
    public List<Object[]> getInfoMedicalRecordByID(int id) {
        return this.medicalRecordRepository.getInfoMedicalRecordByID(id);

    }

    @Override
    public List<Object[]> getMedicalRecordForPayment() {
        return this.medicalRecordRepository.getMedicalRecordForPayment();
    }

    @Override
    public List<Object[]> getMedicalRecordForPaymentByID(int id) {
        return this.medicalRecordRepository.getMedicalRecordForPaymentByID(id);
    }

    @Override
    public boolean payment(int idM, int idNurse, Date date) {
        return this.medicalRecordRepository.payment(idM, idNurse, date);
    }
}
