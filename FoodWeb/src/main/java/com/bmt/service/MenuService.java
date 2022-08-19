/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bmt.service;

import com.bmt.pojo.Menuthucan;
import com.bmt.pojo.Monan;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface MenuService {
    boolean themMenu(Menuthucan menu);
    boolean suaMenu(Menuthucan menu);
    boolean xoaMenu(Menuthucan menu);
    List<Menuthucan> getAllMenuByIDCuahang(String idcuahang);
    Menuthucan getAllMenuByID(int idmenu);
}
