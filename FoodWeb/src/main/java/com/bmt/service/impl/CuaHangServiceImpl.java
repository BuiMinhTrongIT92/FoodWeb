/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.service.impl;

import com.bmt.pojo.Cuahang;
import com.bmt.repository.CuaHangRepository;
import com.bmt.service.CuaHangService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER
 */
@Service
public class CuaHangServiceImpl implements CuaHangService{
    @Autowired
    private CuaHangRepository cuaHangRepository;
    
    @Override
    public List<Object[]> getCuaHangNoiBat(int sl) {
        return this.cuaHangRepository.getCuaHangNoiBat(sl);
    }

    @Override
    public List<Object[]> getCuaHangTheoMonAnTimKiem(Map<String, String> params, int page) {
        return  this.cuaHangRepository.getCuaHangTheoMonAnTimKiem(params, page);
    }  
}
