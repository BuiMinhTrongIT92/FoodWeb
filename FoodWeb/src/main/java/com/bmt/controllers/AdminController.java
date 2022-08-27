/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.controllers;

import com.bmt.pojo.User;
import com.bmt.service.ThongBaoService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ACER
 */
@Controller
@RequestMapping("/admin")
@ControllerAdvice
public class AdminController {
    
    @Autowired
    private ThongBaoService thongBaoService;
    
    @GetMapping("/xacnhancuahang")
    public String xacNhanCuaHang(Model model){
        model.addAttribute("thongbaochoxacnhan",this.thongBaoService.getThongBaoChoXacNhan());
        return "xacnhancuahang";
    }
    @GetMapping("/tansuatbanhang")
    public String tanSuatBanHang(Model model){
        return "tansuatbanhang";
    }
    @GetMapping("/tongspkinhdoanh")
    public String tongSPKinhDoanh(Model model){
        return "tongspkinhdoanh";
    }
    @ModelAttribute
    public void att(Model model, HttpSession session) {
        
        model.addAttribute("counttb", this.thongBaoService.getThongBaoChoXacNhan());
    }
}
