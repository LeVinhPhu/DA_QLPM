/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.service.impl;

import com.vpdq.pojo.Medicine;
import com.vpdq.repository.MedicineRepository;
import com.vpdq.service.MedicineService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author phamt
 */
@Service
public class MedicineServiceImpl implements MedicineService {
    @Autowired 
    private MedicineRepository medicineRepository;

    @Override
    public List<Object[]> getMedicines(Map<String, String> params, int page) {
        return this.medicineRepository.getMedicines(params, page);
    }

    @Override
    public boolean deleteMedicine(int id) {
        return this.medicineRepository.deleteMedicine(id);
        
    }

    @Override
    public boolean addMedicine(Medicine m) {
        return this.medicineRepository.addMedicine(m);
    }

    @Override
    public List<Medicine> getMedicines2(Map<String, String> params, int page) {
        return this.medicineRepository.getMedicines2(params, page);
    }

    @Override
    public Medicine getMedicineByID(int id) {
        return this.medicineRepository.getMedicineByID(id);
    }

    @Override
    public boolean updateMedicineByID(int id, Medicine medicine) {
        return this.medicineRepository.updateMedicineByID(id, medicine);
    }

    @Override
    public List<Object[]> frequencyOfMedicineUsageStatisticsByYear(int year) {
        return this.medicineRepository.frequencyOfMedicineUsageStatisticsByYear(year);
    }

    @Override
    public List<Object[]> frequencyOfMedicineUsageStatisticsByQuarter(int year, int quarter) {
        return this.medicineRepository.frequencyOfMedicineUsageStatisticsByQuarter(year, quarter);
    }

    @Override
    public List<Object[]> frequencyOfMedicineUsageStatisticsByMonth(int year, int month) {
        return this.medicineRepository.frequencyOfMedicineUsageStatisticsByMonth(year, month);
    }

    @Override
    public List<Object[]> getMedicinesByKeyword(String kw) {
        return this.medicineRepository.getMedicinesByKeyword(kw);
    }
    
}
