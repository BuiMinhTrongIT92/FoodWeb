/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bmt.service;

import com.bmt.pojo.Menuthucan;
import com.bmt.pojo.MenuthucanMonan;
import com.bmt.pojo.Monan;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ACER
 */
public interface MenuThucAnService {
    List<MenuthucanMonan> getMonAnByMenu(int idmenu);
    boolean themMonAnVaoMenu(MenuthucanMonan MenuthucanMonan);
    boolean xoaMonAnKhoiMenu(MenuthucanMonan MenuthucanMonan);
    MenuthucanMonan getMenuthucanMonanByID(int id);
    public List<Object[]> getMenuthucan(Map<String, String> params, int page);
    public List<Object[]> getMonAnTrongMenu(int idMenu);
    public Menuthucan getTenMenuByIdMenu(int idMenu);
}
