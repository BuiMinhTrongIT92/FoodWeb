/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.controllers;

import com.bmt.pojo.Cuahang;
import com.bmt.pojo.User;
import com.bmt.service.CuaHangService;
import com.bmt.service.LoaiMonAnService;
import com.bmt.service.MonAnService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ACER
 */
@Controller
@RequestMapping("/admin")
@ControllerAdvice
public class QuanLyController {

    @Autowired
    private CuaHangService cuaHangService;

    @Autowired
    private MonAnService monAnService;

    @Autowired
    private LoaiMonAnService loaiMonAnSerivce;

    @GetMapping("/thongkesp")
    public String thongKeSP(Model model, HttpSession session, @RequestParam(required = false) Map<String, String> params) throws ParseException {
        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
        String kw = params.getOrDefault("kw", null);
        User u = (User) session.getAttribute("currentUser");
        Date tungay = null;
        Date denngay = null;
        try {
            String tu = params.getOrDefault("tungay", null);
            if (tu != null) {
                tungay = fm.parse(tu);
            }

            String den = params.getOrDefault("denngay", null);
            if (den != null) {
                denngay = fm.parse(den);
            }
            if (!params.get("thang").isEmpty() && !params.get("nam").isEmpty() ) {
                model.addAttribute("thongkemonantheothang", this.monAnService.thongKeDoanhThuMonAnTheoThang(Integer.parseInt(params.get("thang")), Integer.parseInt(params.get("nam")),u.getId()));
            }
            if (params.get("loai").contains("day")) {
                model.addAttribute("thongkemonan", this.monAnService.thongKeDoanhThuMonAn(kw, tungay, denngay,u.getId()));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("thongkemonan", this.monAnService.thongKeDoanhThuMonAn(kw, tungay, denngay,u.getId()));

        String quy = params.getOrDefault("quy", null);
        String nam = params.getOrDefault("nam", null);
//        model.addAttribute("thongkemonanquynam", this.monAnService.thongKeDoanhThuMonAnTheoQuy(4, 2022));
        try {
            if (quy != null && nam != null) {
                model.addAttribute("thongkemonanquynam", this.monAnService.thongKeDoanhThuMonAnTheoQuy(Integer.parseInt(quy), Integer.parseInt(nam),u.getId()));
            }
            if (quy.contains("0") && nam != null) {
                model.addAttribute("thongkemonanquynam", this.monAnService.thongKeDoanhThuMonAnTheoNam(Integer.parseInt(nam),u.getId()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "thongkesp";
    }

    @GetMapping("/thongkedanhmuc")
    public String thongKeDanhMuc(Model model, HttpSession session, @RequestParam(required = false) Map<String, String> params) throws ParseException {
        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
        String kw = params.getOrDefault("kw", null);
        User u = (User) session.getAttribute("currentUser");
        Date tungay = null;
        Date denngay = null;
        try {
            String tu = params.getOrDefault("tungay", null);
            if (tu != null) {
                tungay = fm.parse(tu);
            }

            String den = params.getOrDefault("denngay", null);
            if (den != null) {
                denngay = fm.parse(den);
            }
            if (!params.get("thang").isEmpty() && !params.get("nam").isEmpty() ) {
                model.addAttribute("thongkedanhmuctheothang", this.loaiMonAnSerivce.thongKeDoanhThuDanhMucTheoThang(Integer.parseInt(params.get("thang")), Integer.parseInt(params.get("nam")),u.getId()));
            }
            model.addAttribute("thongkedanhmuc", this.loaiMonAnSerivce.thongKeDoanhThuDanhMuc(kw, tungay, denngay,u.getId()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("thongkedanhmuc", this.loaiMonAnSerivce.thongKeDoanhThuDanhMuc(kw, tungay, denngay,u.getId()));
        
        String quy = params.getOrDefault("quy", null);
        String nam = params.getOrDefault("nam", null);
        try {
            if (quy != null && nam != null) {
                        model.addAttribute("thongkedanhmuctheoquy", this.loaiMonAnSerivce.thongKeDoanhThuDanhMucTheoQuy(Integer.parseInt(quy), Integer.parseInt(nam),u.getId()));

            }
            if (quy.contains("0") && nam != null) {
                model.addAttribute("thongkedanhmuctheoquy", this.loaiMonAnSerivce.thongKeDoanhThuDanhMucTheoNam(Integer.parseInt(nam),u.getId()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "thongkedanhmuc";
    }
    @GetMapping("/quanlyloaimon")
    public String quanLyLoaiMon(Model model, HttpSession session, @RequestParam(required = false) Map<String, String> params) throws ParseException {
        model.addAttribute("allloaimonan", this.loaiMonAnSerivce.getAllLoaiMonAn());
        return "quanlyloaimon";
    }

    @ModelAttribute
    public void att(Model model, HttpSession session) {
        User u = (User) session.getAttribute("currentUser");
        model.addAttribute("listcuahang", this.cuaHangService.getAllCuaHangByUser(u));
    }

}
