/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.controllers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.vpdq.mail.Mail;
import com.vpdq.pojo.Department;
import com.vpdq.pojo.Medicine;
import com.vpdq.pojo.OnCall;
import com.vpdq.pojo.User;
import com.vpdq.service.DepartmentService;
import com.vpdq.service.MedicalRecordService;
import com.vpdq.service.MedicineService;
import com.vpdq.service.OnCallService;
import com.vpdq.service.SupplierService;
import com.vpdq.service.UnitService;
import com.vpdq.service.UserService;
import com.vpdq.utils.Search;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Map;
import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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
@RequestMapping("/admins")
@ControllerAdvice //dung trong khai bao thuoc tinh dung chung
public class AdminController {

    @Bean
    public Cloudinary cloudinary() {
        Cloudinary cloudinary
                = new Cloudinary(ObjectUtils.asMap(
                        "cloud_name", "vinhphuvtv2",
                        "api_key", "335115886111226",
                        "api_secret", "Y4A5vCe_8f-liruLKg5FRmjl9tw",
                        "secure", true));
        return cloudinary;
    }

    //Kết nối vs service
    @Autowired
    private MedicineService medicineService;

    @Autowired
    private UnitService unitService;

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private MedicalRecordService medicalRecordService;

    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private UserService userService;

    @Autowired
    private DepartmentService departmentService;

    //dung chung
    @ModelAttribute
    public void commonAttribute(Model model) {
        model.addAttribute("department", this.departmentService.getDepartment());
        model.addAttribute("units", this.unitService.getUnits());
        model.addAttribute("suppliers", this.supplierService.getSuppliers());
    }

    @GetMapping("/adminIndex")
    public String index() {
        return "adminIndex";
    }

    /**
     *
     * @return
     */
    //-----------ADMIN----------------------------------------------------------------------------------------------
    @GetMapping("/adminsManager")
    public String adminsMager(Model model,
            @RequestParam(value = "kw", defaultValue = "", required = false) String kw,
            @RequestParam Map<String, String> params) {
        model.addAttribute("adminUP", new User());

        return "adminsManager";
    }

    // Thêm Admin
    @PostMapping("/adminsManager")
    public String addAdmin(@ModelAttribute(value = "adminUP") @Valid User adm,
            BindingResult rs) throws IOException {

        //nếu có ảnh thì upload lên cloudinary
        if (adm.getFile().isEmpty() == false) {
            try {
                Map r = this.cloudinary.uploader().upload(adm.getFile().getBytes(),
                        ObjectUtils.asMap("resource_type", "auto"));
                String img = (String) r.get("secure_url");
                adm.setImage(img);
            } catch (IOException ex) {
                System.err.println("ADD ADMIN " + ex.getMessage());
            }
        }

        if (adm.getNote().isEmpty()) {
            adm.setNote(null);
        }

        if (rs.hasErrors()) {
            return "adminsManager"; //return lổi
        }

        adm.setPosition("Quản trị viên");
        adm.setUserRole("ROLE_ADMIN");
        if (this.userService.addUser(adm) == true) {
            return "redirect:adminsManager"; //return về trang gì đó
        }
        return "adminsManager";
    }

    //Trang sửa admin
    @GetMapping("/updateAdmin/{adminId}")
    public String getAdmin(Model model, @PathVariable(value = "adminId") int id) {
        model.addAttribute("adminUpdate", this.userService.getUserByID(id));
        return "updateAdmin";
    }

    // Sửa Admin
    @PostMapping("/updateAdmin/{adminId}")
    public String updateAdmin(@PathVariable(value = "adminId") int id,
            @ModelAttribute(value = "adminUpdate") @Valid User adm,
            BindingResult rs) throws IOException {

        if (adm.getFile().isEmpty() == false) {
            try {
                Map r = this.cloudinary.uploader().upload(adm.getFile().getBytes(),
                        ObjectUtils.asMap("resource_type", "auto"));
                String img = (String) r.get("secure_url");
                adm.setImage(img);
            } catch (IOException ex) {
                System.err.println("UPDATE ADMIN " + ex.getMessage());
            }
        }

        if (rs.hasErrors()) {
            return "adminsManager"; //return lổi
        }

        if (adm.getNote().isEmpty()) {
            adm.setNote(null);
        }

        if (this.userService.updateUser(id, adm) == true) {
            return "redirect:/admins/adminsManager";
        }
        return "adminsManager";
    }

