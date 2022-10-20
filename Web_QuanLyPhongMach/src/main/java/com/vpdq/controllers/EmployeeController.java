/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.controllers;

import com.vpdq.mail.Mail;
import com.vpdq.pojo.Appointment;
import com.vpdq.pojo.MedicalRecord;
import com.vpdq.pojo.Prescription;
import com.vpdq.pojo.User;
import com.vpdq.service.AppointmentService;
import com.vpdq.service.MedicalRecordService;
import com.vpdq.service.MedicalServiceService;
import com.vpdq.service.MedicineService;
import com.vpdq.service.PrescriptionService;
import com.vpdq.service.UserService;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author vinhp
 */

@Controller
@ControllerAdvice
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired 
    private UserService userService;

    @Autowired 
    private MedicalServiceService medicalServiceService;

    @Autowired
    private MedicalRecordService medicalRecordService;
    
    @Autowired
    private AppointmentService appointmentService;
    
    @Autowired
    private PrescriptionService prescriptionService;
    
    @Autowired
    private MedicineService medicineService;
    
    //dung chung
    @ModelAttribute
    public void commonAttribute(Model model) {
        model.addAttribute("services", this.medicalServiceService.getService());
        model.addAttribute("appointments", this.appointmentService.getAppointment(0));
        model.addAttribute("medicine", this.medicineService.getMedicines(null, 0));
    }
    
    //Bác sĩ quản lý
    
    @GetMapping("/doctorsIndex")
    public String doctorsIndex (){
        return "doctorsIndex";
    }
    
    @GetMapping("/doctorsProfile")
    public String doctorsProfile (){
        return "doctorsProfile";
    }
    
    
    @GetMapping("/medicalRecord/{cusID}")
    public String medicalRecord(Model model, @PathVariable(value = "cusID") int cusID) {

        model.addAttribute("medicalRecord", new MedicalRecord());
        return "medicalRecord";
    }

