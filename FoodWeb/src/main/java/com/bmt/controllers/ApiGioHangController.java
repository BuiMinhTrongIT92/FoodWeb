/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.controllers;

import com.bmt.pojo.Giohang;
import com.bmt.utils.Utils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ACER
 */
@RestController
@RequestMapping("/api")
public class ApiGioHangController {
    
    @PostMapping("/giohang")
    public int themVaoGio(@RequestBody Giohang giohang, HttpSession session){
        Map<Integer,Giohang> gios = (Map<Integer,Giohang>) session.getAttribute("gio");
        if(gios == null){
           gios = new HashMap<>();
        }
        int idmonan = giohang.getIdmonan();
        if(gios.containsKey(idmonan) == true){
            Giohang gio = gios.get(idmonan);
            gio.setSoluong(gio.getSoluong() + 1);
            gio.setTongtien(gio.getSoluong() * gio.getGia());
        }else{
            giohang.setTongtien(giohang.getSoluong() * giohang.getGia());
            gios.put(idmonan, giohang);
        }
            
        session.setAttribute("gio", gios);
        return Utils.countGio(gios);
    } 
    
    @GetMapping("/giohang")
    public ResponseEntity<List<Giohang>> themVaoGio(HttpSession session){
        Map<Integer, Giohang> l = (Map<Integer, Giohang>) session.getAttribute("gio");
        List<Giohang> jh = new ArrayList<>();
        if(l != null){
            for (Giohang gio : l.values()) {
                jh.add(gio);
            }
        }
        return new ResponseEntity<>(jh,HttpStatus.OK);
    } 
    
    @GetMapping("/tongtien")
    public Double tongTien(HttpSession session){
        Map<Integer, Giohang> l = (Map<Integer, Giohang>) session.getAttribute("gio");
        
        Double tongTien = 0.0;
        List<Giohang> jh = new ArrayList<>();
        if(l != null){
            for (Giohang gio : l.values()) {
                tongTien += gio.getTongtien();
            }
        }
        return tongTien;
    } 
}
