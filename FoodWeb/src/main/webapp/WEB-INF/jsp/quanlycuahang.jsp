<%-- 
    Document   : themcuahang
    Created on : Aug 15, 2022, 8:09:16 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<div>
    <h1 class="admintitle">Quản lý cửa hàng</h1>
    <c:url value="/admin/cuahang/quanlycuahang" var="quanlycuahang"/>
    <div class="form-group cuahanginput">
        <input type="text" placeholder="<spring:message code="dangkycuahang.tencuahang"/>" id="tencuahang" class="form-control form__input"/>
        <input type="text" placeholder="<spring:message code="dangkycuahang.diachi"/>" id="vitri" class="form-control form__input"/>
        <select id="status" class="form-control form__input" placeholder="<spring:message code="dangkycuahang.active"/>">
            <c:forEach items="allcuahang" var="allcuahang">
                <option value="true">Bật</option>
                <option value="false">Tắt</option>
            </c:forEach>
        </select>
        <input id="file-upload" type="file" onchange="oncliv()" class="form-control form__input"/>
        <input id="luu" type="button" class="btn btn-warning form__input" onclick="luu()" value="<spring:message code="dangkycuahang.dangky"/>"/>
        <input id="sua" type="button" class="btn btn-success form__input" onclick="" value="<spring:message code="dangkycuahang.sua"/>"/>
        <input id="xoach" type="button" class="btn btn-danger form__input" value="<spring:message code="dangkycuahang.xoa"/>"/>
    </div>
    <div class="table-wrapper-scroll-y my-custom-scrollbar">
        <table class="table">
            <tr class="themcuahangheadtable">
                <td><spring:message code="dangkycuahang.tencuahang"/></td>
                <td><spring:message code="dangkycuahang.diachi"/></td>
                <td><spring:message code="dangkycuahang.active"/></td>
                <td><spring:message code="dangkycuahang.logo"/></td>
            </tr>
            <c:if test="${listcuahang.size() > 0}">
                <c:forEach items="${listcuahang}" var="listcuahang">
                    <tr class="themcuahangitem" onclick="suacuahang('${listcuahang.idcuahang}')">
                        <td>${listcuahang.tencuahang}</td>
                        <td>${listcuahang.diachi}</td>
                        <c:if test="${listcuahang.active == true}">
                            <td><i style="color: green" class="fas fa-check-circle"></i></td>
                            </c:if>
                            <c:if test="${listcuahang.active == false}">
                            <td><i style="color: red" class="fas fa-times-circle"></i></td>
                            </c:if>
                        <td><img src="${listcuahang.logo}" alt="alt" class="avatar" id="logo"/></td>

                    </tr>
                </c:forEach>
            </c:if>
        </table>
    </div>
    </div>

    <script src="<c:url value="/js/indexjs.js"/>"></script>
    <script type="text/javascript">
                        var CLOUDINARY_URL = "https://api.cloudinary.com/v1_1/trongbui/upload"
                        var CLOUDINARY_UPLOAD_PRESET = "svzzed5s"

                        var imgPreview = document.getElementById('img-preview');
                        var fileUpload = document.getElementById('file-upload');

                        fileUpload.addEventListener('change', function (event) {
                            var file = event.target.files[0];
                            var formData = new FormData();
                            formData.append('file', file);
                            formData.append('upload_preset', CLOUDINARY_UPLOAD_PRESET);

                            axios({
                                url: CLOUDINARY_URL,
                                method: 'POST',
                                headers: {
                                    'Content-Type': 'application/x-www-form-urlencoded'
                                },
                                data: formData
                            }).then(function (res) {
                                l = res.data.secure_url;
                            }).then(function (err) {
                                console.error(err);
                            });
                        })

    </script>
