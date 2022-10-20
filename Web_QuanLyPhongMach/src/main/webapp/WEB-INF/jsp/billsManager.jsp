<%-- 
    Document   : billsManager
    Created on : Aug 21, 2022, 11:09:11 AM
    Author     : vinhp
--%>

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


<h2 style="text-align: center; margin-top: 10px">DANH SÁCH HOÁ ĐƠN</h2>

<!--DANH SÁCH PHIẾU KHÁM BỆNH-->
<div class="row"> 
    <div class="col-md-2 col-12"></div><!-- comment -->
    <div class="col-md-8 col-12" style="overflow: auto; height: 500px; border-radius: 10px">
        <c:url value="/employees/billsManager" var="action" />
        <form method="post" action="${action}">
            <table class="table table-hover">
                <tr class="table-primary">
                    <th>Mã phiếu khám</th>
                    <th>Tên khách hàng</th>
                    <th>Loại dịch vụ</th>
                    <th>Tổng tiền</th>
                    <th></th>
                </tr>
                <tbody id="myMedicalRecord">
                    <c:forEach items="${medicalRecordForNurse}" var="d">
                        <tr>
                            <td>${d[1]}</td>
                            <td>${d[2]} ${d[3]}</td>
                            <td>${d[4]}</td>
                            <td><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${d[0]}" /> VNĐ</td>
                            <td style="text-align: right"><a class="btn btn-primary" href="/Web_QuanLyPhongMach/employees/billsManager/${d[1]}">Thanh toán</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </form>
    </div>

    <div class="col-md-2 col-12"></div>
</div>

        <script src="<c:url value="/js/appointment.js" />"></script>
<script>
    <c:url value="/api/appointment" var="m" />
    window.onload = function () {
        getAppointmentForDoctor('${m}');
    };
</script>
