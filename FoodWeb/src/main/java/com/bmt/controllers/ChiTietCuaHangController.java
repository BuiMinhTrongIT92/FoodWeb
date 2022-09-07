/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.controllers;

import com.bmt.service.CuaHangService;
import com.bmt.service.DanhGiaService;
import com.bmt.service.MonAnService;
import com.bmt.service.TheoDoiService;
import com.bmt.pojo.User;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author NhatTien
 */
@Controller
@RequestMapping("/chitietcuahang")

public class ChiTietCuaHangController {

    @Autowired
    private CuaHangService cuaHangService;

    @Autowired
    private MonAnService monanService;
    
    @Autowired
    private DanhGiaService danhGiaService;

    @Autowired
    private TheoDoiService theoDoiService;

    @GetMapping("/{idcuahang}")
    public String index(Model model,
            @PathVariable(value = "idcuahang") String idCuaHang,
            @RequestParam Map<String, String> params, HttpSession session) {
        User u = (User) session.getAttribute("currentUser");
        String vitri = "https://maps.google.com/maps?q="+this.cuaHangService.getCuaHangByID(idCuaHang).getVitri().replaceAll(" ", "").trim()+"&hl=vi;z=14&output=embed";
        model.addAttribute("current", u);
        model.addAttribute("idcuahang", idCuaHang);
        model.addAttribute("vitris",vitri.toString());
        model.addAttribute("chitietcuahang", this.cuaHangService.getCuaHangByID(idCuaHang));
        model.addAttribute("monantheoidcuahang", this.monanService.getMonAnTheoIdCuaHang(params, idCuaHang, 0));
        try {
            model.addAttribute("tongsosaocuahang", this.danhGiaService.tongSoSaoCuaHang(idCuaHang));
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("demdanhgiacuahang", this.danhGiaService.demDanhGiaCuaHang(idCuaHang));
        try {
            model.addAttribute("trangthaitheodoi", this.theoDoiService.getTrangThaiTheoDoi(u.getId(), idCuaHang));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "chitietcuahang";
    }
}