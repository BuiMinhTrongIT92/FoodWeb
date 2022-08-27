<%-- 
    Document   : adminhome
    Created on : Aug 15, 2022, 12:15:35 AM
    Author     : ACER
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="homeadmin">
    <div class="row">
        <div class="col-md-5">
            <div>
                <canvas id="myChart3"></canvas>
            </div>
            <div class="table-wrapper-scroll-ymenu my-custom-scrollbarmenu">
                <table class="table table-bordered table-striped mb-0">
                    <thead class="themcuahangheadtable">
                        <tr>
                            <th scope="col"><spring:message code="tableonstate.tenloaimonan"/></th>
                            <th scope="col"><spring:message code="tableonstate.tongtien"/></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${thongkedanhmuc}" var="thongkedanhmuc">
                            <tr>
                                <td>${thongkedanhmuc[1]}</td>
                                <td><fmt:formatNumber type="number" value="${thongkedanhmuc[2]}" maxFractionDigits="3" /> VNĐ</td>


                            </tr>
                        </c:forEach>

                    </tbody>
                </table>
            </div>        
        </div>

        <div class="col-md-5">
            <div class="admintitle"><spring:message code="tableonstate.thongkemonantheongay"/></div>  
            <form>
                <div class="form-group">
                    <label for="kw"><spring:message code="tableonstate.nhaptenmonan"/></label>
                    <input class="form-control form__input" type="text" name="kw" id="kw" />
                </div>

                <div class="form-group">
                    <label for="thangbatdau"><spring:message code="tableonstate.thoigianbatdau"/></label>
                    <input id="thangbatdau" class="form-control form__input" type="datetime-local" name="tungay"></input>
                </div>
                <div class="form-group">
                    <label for="thangketthuc"><spring:message code="tableonstate.thoigianketthuc"/></label>
                    <input id="thangketthuc" class="form-control form__input" type="datetime-local" name="denngay"></input>
                </div>
                <input type="submit" class="btn btn-warning"></input>
            </form>
            <br/>
        </div>
    </div>



    <hr style="height: 10px"/>
    <div class="row">
        <div class="col-md-5">
            <div>
                <canvas id="myChartLoaiTheoThang"></canvas>
            </div>
            <div class="table-wrapper-scroll-ymenu my-custom-scrollbarmenu">
                <table class="table table-bordered table-striped mb-0">
                    <thead class="themcuahangheadtable">
                        <tr>
                            <th scope="col"><spring:message code="tableonstate.tenloaimonan"/></th>
                            <th scope="col"><spring:message code="tableonstate.thang"/></th>
                            <th scope="col"><spring:message code="tableonstate.nam"/></th>
                            <th scope="col"><spring:message code="tableonstate.tongtien"/></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${thongkedanhmuctheothang}" var="thongkedanhmuctheothang">
                            <tr>
                                <td>${thongkedanhmuctheothang[0]}</td>
                                <td>${thongkedanhmuctheothang[1]}</td>
                                <td>${thongkedanhmuctheothang[2]}</td>
                                <td><fmt:formatNumber type="number" value="${thongkedanhmuctheothang[3]}" maxFractionDigits="3" /> VNĐ</td>
                            </tr>
                        </c:forEach>

                    </tbody>
                </table>
            </div>        
        </div>

        <div class="col-md-5">
            <div class="admintitle"><spring:message code="tableonstate.thongkemonantheothang"/></div>
            <form>

                <div class="form-group">
                    <label for="thang"><spring:message code="tableonstate.thang"/></label>
                    <select id="thang" name="thang" class="form-control form__input" placeholder="<spring:message code="monan.active"/>">
                        <c:forEach begin="1" end="12" var="thang">
                            <option value="${thang}">${thang}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="nam"><spring:message code="tableonstate.nam"/></label>
                    <input class="form-control form__input" type="number" name="nam" id="nam" />
                </div>
                <input type="submit" class="btn btn-warning"></input>
            </form>
        </div>
    </div>
    <hr style="height: 10px"/>
    <div class="row">
        <div class="col-md-5">
            <div>
                <canvas id="myChartLoaiTheoQuy"></canvas>
            </div>
            <div class="table-wrapper-scroll-ymenu my-custom-scrollbarmenu">
                <table class="table table-bordered table-striped mb-0">
                    <thead class="themcuahangheadtable">
                        <tr>
                            <th scope="col"><spring:message code="tableonstate.quy"/>(hoặc <spring:message code="tableonstate.nam"/>)</th>
                            <th scope="col"><spring:message code="tableonstate.tenloaimonan"/></th>
                            <th scope="col"><spring:message code="tableonstate.tongtien"/></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${thongkedanhmuctheoquy}" var="thongkedanhmuctheoquy">
                            <tr>
                                <td>${thongkedanhmuctheoquy[0]}</td>
                                <td>${thongkedanhmuctheoquy[1]}</td>
                                <td><fmt:formatNumber type="number" value="${thongkedanhmuctheoquy[2]}" maxFractionDigits="3" /> VNĐ</td>
                                
                            </tr>
                        </c:forEach>

                    </tbody>
                </table>
            </div>

        </div>

        <div class="col-md-5">
            <div class="admintitle"><spring:message code="tableonstate.thongkemonantheoquynam"/></div>
            <form>

                <div class="form-group">
                    <label for="quy"><spring:message code="tableonstate.quy"/></label>
                    <h8><em>(chọn quý = 0 nếu thống kê theo năm)</em></h8>
                    <select name="quy" class="form-control form__input" placeholder="<spring:message code="monan.active"/>">
                        <option value="0" selected="0">0</option>
                        <c:forEach begin="1" end="4" var="quy">
                            <option value="${quy}">${quy}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="nam"><spring:message code="tableonstate.nam"/></label>
                    <input id="nam" class="form-control form__input" type="number" name="nam"></input>
                </div>
                <input type="submit" class="btn btn-warning"></input>
            </form>
        </div>
    </div>
</div>


<script src="<c:url value="/js/chart.js"/>"></script>
<script>
    window.onload = function () {
        let labels3 = [], data3 = []
    <c:forEach items="${thongkedanhmuc}" var="thongkedanhmuc">
        labels3.push('${thongkedanhmuc[1]}')
        data3.push('${thongkedanhmuc[2]}')
    </c:forEach>
        char3(labels3, data3);

        let labeldmthang = [], datadmthang = []
    <c:forEach items="${thongkedanhmuctheothang}" var="thongkedanhmuctheothang">
        labeldmthang.push('${thongkedanhmuctheothang[2]}')
        datadmthang.push('${thongkedanhmuctheothang[3]}')
    </c:forEach>
        charDanhMucThang(labeldmthang, datadmthang)
        
    
        let labeldmquy = [], datadmquy = []
    <c:forEach items="${thongkedanhmuctheoquy}" var="thongkedanhmuctheoquy">
        labeldmquy.push('${thongkedanhmuctheoquy[1]}')
        datadmquy.push('${thongkedanhmuctheoquy[2]}')
    </c:forEach>
        charDanhMucQuy(labeldmquy, datadmquy)
    }
</script>
