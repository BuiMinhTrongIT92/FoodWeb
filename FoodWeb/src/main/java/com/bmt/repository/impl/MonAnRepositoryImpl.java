/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.repository.impl;

import com.bmt.pojo.Cuahang;
import com.bmt.pojo.Danhgia;
import com.bmt.pojo.Monan;
import com.bmt.repository.MonAnRepository;
import java.util.ArrayList;
import java.util.Date;
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
 * @author ACER
 */
@Repository
@Transactional
@PropertySource("classpath:template.properties")
public class MonAnRepositoryImpl implements MonAnRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private Environment env;

    @Override
    public List<Monan> getMonAnSapBan() {
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Monan> q = b.createQuery(Monan.class);
        Root root = q.from(Monan.class);
        q.select(root);
        List<Predicate> predicates = new ArrayList<>();
        Predicate p1 = b.greaterThanOrEqualTo(root.get("thoidiemban").as(Date.class),
                b.currentDate());
        Predicate p2 = b.equal(root.get("active").as(Boolean.class),
                b.literal(true));
        Predicate p3 = b.equal(root.get("trangthai").as(Boolean.class),
                b.literal(true));
        predicates.add(p1);
        predicates.add(p2);
        predicates.add(p3);
        q.where(predicates.toArray(new Predicate[]{}));
        Query query = session.createQuery(q);
        query.setMaxResults(Integer.parseInt(env.getProperty("content.monanconlai")));
        return query.getResultList();
    }

    @Override
    public List<Monan> getMonAnPhoBien(int page) {
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        Root root1 = q.from(Danhgia.class);
        Root root2 = q.from(Monan.class);
        q.select(root2);
        List<Predicate> predicates = new ArrayList<>();
        Predicate p1 = b.equal(root1.get("idmonan"), root2.get("idmonan"));
        Predicate p2 = b.equal(root2.get("active").as(Boolean.class),b.literal(true));
        Predicate p3 = b.equal(root2.get("trangthai").as(Boolean.class),b.literal(true));
        predicates.add(p1);
        predicates.add(p2);
        predicates.add(p3);
        q.where(predicates.toArray(new Predicate[]{}));
        q.orderBy(b.desc(root1.get("sao")));

        Query query = session.createQuery(q);
        if (page > 0) {
            int size = Integer.parseInt(env.getProperty("page.size").toString());
            int start = (page - 1) * size;
            query.setFirstResult(start);
            query.setMaxResults(size);
        }
        return query.getResultList();
    }

}
