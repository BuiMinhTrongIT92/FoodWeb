/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.service.impl;

import com.bmt.pojo.MenuthucanMonan;
import com.bmt.pojo.Monan;
import com.bmt.repository.MenuThucAnRepository;
import com.bmt.service.MenuThucAnService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER
 */
@Service
public class MenuThucAnServiceImpl implements MenuThucAnService{
    
    @Autowired
    private MenuThucAnRepository menuThucAnRepository;

    @Override
    public List<MenuthucanMonan> getMonAnByMenu(int idmenu) {
        return this.menuThucAnRepository.getMonAnByMenu(idmenu);
    }

    @Override
    public boolean themMonAnVaoMenu(MenuthucanMonan MenuthucanMonan) {
        return this.menuThucAnRepository.themMonAnVaoMenu(MenuthucanMonan);
    }

    @Override
    public boolean xoaMonAnKhoiMenu(MenuthucanMonan MenuthucanMonan) {
        return this.menuThucAnRepository.xoaMonAnKhoiMenu(MenuthucanMonan);
    }

    @Override
    public MenuthucanMonan getMenuthucanMonanByID(int id) {
        return this.menuThucAnRepository.getMenuthucanMonanByID(id);
    }
    
}
