
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div>
    <h1 class="admintitle">${cuahang.tencuahang}</h1>
    <button type="button" onclick="openFormChat()" id="readyChat" class="btnchat" ><i class="fas fa-comment"></i></button>
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
            <select id="loaimonan" class="form-control form__input" placeholder="<spring:message code="monan.loaimonan"/>">
                <c:forEach items="${allloaimonan}" var="allloaimonan">
                    <option value="${allloaimonan.idloaimonan}">${allloaimonan.tenloai}</option>
                </c:forEach>
            </select>
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
    <input id="xoamonan" type="button" class="btn btn-danger form__input" onclick="" value="<spring:message code="monan.xoa"/>"/>
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
<script src="<c:url value="/js/chat.js"/>"></script>
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
<script type="module">

                       
                       import { initializeApp } from "https://www.gstatic.com/firebasejs/9.9.4/firebase-app.js";
                       import { getAnalytics } from "https://www.gstatic.com/firebasejs/9.9.4/firebase-analytics.js";
                       import { getDatabase, set, ref, push, child, onValue, onChildAdded } from "https://www.gstatic.com/firebasejs/9.9.4/firebase-database.js";
                       // TODO: Add SDKs for Firebase products that you want to use
                       // https://firebase.google.com/docs/web/setup#available-libraries

                       // Your web app's Firebase configuration
                       // For Firebase JS SDK v7.20.0 and later, measurementId is optional
                       const firebaseConfig = {
                           apiKey: "AIzaSyAXemoZT4xpA1_0vXutlenncf3KixDjaWQ",
                           authDomain: "foodwebchat-bdb90.firebaseapp.com",
                           projectId: "foodwebchat-bdb90",
                           storageBucket: "foodwebchat-bdb90.appspot.com",
                           messagingSenderId: "489075632814",
                           appId: "1:489075632814:web:41dd60ebf8918ae21a9b3f",
                           measurementId: "G-TT4ZTR442K"
                       };

                       // Initialize Firebase
                       const app = initializeApp(firebaseConfig);
                       const analytics = getAnalytics(app);
                       var database = getDatabase(app);
                       window.onload = function () {
    <c:set var = "tennguoidung" scope = "session" value = "${currentUser.tennguoidung}"/>
    <c:set var = "id" scope = "session" value = "${currentUser.id}"/>
    <c:set var = "idcuahang" scope = "session" value = "${cuahang.idcuahang}"/>
                           contentall2.scrollTop = contentall2.scrollHeight
                       }
                       var content = document.getElementById('inputchat');
                       var sendChat = document.getElementById('sendChat');
                       var readyChat = document.getElementById('readyChat');

                       sendChat.addEventListener('click', (e) => {
                           const id = push(child(ref(database), 'messages')).key;

                           set(ref(database, "messages/" + id), {
                               iduser: '${id}',
                               name: '${tennguoidung}',
                               idcuahang: '${idcuahang}',
                               message: content.value,
                               role: "quanly"
                           });
                           content.value = null
                       })


                       const newMessage = ref(database, 'messages/');
                       var contentall = document.getElementById("contentall");
                       var contentall2 = document.querySelector(".contentall");

                       onChildAdded(newMessage, (data) => {
                           if (data.val().idcuahang == '${idcuahang}' && data.val().role == 'nguoidung') {
                               if (data.val().iduser != '${id}') {
                                   let pleft = '<p class="left">' + data.val().message + '</p>';
                                   pleft += '<p class="tenleft"><em>' + data.val().name + '</em></p>';
                                   contentall.insertAdjacentHTML("beforebegin", pleft);

                               } else {
                                   let pright = '<p class="right">' + data.val().message + '</p>';
                                   pright += '<p class="tenright"><em>' + data.val().name + '</em></p>';
                                   contentall.insertAdjacentHTML("beforebegin", pright);
                               }
                               contentall2.scrollTop = contentall2.scrollHeight
                           }
                       });

</script>