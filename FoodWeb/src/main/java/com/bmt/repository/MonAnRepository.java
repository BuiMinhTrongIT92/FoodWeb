/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bmt.repository;

import com.bmt.pojo.Monan;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ACER
 */
public interface MonAnRepository {
    List<Monan> getMonAnSapBan();
    List<Monan> getMonAnPhoBien(int page);
}