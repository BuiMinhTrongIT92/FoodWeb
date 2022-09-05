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
                <a class="navbar-brand" href="#">
                    <img src="${chitietloaimonan.anhloaimonan}" alt="Logo" class="rounded-circle" style="width:200px; height: 200px;">
                </a>
                <div class="col-md-7 col-lg-6 text-md-start text-center" style="padding-top: 10%; padding-left: 8%;">
                    <h1 class="display-1 fs-md-5 fs-lg-6 fs-xl-8 text-light" style="color: white !important; font-size: 40px !important;">${chitietloaimonan.tenloai}</h1>
                </div>
            </div>
        </div>
    </div>
</section>

<section class="py-4 overflow-hidden" style="margin-top: 5px;">
    <div class="fw-bold text-danger fs-3 fs-lg-5 lh-sm my-6 container"><spring:message code="content.monanthucdon"/> <spring:message code="chitietloaimonan.cua"/> ${chitietloaimonan.tenloai}</div>
    <div class="container" style="display: flex"> 
        <div class="row h-100">
            <div class="col-12">
                <div class="carousel slide" id="carouselPopularItems" data-bs-touch="false" data-bs-interval="false">
                    <div class="carousel-inner mb-6">
                        <div class="carousel-item active" data-bs-interval="10000">
                            <div class="row gx-3 h-100 align-items-center it">
                                <c:if test="${monantheoidloaimon.size() == 0}">
                                    <p>
                                        <strong class="text-danger"><spring:message code="chitietloaimonan.khongcomonan"/></strong>
                                    </p>
                                </c:if>
                                <c:forEach items="${monantheoidloaimon}" var="m">
                                    <div class="card">
                                        <img style="width:280px;height: 200px" class="card-img-top" src="${m.anhmonan}" alt="Card image">
                                        <div class="card-body">
                                            <h5 class="fw-bold text-1000 text-truncate mb-1">${m.tenmonan}</h5>
                                            <div><span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span>
                                                <span class="text-primary">${m.getIdcuahang().getDiachi()}</span>
                                                <hr/>
                                                <h5 class="fw-bold text-1000 text-truncate mb-1"><spring:message code="content.tencuahang"/></h5>
                                                <button type="submit" class="shopee-sort-by-options__option" class="text-primary" type="button"/><a class="text-primary" href="<c:url value="/chitietcuahang/${m.getIdcuahang().getIdcuahang()}" />">${m.getIdcuahang().getTencuahang()}</a></button>
                                            </div>
                                            <p class="fw-bold text-1000 text-truncate mb-1">
                                                <fmt:formatNumber type="number" value="${m.gia}" maxFractionDigits="3" /> <spring:message code="timkiem.donvimonan" />
                                                <c:url value="/api/giohang" var="giohang"/>
                                            </p>
                                            <div class="buttons">
                                                <div class="d-grid gap-2 buttons_style"><a class="btn btn-lg btn-primary buttons_style_text" href="<c:url value="/chitietmonan/${m.getIdmonan()}" />" role="button"><spring:message code="btn.xemchitiet"/></a></div>
                                                <div class="d-grid gap-2 buttons_style"><a class="btn btn-lg btn-danger buttons_style_text" onclick="
                                                        themMonAnVaoGio('${giohang}',${m.idmonan}, '${m.tenmonan}',${m.gia}, '${m.anhmonan}')" href="#" role="button"><spring:message code="btn.datngay"/></a></div>
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