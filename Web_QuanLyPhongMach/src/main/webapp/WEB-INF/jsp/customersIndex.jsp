<%-- 
    Document   : customer
    Created on : Aug 19, 2022, 10:48:17 AM
    Author     : vinhp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="row mt-5 mb-5">
    <div class="col-md-6 col-xs-12 mt-2 mb-2">
        <div class="">
            <h2 style="font-family: fantasy;">P&QCOMPANY</h2>
            <h6 style="font-family: courier">Customer is The God!</h6>
            <hr>
        </div>
    </div>
    <div class = "col-md-3 col-xs-12 mt-2 mb-2">
        <div class="card bg-light shadow rounded-3" style="text-align: center; align-items: center;border: none">
            <div class="mb-4 mt-5">
                <img class="card-img-top"
                     src="https://res.cloudinary.com/vinhphuvtv2/image/upload/v1662268251/Web_QLPM/Avatar/timetable_pzzi91.png"
                     alt="Card image"
                     style="width:60%">
            </div>
            <h4 class="card-title">Đặt Lịch Khám</h4>
            <div class="card-body">
                <a href="<c:url value="/customers/appointments"/>" class="btn btn-primary">Xác Nhận</a>
            </div>
        </div>
    </div>
    <div class = "col-md-3 col-xs-12 mt-2 mb-2">
        <div class="card bg-light shadow rounded-3" style="text-align: center; align-items: center;border: none">
            <div class="mb-4 mt-5">
                <img class="card-img-top"
                     src="https://res.cloudinary.com/vinhphuvtv2/image/upload/v1662268258/Web_QLPM/Avatar/checklist_cppfzb.png"
                     alt="Card image"
                     style="width:60%">
            </div>
            <h4 class="card-title">Tra cứu thông tin</h4>
            <div class="card-body">
                <a href="<c:url value="/customers/customersIndex"/>" class="btn btn-primary">Xác Nhận</a>
            </div>
        </div>
    </div>
</div>