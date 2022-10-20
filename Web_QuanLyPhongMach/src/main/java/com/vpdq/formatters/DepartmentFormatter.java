/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.formatters;

import com.vpdq.pojo.Department;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author vinhp
 */
public class DepartmentFormatter implements Formatter<Department> {

    @Override
    public String print(Department t, Locale locale) {
        return String.valueOf(t.getId());
    }

    @Override
    public Department parse(String id, Locale locale) throws ParseException {
        Department d = new Department();
        d.setId(id);
        return d;
    }

}
