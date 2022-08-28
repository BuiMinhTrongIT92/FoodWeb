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
                <canvas id="myChartTanSuat"></canvas>
            </div>

            <div class="table-wrapper-scroll-ymenu my-custom-scrollbarmenu">
                <table class="table table-bordered table-striped mb-0">
                    <thead class="themcuahangheadtable">
                        <tr>
                            <th scope="col"><spring:message code="tableonstate.tencuahang"/></th>
                            <th scope="col"><spring:message code="tableonstate.tansuat"/></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:if test="${cuahang.size() > 0}">
                            <c:forEach begin="0" end="${cuahang.size() -1}" var="c">
                                <tr>

                                    <td>${cuahang.get(c).tencuahang}</td>
                                    <c:if test="${tansuat.get(c) == 'NaN'}">
                                        <td>Chưa có dữ liệu</td>
                                    </c:if>
                                    <c:if test="${tansuat.get(c) != 'NaN'}">
                                        <td>${tansuat.get(c)}</td>
                                    </c:if>
                                </tr>
                            </c:forEach>
                        </c:if>


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
                <canvas id="myChartTanSuatQuyNam"></canvas>
            </div>
            <div class="table-wrapper-scroll-ymenu my-custom-scrollbarmenu">
                <table class="table table-bordered table-striped mb-0">
                    <thead class="themcuahangheadtable">
                        <tr>
                            <th scope="col"><spring:message code="tableonstate.tencuahang"/></th>
                            <th scope="col"><spring:message code="tableonstate.tansuat"/></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:if test="${tansuatquynam.size() > 0}">
                            <c:forEach begin="0" end="${cuahangquynam.size() -1}" var="c">
                                <tr>
                                    <td>${cuahangquynam.get(c).tencuahang}</td>
                                    <c:if test="${tansuatquynam.get(c) == 'NaN'}">
                                        <td>Chưa có dữ liệu</td>
                                    </c:if>
                                    <c:if test="${tansuatquynam.get(c) != 'NaN'}">
                                        <td>${tansuatquynam.get(c)}</td>
                                    </c:if>
                                </tr>
                            </c:forEach>
                        </c:if>

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
        let labelstansuatthang = [], datatansuatthang = []
    <c:if test="${cuahang.size() > 0}">
        <c:forEach begin="0" end="${cuahang.size() -1}" var="c">
        labelstansuatthang.push('${cuahang.get(c).tencuahang}')
            <c:if test="${tansuat.get(c) == 'NaN'}">
        datatansuatthang.push(0)
            </c:if>
            <c:if test="${tansuat.get(c) != 'NaN'}">
        datatansuatthang.push(${tansuat.get(c)})
            </c:if>
        </c:forEach>

        charTanSuat(labelstansuatthang, datatansuatthang);
    </c:if>
        
        
        let labelstansuatquynam = [], datatansuatquynam = []
    <c:if test="${tansuatquynam.size() > 0}">
        <c:forEach begin="0" end="${cuahangquynam.size() -1}" var="v">
            labelstansuatquynam.push('${cuahangquynam.get(v).tencuahang}')
            
            <c:if test="${tansuatquynam.get(v) == 'NaN'}">
                datatansuatquynam.push(0)
            </c:if>
            <c:if test="${tansuatquynam.get(v) != 'NaN'}">
                datatansuatquynam.push(${tansuatquynam.get(v)})
            </c:if>
        </c:forEach>

        charTanSuatQuyNam(labelstansuatquynam, datatansuatquynam);
    </c:if>

    }

</script>

