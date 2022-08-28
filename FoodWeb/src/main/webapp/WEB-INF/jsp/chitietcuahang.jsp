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
                    <img src="${chitietcuahang.logo}" alt="Logo" class="rounded-circle" style="width:200px; height: 200px;">
                </a>
                <div class="col-md-7 col-lg-6 text-md-start text-center" style="padding-top: 10%; padding-left: 8%;">
                    <h1 class="display-1 fs-md-5 fs-lg-6 fs-xl-8 text-light" style="color: black !important; font-size: 40px !important;">${chitietcuahang.tencuahang}</h1>  

                    <div style="display: flex;">
                        <span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span>
                        <span class="display-1 fs-md-5 fs-lg-6 fs-xl-8 text-light" style="color: orange !important; font-size: 16px !important; padding-top: 5px;">${chitietcuahang.diachi}</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<section class="py-4 overflow-hidden" style="margin-top: 5px;">
    <div class="fw-bold text-danger fs-3 fs-lg-5 lh-sm my-6 container"><spring:message code="content.monanthucdon"/></div>
    <div class="container" style="display: flex"> 
        <div class="row h-100">
            <div class="col-12">
                <div class="carousel slide" id="carouselPopularItems" data-bs-touch="false" data-bs-interval="false">
                    <div class="carousel-inner mb-6">
                        <div class="carousel-item active" data-bs-interval="10000">
                            <div class="row gx-3 h-100 align-items-center it">
                                <c:if test="${monantheoidcuahang.size() == 0}">
                                    <p>
                                        <strong class="text-danger"><spring:message code="chitietcuahang.khongcomonan"/></strong>
                                    </p>
                                </c:if>
                                <c:forEach items="${monantheoidcuahang}" var="m">
                                    <div class="card">
                                        <img style="width:280px;height: 200px" class="card-img-top" src="${m[3]}" alt="Card image">
                                        <div class="card-body">
                                            <h5 class="fw-bold text-1000 text-truncate mb-1">${m[1]}</h5>
                                            <div><span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span>
                                                <span class="text-primary">${m[5]}</span>
                                                <hr/>
                                                <h5 class="fw-bold text-1000 text-truncate mb-1"><spring:message code="content.tencuahang"/></h5>
                                                <span class="text-primary">${m[4]}</span>
                                            </div>
                                            <p class="fw-bold text-1000 text-truncate mb-1">
                                                <fmt:formatNumber type="number" value="${m[2]}" maxFractionDigits="3" /> <spring:message code="timkiem.donvimonan" />
                                                <c:url value="/api/giohang" var="giohang"/>
                                            </p>
                                            <div class="buttons">
                                                <div class="d-grid gap-2 buttons_style"><a class="btn btn-lg btn-primary buttons_style_text" href="<c:url value="/chitietmonan/${m[0]}" />" role="button"><spring:message code="btn.xemchitiet"/></a></div>
                                                <div class="d-grid gap-2 buttons_style"><a class="btn btn-lg btn-danger buttons_style_text" onclick="
                                                        themMonAnVaoGio('${giohang}',${m[0]}, '${m[1]}',${m[2]}, '${m[3]}')" href="#" role="button"><spring:message code="btn.datngay"/></a></div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="fw-bold text-danger fs-3 fs-lg-5 lh-sm my-6 container"><spring:message code="chitietmonan.nhanxet"/></div>

    <sec:authorize access="!isAuthenticated()">
        <div class="container">
            <p><spring:message code="chitietcuahang.luuy" /></p>
            <c:url value="/dangnhap" var="dangnhap"/>
            <p><a href="${dangnhap}" class="text-primary fw-bold"><spring:message code="regis.dangnhap" /></a> <spring:message code="chitiet.taiday" /></p>
        </div>
    </sec:authorize>

    <sec:authorize access="isAuthenticated()">
        <c:url value="/api/cuahang/${chitietcuahang.idcuahang}/binhluan" var="endpoint"/>
        <spring:message code="chitiet.xacnhanbinhluan" var="xacnhan"/>
        <spring:message code="chitiet.binhluanthanhcong" var="thanhcong"/>
        <spring:message code="chitiet.binhluanthatbai" var="thatbai"/>
        <form class="d-flex" style="padding-left: 10%; padding-right: 25%;">
            <textarea id="noidungBLCH" class="form-control me-2" placeholder="<spring:message code="chitietmonan.binhluan"/>"></textarea>
            <input type="submit" class="btn btn-primary" value="<spring:message code="chitietmonan.gui"/>" style="height: 50px;" 
                   onclick="themBinhLuanCuaHang('${endpoint}', '${chitietcuahang.idcuahang}', '${xacnhan}', '${thanhcong}', '${thatbai}')"/>
        </form>
    </sec:authorize>

    <c:url value="/api/cuahang/${chitietcuahang.idcuahang}/binhluan" var="endpoint"/>
    <div id="binhluancuahang" style="padding-left: 15%; padding-right: 25%; padding-top: 5%;">
        <li></li>
    </div>
</section>

<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment-with-locales.min.js"></script>
<script src="<c:url value="/js/binhluan.js" />" ></script>
<script>

                       window.onload = function () {
                           loadBinhLuanCuaHang('${endpoint}');
                       };
</script>

