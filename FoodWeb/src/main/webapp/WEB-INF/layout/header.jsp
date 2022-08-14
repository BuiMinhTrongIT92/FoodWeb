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
                <c:url value="/monan" var="monan"/>

                <a class="mb-0 fw-bold text-lg-center headcate" href="${monan}"><spring:message code="head.monngon"/></a>
            </div>
            <c:url value="/timkiem" var="timkiem"/>
            <form class="d-flex" action="${timkiem}">
                <input class="form-control me-2" type="text" placeholder="<spring:message code="head.timkiem"/>" name="tukhoa">
                <input type="submit" class="btn btn-primary" value="<spring:message code="head.tim"/> "/>
            </form>
            <div class="mx-auto pt-5 pt-lg-0 d-block d-lg-none d-xl-block"> 
                <div class="dropdown">
                    <c:url value="/giohang" var="giohang"/>
                    <a  href="${giohang}" id="tooltips" >
                        <div class="dropbtn"><i class="fa fa-cart-plus carticon"></i></div>
                        <div class="cartsize" id="cartsize">${giosize}</div>
                    </a>
                    <div class="dropdown-content" id="itemcart">

                    </div>

                </div>
                <table class="table animate" id="bos" >

                    <tbody id="bo">

                    </tbody>

                </table>
            </div>
            <form class="d-flex mt-4 mt-lg-0 ms-lg-auto ms-xl-0">
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
                <c:if test="${currentUser.role == 'QUANLY'}">
                    <div class="alert alert-warning">
                        <c:url value="/danhsachcuahang" var="danhsachcuahang"></c:url>
                        <a href="${danhsachcuahang}" class="btn btn-white text-warning"><i class="fa fa-cart-plus me-2"></i></i></i><spring:message code="head.cuahang"/></a>
                    </div>
                </c:if>

                <c:if test="${currentUser.role == 'NGUOIDUNG'}">
                    <div class="alert alert-warning">
                        <a href="#" class="btn btn-white text-warning" id="myBtn"><i class="fa fa-cart-plus me-2"></i></i></i><spring:message code="head.dangkibanhang"/></a>
                    </div>
                </c:if>
            </div>

            <!-- Modal footer -->
            <div class="modal-footer">
                <a href="<c:url value="/logout"/>" class="btn btn-danger"><spring:message code="head.dangxuat"/></a>
                <c:url value="/api/giohang" var="urll"/>

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
<script src="<c:url value="/js/indexjs.js"/>"></script>

