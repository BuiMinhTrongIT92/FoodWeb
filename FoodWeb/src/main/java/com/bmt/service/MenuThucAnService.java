/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bmt.service;

import com.bmt.pojo.MenuthucanMonan;
import com.bmt.pojo.Monan;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface MenuThucAnService {
    List<MenuthucanMonan> getMonAnByMenu(int idmenu);
    boolean themMonAnVaoMenu(MenuthucanMonan MenuthucanMonan);
    boolean xoaMonAnKhoiMenu(MenuthucanMonan MenuthucanMonan);
    MenuthucanMonan getMenuthucanMonanByID(int id);
}
