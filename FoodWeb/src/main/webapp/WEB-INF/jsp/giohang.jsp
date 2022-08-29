<%-- 
    Document   : giohang
    Created on : Jul 28, 2022, 5:08:08 PM
    Author     : NhatTien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<section class="py-5 giomau" >

    <div class="container tranggio">
        <div id="spin" style="display: none"><div class="spinner-border text-warning"></div></div>
        <div class="row">
            <div class="col-md-8 col-xs-3">
                <c:if test="${thanh != null}">
                    <div>${thanh}</div>
                </c:if>
                <table class="giohanghead table">
                    <thead>
                        <tr>
                    <div><td><spring:message code="giohang.monan"/></td>
                        <td><spring:message code="giohang.gia"/></td>
                        <td><spring:message code="giohang.soluong"/></td>
                        <td colspan="2"><spring:message code="giohang.thanhtien"/></td>
                        <td></td></div>
                    </tr>
                    </thead>
                    <tbody>
                        <c:if test="${monantronggio != null}">
                            <c:forEach items="${monantronggio}" var="montronggio">
                                <tr id="monanitem${montronggio.idmonan}" class="monanitem">
                                    <td><img class="img-thumbnail" src="${montronggio.anhmonan}"/>${montronggio.tenmonan}</td>
                                    <td>
                                        <fmt:formatNumber type="number" value="${montronggio.gia}" maxFractionDigits="3" /> VND
                                    </td>

                                    <td>
                                        <c:url value="/api/giohang" var="giohang"/>
                                        <c:url value="/api/vanchuyen" var="vanchuyen"/>
                                        <div class="form-group">
                                            <input type="number" min="1" value="${montronggio.soluong}" onblur="capNhatGio('${giohang}', '${vanchuyen}', this,${montronggio.idmonan})" />
                                        </div>
                                    </td>
                                    <td class="btntongtien">
                                        <fmt:formatNumber type="number" value="${montronggio.tongtien}" maxFractionDigits="3" /> VND
                                    </td>
                                    <td>
                                        <input class="btn btn-warning" type="button" onclick="xoaMonAn('${giohang}', '${vanchuyen}',${montronggio.idmonan})" value="<spring:message code="giohang.xoa"/>"></input>
                                    </td>

                                </tr>
                            </c:forEach>
                        </c:if>
                        <c:if test="${monantronggio == null}">
                        <h1><spring:message code="giohang.haythemmonan"/></h1>


                    </c:if>
                    </tbody>
                </table>
            </div>
            <div class="col-md-2 col-xs-3">
                <div class="giohangright">


                    <div class="form-group">
                        <div>
                            <div><spring:message code="thanhtoan.hinhthucthanhtoan"/></div>
                            <select class="select form__input selectthanhtoan" name="thanh" onblur="bat(this)">
                                <option value="0" name="0">Trực tiếp</option>
                                <option value="1" name="1">Trực tuyến</option>
                            </select>

                        </div>  
                    </div>
                    <hr/>
                    <table>                        
                        <tr>
                            <td>
                                <spring:message code="thanhtoan.tienvanchuyen"/>
                            </td>
                            <td id="tienvanchuyen">

                            </td>
                        </tr>
                        <tr>
                            <td>
                                <spring:message code="giohang.tongtien"/>
                            </td>

                            <td id="tongtien">

                            </td>
                        </tr>
                    </table>
                    <div>
                        <c:url value="/api/thanhtoan" var="thanhToan"/>
                        <spring:message code="thanhtoan.xacnhan" var="xacnhan"/>
                        <spring:message code="thanhtoan.thanhcong" var="thanhcong"/>
                        <spring:message code="thanhtoan.thatbai" var="thatbai"/>
                        <sec:authorize access="isAuthenticated()">
                            <button class="btn" onclick="thanhToan('${thanhToan}', '${xacnhan}', '${thanhcong}', '${thatbai}')" type="button" value="<spring:message code="giohang.thanhtoan"/>"><spring:message code="giohang.thanhtoan"/></button>
                        </sec:authorize>
                        <sec:authorize access="!isAuthenticated()">
                            <br/>
                            <div class="container">
                                <p><spring:message code="chitietmonan.luuthanhtoan" /></p>
                                <c:url value="/dangnhap" var="dangnhap"/>
                                <p><a href="${dangnhap}" class="text-primary fw-bold"><spring:message code="regis.dangnhap" /></a> <spring:message code="chitiet.taiday" /></p>
                            </div>
                        </sec:authorize>

                    </div>

                </div>
            </div>
        </div>
    </div>
</section>
<script src="<c:url value="/js/indexjs.js"/>"></script>
<script>
    <c:url value="/api/tongtien" var="tongtien"/>
    <c:url value="/api/vanchuyen" var="vanchuyen"/>
                                window.onload = function () {
                                    getTongTien('${tongtien}');
                                    tienVanChuyen('${vanchuyen}');
                                };
</script>