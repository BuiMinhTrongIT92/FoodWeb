/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.controllers;

import com.bmt.pojo.Cuahang;
import com.bmt.pojo.User;
import com.bmt.service.CuaHangService;
import com.bmt.service.DonHangMonAnService;
import com.bmt.service.ThongBaoService;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ACER
 */
@Controller
@RequestMapping("/admin")
@ControllerAdvice
public class AdminController {

    @Autowired
    private ThongBaoService thongBaoService;

    @Autowired
    private DonHangMonAnService donHangMonAnService;

    @Autowired
    private CuaHangService cuaHangService;

    @GetMapping("/xacnhancuahang")
    public String xacNhanCuaHang(Model model) {
        model.addAttribute("thongbaochoxacnhan", this.thongBaoService.getThongBaoChoXacNhan());
        return "xacnhancuahang";
    }

    @GetMapping("/tansuatbanhang")
    public String tanSuatBanHang(Model model, HttpSession session, @RequestParam(required = false) Map<String, String> params) throws ParseException {

        List<Cuahang> allch = this.cuaHangService.getAllCuaHang();
        List<Double> tansuat = new ArrayList<>();
        try {
            int thang = 0;
            int quy = 0;
            int nam = 0;
            if (params.get("thang") != null) {
                thang = Integer.parseInt(params.get("thang"));
            }
            if (params.get("quy") != null) {
                quy = Integer.parseInt(params.get("quy"));
            }
            if (params.get("nam") != null) {
                nam = Integer.parseInt(params.get("nam"));
            }
            for (Cuahang ch : allch) {
                double sodon = this.donHangMonAnService.demSoDonTheoThang(ch.getIdcuahang(), thang, nam).size();
                double sokh = this.donHangMonAnService.demSoKhachHangTheoThang(ch.getIdcuahang(), thang, nam).size();
                tansuat.add(sodon / sokh);
            }
            model.addAttribute("cuahang", allch);
            model.addAttribute("tansuat", tansuat);
            
            List<Double> tansuatquynam = new ArrayList<>();
            if (quy != 0 && nam != 0) {
                for (Cuahang ch : allch) {
                    double sodon = this.donHangMonAnService.demSoDonTheoQuy(ch.getIdcuahang(), quy, nam).size();
                    double sokh = this.donHangMonAnService.demSoKhachHangTheoQuy(ch.getIdcuahang(), quy, nam).size();
                    tansuatquynam.add(sodon / sokh);
                }

            }
            if (quy == 0 && nam != 0 && thang == 0) {
                for (Cuahang ch : allch) {
                    double sodon = this.donHangMonAnService.demSoDonTheoNam(ch.getIdcuahang(), nam).size();
                    double sokh = this.donHangMonAnService.demSoKhachHangTheoNam(ch.getIdcuahang(), nam).size();
                    tansuatquynam.add(sodon / sokh);
                }
            }
            model.addAttribute("cuahangquynam", allch);
            model.addAttribute("tansuatquynam", tansuatquynam);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "tansuatbanhang";
    }

    @GetMapping("/tongspkinhdoanh")
    public String tongSPKinhDoanh(Model model) {
        return "tongspkinhdoanh";
    }

    @ModelAttribute
    public void att(Model model, HttpSession session) {

        model.addAttribute("counttb", this.thongBaoService.getThongBaoChoXacNhan());
    }
}
