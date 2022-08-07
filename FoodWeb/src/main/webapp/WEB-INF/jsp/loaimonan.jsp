<%-- 
    Document   : loaimonan
    Created on : Jul 29, 2022, 8:23:51 AM
    Author     : NhatTien
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<section class="py-4 overflow-hidden" style="margin-top: 40px;">
    <div class="container">
        <div class="row h-100">
            <div class="col-12">
                <div class="carousel slide" id="carouselPopularItems" data-bs-touch="false" data-bs-interval="false">
                    <div class="carousel-inner">
                        <div class="carousel-item active" data-bs-interval="10000">
                            <div class="row gx-3 h-100 align-items-center">             
                                <c:forEach items="${loaimonan}" var="l"> 
                                    <div class="col-sm-6 col-md-4 col-xl mb-5 h-100">
                                        <div class="card card-span h-100 rounded-3"><img class="img-fluid rounded-3 h-100" src="${l.anhloaimonan}" alt="..."/>
                                            <div class="card-body ps-0">
                                                <h5 style="text-align: center" class="fw-bold text-1000 text-truncate mb-1">${l.tenloai}</h5>    
                                            </div>
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

