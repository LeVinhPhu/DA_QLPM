/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.formatters;

import com.vpdq.pojo.Unit;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author phamt
 */
public class UnitFormatter implements Formatter<Unit>{

    @Override
    public String print(Unit t, Locale locale) {
        return String.valueOf(t.getId());
    }

    @Override
    public Unit parse(String uId, Locale locale) throws ParseException {
        Unit u = new Unit();
        u.setId(Integer.parseInt(uId));
        
        return u;
    }
    
}
