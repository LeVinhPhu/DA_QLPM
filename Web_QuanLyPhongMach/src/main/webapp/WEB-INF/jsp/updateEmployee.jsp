<%-- 
    Document   : updateEmployee
    Created on : Oct 20, 2022, 12:34:56 AM
    Author     : vinhp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="mt-2 mb-3">
    <div style="text-align: center">
        <img src="${employeeUpdate.image}" width='150' />
    </div>
    <h3 class="mt-2 mb-2" style="text-align: center">${employeeUpdate.firstName} ${employeeUpdate.lastName}</h3>
</div>
<form:errors path="**" element="div" style="color: red; font-size: 13px; margin-top: 2px" />

<c:url value="/admins/updateEmployee/${employeeUpdate.id}" var="action" />
<form:form id="formUpdate" method="post" action="${action}" modelAttribute="employeeUpdate" enctype="multipart/form-data">
    <div class="form-floating input-row">
        <form:input type="text" path="firstName" class="form-control" id="firstName" placeholder="Nhap ho ten dem" name="firstName" />
        <label for="firstName">Họ và tên đệm:</label>
        <small></small>
    </div>

    <div class="form-floating input-row">
        <form:input type="text" path="lastName" class="form-control" id="lastName" placeholder="Nhap ten" name="lastName" />
        <label for="lastName">Tên:</label>
        <small></small>
    </div>

    <div class="row">
        <div class="col-md-8">
            <div class="input-row form-floating">
                <form:input type="date" class="form-control" path="dateOfBirth" id="dateOfBirth"/>
                <label for="dateOfBirth">Ngày Sinh:</label>
                <!--Sinh lổi-->
                <small></small>
            </div> 
        </div>

        <div class="col-md-4">
            <div class="input-row form-floating">
                <form:select path="sex" class="form-select" id="sex" name="sex">
                    <c:if test="${employeeUpdate.sex.equals('Nam')}">
                        <option value="Nam" selected="selected">Nam</option>
                        <option value="Nữ">Nữ</option>
                        <option value="Khác">Khác</option>
                    </c:if>
                    <c:if test="${employeeUpdate.sex.equals('Nữ')}">
                        <option value="Nam">Nam</option>
                        <option value="Nữ" selected="selected">Nữ</option>
                        <option value="Khác">Khác</option>
                    </c:if>
                    <c:if test="${employeeUpdate.sex.equals('Khác')}">
                        <option value="Nam" selected="selected">Nam</option>
                        <option value="Nữ">Nữ</option>
                        <option value="Khác" selected="selected">Khác</option>
                    </c:if>
                </form:select>
                <label for="sex" class="form-label">Giới Tính:</label>
                <!--Sinh lổi-->
                <small></small>
            </div>
        </div>
    </div>            

    <div class="form-floating input-row">
        <form:input type="text" path="email" class="form-control" id="email" placeholder="Nhap email" name="email" />
        <label for="email">Email:</label>
        <%--<form:errors path="name" element="div" cssClass="alert alert-danger" />--%>
        <small></small>
    </div>

    <div class="form-floating input-row">
        <form:input type="number" path="phone" class="form-control" id="phone" placeholder="Nhap phone" name="phone" />
        <label for="phone">Số điện thoại:</label>
        <small></small>
    </div>

    <div class="row">
        <div class="col-md-8">
            <div class="form-floating input-row">
                <form:input type="text" path="specialize" class="form-control" id="specialize" placeholder="Nhap chuyen khoa" name="specialize" />
                <label for="specialize">Chuyên khoa:</label>
                <small></small>
            </div>
        </div>

        <div class="col-md-4">
            <div class="input-row form-floating">
                <form:select path="userRole" class="form-select" id="userRole" name="userRole">
                    <c:if test="${employeeUpdate.userRole.equals('ROLE_DOCTOR')}">
                        <option value="ROLE_DOCTOR" selected="selected">Bác sĩ</option>
                        <option value="ROLE_NURSE">Y tá</option>
                    </c:if>
                    <c:if test="${employeeUpdate.userRole.equals('ROLE_NURSE')}">
                        <option value="ROLE_DOCTOR">Bác sĩ</option>
                        <option value="ROLE_NURSE" selected="selected">Y tá</option>
                    </c:if>
                </form:select>
                <label for="userRole" class="form-label">Chức vụ:</label>
                <!--Sinh lổi-->
                <small></small>
            </div>
        </div>
    </div>

    <div class="form-floating input-row">
        <form:input type="text" path="address" class="form-control" id="address" placeholder="Nhap dia chi" name="address" />
        <label for="address">Địa chỉ:</label>
        <small></small>
    </div>

    <div class="form-floating input-row">
        <form:input type="text" path="username" class="form-control" id="username" placeholder="Nhap username" name="username" />
        <label for="username">Tài khoản:</label>
        <small></small>
    </div>
    <div class="input-row">
        <label style="margin-left: 0;" class="ml-2"for="file">Chọn ảnh:</label>
        <form:input type="file" path="file" name="file" id="file" class="form-control" />
    </div>

    <div class="form-floating input-row">
        <form:input type="text" path="note" class="form-control" id="note" placeholder="Ghi chu" name="note" />
        <label for="note">Ghi chú</label>
    </div>

    <div class="form-floating mt-2" style="text-align: right">
        <input type="submit" id="btnUpdate" value="Lưu thông tin" class="btn mb-3 mt-3" style="background-color: #d1e7dd" />
    </div>
</form:form>

<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment-with-locales.min.js"></script> 

<script src="<c:url value="/js/updateEmployee.js" />"></script>
<script>
    _today: function () {
        document.getElementById("dateOfBirth").value = ${adminUpdate.dateOfBirth}.format("MM/DD/YYYY");
    }
</script>
