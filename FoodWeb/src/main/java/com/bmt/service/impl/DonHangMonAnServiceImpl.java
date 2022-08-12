/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.service.impl;

import com.bmt.pojo.Giohang;
import com.bmt.pojo.User;
import com.bmt.repository.DonHangMonAnRepository;
import com.bmt.service.DonHangMonAnService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER
 */
@Service
public class DonHangMonAnServiceImpl implements DonHangMonAnService{
    
    @Autowired
    private DonHangMonAnRepository donHangMonAnRepository;
    
    @Override
    public boolean themDonHang(Map<Integer, Giohang> gio, User user) {
        if(gio != null){
            this.donHangMonAnRepository.themDonHang(gio, user);
            return true;
        }
        return false;
    }
    
}
