/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bmt.service;

import com.bmt.pojo.Loaimonan;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ACER
 */
public interface LoaiMonAnService {
    List<Loaimonan> getLoaiMonAn();
    List<Loaimonan> timkiemLoaiMonAn(Map<String, String> params, int page);
    public Loaimonan getLoaiMonAnTheoId(int idLoaiMonAn, int page);
}
