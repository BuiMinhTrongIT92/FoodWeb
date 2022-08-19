/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.controllers;

import com.bmt.pojo.Cuahang;
import com.bmt.pojo.User;
import com.bmt.service.CuaHangService;
import com.bmt.service.MonAnService;
import com.cloudinary.Cloudinary;
import java.io.IOException;
import com.cloudinary.utils.ObjectUtils;
import java.util.Map;
import java.util.UUID;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ACER
 */
@Controller
@RequestMapping("/admin")
public class CuaHangController {

    @Autowired
    private Cloudinary cloudinary;
    
    @Autowired
    private CuaHangService cuaHangService;
    
    @Autowired
    private MonAnService monanService;

    @GetMapping("/cuahang")
    public String cuaHang(Model model) {
        model.addAttribute("cuahang", new Cuahang());
        return "cuahang";
    }
    
    @GetMapping("/cuahang/quanlycuahang")
    public String themCuaHang(Model model) {
        model.addAttribute("cuahang", new Cuahang());
        return "quanlycuahang";
    }
    
    @GetMapping("/cuahang/{idcuahang}")
    public String cuahang(Model model, @PathVariable(value = "idcuahang") String idcuahang, HttpSession session) {
        String idch = (String) session.getAttribute("idch");
        if (idch == null) {
            session.setAttribute("idch", idcuahang);
        } else {
            session.setAttribute("idch", idcuahang);
        }
        model.addAttribute("cuahang", this.cuaHangService.getCuaHangByID(idcuahang));
        model.addAttribute("allmonan", this.monanService.getALLMonAnByCuaHang(idcuahang));
        return "cuahang";
    }
    
//    @PostMapping("/cuahang/quanlycuahang")
//    public String thmCuaHang(Model model, HttpSession session, @ModelAttribute(value = "cuahang") Cuahang cuahang) throws IOException {
//        User u = (User) session.getAttribute("currentUser");
//        UUID id = UUID.randomUUID();
//        cuahang.setIdcuahang(id.toString());
//        cuahang.setIduser(u);
//        MultipartFile kq = cuahang.getFile();
//        if (!kq.isEmpty()) {
//            Map r = cloudinary.uploader().upload(kq.getBytes(),
//                    ObjectUtils.asMap("resource_type", "auto"));
//            cuahang.setLogo((String) r.get("secure_url"));
//        }else
//            cuahang.setLogo("https://res.cloudinary.com/trongbui/image/upload/v1658997161/cld-sample-2.jpg");
//        if(!cuahang.getTencuahang().isEmpty() && !cuahang.getDiachi().isEmpty() && !cuahang.getIdcuahang().isEmpty()){
//            this.cuaHangService.themCuaHang(cuahang);
//        }
//        
//        return "redirect:/admin/cuahang/quanlycuahang";
//    }

}
