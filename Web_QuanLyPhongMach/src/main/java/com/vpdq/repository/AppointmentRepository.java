/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.vpdq.repository;

import com.vpdq.pojo.Appointment;
import java.util.List;

/**
 *
 * @author phamt
 */
public interface AppointmentRepository {
    boolean addAppointment (Appointment a);
    List<Object[]> getAppointment(float idCus);
    boolean deleteAppointment(int id);
    boolean changeStatusAppointmentByID(int id, int status);
    Appointment getAppointmentByID(int id);
    Appointment getAppointmentByIdCustomer(int idCus);
    boolean checkAppointmentExists(int idCus);
    List<Object[]> getCusFromAppointmentById(int idAp);
}
