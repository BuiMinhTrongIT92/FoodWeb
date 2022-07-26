/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bmt.service;

import com.bmt.pojo.Loaimonan;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ACER
 */
public interface LoaiMonAnService {
    int demLoaiMonAn();
    List<Loaimonan> getLoaiMonAn();
    List<Loaimonan> timkiemLoaiMonAn(Map<String, String> params, int page);
    List<Object[]> thongKeDoanhThuDanhMuc(String kw,Date tungay,Date denngay,String iduser);
    List<Object[]> thongKeDoanhThuDanhMucTheoThang(int thang, int nam,String iduser);
    List<Object[]> thongKeDoanhThuDanhMucTheoQuy(int quy,int nam,String iduser);
    List<Object[]> thongKeDoanhThuDanhMucTheoNam(int nam,String iduser);
    List<Loaimonan> getAllLoaiMonAn();
    List<Loaimonan> getAllLoaiMonAnByIDUser();
    List<Loaimonan> getAllLoaiMonAnByIDUserTrue();
    Loaimonan getMotLoaiMonAn(int idloaimon);
    boolean themLoaiMon(Loaimonan loaimon);
    boolean suaLoaiMon(Loaimonan loaimon);
    boolean xoaLoaiMon(int idloaimon);
    public Loaimonan getLoaiMonAnTheoId(int idLoaiMonAn, int page);
    List<Loaimonan> getLoaiMonAnTimKiem(Map<String, String> params, int page);
    List<Object[]> thongKeSanPhamTheoThang(int thang,int nam);
    List<Object[]> thongKeSanPhamTheoQuy(int quy,int nam);
    List<Object[]> thongKeSanPhamTheoNam(int nam);
}
