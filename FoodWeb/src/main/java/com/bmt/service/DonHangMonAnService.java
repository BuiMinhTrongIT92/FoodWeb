/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.service;

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
public interface DonHangMonAnService {
    boolean themDonHang(Map<Integer,Giohang> gio,User user);
    boolean suaDonHang(String iddonhang,String trangthai);
    List<Donhang> getDonHangByIDCuaHang(String idcuahang);
    List<DonhangMonan> getDetailDonHang(String iddonhang);
}
