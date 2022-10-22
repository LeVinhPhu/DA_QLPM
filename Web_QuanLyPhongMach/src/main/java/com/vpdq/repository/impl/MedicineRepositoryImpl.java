/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.repository.impl;

import com.vpdq.pojo.MedicalRecord;
import com.vpdq.pojo.Medicine;
import com.vpdq.pojo.Prescription;
import com.vpdq.pojo.Supplier;
import com.vpdq.pojo.Unit;
import com.vpdq.repository.MedicineRepository;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import javax.persistence.criteria.Root;
import org.hibernate.query.Query;
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
@PropertySource("classpath:messages.properties")
@Transactional
public class MedicineRepositoryImpl implements MedicineRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private Environment env;

    @Override
    public List<Object[]> getMedicines(Map<String, String> params, int page) {
        //sử dụng api để lấy thuốc
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        Root<Medicine> mRoot = q.from(Medicine.class);
        Root<Unit> uRoot = q.from(Unit.class);
        Root<Supplier> sRoot = q.from(Supplier.class);
        
        q.where(b.equal(mRoot.get("unitId"), uRoot.get("id")),
                b.equal(mRoot.get("supplierId"), sRoot.get("id")));

        q.multiselect(mRoot.get("id"),
                mRoot.get("name"),
                mRoot.get("quantity"),
                mRoot.get("unitPrice"),
                uRoot.get("name"),
                mRoot.get("image"),
                mRoot.get("note"),
                sRoot.get("companyName"));

        //sap xep thuoc theo ten
        q.orderBy(b.asc(mRoot.get("name")));

        if (params != null) {
            String kw = params.get("kw");
            
            if (kw != null && !kw.isEmpty()) {
                Predicate p = b.like(mRoot.get("name").as(String.class), String.format("%%%s%%", kw));
                Predicate p2 = b.equal(mRoot.get("unitId"), uRoot.get("id"));
                q = q.where(b.and(p, p2));
            }   
        }

        Query<Object[]> query = session.createQuery(q);

        return query.getResultList();
    }

    @Override
    public boolean deleteMedicine(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        try {
            Medicine m = session.get(Medicine.class, id);
            session.delete(m);

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addMedicine(Medicine m) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        try {
            session.save(m);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Medicine> getMedicines2(Map<String, String> params, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Medicine> q = b.createQuery(Medicine.class);
        Root root = q.from(Medicine.class);
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
    public Medicine getMedicineByID(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<Medicine> query = builder.createQuery(Medicine.class);
        Root<Medicine> root = query.from(Medicine.class);
        query.select(root);
        query.where(builder.equal(root.get("id"), id));
        Medicine m = session.createQuery(query).uniqueResult();

        return m;
    }

    @Override
    public boolean updateMedicineByID(int id, Medicine medicine) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Medicine m = getMedicineByID(id);

        m.setName(medicine.getName());
        m.setQuantity(medicine.getQuantity());
        m.setUnitPrice(medicine.getUnitPrice());
        m.setUnitId(medicine.getUnitId());
        m.setSupplierId(medicine.getSupplierId());
        m.setNote(medicine.getNote());
        m.setImage(medicine.getImage());

        try {
            session.saveOrUpdate(m);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Object[]> frequencyOfMedicineUsageStatisticsByYear(int year) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root mRoot = q.from(MedicalRecord.class);
        Root pRoot = q.from(Prescription.class);
        Root medicineRoot = q.from(Medicine.class);

        q.where(b.equal(pRoot.get("medicalRecordId"), mRoot.get("id")),
                b.equal(pRoot.get("medicineId"), medicineRoot.get("id")),
                b.equal(pRoot.get("medicineId"), medicineRoot.get("id")),
                b.equal(b.function("YEAR", Integer.class, mRoot.get("billingDate")), year));

        q.multiselect(medicineRoot.get("name"),
                b.count(pRoot.get("medicineId")));

        q.groupBy(pRoot.get("medicineId"));
        q.orderBy(b.asc(medicineRoot.get("name")));

        Query query = session.createQuery(q);

        return query.getResultList();
    }

    @Override
    public List<Object[]> frequencyOfMedicineUsageStatisticsByQuarter(int year, int quarter) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root mRoot = q.from(MedicalRecord.class);
        Root pRoot = q.from(Prescription.class);
        Root medicineRoot = q.from(Medicine.class);

        q.where(b.equal(pRoot.get("medicalRecordId"), mRoot.get("id")),
                b.equal(pRoot.get("medicineId"), medicineRoot.get("id")),
                b.equal(pRoot.get("medicineId"), medicineRoot.get("id")),
                b.equal(b.function("YEAR", Integer.class, mRoot.get("billingDate")), year),
                b.equal(b.function("QUARTER", Integer.class, mRoot.get("billingDate")), quarter));

        q.multiselect(medicineRoot.get("name"),
                b.count(pRoot.get("medicineId")));

        q.groupBy(pRoot.get("medicineId"));
        q.orderBy(b.asc(medicineRoot.get("name")));

        Query query = session.createQuery(q);

        return query.getResultList();
    }

    @Override
    public List<Object[]> frequencyOfMedicineUsageStatisticsByMonth(int year, int month) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root mRoot = q.from(MedicalRecord.class);
        Root pRoot = q.from(Prescription.class);
        Root medicineRoot = q.from(Medicine.class);

        q.where(b.equal(pRoot.get("medicalRecordId"), mRoot.get("id")),
                b.equal(pRoot.get("medicineId"), medicineRoot.get("id")),
                b.equal(pRoot.get("medicineId"), medicineRoot.get("id")),
                b.equal(b.function("YEAR", Integer.class, mRoot.get("billingDate")), year),
                b.equal(b.function("MONTH", Integer.class, mRoot.get("billingDate")), month));

        q.multiselect(medicineRoot.get("name"),
                b.count(pRoot.get("medicineId")));

        q.groupBy(pRoot.get("medicineId"));
        q.orderBy(b.asc(medicineRoot.get("name")));

        Query query = session.createQuery(q);

        return query.getResultList();
    }

    @Override
    public List<Object[]> getMedicinesByKeyword(String kw) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
       
        Root<Medicine> mRoot = q.from(Medicine.class);
        Root<Unit> uRoot = q.from(Unit.class);
        q.where(b.equal(mRoot.get("unitId"), uRoot.get("id")));

        q.multiselect(mRoot.get("image"),
                mRoot.get("name"),
                uRoot.get("name"),
                mRoot.get("unitPrice"),
                mRoot.get("note"));

        if (kw != null && !kw.isEmpty()) {
                Predicate p = b.like(mRoot.get("name").as(String.class), String.format("%%%s%%", kw));
                Predicate p2 = b.equal(mRoot.get("unitId"), uRoot.get("id"));
                q = q.where(b.and(p, p2));
            }  
        
        //sap xep thuoc theo ten
        q.orderBy(b.asc(mRoot.get("name")));
        
        Query<Object[]> query = session.createQuery(q);
        return query.getResultList();
    }

}
