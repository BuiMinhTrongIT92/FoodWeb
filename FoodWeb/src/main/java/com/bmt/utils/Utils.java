/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.utils;

import com.bmt.pojo.Giohang;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author ACER
 */
public class Utils {

    public static int countGio(Map<Integer, Giohang> gios) {
        int sl = 0;
        if (gios != null) {
            //        gios.values() lấy ds các vaules bỏ qua key
            for (Giohang g : gios.values()) {
                sl += g.getSoluong();
            }
        }
        return sl;
    }


}
