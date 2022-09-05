/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bmt.repository;

import com.bmt.pojo.Binhluan;
import com.bmt.pojo.Cuahang;
import com.bmt.pojo.Danhgia;
import com.bmt.pojo.User;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ACER
 */
public interface CuaHangRepository {
    int demTatCaCuaHang();
    List<Object[]> getCuaHangNoiBat(int ls);
    List<Cuahang> getAllCuaHangByUser(User user);
    Cuahang getCuaHangByID(String id);
    boolean themCuaHang(Cuahang cuahang);
    boolean capNhatCuaHang(Cuahang cuahang);
    boolean xoaCuaHang(String idcuahang);
    public List<Binhluan> getBinhLuanCuaHang(String idCuaHang);
    Binhluan themBinhLuanCuaHang(String noiDung, String idCuaHang);
    List<Cuahang> getCuaHang(Map<String, String> params, int page);
    List<Cuahang> getAllCuaHang();
    Cuahang getCuahangByIdMenu(int idMenu);
    public List<Danhgia> getDanhGiaCuaHang(String idCuaHang);
    Danhgia themDanhGiaCuaHang(double soLuongSao, String idCuaHang);
}
