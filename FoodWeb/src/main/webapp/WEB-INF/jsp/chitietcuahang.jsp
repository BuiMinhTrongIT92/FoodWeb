<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<section class="py-5 giomau" >
    <div class="container tranggio">
        <div id="spin" style="display: none"><div class="spinner-border text-warning"></div></div>
        <div>
            <div class="col-md-8 col-xs-3" style="display: flex;">
                <a class="navbar-brand" href="#">
                    <img src="${chitietcuahang.logo}" alt="Logo" class="rounded-circle" style="width:200px; height: 200px;">

                </a>
                <div class="col-md-7 col-lg-6 text-md-start text-center" style="padding-top: 10%; padding-left: 8%;">
                    <h1 class="display-1 fs-md-5 fs-lg-6 fs-xl-8 text-light" style="color: black !important; font-size: 16px !important;"><spring:message code="chitietcuahang.cuahang"/></h1>
                    <h1 class="display-1 fs-md-5 fs-lg-6 fs-xl-8 text-light" style="color: black !important; font-size: 40px !important;">${chitietcuahang.tencuahang}</h1>
                    <c:if test="${tongsosaocuahang == null}">
                        <p>
                            <strong class="text-danger"><spring:message code="chitietmonan.chuacodanhgia"/></strong>
                        </p>
                    </c:if>
                    <c:if test="${tongsosaocuahang != null}">
                        <div style="display: flex;">
                            <div style="padding: 15px;">
                                <h4><fmt:formatNumber type = "number" groupingUsed = "false" value = "${tongsosaocuahang/demdanhgiacuahang}" />/5</h4>
                            </div>
                            <div class="rating">
                                <input type="radio" name="html">
                                <input type="radio" name="html">
                            </div>
                            <div style="padding: 15px"><p>(<spring:message code="chitiet.sodanhgia"/> ${demdanhgiacuahang} <spring:message code="chitiet.danhgia"/>)</p></div>
                        </div>
                    </c:if>

                    <div style="display: flex;">
                        <span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span>
                        <span class="display-1 fs-md-5 fs-lg-6 fs-xl-8 text-light" style="color: orange !important; font-size: 16px !important; padding-top: 5px;">${chitietcuahang.diachi}</span>
                    </div>
                </div>
                <div>
                    <c:if test="${trangthaitheodoi != null }">
                        <c:if test="${trangthaitheodoi.trangthai == true}">
                            <span><input onchange="chuyenTranThai('${chitietcuahang.idcuahang}')" id="trangthaitd" type="checkbox" checked data-toggle="toggle" data-width="200" data-height="30" data-on="Theo dõi" data-off="Đang theo dõi" data-offstyle="success"></span>
                            </c:if>
                            <c:if test="${trangthaitheodoi.trangthai == false}">
                            <span><input onchange="chuyenTranThai('${chitietcuahang.idcuahang}')" id="trangthaitd" type="checkbox" data-toggle="toggle" data-width="200" data-height="30" data-on="Theo dõi" data-off="Đang theo dõi" data-offstyle="success"></span>
                            </c:if>
                        </c:if>
                        <c:if test="${trangthaitheodoi == null}">
                        <span><input onchange="chuyenTranThai('${chitietcuahang.idcuahang}')" id="trangthaitd" type="checkbox" data-toggle="toggle" data-width="200" data-height="30" data-on="Theo dõi" data-off="Đang theo dõi" data-offstyle="success"></span>
                        </c:if>
                    <hr/>
                    <button type="button" onclick="openFormChat()" id="readyChat" class="btnchat" ><i class="fas fa-comment"></i></button>
                </div>

            </div>
        </div>
</section>

