/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.service.impl;

import com.bmt.pojo.Cuahang;
import com.bmt.pojo.User;
import com.bmt.repository.CuaHangRepository;
import com.bmt.service.CuaHangService;
import java.util.ArrayList;
import java.util.List;
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
    public List<Cuahang> getAllCuaHangByUser(User user) {
        List<Cuahang> ls = new ArrayList<>();
        if(user !=null){
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

    

    
}
