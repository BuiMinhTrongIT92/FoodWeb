/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bmt.repository;

import com.bmt.pojo.Donhang;
import com.bmt.pojo.DonhangMonan;
import com.bmt.pojo.Giohang;
import com.bmt.pojo.User;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ACER
 */
public interface DonHangMonAnRepository {
    boolean themDonHang(Map<Integer,Giohang> gio,User user);
    boolean suaDonHang(String iddonhang,String trangthai);
    List<Donhang> getDonHangByIDCuaHang(String idcuahang);
    List<DonhangMonan> getDetailDonHang(String iddonhang);
    
    List<Object[]> demSoDonTheoThang(String idcuahang,int thang, int nam);
    List<Object[]> demSoDonTheoQuy(String idcuahang,int quy, int nam);
    List<Object[]> demSoDonTheoNam(String idcuahang,int nam);
    
    List<Object[]> demSoKhachHangTheoThang(String idcuahang,int thang, int nam);
    List<Object[]> demSoKhachHangTheoQuy(String idcuahang,int quy, int nam);
    List<Object[]> demSoKhachHangTheoNam(String idcuahang,int nam);
}
