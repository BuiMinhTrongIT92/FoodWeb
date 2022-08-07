/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.service;

import com.bmt.pojo.Thongbao;
import com.bmt.pojo.User;

/**
 *
 * @author ACER
 */
public interface ThongBaoService {
    boolean taoThongBao(User user);
    boolean checkThongBao(User user);
}
