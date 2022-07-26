/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.controllers;

import com.bmt.pojo.Monan;
import com.bmt.service.CuaHangService;
import com.bmt.service.LoaiMonAnService;
import com.bmt.service.MonAnService;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author NhatTien
 */
@Controller
@RequestMapping("/")
@PropertySource("classpath:template.properties")
public class TimKiemController {

    @Autowired
    private MonAnService monAnService;

    @Autowired
    private LoaiMonAnService loaiMonAnService;

    @Autowired
    private CuaHangService cuaHangService;

    @Autowired
    private Environment env;

    @GetMapping("/timkiem")
    public String index(Model model,
            @RequestParam Map<String, String> params) {
        int monan_page = Integer.parseInt(params.getOrDefault("monan_page", "1"));
        model.addAttribute("monan", this.monAnService.getTatCaMonAnCoCheckThoiGian(params, monan_page));
        model.addAttribute("cuahang", this.monAnService.getCuaHangTheoMonAnTimKiem(params, 0));
        model.addAttribute("loaimonan", this.monAnService.getLoaiMonAnTheoMonAnTimKiem(params, 0));
        model.addAttribute("demMonAn", this.monAnService.demTatMonAn());
        model.addAttribute("monAnPageSize", Integer.parseInt(env.getProperty("monan_page.size")));
        return "timkiem";
    }

    @GetMapping("timkiem/caodenthap")
    public String getMonAnGiamDan(Model model, @RequestParam Map<String, String> params) {
        int monan_page = Integer.parseInt(params.getOrDefault("monan_page", "1"));
        model.addAttribute("monan", this.monAnService.getMonAnGiamDanTheoGia(0));
        model.addAttribute("cuahang", this.monAnService.getCuaHangTheoMonAnTimKiem(params, 0));
        model.addAttribute("loaimonan", this.monAnService.getLoaiMonAnTheoMonAnTimKiem(params, 0));
        model.addAttribute("demMonAn", this.monAnService.demTatMonAn());
        model.addAttribute("monAnPageSize", Integer.parseInt(env.getProperty("monan_page.size")));
        return "timkiem";
    }

    @GetMapping("/timkiem/thapdencao")
    public String getMonAnTangDan(Model model, @RequestParam Map<String, String> params) {
        int monan_page = Integer.parseInt(params.getOrDefault("monan_page", "1"));
        model.addAttribute("monan", this.monAnService.getMonAnTangDanTheoGia(0));
        model.addAttribute("cuahang", this.monAnService.getCuaHangTheoMonAnTimKiem(params, 0));
        model.addAttribute("loaimonan", this.monAnService.getLoaiMonAnTheoMonAnTimKiem(params, 0));
        model.addAttribute("demMonAn", this.monAnService.demTatMonAn());
        model.addAttribute("monAnPageSize", Integer.parseInt(env.getProperty("monan_page.size")));
        return "timkiem";
    }

    @GetMapping("/timkiemcuahang")
    public String getCuaHang(Model model, @RequestParam Map<String, String> params) {
        int cuahang_page = Integer.parseInt(params.getOrDefault("cuahang_page", "1"));
        model.addAttribute("timkiemcuahang", this.cuaHangService.getCuaHang(params, cuahang_page));
        model.addAttribute("demCuaHang", this.cuaHangService.demTatCaCuaHang());
        model.addAttribute("cuaHangPageSize", Integer.parseInt(env.getProperty("cuahang_page.size")));
        return "timkiemcuahang";
    }

    @GetMapping("/timkiemloaimonan")
    public String getLoaiMonAn(Model model, @RequestParam Map<String, String> params) {
        int loaimonan_page = Integer.parseInt(params.getOrDefault("loaimonan_page", "1"));
        model.addAttribute("timkiemloaimonan", this.loaiMonAnService.getLoaiMonAnTimKiem(params, loaimonan_page));
        model.addAttribute("demLoaiMonAn", this.loaiMonAnService.demLoaiMonAn());
        model.addAttribute("loaiMonAnPageSize", Integer.parseInt(env.getProperty("loaimonan_page.size")));
        return "timkiemloaimonan";
    }
}
