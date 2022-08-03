/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.controllers;

import com.bmt.pojo.Monan;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bmt.pojo.User;
import com.bmt.service.CuaHangService;
import com.bmt.service.LoaiMonAnService;
import com.bmt.service.MonAnService;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ACER
 */
@Controller
public class HomeController {

    @Autowired
    private MonAnService monAnService;

    @Autowired
    private CuaHangService cuaHangService;
    
    @Autowired
    private LoaiMonAnService loaiMonAnSerive;
    
    @Autowired
    private Environment env;

    @RequestMapping("/")
    @Transactional
    public String index(Model model,@RequestParam Map<String,String> params) throws ParseException {
        
        //Lấy món ăn sắp mở bán
        model.addAttribute("monansapban", monAnService.getMonAnSapBan());
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:sss");
        Date currentDate = new Date();
        Date date1 = null;
        Date date2 = null;

        String endDate = simpleDateFormat.format(currentDate);
        date1 = simpleDateFormat.parse(endDate);
        List<String> ls = new ArrayList<>();
        for (Monan monan : this.monAnService.getMonAnSapBan()) {
            date2 = simpleDateFormat.parse(monan.getThoidiemban().toString());
            long getDiff = Math.abs(date1.getTime() - date2.getTime());
            long getDaysDiff = getDiff / (24 * 60 * 60 * 1000);
            ls.add(String.valueOf(getDaysDiff + 1));
        }
        model.addAttribute("ngayconlai",ls);
        
        
        //Lấy món ăn phổ biến
        
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        model.addAttribute("monanphobien",monAnService.getMonAnPhoBien(page));
        model.addAttribute("soluongmonanphobien",monAnService.getMonAnPhoBien(0).size());
        model.addAttribute("loaimonan",loaiMonAnSerive.getLoaiMonAn());
        model.addAttribute("pageSize",Integer.parseInt(env.getProperty("page.size")));
        
        
        return "index";
    }
}
