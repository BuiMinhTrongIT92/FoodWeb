
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<section class="py-5 overflow-hidden bg-primary" id="home">
    <div class="container">
        <div class="row flex-center">
            <div class="col-md-7 col-lg-6 py-8 text-md-start text-center">
                <h1 class="display-1 fs-md-5 fs-lg-6 fs-xl-8 text-light" id="dangkycontent"><spring:message code="regis.dangnhap"/></h1>
            </div>
        </div>
        <c:if test="${param.erro !=null}">
            <div class="alert alert-danger">
                Có lỗi
            </div>
        </c:if>
        
        <div class="main animate">
            <div class="container_dn b-container" id="b-container_dn">
                <c:url value="/dangnhap" var="action"/>
                <form class="form" action="${action}" method="post">
                    <h2 class="form_title title"><spring:message code="regis.info2"/></h2>
                    <br>
                    <br>
                    <input class="form__input" type="text" placeholder="Tên đăng nhập" name="taikhoan">
                    <input class="form__input" type="password" placeholder="Mật khẩu" name="matkhau"><a class="form__link">Quên mật khẩu?</a>
                    
                    <input type="submit" value="Đăng nhập" class="form__button button submit"/>
                </form>
            </div>

            <div class="switch" id="switch-cnt">
                <div class="switch__container is-hidden" id="switch-c2">
                    <h2 class="switch__title title"><spring:message code="head.nameweb"/></h2>
                    <h2 class="switch__title title"><spring:message code="regis.hi"/></h2>
                    <br> 
                    <p class="switch__description description"><spring:message code="regis.canhbaodangnhap"/></p>
                    <div class="sign-up">
                        <a href="<c:url value="/dangky"/>"><button class="switch__button button switch-btn">ĐĂNG KÝ</button></a>

                    </div>
                </div>
            </div>
        </div>
    </div>
</section>




