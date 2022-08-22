/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.controllers;

import com.bmt.service.LoaiMonAnService;
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
@RequestMapping("/chitietloaimonan")
public class ChiTietLoaiMonAnController {
    @Autowired
    private MonAnService monAnService;
    
    @Autowired
    private LoaiMonAnService loaiMonAnService;
    
    @GetMapping("/{idloaimon}")
    public String index(Model model,
            @PathVariable(value = "idloaimon") int idLoaiMon,
            @RequestParam Map<String, String> params) {
        model.addAttribute("chitietloaimonan", this.loaiMonAnService.getLoaiMonAnTheoId(idLoaiMon, 0));
        model.addAttribute("monantheoidloaimon", this.monAnService.getMonAnTheoIdLoaiMonAn(params, idLoaiMon, 0));
        return "chitietloaimonan";
    }
}
