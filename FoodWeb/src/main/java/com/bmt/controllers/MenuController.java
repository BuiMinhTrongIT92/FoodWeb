/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.controllers;

import com.bmt.pojo.User;
import com.bmt.service.CuaHangService;
import com.bmt.service.MenuService;
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
public class MenuController {

    @Autowired
    private CuaHangService cuahangService;

    @Autowired
    private MenuService menuService;

    @GetMapping("/menu")
    public String menu(Model model, HttpSession session) {
        User u = (User) session.getAttribute("currentUser");
        model.addAttribute("allcuahang", this.cuahangService.getAllCuaHangByUser(u));
        model.addAttribute("all", this.menuService.getAllMenuByIDCuahang("1"));

        return "menu";
    }

}