//    Tạo phiếu khám
    @PostMapping("/medicalRecord/{cusID}")
    public String addMedicalRecord(Model model, HttpSession session,
            @PathVariable(value = "cusID") int cusID,
            @ModelAttribute(value = "medicalRecord") @Valid MedicalRecord m,
            BindingResult rs) {

        model.addAttribute("cusID", cusID);
        User employee = (User) session.getAttribute("currentUser");

        m.setDoctorId(employee);
        User customer = new User();
        customer.setId(cusID);
        m.setCustomerId(customer);

        if (rs.hasErrors())
        {
            return "medicalRecord";
        }

        if (this.medicalRecordService.addMedicalRecord(m) == true)
        {
            Appointment a1 = this.appointmentService.getAppointmentByIdCustomer(cusID);
            
            if (this.appointmentService.changeStatusAppointmentByID(a1.getId(), 3))
            return "redirect:/employees/prescription";
        }

        return "medicalRecord";
    }
    
    
    //Hiển thị các phiếu khám bệnh
    @GetMapping("/prescription")
    public String prescription(Model model) {
        model.addAttribute("medicalRecord2", this.medicalRecordService.getMedicalRecord("doctor"));
        return "prescription";
    }

    //lấy mã phiếu khám, qua trang kê toa thuốc
    @PostMapping("/prescription")
    public String postprescription(Model model) {
        return "prescription";
    }
    
    
    //KÊ TOA THUỐC
    @GetMapping("/prescription/{medicalRecordID}")
    public String prescriptions(Model model,
            @PathVariable(value = "medicalRecordID") int medicalRecordID,
            @RequestParam(value = "kw", defaultValue = "", required = false) String kw,
            @RequestParam Map<String, String> params) {
         
        model.addAttribute("medicines", this.medicineService.getMedicinesByKeyword(null));
        if (kw != null && !kw.isEmpty())
             model.addAttribute("medicines", this.medicineService.getMedicinesByKeyword(kw));

        model.addAttribute("prescription", new Prescription());
        model.addAttribute("medicalRecordID", medicalRecordID);
        model.addAttribute("info", this.medicalRecordService.getInfoMedicalRecordByID(medicalRecordID));
        model.addAttribute("medicineInPrescription", this.prescriptionService.getPreByMedicalRecordID(medicalRecordID));

        return "prescribeTheDrug";
    }

    //Thêm thuốc vào toa thuốc
    @PostMapping("/prescription/{medicalRecordID}")
    public String addPrescription(Model model,
            @ModelAttribute(value = "prescription") Prescription p,
            @PathVariable(value = "medicalRecordID") int medicalRecordID,
            @RequestParam(value = "addMedicine", defaultValue = "0", required = false) int addMedicine,
            @RequestParam(value = "kw", defaultValue = "", required = false) String kw,
            @RequestParam Map<String, String> params) {

        MedicalRecord m = new MedicalRecord();
        m.setId(medicalRecordID);
        p.setMedicalRecordId(m);

        if (addMedicine != 0) {
            if (this.prescriptionService.addPrescription(p) == true) {
                model.addAttribute("medicineInPrescription", this.prescriptionService.getPreByMedicalRecordID(medicalRecordID));
                model.addAttribute("medicines", this.medicineService.getMedicinesByKeyword(null));
                model.addAttribute("info", this.medicalRecordService.getInfoMedicalRecordByID(medicalRecordID));
                if (kw != null && !kw.isEmpty())
                    model.addAttribute("medicines", this.medicineService.getMedicinesByKeyword(kw));
                return "prescribeTheDrug";
                
             
            }
        }

        return "redirect:prescription";
    }
    
    //Y tá quản lý
    
    @GetMapping("/nursesIndex")
    public String nursesIndex (Model model, HttpSession session){
        model.addAttribute("currentUser",session.getAttribute("currentUser"));
        return "nursesIndex";
    }
    
    @GetMapping("/billsManager")
    public String billsManager (Model model){
        model.addAttribute("medicalRecordForNurse", this.medicalRecordService.getMedicalRecordForPayment());
        return "billsManager";
    }
    
    @GetMapping("/billsManager/{medicalRecordID}")
    public String billsManagerByID (Model model,
             @PathVariable(value = "medicalRecordID") int medicalRecordID){
        model.addAttribute("medicalPayment", this.medicalRecordService.getMedicalRecordForPaymentByID(medicalRecordID));
        model.addAttribute("medicineInPrescription", this.prescriptionService.getPreByMedicalRecordID(medicalRecordID));
        return "billsManagerForPayment";
    }
    
    @PostMapping("/billsManager/{medicalRecordID}")
    public String payment (Model model, HttpSession session,
            @PathVariable(value = "medicalRecordID") int medicalRecordID) {
        
        model.addAttribute("medicalRecordID", medicalRecordID);
        java.util.Date date = new java.util.Date();
        User e = (User) session.getAttribute("currentUser");
        
        if(this.medicalRecordService.payment(medicalRecordID, e.getId(), date)){
            model.addAttribute("medicalRecordForNurse", this.medicalRecordService.getMedicalRecordForPayment());
            return "billsManager";
        }
            
        return "billsManagerForPayment";
    }
   
    
    @GetMapping("/appointmentsManager")
    public String appointmentsManager (Model model){
        return "appointmentsManager";
    }
    
    @PostMapping("/appointmentsManager")
    public String ChangeStatusForAppointment(Model model,
            @RequestParam(value = "idAppointment") int idAppointment) throws MessagingException, UnsupportedEncodingException {

        if (this.appointmentService.changeStatusAppointmentByID(idAppointment, 2))
        { 
            Object[] ob = this.appointmentService.getCusFromAppointmentById(idAppointment).get(0);
            String contentbody = "P&QCLINIC - Đã xác nhận lịch khám của bạn"
                     + ". Xin Cảm ơn.";
            String mail = (String) ob[1];
            Mail.SendEmail(contentbody, mail);
            return "nursesIndex";
        }
        return "appointmentsManager";
    }
    
    //Trang Ca nhan Admin
    @GetMapping("/employeesProfile")
    public String employeeProfile(Model model, HttpSession session) {
        model.addAttribute("currentUser", session.getAttribute("currentUser"));
        model.addAttribute("updateProfileEmployee", new User());
        return "employeesProfile";
    }

    @PostMapping("/employeesProfile")
    public String updateProfileEmployee(HttpSession session,
            @ModelAttribute(value = "updateProfileEmployee") @Valid User e,
            BindingResult r) {
        if (r.hasErrors()) {
            return "employeesProfile";
            //return lổi
        }
        User e2 = (User) session.getAttribute("currentUser");
        if (this.userService.updateUser(e2.getId(), e) == true) {
            return "redirect:updateProfileEmployee"; //return về trang gì đó
        }
        return "updateProfileEmployee";
    }

}
