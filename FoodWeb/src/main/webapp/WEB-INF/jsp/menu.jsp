<%-- 
    Document   : menu
    Created on : Aug 17, 2022, 4:10:51 PM
    Author     : ACER
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div>
    <div >
        <h1 class="admintitle">Menu Thức Ăn</h1>
        <div class="col-md-5">
            <label for="choncuahang" class="form-label">Chọn cửa hàng</label>
            <select id="choncuahang" class="form-control form__input" placeholder="<spring:message code="dangkycuahang.active"/>" onclick="getmenu()">
                <c:forEach items="${allcuahang}" var="allcuahang">
                    <option value="${allcuahang.idcuahang}">${allcuahang.tencuahang}</option>
                </c:forEach>

            </select>
                <input type="text" class="form-control form__input" id="tenmenu"/>
            <div class="col-md-5">
                <select id="activemenu" class="form-control form__input" placeholder="<spring:message code="monan.active"/>">
                    <option value="true">Bật</option>
                    <option value="false">Tắt</option>
                </select>
            </div>
            <input type="datetime-local" placeholder="<spring:message code="monan.thoidiemban"/>" id="thoidiembanmenu" class="form-control form__input"/>
            <input type="datetime-local" placeholder="<spring:message code="monan.thoidiemketthuc"/>" id="thoidiemketthucmenu" class="form-control form__input"/>
        </div>

        <input id="themmenu" class="btn btn-success" value="Thêm" type="button" onclick="themmenu()"/>
        <input id="suamenu" class="btn btn-warning" value="Sửa" type="button" onclick=""/>
        <div class="table-wrapper-scroll-ymenu my-custom-scrollbarmenu">

            <table class="table table-bordered table-striped mb-0">
                <thead class="themcuahangheadtable">
                    <tr>
                        <th scope="col"><spring:message code="menu.idmenu"/></th>
                        <th scope="col"><spring:message code="menu.tenmenu"/></th>
                        <th scope="col"><spring:message code="menu.active"/></th>
                        <th scope="col"><spring:message code="menu.idcuahang"/></th>
                        <th scope="col"><spring:message code="menu.ngaybatdau"/></th>
                        <th scope="col"><spring:message code="menu.ngayketthuc"/></th>
                        <th scope="col"></th>
                    </tr>
                </thead>
                <tbody id="menuthuca">

                </tbody>
            </table>

        </div>
    </div>
    <hr style="height: 10px"/>
    <div >
        <h1 class="admintitle">Thêm món ăn vào Menu</h1>
        <input id="themmonvaomenu" class="btn btn-success" value="Thêm" type="button" onclick="themmonvaomenu()"/>
        <div class="table-wrapper-scroll-ymenu my-custom-scrollbarmenu">
            <div style="display: flex">
                <div class="col-md-5"style="margin-right: 2%">

                    <select id="dscuahang" class="form-control form__input" placeholder="<spring:message code="dangkycuahang.active"/>" onclick="getMenuByIDCuahang()">
                        <c:forEach items="${allcuahang}" var="allcuahang">
                            <option value="${allcuahang.idcuahang}">${allcuahang.tencuahang}</option>
                        </c:forEach>
                    </select>

                    <select id="dsmenu" class="form-control form__input" placeholder="<spring:message code="dangkycuahang.active"/>" onclick="getMenuThucAnMonAnByMenu()">
                    </select>
                    <select id="dsmonanbycuahang" class="form-control form__input" placeholder="<spring:message code="dangkycuahang.active"/>">
                    </select>
                </div>
                <div class="col-md-5">
                    <select id="dsmenu2" class="form-control form__input" placeholder="<spring:message code="dangkycuahang.active"/>">
                    </select>
                    <input type="button" class="btn btn-secondary" value="Gửi mail" onclick="guiMailMenu()"></input>
                </div>
            </div>



            <table class="table table-bordered table-striped mb-0">
                <thead>
                    <tr class="themcuahangheadtable">
                        <th scope="col">ID Menu</th>
                        <th scope="col">Tên Món Ăn</th>

                    </tr>
                </thead>
                <tbody id="menuthucanmonan">

                </tbody>
            </table>

        </div>


    </div>
</div>
<script src="<c:url value="/js/indexjs.js"/>"></script>




