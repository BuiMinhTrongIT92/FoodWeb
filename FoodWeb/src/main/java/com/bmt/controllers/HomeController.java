/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.controllers;

import com.bmt.service.UserService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bmt.pojo.User;

/**
 *
 * @author ACER
 */
@Controller
public class HomeController {
    
    @Autowired
    private UserService userService;
    
    @RequestMapping("/")
    @Transactional
    public String index(Model model){
        
        model.addAttribute("users",userService.getUser());
        return "index";
    }
}
