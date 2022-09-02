<%-- 
    Document   : baseadmin
    Created on : Aug 15, 2022, 12:00:39 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><tiles:insertAttribute name="title"/></title>
        <script src="<c:url value="/js/theme.js"/>"></script>
        <link href="<c:url value="/css/dangky_dangnhap.css"/>" rel="stylesheet" />
        <link href="<c:url value="/css/theme.css"/>" rel="stylesheet">

        <script src="<c:url value="/vendors/fontawesome/all.min.js"/>"></script>      

        <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
        <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
        <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">

        <!-- Slider ============================-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.27.2/axios.min.js" integrity="sha512-odNmoc1XJy5x1TMVMdC7EMs3IVdItLPlCeL5vSUPN2llYKMJ2eByTTAIiiuqLg+GdNr9hF6z81p27DArRFKT7A==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
        <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.css" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>
        <div class="row">
            <div class="col-md-2">
                <div class="admincol2">
                    <a href="<c:url value="/"/>">
                        <img class="d-inline-block" src="<c:url value="/img/gallery/logo.svg"/>" alt="logo" /><span class="text-1000 fs-3 fw-bold ms-2 text-gradient"></span></a>

                    </a>
                    <br/>
                    <br/>
                    <div>
                        <div><img class="avatar" src="${currentUser.avatar}" alt="alt"/></div>
                        <div><h4>${currentUser.tennguoidung}</h4></div>
                    </div>
                    <hr/>
                    <div class="trinhdieukhien">
                        <div class="homethongke"><a onclick="showthongke()" /><i class="fas fa-chart-line"></i>Thống kê</a>
                            <div id="thongke" c style="display: none">
                                <div><a style="text-decoration: none" class="acolor"  href="<c:url value="/admin/thongkesp"/>">Doanh thu sản phẩm</a></div>
                                <div><a style="text-decoration: none" class="acolor" href="<c:url value="/admin/thongkedanhmuc"/>">Doanh thu danh mục</a></div>
                            </div>
                        </div>
                    </div>
                    <br/>
                    <div>
                        <div class="cuahangcontroll">
                            <div type = "button" onclick="showcontrol()">
                                <i class="fas fa-store"></i>Cửa hàng<h1><a class="btn btn-success" href="<c:url value="/admin/cuahang/quanlycuahang"/>">Thêm<i class="fas fa-plus-circle"></i></a>

                            </div>
                            <div id="cuahanglist" style="display: none">
                                <c:if test="${listcuahang.size() > 0}">
                                    <c:forEach items="${listcuahang}" var="listcuahang">
                                        <c:url value="/admin/cuahang/${listcuahang.idcuahang}" var="cuahang"></c:url>
                                        <div><a class="acolor" href="${cuahang}">${listcuahang.tencuahang}<c:if test="${listcuahang.active == true}">
                                                    <td><i style="color: green" class="fas fa-check-circle"></i></td>
                                                    </c:if>
                                                    <c:if test="${listcuahang.active == false}">
                                                    <td><i style="color: red" class="fas fa-times-circle"></i></td>
                                                </c:if></a>
                                        </div>
                                    </c:forEach>
                                </c:if>
                            </div>
                        </div>
                    </div>
                    <br/>
                    <div>
                        <div class="cuahangcontroll">
                            <a href="<c:url value="/admin/quanlyloaimon"/>" style="text-decoration: none">
                                <div type = "button">
                                    <i class="fas fa-cookie"></i>  Loại món
                                </div>
                            </a>
                        </div>
                    </div>
                    <div>
                        <div class="cuahangcontroll">
                            <a href="<c:url value="/admin/menu"/>" style="text-decoration: none">
                                <div type = "button">
                                    <i class="fas fa-utensils"></i>  Menu
                                </div>
                            </a>
                        </div>
                    </div>
                    <div>
                        <div class="cuahangcontroll">
                            <a href="<c:url value="/admin/donhang"/>" style="text-decoration: none">
                                <div type = "button">
                                    <i class="fas fa-receipt"></i>  Đơn hàng
                                </div>
                            </a>
                        </div>
                    </div>
                    <div>
                        <div class="cuahangcontroll">
                            <a href="<c:url value="/admin/quanlyquidinh"/>" style="text-decoration: none">
                                <div type = "button">
                                    <i class="fas fa-exclamation-circle"></i>  Qui định
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-10">
                <main id="top">

                    <tiles:insertAttribute name="content"/>
                </main>
            </div>
        </div>

    </body>
</html>
<script src="<c:url value="/js/indexjs.js"/>"></script>
<script src="<c:url value="/js/chart.js"/>"></script>