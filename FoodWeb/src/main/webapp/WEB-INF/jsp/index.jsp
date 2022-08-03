<%-- 
    Document   : index
    Created on : Jul 23, 2022, 12:39:59 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<section class="py-5 overflow-hidden bg-primary" id="home">
    <div class="container">
        <div class="row flex-center">
            <div class="col-md-5 col-lg-6 order-0 order-md-1 mt-8 mt-md-0"><a class="img-landing-banner" href="#!"><img class="img-fluid" src="<c:url value="/img/gallery/hero-header.png"/>" alt="hero-header" /></a></div>
            <div class="col-md-7 col-lg-6 py-8 text-md-start text-center">
                <h1 class="display-1 fs-md-5 fs-lg-6 fs-xl-8 text-light"><spring:message code="content.question"/></h1>
                <h1 class="text-800 mb-5 fs-4"><spring:message code="content.slogan"/><br class="d-none d-xxl-block" /></h1>
                <div class="card w-xxl-75">
                    <div class="card-body">
                        <nav>
                            <div class="nav nav-tabs" id="nav-tab" role="tablist">
                                <button class="nav-link active mb-3" id="nav-home-tab" data-bs-toggle="tab" data-bs-target="#nav-home" type="button" role="tab" aria-controls="nav-home" aria-selected="true"><i class="fas fa-motorcycle me-2"></i>Delivery</button>
                                <button class="nav-link mb-3" id="nav-profile-tab" data-bs-toggle="tab" data-bs-target="#nav-profile" type="button" role="tab" aria-controls="nav-profile" aria-selected="false"><i class="fas fa-shopping-bag me-2"></i>Pickup</button>
                            </div>
                        </nav>
                        <div class="tab-content mt-3" id="nav-tabContent">
                            <div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">
                                <form class="row gx-2 gy-2 align-items-center">
                                    <div class="col">
                                        <div class="input-group-icon"><i class="fas fa-map-marker-alt text-danger input-box-icon"></i>
                                            <label class="visually-hidden" for="inputDelivery">Address</label>
                                            <input class="form-control input-box form-foodwagon-control" id="inputDelivery" type="text" placeholder="Enter Your Address" />
                                        </div>
                                    </div>
                                    <div class="d-grid gap-3 col-sm-auto">
                                        <button class="btn btn-danger" type="submit">Find Food</button>
                                    </div>
                                </form>
                            </div>
                            <div class="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab">
                                <form class="row gx-4 gy-2 align-items-center">
                                    <div class="col">
                                        <div class="input-group-icon"><i class="fas fa-map-marker-alt text-danger input-box-icon"></i>
                                            <label class="visually-hidden" for="inputPickup">Address</label>
                                            <input class="form-control input-box form-foodwagon-control" id="inputPickup" type="text" placeholder="Enter Your Address" />
                                        </div>
                                    </div>
                                    <div class="d-grid gap-3 col-sm-auto">
                                        <button class="btn btn-danger" type="submit">Find Food</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>    
</section>


<!-- ============================================-->
<!-- <section> begin ============================-->
<section class="py-0">

    <div class="modal" id="myModal">
        <div class="modal-dialog">
            <div class="main">
            <div class="container_dn b-container" id="b-container_dn">
                <form class="form">
                    <h2 class="form_title title">Đăng ký tài khoản</h2>
                    <br>
                    <br>
                    <input class="form__input" type="text" placeholder="Tên người dùng">
                    <input class="form__input" type="text" placeholder="Giới tính">
                    <input class="form__input" type="text" placeholder="Số điện thoại">
                    <input class="form__input" type="text" placeholder="Email">
                    <input class="form__input" type="text" placeholder="Địa chỉ">                
                    <input class="form__input" type="text" placeholder="Tên đăng nhập">
                    <input class="form__input" type="password" placeholder="Mật khẩu">
                    <input class="form__input" type="password" placeholder="Xác nhận mật khẩu">
                    <button class="form__button button submit"/>ĐĂNG KÝ</button>
                </form>
            </div>

            <div class="switch" id="switch-cnt">
                <div class="switch__container is-hidden" id="switch-c2">
                    <h2 class="switch__title title">SlimFood</h2>
                    <h2 class="switch__title title">xin chào!</h2>
                    <br>
                    <a class="navbar-brand d-inline-flex" href="index.html"><img class="d-inline-block" style="width: 80px; height: 80px;" src="resources/img/logo.png" alt="logo" /><span class="text-1000 fs-3 fw-bold ms-2 text-gradient"><spring:message code="head.nameweb"/></span></a>
                    <br>
                    <p class="switch__description description">Hãy nhập đầy đủ các thông tin nhé!</p>
                </div>
            </div>
        </div>
        </div>
    </div>
    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#myModal">
  Open modal
