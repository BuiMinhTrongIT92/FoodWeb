/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.repository.impl;


import com.bmt.pojo.Donhang;
import com.bmt.pojo.DonhangMonan;

import com.bmt.pojo.Cuahang;
import com.bmt.pojo.Danhgia;
import com.bmt.pojo.Loaimonan;
import com.bmt.pojo.Monan;
import com.bmt.pojo.MonanLoaimonan;
import com.bmt.repository.LoaiMonAnRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author ACER
 */
@Repository
@Transactional
public class LoaiMonAnRepositoryImpl implements LoaiMonAnRepository {

    @Autowired
    LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Loaimonan> getLoaiMonAn() {
        Session s = sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM Loaimonan WHERE active = true");
        return q.getResultList();
    }

    @Override
    public List<Loaimonan> timkiemLoaiMonAn(Map<String, String> params, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Loaimonan> q = b.createQuery(Loaimonan.class);
        Root<Loaimonan> root = q.from(Loaimonan.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();

            Predicate p1 = b.equal(root.get("active").as(Boolean.class), b.literal(true));
            predicates.add(p1);

            String tukhoa = params.get("tukhoa");
            if (tukhoa != null && !tukhoa.isEmpty()) {
                Predicate p = b.like(root.get("tenloai").as(String.class), String.format("%%%s%%", tukhoa));
                predicates.add(p);
            }

            q.where((Predicate[]) predicates.toArray(Predicate[]::new));
        }
        Query query = session.createQuery(q);

        return query.getResultList();
    }

    @Override

    public List<Object[]> thongKeDoanhThuDanhMuc(String kw, Date tungay, Date denngay,String iduser) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();

        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rMonan = q.from(Monan.class);
        Root rDonhang = q.from(Donhang.class);
        Root rDonhangMonan = q.from(DonhangMonan.class);
        Root rLoaiMonAn = q.from(Loaimonan.class);
        Root rMonanLoaimonan = q.from(MonanLoaimonan.class);
        Root rCuahang = q.from(Cuahang.class);
        q.where();
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(b.equal(rDonhangMonan.get("iddonhang"), rDonhang.get("iddonhang")));
        predicates.add(b.equal(rDonhangMonan.get("idmonan"), rMonan.get("idmonan")));
        predicates.add(b.equal(rMonan.get("idmonan"), rMonanLoaimonan.get("idmonan")));
        predicates.add(b.equal(rMonanLoaimonan.get("idloaimonan"), rLoaiMonAn.get("idloaimonan")));
        predicates.add(b.equal(rMonan.get("idcuahang"), rCuahang.get("idcuahang")));
        predicates.add(b.equal(rDonhang.get("trangthai"), "thanhcong"));
        q.multiselect(rMonanLoaimonan.get("idloaimonan"), rLoaiMonAn.get("tenloai"),
                b.sum(rDonhangMonan.get("tongtien")), rDonhang.get("ngaytao"));

        if (kw != null && !kw.isEmpty()) {
            predicates.add(b.like(rLoaiMonAn.get("tenloai"), String.format("%%%s%%", kw)));
        }
        if (tungay != null) {
            predicates.add(b.greaterThanOrEqualTo(rDonhang.get("ngaytao"), tungay));
        }
        if (denngay != null) {
            predicates.add(b.lessThanOrEqualTo(rDonhang.get("ngaytao"), denngay));
        }
        predicates.add(b.equal(rCuahang.get("iduser").get("id"), iduser));
        q.where((Predicate[]) predicates.toArray(Predicate[]::new));
        q.groupBy(rMonanLoaimonan.get("idloaimonan"));
        q.orderBy(b.desc(b.sum(rDonhangMonan.get("tongtien"))));
        Query query = session.createQuery(q);
        return query.getResultList();
    }

