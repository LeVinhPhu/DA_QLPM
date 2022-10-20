package com.vpdq.pojo;

import com.vpdq.pojo.Medicine;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-10-20T11:20:13")
@StaticMetamodel(Unit.class)
public class Unit_ { 

    public static volatile SingularAttribute<Unit, String> name;
    public static volatile SingularAttribute<Unit, Integer> id;
    public static volatile CollectionAttribute<Unit, Medicine> medicineCollection;

}