<section class="py-4 overflow-hidden" style="margin-top: 5px;">
    <div class="fw-bold text-danger fs-3 fs-lg-5 lh-sm my-6 container"><spring:message code="content.monanthucdon"/></div>
    <div class="container" style="display: flex"> 
        <div class="row h-100">
            <div class="col-12">
                <div class="carousel slide" id="carouselPopularItems" data-bs-touch="false" data-bs-interval="false">
                    <div class="carousel-inner mb-6">
                        <div class="carousel-item active" data-bs-interval="10000">
                            <div class="row gx-3 h-100 align-items-center it">
                                <c:if test="${monantheoidcuahang.size() == 0}">
                                    <p>
                                        <strong class="text-danger"><spring:message code="chitietcuahang.khongcomonan"/></strong>
                                    </p>
                                </c:if>
                                <c:forEach items="${monantheoidcuahang}" var="m">
                                    <div class="card">
                                        <img style="width:280px;height: 200px" class="card-img-top" src="${m[3]}" alt="Card image">
                                        <div class="card-body">
                                            <h5 class="fw-bold text-1000 text-truncate mb-1">${m[1]}</h5>
                                            <div><span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span>
                                                <span class="text-primary">${m[5]}</span>
                                                <hr/>
                                                <h5 class="fw-bold text-1000 text-truncate mb-1"><spring:message code="content.tencuahang"/></h5>
                                                <span class="text-primary">${m[4]}</span>
                                            </div>
                                            <p class="fw-bold text-1000 text-truncate mb-1">
                                                <fmt:formatNumber type="number" value="${m[2]}" maxFractionDigits="3" /> <spring:message code="timkiem.donvimonan" />
                                                <c:url value="/api/giohang" var="giohang"/>
                                            </p>
                                            <div class="buttons">
                                                <div class="d-grid gap-2 buttons_style"><a class="btn btn-lg btn-primary buttons_style_text" href="<c:url value="/chitietmonan/${m[0]}" />" role="button"><spring:message code="btn.xemchitiet"/></a></div>
                                                <div class="d-grid gap-2 buttons_style"><a class="btn btn-lg btn-danger buttons_style_text" onclick="
                                                        themMonAnVaoGio('${giohang}',${m[0]}, '${m[1]}',${m[2]}, '${m[3]}')" href="#" role="button"><spring:message code="btn.datngay"/></a></div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <sec:authorize access="!isAuthenticated()">
        <div class="container">
            <p><spring:message code="chitietcuahang.luuy" /></p>
            <c:url value="/dangnhap" var="dangnhap"/>
            <p><a href="${dangnhap}" class="text-primary fw-bold"><spring:message code="regis.dangnhap" /></a> <spring:message code="chitiet.taiday" /></p>
        </div>
    </sec:authorize>

    <div class="fw-bold text-danger fs-3 fs-lg-5 container"><spring:message code="chitietcuahang.danhgia"/></div>
    <sec:authorize access="isAuthenticated()">
        <div class="container">
            <div style="display: flex">
                <div class="col-md-8 col-xs-3" style="display: flex;">
                    <div style="padding-top: 2%; padding-left: 8%; ">
                        <c:url value="/api/cuahang/${chitietcuahang.idcuahang}/danhgia" var="endpoint1"/>
                        <spring:message code="chitiet.xacnhandanhgia" var="xacnhan"/>
                        <spring:message code="chitiet.danhgiathanhcong" var="thanhcong"/>
                        <spring:message code="chitiet.danhgiathatbai" var="thatbai"/>
                        <form>
                            <div id="rating"></div>
                            <input type="hidden" id="star-rating" name="star-rating"/>
                            <input type="submit" class="btn btn-primary btn-danhgia" value="<spring:message code="chitietmonan.gui"/>" style="height: 50px;"
                                   onclick="themDanhGiaCuaHang('${endpoint1}', '${chitietcuahang.idcuahang}', '${xacnhan}', '${thanhcong}', '${thatbai}')"/>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </sec:authorize>
    <div class="container">
        <c:url value="/api/cuahang/${chitietcuahang.idcuahang}/danhgia" var="endpoint1"/>
        <div id="danhgiacuahang" class="row gx-3 h-100 align-items-center it" style="padding-left: 5%; padding-top: 5%;">

        </div>
    </div>

    <div class="fw-bold text-danger fs-3 fs-lg-5 lh-sm my-6 container"><spring:message code="chitietmonan.nhanxet"/></div>  

    <sec:authorize access="isAuthenticated()">
        <c:url value="/api/cuahang/${chitietcuahang.idcuahang}/binhluan" var="endpoint2"/>
        <spring:message code="chitiet.xacnhanbinhluan" var="xacnhan"/>
        <spring:message code="chitiet.binhluanthanhcong" var="thanhcong"/>
        <spring:message code="chitiet.binhluanthatbai" var="thatbai"/>
        <form class="d-flex" style="padding-left: 10%; padding-right: 25%;">
            <textarea id="noidungBLCH" class="form-control me-2" placeholder="<spring:message code="chitietmonan.binhluan"/>"></textarea>
            <input type="submit" class="btn btn-primary" value="<spring:message code="chitietmonan.gui"/>" style="height: 50px;" 
                   onclick="themBinhLuanCuaHang('${endpoint2}', '${chitietcuahang.idcuahang}', '${xacnhan}', '${thanhcong}', '${thatbai}')"/>
        </form>
    </sec:authorize>

    <c:url value="/api/cuahang/${chitietcuahang.idcuahang}/binhluan" var="endpoint2"/>
    <div id="binhluancuahang" style="padding-left: 15%; padding-right: 25%; padding-top: 5%;">

    </div>
</section>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment-with-locales.min.js"></script>
<script src="<c:url value="/js/jquery.rateyo.min.js" />"></script>
<script src="<c:url value="/js/chat.js" />"></script>
<script src="<c:url value="/js/binhluan.js" />" ></script>
<script src="<c:url value="/js/danhgia.js" />" ></script>

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
                           loadDanhGiaCuaHang('${endpoint1}');
                           loadBinhLuanCuaHang('${endpoint2}');
    <c:set var = "tennguoidung" scope = "session" value = "${current.tennguoidung}"/>
    <c:set var = "id" scope = "session" value = "${current.id}"/>
    <c:set var = "idcuahang" scope = "session" value = "${idcuahang}"/>
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
                               message: content.value
                           });
                           content.value = null
                       })


                       const newMessage = ref(database, 'messages/');
                       var contentall = document.getElementById("contentall");
                       var contentall2 = document.querySelector(".contentall");

                       onChildAdded(newMessage, (data) => {
                           if (data.val().idcuahang == '${idcuahang}') {
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