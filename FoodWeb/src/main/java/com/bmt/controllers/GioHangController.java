/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.controllers;

import com.bmt.pojo.Giohang;
import com.bmt.service.ThanhToanService;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author NhatTien
 */
@Controller
@RequestMapping("/")
public class GioHangController {

    @Autowired
    private ThanhToanService thanhToanService;

    @GetMapping("/giohang")
    public String giohang(Model model, HttpSession session) {
        Map<Integer, Giohang> gios = (Map<Integer, Giohang>) session.getAttribute("gio");
        if (gios != null) {
            model.addAttribute("monantronggio", gios.values());
        } else {
            model.addAttribute("monantronggio", null);
        }
//        model.addAttribute("tienvc", tienVanChuyen(session));
        return "giohang";
    }

//    public Double tienVanChuyen(HttpSession session) {
//        Map<Integer, Giohang> gios = (Map<Integer, Giohang>) session.getAttribute("gio");
//        Set<String> idCHSet = new HashSet<>();
//        Double KQ = 0.0;
//        if (gios != null) {
//            for (Giohang g : gios.values()) {
//                String idCH = this.thanhToanService.idCuaHang(g.getIdmonan());
//                idCHSet.add(idCH);
//            }
//            for (String idCh : idCHSet) {
//                Double tienvanchuyen = Double.valueOf(this.thanhToanService.tienVanChuyen(idCh));
//                KQ += tienvanchuyen;
//            }
//        }
//        return KQ;
//    }
}
