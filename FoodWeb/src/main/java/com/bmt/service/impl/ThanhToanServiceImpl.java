/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.service.impl;

import com.bmt.pojo.Giohang;
import com.bmt.repository.ThanhToanRepository;
import com.bmt.service.ThanhToanService;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER
 */
@Service
public class ThanhToanServiceImpl implements ThanhToanService{

    @Autowired
    private ThanhToanRepository thanhToanRepository;
    
    @Override
    public String tienVanChuyen(String idcuahang) {
        return this.thanhToanRepository.tienVanChuyen(idcuahang);
    }

    @Override
    public String idCuaHang(int idmonan) {
        return this.thanhToanRepository.idCuaHang(idmonan);
    }
    
}
