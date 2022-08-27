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
                <canvas id="myChart"></canvas>
            </div>
            <div class="table-wrapper-scroll-ymenu stattable">
                <table class="table table-bordered table-striped mb-0 ">
                    <thead class="themcuahangheadtable">
                        <tr>
                            <th scope="col"><spring:message code="tableonstate.idmonan"/></th>
                            <th scope="col"><spring:message code="tableonstate.tenmonan"/></th>
                            <th scope="col"><spring:message code="tableonstate.tongtien"/></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${thongkemonan}" var="thongkemonan">
                            <tr>
                                <td>${thongkemonan[0].idmonan}</td>
                                <td>${thongkemonan[1]}</td>
                                <td><fmt:formatNumber type="number" value="${thongkemonan[2]}" maxFractionDigits="3" /> VNĐ</td>

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

        </div>
    </div>
</div>
<hr style="height: 10px"/>
<div class="row">
    <div class="col-md-5">
        <div>
            <canvas id="myChartMonAnTheoThang"></canvas>
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
                    <c:forEach items="${thongkemonantheothang}" var="thongkemonantheothang">
                        <tr>
                            <td>${thongkemonantheothang[0]}</td>
                            <td>${thongkemonantheothang[1]}</td>
                            <td>${thongkemonantheothang[2]}</td>
                            <td><fmt:formatNumber type="number" value="${thongkemonantheothang[3]}" maxFractionDigits="3" /> VNĐ</td>
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
            <canvas id="myChart2"></canvas>
        </div>
        <div class="table-wrapper-scroll-ymenu stattable">
            <table class="table table-bordered table-striped mb-0">
                <thead class="themcuahangheadtable">
                    <tr>
                        <th scope="col"><spring:message code="tableonstate.idmonan"/></th>
                        <th scope="col"><spring:message code="tableonstate.tenmonan"/></th>
                        <th scope="col"><spring:message code="tableonstate.tongtien"/></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${thongkemonanquynam}" var="thongkemonanquynam">
                        <tr>
                            <td>${thongkemonanquynam[0].idmonan}</td>
                            <td>${thongkemonanquynam[1]}</td>
                            <td><fmt:formatNumber type="number" value="${thongkemonanquynam[2]}" maxFractionDigits="3" /> VNĐ</td>

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
<script src="<c:url value="/js/chart.js"/>"></script>
<script>
    window.onload = function () {
        let labels = [], data = []
    <c:forEach items="${thongkemonan}" var="thongkemonan">
        labels.push('${thongkemonan[1]}')
        data.push('${thongkemonan[2]}')
    </c:forEach>


       let labelsmonantheothang = [], data2monantheothang = []
    <c:forEach items="${thongkemonantheothang}" var="thongkemonantheothang">
        labelsmonantheothang.push('${thongkemonantheothang[1]}')
        data2monantheothang.push('${thongkemonantheothang[3]}')
    </c:forEach>
        chartMonAnTheoThang(labelsmonantheothang, data2monantheothang);
    
        let labels2 = [], data2 = []
    <c:forEach items="${thongkemonanquynam}" var="thongkemonanquynam">
        labels2.push('${thongkemonanquynam[1]}')
        data2.push('${thongkemonanquynam[2]}')
    </c:forEach>

        chart(labels, data);
        char2(labels2, data2);
    }
</script>
