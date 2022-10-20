<%-- 
    Document   : employee
    Created on : Aug 19, 2022, 10:48:08 AM
    Author     : vinhp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="row mt-5 mb-5">
    <div class="col-md-6 col-xs-12 mt-2 mb-2">
        <div class="">
            <h2 style="font-family: fantasy;">P&QCOMPANY</h2>
            <h6 style="font-family: courier">The best doctor gives the least medicines</h6>
            <hr>
        </div>

        <!--DANH SÁCH PHIẾU ĐẶT CỦA KHÁCH HÀNG-->
        <div> 
            <div style="height: 250px; overflow: auto;border-radius: 10px">
                <table class="table table-hover ">
                    <tr class="table-primary">
                        <th>Mã phiếu đặt</th>
                        <th>Tên khách hàng</th>
                        <th></th>
                    </tr>
                    <tbody id="myAppointmentForDoctor">
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <div class = "col-md-3 col-xs-12 mt-2 mb-2">
        <div class="card bg-light shadow rounded-3" style="text-align: center; align-items: center;border: none">
            <div class="mb-4 mt-5">
                <img class="card-img-top"
                     src="https://res.cloudinary.com/vinhphuvtv2/image/upload/v1662569031/Web_QLPM/Avatar/prescription_hguwgz.png"
                     alt="Card image"
                     style="width:60%">
            </div>
            <div class="card-body">
                <h4 class="card-title">Ra Toa Thuốc</h4>
                <a href="<c:url value="/employees/prescription"/>" class="btn btn-primary">Xác Nhận</a>
            </div>
        </div>
    </div>
    <div class = "col-md-3 col-xs-12 mt-2 mb-2">
        <div class="card bg-light shadow rounded-3" style="text-align: center; align-items: center;border: none">
            <div class="mb-4 mt-5">
                <img class="card-img-top"
                     src="https://res.cloudinary.com/vinhphuvtv2/image/upload/v1662568896/Web_QLPM/Avatar/medical-record_1_mfwahh.png"
                     alt="Card image"
                     style="width:60%">
            </div>
            <div class="card-body">
                <h4 class="card-title">Khám Bệnh</h4>
                <a href="<c:url value="/employees/medicalRecord"/>" class="btn btn-primary">Xác Nhận</a>
            </div>
        </div>
    </div>
</div>


<script src="<c:url value="/js/appointment.js" />"></script>
<script>
    <c:url value="/api/appointment" var="m" />
    window.onload = function () {
        getAppointmentForDoctor('${m}');
    };
</script>