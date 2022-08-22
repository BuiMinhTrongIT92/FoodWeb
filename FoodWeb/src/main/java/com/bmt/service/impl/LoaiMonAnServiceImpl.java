/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.service.impl;

import com.bmt.pojo.Loaimonan;
import com.bmt.repository.LoaiMonAnRepository;
import com.bmt.service.LoaiMonAnService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER
 */
@Service
public class LoaiMonAnServiceImpl implements LoaiMonAnService{

    @Autowired
    LoaiMonAnRepository loaiMonAnRepository;
    
    @Override
    public List<Loaimonan> getLoaiMonAn() {
        return this.loaiMonAnRepository.getLoaiMonAn();
    }

    @Override
    public List<Loaimonan> timkiemLoaiMonAn(Map<String, String> params, int page) {
        return this.loaiMonAnRepository.timkiemLoaiMonAn(params, page);
    }

    @Override
    public Loaimonan getLoaiMonAnTheoId(int idLoaiMonAn, int page) {
        return this.loaiMonAnRepository.getLoaiMonAnTheoId(idLoaiMonAn, page);
    }
}
