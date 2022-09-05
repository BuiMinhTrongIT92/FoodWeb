/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bmt.repository;

import com.bmt.pojo.Danhgia;
import java.util.List;

/**
 *
 * @author NhatTien
 */

public interface DanhGiaRepository {
    int demDanhGiaMonAn(int idMonAn);
    double tongSoSaoMonAn(int idMonAn);
    int demDanhGiaCuaHang(String idCuaHang);
    double tongSoSaoCuaHang(String idCuaHang);
}
