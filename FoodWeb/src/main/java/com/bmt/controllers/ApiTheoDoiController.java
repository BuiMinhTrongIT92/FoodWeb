/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.controllers;

import com.bmt.pojo.Quidinh;
import com.bmt.pojo.User;
import com.bmt.service.TheoDoiService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
public class ApiTheoDoiController {
    
    @Autowired
    private TheoDoiService theoDoiService;
    
    @PostMapping("/theodoi")
    public boolean getQuiDinhByID(@RequestBody Map<String,String> param,HttpSession session) {
        User u = (User) session.getAttribute("currentUser");
        try {
            this.theoDoiService.capNhatTrangThaiTheoDoi(u.getId(), param.get("idcuahang"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
