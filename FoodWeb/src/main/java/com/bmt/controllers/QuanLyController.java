/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.controllers;

import com.bmt.pojo.Cuahang;
import com.bmt.pojo.User;
import com.bmt.service.CuaHangService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ACER
 */
@Controller
@RequestMapping("/admin")
@ControllerAdvice
public class QuanLyController {
    
    @Autowired
    private CuaHangService cuaHangService;
    
    @GetMapping("/home")
    public String admin(HttpSession session){
        User u = (User) session.getAttribute("currentUser");
        if(u.getRole().contains("QUANLY")){
            return "adminhome";
        }
        else
            return "index";
    }
    @ModelAttribute
    public void att(Model model, HttpSession session) {
        User u = (User) session.getAttribute("currentUser");
        model.addAttribute("listcuahang", this.cuaHangService.getAllCuaHangByUser(u));
    }
    
    
    
}
