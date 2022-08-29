/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bmt.service;

import com.bmt.pojo.User;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author ACER
 */
public interface UserService extends UserDetailsService{
    boolean addUser(User user);
    List<User> getUsers(String taikhoan);
    User getUserByTaiKhoan(String taiKhoan);
    boolean updateQuanLy(String iduser);
}
