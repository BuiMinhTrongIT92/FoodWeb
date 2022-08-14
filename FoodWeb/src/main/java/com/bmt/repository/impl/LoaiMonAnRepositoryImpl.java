/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.repository.impl;

import com.bmt.pojo.Loaimonan;
import com.bmt.pojo.Monan;
import com.bmt.repository.LoaiMonAnRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
public class LoaiMonAnRepositoryImpl implements LoaiMonAnRepository {

    @Autowired
    LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Loaimonan> getLoaiMonAn() {
        Session s = sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM Loaimonan WHERE active = true");
        return q.getResultList();
    }

    @Override
    public List<Loaimonan> timkiemLoaiMonAn(Map<String, String> params, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Loaimonan> q = b.createQuery(Loaimonan.class);
        Root<Loaimonan> root = q.from(Loaimonan.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();

            Predicate p1 = b.equal(root.get("active").as(Boolean.class), b.literal(true));
            predicates.add(p1);
            
            String tukhoa = params.get("tukhoa");
            if (tukhoa != null && !tukhoa.isEmpty()) {
                Predicate p = b.like(root.get("tenloai").as(String.class), String.format("%%%s%%", tukhoa));
                predicates.add(p);
            }
            
            q.where((Predicate[]) predicates.toArray(Predicate[]::new));
        }
        Query query = session.createQuery(q);
        
        return query.getResultList();
    }
}
