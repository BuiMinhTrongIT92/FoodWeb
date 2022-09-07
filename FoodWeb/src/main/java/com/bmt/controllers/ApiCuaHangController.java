/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.controllers;

import com.bmt.pojo.Cuahang;
import com.bmt.pojo.Giohang;
import com.bmt.pojo.User;
import com.bmt.service.CuaHangService;
import com.bmt.service.MonAnService;
import com.bmt.utils.Utils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ACER
 */
@RestController
@RequestMapping("/api")
public class ApiCuaHangController {
    
    @Autowired
    private CuaHangService cuaHangService;
    
    @GetMapping("/allcuahanghot")
    public ResponseEntity<List<Object[]>> allcuaHangHot(){
        return new ResponseEntity<>(this.cuaHangService.getCuaHangNoiBat(0),HttpStatus.OK);
    }
    
    @GetMapping("/cuahanghot")
    public ResponseEntity<List<Object[]>> cuaHangHot(){
        return new ResponseEntity<>(this.cuaHangService.getCuaHangNoiBat(-1),HttpStatus.OK);
    }
    
    @GetMapping("/getcuahang/{idcuahang}")
    public ResponseEntity<List<Cuahang>> getCuaHangByID(@PathVariable(value = "idcuahang") String idcuahang){
        List<Cuahang> ch = new ArrayList<>();
        ch.add(this.cuaHangService.getCuaHangByID(idcuahang));
        return new ResponseEntity<>(ch,HttpStatus.OK);
    }
    
    @PutMapping("/capnhatcuahang")
    public boolean capNhatCuahang(@RequestBody Cuahang cuahang, HttpSession session) {
        User u = (User) session.getAttribute("currentUser");
        try {
            cuahang.setIduser(u);
            
            this.cuaHangService.capNhatCuaHang(cuahang);
            return true;
        } catch (Exception e) {
            return false;
        }        
    }
    @DeleteMapping("/xoacuahang")
    public boolean xoaCuahang(@RequestBody Map<String,String> params) {
        
        try {
            this.cuaHangService.xoaCuaHang(params.get("idcuahang"));
            return true;
        } catch (Exception e) {
            return false;
        }        
    }
    
    @PostMapping("/quanlycuahang")
    public boolean themCuahang(@RequestBody Cuahang cuahang, HttpSession session) {
        User u = (User) session.getAttribute("currentUser");
        try {
            UUID id = UUID.randomUUID();
            cuahang.setIdcuahang(id.toString());
            cuahang.setIduser(u);
           
            this.cuaHangService.themCuaHang(cuahang);
            return true;
        } catch (Exception e) {
            return false;
        }        
    }
    
    
    
}

