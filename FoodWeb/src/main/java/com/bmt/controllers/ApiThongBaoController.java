/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.controllers;

import com.bmt.service.ThongBaoService;
import com.bmt.service.UserService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ACER
 */
@RestController
@RequestMapping("/api")
public class ApiThongBaoController {
    
    @Autowired
    private ThongBaoService thongbaoService;
    
    @Autowired
    private UserService userService;
    
    @PutMapping("/xacnhancuahang/{idthongbao}")
    public boolean xacNhanThongBao(Model model,
            @PathVariable(value = "idthongbao") int idthongbao) {
        if(this.thongbaoService.xacNhanThongBao(idthongbao) == true && this.userService.updateQuanLy(this.thongbaoService.getIDUserByIDThongbao(idthongbao)) == true){
            return true;
        }
        return false;
    } 
}
