/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.controllers;

import com.bmt.pojo.User;
import com.bmt.service.UserService;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.xml.bind.DatatypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author NhatTien
 */
@Controller
public class NguoiDungController {

    @Autowired
    private UserService userDetailsService;

    @GetMapping("/dangnhap")
    public String dangnhap() {
        return "dangnhap";
    }

    @GetMapping("/dangky")
    public String dangkyview(Model model) {
        model.addAttribute("user", new User());
        return "dangky";
    }

    @PostMapping("/dangky")
    public String dangky(Model model, @ModelAttribute(value = "user") User user) throws ParseException, NoSuchAlgorithmException {

        String err = "";
        try {
            if (user.getMatkhau().equals(user.getNhaplaimatkhau())) {
                if (this.userDetailsService.addUser(user) == true) {
                    return "redirect:/dangnhap";
                }
            }
            else{
                err = "Mật khẩu không khớp";
            }

        } catch (Exception ex) {
            err = "Đăng ký lỗi";
        }

        model.addAttribute("erro", err);
        return "dangky";
    }

}
