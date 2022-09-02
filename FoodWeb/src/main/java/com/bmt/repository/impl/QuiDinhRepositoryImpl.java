/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.repository.impl;

import com.bmt.pojo.Monan;
import com.bmt.pojo.Quidinh;
import com.bmt.repository.QuiDinhRepository;
import com.bmt.repository.UserRepository;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
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
public class QuiDinhRepositoryImpl implements QuiDinhRepository{

    @Autowired
    LocalSessionFactoryBean sessionFactory;
    
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public List<Quidinh> getAllQuiDinhByUser() {
        Session session = sessionFactory.getObject().getCurrentSession();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        com.bmt.pojo.User u = this.userRepository.getUserByTaiKhoan(authentication.getName());
        Query query = session.createQuery("FROM Quidinh WHERE iduser = '"+u.getId()+"'");
        return query.getResultList();
    }

    @Override
    public Quidinh getAllQuiDinhByID(int id) {
        Session session = sessionFactory.getObject().getCurrentSession();
        Query query = session.createQuery("FROM Quidinh WHERE idquidinh = '"+id+"'");
        return (Quidinh) query.getResultList().get(0);
    }

    @Override
    public boolean themQuiDinh(Quidinh quidinh) {
        Session s = sessionFactory.getObject().getCurrentSession();
        try {
            s.save(quidinh);
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());

        }
        return false;
    }

    @Override
    public boolean suaQuiDinh(Quidinh quidinh) {
        Session s = sessionFactory.getObject().getCurrentSession();
        try {
            s.update(quidinh);
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());

        }
        return false;
    }

    @Override
    public boolean xoaQuiDinh(int idquidinh) {
        Session s = sessionFactory.getObject().getCurrentSession();
        try {
            s.delete(s.get(Quidinh.class, idquidinh));
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());

        }
        return false;
    }
    
}
