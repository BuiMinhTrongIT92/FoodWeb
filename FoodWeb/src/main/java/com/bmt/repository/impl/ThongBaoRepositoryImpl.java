/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.repository.impl;

import com.bmt.pojo.Monan;
import com.bmt.pojo.Thongbao;
import com.bmt.pojo.User;
import com.bmt.repository.ThongBaoRepository;
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
public class ThongBaoRepositoryImpl implements ThongBaoRepository{
    
     @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public boolean taoThongBao(User user) {
        
        Session s = sessionFactory.getObject().getCurrentSession();
        Thongbao tb = new Thongbao();
        tb.setActive(false);
        tb.setNoidung("Đăng ký cửa hàng");
        tb.setIduser(user);
        try {
            s.save(tb);
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean checkThongBao(User user) {
//        Session session = sessionFactory.getObject().getCurrentSession();
//        
//        CriteriaBuilder b = session.getCriteriaBuilder();
//        CriteriaQuery<Thongbao> q = b.createQuery(Thongbao.class);
//        Root root = q.from(Thongbao.class);
//        q.select(root);
//        List<Predicate> predicates = new ArrayList<>();
//        Predicate p1 = b.equal(root.get("iduser").as(User.class),
//                user);
//        Predicate p2 = b.equal(root.get("active").as(Boolean.class),
//                b.literal(true));
//        predicates.add(p1);
//        predicates.add(p2);
//        q.where(predicates.toArray(new Predicate[]{}));
//        Query query = session.createQuery(q);
//        if(query.getResultList().size() > 0){
//            return true;
//        }
        
        return false;
    }
    
    
    
}