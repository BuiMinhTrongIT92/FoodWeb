/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.repository.impl;

import com.bmt.pojo.Cuahang;
import com.bmt.pojo.Danhgia;
import com.bmt.pojo.Monan;
import com.bmt.pojo.MonanLoaimonan;
import com.bmt.pojo.User;
import com.bmt.repository.CuaHangRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
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
 * @author ACER
 */
@Repository
@Transactional
@PropertySource("classpath:template.properties")
public class CuaHangRepositoryImpl implements CuaHangRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Autowired
    private Environment env;

    @Override
    public List<Object[]> getCuaHangNoiBat(int sl) {
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        Root root1 = q.from(Danhgia.class);
        Root root2 = q.from(Cuahang.class);
        q.multiselect(root2.get("idcuahang"),
                root2.get("tencuahang"),
                root2.get("diachi"),
                root2.get("active"),
                root2.get("logo"),
                b.sum(root1.get("sao")));

        List<Predicate> predicates = new ArrayList<>();
        Predicate p1 = b.equal(root2.get("active").as(Boolean.class), b.literal(true));
        Predicate p2 = b.equal(root1.get("idcuahang"), root2.get("idcuahang"));
        predicates.add(p1);
        predicates.add(p2);
        q.where(predicates.toArray(new Predicate[]{}));

//        q.where(b.equal(root1.get("idcuahang"), root2.get("idcuahang")));
        q.groupBy(root1.get("idcuahang"));
        q.orderBy(b.desc(b.sum(root1.get("sao"))));
        Query query = session.createQuery(q);
        if (sl != 0) {
            query.setMaxResults(Integer.parseInt(env.getProperty("content.cuahangphobien").toString()));
        } else {
            return query.getResultList();
        }
        return query.getResultList();
    }


    @Override
    public List<Cuahang> getAllCuaHangByUser(User user) {
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Cuahang> q = b.createQuery(Cuahang.class);
        Root root = q.from(Cuahang.class);
        q.select(root);
        List<Predicate> predicates = new ArrayList<>();
        Predicate p1 = b.equal(root.get("iduser").as(User.class), user);
        predicates.add(p1);
        q.where(predicates.toArray(new Predicate[]{}));
        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public Cuahang getCuaHangByID(String id) {
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Cuahang> q = b.createQuery(Cuahang.class);
        Root root = q.from(Cuahang.class);
        q.select(root);
        List<Predicate> predicates = new ArrayList<>();
        Predicate p1 = b.equal(root.get("idcuahang").as(String.class), id);
        predicates.add(p1);
        q.where(predicates.toArray(new Predicate[]{}));
        Query query = session.createQuery(q);
        return (Cuahang) query.getSingleResult();
    }

    @Override
    public boolean themCuaHang(Cuahang cuahang) {
        Session s = sessionFactory.getObject().getCurrentSession();
        try {
            s.save(s);
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }
}

