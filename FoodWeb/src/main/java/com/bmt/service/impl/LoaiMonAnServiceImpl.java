/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.service.impl;

import com.bmt.pojo.Loaimonan;
import com.bmt.repository.LoaiMonAnRepository;
import com.bmt.service.LoaiMonAnService;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER
 */
@Service
public class LoaiMonAnServiceImpl implements LoaiMonAnService {

    @Autowired
    LoaiMonAnRepository loaiMonAnRepository;

    @Override
    public List<Loaimonan> getLoaiMonAn() {
        return this.loaiMonAnRepository.getLoaiMonAn();
    }

    @Override
    public List<Loaimonan> timkiemLoaiMonAn(Map<String, String> params, int page) {
        return this.loaiMonAnRepository.timkiemLoaiMonAn(params, page);
    }

    @Override
    public List<Object[]> thongKeDoanhThuDanhMuc(String kw, Date tungay, Date denngay,String iduser) {
        return this.loaiMonAnRepository.thongKeDoanhThuDanhMuc(kw, tungay, denngay, iduser);
    }

    @Override
    public List<Object[]> thongKeDoanhThuDanhMucTheoThang(int thang, int nam,String iduser) {
        return this.loaiMonAnRepository.thongKeDoanhThuDanhMucTheoThang(thang, nam, iduser);
    }

    @Override
    public List<Object[]> thongKeDoanhThuDanhMucTheoQuy(int quy, int nam,String iduser) {
        return this.loaiMonAnRepository.thongKeDoanhThuDanhMucTheoQuy(quy, nam, iduser);
    }

    @Override
    public List<Object[]> thongKeDoanhThuDanhMucTheoNam(int nam,String iduser) {
        return this.loaiMonAnRepository.thongKeDoanhThuDanhMucTheoNam(nam, iduser);
    }

    @Override
    public List<Loaimonan> getAllLoaiMonAn() {
        return this.loaiMonAnRepository.getAllLoaiMonAn();
    }

    @Override
    public Loaimonan getMotLoaiMonAn(int idloaimon) {
        return this.loaiMonAnRepository.getMotLoaiMonAn(idloaimon);
    }

    @Override
    public boolean themLoaiMon(Loaimonan loaimon) {
        return this.loaiMonAnRepository.themLoaiMon(loaimon);
    }

    @Override
    public boolean suaLoaiMon(Loaimonan loaimon) {
        return this.loaiMonAnRepository.suaLoaiMon(loaimon);
    }

    @Override
    public Loaimonan getLoaiMonAnTheoId(int idLoaiMonAn, int page) {
        return this.loaiMonAnRepository.getLoaiMonAnTheoId(idLoaiMonAn, page);
    }
}
