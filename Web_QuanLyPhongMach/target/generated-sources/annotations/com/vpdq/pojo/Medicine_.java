package com.vpdq.pojo;

import com.vpdq.pojo.Prescription;
import com.vpdq.pojo.Supplier;
import com.vpdq.pojo.Unit;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-10-21T07:42:53")
@StaticMetamodel(Medicine.class)
public class Medicine_ { 

    public static volatile SingularAttribute<Medicine, Long> unitPrice;
    public static volatile SingularAttribute<Medicine, String> image;
    public static volatile SingularAttribute<Medicine, String> note;
    public static volatile SingularAttribute<Medicine, Integer> quantity;
    public static volatile SingularAttribute<Medicine, Supplier> supplierId;
    public static volatile SingularAttribute<Medicine, String> name;
    public static volatile SingularAttribute<Medicine, Unit> unitId;
    public static volatile SingularAttribute<Medicine, Integer> id;
    public static volatile CollectionAttribute<Medicine, Prescription> prescriptionCollection;

}