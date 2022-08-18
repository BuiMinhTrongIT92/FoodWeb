<%-- 
    Document   : header
    Created on : Jul 22, 2022, 3:09:15 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
    <div class="container-fluid">
    
      <a class="navbar-brand d-inline-flex" href="<c:url value="/"/>">
        <img class="d-inline-block" src="<c:url value="/img/gallery/logo.svg"/>" alt="logo" />
    </a>
  </div>
  <div class="container-fluid">
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="mynavbar">
      <ul class="navbar-nav me-auto">
        <li class="nav-item">
          <a class="nav-link" href="javascript:void(0)"><i class="far fa-bell"></i></a>
        </li>
        
      </ul>
      
    </div>
  </div>
</nav>
