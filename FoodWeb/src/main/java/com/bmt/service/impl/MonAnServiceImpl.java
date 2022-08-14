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
}
