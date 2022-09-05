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
        <link rel="stylesheet" href="jquery.rateyo.css"/>
        <script src="jquery.js"></script>
        <script src="jquery.rateyo.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/rateYo/2.3.2/jquery.rateyo.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/rateYo/2.3.2/jquery.rateyo.min.js"></script>
        <script src="<c:url value="/js/chat.js"/>"></script>
        <script src="<c:url value="/vendors/fontawesome/all.min.js"/>"></script>      
        <script src="https://www.gstatic.com/firebasejs/9.9.4/firebase-app.js"/>"></script>
        <script src="https://www.gstatic.com/firebasejs/9.9.4/firebase-database.js"/>"></script> 
        <script src="https://www.gstatic.com/firebasejs/9.9.4/firebase-analytics.js"/>"></script>
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
                    <div>
                        <div><img class="avatar" src="${currentUser.avatar}" alt="alt"/></div>
                        <div><h4>${currentUser.tennguoidung}</h4></div>
                    </div>
                    <hr/>
                    <div class="trinhdieukhien">
                        <div class="homethongke"><a onclick="showthongke()" /><i class="fas fa-chart-line"></i>Thống kê</a>
                            <div id="thongke" c style="display: none">
                                <div><a style="text-decoration: none" class="acolor"  href="<c:url value="/adminhethong/tansuatbanhang"/>"><spring:message code="tableonstate.tansuatbanhang"/></a></div>
                                <div><a style="text-decoration: none" class="acolor" href="<c:url value="/adminhethong/tongspkinhdoanh"/>"><spring:message code="tableonstate.tongspkinhdoanh"/></a></div>
                            </div>
                        </div>
                    </div>
                    <br/>


                    <div>
                        <div class="cuahangcontroll">
                            <a href="<c:url value="/adminhethong/xacnhancuahang"/>" style="text-decoration: none">
                                <div type = "button">
                                    <i class="fas fa-receipt"></i>  Xác nhận cửa hàng
                                </div>
                            </a>
                        </div>
                    </div>
                    <div>
                        <div class="cuahangcontroll">
                            <a href="<c:url value="/adminhethong/quanlynguoidung"/>" style="text-decoration: none">
                                <div type = "button">
                                    <i class="fas fa-user"></i>  Người dùng
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-10">
                <main id="top">
                    <tiles:insertAttribute name="header"/>
                    <tiles:insertAttribute name="content"/>
                </main>
            </div>
        </div>

    </body>
</html>
<script src="<c:url value="/js/indexjs.js"/>"></script>
<script src="<c:url value="/js/chart.js"/>"></script>