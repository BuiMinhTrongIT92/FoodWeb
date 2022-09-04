/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.controllers;

import com.bmt.pojo.Monan;
import com.bmt.pojo.User;
import com.bmt.service.UserService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ACER
 */
@RestController
@RequestMapping("/api")
public class ApiNguoiDungController {

    @Autowired
    private UserService userService;

    

    @PostMapping("/chitietnguoidung")
    public ResponseEntity<List<User>> chiTietNguoiDung(@RequestBody Map<String, String> param) {
        List<User> u = new ArrayList<>();
        u.add(this.userService.getUserByID(param.get("idnguoidung")));
        return new ResponseEntity<>(u, HttpStatus.OK);
    }

    @PutMapping("/suanguoidung")
    public boolean suaNguoiDung(@RequestBody Map<String, String> param, HttpSession session) {
        User u = (User) session.getAttribute("currentUser");
        if (param.get("role") != "" || param.get("idnguoidung") != "" || param.get("tennguoidung") != "" || param.get("taikhoan") != "" || param.get("matkhau1") != "" || param.get("nhaplaimatkhau1") != "" || param.get("gioitinh") != ""
                || param.get("email") != "" || param.get("SDT") != "" || param.get("diachi") != "" || param.get("avatar") != "" || param.get("active") != "") {
            try {
                User ucheck = new User();
                ucheck.setId(param.get("idnguoidung"));
                ucheck.setTennguoidung(param.get("tennguoidung"));
                ucheck.setTaikhoan(param.get("taikhoan"));
                if (param.get("matkhau1").contains(param.get("nhaplaimatkhau1"))) {
                    ucheck.setMatkhau(param.get("matkhau1"));
                }else
                    ucheck.setMatkhau(null);
                
                ucheck.setGioitinh(param.get("gioitinh"));
                if (param.get("active").contains("true")) {
                    ucheck.setActive(true);
                } else if (param.get("active").contains("false")) {
                    ucheck.setActive(false);
                }
                ucheck.setRole(param.get("role"));
                ucheck.setEmail(param.get("email"));
                ucheck.setDiachi(param.get("diachi"));
                ucheck.setSdt(Integer.parseInt(param.get("SDT")));

                ucheck.setAvatar(param.get("avatar"));

                this.userService.updateUser(ucheck);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

}
