/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.controllers;

import com.bmt.pojo.Monan;
import com.bmt.pojo.Quidinh;
import com.bmt.pojo.User;
import com.bmt.service.CuaHangService;
import com.bmt.service.QuiDinhService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
public class ApiQuiDinhController {

    @Autowired
    private QuiDinhService quiDinhService;

    @Autowired
    private CuaHangService cuaHangService;

    @GetMapping("/getquidinh/{idquidinh}")
    public ResponseEntity<List<Quidinh>> getQuiDinhByID(@PathVariable(value = "idquidinh") String idquidinh) {
        List<Quidinh> ma = new ArrayList<>();
        ma.add(this.quiDinhService.getAllQuiDinhByID(Integer.parseInt(idquidinh)));
        return new ResponseEntity<>(ma, HttpStatus.OK);
    }

    @PostMapping("/themquidinh")
    public boolean themQuiDinh(@RequestBody Map<String, String> param, HttpSession session) {
        User u = (User) session.getAttribute("currentUser");
        Quidinh qd = new Quidinh();
        try {
            if(param.get("tenquidinh") != null && param.get("noidungquidinh") != "" && param.get("noidungquidinh") != null
                    && param.get("activequidinh") != null && param.get("cuahangquidinh") != null ){
            qd.setTenquidinh(param.get("tenquidinh"));
            qd.setNoidung(param.get("noidungquidinh"));
            qd.setIduser(u);
            if (param.get("activequidinh").contains("true")) {
                qd.setActive(true);
            } else {
                qd.setActive(false);
            }
            qd.setIdcuahang(this.cuaHangService.getCuaHangByID(param.get("cuahangquidinh")));
            this.quiDinhService.themQuiDinh(qd);
            return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    @PutMapping("/suaquidinh")
    public boolean suaQuiDinh(@RequestBody Map<String, String> param, HttpSession session) {
        User u = (User) session.getAttribute("currentUser");
        
        
        try {
            if (param.get("tenquidinh") != null && param.get("noidungquidinh") != null && param.get("noidungquidinh") != ""
                    && param.get("activequidinh") != null && param.get("cuahangquidinh") != null ) {
                Quidinh qd = this.quiDinhService.getAllQuiDinhByID(Integer.parseInt(param.get("idquidinh")));
                qd.setTenquidinh(param.get("tenquidinh"));
                qd.setNoidung(param.get("noidungquidinh"));
                qd.setIduser(u);
                if (param.get("activequidinh").contains("true")) {
                    qd.setActive(true);
                } else {
                    qd.setActive(false);
                }
                qd.setIdcuahang(this.cuaHangService.getCuaHangByID(param.get("cuahangquidinh")));
                this.quiDinhService.suaQuiDinh(qd);
                return true;
            }

        } catch (Exception e) {
            return false;
        }
        return false;
    }
    
    @DeleteMapping("/xoaquidinh")
    public boolean xoaQuiDinh(@RequestBody Map<String, String> param, HttpSession session) {
        try {
            if (param.get("idquidinh") != null && param.get("idquidinh") != "") {
                this.quiDinhService.xoaQuiDinh(Integer.parseInt(param.get("idquidinh")));
                return true;
            }

        } catch (Exception e) {
            return false;
        }
        return false;
    }
}
