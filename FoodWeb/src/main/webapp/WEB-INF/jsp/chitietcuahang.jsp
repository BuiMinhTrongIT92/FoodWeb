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
                    <img src="https://res.cloudinary.com/ou-hcm/image/upload/v1659539258/Eq_it-na_pizza-margherita_sep2005_sml_bvljsr.jpg" alt="Logo" class="rounded-circle" style="width:200px; height: 200px;">
                </a>

                <div class="col-md-7 col-lg-6 text-md-start text-center" style="padding-top: 10%; padding-left: 8%;">
                    <h1 class="display-1 fs-md-5 fs-lg-6 fs-xl-8 text-light" style="color: black !important; font-size: 20px !important;">${chitietcuahang.tencuahang}</h1>  

                    <div style="display: flex;">
                        <span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span>
                        <span class="display-1 fs-md-5 fs-lg-6 fs-xl-8 text-light" style="color: orange !important; font-size: 16px !important; padding-top: 5px;">${chitietcuahang.diachi}</span>
                    </div>
                </div>

            </div>
        </div>
    </div>
</section>

<section class="py-4 overflow-hidden" style="margin-top: 10px;">
    <div class="container" style="display: flex">
        <div class="row h-100">
            <div class="col-12">
                <div class="carousel slide" id="carouselPopularItems" data-bs-touch="false" data-bs-interval="false">
                    <div class="carousel-inner">
                        <div class="carousel-item active" data-bs-interval="10000">
                            <div class="row gx-3 h-100 align-items-center">
                                <c:forEach items="${monantheoidcuahang}" var="m">
                                    <div class="col-md-3 col-xs-9" style="margin-bottom: 50px;">
                                        <div class="card card-span h-100 rounded-3"><img class="img-fluid rounded-3 h-100" src="${m[3]}" alt="..."/>
                                            <div class="card-body ps-0">
                                                <h5 class="fw-bold text-1000 text-truncate mb-1">${m[1]}</h5>
                                                <div><span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span>
                                                    <span class="text-primary"></span>
                                                </div>
                                                <div>
                                                    <button type="submit" class="shopee-sort-by-options__option" class="text-primary" type="button"/><a class="text-primary" href="<c:url value="/chitietcuahang/${m[0]}" />">${m[1]}</a></button>
                                                </div>
                                                <span class="text-1000 fw-bold">
                                                    <fmt:formatNumber type="number" maxFractionDigits="3" value="${m[2]}" /> <spring:message code="timkiem.donvimonan" />
                                                </span>
                                            </div>
                                        </div>

                                        <div class="buttons">
                                            <div class="d-grid gap-2 buttons_style"><a class="btn btn-lg btn-primary buttons_style_text" href="#!" role="button"><spring:message code="btn.xemchitiet" /></a></div>
                                            <div class="d-grid gap-2 buttons_style"><a class="btn btn-lg btn-danger buttons_style_text" href="#!" role="button"><spring:message code="btn.datngay" /></a></div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                    <button class="carousel-control-prev carousel-icon" type="button" data-bs-target="#carouselPopularItems" data-bs-slide="prev"><span class="carousel-control-prev-icon hover-top-shadow" aria-hidden="true"></span><span class="visually-hidden">Previous</span></button>
                    <button class="carousel-control-next carousel-icon" type="button" data-bs-target="#carouselPopularItems" data-bs-slide="next"><span class="carousel-control-next-icon hover-top-shadow" aria-hidden="true"></span><span class="visually-hidden">Next </span></button>
                </div>
            </div>
        </div>
    </div><!-- end of .container-->
</section>