/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.service.impl;

import com.bmt.pojo.Monan;
import com.bmt.repository.MonAnRepository;
import com.bmt.service.MonAnService;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
public class MonAnServiceImpl implements MonAnService {

    @Autowired
    private MonAnRepository monAnRepository;

    @Override
    public List<Monan> getMonAnSapBan() {
        return this.monAnRepository.getMonAnSapBan();
    }

    @Override
    public List<Monan> getMonAnPhoBien (int page) {
        return this.monAnRepository.getMonAnPhoBien(page);
    }

    @Override
    public List<Monan> getTatCaMonAn(Map<String, String> params, int page) {
        return this.monAnRepository.getTatCaMonAn(params, page);
    }

    @Override
    public List<Monan> getMonAnTangDanTheoGia(int page) {
        return this.monAnRepository.getMonAnTangDanTheoGia(page);
    }

    @Override
    public List<Monan> getMonAnGiamDanTheoGia(int page) {
        return this.monAnRepository.getMonAnGiamDanTheoGia(page);
    }

    @Override
    public List<Object[]> geCuaHangTheoMonAnTimKiem(Map<String, String> params, int page) {
        return this.monAnRepository.geCuaHangTheoMonAnTimKiem(params, page);
    }
    
    @Override
    public Monan getMonAnByID(int id) {
        return this.monAnRepository.getMonAnByID(id);
    }

    @Override
<<<<<<< HEAD
    public List<Object[]> getLoaiMonAnTheoMonAnTimKiem(Map<String, String> params, int page) {
        return this.monAnRepository.getLoaiMonAnTheoMonAnTimKiem(params, page);
    }

    @Override
    public List<Object[]> getMonAnTheoIdCuaHang(Map<String, String> params, String idCuaHang, int page) {
        return this.monAnRepository.getMonAnTheoIdCuaHang(params, idCuaHang, page);
    }
=======
    public List<Monan> getALLMonAnByCuaHang(String idcuahang) {
        return this.monAnRepository.getALLMonAnByCuaHang(idcuahang);
        
    }

    @Override
    public Monan getChiTietMonAnByID(int id) {
        return this.monAnRepository.getChiTietMonAnByID(id);
    }

    @Override
    public boolean themMonAn(Monan monan) {
        return this.monAnRepository.themMonAn(monan);
    }

    @Override
    public boolean suaMonAn(Monan monan) {
        return this.monAnRepository.suaMonAn(monan);
    }

    @Override
    public List<Monan> getALLMonAnActiveByCuaHang(String idcuahang) {
        return this.monAnRepository.getALLMonAnActiveByCuaHang(idcuahang);
    }

>>>>>>> 226f6d66a346b81613eb8a7ba4384cec3b0eb81e
}
