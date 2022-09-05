<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<section class="py-5 giomau bg-primary" >
    <div class="container tranggio">
        <div id="spin" style="display: none"><div class="spinner-border text-warning"></div></div>
        <div>
            <div class="col-md-8 col-xs-3" style="display: flex;">
                <div class="col-md-7 col-lg-6 text-md-start text-center" style="padding-left: 8%;">
                    <h1 class="display-1 fs-md-5 fs-lg-6 fs-xl-8 text-light" style="color: white !important; font-size: 40px !important;"><spring:message code="menuthucan.danhsach"/></h1>  
                </div>
            </div>
        </div>
    </div>
</section>

<section class="py-4 overflow-hidden" style="margin-top: 5px;">
    <div class="container" style="display: flex"> 
        <div class="row h-100">
            <div class="col-12">
                <div class="carousel slide" id="carouselPopularItems" data-bs-touch="false" data-bs-interval="false">
                    <div class="carousel-inner mb-6">
                        <div class="carousel-item active" data-bs-interval="10000">
                            <div class="row gx-3 h-100 align-items-center it">
                                <c:forEach items="${menuthucan}" var="m">
                                    <c:url value="/chitietmenu/${m[2]}" var="cUrl">
                                        <c:param name="idMenu" value="${m[2]}" />
                                    </c:url>
                                    <div class="card" style="width:350px;height: 120px">
                                        <div class="menuthucan-tieude" style="align-items: center">
                                            <img src="${m[0]}" alt="Logo" class="rounded-circle" style="width:25px; height: 25px;">
                                            <h5 class="fw-bold text-1000 text-truncate mb-1 menuthucan-tencuahang" style="text-align: center">${m[4]}</h5>
                                        </div>
                                        <div class="buttons">
                                            <div class="d-grid gap-2 buttons_style">
                                                <a class="btn btn-lg btn-danger" style="font-size: 14px !important" href="${cUrl}" role="button"><spring:message code="btn.xemchitietmenu"/></a>
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
</section>