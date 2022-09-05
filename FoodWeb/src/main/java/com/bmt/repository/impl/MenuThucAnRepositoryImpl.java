/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.repository.impl;

import com.bmt.pojo.Cuahang;
import com.bmt.pojo.Menuthucan;
import com.bmt.pojo.MenuthucanMonan;
import com.bmt.pojo.Monan;
import com.bmt.repository.MenuThucAnRepository;
import java.util.ArrayList;
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
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ACER
 */
@Repository
@Transactional
public class MenuThucAnRepositoryImpl implements MenuThucAnRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<MenuthucanMonan> getMonAnByMenu(int idmenu) {
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<MenuthucanMonan> q = b.createQuery(MenuthucanMonan.class);
        Root root = q.from(MenuthucanMonan.class);
        q.select(root);
        List<Predicate> predicates = new ArrayList<>();
        Predicate p1 = b.equal(root.get("idmenuthucan").get("idmenuthucan").as(Integer.class),
                idmenu);
        predicates.add(p1);
        q.where(predicates.toArray(new Predicate[]{}));
        Query query = session.createQuery(q);

        return query.getResultList();
    }

    @Override
    public boolean themMonAnVaoMenu(MenuthucanMonan MenuthucanMonan) {
        Session s = sessionFactory.getObject().getCurrentSession();
        try {
            s.save(MenuthucanMonan);
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean xoaMonAnKhoiMenu(MenuthucanMonan MenuthucanMonan) {
        Session s = sessionFactory.getObject().getCurrentSession();
        try {
            s.delete(MenuthucanMonan);
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public MenuthucanMonan getMenuthucanMonanByID(int id) {
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<MenuthucanMonan> q = b.createQuery(MenuthucanMonan.class);
        Root root = q.from(MenuthucanMonan.class);
        q.select(root);
        Predicate p1 = b.equal(root.get("idmenuthucanmonan").as(Integer.class),
                id);
        q.where(p1);
        Query query = session.createQuery(q);
        return (MenuthucanMonan) query.getSingleResult();
    }

    @Override
    public List<Object[]> getMenuthucan(Map<String, String> params, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        Root rCuahang = q.from(Cuahang.class);
        Root rMenu = q.from(Menuthucan.class);
        Date now = new Date();
        List<Predicate> predicates = new ArrayList<>();
        Predicate p1 = b.equal(rMenu.get("active").as(Boolean.class), b.literal(true));
        Predicate p2 = b.equal(rMenu.get("idcuahang"), rCuahang.get("idcuahang"));
        Predicate p3 = b.lessThanOrEqualTo(rMenu.get("thoidiembatdau").as(Date.class), now);
        Predicate p4 = b.greaterThanOrEqualTo(rMenu.get("thoidiemketthuc").as(Date.class), now);
        predicates.add(p1);
        predicates.add(p2);
        predicates.add(p3);
        predicates.add(p4);
        q.where((Predicate[]) predicates.toArray(Predicate[]::new));
        q.multiselect(rCuahang.get("logo"), rCuahang.get("tencuahang"), rMenu.get("idmenuthucan"), rCuahang.get("idcuahang"), rMenu.get("tenmenu"));
        q.groupBy(rMenu.get("idmenuthucan"));
        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public List<Object[]> getMonAnTrongMenu(int idMenu) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        Root rMonan = q.from(Monan.class);
        Root rMenu_MonAn = q.from(MenuthucanMonan.class);
        Root rMenu = q.from(Menuthucan.class);
        Root rCuahang = q.from(Cuahang.class);
        Date now = new Date();
        List<Predicate> predicates = new ArrayList<>();
        Predicate p1 = b.equal(rMenu_MonAn.get("idmonan"), rMonan.get("idmonan"));
        Predicate p2 = b.equal(rMenu.get("idmenuthucan"), rMenu_MonAn.get("idmenuthucan"));
        Predicate p3 = b.equal(rMenu.get("idcuahang").get("idcuahang").as(Integer.class), rCuahang.get("idcuahang"));
        Predicate p4 = b.equal(rMenu.get("idmenuthucan"), idMenu);
        Predicate p5 = b.equal(rMonan.get("active").as(Boolean.class), b.literal(true));
        Predicate p6 = b.equal(rMonan.get("trangthai").as(Boolean.class), b.literal(true));
        Predicate p7 = b.lessThanOrEqualTo(rMonan.get("thoidiemban").as(Date.class), now);
        Predicate p8 = b.greaterThanOrEqualTo(rMonan.get("thoidiemketthuc").as(Date.class), now);
        predicates.add(p1);
        predicates.add(p2);
        predicates.add(p3);
        predicates.add(p4);
        predicates.add(p5);
        predicates.add(p6);
        predicates.add(p7);
        predicates.add(p8);
        q.where((Predicate[]) predicates.toArray(Predicate[]::new));
        q.multiselect(rMonan.get("tenmonan"), rMonan.get("gia"), rMonan.get("anhmonan"), rMonan.get("idmonan")).distinct(true);
        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public Menuthucan getTenMenuByIdMenu(int idMenu) {
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Menuthucan> q = b.createQuery(Menuthucan.class);
        Root root = q.from(Menuthucan.class);
        q.select(root);
        List<Predicate> predicates = new ArrayList<>();
        Predicate p1 = b.equal(root.get("idmenuthucan").as(Integer.class), idMenu);
        predicates.add(p1);
        q.where(predicates.toArray(new Predicate[]{}));
        Query query = session.createQuery(q);
        return (Menuthucan) query.getSingleResult();
    }
}
