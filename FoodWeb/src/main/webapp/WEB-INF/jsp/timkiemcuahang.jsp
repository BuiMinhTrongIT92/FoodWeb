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
                    <h1 class="display-1 fs-md-5 fs-lg-6 fs-xl-8 text-light" style="color: white !important; font-size: 40px !important;"><spring:message code="timkiemcuahang.cuahang"/></h1>  
                </div>
            </div>
        </div>
    </div>
</section>

<section class="py-4 overflow-hidden" style="margin-top: 5px;">
    <div class="fw-bold text-danger fs-3 fs-lg-5 lh-sm my-6 container"><spring:message code="timkiemcuahang.danhsachcuahang"/></div>

    <ul class="pagination container timtheomuc" style="padding-left: 8%">
        <c:forEach begin="1" end="${Math.ceil(demCuaHang/cuaHangPageSize)}" var="i">
            <c:url value="/timkiemcuahang" var="u">
                <c:param name="cuahang_page" value="${i}" />
            </c:url>
            <li class="page-item"><a class="page-link fw-bold" href="${u}">${i}</a></li>
            </c:forEach>
    </ul>  

    <div class="container" style="display: flex"> 
        <div class="row h-100">
            <div class="col-12">
                <div class="carousel slide" id="carouselPopularItems" data-bs-touch="false" data-bs-interval="false">
                    <div class="carousel-inner mb-6">
                        <div class="carousel-item active" data-bs-interval="10000">
                            <div class="row gx-3 h-100 align-items-center it">
                                <c:if test="${timkiemcuahang.size() == 0}">
                                    <p>
                                        <strong class="text-danger"><spring:message code="timkiemcuahang.khongcocuahang"/></strong>
                                    </p>
                                </c:if>
                                <c:forEach items="${timkiemcuahang}" var="t">
                                    <div class="card cart-cuahang">
                                        <div id="over">
                                            <a class="navbar-brand" href="<c:url value="chitietcuahang/${t.idcuahang}" />">
                                                <img src="${t.logo}" alt="Logo" class="rounded-circle" style="width:250px; height: 250px;">
                                            </a>
                                        </div>
                                        <div class="card-body" style="text-align: center">
                                            <h5 class="fw-bold text-1000 text-truncate mb-1">
                                                <a href="<c:url value="chitietcuahang/${t.idcuahang}" />">${t.tencuahang}</a>
                                            </h5>
                                            <div><span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span>
                                                <span class="text-primary">${t.diachi}</span>
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
