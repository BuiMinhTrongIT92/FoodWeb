<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                                            <fmt:formatNumber type="number" value="${m[2]}" maxFractionDigits="3" /> <spring:message code="timkiem.donvimonan" />
                                            <div class="buttons">
                                                <div class="d-grid gap-2 buttons_style"><a class="btn btn-lg btn-primary buttons_style_text" href="<c:url value="/chitietmonan/${m[0]}" />" role="button"><spring:message code="btn.xemchitiet"/></a></div>
                                                <div class="d-grid gap-2 buttons_style"><a class="btn btn-lg btn-danger buttons_style_text" href="#" role="button"><spring:message code="btn.datngay"/></a></div>
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
    </div><!-- end of .container-->
</section>