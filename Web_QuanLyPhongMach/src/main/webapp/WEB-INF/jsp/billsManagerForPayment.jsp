<%-- 
    Document   : billsManagerForPayment
    Created on : Sep 8, 2022, 10:59:25 AM
    Author     : phamt
--%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<div class="row  mb-4 mt-3" style="">
    <div class="col-md-9 col-12">
        <div class="mt-3">
            <h2 style="font-family: fantasy;">P&Q CLINIC </h2>
            <h6 style="font-family: courier">Customer is The God!</h6>
            <c:if test="${param.accessDenied != null}"> 
                <h6 style="font-family: courier; color: red; font-weight: bold">Bạn cần đăng nhập để tiếp tục !</h6>
            </c:if>
            <hr>
        </div>
    </div>
    <div class = "col-md-1 col-12 mt-2 mb-2" style="align-items: center;">
        <a href="/Web_QuanLyPhongMach/employees/nursesIndex" style="color: black; text-decoration: none">
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
        <a href="/Web_QuanLyPhongMach/employees/appointmentsManager" style="color: black; text-decoration: none">
            <div class="card bg-light shadow rounded-3" style="text-align: center; align-items: center;border: none">
                <div class="mt-3 mb-2">
                    <img class="card-img-top"
                         src="https://res.cloudinary.com/vinhphuvtv2/image/upload/v1662134267/Web_QLPM/Avatar/calendar_c7rbe9.png"
                         alt="Card image"
                         style="width:50%">
                </div>
                <h6 class="card-title" style="font-size: 13px;font-weight: bold">Lịch Khám</h6>
            </div>
        </a>
    </div>

    <div class = "col-md-1 col-12 mt-2 mb-2" style="align-items: center;">
        <a href="/Web_QuanLyPhongMach/employees/billsManager" style="color: black; text-decoration: none">
            <div class="card bg-light shadow rounded-3" style="text-align: center; align-items: center;border: none">
                <div class="mt-3 mb-2">
                    <img class="card-img-top"
                         src="https://res.cloudinary.com/vinhphuvtv2/image/upload/v1662134267/Web_QLPM/Avatar/medical_ih66se.png"
                         alt="Card image"
                         style="width:50%">
                </div>
                <h6 class="card-title" style="font-size: 13px;font-weight: bold">Thanh Toán</h6>
            </div>
        </a>
    </div>
</div>   


<h2 style="text-align: center; margin-top: 10px">HOÁ ĐƠN THANH TOÁN</h2>

<div>Mã phiếu khám ${medicalPayment[0][0]} </div> 
<div>Tên khách hàng: ${medicalPayment[0][1]} ${medicalPayment[0][2]}</div>
<div>Dịch vụ: ${medicalPayment[0][3]} </div>
<div>Giá dịch vụ: <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${medicalPayment[0][4]}" /> VNĐ</div>

Toa thuốc
<table class="table table-hover shadow">
                <tr>
                    <th>Tên thuốc</th>
                    <th>Số lượng</th>
                    <th>Đơn vị </th>
                    <th>Đơn giá (VNĐ)</th>
                    <th>Ghi chú</th>
                    <th></th>
                </tr>
                <tbody>
                    <c:forEach items="${medicineInPrescription}" var="m">
                        <tr>
                            <td>${m[4]}</td>
                            <td>${m[5]}</td>
                            <td>${m[6]}</td>
                            <td><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${m[7]}" /></td>
                            <td>${m[8]}</td>
                            <td><i style="color: lightgray" class="fas fa-minus"></i></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
<div>Tiền thuốc: <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${medicalPayment[0][5]}" /> VNĐ</div>
<div>Tổng tiền: <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${medicalPayment[0][6]}" /> VNĐ</div>
<c:url value="/employees/billsManager/${medicalRecordID}" var="action"></c:url>
<form method="post" action="${action}">
    <div class="form-floating"  style="text-align: center">
        <input type="submit" value="Thanh toán" class="btn btn-primary"/>
    </div>
</form>

