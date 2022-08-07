/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.repository.impl;

import com.bmt.pojo.Loaimonan;
import com.bmt.repository.LoaiMonAnRepository;
import java.util.List;
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
public class LoaiMonAnRepositoryImpl implements LoaiMonAnRepository{
    
    @Autowired
    LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Loaimonan> getLoaiMonAn() {
        Session s = sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM Loaimonan WHERE active = true");
        return q.getResultList();
    }
}
