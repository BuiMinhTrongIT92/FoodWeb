<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<section class="py-4 overflow-hidden" style="margin-top: 50px;">
    <div class="fw-bold text-danger fs-3 fs-lg-5 lh-sm my-6 container"><spring:message code="timkiemloaimonan.danhsachloai"/></div>
    
    <ul class="pagination container timtheomuc" style="padding-left: 8%">
        <c:forEach begin="1" end="${Math.ceil(demLoaiMonAn/loaiMonAnPageSize)}" var="i">
            <c:url value="/loaimonan" var="u">
                <c:param name="loaimonan_page" value="${i}" />
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
                                <c:if test="${timkiemloaimonan.size() == 0}">
                                    <p>
                                        <strong class="text-danger"><spring:message code="timkiemloaimonan.khongcoloai"/></strong>
                                    </p>
                                </c:if>
                                <c:forEach items="${timkiemloaimonan}" var="t">
                                    <div class="card cart-cuahang">
                                        <a class="navbar-brand" href="<c:url value="chitietloaimonan/${t.idloaimonan}" />">
                                            <img src="${t.anhloaimonan}" alt="Logo" class="rounded-circle" style="width:220px; height: 220px;">
                                        </a>
                                        <div class="card-body-loaimonan">
                                            <h5 class="fw-bold text-1000 text-truncate mb-1" style="text-align: center">
                                                <a href="<c:url value="chitietloaimonan/${t.idloaimonan}" />">${t.tenloai}</a>
                                            </h5>                           
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
