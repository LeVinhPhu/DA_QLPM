/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.repository.impl;


import com.vpdq.pojo.MedicalRecord;
import com.vpdq.pojo.MedicalService;
import com.vpdq.pojo.Medicine;
import com.vpdq.pojo.Prescription;
import com.vpdq.pojo.User;
import com.vpdq.repository.MedicalRecordRepository;
import java.util.Date;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
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
public class MedicalRecordRepositoryImpl implements MedicalRecordRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override // cần kiểm tra lại nếu lổi
    public List<Object[]> revenueStatistics() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root mRoot = q.from(MedicalRecord.class);

        q.multiselect(b.function("YEAR", Integer.class, mRoot.get("billingDate")), 
                b.sum(mRoot.get("total")));
        
        q.groupBy(b.function("YEAR", Integer.class, mRoot.get("billingDate")));
        q.orderBy(b.asc(b.function("YEAR", Integer.class, mRoot.get("billingDate"))));
        Query query = session.createQuery(q);

        return query.getResultList();
    }

    @Override // cần kiểm tra lại nếu lổi
    public List<Object[]> revenueStatisticsByQuarter(int year) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root mRoot = q.from(MedicalRecord.class);
       
        
        q.where(b.isNotNull(mRoot.get("billingDate")),
                b.equal(b.function("YEAR", Integer.class, mRoot.get("billingDate")), year));

        q.multiselect(b.function("QUARTER", Integer.class, mRoot.get("billingDate")), 
                b.sum(mRoot.get("total")));

        q.groupBy(b.function("QUARTER", Integer.class, mRoot.get("billingDate")));
        q.orderBy(b.asc(b.function("QUARTER", Integer.class, mRoot.get("billingDate"))));
        
        Query query = session.createQuery(q);

        return query.getResultList();
    }

    @Override //cần kiểm tra lại nếu lổi
    public List<Object[]> revenueStatisticsByMonth(int year) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root mRoot = q.from(MedicalRecord.class);
      
        q.where(b.isNotNull(mRoot.get("billingDate")),
                b.equal(b.function("YEAR", Integer.class, mRoot.get("billingDate")), year));

        q.multiselect(b.function("MONTH", Integer.class, mRoot.get("billingDate")), 
                b.sum(mRoot.get("total")));

        q.groupBy(b.function("MONTH", Integer.class, mRoot.get("billingDate")));
        q.orderBy(b.asc(b.function("MONTH", Integer.class, mRoot.get("billingDate"))));
        
        Query query = session.createQuery(q);

        return query.getResultList();
    }

    @Override // cần kiểm tra nếu có lổi
    public List<Object[]> totalRevenueStatistics() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root mRoot = q.from(MedicalRecord.class);
        
        q.where(b.isNotNull(mRoot.get("billingDate")));

        q.multiselect(b.sum(mRoot.get("total")));
        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public boolean addMedicalRecord(MedicalRecord m) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        try {
            session.save(m);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override // cần xem xét lại nếu ko tìm đc đối tương user
    public List<Object[]> getMedicalRecord(String name) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();

        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root mRoot = q.from(MedicalRecord.class);
        Root cRoot = q.from(User.class);

        q.where(b.equal(cRoot.get("id"), mRoot.get("customerId")),
                b.isNull(mRoot.get("billingDate")));
        q.multiselect(mRoot.get("id"), cRoot.get("firstName"), cRoot.get("lastName"));

        Query<Object[]> query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public MedicalRecord getMedicalRecordByID(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<MedicalRecord> query = builder.createQuery(MedicalRecord.class);
        Root<MedicalRecord> root = query.from(MedicalRecord.class);
        query.select(root);
        query.where(builder.equal(root.get("id"), id));
        MedicalRecord m = session.createQuery(query).uniqueResult();

        return m;
    }

    @Override //r
    public List<Object[]> getInfoMedicalRecordByID(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        
        Root mRoot = q.from(MedicalRecord.class);
        Root cRoot = q.from(User.class);
        
        q.where(b.equal(mRoot.get("customerId"), cRoot.get("id")),
                b.equal(mRoot.get("id"), id));
       
        q.multiselect(mRoot.get("id"), 
                cRoot.get("firstName"), 
                cRoot.get("lastName"),
                mRoot.get("symptom"),
                mRoot.get("conclusion"));
        Query<Object[]> query = session.createQuery(q);
        return query.getResultList();
    }


    @Override
    public List<Object[]> getMedicalRecordForPayment() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root mRoot = q.from(MedicalRecord.class);
        Root pRoot = q.from(Prescription.class);
        Root medicineRoot = q.from(Medicine.class);
        Root cRoot = q.from(User.class);
        Root sRoot = q.from(MedicalService.class);
       

        q.where(b.equal(pRoot.get("medicalRecordId"), mRoot.get("id")),
                b.equal(pRoot.get("medicineId"), medicineRoot.get("id")),
                b.equal(pRoot.get("medicineId"), medicineRoot.get("id")),
                b.equal(mRoot.get("customerId"), cRoot.get("id")),
                b.equal(mRoot.get("medicalServiceId"), sRoot.get("id")),
                b.isNull(mRoot.get("billingDate")));
       
        
        q.multiselect(b.sum(b.sum(b.prod(pRoot.get("quantity"), medicineRoot.get("unitPrice"))), sRoot.get("price")),
                mRoot.get("id"),
                cRoot.get("firstName"),
                cRoot.get("lastName"),
                sRoot.get("name")
                );

        q.groupBy(mRoot.get("id"));
        Query query = session.createQuery(q);

        return query.getResultList();
    }

    @Override
    public List<Object[]> getMedicalRecordForPaymentByID(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root mRoot = q.from(MedicalRecord.class);
        Root pRoot = q.from(Prescription.class);
        Root medicineRoot = q.from(Medicine.class);
        Root cRoot = q.from(User.class);
        Root sRoot = q.from(MedicalService.class);
       
        q.where(b.equal(mRoot.get("customerId"), cRoot.get("id")),
                b.equal(mRoot.get("medicalServiceId"), sRoot.get("id")),
                b.equal(pRoot.get("medicalRecordId"), mRoot.get("id")),
                b.equal(pRoot.get("medicineId"), medicineRoot.get("id")),
                b.equal(mRoot.get("id"), id));
       
           
        q.multiselect(mRoot.get("id"),
                cRoot.get("firstName"),
                cRoot.get("lastName"),
                sRoot.get("name"),
                sRoot.get("price"),
                b.sum(b.prod(pRoot.get("quantity"), medicineRoot.get("unitPrice"))),
                b.sum(b.sum(b.prod(pRoot.get("quantity"), medicineRoot.get("unitPrice"))), sRoot.get("price")));

        Query query = session.createQuery(q);

        return query.getResultList();
    }

    @Override
    public boolean payment(int idM, int idNurse, Date date, Long total) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        MedicalRecord m = getMedicalRecordByID(idM);
        
        User nurse = new User();
        nurse.setId(idNurse);
        m.setNurseId(nurse);
        m.setTotal(total);
        m.setBillingDate(date);
        try {
            session.update(m);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Object[]> getMedicalRecordByIdCustomer() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);   
        Root<User> aRoot = q.from(User.class);
        Root<User> cRoot = q.from(User.class);
        Root<MedicalRecord> mRRoot = q.from(MedicalRecord.class);

        
        q.where(b.equal(mRRoot.get("doctorId"), aRoot.get("id")),
                b.equal(mRRoot.get("customerId"), cRoot.get("id")));
        q.multiselect(
                mRRoot.get("id"),
                aRoot.get("firstName"),
                aRoot.get("lastName"),
                mRRoot.get("symptom"),
                mRRoot.get("conclusion"));

        Query<Object[]> query = session.createQuery(q);

        return query.getResultList();
    }
}
