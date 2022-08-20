/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.controllers;

import com.bmt.pojo.Cuahang;
import com.bmt.pojo.Donhang;
import com.bmt.pojo.DonhangMonan;
import com.bmt.pojo.Giohang;
import com.bmt.service.DonHangMonAnService;
import com.bmt.utils.Utils;
import java.util.ArrayList;
import java.util.HashMap;
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
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ACER
 */
@RestController
@RequestMapping("/api")
public class ApiDonHangController {

    @Autowired
    private DonHangMonAnService donHangMonAnService;

    @PostMapping("/donhang")
    public ResponseEntity<List<Donhang>> getDonHangByID(@RequestBody Map<String, String> params) {
        List<Donhang> ch = new ArrayList<>();
        if (params.get(params.get("iddonhang")) != "") {
            ch = this.donHangMonAnService.getDonHangByIDCuaHang(params.get("idcuahang"));
        }
        return new ResponseEntity<>(ch, HttpStatus.OK);
    }

    @PostMapping("/donhang/chitietdonhang")
    public ResponseEntity<List<DonhangMonan>> getDetailDonHang(@RequestBody Map<String, String> params) {
        List<DonhangMonan> detail = new ArrayList<>();
        detail = this.donHangMonAnService.getDetailDonHang(params.get("iddonhang"));
        return new ResponseEntity<>(detail, HttpStatus.OK);
    }

    @PostMapping("/donhang/suadonhang")
    public boolean suaDonHang(@RequestBody Map<String, String> params) {
       
                this.donHangMonAnService.suaDonHang(params.get("iddonhang"), params.get("trangthai"));
                return true;
           
    }

}
