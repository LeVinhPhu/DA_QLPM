/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.repository.impl;

import com.vpdq.pojo.Department;
import com.vpdq.pojo.OnCall;
import com.vpdq.pojo.User;
import com.vpdq.repository.OnCallRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vinhp
 */
@Repository
@Transactional
@PropertySource("classpath:messages.properties")
public class OnCallRepositoryImpl implements OnCallRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private Environment env;

    @Override
    public List<Object[]> getOnCallView(Map<String, String> params, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);   
        Root<User> aRoot = q.from(User.class);
        Root<User> eRoot = q.from(User.class);
        Root<OnCall> oclRoot = q.from(OnCall.class);
        Root<Department> dRoot = q.from(Department.class);
        
        q.where(b.equal(oclRoot.get("admin"), aRoot.get("id")),
                b.equal(oclRoot.get("employee"), eRoot.get("id")),
                b.equal(oclRoot.get("department"), dRoot.get("id")));
        q.multiselect(
                oclRoot.get("id"),
                aRoot.get("firstName"),
                aRoot.get("lastName"),
                eRoot.get("firstName"),
                eRoot.get("lastName"),
                oclRoot.get("date"),
                dRoot.get("name"));

        q.orderBy(b.desc(oclRoot.get("date")));


        Query<Object[]> query = session.createQuery(q);

        return query.getResultList();
    }

    @Override
    public List<OnCall> getOnCall(Map<String, String> params, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        Root<OnCall> Root = q.from(OnCall.class);

        Root root = q.from(OnCall.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            q.where(predicates.toArray(Predicate[]::new));
        }

        Query query = session.createQuery(q);
        if (page > 0) {
            int size = Integer.parseInt(env.getProperty("page.size").toString());
            int start = (page - 1) * size;
            query.setFirstResult(start);
            query.setMaxResults(size);

        }

        return query.getResultList();
    }

    @Override
    public boolean deleteOnCall(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        try {
            OnCall ocl = session.get(OnCall.class, id);
            session.delete(ocl);

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addOnCall(OnCall ocl) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        try {
            session.save(ocl);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public OnCall getOnCallByID(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<OnCall> query = builder.createQuery(OnCall.class);
        Root<OnCall> root = query.from(OnCall.class);
        query.select(root);
        query.where(builder.equal(root.get("id"), id));
        OnCall ocl = session.createQuery(query).uniqueResult();

        return ocl;
    }
}
