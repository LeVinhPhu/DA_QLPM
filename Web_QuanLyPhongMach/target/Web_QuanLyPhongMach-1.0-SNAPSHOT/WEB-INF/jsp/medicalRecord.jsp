<%-- 
    Document   : medicalRecord
    Created on : Aug 21, 2022, 10:55:14 AM
    Author     : vinhp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="row  mb-4 mt-3" style="">
    <div class="col-md-9 col-12">
        <div class="mt-3">
            <h2 style="font-family: fantasy;">P&Q CLINIC </h2>
            <h6 style="font-family: courier">The best doctor gives the least medicines</h6>
            <c:if test="${param.accessDenied != null}"> 
                <h6 style="font-family: courier; color: red; font-weight: bold">Bạn cần đăng nhập để tiếp tục !</h6>
            </c:if>
            <hr>
        </div>
    </div>
    <div class = "col-md-1 col-12 mt-2 mb-2" style="align-items: center;">
        <a href="/Web_QuanLyPhongMach/employees/doctorsIndex" style="color: black; text-decoration: none">
            <div class="card bg-light shadow rounded-3" style="text-align: center; align-items: center;border: none">
                <div class="mt-3 mb-2">
                    <img class="card-img-top"
                         src="https://res.cloudinary.com/vinhphuvtv2/image/upload/v1662556012/Web_QLPM/Avatar/home_hxzsfb.png"
                         alt="Card image"
                         style="width:50%">
                </div>
                <h6 class="card-title" style="font-size: 13px;font-weight: bold">Trang chủ</h6>
            </div>
        </a>
    </div>
    <div class = "col-md-1 col-12 mt-2 mb-2" style="align-items: center;">
        <a href="/Web_QuanLyPhongMach/employees/prescription" style="color: black; text-decoration: none">
            <div class="card bg-light shadow rounded-3" style="text-align: center; align-items: center;border: none">
                <div class="mt-3 mb-2">
                    <img class="card-img-top"
                         src="https://res.cloudinary.com/vinhphuvtv2/image/upload/v1662569031/Web_QLPM/Avatar/prescription_hguwgz.png"
                         alt="Card image"
                         style="width:50%">
                </div>
                <h6 class="card-title" style="font-size: 13px;font-weight: bold">Ra Toa</h6>
            </div>
        </a>
    </div>

    <div class = "col-md-1 col-12 mt-2 mb-2" style="align-items: center;">
        <a href="/Web_QuanLyPhongMach/employees/doctorsIndex" style="color: black; text-decoration: none">
            <div class="card bg-light shadow rounded-3" style="text-align: center; align-items: center;border: none">
                <div class="mt-3 mb-2">
                    <img class="card-img-top"
                         src="https://res.cloudinary.com/vinhphuvtv2/image/upload/v1662568896/Web_QLPM/Avatar/medical-record_1_mfwahh.png"
                         alt="Card image"
                         style="width:50%">
                </div>
                <h6 class="card-title" style="font-size: 13px;font-weight: bold">Khám Bệnh</h6>
            </div>
        </a>
    </div>
</div>   


<h2 style="text-align: center; margin-top: 10px">PHIẾU KHÁM BỆNH</h2>


<c:url value="/employees/medicalRecord/${cusID}" var="action" />
<form:form id="myForm" method="post" action="${action}" modelAttribute="medicalRecord" enctype="multipart/form-data">

    <div class="form-floating input-row">
        <form:select path="serviceId" class="form-select" id="serviceId" name="serviceId">
            <c:forEach items="${services}" var="s">
                <option value="${s.id}">${s.name}</option>
            </c:forEach>
        </form:select>
        <label for="serviceId" class="form-label">Loại dịch vụ</label>
    </div>

    <div class="form-floating input-row">
        <form:input type="text" path="symptom" class="form-control" id="symptom" placeholder="Nhap trieu chung" name="name" />
        <label for="name">Triệu chứng</label>
        <%--<form:errors path="name" element="div" cssClass="alert alert-danger" />--%>
        <small></small>
    </div>

    <div class="form-floating input-row">
        <form:input type="text" path="conclusion" class="form-control" id="conclusion" placeholder="Nhap ket luan benh" name="conclusion" />
        <label for="conclusion">Kết luận</label>
        <%--<form:errors path="unitPrice" element="div" cssClass="alert alert-danger" />--%>
        <small></small>
    </div>

    <div class="form-floating input-row">
        <form:input type="text" path="note" class="form-control" id="note" placeholder="Ghi chu" name="note" />
        <label for="note">Ghi chú</label>
    </div>

    <div class="form-floating mt-2">
        <input type="submit" id="btnAdd" value="Lập phiếu" class="btn mb-3 mt-3 btn btn-primary"/>
    </div>

</form:form>  