</button>



    <!-- ============================================-->  
    <div class="container">
        <div class="fw-bold text-danger fs-3 fs-lg-5 lh-sm my-6"><spring:message code="content.monsapmoban"/></div>
        <div class="row h-100 gx-2 mt-7">

            <c:forEach var="waitMonans" begin="0" end="${monansapban.size() -1}">
                <div class="col-sm-6 col-lg-3 mb-3 mb-md-0 h-100 pb-4 monanconlai">
                    <div class="card card-span h-100">
                        <div class="position-relative"> <img class="img-fluid rounded-3 w-100" src="${monansapban.get(waitMonans).anhmonan}" alt="..." />
                            <div class="card-actions">
                                <div class="badge badge-foodwagon bg-primary p-4">
                                    <div class="d-flex flex-between-center">
                                        <div class="text-white fs-7">15</div>
                                        <div class="d-block text-white fs-2">% <br />
                                            <div class="fw-normal fs-1 mt-2">Off</div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="card-body px-0">
                            <h5 class="fw-bold text-1000 text-truncate">${monansapban.get(waitMonans).tenmonan}</h5><span class="badge bg-soft-danger py-2 px-3"><span class="fs-1 text-danger">${ngayconlai.get(waitMonans)} Ngày Còn Lại</span></span>
                        </div><a class="stretched-link" href="#"></a>
                    </div>
                </div>

            </c:forEach>

        </div>
    </div><!-- end of .container-->


</section>
<!-- <section> close ============================-->
<!-- ============================================-->




<!-- ============================================-->
<!-- <section> begin ============================-->
<section class="py-0 bg-primary-gradient">

    <div class="container">
        <div class="row justify-content-center g-0">
            <div class="col-xl-9">
                <div class="col-lg-6 text-center mx-auto mb-3 mb-md-5 mt-4">
                    <h5 class="fw-bold text-danger fs-3 fs-lg-5 lh-sm my-6">How does it work</h5>
                </div>
                <div class="row">
                    <div class="col-sm-6 col-md-3 mb-6">
                        <div class="text-center"><img class="shadow-icon" src="<c:url value="/img/gallery/location.png"/>"height="112" alt="..." />
                            <h5 class="mt-4 fw-bold">Select location</h5>
                            <p class="mb-md-0">Choose the location where your food will be delivered.</p>
                        </div>
                    </div>
                    <div class="col-sm-6 col-md-3 mb-6">
                        <div class="text-center"><img class="shadow-icon" src="<c:url value="/img/gallery/order.png"/>" height="112" alt="..." />
                            <h5 class="mt-4 fw-bold">Choose order</h5>
                            <p class="mb-md-0">Check over hundreds of menus to pick your favorite food</p>
                        </div>
                    </div>
                    <div class="col-sm-6 col-md-3 mb-6">
                        <div class="text-center"><img class="shadow-icon" src="<c:url value="/img/gallery/pay.png"/>" height="112" alt="..." />
                            <h5 class="mt-4 fw-bold">Pay advanced</h5>
                            <p class="mb-md-0">It's quick, safe, and simple. Select several methods of payment</p>
                        </div>
                    </div>
                    <div class="col-sm-6 col-md-3 mb-6">
                        <div class="text-center"><img class="shadow-icon" src="<c:url value="/img/gallery/location.png"/>" height="112" alt="..." />
                            <h5 class="mt-4 fw-bold">Enjoy meals</h5>
                            <p class="mb-md-0">Food is made and delivered directly to your home.</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div><!-- end of .container-->

</section>
<!-- <section> close ============================-->
<!-- ============================================-->




<!-- ============================================-->
<!-- <section> begin ============================-->
<section class="py-4 overflow-hidden">

    <div class="container">
        <div class="row h-100">
            <div class="fw-bold text-danger fs-3 fs-lg-5 lh-sm my-6"><spring:message code="content.monanphobien"/></div>
            <div class="col-12">
                <div class="carousel slide" id="carouselPopularItems" data-bs-touch="false" data-bs-interval="false">
                    <div class="carousel-inner mb-6">
                        <div class="carousel-item active" data-bs-interval="10000">
                            <div class="row gx-3 h-100 align-items-center it">
                                <c:forEach items="${monanphobien}" var="monanpb">

                                    <div class="card">
                                        <img class="card-img-top" src="<c:url value="/img/gallery/discount-item-4.png"/>" alt="Card image">
                                        <div class="card-body">
                                            <h5 class="fw-bold text-1000 text-truncate mb-1">${monanpb.tenmonan}</h5>
                                            <div><span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span><span class="text-primary">${monanpb.getIdcuahang().getDiachi()}</span><hr/><h5 class="fw-bold text-1000 text-truncate mb-1"><spring:message code="content.tencuahang"/></h5><span class="text-primary">${monanpb.getIdcuahang().getTencuahang()}</span></div><span class="text-1000 fw-bold">${monanpb.gia} VNĐ</span>
                                        </div>
                                        <div class="d-grid"><a class="btn btn-lg btn-danger" href="#!" role="button"><spring:message code="btn.dathangngay"/></a></div>
                                    </div>

                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div><!-- end of .container-->

