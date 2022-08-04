/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.repository.impl;

import com.bmt.pojo.Monan;
import com.bmt.pojo.User;
import com.bmt.repository.UserRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ACER
 */
@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public boolean addUser(User user) {
//        Session s = sessionFactory.getObject().getCurrentSession();
//        try {
//            s.save(user);
//            return true;
//        } catch (HibernateException ex) {
//            System.err.println(ex.getMessage());
//        }
        return false;
    }

    @Override
    public List<User> getUsers(String taikhoan) {
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<User> q = b.createQuery(User.class);
        Root root = q.from(User.class);
        q.select(root);
        if (!taikhoan.isEmpty()) {
            List<Predicate> predicates = new ArrayList<>();
            Predicate p1 = b.equal(root.get("taikhoan").as(String.class), taikhoan.trim());
//            Predicate p2 = b.equal(root.get("active").as(Boolean.class),
//                b.literal(true)); 
            predicates.add(p1);
//            predicates.add(p2);
//            q.where(predicates.toArray(new Predicate[]{}));
                q.where(p1);
        }
        Query query = session.createQuery(q);
        return query.getResultList();
    }

}
