/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.vpdq.service;

import com.vpdq.pojo.MedicalRecord;
import java.util.Date;
import java.util.List;

/**
 *
 * @author phamt
 */
public interface MedicalRecordService {
    List<Object[]> totalRevenueStatistics();
    List<Object[]> revenueStatistics();
    List<Object[]> revenueStatisticsByMonth(int year);
    List<Object[]> revenueStatisticsByQuarter(int year);
    boolean addMedicalRecord (MedicalRecord m);
    List<Object[]> getMedicalRecord(String name);
    MedicalRecord getMedicalRecordByID(int id);
    List<Object[]> getInfoMedicalRecordByID(int id);

    List<Object[]> getMedicalRecordForPayment();
    List<Object[]> getMedicalRecordForPaymentByID(int id);
    boolean payment(int idM, int idNurse, Date date);

}
