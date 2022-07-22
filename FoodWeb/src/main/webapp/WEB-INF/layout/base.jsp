<%-- 
    Document   : base
    Created on : Jul 22, 2022, 3:09:55 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><tiles:insertAttribute name="title"/></title>
    </head>
    <body>
        <tiles:insertAttribute name="header"/>
        <tiles:insertAttribute name="content"/>
        <tiles:insertAttribute name="footer"/>
    </body>
</html>
