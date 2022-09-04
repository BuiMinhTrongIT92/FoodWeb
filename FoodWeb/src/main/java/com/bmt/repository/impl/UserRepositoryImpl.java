/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.repository.impl;

import com.bmt.pojo.Monan;
import com.bmt.pojo.Thongbao;
import com.bmt.pojo.User;
import com.bmt.repository.UserRepository;
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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ACER
 */
@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public boolean addUser(User user) {
        Session s = sessionFactory.getObject().getCurrentSession();
        try {
            s.save(user);
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public List<User> getUsers(String taikhoan) {
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<User> q = b.createQuery(User.class);
        Root root = q.from(User.class);
        q.select(root);
        if (!taikhoan.isEmpty()) {
            List<Predicate> predicates = new ArrayList<>();
            Predicate p1 = b.equal(root.get("taikhoan").as(String.class), taikhoan.trim());
            Predicate p2 = b.equal(root.get("active").as(Boolean.class),
                    b.literal(true));
            predicates.add(p1);
            predicates.add(p2);
            q.where(predicates.toArray(new Predicate[]{}));
        }
        Query query = session.createQuery(q);
        return query.getResultList();
    }
    
    @Override
    public List<User> getALLUsers() {
        Session session = sessionFactory.getObject().getCurrentSession();
        
        Query query = session.createQuery("FROM User");
        return query.getResultList();
    }

    @Override
    public User getUserByTaiKhoan(String taiKhoan) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<User> q = b.createQuery(User.class);
        Root root = q.from(User.class);
        q.select(root);

        q.where(b.equal(root.get("taikhoan").as(String.class), taiKhoan));

        Query query = session.createQuery(q);
        return (User) query.getSingleResult();
    }

    public boolean updateQuanLy(String iduser) {
        Session session = sessionFactory.getObject().getCurrentSession();
        try {
            User u = session.get(User.class, iduser);
            u.setRole("ROLE_QUANLY");
            session.update(u);
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        Session session = sessionFactory.getObject().getCurrentSession();
        try {
            if (user.getRole() != null || user.getTaikhoan() != null || user.getTennguoidung() != "" || user.getGioitinh() != null || user.getEmail() != null
                    || user.getSdt() != null || user.getDiachi() != null || user.getAvatar() != null || user.getId() != null) {
                User u = session.get(User.class, user.getId());
                u.setTaikhoan(user.getTaikhoan());
                u.setTennguoidung(user.getTennguoidung());
                String pass = "";
                if(user.getMatkhau() != null){
                    pass = this.passwordEncoder.encode(user.getMatkhau());
                    u.setMatkhau(pass);
                }else
                {
                    pass = u.getMatkhau();
                    u.setMatkhau(pass);
                }
                u.setGioitinh(user.getGioitinh());
                u.setEmail(user.getEmail());
                u.setSdt(user.getSdt());
                u.setDiachi(user.getDiachi());
                u.setRole(user.getRole());
                u.setActive(user.getActive());
                if(user.getAvatar() != ""){
                    u.setAvatar(user.getAvatar());
                }
                session.save(u);
                return true;
            }

        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public User getUserByID(String iduser) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<User> q = b.createQuery(User.class);
        Root root = q.from(User.class);
        q.select(root);

        q.where(b.equal(root.get("id").as(String.class), iduser));

        Query query = session.createQuery(q);
        return (User) query.getSingleResult();
    }
}
