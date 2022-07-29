/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.controllers;

import com.bmt.pojo.Cuahang;
import com.bmt.service.CuaHangService;
import com.bmt.service.MonAnService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
    public ResponseEntity<List<Cuahang>> allcuaHangHot(){
        return new ResponseEntity<>(this.cuaHangService.getCuaHangNoiBat(0),HttpStatus.OK);
    }
    
    @GetMapping("/cuahanghot")
    public ResponseEntity<List<Cuahang>> cuaHangHot(){
        return new ResponseEntity<>(this.cuaHangService.getCuaHangNoiBat(-1),HttpStatus.OK);
    }
    
}

