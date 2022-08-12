/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.service;

import com.bmt.pojo.Giohang;
import com.bmt.pojo.User;
import java.util.Map;

/**
 *
 * @author ACER
 */
public interface DonHangMonAnService {
    boolean themDonHang(Map<Integer,Giohang> gio,User user);
}
