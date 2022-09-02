/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bmt.repository;

import com.bmt.pojo.Theodoi;
import com.bmt.pojo.User;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface TheoDoiRepository {
    Theodoi getTrangThaiTheoDoi(String iduser, String idcuahang);
    boolean capNhatTrangThaiTheoDoi(String iduser, String idcuahang);
    List<Object[]> getAllUserByIDCuaHang(String idcuahang);
}
