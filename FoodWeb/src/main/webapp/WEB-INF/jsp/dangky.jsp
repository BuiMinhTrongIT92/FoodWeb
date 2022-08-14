<%-- 
    Document   : dangky
    Created on : Jul 28, 2022, 11:54:08 PM
    Author     : NhatTien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<section class="py-5 overflow-hidden bg-primary" id="home">
    <div class="container">
        <div class="row flex-center">
            <div class="col-md-7 col-lg-6 py-8 text-md-start text-center">
                <h1 class="display-1 fs-md-5 fs-lg-6 fs-xl-8 text-light" id="dangkycontent"><spring:message code="regis.dangky"/></h1>
            </div>
        </div>

        <div class="main animate">

            <c:url value="/dangky" var="dangky"/>
            <div class="container_dn b-container" id="b-container_dn">
                <form:form class="form" method="POST" modelAttribute="user" enctype="multipart/form-data">
                    <h2 class="form_title title"><spring:message code="regis.info1"/></h2>
                    <br>
                    <br>
                    <c:if test="${erro !=null}">
                        <div class="alert alert-danger">${erro}</div>
                    </c:if>
                    <div class="form-group">
                        <spring:message code="regis.tennguoidung" var="tennguoidung"/>
                        <form:input type="text" cssClass="form-control form__input" path="tennguoidung" placeholder="${tennguoidung}" />
                    </div>
                    <div class="form-group">
                        <spring:message code="regis.taikhoan" var="taikhoan"/>
                        <form:input type="text" cssClass="form-control form__input" path="taikhoan" placeholder="${taikhoan}" />
                    </div>
                    <div class="form-group">
                        <spring:message code="regis.matkhau" var="matkhau"/>
                        <form:input type="password" cssClass="form-control form__input" path="matkhau" placeholder="${matkhau}" />
                    </div>
                    <div class="form-group">
                        <spring:message code="regis.nhaplaimatkhau" var="nhaplaimatkhau"/>
                        <form:input type="password" cssClass="form-control form__input" path="nhaplaimatkhau" placeholder="${nhaplaimatkhau}" />
                    </div>
                    <div class="form-group">
                        <div>
                            <form:select class="select form__input" path="gioitinh">
                                <option value="1" disabled><spring:message code="regis.gioitinh"/></option>
                                <option value="Nam"><spring:message code="regis.nam"/></option>
                                <option value="Nu"><spring:message code="regis.nu"/></option>
                                <option value="Khac"><spring:message code="regis.khac"/></option>
                            </form:select>
                        </div>  
                    </div>
                    <div class="form-group">
                        <spring:message code="regis.email" var="email"/>
                        <form:input type="text" cssClass="form-control form__input" path="email" placeholder="${email}" />
                    </div>
                    <div class="form-group">
                        <spring:message code="regis.SDT" var="SDT"/>
                        <form:input type="number" cssClass="form-control form__input" path="sdt" placeholder="${SDT}" />
                    </div>
                    <div class="form-group">
                        <spring:message code="regis.diachi" var="diachi"/>
                        <form:input type="text" cssClass="form-control form__input" path="diachi" placeholder="${diachi}" />
                    </div>
                    
                    
                    
                    <button class="form__button button submit"/><spring:message code="regis.dangky"/></button>
                    <div class="form-group">
                        <spring:message code="regis.avatar" var="avatar"/>
                        <form:input type="file" cssClass="form-control form__input" path="file" placeholder="${diachi}" />
                    </div>
                    <button class="form__button button submit"/>ĐĂNG KÝ</button>
                </form:form>
            </div>

            <div class="switch" id="switch-cnt">
                <div class="switch__container is-hidden" id="switch-c2">
                    <h2 class="switch__title title"><spring:message code="head.nameweb"/></h2>
                    <h2 class="switch__title title"><spring:message code="regis.hi"/></h2>
                    <br>
                    <a class="navbar-brand d-inline-flex" href="index.html"><img class="d-inline-block" style="width: 80px; height: 80px;" src="resources/img/logo.png" alt="logo" /><span class="text-1000 fs-3 fw-bold ms-2 text-gradient"><spring:message code="head.nameweb"/></span></a>
                    <br>
                    <p class="switch__description description"><spring:message code="regis.canhbaodangky"/></p>
                </div>
            </div>
            <!--</div>-->

        </div>
</section>
