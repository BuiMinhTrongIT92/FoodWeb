/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.configs;

import com.bmt.configs.handlers.LoginSuccessfulHandler;
import com.bmt.configs.handlers.LogoutSuccessfullHandler;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author ACER
 */
@Configuration
@EnableWebSecurity
@EnableTransactionManagement
@ComponentScan(basePackages = {
    "com.bmt.repository",
    "com.bmt.service",})
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationSuccessHandler loginSuccessHandler;

    @Autowired
    private LogoutSuccessHandler logoutSuccessfullHandler;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public Cloudinary cloudinary() {
        Cloudinary cloudinary
                = new Cloudinary(ObjectUtils.asMap(
                        "cloud_name", "trongbui",
                        "api_key", "333674776249545",
                        "api_secret", "eR1kMCmWx_-NkROxOuJPuDKnuJI",
                        "secure", true));
        return cloudinary;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/dangnhap").usernameParameter("taikhoan").passwordParameter("matkhau");
        //=========Login===========
//        Lấy đầy đủ thông tin user trong session khi thực thi sẽ chạy trước http.formLogin().defaultSuccessUrl("/").....
        http.formLogin().successHandler(this.loginSuccessHandler).failureUrl("/dangnhap?erro");
//        http.formLogin().defaultSuccessUrl("/").failureUrl("/dangnhap?erro");

        //=========Logout===========
//        http.logout().logoutSuccessUrl("/dangnhap");
        http.logout().logoutSuccessHandler(this.logoutSuccessfullHandler);

//        http.authorizeRequests().antMatchers("/").permitAll()
//                .antMatchers("/**/binhluan").authenticated();

        http.csrf().disable();
    }

    @Bean
    public AuthenticationSuccessHandler loginSuccessHandler() {
        return new LoginSuccessfulHandler();
    }

    @Bean
    public LogoutSuccessHandler logoutSuccessfullHandler() {
        return new LogoutSuccessfullHandler();
    }
}
