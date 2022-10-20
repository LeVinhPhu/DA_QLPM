<%-- 
    Document   : details
    Created on : Sep 1, 2022, 9:55:44 AM
    Author     : phamt
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h3 style="text-align: center">${medicine1.name}</h3>
<div style="text-align: center">
    <img src="${medicine1.image}" width='150' />
</div>

<c:url value="/admins/medicinesManager/${medicine1.id}" var="action" />
<form:form id="formUpdate" method="post" action="${action}" modelAttribute="medicine1" enctype="multipart/form-data">
    <div style="width: 50%; margin-left: 25%">
        <div class="form-floating input-row">
            <form:input type="text" path="name" class="form-control" id="mName" placeholder="Nhap ten" name="name" />
            <label for="name">Tên thuốc <span style="color: red">*</span></label>
            <form:errors path="name" element="div" style="color: red; font-size: 13px; margin-top: 2px" />
            <small></small>
        </div>
        <div class="form-floating input-row">
            <form:select path="unitId" class="form-select" id="unit" name="unit">
                <option selected="selected" value="${medicine1.unitId.id}">Chọn đơn vị</option>
                <c:forEach items="${units}" var="u">
                    <option value="${u.id}">${u.name}</option>
                </c:forEach>
            </form:select>
            <label for="unit" class="form-label">Đơn vị</label>
        </div>
        <div class="form-floating input-row">
            <form:input type="number" path="unitPrice" class="form-control" id="mUnitPrice" placeholder="Nhap gia" name="unitPrice" />
            <label for="unitPrice">Đơn giá <span style="color: red">*</span></label>
            <%--<form:errors path="unitPrice" element="div" style="color: red; font-size: 13px; margin-top: 2px" />--%>
            <small></small>
        </div>

        <div class="form-floating input-row">
            <form:input type="number" path="quantity" class="form-control" id="mQuantity" placeholder="Nhap so luong" name="quantity" />
            <label for="quantity">Số lượng</label>
            <small></small>
        </div>
        <div class="form-floating input-row">
            <form:select path="supplierId" class="form-select" id="sup" name="sup">
                <option selected="selected" value="${medicine1.supplierId.id}"}>Chọn nhà cung cấp</option>
                <c:forEach items="${suppliers}" var="s">
                    <option value="${s.id}">${s.companyName}</option>
                </c:forEach>
            </form:select>
            <label for="sup" class="form-label">Nhà cung cấp</label>
        </div>
        <div class="input-row">
            <label style="margin-left: 4.5%;" class="ml-2"for="file">Chọn ảnh</label>
            <form:input type="file" path="file" name="file" id="file" class="form-control" />
        </div>
        <div class="form-floating input-row">
            <form:input type="text" path="note" class="form-control" id="name" placeholder="Nhap ten" name="name" />
            <label for="name">Ghi chú</label>
        </div>
        <div>
            <input id="btnUpdate" type="submit" value="Sửa thuốc" class="btn btn-warning mb-3 mt-3" />
        </div>    

    </div>


</form:form>


<script src="<c:url value="/js/updateMedicine.js" />"></script>