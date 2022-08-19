/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bmt.repository;

import com.bmt.pojo.Monan;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ACER
 */
public interface MonAnRepository {
    List<Monan> getTatCaMonAn(Map<String, String> params, int page);
    List<Monan> getMonAnTangDanTheoGia(int page);
    List<Monan> getMonAnGiamDanTheoGia(int page);
    List<Monan> getMonAnSapBan();
    List<Monan> getMonAnPhoBien(int page);
    public List<Object[]> geCuaHangTheoMonAnTimKiem(Map<String, String> params, int page);
    Monan getMonAnByID(int id);
    Monan getChiTietMonAnByID(int id);
    List<Monan> getALLMonAnByCuaHang(String idcuahang);
    List<Monan> getALLMonAnActiveByCuaHang(String idcuahang);
    boolean themMonAn(Monan monan);
    boolean suaMonAn(Monan monan);
    
}
