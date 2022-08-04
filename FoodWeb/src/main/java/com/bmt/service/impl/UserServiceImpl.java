/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.service.impl;

import com.bmt.pojo.User;
import com.bmt.repository.UserRepository;
import com.bmt.service.UserService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
public class UserServiceImpl implements UserService{

//    @Autowired
//    private Environment env;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    @Override
    public boolean addUser(User user) {
//        String matkhau = user.getMatkhau();
//        user.setMatkhau(this.passwordEncoder.encode(matkhau));
//        user.setRole(User.NGUOIDUNG);
        return this.userRepository.addUser(user);
    }

    @Override
    public List<User> getUsers(String taikhoan) {
        return this.userRepository.getUsers(taikhoan);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> users = this.getUsers(username);
        if(users.isEmpty()){
            throw new UsernameNotFoundException("Không tìm thấy");
        }
        User user = users.get(0);
        Set<GrantedAuthority> auth = new HashSet<>();
        auth.add(new SimpleGrantedAuthority(user.getRole()));
        return new org.springframework.security.core.userdetails.User(user.getTaikhoan(),user.getMatkhau(),auth);
    }
    
}
