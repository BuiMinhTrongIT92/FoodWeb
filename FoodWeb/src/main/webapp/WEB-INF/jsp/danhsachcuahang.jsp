
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

        <div class="danhsachcuahang">
            <a onclick="hienDangKyCuahang()"><input type="button" class="btn btn-success" value="Thêm cửa hàng"/></a>
            <br/>
            <br/>
            <table class="table">
                <c:forEach items="${listcuahang}" var="listcuahang">
                    <tr id="cuahangtrongds">
                        <td>${listcuahang.tencuahang}</td>
                        <c:url value="/cuahang/${listcuahang.idcuahang}" var="cuahang" />
                        <c:if test="${listcuahang.active == true}">
                            <td><i style="color: green" class="fas fa-check-circle"></i></td>
                            </c:if>
                            <c:if test="${listcuahang.active == false}">
                            <td><i style="color: red" class="fas fa-times-circle"></i></td>
                            </c:if>    
                        <td class="tools">
                            <a href="${cuahang}" type="button" ><i class="fas fa-sign-in-alt"></i></a>
                            <a href="#" type="button" ><i class="fas fa-edit"></i></a>
                            <a href="#" type="button" ><i class="fas fa-trash-alt"></i></a>
                        </td>
                    </tr>
                </c:forEach>


            </table>
            <div class="themcuahang animate container" id="themcuahang" ">
                <div class="modal-dialog">
                    <div class="modal-content">

                        <!-- Modal Header -->
                        <div class="modal-header" style="text-align: center">
                            <h4 class="modal-title" ><spring:message code="cuahang.dangkycuahang"/></h4>
                            <button onclick="anDangKyCuahang()" type="button" class="btn-close" data-bs-dismiss="modal"></button>
                        </div>

                        <!-- Modal body -->
                        <div class="modal-body">
                            <form:form class="form-group" method="POST" modelAttribute="cuahang" enctype="multipart/form-data">
                                <div class="form-group">
                                    <spring:message code="dangkycuahang.tencuahang" var="tencuahang"/>
                                    <form:input type="text" cssClass="form-control form__input" path="tencuahang" placeholder="${tencuahang}" />
                                </div>
                                <div class="form-group">
                                    <spring:message code="dangkycuahang.diachi" var="diachi"/>
                                    <form:input type="text" cssClass="form-control form__input" path="diachi" placeholder="${diachi}" />
                                </div>
                                <div class="form-group">
                                    <spring:message code="dangkycuahang.logo" var="logo"/>
                                    <form:input type="file" cssClass="form-control form__input" path="file" placeholder="${logo}" />
                                </div>
                                <input type="submit"/>ĐĂNG KÝ</button>
                            </form:form>
                        </div>

                        <!-- Modal footer -->


                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</section>
