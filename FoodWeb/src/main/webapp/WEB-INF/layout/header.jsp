<%-- 
    Document   : header
    Created on : Jul 22, 2022, 3:09:15 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top" data-navbar-on-scroll="data-navbar-on-scroll">
    <div class="container"><a class="navbar-brand d-inline-flex" href="<c:url value="/"/>"><img class="d-inline-block" src="<c:url value="/img/gallery/logo.svg"/>" alt="logo" /><span class="text-1000 fs-3 fw-bold ms-2 text-gradient"><spring:message code="head.nameweb"/></span></a>

        <div class="collapse navbar-collapse border-top border-lg-0 my-2 mt-lg-0" id="navbarSupportedContent">
            <div class="mx-auto pt-5 pt-lg-0 d-block d-lg-none d-xl-block">
                <!--                <p class="mb-0 fw-bold text-lg-center">Deliver to: <i class="fas fa-map-marker-alt text-warning mx-2"></i><span class="fw-normal">Current Location </span><span>Mirpur 1 Bus Stand, Dhaka</span></p>-->
                <a class="mb-0 fw-bold text-lg-center headcate " href="#"><spring:message code="head.trangchu"/></a>
            </div>
            <div class="mx-auto pt-5 pt-lg-0 d-block d-lg-none d-xl-block">   
                <a class="mb-0 fw-bold text-lg-center headcate" href="#"><spring:message code="head.menu"/></a>              
            </div>
            <div class="mx-auto pt-5 pt-lg-0 d-block d-lg-none d-xl-block">   
                <a class="mb-0 fw-bold text-lg-center headcate" href="#"><spring:message code="head.loaimon"/></a>               
            </div>
            <div class="mx-auto pt-5 pt-lg-0 d-block d-lg-none d-xl-block"> 
                <a class="mb-0 fw-bold text-lg-center headcate" href="#"><spring:message code="head.monngon"/></a>
            </div>

            <form class="d-flex mt-4 mt-lg-0 ms-lg-auto ms-xl-0">
                <div class="input-group-icon pe-2"><i class="fas fa-search input-box-icon text-primary"></i>
                    <input class="form-control border-0 input-box bg-100" type="search" placeholder="<spring:message code="head.timkiem"/>" aria-label="Search" />
                </div>

                <c:if test="${pageContext.request.userPrincipal.name ==null}">
                    <c:url value="/dangnhap" var="dangnhap"/>
                    <a href="${dangnhap}" class="btn btn-white shadow-warning text-warning"><i class="fas fa-user me-2"></i><spring:message code="regis.dangnhap"/></a>
                        <c:url value="/dangky" var="dangky"/>
                    <a href="${dangky}" class="btn btn-white shadow-warning text-warning autosize"><i class="fas fa-user me-2"></i><spring:message code="regis.dangky"/></a>
                    </c:if>

                <c:if test="${pageContext.request.userPrincipal.name !=null}">
                    <a class="text-warning autosize" data-bs-toggle="modal" data-bs-target="#myModal"><img src="${currentUser.avatar}" alt="Avatar" class="avatar"></a>
                    </c:if>
            </form>
        </div>
    </div>
</nav>

<div class="modal" id="myModal">
    <div class="modal-dialog animate">
        <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title text-warning"><div data-bs-toggle="modal" data-bs-target="#myModal" ><spring:message code="head.thongtin"/>: ${currentUser.tennguoidung}</div></h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>

            <!-- Modal body -->
            <div class="modal-body">
                <!--<div><img src="${currentUser.avatar}" class="img-thumbnail col-md-12 " alt="Cinque Terre"></div>-->
                <div class="alert alert-warning">
                    <a href="#" class="btn btn-white text-warning"><i class="fas fa-user me-2"></i><spring:message code="head.thongtincanhan"/></a>
                </div>
                <div class="alert alert-warning">
                    <a href="#" class="btn btn-white text-warning"><i class="fa fa-cart-plus me-2"></i></i></i><spring:message code="head.cuahang"/></a>
                </div>
                <c:if test="${check == false}">
                    <div class="alert alert-warning">
                        <a href="#" class="btn btn-white text-warning" id="myBtn"><i class="fa fa-cart-plus me-2"></i></i></i><spring:message code="head.dangkibanhang"/></a>
                    </div>
                </c:if>
            </div>

            <!-- Modal footer -->
            <div class="modal-footer">
                <a href="<c:url value="/logout"/>" class="btn btn-danger"><spring:message code="head.dangxuat"/></a>

            </div>

        </div>
    </div>
</div>

<div id="quidinh" class="quidinh">
    <!-- Modal content -->
    <div class="quidinh-content animate">
        <span class="close" style="color: red">&times;</span>
        <p>Qui định..........................</p>
        <div class="xacnhancuahang"><a href="<c:url value="/guiyeucau"/>" class="btn btn-danger"><spring:message code="head.xacnhandangkycuahang"/></a></div>

    </div>

</div>