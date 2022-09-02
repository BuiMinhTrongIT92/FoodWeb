
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div>
    <h1 class="admintitle">${cuahang.tencuahang}</h1>
    <div class="row">
        <div class="col-md-5">
            
            <div class="form-group cuahanginput">
                <select class="form-control form__input" placeholder="<spring:message code="quidinh.tenquidinh"/>" id="tenquidinh">
                    <option value="vanchuyen">Vận chuyển</option>
                </select>
                <input type="text" placeholder="<spring:message code="quidinh.noidung"/>" id="noidungquidinh" class="form-control form__input"/>
                <select class="form-control form__input" placeholder="<spring:message code="monan.active"/>" id="activequidinh">
                    <option value="true">Bật</option>
                    <option value="false">Tắt</option>
                </select>
                <select class="form-control form__input" placeholder="<spring:message code="quidinh.tencuahang"/>" id="cuahangquidinh">
                    <c:if test="${listcuahang.size() > 0}">
                        <c:forEach items="${listcuahang}" var="listcuahang">
                            <option value="${listcuahang.idcuahang}">${listcuahang.tencuahang}</option>
                        </c:forEach>
                    </c:if>
                </select>
            </div>
        </div>
        
    </div>
    <input type="button" class="btn btn-warning form__input" onclick="themQuiDinh()" value="<spring:message code="monan.them"/>"/>
    <input id="suaquidinh" type="button" class="btn btn-success form__input" value="<spring:message code="monan.sua"/>"/>
    <input id="xoaquidinh" type="button" class="btn btn-danger form__input" value="<spring:message code="monan.xoa"/>"/>
    <div class="table-wrapper-scroll-y my-custom-scrollbar">
        <table class="table">
            <tr class="themcuahangheadtable">
                <td><spring:message code="quidinh.idquidinh"/></td>
                <td><spring:message code="quidinh.tenquidinh"/></td>
                <td><spring:message code="quidinh.noidung"/></td>
                <td><spring:message code="quidinh.active"/></td>
                <td><spring:message code="quidinh.tencuahang"/></td>

            </tr>
            <c:if test="${allquidinh.size() > 0}">
                <c:forEach items="${allquidinh}" var="allquidinh">
                    <tr class="allloaimonan themcuahangitem" onclick="getQuiDinh(${allquidinh.idquidinh})">
                        <td>${allquidinh.idquidinh}</td>
                        <td>${allquidinh.tenquidinh}</td>
                        <td>${allquidinh.noidung}</td>
                        <c:if test="${allquidinh.active == true}">
                            <td><i style="color: green" class="fas fa-check-circle"></i></td>
                            </c:if>
                            <c:if test="${allquidinh.active == false}">
                            <td><i style="color: red" class="fas fa-times-circle"></i></td>
                            </c:if>
                            
                        <td>${allquidinh.idcuahang.tencuahang}</td>

                    </tr>
                </c:forEach>
            </c:if>
        </table>
    </div>

</div>

<script src="<c:url value="/js/indexjs.js"/>"></script>
