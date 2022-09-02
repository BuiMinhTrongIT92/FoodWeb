/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.service.impl;

import com.bmt.pojo.Theodoi;
import com.bmt.repository.TheoDoiRepository;
import com.bmt.service.TheoDoiService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER
 */
@Service
public class TheoDoiServiceImpl implements TheoDoiService{

    @Autowired
    private TheoDoiRepository theoDoiRepository;

    @Override
    public Theodoi getTrangThaiTheoDoi(String iduser, String idcuahang) {
        return this.theoDoiRepository.getTrangThaiTheoDoi(iduser, idcuahang);
    }

    @Override
    public boolean capNhatTrangThaiTheoDoi(String iduser, String idcuahang) {
        return this.theoDoiRepository.capNhatTrangThaiTheoDoi(iduser, idcuahang);
    }

    @Override
    public List<Object[]> getAllUserByIDCuaHang(String idcuahang) {
        return this.theoDoiRepository.getAllUserByIDCuaHang(idcuahang);
    }
    
   
}
