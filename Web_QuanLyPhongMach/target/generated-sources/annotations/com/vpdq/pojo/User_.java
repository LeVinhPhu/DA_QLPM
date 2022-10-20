package com.vpdq.pojo;

import com.vpdq.pojo.Appointment;
import com.vpdq.pojo.Degree;
import com.vpdq.pojo.MedicalRecord;
import com.vpdq.pojo.OnCall;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-10-20T13:48:50")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> lastName;
    public static volatile SingularAttribute<User, String> note;
    public static volatile SingularAttribute<User, String> image;
    public static volatile SingularAttribute<User, String> address;
    public static volatile SingularAttribute<User, String> sex;
    public static volatile SingularAttribute<User, Date> dateOfBirth;
    public static volatile CollectionAttribute<User, MedicalRecord> medicalRecordCollection;
    public static volatile CollectionAttribute<User, Appointment> appointmentCollection;
    public static volatile SingularAttribute<User, String> firstName;
    public static volatile SingularAttribute<User, String> password;
    public static volatile CollectionAttribute<User, Degree> degreeCollection;
    public static volatile CollectionAttribute<User, MedicalRecord> medicalRecordCollection2;
    public static volatile SingularAttribute<User, String> phone;
    public static volatile CollectionAttribute<User, MedicalRecord> medicalRecordCollection1;
    public static volatile CollectionAttribute<User, OnCall> onCallCollection;
    public static volatile SingularAttribute<User, Integer> id;
    public static volatile CollectionAttribute<User, OnCall> onCallCollection1;
    public static volatile SingularAttribute<User, String> position;
    public static volatile SingularAttribute<User, String> userRole;
    public static volatile SingularAttribute<User, String> email;
    public static volatile SingularAttribute<User, String> specialize;
    public static volatile SingularAttribute<User, String> username;

}