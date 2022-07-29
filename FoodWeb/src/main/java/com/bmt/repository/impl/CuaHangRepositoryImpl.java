/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.repository.impl;

import com.bmt.pojo.Cuahang;
import com.bmt.pojo.Danhgia;
import com.bmt.pojo.Monan;
import com.bmt.repository.CuaHangRepository;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
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

    @Override
    public List<Cuahang> getCuaHangNoiBat(int sl) {
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        Root root1 = q.from(Danhgia.class);
        Root root2 = q.from(Cuahang.class);
        q.select(root2);
        q.where(b.equal(root1.get("idcuahang"), root2.get("idcuahang")));
        q.orderBy(b.desc(root1.get("sao")));
        Query query = session.createQuery(q);
        if(sl != 0){
            query.setMaxResults(Integer.parseInt(env.getProperty("content.cuahangphobien").toString()));
        }
        else
            return query.getResultList();
        return query.getResultList();
    }

}