/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.controllers;

import com.bmt.pojo.Binhluan;
import com.bmt.service.DanhGiaService;
import com.bmt.service.MonAnService;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author NhatTien
 */
@Controller
@RequestMapping("/chitietmonan")
public class ChiTietMonAnController {

    @Autowired
    private MonAnService monAnService;

    @Autowired
    private DanhGiaService danhGiaService;
    
    @GetMapping("/{idmonan}")
    public String index(Model model,
            @PathVariable(value = "idmonan") int idMonAn,
            @RequestParam Map<String, String> params) {
        model.addAttribute("chitietmonan", this.monAnService.getMonAnByID(idMonAn));
        try {
            model.addAttribute("tongsosao", this.danhGiaService.tongSoSaoMonAn(idMonAn));
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("demdanhgiamonan", this.danhGiaService.demDanhGiaMonAn(idMonAn));
        return "chitietmonan";
    }
}
