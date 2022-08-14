/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bmt.repository;

import com.bmt.pojo.Cuahang;
import com.bmt.pojo.User;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface CuaHangRepository {
    List<Object[]> getCuaHangNoiBat(int ls);
    List<Cuahang> getAllCuaHangByUser(User user);
    Cuahang getCuaHangByID(String id);
    boolean themCuaHang(Cuahang cuahang);
}
