/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.formatters;

import com.vpdq.pojo.MedicalRecord;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author phamt
 */
public class MedicalRecordFormatter implements Formatter<MedicalRecord> {
    @Override
    public String print(MedicalRecord t, Locale locale) {
        return String.valueOf(t.getId());
    }

    @Override
    public MedicalRecord parse(String mId, Locale locale) throws ParseException {
        MedicalRecord m = new MedicalRecord();
        m.setId(Integer.parseInt(mId));
        
        return m;
    }
}
