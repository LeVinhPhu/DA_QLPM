/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.controllers;

import com.vpdq.pojo.User;
import com.vpdq.service.AppointmentService;
import com.vpdq.service.MedicalRecordService;
import com.vpdq.service.MedicineService;
import com.vpdq.service.OnCallService;
import com.vpdq.service.PrescriptionService;
import com.vpdq.service.UserService;
import com.vpdq.utils.Search;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author phamt
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private MedicineService medicineService;

    @Autowired
    private UserService userService;

    @Autowired
    private PrescriptionService prescriptionService;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private MedicalRecordService medicalRecordService;

//  API-Que
    @GetMapping("/medicines")
    public ResponseEntity<List<Object[]>> listMedicine() {
        // lấy danh sách thuốc phục vụ cho admin/medicinesManager
        if (Search.getParam().isEmpty() == false) {
            return new ResponseEntity<>(this.medicineService.getMedicines(Search.getParam(), 0), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(this.medicineService.getMedicines(null, 0), HttpStatus.OK);
        }
    }

    //xoá thuốc
    @DeleteMapping("/medicines/{medicineId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMedicine(@PathVariable(value = "medicineId") int id) {
        this.medicineService.deleteMedicine(id);
    }

    @GetMapping("/prescription")
    public ResponseEntity<List<Object[]>> listPrescription() {
        return new ResponseEntity<>(this.prescriptionService.getPrescription(), HttpStatus.OK);
    }

    @GetMapping("/employeesManager")
    public ResponseEntity<List<User>> list() {
        return new ResponseEntity<>(this.userService.getUserEmployee(null, 0), HttpStatus.OK);
    }

    @DeleteMapping("/employeesManager/{employeeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable(value = "employeeId") int employeeId) {
        this.userService.deleteUser(employeeId);
    }

    @GetMapping("/adminsManager")
    public ResponseEntity<List<User>> listAdmin() {
        return new ResponseEntity<>(this.userService.getUserAdmin(null, 0), HttpStatus.OK);
    }

    @DeleteMapping("/adminsManager/{adminId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAdmin(@PathVariable(value = "adminId") int adminId) {
        this.userService.deleteUser(adminId);
    }


    //DANH SÁCH PHIẾU ĐẶT
    @GetMapping("/appointment")
    public ResponseEntity<List<Object[]>> listAppointment(HttpSession session, Model model) {
        //nếu là bệnh nhân, lấy api theo ID bệnh nhân

        if (Search.getIdCus() != 0) {
            return new ResponseEntity<>(this.appointmentService.getAppointment(Search.getIdCus()), HttpStatus.OK);
        }

        User e = (User) session.getAttribute("currentUser");

        //nếu là bác sĩ thì nạp phiếu đã xác nhận
        if (e.getUserRole().equals("ROLE_DOCTOR")) {
            return new ResponseEntity<>(this.appointmentService.getAppointment(-1), HttpStatus.OK);
        }  //nếu là y tá thì nạp phiếu có trạng thái chưa xác nhận
        if (e.getUserRole().equals("ROLE_NURSE")) {
            return new ResponseEntity<>(this.appointmentService.getAppointment(0), HttpStatus.OK);
        }

        return new ResponseEntity<>(this.appointmentService.getAppointment(0), HttpStatus.OK);
    }

    //HUỶ PHIẾU ĐẶT KHÁM
    @DeleteMapping("/appointment/{aId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAppointment(@PathVariable(value = "aId") int aId) {
        this.appointmentService.deleteAppointment(aId);
    }

    //------------------ONCALL-------------------------
    @Autowired
    private OnCallService onCallService;

    //xoá lịch trực
    @DeleteMapping("/onCallManager/{onCallId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOncall(@PathVariable(value = "onCallId") int onCallId) {
        this.onCallService.deleteOnCall(onCallId);
    }

    @GetMapping("/onCallManager")
    public ResponseEntity<List<Object[]>> listOnCall() {
        return new ResponseEntity<>(this.onCallService.getOnCallView(null, 0), HttpStatus.OK);
    }

    //MedicalRecord-------------------
    @GetMapping("/medi")
    public ResponseEntity<List<Object[]>> listMedi() {
        return new ResponseEntity<>(this.medicalRecordService.getMedicalRecordForPayment(), HttpStatus.OK);
    }

    @GetMapping("/medical")
    public ResponseEntity<List<Object[]>> medical() {
        return new ResponseEntity<>(this.medicalRecordService.getMedicalRecordForPaymentByID(43), HttpStatus.OK);
    }

    @GetMapping("/medicalRecordByIdCustomer")
    public ResponseEntity<List<Object[]>> medicalRecordByIdCustomer() {
        return new ResponseEntity<>(this.medicalRecordService.getMedicalRecordByIdCustomer(), HttpStatus.OK);
    }
    
    //xem thuốc trong toa thuốc
    @GetMapping("/medicineInPre/{medicalRecordID}")
    public ResponseEntity<List<Object[]>> medicineInPre(@PathVariable(value = "medicalRecordID") int medicalRecordID) {
        return new ResponseEntity<>(this.prescriptionService.getPreByMedicalRecordID(medicalRecordID), HttpStatus.OK);
    }
    
    //xoá thuốc trong khi kê toa
    @DeleteMapping("/medicineInPre/{medicalRecordID}/{preID}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMedicineInPre(@PathVariable(value = "preID") int preID) {
        this.prescriptionService.deleteMedicineInPrescription(preID);
    }
}
