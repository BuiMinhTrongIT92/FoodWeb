/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.repository.impl;

import com.bmt.pojo.Cuahang;
import com.bmt.pojo.Danhgia;
import com.bmt.pojo.Monan;
import com.bmt.pojo.Theodoi;
import com.bmt.pojo.User;
import com.bmt.repository.TheoDoiRepository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
public class TheoDoiRepositoryImpl implements TheoDoiRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public Theodoi getTrangThaiTheoDoi(String iduser, String idcuahang) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Theodoi> q = b.createQuery(Theodoi.class);
        Root<Theodoi> root = q.from(Theodoi.class);
        q.select(root);
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(b.equal(root.get("iduser"), session.get(User.class, iduser)));
        predicates.add(b.equal(root.get("idcuahang"), session.get(Cuahang.class, idcuahang)));
        q.where((Predicate[]) predicates.toArray(Predicate[]::new));
        Query query = session.createQuery(q);

        return (Theodoi) query.getSingleResult();
    }

    @Override
    public boolean capNhatTrangThaiTheoDoi(String iduser, String idcuahang) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            Theodoi td = this.getTrangThaiTheoDoi(iduser, idcuahang);
            
                if (td.getTrangthai() == true) {
                    td.setTrangthai(false);
                    session.delete(td);
                } 
                
            return true;
        } catch (Exception e) {
            Theodoi tdnew = new Theodoi();
            tdnew.setIduser(session.get(User.class, iduser));
            tdnew.setIdcuahang(session.get(Cuahang.class, idcuahang));
            tdnew.setTrangthai(true);
            session.save(tdnew);
            return false;
        }
    }

    @Override
    public List<Object[]> getAllUserByIDCuaHang(String idcuahang) {
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        Root root1 = q.from(Theodoi.class);
        Root root2 = q.from(User.class);
        q.select(root2.get("email"));
        List<Predicate> predicates = new ArrayList<>();
        Predicate p1 = b.equal(root1.get("iduser"), root2.get("id"));
        Predicate p2 = b.equal(root1.get("idcuahang").get("idcuahang"), idcuahang);
        predicates.add(p1);
        predicates.add(p2);
        q.where(predicates.toArray(new Predicate[]{}));
        

        Query query = session.createQuery(q);

        return query.getResultList();
    }

}
