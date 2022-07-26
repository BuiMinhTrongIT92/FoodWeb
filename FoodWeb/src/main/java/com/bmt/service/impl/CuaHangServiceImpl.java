/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.service.impl;

import com.bmt.pojo.Binhluan;
import com.bmt.pojo.Cuahang;
import com.bmt.pojo.Danhgia;
import com.bmt.pojo.Monan;
import com.bmt.pojo.User;
import com.bmt.repository.CuaHangRepository;
import com.bmt.service.CuaHangService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER
 */
@Service
public class CuaHangServiceImpl implements CuaHangService {

    @Autowired
    private CuaHangRepository cuaHangRepository;

    @Override
    public List<Object[]> getCuaHangNoiBat(int sl) {
        return this.cuaHangRepository.getCuaHangNoiBat(sl);
    }

    public List<Cuahang> getAllCuaHangByUser(User user) {
        List<Cuahang> ls = new ArrayList<>();
        if (user != null) {
            ls = this.cuaHangRepository.getAllCuaHangByUser(user);
        }
        return ls;
    }

    @Override
    public Cuahang getCuaHangByID(String id) {
        return this.cuaHangRepository.getCuaHangByID(id);
    }

    @Override
    public boolean themCuaHang(Cuahang cuahang) {
        return this.cuaHangRepository.themCuaHang(cuahang);
    }

    @Override
    public boolean capNhatCuaHang(Cuahang cuahang) {
        return this.cuaHangRepository.capNhatCuaHang(cuahang);
    }

    @Override
    public List<Binhluan> getBinhLuanCuaHang(String idCuaHang) {
        return this.cuaHangRepository.getBinhLuanCuaHang(idCuaHang);
    } 

    @Override
    public Binhluan themBinhLuanCuaHang(String noiDung, String idCuaHang) {
        return this.cuaHangRepository.themBinhLuanCuaHang(noiDung, idCuaHang);
    }

    @Override
    public List<Cuahang> getCuaHang(Map<String, String> params, int page) {
        return this.cuaHangRepository.getCuaHang(params, page);
    }
    
    public List<Cuahang> getAllCuaHang() {
        return this.cuaHangRepository.getAllCuaHang();
    }

    @Override
    public boolean xoaCuaHang(String idcuahang) {
        return this.cuaHangRepository.xoaCuaHang(idcuahang);
    }

    @Override
    public int demTatCaCuaHang() {
        return this.cuaHangRepository.demTatCaCuaHang();
    }

    @Override
    public Cuahang getCuahangByIdMenu(int idMenu) {
        return this.cuaHangRepository.getCuahangByIdMenu(idMenu);
    }

    @Override
    public List<Danhgia> getDanhGiaCuaHang(String idCuaHang) {
        return this.cuaHangRepository.getDanhGiaCuaHang(idCuaHang);
    }

    @Override
    public Danhgia themDanhGiaCuaHang(double soLuongSao, String idCuaHang) {
        return this.cuaHangRepository.themDanhGiaCuaHang(soLuongSao, idCuaHang);
    }
}
