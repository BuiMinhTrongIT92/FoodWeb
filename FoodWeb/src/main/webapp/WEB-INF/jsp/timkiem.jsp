<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<div class="shopee-sort-bar">
    <span class="shopee-sort-bar__label"><spring:message code="timkiem.sapxeptheo" /></span>
    <div class="shopee-sort-by-options">
        <div class="shopee-sort-by-options__option shopee-sort-by-options__option--selected" style="background-color: rgb(238, 77, 45);"><spring:message code="timkiem.lienquan" /></div>

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
            <form class="d-flex shopee-sort-by-options__option" method="get" action="${tu}">    
                <input class="form-control" type="text" name="tu" placeholder="Từ..."> 
            </form>
        </div>

        <div>   
            <c:url value="/timkiem" var="den"/>
            <form class="d-flex shopee-sort-by-options__option" method="get" action="${den}">    
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
            <div class="shopee-sort-by-options__option shopee-sort-by-options__option--selected" style="background-color: rgb(238, 77, 45);"><spring:message code="timkiem.boloc" /></div>
        </div>

        <div class="shopee-filter-group shopee-facet-filter">
            <div class="shopee-filter-group__header"><spring:message code="timkiem.theodanhmuc" /></div>

            <c:forEach items="${monan}" var="m">
                <div class="folding-items shopeee-filter-group__body folding-items--folded">
                    <div class="shopee-filter shopee-checkbox-filter">
                        <div class="shopee-checkbox">
                            <label class="shopee-checkbox__control">
                                <input type="checkbox" name="" value="11035811">
                                <div class="shopee-checkbox__box">
                                    <i> </i></div>
                                <span class="shopee-checkbox__label">${m.getIdmonan()}</span>
                            </label>
                        </div>
                    </div>
                </div>
            </c:forEach>

        </div>

        <div class="shopee-filter-group shopee-facet-filter">
            <div class="shopee-filter-group__header"><spring:message code="timkiem.theocuahang" /></div>

            <c:forEach items="${cuahang}" var="c">
               
                    <div class="folding-items shopeee-filter-group__body folding-items--folded">
                        <div class="shopee-filter shopee-checkbox-filter">
                            <div class="shopee-checkbox">
                                <label class="shopee-checkbox__control">
                                    <input type="checkbox" name="" value="11035811">
                                    <div class="shopee-checkbox__box">
                                        <i> </i></div>
                                    <span class="shopee-checkbox__label">${c}</span>
                                </label>
                            </div>
                        </div>
                    </div>
               

            </c:forEach>
        </div>

    </div>
    <section class="py-4 overflow-hidden" style="margin-top: 10px;">
        <div class="container" style="display: flex">
            <div class="row h-100">
                <div class="col-12">
                    <div class="carousel slide" id="carouselPopularItems" data-bs-touch="false" data-bs-interval="false">
                        <div class="carousel-inner">
                            <div class="carousel-item active" data-bs-interval="10000">
                                <div class="row gx-3 h-100 align-items-center">
                                    <c:forEach items="${monan}" var="m">
                                        <div class="col-md-3 col-xs-9" style="margin-bottom: 50px;">
                                            <div class="card card-span h-100 rounded-3"><img class="img-fluid rounded-3 h-100" src="${m.anhmonan}" alt="..."/>
                                                <div class="card-body ps-0">
                                                    <h5 class="fw-bold text-1000 text-truncate mb-1">${m.tenmonan}</h5>
                                                    <div><span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span>
                                                        <span class="text-primary">${m.getIdcuahang().getDiachi()}</span>
                                                    </div>
                                                    <div>
                                                        <span class="text-primary">${m.getIdcuahang().getTencuahang()}</span>
                                                    </div>
                                                    <span class="text-1000 fw-bold">
                                                        <fmt:formatNumber type="number" maxFractionDigits="3" value="${m.gia}" /> <spring:message code="timkiem.donvimonan" />
                                                    </span>
                                                </div>
                                            </div>
                                            <div class="d-grid gap-2"><a class="btn btn-lg btn-danger" href="#!" role="button"><spring:message code="btn.datngay"/></a></div>
                                        </div>  
                                    </c:forEach>   
                                </div>
                            </div>
                        </div>
                        <button class="carousel-control-prev carousel-icon" type="button" data-bs-target="#carouselPopularItems" data-bs-slide="prev"><span class="carousel-control-prev-icon hover-top-shadow" aria-hidden="true"></span><span class="visually-hidden">Previous</span></button>
                        <button class="carousel-control-next carousel-icon" type="button" data-bs-target="#carouselPopularItems" data-bs-slide="next"><span class="carousel-control-next-icon hover-top-shadow" aria-hidden="true"></span><span class="visually-hidden">Next </span></button>
                    </div>
                </div>
            </div>
        </div><!-- end of .container-->
    </section>
</div>