/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bmt.service;

import com.bmt.pojo.Monan;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ACER
 */
public interface MonAnService {
    List<Monan> getTatCaMonAn(Map<String, String> params, int page);
    List<Monan> getMonAnSapBan();
    List<Monan> getMonAnPhoBien(int page);
    Monan getMonAnByID(int id);
}
