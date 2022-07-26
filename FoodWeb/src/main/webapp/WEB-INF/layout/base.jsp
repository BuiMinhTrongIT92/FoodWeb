<%-- 
    Document   : base
    Created on : Jul 22, 2022, 3:09:55 PM
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
        <link href="<c:url value="/css/theme.css"/>" rel="stylesheet" />
        <script src="<c:url value="/js/theme.js"/>"></script>
        <script src="<c:url value="/vendors/fontawesome/all.min.js"/>"></script>
        
    </head>
    <body>
        <main id="top">
            <tiles:insertAttribute name="header"/>
            <tiles:insertAttribute name="content"/>
            <tiles:insertAttribute name="footer"/>
        </main>
    </body>
</html>
