<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<div class="shopee-sort-bar">
    <span class="shopee-sort-by-options__option shopee-sort-by-options__option--selected btn btn-lg btn-primary buttons_style_text"><spring:message code="timkiem.sapxeptheo" /></span>
    <div class="shopee-sort-by-options">

        <c:url value="/timkiem" var="timkiem" />
        <form class="d-flex" action="${timkiem}">
            <button name="lienquan" type="submit" class="shopee-sort-by-options__option" type="button"/><a href="${timkiem}"><spring:message code="timkiem.lienquan" /></a></button>
        </form>

        <c:url value="/timkiem/caodenthap" var="caodenthap"/>
        <form class="d-flex">
            <button name="caodenthap" type="submit" class="shopee-sort-by-options__option" type="button"><a href="${caodenthap}"><spring:message code="timkiem.tucaodenthap" /></a></button>
        </form>

        <c:url value="/timkiem/thapdencao" var="thapdencao"/>
        <form class="d-flex">
            <button name="thapdencap" type="submit" class="shopee-sort-by-options__option" type="button"><a href="${thapdencao}"><spring:message code="timkiem.tuthapdencao" /></a></button>
        </form>

        <div class="shopee-sort-by-options__option">
            <div class="select-with-status__holder select-with-status__box-shadow">
                <span class="select-with-status__placeholder"><spring:message code="timkiem.gia" /></span>
            </div>
        </div>

        <div>
            <c:url value="/timkiem" var="tu"/>
            <form class="d-flex select-with-status__holder select-with-status__box-shadow" method="get" action="${tu}" style="margin: 2px;">
                <input class="form-control" type="text" name="tu" placeholder="Từ...">    
            </form>
        </div>

        <div>
            <c:url value="/timkiem" var="den"/>
            <form class="d-flex select-with-status__holder select-with-status__box-shadow" method="get" action="${den}" style="margin: 2px;">
                <input class="form-control" type="text" name="den" placeholder="đến...">
            </form>
        </div>

        <div class="shopee-sort-by-options__option">
            <div class="select-with-status__holder select-with-status__box-shadow">
                <span class="select-with-status__placeholder"><spring:message code="timkiem.donvi" /></span>
            </div>
        </div>

    </div>
</div>


