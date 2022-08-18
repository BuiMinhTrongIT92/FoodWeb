/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.repository.impl;

import com.bmt.pojo.MenuthucanMonan;
import com.bmt.pojo.Monan;
import com.bmt.repository.MenuThucAnRepository;
import java.util.ArrayList;
import java.util.Date;
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
public class MenuThucAnRepositoryImpl implements MenuThucAnRepository{
    
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
    
}
