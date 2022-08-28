/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.service.impl;

import com.bmt.pojo.User;
import com.bmt.repository.UserRepository;
import com.bmt.service.UserService;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
import org.springframework.web.multipart.MultipartFile;

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
    
    @Autowired
    private Cloudinary cloudinary;

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
            MultipartFile kq = user.getFile();
            if(!kq.isEmpty())
            {
                Map r = cloudinary.uploader().upload(kq.getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));
                user.setAvatar((String) r.get("secure_url"));
            }
            user.setAvatar("https://res.cloudinary.com/trongbui/image/upload/v1660229878/uc2kvbarpqepjdlh8hhc.webp");
        } catch (ParseException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
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
         Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole()));

        return new org.springframework.security.core.userdetails.User(
                user.getTaikhoan(), user.getMatkhau(), authorities);
    }

    @Override
    public boolean updateQuanLy(String iduser) {
        return this.userRepository.updateQuanLy(iduser);
    }

    @Override
    public User getUserByTaiKhoan(String taiKhoan) {
        return this.userRepository.getUserByTaiKhoan(taiKhoan);
    }

}
