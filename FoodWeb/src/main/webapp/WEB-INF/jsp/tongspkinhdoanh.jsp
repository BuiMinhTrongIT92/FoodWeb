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
                <canvas id="myChartTongSPThang"></canvas>
            </div>

            <div class="table-wrapper-scroll-ymenu my-custom-scrollbarmenu">
                <table class="table table-bordered table-striped mb-0">
                    <thead class="themcuahangheadtable">
                        <tr>
                            <th scope="col"><spring:message code="tableonstate.tongsoluong"/></th>
                            <th scope="col"><spring:message code="tableonstate.tencuahang"/></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:if test="${tongspthang.size() > 0}">
                            <c:forEach items="${tongspthang}" var="tongspthang">
                                <tr>
                                    <td>${tongspthang[0]}</td>
                                    <td>${tongspthang[1]}</td>
                                </tr>
                            </c:forEach>
                        </c:if>


                    </tbody>
                </table>
            </div>        
        </div>

        <div class="col-md-5">
            <div class="admintitle"><spring:message code="tableonstate.thongketongsptheothang"/></div>
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
                <canvas id="myChartTongSPQuyNam"></canvas>
            </div>
            <div class="table-wrapper-scroll-ymenu my-custom-scrollbarmenu">
                <table class="table table-bordered table-striped mb-0">
                    <thead class="themcuahangheadtable">
                        <tr>
                            <th scope="col"><spring:message code="tableonstate.tongsoluong"/></th>
                            <th scope="col"><spring:message code="tableonstate.tencuahang"/></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:if test="${tongspquynam.size() > 0}">
                            <c:forEach items="${tongspquynam}" var="tongspquynam">
                                <tr>
                                    <td>${tongspquynam[0]}</td>
                                    <td>${tongspquynam[1]}</td>
                                    
                                </tr>
                            </c:forEach>
                        </c:if>

                    </tbody>
                </table>
            </div>

        </div>

        <div class="col-md-5">
            <div class="admintitle"><spring:message code="tableonstate.thongketongsptheoquynam"/></div>
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
        let labelstongspthang = [], datatongspthang = []
    <c:if test="${tongspthang.size() > 0}">
        <c:forEach items="${tongspthang}" var="tongspthang">
            labelstongspthang.push('${tongspthang[1]}')

            datatongspthang.push('${tongspthang[0]}')
        </c:forEach>

        charTongSPThang(labelstongspthang, datatongspthang);
    </c:if>
        
        
        let labelstongspquynam = [], datatongspquynam = []
    <c:if test="${tongspquynam.size() > 0}">
        <c:forEach items="${tongspquynam}" var="tongspquynam">
            labelstongspquynam.push('${tongspquynam[1]}')

            datatongspquynam.push('${tongspquynam[0]}')
        </c:forEach>

        charTongSPQuyNam(labelstongspquynam, datatongspquynam);
    </c:if>

    }

</script>

