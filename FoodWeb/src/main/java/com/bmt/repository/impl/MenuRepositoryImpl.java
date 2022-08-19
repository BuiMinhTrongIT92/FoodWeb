/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.repository.impl;

import com.bmt.pojo.Loaimonan;
import com.bmt.pojo.Menuthucan;
import com.bmt.pojo.Monan;
import com.bmt.repository.MenuRepository;
import java.util.ArrayList;
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
public class MenuRepositoryImpl implements MenuRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public boolean themMenu(Menuthucan menu) {
        Session s = sessionFactory.getObject().getCurrentSession();
        try {
            s.save(menu);
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public List<Menuthucan> getAllMenuByIDCuahang(String idcuahang) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Menuthucan> q = b.createQuery(Menuthucan.class);
        Root<Menuthucan> root = q.from(Menuthucan.class);
        q.select(root);
        Predicate p1 = b.equal(root.get("idcuahang").get("idcuahang").as(String.class), idcuahang);
        q.where(p1);

        Query query = session.createQuery(q);

        return query.getResultList();
    }

    @Override
    public Menuthucan getAllMenuByID(int idmenu) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Menuthucan> q = b.createQuery(Menuthucan.class);
        Root<Menuthucan> root = q.from(Menuthucan.class);
        q.select(root);
        List<Predicate> predicates = new ArrayList<>();
        Predicate p3 = b.equal(root.get("idmenuthucan").as(Integer.class), idmenu);
        predicates.add(p3);
        q.where((Predicate[]) predicates.toArray(Predicate[]::new));
        Query query = session.createQuery(q);
        return (Menuthucan) query.getSingleResult();
    }

    @Override
    public boolean suaMenu(Menuthucan menu) {
        Session s = sessionFactory.getObject().getCurrentSession();
        try {
            s.update(menu);
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean xoaMenu(Menuthucan menu) {
        Session s = sessionFactory.getObject().getCurrentSession();
        try {
            s.delete(menu);
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    

}
