/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.formatters;

import com.vpdq.pojo.Status;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author phamt
 */
public class StatusFormatter implements Formatter<Status> {
    @Override
    public String print(Status t, Locale locale) {
        return String.valueOf(t.getId());
    }

    @Override
    public Status parse(String id,
             Locale locale) throws ParseException {
        Status s = new Status();
        s.setId(Integer.parseInt(id));

        return s;
    }
}
