/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.service.impl;

import com.bmt.pojo.User;
import com.bmt.repository.UserRepository;
import com.bmt.service.UserService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER
 */
@Service("userDetailsService")
@PropertySource("classpath:template.properties")
public class UserServiceImpl implements UserService {

    @Autowired
    private Environment env;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public boolean addUser(User user) {
        try {
            String matkhau = user.getMatkhau();
            UUID uuid = UUID.randomUUID();
            user.setId(uuid.toString());
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date;
            date = formatter.parse(String.valueOf(java.time.LocalDateTime.now()));
            user.setActive(true);
            user.setNgaytao(date);
            user.setMatkhau(this.passwordEncoder.encode(matkhau));
            user.setRole(User.NGUOIDUNG);
        } catch (ParseException ex) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.userRepository.addUser(user);
    }

    @Override
    public List<User> getUsers(String taikhoan) {
        return this.userRepository.getUsers(taikhoan);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> users = this.getUsers(username);
        if (users.isEmpty()) {
            throw new UsernameNotFoundException(env.getProperty("loadUserByUsernameERRO"));
        }
        User user = users.get(0);
        Set<GrantedAuthority> auth = new HashSet<>();
        auth.add(new SimpleGrantedAuthority(user.getRole()));
        return new org.springframework.security.core.userdetails.User(user.getTaikhoan(), user.getMatkhau(), auth);
    }

}
