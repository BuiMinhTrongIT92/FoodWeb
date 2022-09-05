/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.controllers;

import com.bmt.pojo.Binhluan;
import com.bmt.pojo.Monan;
import com.bmt.service.CuaHangService;
import com.bmt.service.MonAnService;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
public class ApiBinhLuanController {

    @Autowired
    private MonAnService monAnService;

    @Autowired
    private CuaHangService cuaHangService;

    @GetMapping("/monan/{idMonAn}/binhluan")
    public ResponseEntity<List<Binhluan>> getBinhLuanMonAn(@PathVariable(value = "idMonAn") int idMonAn) {
        return new ResponseEntity<>(this.monAnService.getBinhLuanMonAn(idMonAn), HttpStatus.OK);
    }

    @PostMapping(path = "monan/{idMonAn}/binhluan", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Binhluan> themBinhLuanMonAn(@RequestBody Map<String, String> params) {
        String noiDung = params.get("noidung");
        int idMonAn = Integer.parseInt(params.get("idmonan"));
        Binhluan b = this.monAnService.themBinhLuanMonAn(noiDung, idMonAn);
        return new ResponseEntity<>(b, HttpStatus.CREATED);
    }
    @GetMapping("/cuahang/{idCuaHang}/binhluan")
    public ResponseEntity<List<Binhluan>> getBinhLuanCuaHang(@PathVariable(value = "idCuaHang") String idCuaHang) {
        return new ResponseEntity<>(this.cuaHangService.getBinhLuanCuaHang(idCuaHang), HttpStatus.OK);
    }

    @PostMapping(path = "cuahang/{idCuaHang}/binhluan", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Binhluan> themBinhLuanCuaHang(@RequestBody Map<String, String> params) {
        String noiDung = params.get("noidung");
        String idCuaHang = String.valueOf(params.get("idcuahang"));
        Binhluan b = this.cuaHangService.themBinhLuanCuaHang(noiDung, idCuaHang);
        return new ResponseEntity<>(b, HttpStatus.CREATED);
    }
}