//    @Override
//    public List<Object[]> thongKeDoanhThuDanhMucTheoThang(int thang, int nam) {
//        Session session = this.sessionFactory.getObject().getCurrentSession();
//        CriteriaBuilder b = session.getCriteriaBuilder();
//
//        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
//
//        Root rMonan = q.from(Monan.class);
//        Root rDonhang = q.from(Donhang.class);
//        Root rDonhangMonan = q.from(DonhangMonan.class);
//        Root rLoaiMonAn = q.from(Loaimonan.class);
//        Root rMonanLoaimonan = q.from(MonanLoaimonan.class);
//        List<Predicate> predicates = new ArrayList<>();
//        predicates.add(b.equal(rDonhangMonan.get("iddonhang"), rDonhang.get("iddonhang")));
//        predicates.add(b.equal(rDonhangMonan.get("idmonan"), rMonan.get("idmonan")));
//        predicates.add(b.equal(rMonan.get("idmonan"), rMonanLoaimonan.get("idmonan")));
//        predicates.add(b.equal(rMonanLoaimonan.get("idloaimonan"), rLoaiMonAn.get("idloaimonan")));
//        predicates.add(b.equal(rDonhang.get("trangthai"), "thanhcong"));
//        q.multiselect(rLoaiMonAn.get("tenloai"),b.function("MONTH", Integer.class, rDonhang.get("ngaytao")),
//                b.function("YEAR", Integer.class, rDonhang.get("ngaytao")),b.sum(rDonhangMonan.get("tongtien")));
//
//        predicates.add(b.equal(b.function("MONTH", Integer.class, rDonhang.get("ngaytao")), thang));
//        predicates.add(b.equal(b.function("YEAR", Integer.class, rDonhang.get("ngaytao")), nam));
//
//        q.where((Predicate[]) predicates.toArray(Predicate[]::new));
//        q.groupBy(b.function("MONTH", Integer.class, rDonhang.get("ngaytao"), 
//                b.function("YEAR", Integer.class, rDonhang.get("ngaytao"),rLoaiMonAn.get("idloaimonan"))));                                                           
//        q.orderBy(b.desc(b.function("YEAR", Integer.class, rDonhang.get("ngaytao"))));
//        Query query = session.createQuery(q);
//        return query.getResultList();
//    }
    @Override
    public List<Object[]> thongKeDoanhThuDanhMucTheoThang(int thang, int nam,String iduser) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();

        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rMonan = q.from(Monan.class);
        Root rDonhang = q.from(Donhang.class);
        Root rDonhangMonan = q.from(DonhangMonan.class);
        Root rLoaiMonAn = q.from(Loaimonan.class);
        Root rMonanLoaimonan = q.from(MonanLoaimonan.class);
        Root rCuahang = q.from(Cuahang.class);
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(b.equal(rDonhangMonan.get("iddonhang"), rDonhang.get("iddonhang")));
        predicates.add(b.equal(rDonhangMonan.get("idmonan"), rMonan.get("idmonan")));
        predicates.add(b.equal(rMonan.get("idmonan"), rMonanLoaimonan.get("idmonan")));
        predicates.add(b.equal(rMonanLoaimonan.get("idloaimonan"), rLoaiMonAn.get("idloaimonan")));
        predicates.add(b.equal(rMonan.get("idcuahang"), rCuahang.get("idcuahang")));
        predicates.add(b.equal(rDonhang.get("trangthai"), "thanhcong"));
        q.multiselect(rLoaiMonAn.get("tenloai"), b.function("MONTH", Integer.class, rDonhang.get("ngaytao")),
                b.function("YEAR", Integer.class, rDonhang.get("ngaytao")), b.sum(rDonhangMonan.get("tongtien")));

        predicates.add(b.equal(b.function("MONTH", Integer.class, rDonhang.get("ngaytao")), thang));
        predicates.add(b.equal(b.function("YEAR", Integer.class, rDonhang.get("ngaytao")), nam));
        predicates.add(b.equal(rCuahang.get("iduser").get("id"), iduser));
        
        q.where((Predicate[]) predicates.toArray(Predicate[]::new));
        q.groupBy(rLoaiMonAn.get("idloaimonan"), b.function("MONTH", Integer.class, rDonhang.get("ngaytao")));
        q.orderBy(b.desc(b.function("YEAR", Integer.class, rDonhang.get("ngaytao"))));
        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public List<Object[]> thongKeDoanhThuDanhMucTheoQuy(int quy, int nam,String iduser) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();

        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rMonan = q.from(Monan.class);
        Root rDonhang = q.from(Donhang.class);
        Root rDonhangMonan = q.from(DonhangMonan.class);
        Root rLoaiMonAn = q.from(Loaimonan.class);
        Root rMonanLoaimonan = q.from(MonanLoaimonan.class);
        Root rCuahang = q.from(Cuahang.class);
        q.where();
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(b.equal(rDonhangMonan.get("iddonhang"), rDonhang.get("iddonhang")));
        predicates.add(b.equal(rDonhangMonan.get("idmonan"), rMonan.get("idmonan")));
        predicates.add(b.equal(rMonan.get("idmonan"), rMonanLoaimonan.get("idmonan")));
        predicates.add(b.equal(rMonanLoaimonan.get("idloaimonan"), rLoaiMonAn.get("idloaimonan")));
        predicates.add(b.equal(rMonan.get("idcuahang"), rCuahang.get("idcuahang")));
        predicates.add(b.equal(rDonhang.get("trangthai"), "thanhcong"));
        q.multiselect(b.function("QUARTER", Integer.class, rDonhang.get("ngaytao")), rLoaiMonAn.get("tenloai"),
                b.sum(rDonhangMonan.get("tongtien")));

        predicates.add(b.equal(b.function("QUARTER", Integer.class, rDonhang.get("ngaytao")), quy));
        predicates.add(b.equal(b.function("YEAR", Integer.class, rDonhang.get("ngaytao")), nam));
        predicates.add(b.equal(rCuahang.get("iduser").get("id"), iduser));
        
        q.where((Predicate[]) predicates.toArray(Predicate[]::new));
        q.groupBy(rMonanLoaimonan.get("idloaimonan"));
        q.orderBy(b.desc(b.sum(rDonhangMonan.get("tongtien"))));
        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public List<Object[]> thongKeDoanhThuDanhMucTheoNam(int nam,String iduser) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();

        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rMonan = q.from(Monan.class);
        Root rDonhang = q.from(Donhang.class);
        Root rDonhangMonan = q.from(DonhangMonan.class);
        Root rLoaiMonAn = q.from(Loaimonan.class);
        Root rMonanLoaimonan = q.from(MonanLoaimonan.class);
        Root rCuahang = q.from(Cuahang.class);
        q.where();
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(b.equal(rDonhangMonan.get("iddonhang"), rDonhang.get("iddonhang")));
        predicates.add(b.equal(rDonhangMonan.get("idmonan"), rMonan.get("idmonan")));
        predicates.add(b.equal(rMonan.get("idmonan"), rMonanLoaimonan.get("idmonan")));
        predicates.add(b.equal(rMonanLoaimonan.get("idloaimonan"), rLoaiMonAn.get("idloaimonan")));
        predicates.add(b.equal(rMonan.get("idcuahang"), rCuahang.get("idcuahang")));
        predicates.add(b.equal(rDonhang.get("trangthai"), "thanhcong"));
        q.multiselect(b.function("YEAR", Integer.class, rDonhang.get("ngaytao")), rLoaiMonAn.get("tenloai"),
                b.sum(rDonhangMonan.get("tongtien")));

        predicates.add(b.equal(b.function("YEAR", Integer.class, rDonhang.get("ngaytao")), nam));
        predicates.add(b.equal(rCuahang.get("iduser").get("id"), iduser));
        
        q.where((Predicate[]) predicates.toArray(Predicate[]::new));
        q.groupBy(rMonanLoaimonan.get("idloaimonan"));
        q.orderBy(b.desc(b.sum(rDonhangMonan.get("tongtien"))));
        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public List<Loaimonan> getAllLoaiMonAn() {
        Session s = sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM Loaimonan");
        return q.getResultList();
    }

    @Override
    public Loaimonan getMotLoaiMonAn(int idloaimon) {
        Session s = sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From Loaimonan where idloaimonan =" + idloaimon);

        return (Loaimonan) q.getSingleResult();
    }

    @Override
    public boolean themLoaiMon(Loaimonan loaimon) {
        Session s = sessionFactory.getObject().getCurrentSession();
        try {
            s.save(loaimon);
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean suaLoaiMon(Loaimonan loaimon) {
        Session s = sessionFactory.getObject().getCurrentSession();
        try {
            s.update(loaimon);
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
            
        }
        return false;
    }

    @Override
    public Loaimonan getLoaiMonAnTheoId(int idLoaiMonAn, int page) {
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Loaimonan> q = b.createQuery(Loaimonan.class);
        Root root = q.from(Loaimonan.class);
        q.select(root);
        List<Predicate> predicates = new ArrayList<>();
        Predicate p1 = b.equal(root.get("idloaimonan"), idLoaiMonAn);
        predicates.add(p1);
        
        q.where(predicates.toArray(new Predicate[]{}));
        Query query = session.createQuery(q);
        
        return (Loaimonan) query.getSingleResult();
    }

    @Override

    public boolean xoaLoaiMon(int idloaimon) {
        Session s = sessionFactory.getObject().getCurrentSession();
        try {
            s.delete(s.get(Loaimonan.class, idloaimon));
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
            
        }
        return false;
    }
    

    public List<Loaimonan> getLoaiMonAnTimKiem(Map<String, String> params, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Loaimonan> q = b.createQuery(Loaimonan.class);
        Root<Loaimonan> root = q.from(Loaimonan.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();

            Predicate p1 = b.equal(root.get("active").as(Boolean.class), b.literal(true));
            predicates.add(p1);
            
            String tenLoai = params.get("tenLoai");
            if (tenLoai != null && !tenLoai.isEmpty()) {
                Predicate p = b.like(root.get("tenloai").as(String.class), String.format("%%%s%%", tenLoai));
                predicates.add(p);
            }
            q.where((Predicate[]) predicates.toArray(Predicate[]::new));
        }
        Query query = session.createQuery(q);
        return query.getResultList();
    }

}
