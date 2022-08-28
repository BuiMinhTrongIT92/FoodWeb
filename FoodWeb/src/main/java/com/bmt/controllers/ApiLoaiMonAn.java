/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.controllers;

import com.bmt.pojo.DonhangMonan;
import com.bmt.pojo.Giohang;
import com.bmt.pojo.Loaimonan;
import com.bmt.service.LoaiMonAnService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ACER
 */
@RestController
@RequestMapping("/api")
public class ApiLoaiMonAn {
    
    @Autowired
    private LoaiMonAnService loaiMonAnService;
    
    @PostMapping("/themloaimonan")
    public boolean themLoaiMonAn(@RequestBody Loaimonan loaimonan, HttpSession session) {
        try {
            this.loaiMonAnService.themLoaiMon(loaimonan);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    @GetMapping("/getloaimonan/{idloaimon}")
    public ResponseEntity<List<Loaimonan>> getLoaiMonAn(@PathVariable(value = "idloaimon" ) int idloaimonan) {
        List<Loaimonan> loaimonan = new ArrayList<>();
        loaimonan.add(this.loaiMonAnService.getMotLoaiMonAn(idloaimonan));
        return new ResponseEntity<>(loaimonan,HttpStatus.OK);
    }
    
    @PutMapping("/sualoaimonan")
    public boolean suaLoaiMonAn(@RequestBody Loaimonan loaimonan) {
        try {
            this.loaiMonAnService.suaLoaiMon(loaimonan);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