</section>
<!-- <section> close ============================-->
<!-- ============================================-->


<section id="testimonial">
    <div class="container">
        <div class="row h-100">
            <div class="fw-bold text-danger fs-3 fs-lg-5 lh-sm my-6"><spring:message code="content.cuahangnoibat"/></div>
        </div>
        <div class="row gx-2" id="cuahangnoibat">

        </div>
        <c:url value="/api/allcuahanghot" var="url"/>
        <spring:message code="content.btnxemcuahang" var="btnn"/>
        <div class="col-12 d-flex justify-content-center mt-5"> <a class="btn btn-lg btn-primary"  onclick="layTatCaCuaHangNoiBat('${url}', '${btnn}')">View All <i class="fas fa-chevron-right ms-2"> </i></a></div>

    </div>
</section>


<!-- ============================================-->
<!-- <section> begin ============================-->
<section class="py-8 overflow-hidden">

    <div class="container">
        <div class="row flex-center mb-6">
            <div class="col-lg-7">
                <h5 class="fw-bold fs-3 fs-lg-5 lh-sm text-center text-lg-start"></h5>
            </div>
            <div class="fw-bold text-danger fs-3 fs-lg-5 lh-sm my-6"><spring:message code="content.slideloaimonan"/></div>

        </div>
        <div class="row flex-center">
            <div class="col-12">
                <div class="carousel" id="carouselSearchByFood" data-bs-touch="false" data-bs-interval="false">
                    <div class="carousel-inner">
                        <div class="carousel-item active" data-bs-interval="10000">
                            <div class="row h-100 align-items-center">
                                <div class="col-sm-6 col-md-4 col-xl mb-5 h-100 it">
                                    <c:forEach items="${loaimonan}" var="loaimon">
                                        <div class="card card-span h-100 rounded-circle"><img class="img-fluid rounded-circle h-100" src="${loaimon.anhloaimonan}" alt="..." />
                                            <div class="card-body ps-0">
                                                <h5 class="text-center fw-bold text-1000 text-truncate mb-2">${loaimon.tenloai}</h5>
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
    </div>
</div><!-- end of .container-->

</section>
<!-- <section> close ============================-->
<!-- ============================================-->


<!--<section>
    <div class="bg-holder" style="background-image:url(assets/img/gallery/cta-one-bg.png);background-position:center;background-size:cover;">
    </div>
    /.bg-holder

    <div class="container">
        <div class="row justify-content-center">
            <div class="col-xxl-10">
                <div class="card card-span shadow-warning" style="border-radius: 35px;">
                    <div class="card-body py-5">
                        <div class="row justify-content-evenly">
                            <div class="col-md-3">
                                <div class="d-flex d-md-block d-xl-flex justify-content-evenly justify-content-lg-between"><img src="<c:url value="/img/gallery/discount-item-4.png"/>" width="100" alt="..." />
                                    <div class="d-flex d-lg-block d-xl-flex flex-center">
                                        <h2 class="fw-bolder text-1000 mb-0 text-gradient">Daily<br class="d-none d-md-block" />Discounts </h2>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3 hr-vertical">
                                <div class="d-flex d-md-block d-xl-flex justify-content-evenly justify-content-lg-between"><img src="<c:url value="/img/gallery/discount-item-4.png"/>" width="100" alt="..." />
                                    <div class="d-flex d-lg-block d-xl-flex flex-center">
                                        <h2 class="fw-bolder text-1000 mb-0 text-gradient">Live Tracking</h2>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3 hr-vertical">
                                <div class="d-flex d-md-block d-xl-flex justify-content-evenly justify-content-lg-between"><img src="<c:url value="/img/gallery/discount-item-4.png"/>g" width="100" alt="..." />
                                    <div class="d-flex d-lg-block d-xl-flex flex-center">
                                        <h2 class="fw-bolder text-1000 mb-0 text-gradient">Quick Delivery </h2>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row flex-center mt-md-8">
            <div class="col-lg-5 d-none d-lg-block" style="margin-bottom: -122px;"> <img class="w-100" src="<c:url value="/img/gallery/discount-item-4.png"/>" alt="..." /></div>
            <div class="col-lg-5 mt-7 mt-md-0">
                <h1 class="text-primary">Install the app</h1>
                <p>It's never been easier to order food. Look for the finest <br class="d-none d-xl-block" />discounts and you'll be lost in a world of delectable food.</p><a class="pe-2" href="https://www.apple.com/app-store/" target="_blank"><img src="assets/img/gallery/app-store.svg" width="160" alt="" /></a><a href="https://play.google.com/store/apps" target="_blank"><img src="assets/img/gallery/google-play.svg" width="160" alt="" /></a>
            </div>
        </div>
    </div>
