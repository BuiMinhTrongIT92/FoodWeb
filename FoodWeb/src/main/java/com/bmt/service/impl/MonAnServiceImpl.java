/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.service.impl;

import com.bmt.pojo.Monan;
import com.bmt.repository.MonAnRepository;
import com.bmt.service.MonAnService;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER
 */
@Service
public class MonAnServiceImpl implements MonAnService {

    @Autowired
    private MonAnRepository monAnRepository;

    @Override
    public List<Monan> getMonAnSapBan() {
        return this.monAnRepository.getMonAnSapBan();
    }

}
