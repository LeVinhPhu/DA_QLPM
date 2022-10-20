package com.vpdq.pojo;

import com.vpdq.pojo.MedicalRecord;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-10-20T13:48:50")
@StaticMetamodel(MedicalService.class)
public class MedicalService_ { 

    public static volatile SingularAttribute<MedicalService, String> note;
    public static volatile SingularAttribute<MedicalService, Long> price;
    public static volatile SingularAttribute<MedicalService, String> name;
    public static volatile SingularAttribute<MedicalService, Integer> id;
    public static volatile CollectionAttribute<MedicalService, MedicalRecord> medicalRecordCollection;

}