</section>


 ============================================
 <section> begin ============================
<section class="pb-5 pt-8">

    <div class="container">
        <div class="row">
            <div class="col-12">
                <div class="card card-span mb-3 shadow-lg">
                    <div class="card-body py-0">
                        <div class="row justify-content-center">
                            <div class="col-md-5 col-xl-7 col-xxl-8 g-0 order-0 order-md-1"><img class="img-fluid w-100 fit-cover h-100 rounded-top rounded-md-end rounded-md-top-0" src="<c:url value="/img/gallery/discount-item-4.png"/>" alt="..." /></div>
                            <div class="col-md-7 col-xl-5 col-xxl-4 p-4 p-lg-5">
                                <h1 class="card-title mt-xl-5 mb-4">Best deals <span class="text-primary"> Crispy Sandwiches</span></h1>
                                <p class="fs-1">Enjoy the large size of sandwiches. Complete your meal with the perfect slice of sandwiches.</p>
                                <div class="d-grid bottom-0"><a class="btn btn-lg btn-primary mt-xl-6" href="#!">PROCEED TO ORDER<i class="fas fa-chevron-right ms-2"></i></a></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div> end of .container

</section>
 <section> close ============================
 ============================================




 ============================================
 <section> begin ============================
<section class="py-0">

    <div class="container">
        <div class="row">
            <div class="col-12">
                <div class="card card-span mb-3 shadow-lg">
                    <div class="card-body py-0">
                        <div class="row justify-content-center">
                            <div class="col-md-5 col-xl-7 col-xxl-8 g-0 order-md-0"><img class="img-fluid w-100 fit-cover h-100 rounded-top rounded-md-start rounded-md-top-0" src="assets/img/gallery/fried-chicken.png" alt="..." /></div>
                            <div class="col-md-7 col-xl-5 col-xxl-4 p-4 p-lg-5">
                                <h1 class="card-title mt-xl-5 mb-4">Celebrate parties with <span class="text-primary">Fried Chicken</span></h1>
                                <p class="fs-1">Get the best fried chicken smeared with a lip smacking lemon chili flavor. Check out best deals for fried chicken.</p>
                                <div class="d-grid bottom-0"><a class="btn btn-lg btn-primary mt-xl-6" href="#!">PROCEED TO ORDER<i class="fas fa-chevron-right ms-2"></i></a></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div> end of .container

</section>
 <section> close ============================
 ============================================




 ============================================
 <section> begin ============================
<section class="pt-5">

    <div class="container">
        <div class="row">
            <div class="col-12">
                <div class="card card-span mb-3 shadow-lg">
                    <div class="card-body py-0">
                        <div class="row justify-content-center">
                            <div class="col-md-5 col-xl-7 col-xxl-8 g-0 order-0 order-md-1"><img class="img-fluid w-100 fit-cover h-100 rounded-top rounded-md-end rounded-md-top-0" src="assets/img/gallery/pizza.png" alt="..." /></div>
                            <div class="col-md-7 col-xl-5 col-xxl-4 p-4 p-lg-5">
                                <h1 class="card-title mt-xl-5 mb-4">Wanna eat hot & <span class="text-primary">spicy Pizza?</span></h1>
                                <p class="fs-1">Pair up with a friend and enjoy the hot and crispy pizza pops. Try it with the best deals.</p>
                                <div class="d-grid bottom-0"><a class="btn btn-lg btn-primary mt-xl-6" href="#!">PROCEED TO ORDER<i class="fas fa-chevron-right ms-2"></i></a></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div> end of .container

</section>
 <section> close ============================
 ============================================


<section class="py-0">
    <div class="bg-holder" style="background-image:url(<c:url value="/img/gallery/discount-item-4.png"/>);background-position:center;background-size:cover;">
    </div>
    /.bg-holder

    <div class="container">
        <div class="row flex-center">
            <div class="col-xxl-9 py-7 text-center">
                <h1 class="fw-bold mb-4 text-white fs-6">Are you ready to order <br />with the best deals? </h1><a class="btn btn-danger" href="#"> PROCEED TO ORDER<i class="fas fa-chevron-right ms-2"></i></a>
            </div>
        </div>
    </div>

</section>-->



<script src="<c:url value="/js/indexjs.js"/>"></script>
<script>
    <c:url value="/api/cuahanghot" var="url"/>
            window.onload = function layCuaHangNoiBat() {
                getCuahang('${url}', '${btnn}')
            }
</script>
<script type="text/javascript">
    $('.it').slick({
        infinite: true,
        slidesToShow: 4,
        slidesToScroll: 3
    });

</script>