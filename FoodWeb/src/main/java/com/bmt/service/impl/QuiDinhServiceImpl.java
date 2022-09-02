/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.service.impl;

import com.bmt.pojo.Quidinh;
import com.bmt.repository.QuiDinhRepository;
import com.bmt.service.QuiDinhService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER
 */
@Service
public class QuiDinhServiceImpl implements QuiDinhService{
    
    @Autowired
    private QuiDinhRepository quiDinhRepository;

    @Override
    public List<Quidinh> getAllQuiDinhByUser() {
        return this.quiDinhRepository.getAllQuiDinhByUser();
    }

    @Override
    public Quidinh getAllQuiDinhByID(int id) {
        return this.quiDinhRepository.getAllQuiDinhByID(id);
    }

    @Override
    public boolean themQuiDinh(Quidinh quidinh) {
        return this.quiDinhRepository.themQuiDinh(quidinh);
    }

    @Override
    public boolean suaQuiDinh(Quidinh quidinh) {
        return this.quiDinhRepository.suaQuiDinh(quidinh);
    }

    @Override
    public boolean xoaQuiDinh(int idquidinh) {
        return this.quiDinhRepository.xoaQuiDinh(idquidinh);
    }
    
}
