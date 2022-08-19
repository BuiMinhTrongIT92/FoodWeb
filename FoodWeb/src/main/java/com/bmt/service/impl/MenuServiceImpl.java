/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.service.impl;

import com.bmt.pojo.Menuthucan;
import com.bmt.pojo.Monan;
import com.bmt.repository.MenuRepository;
import com.bmt.service.MenuService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER
 */
@Service
public class MenuServiceImpl implements MenuService {
    
    @Autowired
    private MenuRepository menuRepository;

    @Override
    public boolean themMenu(Menuthucan menu) {
        return this.menuRepository.themMenu(menu);
    }

    @Override
    public List<Menuthucan> getAllMenuByIDCuahang(String idcuahang) {
        return this.menuRepository.getAllMenuByIDCuahang(idcuahang);
    }

    @Override
    public Menuthucan getAllMenuByID(int idmenu) {
        return this.menuRepository.getAllMenuByID(idmenu);
    }

    @Override
    public boolean suaMenu(Menuthucan menu) {
        return this.menuRepository.suaMenu(menu);
    }

    @Override
    public boolean xoaMenu(Menuthucan menu) {
        return this.menuRepository.xoaMenu(menu);
    }

   
}
