
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div>
    <h1 class="admintitle">${cuahang.tencuahang}</h1>
    <div class="row">
        <div class="col-md-5">
            <c:url value="/admin/cuahang/quanlycuahang" var="quanlycuahang"/>
            <div class="form-group cuahanginput">
                <input type="text" placeholder="<spring:message code="monan.tenmonan"/>" id="tenmonan" class="form-control form__input"/>
                <input type="number" placeholder="<spring:message code="monan.gia"/>" id="gia" class="form-control form__input"/>
                <input type="number" placeholder="<spring:message code="monan.soluong"/>" id="soluong" class="form-control form__input"/>
                <input type="datetime-local" placeholder="<spring:message code="monan.thoidiemban"/>" id="thoidiemban" class="form-control form__input"/>
                <input type="datetime-local" placeholder="<spring:message code="monan.thoidiemketthuc"/>" id="thoidiemketthuc" class="form-control form__input"/>
            </div>
        </div>
        <div class="col-md-5">
            <select id="trangthai" class="form-control form__input" placeholder="<spring:message code="monan.trangthai"/>">
                <option value="true">Bật</option>
                <option value="false">Tắt</option>
            </select>
            <select id="active" class="form-control form__input" placeholder="<spring:message code="monan.active"/>">
                <option value="true">Bật</option>
                <option value="false">Tắt</option>
            </select>
            <input id="file-upload" type="file" onchange="oncliv()" class="form-control form__input"/>
        </div>
    </div>
    <input id="luu" type="button" class="btn btn-warning form__input" onclick="themmonan()" value="<spring:message code="monan.them"/>"/>
    <input id="suamonan" type="button" class="btn btn-success form__input" onclick="" value="<spring:message code="monan.sua"/>"/>
    <input id="xoa" type="button" class="btn btn-danger form__input" onclick="" value="<spring:message code="monan.xoa"/>"/>
    <div class="table-wrapper-scroll-y my-custom-scrollbar">
    <table class="table">
        <tr class="themcuahangheadtable">
            <td><spring:message code="monan.tenmonan"/></td>
            <td><spring:message code="monan.gia"/></td>
            <td><spring:message code="monan.soluong"/></td>
            <td><spring:message code="monan.thoidiemban"/></td>
            <td><spring:message code="monan.thoidiemketthuc"/></td>
            <td><spring:message code="monan.trangthai"/></td>
            <td><spring:message code="monan.active"/></td>
            <td><spring:message code="monan.anhmonan"/></td>
        </tr>
        <c:if test="${allmonan.size() > 0}">
            <c:forEach items="${allmonan}" var="allmonan">
                <tr class="themcuahangitem" onclick="getmonandetail(${allmonan.idmonan})">
                    <td>${allmonan.tenmonan}</td>
                    <td>${allmonan.gia}</td>
                    <td>${allmonan.soluong}</td>
                    <td>${allmonan.thoidiemban}</td>
                    <td>${allmonan.thoidiemketthuc}</td>
                    <c:if test="${allmonan.trangthai == true}">
                        <td><i style="color: green" class="fas fa-check-circle"></i></td>
                        </c:if>
                        <c:if test="${allmonan.trangthai == false}">
                        <td><i style="color: red" class="fas fa-times-circle"></i></td>
                        </c:if>
                        <c:if test="${allmonan.active == true}">
                        <td><i style="color: green" class="fas fa-check-circle"></i></td>
                        </c:if>
                        <c:if test="${allmonan.active == false}">
                        <td><i style="color: red" class="fas fa-times-circle"></i></td>
                        </c:if>
                    <td><img src="${allmonan.anhmonan}" alt="alt" class="avatar" id="anhmonan"/></td>

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
                            anhmon = res.data.secure_url;
                        }).then(function (err) {
                            console.error(err);
                        });
                    })

</script>