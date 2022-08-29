/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.repository.impl;

import com.bmt.pojo.Binhluan;
import com.bmt.pojo.Cuahang;
import com.bmt.pojo.Danhgia;
import com.bmt.pojo.Donhang;
import com.bmt.pojo.DonhangMonan;
import com.bmt.pojo.Loaimonan;
import com.bmt.pojo.Monan;
import com.bmt.pojo.User;
import com.bmt.pojo.MonanLoaimonan;
import com.bmt.repository.MonAnRepository;
import com.bmt.repository.UserRepository;
import java.util.ArrayList;
import java.util.Calendar;
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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    @Autowired
    private UserRepository userRepository;

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
    public List<Object[]> getCuaHangTheoMonAnTimKiem(Map<String, String> params, int page) {
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
        q.distinct(true).multiselect(rL.get("idloaimonan"), rL.get("tenloai"));

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
        predicates.add(p5);

        q.where((Predicate[]) predicates.toArray(Predicate[]::new));

        q.multiselect(rM.get("idmonan"), rM.get("tenmonan"), rM.get("gia"), rM.get("anhmonan"), rC.get("tencuahang"), rC.get("diachi"));
        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override

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
        CriteriaQuery<MonanLoaimonan> ql = b.createQuery(MonanLoaimonan.class);
        Root<Monan> root = q.from(Monan.class);
        Root<MonanLoaimonan> rootl = ql.from(MonanLoaimonan.class);
        q.select(root);
        ql.select(rootl);
        List<Predicate> predicates = new ArrayList<>();
        Predicate p3 = b.equal(root.get("idmonan").as(Integer.class), id);
        predicates.add(p3);
        q.where((Predicate[]) predicates.toArray(Predicate[]::new));
        Query query = session.createQuery(q);
        Monan ma = (Monan) query.getSingleResult();

        Predicate p4 = b.equal(rootl.get("idmonan").get("idmonan").as(Integer.class), id);
        ql.where(p4);
        MonanLoaimonan malma = session.createQuery(ql).getSingleResult();
        ma.setIdloaimon(malma.getIdloaimonan().getIdloaimonan());
        return ma;
    }

    @Override
    public boolean themMonAn(Monan monan) {
        Session s = sessionFactory.getObject().getCurrentSession();
        try {
            s.save(monan);
            MonanLoaimonan malma = new MonanLoaimonan();
            malma.setIdmonan(monan);
            malma.setIdloaimonan(s.get(Loaimonan.class, monan.getIdloaimon()));
            s.save(malma);

            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean suaMonAn(Monan monan) {
        Session session = sessionFactory.getObject().getCurrentSession();
        try {
            session.update(monan);
            CriteriaBuilder b = session.getCriteriaBuilder();
            CriteriaQuery<MonanLoaimonan> ql = b.createQuery(MonanLoaimonan.class);
            Root<MonanLoaimonan> rootl = ql.from(MonanLoaimonan.class);
            ql.select(rootl);
            Predicate p4 = b.equal(rootl.get("idmonan").get("idmonan").as(Integer.class), monan.getIdmonan());
            ql.where(p4);
            MonanLoaimonan malma = session.createQuery(ql).getSingleResult();
            malma.setIdloaimonan(session.get(Loaimonan.class, monan.getIdloaimon()));
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    public List<Object[]> getMonAnTheoIdLoaiMonAn(Map<String, String> params, int idLoaiMon, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();

        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rM = q.from(Monan.class);
        Root rL = q.from(Loaimonan.class);
        Root rM_L = q.from(MonanLoaimonan.class);

        q.select(rM);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();

            Predicate p1 = b.equal(rM.get("active").as(Boolean.class), b.literal(true));
            Predicate p2 = b.equal(rM.get("trangthai").as(Boolean.class), b.literal(true));
            Predicate p3 = b.equal(rL.get("active").as(Boolean.class), b.literal(true));
            Predicate p4 = b.equal(rM.get("idmonan"), rM_L.get("idmonan"));
            Predicate p5 = b.equal(rM_L.get("idloaimonan"), rL.get("idloaimonan"));
            Predicate p6 = b.equal(rM_L.get("idloaimonan").get("idloaimonan").as(String.class), idLoaiMon);

            predicates.add(p1);
            predicates.add(p2);
            predicates.add(p3);
            predicates.add(p4);
            predicates.add(p5);
            predicates.add(p6);

            q.where(predicates.toArray(new Predicate[]{}));
        }
        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public List<Binhluan> getBinhLuanMonAn(int idMonAn) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Binhluan> q = b.createQuery(Binhluan.class);
        Root<Binhluan> root = q.from(Binhluan.class);
        q.select(root);
        q.where(b.equal(root.get("idmonan").get("idmonan"), idMonAn));
        q.orderBy(b.desc(root.get("thoigian")));
        Query query = session.createQuery(q);
        return query.getResultList();
        }
    
    public List<Object[]> thongKeDoanhThuMonAn(String kw, Date tungay, Date denngay,String iduser) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();

        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rMonan = q.from(Monan.class);
        Root rDonhang = q.from(Donhang.class);
        Root rDonhangMonan = q.from(DonhangMonan.class);
        Root rCuahang = q.from(Cuahang.class);
        q.where();
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(b.equal(rDonhangMonan.get("iddonhang"), rDonhang.get("iddonhang")));
        predicates.add(b.equal(rDonhangMonan.get("idmonan"), rMonan.get("idmonan")));
        predicates.add(b.equal(rMonan.get("idcuahang"), rCuahang.get("idcuahang")));
        q.multiselect(rDonhangMonan.get("idmonan"), rMonan.get("tenmonan"),
                b.sum(rDonhangMonan.get("tongtien")), rDonhang.get("ngaytao"));

        if (kw != null && !kw.isEmpty()) {
            predicates.add(b.like(rMonan.get("tenmonan"), String.format("%%%s%%", kw)));
        }
        if (tungay != null) {
            predicates.add(b.greaterThanOrEqualTo(rDonhang.get("ngaytao"), tungay));
        }
        if (denngay != null) {
            predicates.add(b.lessThanOrEqualTo(rDonhang.get("ngaytao"), denngay));
        }
        predicates.add(b.equal(rCuahang.get("iduser").get("id"),iduser ));
        predicates.add(b.equal(rDonhang.get("trangthai"), "thanhcong"));
        
        q.where((Predicate[]) predicates.toArray(Predicate[]::new));
        q.groupBy(rDonhangMonan.get("idmonan"));
        q.orderBy(b.desc(b.sum(rDonhangMonan.get("tongtien"))));
        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public Binhluan themBinhLuanMonAn(String noiDung, int idMonAn) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Binhluan b = new Binhluan();
        b.setNoidung(noiDung);
        b.setIdmonan(this.getMonAnByID(idMonAn));

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        b.setIduser(this.userRepository.getUserByTaiKhoan(authentication.getName().toString()));
        session.save(b);
        return b;
    }
    
    public List<Object[]> thongKeDoanhThuMonAnTheoThang(int thang, int nam,String iduser) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();

        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rMonan = q.from(Monan.class);
        Root rDonhang = q.from(Donhang.class);
        Root rDonhangMonan = q.from(DonhangMonan.class);
        Root rCuahang = q.from(Cuahang.class);
        q.where();
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(b.equal(rDonhangMonan.get("iddonhang"), rDonhang.get("iddonhang")));
        predicates.add(b.equal(rDonhangMonan.get("idmonan"), rMonan.get("idmonan")));
        predicates.add(b.equal(rMonan.get("idcuahang"), rCuahang.get("idcuahang")));
        q.multiselect(rMonan.get("tenmonan"), b.function("MONTH", Integer.class, rDonhang.get("ngaytao")),
                b.function("YEAR", Integer.class, rDonhang.get("ngaytao")),
                b.sum(rDonhangMonan.get("tongtien")));

        predicates.add(b.equal(b.function("MONTH", Integer.class, rDonhang.get("ngaytao")), thang));
        predicates.add(b.equal(b.function("YEAR", Integer.class, rDonhang.get("ngaytao")), nam));
        predicates.add(b.equal(rCuahang.get("iduser").get("id"), iduser));
        predicates.add(b.equal(rDonhang.get("trangthai"), "thanhcong"));
        
        q.where((Predicate[]) predicates.toArray(Predicate[]::new));
        q.groupBy(b.function("MONTH", Integer.class, rDonhang.get("ngaytao")), rDonhangMonan.get("idmonan"));
        q.orderBy(b.desc(b.sum(rDonhangMonan.get("tongtien"))));
        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public List<Object[]> thongKeDoanhThuMonAnTheoQuy(int quy, int nam,String iduser) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();

        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rMonan = q.from(Monan.class);
        Root rDonhang = q.from(Donhang.class);
        Root rDonhangMonan = q.from(DonhangMonan.class);
        Root rCuahang = q.from(Cuahang.class);
        q.where();
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(b.equal(rDonhangMonan.get("iddonhang"), rDonhang.get("iddonhang")));
        predicates.add(b.equal(rDonhangMonan.get("idmonan"), rMonan.get("idmonan")));
        predicates.add(b.equal(rMonan.get("idcuahang"), rCuahang.get("idcuahang")));
        q.multiselect(rDonhangMonan.get("idmonan"), rMonan.get("tenmonan"),
                b.sum(rDonhangMonan.get("tongtien")), rDonhang.get("ngaytao"));
        predicates.add(b.equal(b.function("QUARTER", Integer.class, rDonhang.get("ngaytao")), quy));
        predicates.add(b.equal(b.function("YEAR", Integer.class, rDonhang.get("ngaytao")), nam));
        predicates.add(b.equal(rCuahang.get("iduser").get("id"), iduser));
        predicates.add(b.equal(rDonhang.get("trangthai"), "thanhcong"));
        
        q.where((Predicate[]) predicates.toArray(Predicate[]::new));
        q.groupBy(rDonhangMonan.get("idmonan"));
        q.orderBy(b.desc(b.sum(rDonhangMonan.get("tongtien"))));
        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public List<Object[]> thongKeDoanhThuMonAnTheoNam(int nam,String iduser) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();

        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rMonan = q.from(Monan.class);
        Root rDonhang = q.from(Donhang.class);
        Root rDonhangMonan = q.from(DonhangMonan.class);
        Root rCuahang = q.from(Cuahang.class);
        q.where();
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(b.equal(rDonhangMonan.get("iddonhang"), rDonhang.get("iddonhang")));
        predicates.add(b.equal(rDonhangMonan.get("idmonan"), rMonan.get("idmonan")));
        predicates.add(b.equal(rMonan.get("idcuahang"), rCuahang.get("idcuahang")));
        q.multiselect(rDonhangMonan.get("idmonan"), rMonan.get("tenmonan"),
                b.sum(rDonhangMonan.get("tongtien")), rDonhang.get("ngaytao"));
        predicates.add(b.equal(b.function("YEAR", Integer.class, rDonhang.get("ngaytao")), nam));
        predicates.add(b.equal(rCuahang.get("iduser").get("id"), iduser));
        predicates.add(b.equal(rDonhang.get("trangthai"), "thanhcong"));
        
        q.where((Predicate[]) predicates.toArray(Predicate[]::new));
        q.groupBy(rDonhangMonan.get("idmonan"));
        q.orderBy(b.desc(b.sum(rDonhangMonan.get("tongtien"))));
        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public boolean xoaMonAn(int idmonan) {
         Session s = sessionFactory.getObject().getCurrentSession();
        try {
            s.delete(s.get(Monan.class, idmonan));
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
            
        }
        return false;
    }

}