    //------------EMPLOYEE----------------------------------------------------------------------------------
    @GetMapping("/employeesManager")
    public String employeesManager(Model model,
            @RequestParam(value = "kw", defaultValue = "", required = false) String kw,
            @RequestParam Map<String, String> params) {
        model.addAttribute("employeeUp", new User());
        return "employeesManager";
    }

    //Thêm Nhân Viên
    @PostMapping("/employeesManager")
    public String addEmployee(@ModelAttribute(value = "employeeUp")
            @Valid User empl,
            BindingResult rs) throws IOException {
        //nếu có ảnh thì upload lên cloudinary
        if (empl.getFile().isEmpty() == false) {
            try {
                Map r = this.cloudinary.uploader().upload(empl.getFile().getBytes(),
                        ObjectUtils.asMap("resource_type", "auto"));
                String img = (String) r.get("secure_url");
                empl.setImage(img);
            } catch (IOException ex) {
                System.err.println("ADD EMPLOYEE " + ex.getMessage());
            }
        }

        if (empl.getNote().isEmpty()) {
            empl.setNote(null);
        }

        if (rs.hasErrors()) {
            return "employeesManager"; //return lỗi
        }

        if (empl.getUserRole().equals("ROLE_DOCTOR")) {
            empl.setPosition("Bác sĩ");
        }

        if (empl.getUserRole().equals("ROLE_NURSE")) {
            empl.setPosition("Y tá");
        }

        if (this.userService.addUser(empl) == true) {
            return "redirect:employeesManager"; //return về trang gì đó
        }
        return "employeesManager";
    }

    //Trang sửa Nhân Viên
    @GetMapping("/updateEmployee/{employeeId}")
    public String getEmployee(Model model, @PathVariable(value = "employeeId") int id) {
        model.addAttribute("employeeUpdate", this.userService.getUserByID(id));
        return "updateEmployee";
    }

    //Sửa Nhân Viên
    @PostMapping("/updateEmployee/{employeeId}")
    public String updateEmployee(@PathVariable(value = "employeeId") int id,
            @ModelAttribute(value = "employeeUpdate") @Valid User empl,
            BindingResult rs) throws IOException {

        if (empl.getFile().isEmpty() == false) {
            try {
                Map r = this.cloudinary.uploader().upload(empl.getFile().getBytes(),
                        ObjectUtils.asMap("resource_type", "auto"));
                String img = (String) r.get("secure_url");
                empl.setImage(img);
            } catch (IOException ex) {
                System.err.println("UPDATE EMPLOYEE " + ex.getMessage());
            }
        }

        if (rs.hasErrors()) {
            return "employeesManager"; //return lổi
        }

        if (empl.getNote().isEmpty()) {
            empl.setNote(null);
        }

        if (this.userService.updateUser(id, empl) == true) {
            return "redirect:/admins/employeesManager";
        }
        return "employeesManager";
    }

    //---------CUSTOMER-------------------------------------------------------------------------------
    @GetMapping("/customersManager")
    public String customersManager(Model model
    ) {
        return "customersManager";
    }

    //Thống kê doanh thu
    @RequestMapping("/reportsManager")
    public String reportsManager(Model model,
            @RequestParam(value = "year", defaultValue = "2022", required = false) int year,
            @RequestParam(value = "year2", defaultValue = "2022", required = false) int year2
    ) {
        model.addAttribute("total", this.medicalRecordService.totalRevenueStatistics());
        model.addAttribute("revenueStats", this.medicalRecordService.revenueStatistics());
        model.addAttribute("revenueStatsByQuarter", this.medicalRecordService.revenueStatisticsByQuarter(year));
        model.addAttribute("revenueStatsByMonth", this.medicalRecordService.revenueStatisticsByMonth(year2));
        model.addAttribute("year", year);
        model.addAttribute("year2", year2);

        String err1 = "";
        String err2 = "";

        //lấy năm hiện tại
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        int yearNow = zonedDateTime.getYear();

        if (year < 1970 || year > yearNow) {
            err1 = "Năm không hợp lệ! Vui lòng thử lại.";
        }
        model.addAttribute("err1", err1);

        if (year2 < 1970 || year2 > yearNow) {
            err2 = "Năm không hợp lệ! Vui lòng thử lại.";
        }
        model.addAttribute("err2", err2);

        return "reportsManager";
    }

