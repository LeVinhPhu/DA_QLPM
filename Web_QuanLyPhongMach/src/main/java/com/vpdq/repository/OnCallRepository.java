/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.vpdq.repository;

import com.vpdq.pojo.OnCall;
import java.util.List;
import java.util.Map;

/**
 *
 * @author vinhp
 */
public interface OnCallRepository {

    List<Object[]> getOnCallView(Map<String, String> params, int page);

    List<OnCall> getOnCall(Map<String, String> params, int page);

    public boolean addOnCall(OnCall ocl);

    public boolean deleteOnCall(int id);

    public OnCall getOnCallByID(int id);
}
