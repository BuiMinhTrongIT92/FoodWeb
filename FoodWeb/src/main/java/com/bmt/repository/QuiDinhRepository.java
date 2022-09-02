/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bmt.repository;

import com.bmt.pojo.Quidinh;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface QuiDinhRepository {
    List<Quidinh> getAllQuiDinhByUser();
    Quidinh getAllQuiDinhByID(int id);
    boolean themQuiDinh(Quidinh quidinh);
    boolean suaQuiDinh(Quidinh quidinh);
    boolean xoaQuiDinh(int idquidinh);
}