    //------------REPORT------------------------------------------------------------------------------------------
    //Thống kê số lượng bệnh nhân
    @RequestMapping("/reports2Manager")
    public String reports2Manager(Model model,
            @RequestParam(value = "year1", defaultValue = "2022", required = false) int year1,
            @RequestParam(value = "year2", defaultValue = "2022", required = false) int year2
    ) {
        model.addAttribute("patientStats", this.userService.patientStatistics());
        model.addAttribute("patientStatsByYear", this.userService.patientStatisticsByYear());
        model.addAttribute("patientStatsByQuarter", this.userService.patientStatisticsByQuater(year1));
        model.addAttribute("patientStatsByMonth", this.userService.patientStatisticsByMonth(year2));
        model.addAttribute("year1", year1);
        model.addAttribute("year2", year2);

        String err1 = "";
        String err2 = "";

        //lấy năm hiện tại
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        int yearNow = zonedDateTime.getYear();

        if (year1 < 1970 || year1 > yearNow) {
            err1 = "Năm không hợp lệ! Vui lòng thử lại.";
        }
        model.addAttribute("err1", err1);

        if (year2 < 1970 || year2 > yearNow) {
            err2 = "Năm không hợp lệ! Vui lòng thử lại.";
        }
        model.addAttribute("err2", err2);

        return "reports2Manager";
    }

    //Thống kê tần suất sử dụng thuốc
    @RequestMapping("/reports3Manager")
    public String reports3Manager(Model model,
            @RequestParam(value = "year1", defaultValue = "2022", required = false) int year1,
            @RequestParam(value = "year2", defaultValue = "2022", required = false) int year2,
            @RequestParam(value = "year3", defaultValue = "2022", required = false) int year3,
            @RequestParam(value = "quarter2", defaultValue = "1", required = false) int quarter2,
            @RequestParam(value = "month3", defaultValue = "1", required = false) int month3) {
        model.addAttribute("frequencyMedicineUsageStatsByYear", this.medicineService.frequencyOfMedicineUsageStatisticsByYear(year1));
        model.addAttribute("year1", year1);

        model.addAttribute("frequencyMedicineUsageStatsByQuarter", this.medicineService.frequencyOfMedicineUsageStatisticsByQuarter(year2, quarter2));
        model.addAttribute("year2", year2);
        model.addAttribute("quarter2", quarter2);

        model.addAttribute("frequencyMedicineUsageStatsByMonth", this.medicineService.frequencyOfMedicineUsageStatisticsByMonth(year3, month3));
        model.addAttribute("year3", year3);
        model.addAttribute("month3", month3);

        String err1 = "";
        String err2 = "";
        String err3 = "";

        //lấy năm hiện tại
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        int yearNow = zonedDateTime.getYear();

        if (year1 < 1970 || year1 > yearNow) {
            err1 = "Năm không hợp lệ! Vui lòng thử lại.";
        }
        model.addAttribute("err1", err1);

        if (year2 < 1970 || year2 > yearNow) {
            err2 = "Năm không hợp lệ! Vui lòng thử lại.";
        }
        model.addAttribute("err2", err2);

        if (year3 < 1970 || year3 > yearNow) {
            err3 = "Năm không hợp lệ! Vui lòng thử lại.";
        } else if (month3 < 1 || month3 > 12) {
            err3 = "Tháng không hợp lệ! Vui lòng thử lại.";
        }
        model.addAttribute("err3", err3);

        return "reports3Manager";
    }

//-----------THUỐC-----------------------------------------------------------------------------
    @GetMapping("/medicinesManager")
    public String listMedicine(Model model,
            @RequestParam(value = "kw", defaultValue = "", required = false) String kw,
            @RequestParam Map<String, String> params) {
        model.addAttribute("medicineUP", new Medicine());

        Search.setParam(params);
        return "medicinesManager";
    }

