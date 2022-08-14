/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.controllers;

import com.bmt.pojo.Giohang;
import com.bmt.pojo.Monan;
import com.bmt.pojo.Thongbao;
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
import com.bmt.service.ThongBaoService;
import com.bmt.service.UserService;
import com.bmt.utils.Utils;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ACER
 */
@Controller
@ControllerAdvice
public class HomeController {

    @Autowired
    private MonAnService monAnService;

    @Autowired
    private CuaHangService cuaHangService;

    @Autowired
    private LoaiMonAnService loaiMonAnSerive;

    @Autowired
    private ThongBaoService thongBaoService;

    @Autowired
    private UserService userDetailsService;

    @Autowired
    private Environment env;

    @ModelAttribute
    public void commonAttrs(Model model, HttpSession session) {
        model.addAttribute("currentUser", session.getAttribute("currentUser"));
        model.addAttribute("giosize", Utils.countGio((Map<Integer, Giohang>) session.getAttribute("gio")));
        
    }

    @RequestMapping("/")
    @Transactional
    public String index(Model model, @RequestParam Map<String, String> params, HttpSession session) throws ParseException {

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
        model.addAttribute("ngayconlai", ls);

        //Lấy món ăn phổ biến
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        model.addAttribute("monanphobien", monAnService.getMonAnPhoBien(page));
        model.addAttribute("soluongmonanphobien", monAnService.getMonAnPhoBien(0).size());
        model.addAttribute("loaimonan", loaiMonAnSerive.getLoaiMonAn());
        model.addAttribute("pageSize", Integer.parseInt(env.getProperty("page.size")));

//        User us = (User) session.getAttribute("currentUser");
//        model.addAttribute("check", this.thongBaoService.checkThongBao(us));
        
        Map<Integer, Giohang> l = (Map<Integer, Giohang>) session.getAttribute("gio");
        if(l != null){
            model.addAttribute("gioinfo",l.values());
        }else
            model.addAttribute("gioinfo",null);
        return "index";
    }

    @RequestMapping("/guiyeucau")
    public String guiYeuCau(HttpSession session) {

        User u = (User) session.getAttribute("currentUser");
        this.thongBaoService.taoThongBao(u);

        return "redirect:/";
    }

}
