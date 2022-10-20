/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.pojo;

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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author vinhp
 */
@Entity
@Table(name = "medical_record")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MedicalRecord.findAll", query = "SELECT m FROM MedicalRecord m"),
    @NamedQuery(name = "MedicalRecord.findById", query = "SELECT m FROM MedicalRecord m WHERE m.id = :id"),
    @NamedQuery(name = "MedicalRecord.findBySymptom", query = "SELECT m FROM MedicalRecord m WHERE m.symptom = :symptom"),
    @NamedQuery(name = "MedicalRecord.findByConclusion", query = "SELECT m FROM MedicalRecord m WHERE m.conclusion = :conclusion"),
    @NamedQuery(name = "MedicalRecord.findByTotal", query = "SELECT m FROM MedicalRecord m WHERE m.total = :total"),
    @NamedQuery(name = "MedicalRecord.findByBillingDate", query = "SELECT m FROM MedicalRecord m WHERE m.billingDate = :billingDate"),
    @NamedQuery(name = "MedicalRecord.findByNote", query = "SELECT m FROM MedicalRecord m WHERE m.note = :note")})
public class MedicalRecord implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "symptom")
    private String symptom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "conclusion")
    private String conclusion;
    @Column(name = "total")
    private Long total;
    @Column(name = "billing_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date billingDate;
    @Size(max = 200)
    @Column(name = "note")
    private String note;
    @JoinColumn(name = "medical_service_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private MedicalService medicalServiceId;
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User customerId;
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User doctorId;
    @JoinColumn(name = "nurse_id", referencedColumnName = "id")
    @ManyToOne
    private User nurseId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicalRecordId")
    private Collection<Prescription> prescriptionCollection;

    public MedicalRecord() {
    }

    public MedicalRecord(Integer id) {
        this.id = id;
    }

    public MedicalRecord(Integer id, String symptom, String conclusion) {
        this.id = id;
        this.symptom = symptom;
        this.conclusion = conclusion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Date getBillingDate() {
        return billingDate;
    }

    public void setBillingDate(Date billingDate) {
        this.billingDate = billingDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public MedicalService getMedicalServiceId() {
        return medicalServiceId;
    }

    public void setMedicalServiceId(MedicalService medicalServiceId) {
        this.medicalServiceId = medicalServiceId;
    }

    public User getCustomerId() {
        return customerId;
    }

    public void setCustomerId(User customerId) {
        this.customerId = customerId;
    }

    public User getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(User doctorId) {
        this.doctorId = doctorId;
    }

    public User getNurseId() {
        return nurseId;
    }

    public void setNurseId(User nurseId) {
        this.nurseId = nurseId;
    }

    @XmlTransient
    public Collection<Prescription> getPrescriptionCollection() {
        return prescriptionCollection;
    }

    public void setPrescriptionCollection(Collection<Prescription> prescriptionCollection) {
        this.prescriptionCollection = prescriptionCollection;
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
        if (!(object instanceof MedicalRecord)) {
            return false;
        }
        MedicalRecord other = (MedicalRecord) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vpdq.pojo.MedicalRecord[ id=" + id + " ]";
    }
    
}
