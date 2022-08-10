/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.controllers;

import com.bmt.pojo.Giohang;
import java.util.Map;
import javax.servlet.http.HttpSession;
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
    @GetMapping("/giohang")
    public String giohang(Model model,HttpSession session) {
        Map<Integer,Giohang> gios = (Map<Integer,Giohang>) session.getAttribute("gio");
        if(gios != null){
            model.addAttribute("monantronggio",gios.values());
        }else
            model.addAttribute("monantronggio",null);
        return "giohang";
    }
}
