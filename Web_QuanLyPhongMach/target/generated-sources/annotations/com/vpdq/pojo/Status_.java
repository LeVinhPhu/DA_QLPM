package com.vpdq.pojo;

import com.vpdq.pojo.Appointment;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-10-20T13:48:50")
@StaticMetamodel(Status.class)
public class Status_ { 

    public static volatile SingularAttribute<Status, String> name;
    public static volatile SingularAttribute<Status, Integer> id;
    public static volatile CollectionAttribute<Status, Appointment> appointmentCollection;

}