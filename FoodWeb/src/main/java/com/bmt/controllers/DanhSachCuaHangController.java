/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.controllers;

import com.bmt.pojo.Cuahang;
import com.bmt.pojo.User;
import com.bmt.service.CuaHangService;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ACER
 */
@Controller
@ControllerAdvice
public class DanhSachCuaHangController {

    @Autowired
    private CuaHangService cuaHangService;

    @ModelAttribute
    public void att(Model model,HttpSession session){
        User u = (User) session.getAttribute("currentUser");
        model.addAttribute("listcuahang", this.cuaHangService.getAllCuaHangByUser(u));
    }
    
    @GetMapping("/danhsachcuahang")
    public String cuaHang(Model model, HttpSession session) {
        model.addAttribute("cuahang", new Cuahang());
        return "danhsachcuahang";
    }

    @PostMapping("/danhsachcuahang")
    public String themCuaHang(Model model, HttpSession session, @ModelAttribute(value = "cuahang") Cuahang cuahang) {
//        User u = (User) session.getAttribute("currentUser");
//        UUID id = UUID.randomUUID();
//        cuahang.setIdcuahang("rereeere");
//        cuahang.setActive(true);
//        cuahang.setIduser(u);
        this.cuaHangService.themCuaHang(cuahang);

        return "danhsachcuahang";
    }
}
