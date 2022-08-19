/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.repository.impl;

import com.bmt.pojo.Cuahang;
import com.bmt.pojo.Danhgia;
import com.bmt.pojo.Loaimonan;
import com.bmt.pojo.Monan;
import com.bmt.pojo.MonanLoaimonan;
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
import org.hibernate.HibernateException;
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
            
            String idCuaHang = params.get("idCuaHang");
            if (idCuaHang != null) {
                Predicate p = b.equal(root.get("idcuahang").as(String.class), idCuaHang);
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

        q.distinct(true).multiselect(rC.get("idcuahang"), rC.get("tencuahang"), rC.get("diachi"));

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
    public Monan getMonAnByID(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Monan> q = b.createQuery(Monan.class);
        Root<Monan> root = q.from(Monan.class);
        q.select(root);
        List<Predicate> predicates = new ArrayList<>();

        Predicate p1 = b.equal(root.get("active").as(Boolean.class), b.literal(true));
        Predicate p2 = b.equal(root.get("trangthai").as(Boolean.class), b.literal(true));
        Predicate p3 = b.equal(root.get("idmonan").as(Integer.class), id);
        predicates.add(p1);
        predicates.add(p2);
        predicates.add(p3);
        q.where((Predicate[]) predicates.toArray(Predicate[]::new));
        Query query = session.createQuery(q);
        return (Monan) query.getSingleResult();
    }

    @Override
<<<<<<< HEAD
    public List<Object[]> getLoaiMonAnTheoMonAnTimKiem(Map<String, String> params, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();

        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rM = q.from(Monan.class);
        Root rL = q.from(Loaimonan.class);
        Root rM_L = q.from(MonanLoaimonan.class);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();

            Predicate p1 = b.equal(rM.get("active").as(Boolean.class), b.literal(true));
            Predicate p2 = b.equal(rM.get("trangthai").as(Boolean.class), b.literal(true));
            Predicate p3 = b.equal(rL.get("active").as(Boolean.class), b.literal(true));
            Predicate p4 = b.equal(rM.get("idmonan"), rM_L.get("idmonan"));
            Predicate p5 = b.equal(rM_L.get("idloaimonan"), rL.get("idloaimonan"));

            predicates.add(p1);
            predicates.add(p2);
            predicates.add(p3);
            predicates.add(p4);
            predicates.add(p5);

            String tukhoa = params.get("tukhoa");
            if (tukhoa != null && !tukhoa.isEmpty()) {
                Predicate p6 = b.like(rM.get("tenmonan").as(String.class), String.format("%%%s%%", tukhoa));
                predicates.add(p6);
            }

            String tu = params.get("tu");
            if (tu != null) {
                Predicate p7 = b.greaterThanOrEqualTo(rM.get("gia").as(Long.class), Long.parseLong(tu));
                predicates.add(p7);
            }

            String den = params.get("den");
            if (den != null) {
                Predicate p8 = b.lessThanOrEqualTo(rM.get("gia").as(Long.class), Long.parseLong(den));
                predicates.add(p8);
            }
            q.where(predicates.toArray(new Predicate[]{}));

        }
        q.distinct(true).select(rL.get("tenloai"));

        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public List<Object[]> getMonAnTheoIdCuaHang(Map<String, String> params, String idCuaHang, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();

        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rM = q.from(Monan.class);
        Root rC = q.from(Cuahang.class);
        q.where(b.equal(rM.get("idcuahang"), rC.get("idcuahang")));

            List<Predicate> predicates = new ArrayList<>();

            Predicate p1 = b.equal(rM.get("active").as(Boolean.class), b.literal(true));
            Predicate p2 = b.equal(rM.get("trangthai").as(Boolean.class), b.literal(true));
            Predicate p3 = b.equal(rC.get("active").as(Boolean.class), b.literal(true));
            Predicate p4 = b.equal(rM.get("idcuahang").get("idcuahang").as(String.class), idCuaHang);
            Predicate p5 = b.equal(rM.get("idcuahang"), rC.get("idcuahang"));

            predicates.add(p1);
            predicates.add(p2);
            predicates.add(p3);
            predicates.add(p4);
            

            q.where((Predicate[]) predicates.toArray(Predicate[]::new));
        

        q.multiselect(rM.get("idmonan"), rM.get("tenmonan"), rM.get("gia"), rM.get("anhmonan"), rC.get("tencuahang"));
        Query query = session.createQuery(q);
        return query.getResultList();
    }
=======
    public List<Monan> getALLMonAnByCuaHang(String idcuahang) {
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Monan> q = b.createQuery(Monan.class);
        Root root = q.from(Monan.class);
        q.select(root);
        Predicate p1 = b.equal(root.get("idcuahang").get("idcuahang").as(String.class),
                idcuahang);
        q.where(p1);
        Query query = session.createQuery(q);
        return query.getResultList();
    }
    @Override
    public List<Monan> getALLMonAnActiveByCuaHang(String idcuahang) {
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Monan> q = b.createQuery(Monan.class);
        Root root = q.from(Monan.class);
        q.select(root);
        List<Predicate> predicates = new ArrayList<>();
        Predicate p1 = b.equal(root.get("active").as(Boolean.class), b.literal(true));
        Predicate p2 = b.equal(root.get("trangthai").as(Boolean.class), b.literal(true));
        Predicate p3 = b.equal(root.get("idcuahang").get("idcuahang").as(String.class),
                idcuahang);
        predicates.add(p1);
        predicates.add(p2);
        predicates.add(p3);
        q.where((Predicate[]) predicates.toArray(Predicate[]::new));
        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public Monan getChiTietMonAnByID(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Monan> q = b.createQuery(Monan.class);
        Root<Monan> root = q.from(Monan.class);
        q.select(root);
        List<Predicate> predicates = new ArrayList<>();
        Predicate p3 = b.equal(root.get("idmonan").as(Integer.class), id);
        predicates.add(p3);
        q.where((Predicate[]) predicates.toArray(Predicate[]::new));
        Query query = session.createQuery(q);
        return (Monan) query.getSingleResult();
    }

    @Override
    public boolean themMonAn(Monan monan) {
        Session s = sessionFactory.getObject().getCurrentSession();
        try {
            s.save(monan);
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean suaMonAn(Monan monan) {
        Session s = sessionFactory.getObject().getCurrentSession();
        try {
            s.update(monan);
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    
>>>>>>> 226f6d66a346b81613eb8a7ba4384cec3b0eb81e
}
