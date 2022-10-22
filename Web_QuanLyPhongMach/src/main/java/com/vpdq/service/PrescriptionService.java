/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.vpdq.service;

import com.vpdq.pojo.Prescription;
import java.util.List;
import java.util.Map;

/**
 *
 * @author phamt
 */
public interface PrescriptionService {
    List<Object[]> getPrescription();
    boolean addPrescription(Prescription p);
    List<Object[]> getPreByMedicalRecordID(int id);
    boolean deleteMedicineInPrescription(int id);
}
