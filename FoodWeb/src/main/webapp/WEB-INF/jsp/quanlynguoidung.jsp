
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div>
    <h1 class="admintitle">${cuahang.tencuahang}</h1>
    <div class="row">
        <div class="col-md-5">
            <c:url value="/admin/cuahang/quanlycuahang" var="quanlycuahang"/>

            <c:if test="${erro !=null}">
                <div class="alert alert-danger">${erro}</div>
            </c:if>
            <div class="form-group">
                <spring:message code="regis.tennguoidung" var="tennguoidung"/>
                <input type="text" class="form-control form__input" id="tennguoidung1" placeholder="${tennguoidung}"  />
            </div>
            <div class="form-group">
                <spring:message code="regis.taikhoan" var="taikhoan"/>
                <input type="text" class="form-control form__input" id="taikhoan1" placeholder="${taikhoan}"  />
            </div>
            <div class="form-group">
                <spring:message code="regis.matkhau" var="matkhau"/>
                <input type="password" class="form-control form__input" id="matkhau1" placeholder="${matkhau}"  />
            </div>
            <div class="form-group">
                <spring:message code="regis.nhaplaimatkhau" var="nhaplaimatkhau1"/>
                <input type="password" class="form-control form__input" id="nhaplaimatkhau1" placeholder="${nhaplaimatkhau1}"  />
            </div>
            <div class="form-group">
                <div>
                    <select class="select form__input" id="gioitinh1">
                        <option value="1" disabled><spring:message code="regis.gioitinh"/></option>
                        <option value="Nam"><spring:message code="regis.nam"/></option>
                        <option value="Nu"><spring:message code="regis.nu"/></option>
                        <option value="Khac"><spring:message code="regis.khac"/></option>
                    </select>
                </div>  
            </div>
            <select class="select form__input" placeholder="<spring:message code="monan.active"/>" id="activeUser1">
                <option value="true">Bật</option>
                <option value="false">Tắt</option>
            </select>

        </div>
        <div class="col-md-5">
            <div class="form-group">
                <spring:message code="regis.email" var="email"/>
                <input type="text" class="form-control form__input" id="email1" placeholder="${email}"  />
            </div>
            <div class="form-group">
                <spring:message code="regis.SDT" var="SDT"/>
                <input type="number" class="form-control form__input" id="sdt1" placeholder="${SDT}"  />
            </div>
            <div class="form-group">
                <spring:message code="regis.diachi" var="diachi"/>
                <input type="text" class="form-control form__input" id="diachi1"  placeholder="${diachi}" />
            </div>

            <div class="form-group">
                <spring:message code="regis.avatar" var="avatar"/>
                <input type="file"  class="form-control form__input" id="file-uploadanhuser" placeholder="${avatar}" />
            </div>
            <select class="select form__input" id="role1" style="width: 200px">
                <option value="ROLE_ADMIN"><spring:message code="role.admin"/></option>
                <option value="ROLE_QUANLY"><spring:message code="role.quanly"/></option>
                <option value="ROLE_NGUOIDUNG"><spring:message code="role.nguoidung"/></option>
            </select>

        </div>

    </div>

    <input id="suanguoidung" type="button" class="btn btn-success form__input" value="<spring:message code="monan.sua"/>"/>
    <input id="xoanguoidung" type="button" class="btn btn-danger form__input" value="<spring:message code="monan.xoa"/>"/>
    <div class="table-wrapper-scroll-y my-custom-scrollbar">
        <table class="table">
            <tr class="themcuahangheadtable">
                <td><spring:message code="regis.tennguoidung"/></td>
                <td><spring:message code="regis.taikhoan"/></td>
                <td><spring:message code="regis.gioitinh"/></td>
                <td><spring:message code="regis.email"/></td>
                <td><spring:message code="regis.SDT"/></td>
                <td><spring:message code="regis.diachi"/></td>
                <td><spring:message code="regis.ngaytao"/></td>
                <td><spring:message code="regis.active"/></td>
                <td><spring:message code="regis.role"/></td>
                <td><spring:message code="regis.avatar"/></td>

            </tr>
            <c:if test="${alluser.size() > 0}">
                <c:forEach items="${alluser}" var="alluser">
                    <tr class="allloaimonan themcuahangitem" onclick="getDetailUser('${alluser.id}')">
                        <td>${alluser.tennguoidung}</td>
                        <td>${alluser.taikhoan}</td>
                        <td>${alluser.gioitinh}</td>
                        <td>${alluser.email}</td>
                        <td>${alluser.sdt}</td>
                        <td>${alluser.diachi}</td>
                        <td>${alluser.ngaytao}</td>
                        <c:if test="${alluser.active == true}">
                            <td><i style="color: green" class="fas fa-check-circle"></i></td>
                            </c:if>
                            <c:if test="${alluser.active == false}">
                            <td><i style="color: red" class="fas fa-times-circle"></i></td>
                            </c:if>
                        <td>${alluser.role}</td>
                        <td><img class="avatar" src="${alluser.avatar}"/></td>
                    </tr>
                </c:forEach>
            </c:if>
        </table>
    </div>

</div>

<script src="<c:url value="/js/indexjs.js"/>"></script>
<script type="text/javascript">
    window.onload = function (){
        anhnguoidung = '';
    }
                        var CLOUDINARY_URL = "https://api.cloudinary.com/v1_1/trongbui/upload"
                        var CLOUDINARY_UPLOAD_PRESET = "svzzed5s"

                        
                        var fileUpload = document.getElementById('file-uploadanhuser');

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
                                anhnguoidung = res.data.secure_url;
                            }).then(function (err) {
                                console.error(err);
                            });
                        })

</script>