<%--
    Document   : register
    Created on : Aug 21, 2022, 11:10:26 AM
    Author     : vinhp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<div class="shadow rounded-3 mt-4 bg-light" style="width: 50%; margin-left: 25%;">
    <div class="form-floating" style="padding-top: 3%">
        <h3 style="text-align: center">Đăng ký tài khoản</h3>
    </div>
    <div style="width: 90%; margin: 5%; padding-top: 1%; padding-bottom: 1%">
        <c:url value="/register" var="action" />
        <form:form id='form' method="post" action="${action}" modelAttribute="customers" enctype="multipart/form-data">

            <div class="form-floating input-row">
                <form:input type="text" path="firstName" class="form-control" id="firstName" placeholder="Nhap ho va ten dem" name="name" />
                <label for="name">Họ và tên đệm <span style="color: red">*</span></label>
                <form:errors path="firstName" element="div" style="color: red" />
                <small>Error</small>
            </div>
            <div class="form-floating input-row">
                <form:input type="text" path="lastName" class="form-control" id="lastName" placeholder="Nhap ten" name="name" />
                <label for="name">Tên <span style="color: red">*</span></label>
                <form:errors path="lastName" element="div" style="color: red" />
                <small>Error</small>
            </div>
            <div class="row">
                <div class="col-md-4">
                    <div class="form-floating input-row">
                        <form:select path="sex" class="form-select" id="sex" name="sex">
                            <option value="Nam">Nam</option>
                            <option value="Nữ">Nữ</option>
                            <option value="Khác">Khác</option>
                        </form:select>
                        <label for="sex" class="form-label">Giới tính</label>
                    </div>
                </div>
                <div class="col-md-8">
                    <div class="input-row form-floating">
                        <form:input path="dateOfBirth" class="form-control" type="date" id="birthday" name="birthday" />
                        <label for="birthday">Ngày sinh<span style="color: red">*</span></label>
                        <form:errors path="dateOfBirth" style="color: red" />
                        <c:if test="${errMsg3 != null}">
                            <span style="color: red">
                                ${errMsg3}
                            </span>  
                        </c:if>
                        <small>Error</small>
                    </div> 
                </div>
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
                <form:input type="number" path="phone" class="form-control" id="phone" placeholder="Nhap SDT" name="phone" />
                <label for="phone">Số điện thoại:<span style="color: red">*</span></label>
                <form:errors path="phone" style="color: red" />
                <small></small>

            </div>
            <div class="form-floating input-row">
                <form:input type="text" path="username" class="form-control" id="username" placeholder="Nhap Username" name="username" />
                <label for="username">Tên tài khoản:<span style="color: red">*</span></label>
                <form:errors path="username" style="color: red" />
                <c:if test="${errMsg2 != null}">
                    <span style="color: red">
                        ${errMsg2}
                    </span>  
                </c:if>
                <small></small>

            </div>

            <div class="form-floating input-row">
                <form:input type="password" path="password" class="form-control" id="password" placeholder="Mat khau" name="p" />
                <label for="p">Mật khẩu <span style="color: red">*</span></label>
                <form:errors path="password" element="div" style="color: red" />
                <small>Error</small>
            </div>
            <div class="form-floating input-row">
                <form:input type="password" path="confirmPassword" class="form-control" id="confirmPassword" placeholder="Xac nhan mat khau" name="p2" />
                <label for="p2">Xác nhận mật khẩu <span style="color: red">*</span></label>
                <form:errors path="confirmPassword" element="div" style="color: red" />
                <c:if test="${errMsg != null}">
                    <span style="color: red">
                        ${errMsg}
                    </span>
                </c:if>
                <small></small>
            </div>

            <div class="mt-2" style="text-align: center">
                <input id="btnRegister" type="submit" value="Đăng ký" class="btn btn-primary" />
            </div>

            <div class="form-floating mb-4" style="text-align: center">
                <span style="font-size: 12px">Bạn đã có tài khoản? <a href="/Web_QuanLyPhongMach/login" style="text-decoration: none">Đăng nhập</a></span>
            </div>
        </form:form>  
    </div>
</div>

<script src="https://unpkg.com/axios/dist/axios.min.js"></script>