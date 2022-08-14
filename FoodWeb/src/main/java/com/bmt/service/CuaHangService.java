/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bmt.service;

import com.bmt.pojo.Cuahang;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ACER
 */
public interface CuaHangService {
    List<Object[]> getCuaHangNoiBat(int ls);
    List<Object[]> getCuaHangTheoMonAnTimKiem(Map<String, String> params, int page);
}
