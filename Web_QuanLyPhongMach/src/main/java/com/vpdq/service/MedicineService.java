/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.vpdq.service;

import com.vpdq.pojo.Medicine;
import java.util.List;
import java.util.Map;

/**
 *
 * @author phamt
 */

public interface MedicineService {
    List<Object[]> getMedicines(Map<String, String> params, int page);
    List<Medicine> getMedicines2(Map<String, String> params, int page);
    boolean deleteMedicine(int id);
    boolean addMedicine(Medicine m);
    Medicine getMedicineByID(int id);
    boolean updateMedicineByID(int id, Medicine medicine);
    List<Object[]> frequencyOfMedicineUsageStatisticsByYear(int year);
    List<Object[]> frequencyOfMedicineUsageStatisticsByQuarter(int year, int quarter);
    List<Object[]> frequencyOfMedicineUsageStatisticsByMonth(int year, int month);
    List<Object[]> getMedicinesByKeyword(String kw); 
}
