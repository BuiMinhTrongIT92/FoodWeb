/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.controllers;

import com.bmt.pojo.Danhgia;
import com.bmt.service.CuaHangService;
import com.bmt.service.MonAnService;
import com.google.protobuf.Int32Value;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author NhatTien
 */
@RestController
@RequestMapping("/api")
public class ApiDanhGiaController {
    @Autowired
    private MonAnService monAnService;
    
    @Autowired
    private CuaHangService cuaHangService;
    
    @GetMapping("/monan/{idMonAn}/danhgia")
    public ResponseEntity<List<Danhgia>> getDanhGiaMonAn(@PathVariable(value = "idMonAn") int idMonAn) {
        return new ResponseEntity<>(this.monAnService.getDanhGiaMonAn(idMonAn), HttpStatus.OK);
    }
    
    @PostMapping(path = "monan/{idMonAn}/danhgia", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Danhgia> themDanhGiaMonAn(@RequestBody Map<String, String> params) {
        String soLuong = params.get("sao");
        int idMonAn = Integer.parseInt(params.get("idmonan"));
        Danhgia d = this.monAnService.themDanhGiaMonAn(Double.parseDouble(soLuong), idMonAn);
        return new ResponseEntity<>(d, HttpStatus.CREATED);
    }
    
    @GetMapping("/cuahang/{idCuaHang}/danhgia")
    public ResponseEntity<List<Danhgia>> getDanhGiaCuaHang(@PathVariable(value = "idCuaHang") String idCuaHang) {
        return new ResponseEntity<>(this.cuaHangService.getDanhGiaCuaHang(idCuaHang), HttpStatus.OK);
    }
    
    @PostMapping(path = "cuahang/{idCuaHang}/danhgia", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Danhgia> themDanhGiaCuaHang(@RequestBody Map<String, String> params) {
        String soLuong = params.get("sao");
        String idCuaHang = String.valueOf(params.get("idcuahang"));
        Danhgia d = this.cuaHangService.themDanhGiaCuaHang(Double.parseDouble(soLuong), idCuaHang);
        return new ResponseEntity<>(d, HttpStatus.CREATED);
    }
}
