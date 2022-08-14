/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.controllers;

import com.bmt.pojo.Cuahang;
import com.bmt.service.CuaHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ACER
 */
@Controller
public class CuaHangController {
    
    @Autowired
    private CuaHangService cuaHangService;
    
    @GetMapping("/cuahang")
    public String cuaHang(){
        return "cuahang";
    }
    
    @GetMapping("/cuahang/{idcuahang}")
    public String getCuaHang(@PathVariable(value = "idcuahang") String idcuahang,Model model){
        Cuahang ch = this.cuaHangService.getCuaHangByID(idcuahang);
        if(ch.getActive() == true){
            model.addAttribute("ii",ch);
        }
        return "cuahang";
    }
    
    
}
