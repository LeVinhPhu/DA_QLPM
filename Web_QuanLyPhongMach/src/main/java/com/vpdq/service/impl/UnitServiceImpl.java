/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.service.impl;

import com.vpdq.pojo.Unit;
import com.vpdq.repository.UnitRepository;
import com.vpdq.service.UnitService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author phamt
 */
@Service
public class UnitServiceImpl implements UnitService {
    @Autowired
    private UnitRepository unitRepository;

    @Override
    public List<Unit> getUnits() {
        return this.unitRepository.getUnits();
    }

//    @Override
//    public String getUnitById(Unit unit) {
//        return this.unitRepository.getUnitById(unit);
//    }
    
    

}
