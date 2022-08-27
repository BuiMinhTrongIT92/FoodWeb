/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.configs.handlers;

import com.bmt.pojo.User;
import com.bmt.service.UserService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 *
 * @author ACER
 */
@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler{
    @Autowired
    private UserService userDetailsService;
    
    //    Phương thức sẽ được gọi sau khi đăng nhập thành công thay cho DefaultSuccessFul
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication a) throws IOException, ServletException {
        //(Authentication a) lưu trữ User mặc định(của Spring) trong session nhưng chỉ có trường name
//        Muốn lấy toàn bộ thông tin User thì tự xử lý
        User u = this.userDetailsService.getUsers(a.getName()).get(0);
        
        //Gán đối tượng vào session
        request.getSession().setAttribute("currentUser", u);
        
        response.sendRedirect("/FoodWeb");
    }
    
}
