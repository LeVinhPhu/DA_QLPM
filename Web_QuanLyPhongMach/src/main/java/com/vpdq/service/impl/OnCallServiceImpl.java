/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.service.impl;

import com.vpdq.pojo.OnCall;
import com.vpdq.repository.OnCallRepository;
import com.vpdq.service.OnCallService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vinhp
 */
@Service
public class OnCallServiceImpl implements OnCallService {

    @Autowired
    private OnCallRepository onCallRepository;

    @Override
    public List<Object[]> getOnCallView(Map<String, String> params, int page) {
        return this.onCallRepository.getOnCallView(params, page);
    }

    @Override
    public List<OnCall> getOnCall(Map<String, String> params, int page) {
        return this.onCallRepository.getOnCall(params, page);
    }

    @Override
    public boolean addOnCall(OnCall ocl) {
        return this.onCallRepository.addOnCall(ocl);
    }

    @Override
    public boolean deleteOnCall(int id) {
        return this.onCallRepository.deleteOnCall(id);
    }

    @Override
    public OnCall getOnCallByID(int id) {
        return this.onCallRepository.getOnCallByID(id);
    }

}
