<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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

    <div class="fw-bold text-danger fs-3 fs-lg-5 lh-sm my-6 container"><spring:message code="chitietmonan.nhanxet"/></div>

    <sec:authorize access="!isAuthenticated()">
        <div class="container">
            <p><spring:message code="chitietmonan.luuy" /></p>
            <c:url value="/dangnhap" var="dangnhap"/>
            <p><a href="${dangnhap}" class="text-primary fw-bold"><spring:message code="regis.dangnhap" /></a> <spring:message code="chitiet.taiday" /></p>
        </div>
    </sec:authorize>

    <sec:authorize access="isAuthenticated()">
        <c:url value="/api/monan/${chitietmonan.idmonan}/binhluan" var="endpoint"/>
        <spring:message code="chitiet.xacnhanbinhluan" var="xacnhan"/>
        <spring:message code="chitiet.binhluanthanhcong" var="thanhcong"/>
        <spring:message code="chitiet.binhluanthatbai" var="thatbai"/>
        <form class="d-flex" style="padding-left: 10%; padding-right: 25%;">
            <textarea id="noidungBL" class="form-control me-2" placeholder="<spring:message code="chitietmonan.binhluan"/>"></textarea>
            <input type="submit" class="btn btn-primary" value="<spring:message code="chitietmonan.gui"/>" style="height: 50px;" 
                   onclick="themBinhLuanMonAn('${endpoint}', ${chitietmonan.idmonan}, '${xacnhan}', '${thanhcong}', '${thatbai}')"/>
        </form>
    </sec:authorize>

    <c:url value="/api/monan/${chitietmonan.idmonan}/binhluan" var="endpoint"/>
    <div id="binhluanmonan" style="padding-left: 15%; padding-right: 25%; padding-top: 5%;">
        
    </div>
</section>

<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment-with-locales.min.js"></script>
<script src="<c:url value="/js/binhluan.js" />" ></script>
<script>

                   window.onload = function () {
                       loadBinhLuanMonAn('${endpoint}');
                   };
</script>
