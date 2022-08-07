/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.controllers;

import com.bmt.service.LoaiMonAnService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author NhatTien
 */
@Controller
@RequestMapping("/")
public class LoaiMonAnController {
    @Autowired
    private LoaiMonAnService loaiMonAnService;
    
    @GetMapping("/loaimonan")
    @Transactional
    public String index(Model model,
            @RequestParam Map<String, String> params) {
        model.addAttribute("loaimonan", this.loaiMonAnService.getLoaiMonAn());
        return "loaimonan";
    }
}
