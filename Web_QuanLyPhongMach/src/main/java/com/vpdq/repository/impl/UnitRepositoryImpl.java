/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.repository.impl;

import com.vpdq.pojo.Unit;
import com.vpdq.repository.UnitRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author phamt
 */
@Repository
@Transactional
public class UnitRepositoryImpl implements UnitRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Unit> getUnits() {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From Unit");
        return q.getResultList();
    }
}
