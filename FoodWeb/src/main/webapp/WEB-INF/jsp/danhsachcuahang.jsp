
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<section class="py-5 overflow-hidden bg-primary" id="home">
    <div class="container">
        <div class="row flex-center">
            <div class="col-md-7 col-lg-6 py-8 text-md-start text-center">
                <h1 class="display-1 fs-md-5 fs-lg-6 fs-xl-8 text-light" id="dangkycontent"><spring:message code="cuahang.danhsachcuahang"/></h1>    
            </div>
        </div>
            <div class="danhsachcuahang" style="padding:40px;text-align: center">
                <table class="table">
                    <tr>
                        <td>Tên cửa hàng</td>
                        <td><input type="button" value="ok"/></td>
                    </tr>
                     <tr>
                        <td>Tên cửa hàng</td>
                        <td><input type="button" value="ok"/></td>
                    </tr>
                     <tr>
                        <td>Tên cửa hàng</td>
                        <td><input type="button" value="ok"/></td>
                    </tr>
                     <tr>
                        <td>Tên cửa hàng</td>
                        <td><input type="button" value="ok"/></td>
                    </tr>
                </table>
            </div>
    </div>
</section>
