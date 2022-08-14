/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bmt.service;

import com.bmt.pojo.Giohang;
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ACER
 */
public interface ThanhToanService {
    String tienVanChuyen(String idcuahang);
    String idCuaHang(int idmonan);
}
