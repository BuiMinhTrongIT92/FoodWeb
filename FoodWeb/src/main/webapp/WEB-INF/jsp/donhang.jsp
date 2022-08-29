<%-- 
    Document   : donhang.jsp
    Created on : Aug 19, 2022, 12:16:56 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<h1 class="admintitle">Quản lý đơn hàng</h1>
<c:url value="/api/donhang" var="donhang"></c:url>
<select class="form-control form__input" id="donhangcuahang" onclick="getDonHang('${donhang}')">
    <c:forEach items="${donhangcuahang}" var="donhangcuahang">
        <option value="${donhangcuahang.idcuahang}">${donhangcuahang.tencuahang}</option>
    </c:forEach>
</select>
<div class="table-wrapper-scroll-y my-custom-scrollbar">
    <table class="table table-bordered table-striped mb-0">
        <thead>
            <tr class="themcuahangheadtable">
                 <th scope="col"><spring:message code="donhang.iddonhang"/></th>
                <th scope="col"><spring:message code="donhang.ngaytao"/></th>
                <th scope="col"><spring:message code="donhang.khuyenmai"/></th>
                <th scope="col"><spring:message code="donhang.trangthai"/></th>
                <th scope="col"><spring:message code="donhang.tongtien"/></th>
                
                
            </tr>
        </thead>
        <tbody id="donhang">

        </tbody>
    </table>
</div>
<hr style="height: 10px"/>
<div class="table-wrapper-scroll-y my-custom-scrollbar">
    <table class="table table-bordered table-striped mb-0">
        <thead>
            <tr class="themcuahangheadtable">
               <th scope="col"><spring:message code="chitietdonhang.iddonhangmonan"/></th>
                <th scope="col"><spring:message code="chitietdonhang.iddonhang"/></th>
                <th scope="col"><spring:message code="chitietdonhang.tenmonan"/></th>
                <th scope="col"><spring:message code="chitietdonhang.soluong"/></th>
                <th scope="col"><spring:message code="chitietdonhang.gia"/></th>
                <th scope="col"><spring:message code="chitietdonhang.tongtien"/></th>
            </tr>
        </thead>
        <tbody id="chitietdonhang">

        </tbody>
    </table>
</div>
<script src="<c:url value="/js/indexjs.js"/>"></script>