<div style="display: flex">
    <div class="shopee-search-filter-status_container">
        <div class="shopee-search-filter-status">
            <div class="shopee-sort-by-options__option shopee-sort-by-options__option--selected btn btn-lg btn-primary buttons_style_text" style="background-color: rgb(238, 77, 45);"><spring:message code="timkiem.boloc" /></div>
        </div>
        <div class="shopee-filter-group shopee-facet-filter">
            <div class="shopee-filter-group__header"><spring:message code="timkiem.theodanhmuc" /></div>
            <c:forEach items="${loaimonan}" var="l">
                <c:url value="/chitietloaimonan/${l[0]}" var="cUrl">
                    <c:param name="idLoaiMonAn" value="${l[0]}" />
                </c:url>
                <div class="folding-items shopeee-filter-group__body folding-items--folded">
                    <div class="shopee-filter shopee-checkbox-filter">
                        <div class="shopee-checkbox">
                            <label class="shopee-checkbox__control">
                                <div class="shopee-checkbox__box">
                                    <i> </i>
                                </div>
                                <span class="shopee-checkbox__label">
                                    <button type="submit" class="shopee-sort-by-options__option" type="button"/><a href="${cUrl}">${l[1]}</a></button>
                                </span>
                            </label>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>

        <div class="shopee-filter-group shopee-facet-filter">
            <div class="shopee-filter-group__header"><spring:message code="timkiem.theocuahang" /></div>
            <c:forEach items="${cuahang}" var="c">
                <c:url value="/chitietcuahang/${c[0]}" var="cUrl">
                    <c:param name="idCuaHang" value="${c[0]}" />
                </c:url>
                <div class="folding-items shopeee-filter-group__body folding-items--folded">
                    <div class="shopee-filter shopee-checkbox-filter">
                        <div class="shopee-checkbox">
                            <label class="shopee-checkbox__control">
                                <div class="shopee-checkbox__box">
                                    <i> </i>
                                </div>
                                <span class="shopee-checkbox__label">
                                    <button type="submit" class="shopee-sort-by-options__option" type="button"/><a href="${cUrl}" />${c[1]}</a></button>
                                </span>
                            </label>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
    <section class="py-4 overflow-hidden">
        <div class="timtheomuc" style="display: flex;">
            <div>
                <c:url value="/timkiemloaimonan" var="timkiemloaimonan" />
                <form class="d-flex" action="${timkiemloaimonan}">
                    <input class="form-control me-2" type="text" placeholder="<spring:message code="timkiem.timtheodanhmuc"/>" name="tenLoai">
                </form>
            </div>
            <div>
                <c:url value="/timkiemcuahang" var="timkiemcuahang" />
                <form class="d-flex" action="${timkiemcuahang}">
                    <input class="form-control me-2" type="text" placeholder="<spring:message code="timkiem.timtheocuahang"/>" name="tenCuaHang">
                </form>
            </div>
        </div>       

        <ul class="pagination container timtheomuc">
            <c:forEach begin="1" end="${Math.ceil(demMonAn/monAnPageSize)}" var="i">
                <c:url value="/timkiem" var="u">
                    <c:param name="monan_page" value="${i}" />
                </c:url>
                <li class="page-item"><a class="page-link fw-bold" href="${u}">${i}</a></li>
            </c:forEach>
        </ul>    

        <div class="container" style="display: flex">
            <div class="row h-100">
                <div class="col-12">
                    <div class="carousel slide" id="carouselPopularItems" data-bs-touch="false" data-bs-interval="false">
                        <div class="carousel-inner mb-6">
                            <div class="carousel-item active" data-bs-interval="10000">
                                <div class="row gx-3 h-100 align-items-center it">
                                    <c:if test="${monan.size() == 0}">
                                        <p>
                                            <strong class="text-danger"><spring:message code="timkiem.khongco"/></strong>
                                        </p>
                                    </c:if>
                                    <c:forEach items="${monan}" var="m">
                                        <div class="card">
                                            <img style="width:280px;height: 200px" class="card-img-top" src="${m.anhmonan}" alt="Card image">
                                            <div class="card-body">
                                                <h5 class="fw-bold text-1000 text-truncate mb-1">${m.tenmonan}</h5>
                                                <div>
                                                    <span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span>
                                                    <span class="text-primary">${m.getIdcuahang().getDiachi()}</span>
                                                    <hr/>
                                                    <h5 class="fw-bold text-1000 text-truncate mb-1"><spring:message code="content.tencuahang"/></h5>
                                                    <button type="submit" class="shopee-sort-by-options__option" class="text-primary" type="button"/><a class="text-primary" href="<c:url value="/chitietcuahang/${m.getIdcuahang().getIdcuahang()}" />">${m.getIdcuahang().getTencuahang()}</a></button>
                                                </div>
                                                <p class="fw-bold text-1000 text-truncate mb-1">
                                                    <fmt:formatNumber type="number" value="${m.gia}" maxFractionDigits="3" /> <spring:message code="timkiem.donvimonan" />
                                                    <c:url value="/api/giohang" var="giohang"/>
                                                </p>
                                                <div class="buttons">
                                                    <div class="d-grid gap-2 buttons_style"><a class="btn btn-lg btn-primary buttons_style_text" href="<c:url value="/chitietmonan/${m.getIdmonan()}" />" role="button"><spring:message code="btn.xemchitiet"/></a></div>
                                                    <div class="d-grid gap-2 buttons_style"><a class="btn btn-lg btn-danger buttons_style_text" onclick="
                                                            themMonAnVaoGio('${giohang}',${m.idmonan}, '${m.tenmonan}',${m.gia}, '${m.anhmonan}')" href="#" role="button"><spring:message code="btn.datngay"/></a></div>
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
    </section>
</div>