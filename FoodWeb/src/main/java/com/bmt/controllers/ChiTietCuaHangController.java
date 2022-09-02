/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.controllers;

import com.bmt.service.CuaHangService;
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
    private TheoDoiService theoDoiService;

    @GetMapping("/{idcuahang}")
    public String index(Model model,
            @PathVariable(value = "idcuahang") String idCuaHang,
            @RequestParam Map<String, String> params, HttpSession session) {
        User u = (User) session.getAttribute("currentUser");
        model.addAttribute("chitietcuahang", this.cuaHangService.getCuaHangByID(idCuaHang));
        model.addAttribute("monantheoidcuahang", this.monanService.getMonAnTheoIdCuaHang(params, idCuaHang, 0));
        try {
            model.addAttribute("trangthaitheodoi", this.theoDoiService.getTrangThaiTheoDoi(u.getId(), idCuaHang));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "chitietcuahang";
    }
}
