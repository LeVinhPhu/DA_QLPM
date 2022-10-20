/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.service.impl;

import com.vpdq.pojo.Appointment;
import com.vpdq.repository.AppointmentRepository;
import com.vpdq.service.AppointmentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author phamt
 */
@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;
    
    @Override
    public boolean addAppointment(Appointment a) {
        return this.appointmentRepository.addAppointment(a);
    }

    @Override
    public List<Object[]> getAppointment(float idCus) {
        return this.appointmentRepository.getAppointment(idCus);
    }

    @Override
    public boolean deleteAppointment(int id) {
        return this.appointmentRepository.deleteAppointment(id);
    }

    @Override
    public boolean changeStatusAppointmentByID(int id, int status) {
        return this.appointmentRepository.changeStatusAppointmentByID(id, status);
    }

    @Override
    public Appointment getAppointmentByID(int id) {
        return this.appointmentRepository.getAppointmentByID(id);
    }

    @Override
    public Appointment getAppointmentByIdCustomer(int idCus) {
        return this.appointmentRepository.getAppointmentByIdCustomer(idCus);
    }

    @Override
    public boolean checkAppointmentExists(int idCus) {
        return this.appointmentRepository.checkAppointmentExists(idCus);
    }

    @Override
    public List<Object[]> getCusFromAppointmentById(int idAp) {
        return this.appointmentRepository.getCusFromAppointmentById(idAp);
    }
    
}
