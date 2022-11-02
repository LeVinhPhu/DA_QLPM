<%-- 
    Document   : changePasswordCustomer
    Created on : Oct 25, 2022, 9:28:26 AM
    Author     : vinhp
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%--<form:errors path="**" element="div" style="color: red; font-size: 13px; margin-top: 2px" />--%>
<h3 class="mt-3 mb-3" style="text-align: center;">THAY ĐỔI THÔNG TIN MẬT KHẨU</h3>

<c:url value="/customers/changePasswordCustomer" var="action" />
<form:form id="formC" method="post" action="${action}" modelAttribute="changePasswordCustomer" enctype="multipart/form-data">
    
    <div class="form-floating input-row">
        <form:input type="hidden" path="oldPassword" class="form-control" id="oldPassword" placeholder="Nhap oldPassword" name="oldPassword" />
        <small></small>
    </div>

    <div class="form-floating input-row">
        <form:input type="password" path="password" class="form-control" id="password" placeholder="Nhap password" name="password" />
        <label for="newPassword">Nhập mật khẩu mới:</label>
        <form:errors path="password" element="div" style="color: red" />
        <small></small>
    </div>

    <div class="form-floating input-row">
        <form:input type="password" path="confirmPassword" class="form-control" id="confirmPassword" placeholder="confirmPassword" name="confirmPassword" />
        <label for="confirmNewPassword">Nhập lại mật khẩu mới:</label>
        <form:errors path="confirmPassword" element="div" style="color: red" />
        <c:if test="${errMsg != null}">
            <span style="color: red">
                ${errMsg}
            </span>  
        </c:if>
        <small></small>
    </div>

    <div class="form-floating mt-1" style="text-align: right">
        <input type="submit" id="btnUpdate" value="Đổi mật khẩu" class="btn mb-3 btn-primary" />
    </div>
</form:form>

<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment-with-locales.min.js"></script> 

<script src="<c:url value="/js/changePassword.js" />"></script>
