<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<section class="py-5 overflow-hidden bg-primary" id="home">
    <div class="container">
        <div class="row flex-center">
            <div class="col-md-7 col-lg-6 py-8 text-md-start text-center">
                <h1 class="display-1 fs-md-5 fs-lg-6 fs-xl-8 text-light">Món ngon</h1>
                <h1 class="display-1 fs-md-5 fs-lg-6 fs-xl-8 text-light">SlimFood</h1>   
            </div>
        </div>
    </div>
</section>

<section class="py-4 overflow-hidden">
    <div class="container">
        <div class="row h-100">
            <div class="col-12">
                <div class="carousel slide" id="carouselPopularItems" data-bs-touch="false" data-bs-interval="false">         
                    <div class="carousel-inner">       
                        <div class="carousel-item active" data-bs-interval="10000">                
                            <div class="row gx-3 h-100 align-items-center">           
                                <c:forEach items="${monan}" var="m">
                                    <div class="col-md-3 col-xs-12" style="margin-bottom: 50px;">
                                        <div class="card card-span h-100 rounded-3"><img class="img-fluid rounded-3 h-100" src="${m.anhmonan}" alt="..."/>
                                            <div class="card-body ps-0">
                                                <h5 class="fw-bold text-1000 text-truncate mb-1">${m.tenmonan}</h5>
                                                <div><span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span><span class="text-primary">${m.idcuahang}</span></div><span class="text-1000 fw-bold">
                                                    <fmt:formatNumber type="number" maxFractionDigits="3" value="${m.gia}" /> VNĐ
                                                </span>
                                            </div>
                                        </div>
                                        <div class="d-grid gap-2"><a class="btn btn-lg btn-danger" href="#!" role="button"><spring:message code="btn.datngay"/></a></div>
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
