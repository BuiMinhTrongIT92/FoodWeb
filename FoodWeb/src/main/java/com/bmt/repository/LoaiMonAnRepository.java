/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bmt.repository;

import com.bmt.pojo.Loaimonan;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ACER
 */
public interface LoaiMonAnRepository {
    List<Loaimonan> getLoaiMonAn();
    List<Loaimonan> timkiemLoaiMonAn(Map<String, String> params, int page);
    List<Object[]> thongKeDoanhThuDanhMuc(String kw,Date tungay,Date denngay);
    List<Object[]> thongKeDoanhThuDanhMucTheoThang(int thang, int nam);
    List<Object[]> thongKeDoanhThuDanhMucTheoQuy(int quy,int nam);
    List<Object[]> thongKeDoanhThuDanhMucTheoNam(int nam);
    List<Loaimonan> getAllLoaiMonAn();
    Loaimonan getMotLoaiMonAn(int idloaimon);
    boolean themLoaiMon(Loaimonan loaimon);
    boolean suaLoaiMon(Loaimonan loaimon);
    
}
