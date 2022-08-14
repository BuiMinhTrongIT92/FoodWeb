/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bmt.repository;

import com.bmt.pojo.Giohang;
import com.bmt.pojo.User;
import java.util.Map;

/**
 *
 * @author ACER
 */
public interface DonHangMonAnRepository {
    boolean themDonHang(Map<Integer,Giohang> gio,User user);
}
