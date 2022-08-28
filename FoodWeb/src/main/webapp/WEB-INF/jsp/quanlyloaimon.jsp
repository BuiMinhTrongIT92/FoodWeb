
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
                <input type="text" placeholder="<spring:message code="monan.tenmonan"/>" id="tenloaimonan" class="form-control form__input"/>
                <select class="form-control form__input" placeholder="<spring:message code="monan.active"/>" id="activeloaimoanan">
                    <option value="true">Bật</option>
                    <option value="false">Tắt</option>
                </select>
                <input id="file-uploadloaimonan" type="file" class="form-control form__input"/>
            </div>
        </div>
        
    </div>
    <input type="button" class="btn btn-warning form__input" onclick="themLoaiMon()" value="<spring:message code="monan.them"/>"/>
    <input id="sualoaimon" type="button" class="btn btn-success form__input" value="<spring:message code="monan.sua"/>"/>
    <input type="button" class="btn btn-danger form__input" onclick="" value="<spring:message code="monan.xoa"/>"/>
    <div class="table-wrapper-scroll-y my-custom-scrollbar">
        <table class="table">
            <tr class="themcuahangheadtable">
                <td><spring:message code="monan.tenmonan"/></td>
                <td><spring:message code="monan.tenmonan"/></td>
                <td><spring:message code="monan.gia"/></td>
                <td><spring:message code="monan.soluong"/></td>

            </tr>
            <c:if test="${allloaimonan.size() > 0}">
                <c:forEach items="${allloaimonan}" var="allloaimonan">
                    <tr class="allloaimonan themcuahangitem" onclick="getLoaiMonAn(${allloaimonan.idloaimonan})">
                        <td>${allloaimonan.idloaimonan}</td>
                        <td>${allloaimonan.tenloai}</td>
                        <c:if test="${allloaimonan.active == true}">
                            <td><i style="color: green" class="fas fa-check-circle"></i></td>
                            </c:if>
                            <c:if test="${allloaimonan.active == false}">
                            <td><i style="color: red" class="fas fa-times-circle"></i></td>
                            </c:if>
                            
                        <td><img src="${allloaimonan.anhloaimonan}" alt="alt" class="avatar" id="anhloaimonan"/></td>

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

                        
                        var fileUpload = document.getElementById('file-uploadloaimonan');

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
                                anhloaimon = res.data.secure_url;
                            }).then(function (err) {
                                console.error(err);
                            });
                        })

</script>