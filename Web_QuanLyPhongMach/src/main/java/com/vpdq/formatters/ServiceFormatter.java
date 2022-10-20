/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.formatters;

import com.vpdq.pojo.MedicalService;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author phamt
 */
public class ServiceFormatter implements Formatter<MedicalService> {
    @Override
    public String print(MedicalService t, Locale locale) {
        return String.valueOf(t.getId());
    }

    @Override
    public MedicalService parse(String sId, Locale locale) throws ParseException {
        MedicalService s = new MedicalService();
        s.setId(Integer.parseInt(sId));
        
        return s;
    }
}
