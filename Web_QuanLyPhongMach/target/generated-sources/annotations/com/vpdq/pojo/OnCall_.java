package com.vpdq.pojo;

import com.vpdq.pojo.Department;
import com.vpdq.pojo.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-10-21T07:42:53")
@StaticMetamodel(OnCall.class)
public class OnCall_ { 

    public static volatile SingularAttribute<OnCall, Date> date;
    public static volatile SingularAttribute<OnCall, String> note;
    public static volatile SingularAttribute<OnCall, Department> departmentId;
    public static volatile SingularAttribute<OnCall, User> adminId;
    public static volatile SingularAttribute<OnCall, User> employeeId;
    public static volatile SingularAttribute<OnCall, Integer> id;

}