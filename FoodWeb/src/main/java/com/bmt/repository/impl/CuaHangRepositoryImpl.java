/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.repository.impl;

import com.bmt.pojo.Cuahang;
import com.bmt.pojo.Danhgia;
import com.bmt.pojo.Monan;
import com.bmt.pojo.MonanLoaimonan;
import com.bmt.repository.CuaHangRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
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
                b.sum(root1.get("sao")));

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
    public List<Object[]> getCuaHangTheoMonAnTimKiem(Map<String, String> params, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rM = q.from(Monan.class);
        Root rC = q.from(Cuahang.class);
        q.select(rM);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();

            Predicate p1 = b.equal(rM.get("active").as(Boolean.class), b.literal(true));
            Predicate p2 = b.equal(rM.get("trangthai").as(Boolean.class), b.literal(true));
            predicates.add(p1);
            predicates.add(p2);

            String tukhoa = params.get("tukhoa");
            if (tukhoa != null && !tukhoa.isEmpty()) {
                Predicate p = b.like(rM.get("tenmonan").as(String.class), String.format("%%%s%%", tukhoa));
                predicates.add(p);
            }
            
//            String tu = params.get("tu");
//            if (tu != null && !tu.isEmpty()) {
//                Predicate p = b.like(rM.get("tenmonan").as(String.class), String.format("%%%s%%", tu));
//                predicates.add(p);
//            }
            
            q.where(predicates.toArray(new Predicate[]{}));
        }

        q.where(b.equal(rM.get("idcuahang"), rC.get("idcuahang")));
        q.distinct(true).select(rC.get("tencuahang"));

        Query query = session.createQuery(q);
        return query.getResultList();
    }
}

