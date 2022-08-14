/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.repository.impl;

import com.bmt.pojo.Cuahang;
import com.bmt.pojo.Danhgia;
import com.bmt.pojo.Giohang;
import com.bmt.pojo.Monan;
import com.bmt.pojo.Quidinh;
import com.bmt.repository.ThanhToanRepository;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
public class ThanhToanRepositoryImpl implements ThanhToanRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public String tienVanChuyen(String idcuahangg) {
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Quidinh> q = b.createQuery(Quidinh.class);
        Root qdroot = q.from(Quidinh.class);
        q.select(qdroot);
        List<Predicate> predicates = new ArrayList<>();
        Predicate p1 = b.equal(qdroot.get("idcuahang").get("idcuahang"), idcuahangg);
        Predicate p2 = b.equal(qdroot.get("active").as(Boolean.class), b.literal(true));
        predicates.add(p1);
        predicates.add(p2);
        q.where(predicates.toArray(new Predicate[]{}));
        Query query = session.createQuery(q);
        Quidinh kq = (Quidinh) query.getSingleResult();
        return kq.getNoidung();
    }
    
    @Override
    public String idCuaHang(int idmonan) {
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Monan> q = b.createQuery(Monan.class);
        Root monan = q.from(Monan.class);
        q.select(monan);
        List<Predicate> predicates = new ArrayList<>();
        Predicate p1 = b.equal(monan.get("idmonan"), idmonan);
        Predicate p2 = b.equal(monan.get("active").as(Boolean.class), b.literal(true));
        Predicate p3 = b.equal(monan.get("trangthai").as(Boolean.class), b.literal(true));
        predicates.add(p1);
        predicates.add(p2);
        predicates.add(p3);
        q.where(predicates.toArray(new Predicate[]{}));
        Query query = session.createQuery(q);
        Monan kq = (Monan) query.getSingleResult();
        return kq.getIdcuahang().getIdcuahang();
    }

}
