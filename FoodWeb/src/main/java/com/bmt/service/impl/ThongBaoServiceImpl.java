/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.service.impl;

import com.bmt.pojo.Thongbao;
import com.bmt.pojo.User;
import com.bmt.repository.ThongBaoRepository;
import com.bmt.service.ThongBaoService;
import com.bmt.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER
 */
@Service
public class ThongBaoServiceImpl implements ThongBaoService{
    @Autowired
    private ThongBaoRepository thongBaoRepository;

    @Override
    public boolean taoThongBao(User user) {
        return this.thongBaoRepository.taoThongBao(user);
    }

    @Override
    public boolean checkThongBao(User user) {
        return this.thongBaoRepository.checkThongBao(user);
    }

    @Override
    public List<Thongbao> getThongBaoChoXacNhan() {
        return this.thongBaoRepository.getThongBaoChoXacNhan();
    }

    @Override
    public boolean xacNhanThongBao(int idthongbao) {
        return this.thongBaoRepository.xacNhanThongBao(idthongbao);
    }

    @Override
    public String getIDUserByIDThongbao(int idthongbao) {
        return this.thongBaoRepository.getIDUserByIDThongbao(idthongbao);
    }
    
}
