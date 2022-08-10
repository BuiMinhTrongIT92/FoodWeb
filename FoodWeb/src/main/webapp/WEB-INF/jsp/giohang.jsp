<%-- 
    Document   : giohang
    Created on : Jul 28, 2022, 5:08:08 PM
    Author     : NhatTien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<section class="py-5 giomau" >
    <div class="container tranggio">
        <div class="row">
            <div class="col-md-8 col-xs-3">

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
                                <tr id="monanitem">
                                    <td><img class="img-thumbnail" src="${montronggio.anhmonan}"/>${montronggio.tenmonan}</td>
                                    <td>
                                        <fmt:formatNumber type="number" value="${montronggio.gia}" maxFractionDigits="3" /> VND
                                    </td>

                                    <td>
                                        <div class="form-group">
                                            <input type="number" value="${montronggio.soluong}" />
                                        </div>
                                    </td>
                                    <td class="btntongtien">
                                        <fmt:formatNumber type="number" value="${montronggio.tongtien}" maxFractionDigits="3" /> VND
                                    </td>
                                    <td>
                                        <button class="btn btn-warning"type="button" value="<spring:message code="giohang.xoa"/>"><spring:message code="giohang.xoa"/></button>
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
                    <table>
                        <tr>
                            <td>
                                Tạm tính
                            </td>
                            <td>
                                sss
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Tổng tiền
                            </td>
                            
                            <td id="tongtien">
                                
                            </td>
                        </tr>
                      
                    </table>
                    
                    <button class="btn" type="button" value="<spring:message code="giohang.thanhtoan"/>"><spring:message code="giohang.thanhtoan"/></button>
                </div>
            </div>
        </div>
    </div>
</section>
<script src="<c:url value="/js/indexjs.js"/>"></script>
<script>
    <c:url value="/api/tongtien" var="tongtien"/>
            window.onload = function () {
                getTongTien('${tongtien}');
            }
</script>