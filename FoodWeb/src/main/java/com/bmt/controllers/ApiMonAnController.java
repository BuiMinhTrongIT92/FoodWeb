/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.controllers;

import com.bmt.pojo.Cuahang;
import com.bmt.pojo.Monan;
import com.bmt.pojo.User;
import com.bmt.service.CuaHangService;
import com.bmt.service.MonAnService;
import java.util.ArrayList;
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
public class ApiMonAnController {

    @Autowired
    private MonAnService monAnService;
    
    @Autowired
    private CuaHangService cuaHangService;
   
    
    @GetMapping("/getmonan/{idmonan}")
    public ResponseEntity<List<Monan>> getChiTietMonAnByID(@PathVariable(value = "idmonan") int idmon){
        List<Monan> ma = new ArrayList<>();
        ma.add(this.monAnService.getChiTietMonAnByID(idmon));
        return new ResponseEntity<>(ma, HttpStatus.OK);
    }
    
    @PostMapping("/themmonan")
    public boolean themMonAn(@RequestBody Monan monan, HttpSession session) {
        String idch = (String) session.getAttribute("idch");
        try {
            monan.setIdcuahang(this.cuaHangService.getCuaHangByID(idch));
            this.monAnService.themMonAn(monan);
            return true;
        } catch (Exception e) {
            return false;
        }        
    }
    @PutMapping("/suamonan")
    public boolean suaMonAn(@RequestBody Monan monan, HttpSession session) {
        String idch = (String) session.getAttribute("idch");
        try {
            monan.setIdcuahang(this.cuaHangService.getCuaHangByID(idch));
            this.monAnService.suaMonAn(monan);
            return true;
        } catch (Exception e) {
            return false;
        }        
    }
    @DeleteMapping("/xoamonan")
    public boolean xoaMonAn(HttpSession session,@RequestBody Map<String,String> params) {
        try {
            this.monAnService.xoaMonAn(Integer.parseInt(params.get("idmonan")));
            return true;
        } catch (Exception e) {
            return false;
        }        
    }
}
