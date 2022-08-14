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
import java.util.Collection;
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
import org.springframework.security.core.userdetails.User;
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
        if (query.getResultList().size() >= Integer.parseInt(env.getProperty("content.monanconlai"))) {
            query.setMaxResults(Integer.parseInt(env.getProperty("content.monanconlai")));
        } else {
            query.setMaxResults(query.getResultList().size());
        }

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
        Predicate p2 = b.equal(root2.get("active").as(Boolean.class), b.literal(true));
        Predicate p3 = b.equal(root2.get("trangthai").as(Boolean.class), b.literal(true));
        predicates.add(p1);
        predicates.add(p2);
        predicates.add(p3);
        q.where(predicates.toArray(new Predicate[]{}));
        q.orderBy(b.desc(root1.get("sao")));

        Query query = session.createQuery(q);
        int size = Integer.parseInt(env.getProperty("content.monanphobienitem").toString());
        query.setMaxResults(size);

        return query.getResultList();
    }

//    @Override
//    public List<Monan> getTatCaMonAn(Map<String, String> params, int page) {
//        Session session = this.sessionFactory.getObject().getCurrentSession();
//        CriteriaBuilder b = session.getCriteriaBuilder();
//        CriteriaQuery<Monan> q = b.createQuery(Monan.class);
//        Root<Monan> root = q.from(Monan.class);
//        q.select(root);
//        
//        if (params != null) {
//            List<Predicate> predicates = new ArrayList<>();
//            
//            Predicate p1 = b.equal(root.get("active").as(Boolean.class), b.literal(true));
//            Predicate p2 = b.equal(root.get("trangthai").as(Boolean.class), b.literal(true));
//            predicates.add(p1);
//            predicates.add(p2);
//
//            String tukhoa = params.get("tukhoa");
//            if (tukhoa != null && !tukhoa.isEmpty()) {
//                Predicate p = b.like(root.get("tenmonan").as(String.class), String.format("%%%s%%", tukhoa));
//                predicates.add(p);
//            }
//
//            String tu = params.get("tu");
//            if (tu != null) {
//                Predicate p = b.greaterThanOrEqualTo(root.get("gia").as(Long.class), Long.parseLong(tu));
//                predicates.add(p);
//            }
//
//            String den = params.get("den");
//            if (den != null) {
//                Predicate p = b.lessThanOrEqualTo(root.get("gia").as(Long.class), Long.parseLong(den));
//                predicates.add(p);
//            }
//
//            q.where((Predicate[]) predicates.toArray(Predicate[]::new));
//            
//        }
//        Query query = session.createQuery(q);
//        
//        if (page > 0) {
//            int size = Integer.parseInt(env.getProperty("monan_page.size").toString());
//            int start = (page - 1) * size;
//            query.setFirstResult(start);
//            query.setMaxResults(size);
//        }
//        
//        return query.getResultList();
//    }
    @Override
    public List<Monan> getTatCaMonAn(Map<String, String> params, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Monan> q = b.createQuery(Monan.class);
        Root<Monan> root = q.from(Monan.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();

            Predicate p1 = b.equal(root.get("active").as(Boolean.class), b.literal(true));
            Predicate p2 = b.equal(root.get("trangthai").as(Boolean.class), b.literal(true));
            predicates.add(p1);
            predicates.add(p2);

            String tukhoa = params.get("tukhoa");
            if (tukhoa != null && !tukhoa.isEmpty()) {
                Predicate p = b.like(root.get("tenmonan").as(String.class), String.format("%%%s%%", tukhoa));
                predicates.add(p);
            }

            String tu = params.get("tu");
            if (tu != null) {
                Predicate p = b.greaterThanOrEqualTo(root.get("gia").as(Long.class), Long.parseLong(tu));
                predicates.add(p);
            }

            String den = params.get("den");
            if (den != null) {
                Predicate p = b.lessThanOrEqualTo(root.get("gia").as(Long.class), Long.parseLong(den));
                predicates.add(p);
            }

            q.where((Predicate[]) predicates.toArray(Predicate[]::new));

        }
        Query query = session.createQuery(q);

        if (page > 0) {
            int size = Integer.parseInt(env.getProperty("monan_page.size").toString());
            int start = (page - 1) * size;
            query.setFirstResult(start);
            query.setMaxResults(size);
        }

        return query.getResultList();
    }

    @Override
    public List<Monan> getMonAnTangDanTheoGia(int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Monan> q = b.createQuery(Monan.class);
        Root<Monan> root = q.from(Monan.class);
        q.select(root);

        List<Predicate> predicates = new ArrayList<>();

        Predicate p1 = b.equal(root.get("active").as(Boolean.class), b.literal(true));
        Predicate p2 = b.equal(root.get("trangthai").as(Boolean.class), b.literal(true));
        predicates.add(p1);
        predicates.add(p2);
        q.orderBy(b.asc(root.get("gia")));

        q.where((Predicate[]) predicates.toArray(Predicate[]::new));

        Query query = session.createQuery(q);

        return query.getResultList();
    }

    @Override
    public List<Monan> getMonAnGiamDanTheoGia(int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Monan> q = b.createQuery(Monan.class);
        Root<Monan> root = q.from(Monan.class);
        q.select(root);

        List<Predicate> predicates = new ArrayList<>();

        Predicate p1 = b.equal(root.get("active").as(Boolean.class), b.literal(true));
        Predicate p2 = b.equal(root.get("trangthai").as(Boolean.class), b.literal(true));
        predicates.add(p1);
        predicates.add(p2);
        q.orderBy(b.desc(root.get("gia")));

        q.where((Predicate[]) predicates.toArray(Predicate[]::new));

        Query query = session.createQuery(q);

        return query.getResultList();
    }

    @Override
    public List<Object[]> geCuaHangTheoMonAnTimKiem(Map<String, String> params, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();

        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rM = q.from(Monan.class);
        Root rC = q.from(Cuahang.class);
        q.select(rM);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();

            Predicate p1 = b.equal(rM.get("active").as(Boolean.class), b.literal(true));
            Predicate p2 = b.equal(rM.get("trangthai").as(Boolean.class), b.literal(true));
            Predicate p3 = b.equal(rM.get("idcuahang"), rC.get("idcuahang"));
            predicates.add(p1);
            predicates.add(p2);
            predicates.add(p3);

            String tukhoa = params.get("tukhoa");
            if (tukhoa != null && !tukhoa.isEmpty()) {
                Predicate p4 = b.like(rM.get("tenmonan").as(String.class), String.format("%%%s%%", tukhoa));
                predicates.add(p4);
            }

            String tu = params.get("tu");
            if (tu != null) {
                Predicate p5 = b.greaterThanOrEqualTo(rM.get("gia").as(Long.class), Long.parseLong(tu));
                predicates.add(p5);
            }

            String den = params.get("den");
            if (den != null) {
                Predicate p6 = b.lessThanOrEqualTo(rM.get("gia").as(Long.class), Long.parseLong(den));
                predicates.add(p6);
            }
            q.where(predicates.toArray(new Predicate[]{}));  

        }
        
        q.distinct(true).select(rC.get("tencuahang"));

        Query query = session.createQuery(q);

        if (page > 0) {
            int size = Integer.parseInt(env.getProperty("monan_page.size").toString());
            int start = (page - 1) * size;
            query.setFirstResult(start);
            query.setMaxResults(size);
        }

        return query.getResultList();
    }
}
