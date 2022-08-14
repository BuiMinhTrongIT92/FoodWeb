/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.controllers;

import com.bmt.pojo.Giohang;
import com.bmt.service.ThanhToanService;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
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
@RequestMapping("/")
public class GioHangController {

    @Autowired
    private ThanhToanService thanhToanService;

    @GetMapping("/giohang")
    public String giohang(Model model, HttpSession session,HttpServletRequest request) {
        Map<Integer, Giohang> gios = (Map<Integer, Giohang>) session.getAttribute("gio");
        if (gios != null) {
            model.addAttribute("monantronggio", gios.values());
        } else {
            model.addAttribute("monantronggio", null);
        }
        model.addAttribute("thanh",request.getParameter("thanh"));
        return "giohang";
    }
    


}
