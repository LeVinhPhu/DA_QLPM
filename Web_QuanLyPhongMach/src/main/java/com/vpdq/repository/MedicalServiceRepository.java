/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.vpdq.repository;

import com.vpdq.pojo.MedicalService;
import java.util.List;

/**
 *
 * @author vinhp
 */
public interface MedicalServiceRepository {
    List<MedicalService> getService();
}

