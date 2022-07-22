<%-- 
    Document   : index
    Created on : Jul 23, 2022, 12:39:59 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div style="height: 900px;background-color: red">
    
    <c:forEach var="u" items="${users}">
        <h1 style="color: white" >${u.tenNguoiDung}</h1>
    </c:forEach>
</div>

