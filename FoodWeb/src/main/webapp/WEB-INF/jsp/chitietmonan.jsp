<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<section class="py-5 giomau" >
    <div class="fw-bold text-danger fs-3 fs-lg-5 lh-sm my-6 container"><spring:message code="content.monanthucdon"/></div>
    <div class="container tranggio">
        <div id="spin" style="display: none"><div class="spinner-border text-warning"></div></div>
        <div style="display: flex">
            <div class="col-md-8 col-xs-3" style="display: flex;">
                <div>
                    <a class="navbar-brand" href="#">
                        <img style="width:300px;height: 300px" class="card-img-top" src="${chitietmonan.anhmonan}" alt="Card image">
                    </a>
                    <div class="navbar-brand" style="width: 100%; margin: 10px;">
                        <p class="fw-bold" style="font-size: 20px !important;"><fmt:formatNumber type="number" value="${chitietmonan.gia}" maxFractionDigits="3" /> <spring:message code="timkiem.donvimonan"/></p>
                        <div><a class="btn btn-lg btn-danger" href="#" role="button"><spring:message code="btn.datngay"/></a></div>
                    </div>
                </div>

                <div style="padding-top: 2%; padding-left: 8%; ">
                    <div style="display: flex">
                        <p class="fw-bold" style="font-size: 15px !important;"><spring:message code="chitietmonan.monngonslimfood"/> <spring:message code="chitietmonan.dau"/>  </p>
                        <p class="fw-bold text-danger" style="font-size: 15px !important;"> ${chitietmonan.tenmonan}</p>
                    </div>

                    <h1 class="display-1 fs-md-5 fs-lg-6 fs-xl-8 text-light" style="color: black !important; font-size: 35px !important;">${chitietmonan.tenmonan}</h1> 
                    <div>
                        <p style="font-size: 20px !important;"><fmt:formatNumber type="number" value="${chitietmonan.gia}" maxFractionDigits="3" /> <spring:message code="timkiem.donvimonan"/></p>
                    </div>

                    <div style="display: flex;">
                        <span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span>
                        <a class="display-1 fs-md-5 fs-lg-6 fs-xl-8 text-light" style="color: orange !important; font-size: 16px !important; padding-top: 5px;" href="<c:url value="/chitietcuahang/${chitietmonan.getIdcuahang().getIdcuahang()}" />">${chitietmonan.getIdcuahang().getTencuahang()}</a>
                    </div>

                    <div style="padding-top: 20px;">     
                        <p style="font-size: 16px !important;">${chitietmonan.mota}</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

