/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.controllers;

import com.bmt.service.CuaHangService;
import com.bmt.service.MenuThucAnService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
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
@PropertySource("classpath:template.properties")
public class MenuthucanController {

    @Autowired
    private MenuThucAnService menuThucanService;

    @Autowired
    private CuaHangService cuaHangService;

    @GetMapping("/menuthucan")
    public String getMenuthucan(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("menuthucan", this.menuThucanService.getMenuthucan(params, 0));
        return "menuthucan";
    }

    @GetMapping("/chitietmenu/{idmenuthucan}")
    public String getMonAnTrongMenu(Model model,
            @PathVariable(value = "idmenuthucan") int idMenu,
            @RequestParam Map<String, String> params) {
        try {
            model.addAttribute("monantrongmenu", this.menuThucanService.getMonAnTrongMenu(idMenu));
            model.addAttribute("cuahangtheoidmenu", this.cuaHangService.getCuahangByIdMenu(idMenu));
            model.addAttribute("tenmenutheoid", this.menuThucanService.getTenMenuByIdMenu(idMenu));
        } catch (Exception e) {
        }
        return "chitietmenu";
    }
}
