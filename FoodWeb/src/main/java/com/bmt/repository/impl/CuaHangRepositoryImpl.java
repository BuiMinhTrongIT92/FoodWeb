/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.repository.impl;

import com.bmt.pojo.Binhluan;
import com.bmt.pojo.Cuahang;
import com.bmt.pojo.Danhgia;
import com.bmt.pojo.Menuthucan;
import com.bmt.pojo.MenuthucanMonan;
import com.bmt.pojo.Monan;
import com.bmt.pojo.MonanLoaimonan;
import com.bmt.pojo.User;
import com.bmt.repository.CuaHangRepository;
import com.bmt.repository.DanhGiaRepository;
import com.bmt.repository.UserRepository;
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
public class CuaHangRepositoryImpl implements CuaHangRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Autowired
    private Environment env;
    
    @Autowired
    private UserRepository userRepository;

    
    
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
                b.quot(b.sum(root1.get("sao")), b.count(root1.get("iddanhgia"))));

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
            s.save(cuahang);
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean capNhatCuaHang(Cuahang cuahang) {
        Session s = sessionFactory.getObject().getCurrentSession();
        try {
            s.update(cuahang);
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public List<Binhluan> getBinhLuanCuaHang(String idCuaHang) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Binhluan> q = b.createQuery(Binhluan.class);
        Root<Binhluan> root = q.from(Binhluan.class);
        q.select(root);
        q.where(b.equal(root.get("idcuahang").get("idcuahang"), idCuaHang));
        q.orderBy(b.desc(root.get("thoigian")));
        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public Binhluan themBinhLuanCuaHang(String noiDung, String idCuaHang) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Binhluan b = new Binhluan();
        b.setNoidung(noiDung);
        b.setIdcuahang(this.getCuaHangByID(idCuaHang));
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        b.setIduser(this.userRepository.getUserByTaiKhoan(authentication.getName().toString()));
        session.save(b);
        return b;
    }

    @Override
    public List<Cuahang> getCuaHang(Map<String, String> params, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Cuahang> q = b.createQuery(Cuahang.class);
        Root<Cuahang> root = q.from(Cuahang.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();

            Predicate p1 = b.equal(root.get("active").as(Boolean.class), b.literal(true));
            predicates.add(p1);
            
            String tenCuaHang = params.get("tenCuaHang");
            if (tenCuaHang != null && !tenCuaHang.isEmpty()) {
                Predicate p = b.like(root.get("tencuahang").as(String.class), String.format("%%%s%%", tenCuaHang));
                predicates.add(p);
            }
            q.where((Predicate[]) predicates.toArray(Predicate[]::new));
        }
        Query query = session.createQuery(q);
        if (page > 0) {
            int size = Integer.parseInt(env.getProperty("cuahang_page.size").toString());
            int start = (page - 1) * size;
            query.setFirstResult(start);
            query.setMaxResults(size);
        }
        return query.getResultList();
    }
    
    public List<Cuahang> getAllCuaHang() {
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Cuahang> q = b.createQuery(Cuahang.class);
        Root root = q.from(Cuahang.class);
        q.select(root);
        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public boolean xoaCuaHang(String idcuahang) {
        Session s = sessionFactory.getObject().getCurrentSession();
        try {
            s.delete(s.get(Cuahang.class, idcuahang));
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public int demTatCaCuaHang() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("SELECT Count(*) FROM Cuahang WHERE active = 1");

        return Integer.parseInt(q.getSingleResult().toString());
    }

    @Override
    public Cuahang getCuahangByIdMenu(int idMenu) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        Root rMenu = q.from(Menuthucan.class);
        Root rCuahang = q.from(Cuahang.class);
        List<Predicate> predicates = new ArrayList<>();
        Predicate p1 = b.equal(rMenu.get("idcuahang").get("idcuahang").as(String.class), rCuahang.get("idcuahang"));
        Predicate p2 = b.equal(rMenu.get("idmenuthucan"), idMenu);
        predicates.add(p1);
        predicates.add(p2);
        q.where((Predicate[]) predicates.toArray(Predicate[]::new));
        q.select(rCuahang);
        Query query = session.createQuery(q);
        return (Cuahang) query.getSingleResult();
    }

    @Override
    public List<Danhgia> getDanhGiaCuaHang(String idCuaHang) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Danhgia> q = b.createQuery(Danhgia.class);
        Root<Danhgia> root = q.from(Danhgia.class);
        q.select(root);
        q.where(b.equal(root.get("idcuahang").get("idcuahang"), idCuaHang));
        q.orderBy(b.desc(root.get("thoigian")));
        Query query = session.createQuery(q).setMaxResults(6);
        return query.getResultList();
    }

    @Override
    public Danhgia themDanhGiaCuaHang(double soLuongSao, String idCuaHang) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Danhgia d = new Danhgia();
        d.setSao(soLuongSao);
        d.setIdcuahang(this.getCuaHangByID(idCuaHang));
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        d.setIduser(this.userRepository.getUserByTaiKhoan(authentication.getName().toString()));
        session.save(d);
        return d;
    }
}