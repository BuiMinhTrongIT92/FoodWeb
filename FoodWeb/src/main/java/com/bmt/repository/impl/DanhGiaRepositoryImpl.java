/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.repository.impl;

import com.bmt.pojo.Danhgia;
import com.bmt.repository.DanhGiaRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author NhatTien
 */
@Repository
@Transactional
@PropertySource("classpath:template.properties")
public class DanhGiaRepositoryImpl implements DanhGiaRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public int demDanhGiaMonAn(int idMonAn) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Danhgia> q = b.createQuery(Danhgia.class);
        Root<Danhgia> root = q.from(Danhgia.class);
        List<Predicate> predicates = new ArrayList<>();
        Predicate p = b.equal(root.get("idmonan").get("idmonan").as(Integer.class), idMonAn);
        predicates.add(p);
        q.where((Predicate[]) predicates.toArray(Predicate[]::new));
        Query query = session.createQuery(q);
        return query.getResultList().size();
    }

    @Override
    public double tongSoSaoMonAn(int idMonAn) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Double> q = b.createQuery(Double.class);
        Root<Danhgia> root = q.from(Danhgia.class);
        List<Predicate> predicates = new ArrayList<>();
        Predicate p = b.equal(root.get("idmonan").get("idmonan").as(Integer.class), idMonAn);
        predicates.add(p);
        q.select(b.sum(root.get("sao")).as(Double.class)).where((Predicate[]) predicates.toArray(Predicate[]::new));
        Query<Double> query = session.createQuery(q);
        return Double.parseDouble(query.getSingleResult().toString());
    }

    @Override
    public int demDanhGiaCuaHang(String idCuaHang) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Danhgia> q = b.createQuery(Danhgia.class);
        Root<Danhgia> root = q.from(Danhgia.class);
        List<Predicate> predicates = new ArrayList<>();
        Predicate p = b.equal(root.get("idcuahang").get("idcuahang").as(String.class), idCuaHang);
        predicates.add(p);
        q.where((Predicate[]) predicates.toArray(Predicate[]::new));
        Query query = session.createQuery(q);
        return query.getResultList().size();
    }

    @Override
    public double tongSoSaoCuaHang(String idCuaHang) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Double> q = b.createQuery(Double.class);
        Root<Danhgia> root = q.from(Danhgia.class);
        List<Predicate> predicates = new ArrayList<>();
        Predicate p = b.equal(root.get("idcuahang").get("idcuahang").as(String.class), idCuaHang);
        predicates.add(p);
        q.select(b.sum(root.get("sao")).as(Double.class)).where((Predicate[]) predicates.toArray(Predicate[]::new));
        Query<Double> query = session.createQuery(q);
        return Double.parseDouble(query.getSingleResult().toString());
    }
}
