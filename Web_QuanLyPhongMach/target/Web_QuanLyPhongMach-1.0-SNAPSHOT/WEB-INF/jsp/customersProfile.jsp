<%-- 
    Document   : adminsProfile
    Created on : Sep 4, 2022, 12:40:08 PM
    Author     : vinhp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<h3 class="mt-2 mb-2" style="text-align: center">${currentUser.firstName} ${currentUser.lastName}</h3>
<div style="text-align: center">
    <img src="${currentUser.image}" width='150' />
</div>

<form:errors path="**" element="div" style="color: red; font-size: 13px; margin-top: 2px" />

<c:url value="/customers/customersProfile" var="action" />
<form:form id="updateProfileCustomer" method="post" action="${action}" modelAttribute="updateProfileCustomer" enctype="multipart/form-data">

    <div style="width: 50%; margin-left: 25%">
        <div class="form-floating input-row">
            <form:input type="text" path="firstName" class="form-control" id="firstName" placeholder="Nhap ten" name="firstName" />
            <label for="firstName">Họ và tên đệm <span style="color: red">*</span></label>
            <%--<form:errors path="name" element="div" style="color: red; font-size: 13px; margin-top: 2px" />--%>
            <small></small>
        </div>

        <div class="form-floating input-row">
            <form:input type="text" path="lastName" class="form-control" id="lastName" placeholder="Nhap ten" name="lastName" />
            <label for="lastName">Tên <span style="color: red">*</span></label>
            <small></small>
        </div>

        <div class="form-floating input-row">
            <form:select path="sex" class="form-select" id="sex" name="sex">
                <option value="Nam">Nam</option>
                <option value="Nữ">Nữ</option>
                <option value="Khác">Khác</option>
            </form:select>
            <label for="sex" class="form-label">Giới tính</label>
        </div>

        <div class="input-row form-floating">
            <form:input path="dateOfBirth" class="form-control" type="date" id="dateOfBirth" name="dateOfBirth" />
            <label for="dateOfBirth">Ngày sinh</label>
            <small>Error</small>
        </div>    

        <div class="form-floating input-row">
            <form:input type="text" path="address" class="form-control" id="address" placeholder="Nhap dia chi" name="name" />
            <label for="name">Địa chỉ</label>
        </div>

        <div class="form-floating mt-3 input-row">
            <form:input type="email" path="email" class="form-control" id="email" placeholder="Nhap email" name="name" />
            <label for="name">Email</label>
            <small>Error</small>
        </div>

        <div class="form-floating input-row">
            <form:input type="number" path="phoneNumber" class="form-control" id="phoneNumber" placeholder="Nhap SDT" name="phoneNumber" />
            <label for="phone">Số điện thoại <span style="color: red">*</span></label>
            <small>Error</small>
        </div>

<!--        <div class="input-row">
            <label style="" class="ml-2"for="file">Chọn ảnh</label>
            <%--<form:input type="file" path="file" name="file" id="file" class="form-control" />--%>
        </div>-->

        <!--        <div class="form-floating input-row">
        <%--<form:input type="password" path="password" class="form-control" id="password" placeholder="Mat khau" name="password" />--%>
        <label for="p">Mật khẩu <span style="color: red">*</span></label>
        <small>Error</small>
    </div>

    <div class="form-floating input-row">
        <%--<form:input type="password" path="" class="form-control" id="confirmPassword" placeholder="Xac nhan mat khau" name="confirmPassword" />--%>
        <label for="p2">Xác nhận mật khẩu <span style="color: red">*</span></label>
        <small>Error</small>
    </div>-->
        <div>
            <input id="btnUpdateProfile" type="submit" value="Cập nhật" class="btn btn-warning mb-3 mt-3" />
        </div>    
    </div>
</form:form>

<script src="<c:url value="/js/customerProfile.js" />"></script>
<script>
    document.getElementById('firstName').value = "${currentUser.firstName}";
    document.getElementById('lastName').value = "${currentUser.lastName}";
    document.getElementById('dateOfBirth').value = "${currentUser.dateOfBirth}";
    document.getElementById('email').value = "${currentUser.email}";
    document.getElementById('phoneNumber').value = "${currentUser.phoneNumber}";
    document.getElementById('password').value = "${currentUser.password}";
    document.getElementById('confirmPassword').value = "${currentUser.password}";
    document.getElementById('address').value = "${currentUser.address}";
</script>