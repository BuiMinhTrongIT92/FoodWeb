/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bmt.repository;

import com.bmt.pojo.Binhluan;
import com.bmt.pojo.Monan;
import java.util.Date;
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
    public List<Object[]> getCuaHangTheoMonAnTimKiem(Map<String, String> params, int page);
    public List<Object[]> getLoaiMonAnTheoMonAnTimKiem(Map<String, String> params, int page);
    public List<Object[]> getMonAnTheoIdCuaHang(Map<String, String> params, String idCuaHang, int page);
    public List<Object[]> getMonAnTheoIdLoaiMonAn(Map<String, String> params, int idLoaiMon, int page);
    Monan getMonAnByID(int id);
    Monan getChiTietMonAnByID(int id);
    List<Monan> getALLMonAnByCuaHang(String idcuahang);
    List<Monan> getALLMonAnActiveByCuaHang(String idcuahang);
    boolean themMonAn(Monan monan);
    boolean suaMonAn(Monan monan);
    public List<Binhluan> getBinhLuanMonAn(int idMonAn);
    Binhluan themBinhLuanMonAn(String noiDung, int idMonAn);
    List<Object[]> thongKeDoanhThuMonAn(String kw,Date tungay,Date denngay,String iduser);
    List<Object[]> thongKeDoanhThuMonAnTheoThang(int thang,int nam,String iduser);
    List<Object[]> thongKeDoanhThuMonAnTheoQuy(int quy,int nam,String iduser);
    List<Object[]> thongKeDoanhThuMonAnTheoNam(int nam,String iduser);
}
