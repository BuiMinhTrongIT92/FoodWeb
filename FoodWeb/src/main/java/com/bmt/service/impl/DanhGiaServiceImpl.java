/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.service.impl;

import com.bmt.pojo.Danhgia;
import com.bmt.repository.DanhGiaRepository;
import com.bmt.service.DanhGiaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author NhatTien
 */
@Service
public class DanhGiaServiceImpl implements DanhGiaService {
    @Autowired
    private DanhGiaRepository danhGiaRepository;

    @Override
    public int demDanhGiaMonAn(int idMonAn) {
        return this.danhGiaRepository.demDanhGiaMonAn(idMonAn);
    }

    @Override
    public double tongSoSaoMonAn(int idMonAn) {
        return this.danhGiaRepository.tongSoSaoMonAn(idMonAn);
    }

    @Override
    public int demDanhGiaCuaHang(String idCuaHang) {
        return this.danhGiaRepository.demDanhGiaCuaHang(idCuaHang);
    }

    @Override
    public double tongSoSaoCuaHang(String idCuaHang) {
        return this.danhGiaRepository.tongSoSaoCuaHang(idCuaHang);
    }
}
