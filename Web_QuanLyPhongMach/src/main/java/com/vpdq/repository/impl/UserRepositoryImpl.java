/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.repository.impl;

import com.vpdq.pojo.MedicalRecord;
import com.vpdq.pojo.User;
import com.vpdq.repository.UserRepository;
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
public class UserRepositoryImpl implements UserRepository {

    // lien ket voi pojo
    // Tang duy nhat duoc @Autowired voi CSDL
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Autowired
    private Environment env;

    @Override
    public boolean addUser(User user) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(user);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateUser(int id, User user) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        User u = getUserByID(id);
        u.setFirstName(user.getFirstName());
        u.setLastName(user.getLastName());
        u.setDateOfBirth(user.getDateOfBirth());
        u.setSex(user.getSex());
        u.setAddress(user.getAddress());
        u.setEmail(user.getEmail());
        u.setPhone(user.getPhone());
        u.setSpecialize(user.getSpecialize());
        u.setUsername(user.getUsername());
        if (user.getImage() != null) {
            u.setImage(user.getImage());
        }
        try {
            session.saveOrUpdate(u);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteUser(int userId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            User m = session.get(User.class, userId);
            session.delete(m);

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public User getUserByID(int userId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        query.select(root);
        query.where(builder.equal(root.get("id"), userId));
        User u = session.createQuery(query).uniqueResult();

        return u;
    }

    @Override
    public boolean updateImageUser(int userId, String image) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        User u = getUserByID(userId);
        u.setImage(image);
        try {
            session.saveOrUpdate(u);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public List<User> getUserByRole(Map<String, String> params, int page, String role) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<User> q = b.createQuery(User.class);
        Root root = q.from(User.class);
        q.select(root);
        q.where(b.equal(root.get("userRole"), role));
        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();

            //Tìm theo tên
            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                Predicate pfn = b.like(root.get("first_name").as(String.class), String.format("%%%s%%", kw));
                predicates.add(pfn);

                Predicate pln = b.like(root.get("last_name").as(String.class), String.format("%%%s%%", kw));
                if (!pfn.equals(pln)) {
                    predicates.add(pln);
                }

            }
            q.where(predicates.toArray(Predicate[]::new));
        }

        q.orderBy(b.desc(root.get("id")));
        Query query = session.createQuery(q);

        //Phân trang
        if (page > 0) {
            int size = Integer.parseInt(env.getProperty("page.size").toString());
            int start = (page - 1) * size;
            query.setFirstResult(start);
            query.setMaxResults(size);
        }

        return query.getResultList();
    }

    @Override
    public User getUserByUsername(String username) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        query.select(root);
        query.where(builder.equal(root.get("username"), username));
        User user = session.createQuery(query).uniqueResult();
        return user;
    }

    @Override
    public List<User> getUserEmployee(Map<String, String> params, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<User> q = b.createQuery(User.class);
        Root root = q.from(User.class);
        q.select(root);
        q.where(b.or(b.equal(root.get("userRole"), "ROLE_DOCTOR"), b.equal(root.get("userRole"), "ROLE_NURSE")));
        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();

            //Tìm theo tên
            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                Predicate pfn = b.like(root.get("first_name").as(String.class), String.format("%%%s%%", kw));
                predicates.add(pfn);

                Predicate pln = b.like(root.get("last_name").as(String.class), String.format("%%%s%%", kw));
                if (!pfn.equals(pln)) {
                    predicates.add(pln);
                }

            }
            q.where(predicates.toArray(Predicate[]::new));
        }

        q.orderBy(b.desc(root.get("id")));
        Query query = session.createQuery(q);

        //Phân trang
        if (page > 0) {
            int size = Integer.parseInt(env.getProperty("page.size").toString());
            int start = (page - 1) * size;
            query.setFirstResult(start);
            query.setMaxResults(size);
        }

        return query.getResultList();
    }

    @Override
    public List<User> getUserAdmin(Map<String, String> params, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<User> q = b.createQuery(User.class);
        Root root = q.from(User.class);
        q.select(root);
        q.where(b.equal(root.get("userRole"), "ROLE_ADMIN"));
        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();

            //Tìm theo tên
            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                Predicate pfn = b.like(root.get("first_name").as(String.class), String.format("%%%s%%", kw));
                predicates.add(pfn);

                Predicate pln = b.like(root.get("last_name").as(String.class), String.format("%%%s%%", kw));
                if (!pfn.equals(pln)) {
                    predicates.add(pln);
                }

            }
            q.where(predicates.toArray(Predicate[]::new));
        }

        q.orderBy(b.desc(root.get("id")));
        Query query = session.createQuery(q);

        //Phân trang
        if (page > 0) {
            int size = Integer.parseInt(env.getProperty("page.size").toString());
            int start = (page - 1) * size;
            query.setFirstResult(start);
            query.setMaxResults(size);
        }

        return query.getResultList();
    }

    //------------Chuc nang cua vai tro Admin--------------
    @Override
    public int countAdmin() {
        return 0;
    }

    //----------Chuc nang cua vai tro Employee-------------
    @Override
    public int countEmployee() {
        return 0;
    }

    //----------Chuc nang cua vai tro Customer-------------
    @Override
    public List<Object[]> patientStatistics() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root root = q.from(MedicalRecord.class);
        q.multiselect(b.count(root.get("id")));

        Query query = session.createQuery(q);

        return query.getResultList();
    }

    @Override
    public List<Object[]> patientStatisticsByYear() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root root = q.from(MedicalRecord.class);

        q.multiselect(b.function("YEAR", Integer.class, root.get("billingDate")), b.count(root.get("id")));

        q.groupBy(b.function("YEAR", Integer.class, root.get("billingDate")));
        q.orderBy(b.asc(b.function("YEAR", Integer.class, root.get("billingDate"))));
        Query query = session.createQuery(q);

        return query.getResultList();
    }

    @Override
    public List<Object[]> patientStatisticsByQuater(int year) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root root = q.from(MedicalRecord.class);
        q.where(b.equal(b.function("YEAR", Integer.class, root.get("billingDate")), year));
        q.multiselect(b.function("QUARTER", Integer.class, root.get("billingDate")),
                b.count(root.get("id")));

        q.groupBy(b.function("QUARTER", Integer.class, root.get("billingDate")));
        q.orderBy(b.asc(b.function("QUARTER", Integer.class, root.get("billingDate"))));
        Query query = session.createQuery(q);

        return query.getResultList();
    }

    @Override
    public List<Object[]> patientStatisticsByMonth(int year) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root root = q.from(MedicalRecord.class);
        q.where(b.equal(b.function("YEAR", Integer.class, root.get("billingDate")), year));
        q.multiselect(b.function("MONTH", Integer.class, root.get("billingDate")),
                b.count(root.get("id")));

        q.groupBy(b.function("MONTH", Integer.class, root.get("billingDate")));
        q.orderBy(b.asc(b.function("MONTH", Integer.class, root.get("billingDate"))));
        Query query = session.createQuery(q);

        return query.getResultList();
    }

    @Override
    public boolean checkUsernameExists(String u) {
        boolean kq = false;
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);

        query.select(root);
        query.where(builder.equal(root.get("username"), u));

        if (session.createQuery(query).uniqueResult() != null)
            kq = true;
    
        return kq;
    }

    @Override
    public boolean updatePasswordUser(int id, User user) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        User u = getUserByID(id);
        
        u.setPassword(user.getPassword());
  
        try {
            session.saveOrUpdate(u);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

}
