<%-- 
    Document   : dangky
    Created on : Jul 28, 2022, 11:54:08 PM
    Author     : NhatTien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<section class="py-5 overflow-hidden bg-primary" id="home">
    <div class="container">
        <div class="row flex-center">
            <div class="col-md-7 col-lg-6 py-8 text-md-start text-center">
                <h1 class="display-1 fs-md-5 fs-lg-6 fs-xl-8 text-light">Đăng ký</h1>
            </div>
        </div>

        <div class="main">
            <div class="container_dn b-container" id="b-container_dn">
                <form class="form">
                    <h2 class="form_title title">Đăng ký tài khoản</h2>
                    <br>
                    <br>
                    <input class="form__input" type="text" placeholder="Tên người dùng">
                    <input class="form__input" type="text" placeholder="Giới tính">
                    <input class="form__input" type="text" placeholder="Số điện thoại">
                    <input class="form__input" type="text" placeholder="Email">
                    <input class="form__input" type="text" placeholder="Địa chỉ">                
                    <input class="form__input" type="text" placeholder="Tên đăng nhập">
                    <input class="form__input" type="password" placeholder="Mật khẩu">
                    <input class="form__input" type="password" placeholder="Xác nhận mật khẩu">
                    <button class="form__button button submit"/>ĐĂNG KÝ</button>
                </form>
            </div>

            <div class="switch" id="switch-cnt">
                <div class="switch__container is-hidden" id="switch-c2">
                    <h2 class="switch__title title">SlimFood</h2>
                    <h2 class="switch__title title">xin chào!</h2>
                    <br>
                    <a class="navbar-brand d-inline-flex" href="index.html"><img class="d-inline-block" style="width: 80px; height: 80px;" src="resources/img/logo.png" alt="logo" /><span class="text-1000 fs-3 fw-bold ms-2 text-gradient"><spring:message code="head.nameweb"/></span></a>
                    <br>
                    <p class="switch__description description">Hãy nhập đầy đủ các thông tin nhé!</p>
                </div>
            </div>
        </div>
    </div>
</section>
