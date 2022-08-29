/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.repository.impl;

import com.bmt.pojo.Donhang;
import com.bmt.pojo.Giohang;
import com.bmt.pojo.DonhangMonan;
import com.bmt.pojo.Loaimonan;
import com.bmt.pojo.User;
import com.bmt.repository.DonHangMonAnRepository;
import com.bmt.service.CuaHangService;
import com.bmt.service.MonAnService;
import com.bmt.service.ThanhToanService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
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
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ACER
 */
@Repository
@Transactional
public class DonHangMonAnRepositoryImpl implements DonHangMonAnRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Autowired
    private MonAnService monAnService;

    @Autowired
    private ThanhToanService thanhToanService;

    @Autowired
    private CuaHangService cuaHangService;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean themDonHang(Map<Integer, Giohang> gio, User user) {
        try {
            Session session = sessionFactory.getObject().getCurrentSession();
            try {
                Set<String> idCHSet = new HashSet<>();
                if (gio != null) {
                    for (Giohang g : gio.values()) {
                        String idCH = this.thanhToanService.idCuaHang(g.getIdmonan());
                        idCHSet.add(idCH);
                    }
                    for (String idCh : idCHSet) {
                        Donhang dh = new Donhang();
                        UUID uuid = UUID.randomUUID();
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                        Date date;
                        date = formatter.parse(String.valueOf(java.time.LocalDateTime.now()));
                        dh.setIddonhang(String.valueOf(uuid));
                        dh.setNgaytao(date);
                        dh.setTrangthai("choduyet");
                        dh.setIduser(user);
                        Double KQ = 0.0;
                        Double tienvanchuyen = Double.valueOf(this.thanhToanService.tienVanChuyen(idCh));
                        KQ = tienvanchuyen;
                        Double tongTien = 0.0;
                        for (Giohang ma : gio.values()) {
                            if (this.thanhToanService.idCuaHang(ma.getIdmonan()) == idCh) {
                                tongTien += ma.getTongtien();
                                dh.setTongtien(tongTien + KQ);
                            }
                        }
                        dh.setIdcuahang(this.cuaHangService.getCuaHangByID(idCh));
                        session.save(dh);
                        for (Giohang g : gio.values()) {
                            if (this.thanhToanService.idCuaHang(g.getIdmonan()) == idCh) {
                                DonhangMonan hdma = new DonhangMonan();
                                hdma.setSoluong(g.getSoluong().intValue());
                                hdma.setGia(g.getGia());
                                hdma.setTongtien(g.getTongtien());
                                hdma.setIddonhang(dh);
                                hdma.setIdmonan(this.monAnService.getMonAnByID(g.getIdmonan()));
                                session.save(hdma);
                            }

                        }
                    }
                }

            } catch (ParseException ex) {
                Logger.getLogger(DonHangMonAnRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }

        return false;
    }

//    public boolean themDonHang(Map<Integer, Giohang> gio, User user) {
//        try {
//            Session session = sessionFactory.getObject().getCurrentSession();
//            Donhang dh = new Donhang();
//            UUID uuid = UUID.randomUUID();
//            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//            Date date;
//            try {
//                date = formatter.parse(String.valueOf(java.time.LocalDateTime.now()));
//                dh.setIddonhang(String.valueOf(uuid));
//                dh.setNgaytao(date);
//                dh.setTrangthai("choduyet");
//                dh.setUser(user);
//                Double tongTien = 0.0;
//                for (Giohang g : gio.values()) {
//                    tongTien += g.getTongtien();
//                }
//
//                Set<String> idCHSet = new HashSet<>();
//                Double KQ = 0.0;
//                if (gio != null) {
//                    for (Giohang g : gio.values()) {
//                        String idCH = this.thanhToanService.idCuaHang(g.getIdmonan());
//                        idCHSet.add(idCH);
//                    }
//                    for (String idCh : idCHSet) {
//                        Double tienvanchuyen = Double.valueOf(this.thanhToanService.tienVanChuyen(idCh));
//                        KQ += tienvanchuyen;
//                    }
//                }
//
//                dh.setTongtien(tongTien+KQ);
//                session.save(dh);
//            } catch (ParseException ex) {
//                Logger.getLogger(DonHangMonAnRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//            for (Giohang g : gio.values()) {
//                DonhangMonan hdma = new DonhangMonan();
//                hdma.setSoluong(g.getSoluong().intValue());
//                hdma.setGia(g.getGia());
//                hdma.setTongtien(g.getTongtien());
//                hdma.setIddonhang(dh);
//                hdma.setIdmonan(this.monAnService.getMonAnByID(g.getIdmonan()));
//                session.save(hdma);
//            }
//            return true;
//        } catch (HibernateException ex) {
//            ex.printStackTrace();
//        }
//
//        return false;
//    }
    @Override
    public List<Donhang> getDonHangByIDCuaHang(String idcuahang) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Donhang> q = b.createQuery(Donhang.class);
        Root<Donhang> root = q.from(Donhang.class);
        q.select(root);
        List<Predicate> predicates = new ArrayList<>();
        Predicate p1 = b.equal(root.get("idcuahang").get("idcuahang").as(String.class), idcuahang);
        predicates.add(p1);
        q.where((Predicate[]) predicates.toArray(Predicate[]::new));
        Query query = session.createQuery(q);

        return query.getResultList();
    }

    @Override
    public List<DonhangMonan> getDetailDonHang(String iddonhang) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<DonhangMonan> q = b.createQuery(DonhangMonan.class);
        Root<DonhangMonan> root = q.from(DonhangMonan.class);
        q.select(root);
        List<Predicate> predicates = new ArrayList<>();
        Predicate p1 = b.equal(root.get("iddonhang").get("iddonhang").as(String.class), iddonhang);
        predicates.add(p1);
        q.where((Predicate[]) predicates.toArray(Predicate[]::new));
        Query query = session.createQuery(q);

        return query.getResultList();
    }

    @Override
    public boolean suaDonHang(String iddonhang, String trangthai) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            Donhang dh = session.get(Donhang.class, iddonhang);
            dh.setTrangthai(trangthai);
            session.save(dh);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Object[]> demSoDonTheoThang(String idcuahang, int thang, int nam) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        Root<Donhang> root = q.from(Donhang.class);
        q.multiselect(root.get("iddonhang")).distinct(true);
        List<Predicate> predicates = new ArrayList<>();
        Predicate p1 = b.equal(root.get("idcuahang").get("idcuahang").as(String.class), idcuahang);
        Predicate p2 = b.equal(b.function("MONTH", Integer.class, root.get("ngaytao")), thang);
        Predicate p3 = b.equal(b.function("YEAR", Integer.class, root.get("ngaytao")), nam);
        Predicate p4 = b.equal(root.get("trangthai"), "thanhcong");

        predicates.add(p1);
        predicates.add(p2);
        predicates.add(p3);
        predicates.add(p4);
        q.where((Predicate[]) predicates.toArray(Predicate[]::new));
        Query query = session.createQuery(q);

        return query.getResultList();
    }

    @Override
    public List<Object[]> demSoKhachHangTheoThang(String idcuahang, int thang, int nam) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        Root<Donhang> root = q.from(Donhang.class);
        q.multiselect(root.get("iduser")).distinct(true);
        List<Predicate> predicates = new ArrayList<>();
        Predicate p1 = b.equal(root.get("idcuahang").get("idcuahang").as(String.class), idcuahang);
        Predicate p2 = b.equal(b.function("MONTH", Integer.class, root.get("ngaytao")), thang);
        Predicate p3 = b.equal(b.function("YEAR", Integer.class, root.get("ngaytao")), nam);
        Predicate p4 = b.equal(root.get("trangthai"), "thanhcong");

        predicates.add(p1);
        predicates.add(p2);
        predicates.add(p3);
        predicates.add(p4);
        q.where((Predicate[]) predicates.toArray(Predicate[]::new));
        Query query = session.createQuery(q);

        return query.getResultList();

    }

    @Override
    public List<Object[]> demSoDonTheoQuy(String idcuahang, int quy, int nam) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        Root<Donhang> root = q.from(Donhang.class);
        q.multiselect(root.get("iddonhang")).distinct(true);
        List<Predicate> predicates = new ArrayList<>();
        Predicate p1 = b.equal(root.get("idcuahang").get("idcuahang").as(String.class), idcuahang);
        Predicate p2 = b.equal(b.function("QUARTER", Integer.class, root.get("ngaytao")), quy);
        Predicate p3 = b.equal(b.function("YEAR", Integer.class, root.get("ngaytao")), nam);
        Predicate p4 = b.equal(root.get("trangthai"), "thanhcong");

        predicates.add(p1);
        predicates.add(p2);
        predicates.add(p3);
        predicates.add(p4);
        q.where((Predicate[]) predicates.toArray(Predicate[]::new));
        Query query = session.createQuery(q);

        return query.getResultList();
    }

    @Override
    public List<Object[]> demSoDonTheoNam(String idcuahang, int nam) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        Root<Donhang> root = q.from(Donhang.class);
        q.multiselect(root.get("iddonhang")).distinct(true);
        List<Predicate> predicates = new ArrayList<>();
        Predicate p1 = b.equal(root.get("idcuahang").get("idcuahang").as(String.class), idcuahang);
        Predicate p3 = b.equal(b.function("YEAR", Integer.class, root.get("ngaytao")), nam);
        Predicate p4 = b.equal(root.get("trangthai"), "thanhcong");

        predicates.add(p1);
        predicates.add(p3);
        predicates.add(p4);
        q.where((Predicate[]) predicates.toArray(Predicate[]::new));
        Query query = session.createQuery(q);

        return query.getResultList();
    }

    @Override
    public List<Object[]> demSoKhachHangTheoQuy(String idcuahang, int quy, int nam) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        Root<Donhang> root = q.from(Donhang.class);
        q.multiselect(root.get("iduser")).distinct(true);
        List<Predicate> predicates = new ArrayList<>();
        Predicate p1 = b.equal(root.get("idcuahang").get("idcuahang").as(String.class), idcuahang);
        Predicate p2 = b.equal(b.function("QUARTER", Integer.class, root.get("ngaytao")), quy);
        Predicate p3 = b.equal(b.function("YEAR", Integer.class, root.get("ngaytao")), nam);
        Predicate p4 = b.equal(root.get("trangthai"), "thanhcong");

        predicates.add(p1);
        predicates.add(p2);
        predicates.add(p3);
        predicates.add(p4);
        q.where((Predicate[]) predicates.toArray(Predicate[]::new));
        Query query = session.createQuery(q);

        return query.getResultList();
    }

    @Override
    public List<Object[]> demSoKhachHangTheoNam(String idcuahang, int nam) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        Root<Donhang> root = q.from(Donhang.class);
        q.multiselect(root.get("iduser")).distinct(true);
        List<Predicate> predicates = new ArrayList<>();
        Predicate p1 = b.equal(root.get("idcuahang").get("idcuahang").as(String.class), idcuahang);
        Predicate p3 = b.equal(b.function("YEAR", Integer.class, root.get("ngaytao")), nam);
        Predicate p4 = b.equal(root.get("trangthai"), "thanhcong");

        predicates.add(p1);
        predicates.add(p3);
        predicates.add(p4);
        q.where((Predicate[]) predicates.toArray(Predicate[]::new));
        Query query = session.createQuery(q);

        return query.getResultList();
    }
}
