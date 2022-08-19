/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.controllers;

import com.bmt.pojo.Cuahang;
import com.bmt.pojo.DonhangMonan;
import com.bmt.pojo.User;
import com.bmt.service.CuaHangService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ACER
 */
@Controller
@RequestMapping("/admin")
public class DonhangController {
    
    @Autowired
    private CuaHangService cuahangService;
    
    @GetMapping("/donhang")
    public String cuaHang(Model model ,HttpSession session) {
        User u = (User) session.getAttribute("currentUser");
        model.addAttribute("donhangcuahang", this.cuahangService.getAllCuaHangByUser(u));
        return "donhang";
    }
}