    //Thêm thuốc
    @PostMapping("/medicinesManager")
    public String addMedicine(@ModelAttribute(value = "medicineUP")
            @Valid Medicine m,
            BindingResult rs) throws IOException {
        //nếu có ảnh thì upload lên cloudinary
        if (m.getFile().isEmpty() == false) {
            try {
                Map r = this.cloudinary.uploader().upload(m.getFile().getBytes(),
                        ObjectUtils.asMap("resource_type", "auto"));
                String img = (String) r.get("secure_url");
                m.setImage(img);
            } catch (IOException ex) {
                System.err.println("ADD MEDICINE " + ex.getMessage());
            }
        }

        if (m.getNote().isEmpty()) {
            m.setNote(null);
        }

        if (rs.hasErrors()) {
            return "medicinesManager";
        }

        if (this.medicineService.addMedicine(m) == true) {
            return "redirect:medicinesManager";
        }

        return "medicinesManager";
    }

    @GetMapping("/medicinesManager/{mID}")
    public String getMedicine(Model model, Medicine m,
            @PathVariable(value = "mID") int id) {
        model.addAttribute("medicine1", this.medicineService.getMedicineByID(id));
        return "updateMedicine";
    }

    //Sửa thuốc
    @PostMapping("/medicinesManager/{mID}")
    public String updateMedicine(@PathVariable(value = "mID") int id,
            @ModelAttribute(value = "medicine1") @Valid Medicine m,
            BindingResult rs
    ) {
        Medicine me = this.medicineService.getMedicineByID(id);

        if (m.getFile().isEmpty() == false) {
            try {
                Map r = this.cloudinary.uploader().upload(m.getFile().getBytes(),
                        ObjectUtils.asMap("resource_type", "auto"));
                String img = (String) r.get("secure_url");
                m.setImage(img);
            } catch (IOException ex) {
                System.err.println("UPDATE MEDICINE " + ex.getMessage());
            }
        } else {
            m.setImage(me.getImage());
        }

        if (rs.hasErrors()) {
            return "updateMedicine";
        }

        if (this.medicineService.updateMedicineByID(id, m) == true) {
            return "redirect:/admins/medicinesManager";
        }
        return "updateMedicine";
    }

//---------------------LỊCH TRỰC----------------------------
    @Autowired
    private OnCallService onCallService;

    @GetMapping("/onCallManager")
    public String onCallManager(Model model) {
        model.addAttribute("onCall", new OnCall());
        return "onCallManager";
    }

    //Thêm lịch trực
    @PostMapping("/onCallManager")
    public String addOnCall(@ModelAttribute(value = "onCall") @Valid OnCall ocl,
            BindingResult r) throws MessagingException, UnsupportedEncodingException {
        if (r.hasErrors()) {
            return "onCallManager"; //return lổi
        }

        if (this.onCallService.addOnCall(ocl) == true) {
            //Lấy ngày
            Date temp = (Date) ocl.getDate();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            String date = (String) sdf.format(temp);
            //Lấy Phòng
            Department dpmt = departmentService.getDepartmentByID(ocl.getDepartmentId().getId());
            String room = dpmt.getName();
            //lấy mail nhân viên
            User empl = userService.getUserByID(ocl.getEmployeeId().getId());
            String mail = (String) empl.getEmail();
            //lấy tên nhân viên
            String nameEmpl = (String) empl.getFirstName() + " " + empl.getLastName();
            //Gửi mail
            String contentbody = "P&QCLINIC - Bạn: " + nameEmpl + " có lịch trực vào ngày: "
                    + date + " - Phòng: " + room + ". Xin Cảm ơn.";
            Mail.SendEmail(contentbody, mail);
            return "redirect:onCallManager"; //return về trang gì đó
        }
        return "onCallManager";
    }
}
