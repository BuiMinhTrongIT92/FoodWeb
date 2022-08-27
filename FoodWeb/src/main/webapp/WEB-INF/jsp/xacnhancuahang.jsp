<%-- 
    Document   : xacnhandonhang
    Created on : Aug 25, 2022, 12:56:37 PM
    Author     : ACER
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="table-wrapper-scroll-ymenu my-custom-scrollbarmenu">

    <table class="table table-bordered table-striped mb-0">
        <thead class="themcuahangheadtable">
            <tr>
                <th scope="col"><spring:message code="xacnhancuahang.noidung"/></th>
                <th scope="col"><spring:message code="xacnhancuahang.tencuahang"/></th>
                <th scope="col"></th>
            </tr>
        </thead>
        <tbody>
            <c:if test="${thongbaochoxacnhan.size() > 0}">
                <c:forEach items="${thongbaochoxacnhan}" var="thongbaochoxacnhan">
                    <tr>
                        <td>${thongbaochoxacnhan.noidung}</td>
                        <td>${thongbaochoxacnhan.iduser.tennguoidung}</td>
                        <td><input type="submit" class="btn btn-warning" value="Xác nhận" onclick="xacNhanCuaHang(${thongbaochoxacnhan.idthongbao})"></td>
                    </tr>
                </c:forEach>
            </c:if>

        </tbody>
    </table>
</div>
<script src="<c:url value="/js/indexjs.js"/>"></script>
