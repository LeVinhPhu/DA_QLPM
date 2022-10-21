package com.vpdq.pojo;

import com.vpdq.pojo.MedicalService;
import com.vpdq.pojo.Prescription;
import com.vpdq.pojo.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-10-21T07:42:53")
@StaticMetamodel(MedicalRecord.class)
public class MedicalRecord_ { 

    public static volatile SingularAttribute<MedicalRecord, String> conclusion;
    public static volatile SingularAttribute<MedicalRecord, Date> billingDate;
    public static volatile SingularAttribute<MedicalRecord, String> note;
    public static volatile SingularAttribute<MedicalRecord, String> symptom;
    public static volatile SingularAttribute<MedicalRecord, Long> total;
    public static volatile SingularAttribute<MedicalRecord, User> doctorId;
    public static volatile SingularAttribute<MedicalRecord, User> customerId;
    public static volatile SingularAttribute<MedicalRecord, User> nurseId;
    public static volatile SingularAttribute<MedicalRecord, Integer> id;
    public static volatile CollectionAttribute<MedicalRecord, Prescription> prescriptionCollection;
    public static volatile SingularAttribute<MedicalRecord, MedicalService> medicalServiceId;

}