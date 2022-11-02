/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author vinhp
 */
@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id"),
    @NamedQuery(name = "User.findByFirstName", query = "SELECT u FROM User u WHERE u.firstName = :firstName"),
    @NamedQuery(name = "User.findByLastName", query = "SELECT u FROM User u WHERE u.lastName = :lastName"),
    @NamedQuery(name = "User.findByDateOfBirth", query = "SELECT u FROM User u WHERE u.dateOfBirth = :dateOfBirth"),
    @NamedQuery(name = "User.findBySex", query = "SELECT u FROM User u WHERE u.sex = :sex"),
    @NamedQuery(name = "User.findByPosition", query = "SELECT u FROM User u WHERE u.position = :position"),
    @NamedQuery(name = "User.findByAddress", query = "SELECT u FROM User u WHERE u.address = :address"),
    @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
    @NamedQuery(name = "User.findByPhone", query = "SELECT u FROM User u WHERE u.phone = :phone"),
    @NamedQuery(name = "User.findBySpecialize", query = "SELECT u FROM User u WHERE u.specialize = :specialize"),
    @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username"),
    @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password"),
    @NamedQuery(name = "User.findByUserRole", query = "SELECT u FROM User u WHERE u.userRole = :userRole"),
    @NamedQuery(name = "User.findByImage", query = "SELECT u FROM User u WHERE u.image = :image"),
    @NamedQuery(name = "User.findByNote", query = "SELECT u FROM User u WHERE u.note = :note")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 24, message = "{user.fn.null}")
    @Column(name = "first_name")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 24, message = "{user.ln.null}")
    @Column(name = "last_name")
    private String lastName;
    @NotNull(message = "{user.DOB.null}")
    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;
    @Size(max = 10)
    @Column(name = "sex")
    private String sex;
    @Size(max = 45)
    @Column(name = "position")
    private String position;
    @Size(max = 200)
    @Column(name = "address")
    private String address;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "email")
    private String email;
    @Pattern(regexp = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message = "{user.phones.invalid}")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(min = 1, max = 20, message = "{user.phones.null}")
    @Column(name = "phone")
    private String phone;
    @Size(max = 45)
    @Column(name = "specialize")
    private String specialize;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45, message = "{user.username.null}")
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    //@NotNull
    @Size(min = 1, max = 100, message = "{user.password.null}")
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    //@NotNull
    @Size(min = 1, max = 45)
    @Column(name = "user_role")
    private String userRole;
    @Size(max = 300)
    @Column(name = "image")
    private String image;
    @Size(max = 200)
    @Column(name = "note")
    private String note;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerId")
    @JsonIgnore //
    private Collection<MedicalRecord> medicalRecordCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "doctorId")
    @JsonIgnore //
    private Collection<MedicalRecord> medicalRecordCollection1;
    @OneToMany(mappedBy = "nurseId")
    @JsonIgnore //
    private Collection<MedicalRecord> medicalRecordCollection2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    @JsonIgnore //
    private Collection<Degree> degreeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerId")
    @JsonIgnore //
    private Collection<Appointment> appointmentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adminId")
    @JsonIgnore //
    private Collection<OnCall> onCallCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    @JsonIgnore //
    private Collection<OnCall> onCallCollection1;

    // Biến lưu file hình ảnh
    @Transient // Thông báo biến ko liên quan đến csdl
    private MultipartFile file;

    // Biến lưu xác nhận mật khẩu
    @Transient // Thông báo biến ko liên quan đến csdl
    //@NotNull
    @Size(min = 1, max = 100, message = "{user.confirmpassword.null}")
    private String confirmPassword;

    // Biến lưu xác nhận mật khẩu
    @Transient // Thông báo biến ko liên quan đến csdl
    //@NotNull
    @Size(min = 1, max = 100, message = "{user.oldPassword.null}")
    private String oldPassword;
    
    @Transient 
    @Size(min = 1, max = 100, message = "{user.newPassword.null}")
    private String newPassword;
    
    @Transient 
    @Size(min = 1, max = 100, message = "{user.confirmNewPassword.null}")
    private String confirmNewPassword;
    

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(Integer id, String firstName, String lastName, String username, String password, String userRole) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.userRole = userRole;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSpecialize() {
        return specialize;
    }

    public void setSpecialize(String specialize) {
        this.specialize = specialize;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @XmlTransient
    public Collection<MedicalRecord> getMedicalRecordCollection() {
        return medicalRecordCollection;
    }

    public void setMedicalRecordCollection(Collection<MedicalRecord> medicalRecordCollection) {
        this.medicalRecordCollection = medicalRecordCollection;
    }

    @XmlTransient
    public Collection<MedicalRecord> getMedicalRecordCollection1() {
        return medicalRecordCollection1;
    }

    public void setMedicalRecordCollection1(Collection<MedicalRecord> medicalRecordCollection1) {
        this.medicalRecordCollection1 = medicalRecordCollection1;
    }

    @XmlTransient
    public Collection<MedicalRecord> getMedicalRecordCollection2() {
        return medicalRecordCollection2;
    }

    public void setMedicalRecordCollection2(Collection<MedicalRecord> medicalRecordCollection2) {
        this.medicalRecordCollection2 = medicalRecordCollection2;
    }

    @XmlTransient
    public Collection<Degree> getDegreeCollection() {
        return degreeCollection;
    }

    public void setDegreeCollection(Collection<Degree> degreeCollection) {
        this.degreeCollection = degreeCollection;
    }

    @XmlTransient
    public Collection<Appointment> getAppointmentCollection() {
        return appointmentCollection;
    }

    public void setAppointmentCollection(Collection<Appointment> appointmentCollection) {
        this.appointmentCollection = appointmentCollection;
    }

    @XmlTransient
    public Collection<OnCall> getOnCallCollection() {
        return onCallCollection;
    }

    public void setOnCallCollection(Collection<OnCall> onCallCollection) {
        this.onCallCollection = onCallCollection;
    }

    @XmlTransient
    public Collection<OnCall> getOnCallCollection1() {
        return onCallCollection1;
    }

    public void setOnCallCollection1(Collection<OnCall> onCallCollection1) {
        this.onCallCollection1 = onCallCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vpdq.pojo.User[ id=" + id + " ]";
    }

    /**
     * @return the file
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(MultipartFile file) {
        this.file = file;
    }

    /**
     * @return the confirmPassword
     */
    public String getConfirmPassword() {
        return confirmPassword;
    }

    /**
     * @param confirmPassword the confirmPassword to set
     */
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    /**
     * @return the oldPassword
     */
    public String getOldPassword() {
        return oldPassword;
    }

    /**
     * @param oldPassword the oldPassword to set
     */
    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    /**
     * @return the newPassword
     */
    public String getNewPassword() {
        return newPassword;
    }

    /**
     * @param newPassword the newPassword to set
     */
    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    /**
     * @return the confirmNewPassword
     */
    public String getConfirmNewPassword() {
        return confirmNewPassword;
    }

    /**
     * @param confirmNewPassword the confirmNewPassword to set
     */
    public void setConfirmNewPassword(String confirmNewPassword) {
        this.confirmNewPassword = confirmNewPassword;
    }

}
