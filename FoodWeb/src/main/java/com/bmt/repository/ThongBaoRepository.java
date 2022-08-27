/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bmt.repository;

import com.bmt.pojo.Thongbao;
import com.bmt.pojo.User;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface ThongBaoRepository {
    boolean taoThongBao(User user);
    boolean checkThongBao(User user);
    List<Thongbao> getThongBaoChoXacNhan();
    boolean xacNhanThongBao(int idthongbao);
    String getIDUserByIDThongbao(int idthongbao);
}
