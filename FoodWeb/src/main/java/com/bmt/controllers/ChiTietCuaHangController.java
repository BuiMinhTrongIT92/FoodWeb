/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.controllers;

import com.bmt.service.CuaHangService;
import com.bmt.service.MonAnService;
import java.util.Map;
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
@RequestMapping("/")
public class ChiTietCuaHangController {

    @Autowired
    private CuaHangService cuaHangService;

    @Autowired
    private MonAnService monanService;

    @GetMapping("/chitietcuahang/{idcuahang}")
    public String index(Model model,
            @PathVariable(value = "idcuahang") String idCuaHang,
            @RequestParam Map<String, String> params) {
        model.addAttribute("chitietcuahang", this.cuaHangService.getCuaHangByID(idCuaHang));
//        model.addAttribute("monantheoidcuahang", this.monanService.getMonAnTheoIdCuaHang(params, idCuaHang, 0));
        model.addAttribute("monan", this.monanService.getTatCaMonAn(params, 0));
        return "chitietcuahang";
    } 
}
