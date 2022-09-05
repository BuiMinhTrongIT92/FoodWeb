<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<section class="py-5 giomau" >
    <div class="container tranggio">
        <div id="spin" style="display: none"><div class="spinner-border text-warning"></div></div>
        <div>
            <div class="col-md-8 col-xs-3" style="display: flex;">
                <a class="navbar-brand" href="#">
                    <img src="${cuahangtheoidmenu.logo}" alt="Logo" class="rounded-circle" style="width:200px; height: 200px;">
                </a>
                <div class="col-md-7 col-lg-6 text-md-start text-center" style="padding-top: 10%; padding-left: 8%;">
                    <h1 class="display-1 fs-md-5 fs-lg-6 fs-xl-8 text-light" style="color: black !important; font-size: 40px !important;">${cuahangtheoidmenu.tencuahang}</h1>  

                    <div style="display: flex;">
                        <span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span>
                        <span class="display-1 fs-md-5 fs-lg-6 fs-xl-8 text-light" style="color: orange !important; font-size: 16px !important; padding-top: 5px;">${cuahangtheoidmenu.diachi}</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<section class="py-4 overflow-hidden" style="margin-top: 10px;">
    <div class="fw-bold text-danger fs-3 fs-lg-5 lh-sm my-6 container"><spring:message code="chitietmenu.tenthucdon"/> ${tenmenutheoid.tenmenu}</div>
    <div class="container" style="display: flex"> 
        <div class="row h-100">
            <div class="col-12">
                <div class="carousel slide" id="carouselPopularItems" data-bs-touch="false" data-bs-interval="false">
                    <div class="carousel-inner mb-6">
                        <div class="carousel-item active" data-bs-interval="10000">
                            <div class="row gx-3 h-100 align-items-center it" style="width: 600px;">
                                <c:if test="${monantrongmenu.size() == 0}">
                                    <p>
                                        <strong class="text-danger"><spring:message code="chitietcuahang.khongcomonan"/></strong>
                                    </p>
                                </c:if>
                                 
                                <table class="table cart">
                                    <tr>
                                        <th><spring:message code="chitietmenu.hinhanh" /></th>
                                        <th><spring:message code="chitietmenu.monan" /></th>
                                        <th><spring:message code="chitietmenu.gia" /></th>
                                        <th><spring:message code="chitietmenu.luachon" /></th>
                                    </tr>
                                    <tbody>
                                        <c:forEach items="${monantrongmenu}" var="m">
                                            <tr>
                                                <td>
                                                    <a class="navbar-brand" href="<c:url value="/chitietmonan/${m[3]}" />">
                                                        <img src="${m[2]}" alt="Logo" class="rounded-circle" style="width: 60px; height: 60px;">
                                                    </a>
                                                </td>
                                                <td class="fw-bold">${m[0]}</td>
                                                <td class="fw-bold">
                                                    <fmt:formatNumber type="number" value="${m[1]}" maxFractionDigits="3" /> <spring:message code="timkiem.donvimonan" />
                                                    <c:url value="/api/giohang" var="giohang"/>
                                                </td>
                                                <td>
                                                    <div class="buttons">
                                                        <div class="d-grid gap-2 buttons_style"><a class="btn btn-lg btn-primary buttons_style_text" style="font-size: 14px !important" href="<c:url value="/chitietmonan/${m[3]}" />" role="button"><spring:message code="btn.xemchitiet"/></a></div>

                                                        <div class="d-grid gap-2 buttons_style"><a class="btn btn-lg btn-danger buttons_style_text" style="font-size: 14px !important" onclick="
                                                                themMonAnVaoGio('${giohang}',${m[3]}, '${m[0]}',${m[1]}, '${m[2]}')" href="#" role="button"><spring:message code="btn.datngay"/></a></div>
                                                    </div>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
