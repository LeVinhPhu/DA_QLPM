
<%-- 
    Document   : reports3Manager
    Created on : Aug 31, 2022, 6:26:36 PM
    Author     : vinhp
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<div class="row  mb-4 mt-3" style="">
    <div class="col-md-5 col-12">
        <div class="mt-3">
            <h2 style="font-family: fantasy;">P&Q CLINIC </h2>
            <h6 style="font-family: courier">Only a life lived for others is a life worthwhile</h6>
            <c:if test="${param.accessDenied != null}"> 
                <h6 style="font-family: courier; color: red; font-weight: bold">Bạn cần đăng nhập để tiếp tục !</h6>
            </c:if>
            <hr>
        </div>
    </div>
    <div class = "col-md-1 col-12 mt-2 mb-2" style="align-items: center;">
        <a href="/Web_QuanLyPhongMach/admins/adminIndex" style="color: black; text-decoration: none">
            <div class="card bg-light shadow rounded-3" style="text-align: center; align-items: center;border: none">
                <div class="mt-3 mb-2">
                    <img class="card-img-top"
                         src="https://res.cloudinary.com/vinhphuvtv2/image/upload/v1662556012/Web_QLPM/Avatar/home_hxzsfb.png"
                         alt="Card image"
                         style="width:50%">
                </div>
                <h6 class="card-title" style="font-size: 13px;font-weight: bold">Trang Chủ</h6>
            </div>
        </a>
    </div>
    <c:if test="${currentUser.userRole.equals('ROLE_SUPERADMIN')}">
        <div class = "col-md-1 col-12 mt-2 mb-2" style="align-items: center;">
            <a href="/Web_QuanLyPhongMach/admins/adminsManager" style="color: black; text-decoration: none">
                <div class="card bg-light shadow rounded-3" style="text-align: center; align-items: center;border: none">
                    <div class="mt-3 mb-2">
                        <img class="card-img-top"
                             src="https://res.cloudinary.com/vinhphuvtv2/image/upload/v1662556012/Web_QLPM/Avatar/writing_hkvivo.png"
                             alt="Card image"
                             style="width:50%">
                    </div>
                    <h6 class="card-title" style="font-size: 13px;font-weight: bold">QL Admin</h6>
                </div>
            </a>
        </div>    
    </c:if>   
    <div class = "col-md-1 col-12 mt-2 mb-2" style="align-items: center;">
        <a href="/Web_QuanLyPhongMach/admins/employeesManager" style="color: black; text-decoration: none">
            <div class="card bg-light shadow rounded-3" style="text-align: center; align-items: center;border: none">
                <div class="mt-3 mb-2">
                    <img class="card-img-top"
                         src="https://res.cloudinary.com/vinhphuvtv2/image/upload/v1662556012/Web_QLPM/Avatar/writing_hkvivo.png"
                         alt="Card image"
                         style="width:50%">
                </div>
                <h6 class="card-title" style="font-size: 13px;font-weight: bold">QL Nhân Viên </h6>
            </div>
        </a>
    </div>    
    <div class = "col-md-1 col-12 mt-2 mb-2" style="align-items: center;">
        <a href="/Web_QuanLyPhongMach/admins/medicinesManager" style="color: black; text-decoration: none">
            <div class="card bg-light shadow rounded-3" style="text-align: center; align-items: center;border: none">
                <div class="mt-3 mb-2">
                    <img class="card-img-top"
                         src="https://res.cloudinary.com/vinhphuvtv2/image/upload/v1662556012/Web_QLPM/Avatar/writing_hkvivo.png"
                         alt="Card image"
                         style="width:50%">
                </div>
                <h6 class="card-title" style="font-size: 13px;font-weight: bold">QL Thuốc</h6>
            </div>
        </a>
    </div>
    <div class = "col-md-1 col-12 mt-2 mb-2" style="align-items: center;">
        <a href="/Web_QuanLyPhongMach/admins/customersManager" style="color: black; text-decoration: none">
            <div class="card bg-light shadow rounded-3" style="text-align: center; align-items: center;border: none">
                <div class="mt-3 mb-2">
                    <img class="card-img-top"
                         src="https://res.cloudinary.com/vinhphuvtv2/image/upload/v1662556169/Web_QLPM/Avatar/rating_jgs7jn.png"
                         alt="Card image"
                         style="width:50%">
                </div>
                <h6 class="card-title" style="font-size: 13px;font-weight: bold">Khách Hàng</h6>
            </div>
        </a>
    </div>
    <div class = "col-md-1 col-12 mt-2 mb-2" style="align-items: center;">
        <a href="/Web_QuanLyPhongMach/admins/reportsManager" style="color: black; text-decoration: none">
            <div class="card bg-light shadow rounded-3" style="text-align: center; align-items: center;border: none">
                <div class="mt-3 mb-2">
                    <img class="card-img-top"
                         src="https://res.cloudinary.com/vinhphuvtv2/image/upload/v1662556013/Web_QLPM/Avatar/growth_z4ewzy.png"
                         alt="Card image"
                         style="width:50%">
                </div>
                <h6 class="card-title" style="font-size: 13px;font-weight: bold">Thống Kê</h6>
            </div>
        </a>
    </div>
    <div class = "col-md-1 col-12 mt-2 mb-2" style="align-items: center;">
        <a href="/Web_QuanLyPhongMach/admins/onCallManager" style="color: black; text-decoration: none">
            <div class="card bg-light shadow rounded-3" style="text-align: center; align-items: center;border: none">
                <div class="mt-3 mb-2">
                    <img class="card-img-top"
                         src="https://res.cloudinary.com/vinhphuvtv2/image/upload/v1662556012/Web_QLPM/Avatar/calendar_2_pbkqiv.png"
                         alt="Card image"
                         style="width:50%">
                </div>
                <h6 class="card-title" style="font-size: 13px;font-weight: bold">Lịch Trực</h6>
            </div>
        </a>
    </div>
</div>   

<div class="row mb-5 mt-2">
    <div class="col-md-6 col-12"  style="text-align: center;">
        <div style="color: black; border: none" class="card bg-light">
            <h2 style="text-align: center; margin-top: 10px">QUẢN LÝ THỐNG KÊ</h2>
        </div>
    </div>
    <div class="col-md-2 col-12">
        <a href="/Web_QuanLyPhongMach/admins/reportsManager" style="color: black; text-decoration: none">
            <div class="card bg-light rounded-3" style="text-align: center; align-items: center;border: none">
                <h6 class="card-title mt-3 mb-3" style="font-size: 15px;font-weight: bold">Doanh thu</h6>
            </div>
        </a>
    </div>
    <div class="col-md-2 col-12">
        <a href="/Web_QuanLyPhongMach/admins/reports2Manager" style="color: black; text-decoration: none">
            <div class="card bg-light rounded-3" style="text-align: center; align-items: center;border: none">
                <h6 class="card-title mt-3 mb-3" style="font-size: 15px;font-weight: bold">Số lượng Bệnh nhân</h6>
            </div>
        </a>
    </div>
    <div class="col-md-2 col-12">
        <a href="/Web_QuanLyPhongMach/admins/reports3Manager" style="color: black; text-decoration: none">
            <div class="card bg-light  shadow rounded-3" style="text-align: center; align-items: center;border: none">
                <h6 class="card-title mt-3 mb-3" style="font-size: 15px;font-weight: bold">Tần suất sử dụng Thuốc</h6>
            </div>
        </a>
    </div>
</div>

<div class="row mb-5 mt-5 d-flex justify-content-center">
    <div data-bs-toggle="modal" data-bs-target="#myModal" class="col-md-2 col-12"  style="text-align: center;">
        <div style="color: black; border: none" class="card bg-light shadow rounded-3">
            <div class="mt-4 mb-3">
                <img class="card-img-top"
                     src="https://res.cloudinary.com/vinhphuvtv2/image/upload/v1662562119/Web_QLPM/Avatar/statistics_2_r18oez.png"
                     alt="Card image"
                     style="width:40%">
            </div>
            <h6 class="card-title">Theo Năm</h6>
        </div>
        <c:if test="${err1 != null}">
            <div class="mt-2">
                <span style="color: red">
                    ${err1}
                </span>
            </div>
        </c:if>
    </div>

    <div data-bs-toggle="modal" data-bs-target="#myModal2" class="col-md-2 col-12"  style="text-align: center;">
        <div style="color: black; border: none" class="card bg-light shadow rounded-3">
            <div class="mt-4 mb-3">
                <img class="card-img-top"
                     src="https://res.cloudinary.com/vinhphuvtv2/image/upload/v1662562259/Web_QLPM/Avatar/pie-graph_1_dwafob.png"
                     alt="Card image"
                     style="width:40%">
            </div>
            <h6 class="card-title">Theo Quý</h6>
        </div>
        <c:if test="${err2 != null}">
            <div class="mt-2">
                <span style="color: red">
                    ${err2}
                </span>
            </div>
        </c:if>
    </div>
    <div data-bs-toggle="modal" data-bs-target="#myModal3" class="col-md-2 col-12"  style="text-align: center;">
        <div style="color: black; border: none" class="card bg-light shadow rounded-1">
            <div class="mt-4 mb-3">
                <img class="card-img-top"
                     src="https://res.cloudinary.com/vinhphuvtv2/image/upload/v1662562119/Web_QLPM/Avatar/diagram_phb81d.png"
                     alt="Card image"
                     style="width:40%">
            </div>
            <h6 class="card-title">Theo Tháng</h6>
        </div>
        <c:if test="${err3 != null}">
            <div class="mt-2">
                <span style="color: red">
                    ${err3}
                </span>
            </div>
        </c:if>
    </div>
</div>



<div class="row mb-2 mt-2">
    <div class="col-md-9 col-12">
        <div style="text-align: center" class="">
            <!-- The Modal --> <!--Tần suất sử dụng thuốc theo năm-->
            <div class="modal" id="myModal">
                <div class="modal-dialog">
                    <div class="modal-content">

                        <!-- Modal Header -->
                        <div class="modal-header">
                            <h4 class="modal-title">TẦN SUẤT SỬ DỤNG THUỐC NĂM <c:out value="${year1}" /></h4> 
                            <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                        </div>

                        <!-- Modal body -->
                        <div class="modal-body">
                            <div class="row mt-2">  
                                <div class="">
                                    <table class="table">
                                        <tr>
                                            <th>Tên thuốc</th>
                                            <th>Tần suất</th>
                                        </tr>

                                        <c:forEach items="${frequencyMedicineUsageStatsByYear}" var="f">
                                            <tr>
                                                <td>${f[0]}</td>
                                                <td>${f[1]}</td>
                                            </tr>
                                        </c:forEach>
                                    </table>
                                </div>
                                <div class="">
                                    <form action="${action}" method="POST">
                                        <div class="mb-2 mt-2">
                                            <input type="number" class="form-control" placeholder="Nhập năm" name="year1">
                                        </div>
                                        <div style="float: right">
                                            <button type="submit "class="btn btn-primary" style="margin-bottom: 5px">Thống kê</button>
                                        </div>
                                    </form>
                                    <canvas id="myChartFrequencyMedicineUsageStatsByYear"></canvas>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- The Modal --> <!--Tần suất sử dụng thuốc theo quý-->
            <div class="modal" id="myModal2">
                <div class="modal-dialog">
                    <div class="modal-content">

                        <!-- Modal Header -->
                        <div class="modal-header">
                            <h4 class="modal-title">TẦN SUẤT SỬ DỤNG THUỐC QUÝ <c:out value="${quarter2}" /> NĂM <c:out value="${year2}" /></h4> 
                            <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                        </div>

                        <!-- Modal body -->
                        <div class="modal-body">
                            <div class="row mt-2">  
                                <div class="">
                                    <table class="table">
                                        <tr>
                                            <th>Tên thuốc</th>
                                            <th>Tần suất</th>
                                        </tr>
                                        <c:if test="${not empty frequencyMedicineUsageStatsByQuarter[0][0]}"> 
                                            <c:forEach items="${frequencyMedicineUsageStatsByQuarter}" var="p">
                                                <tr>
                                                    <td>${p[0]}</td>
                                                    <td>${p[1]}</td><!--
                                                    --></tr>
                                                </c:forEach>
                                            </c:if>

                                        <c:if test="${frequencyMedicineUsageStatsByQuarter[0][0] == null}">
                                            <td></td>
                                            <td>Chưa có dữ liệu</td>
                                        </c:if>
                                    </table>
                                </div>
                                <div class="">

                                    <form action="${action}" method="POST">
                                        <div class="mb-2 mt-2">
                                            <select name="quarter2" class="form-select" aria-label="Default select example">
                                                <option value="1">Quý 1</option>
                                                <option value="2">Quý 2</option>
                                                <option value="3">Quý 3</option>
                                                <option value="4">Quý 4</option>
                                            </select>
                                        </div>
                                        <div class="mb-2 mt-2">
                                            <input type="number" class="form-control" placeholder="Nhập năm" name="year2">
                                        </div>
                                        <div style="float: right">
                                            <button type="submit "class="btn btn-primary" style="margin-bottom: 5px">Thống kê</button>
                                        </div>

                                    </form>
                                    <canvas id="myChartFrequencyMedicineUsageStatsByQuarter"></canvas>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- The Modal --> <!--Tần suất sử dụng thuốc theo tháng-->
            <div class="modal" id="myModal3">
                <div class="modal-dialog">
                    <div class="modal-content">

                        <!-- Modal Header -->
                        <div class="modal-header">
                            <h4 class="modal-title">TẦN SUẤT SỬ DỤNG THUỐC THÁNG <c:out value="${month3}" /> NĂM <c:out value="${year3}" /></h4>
                            <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                        </div>

                        <!-- Modal body -->
                        <div class="modal-body">
                            <div class="row mt-2">  
                                <div class="">
                                    <table class="table">
                                        <tr>
                                            <th>Tên thuốc</th>
                                            <th>Tần suất</th>
                                        </tr>
                                        <c:if test="${not empty frequencyMedicineUsageStatsByMonth[0][0]}"> 
                                            <c:forEach items="${frequencyMedicineUsageStatsByMonth}" var="m">
                                                <tr>
                                                    <td>${m[0]}</td>
                                                    <td>${m[1]}</td>
                                                </tr>
                                            </c:forEach>
                                        </c:if>

                                        <c:if test="${frequencyMedicineUsageStatsByMonth[0][0] == null}">
                                            <td></td>
                                            <td>Chưa có dữ liệu</td>
                                        </c:if>
                                    </table>
                                </div>
                                <div class="">
                                    <form action="${action}" method="POST">
                                        <div class="mb-2 mt-2">
                                            <input type="number" class="form-control" placeholder="Nhập tháng" name="month3">
                                        </div>
                                        <div class="mb-2 mt-2">
                                            <input type="number" class="form-control" placeholder="Nhập năm" name="year3">
                                        </div>
                                        <div style="float: right">
                                            <button type="submit "class="btn btn-primary" style="margin-bottom: 5px">Thống kê</button>
                                        </div>

                                    </form>
                                    <canvas id="myChartFrequencyMedicineUsageStatsByMonth"></canvas>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>    
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="<c:url value="/js/statistic.js" />"></script>
<script>
    window.onload = function () {
        let data = [];
        let labels = [];
        let data2 = [];
        let labels2 = [];
        let data3 = [];
        let labels3 = [];

    <c:forEach items="${frequencyMedicineUsageStatsByYear}" var="c">
        data.push(${c[1]});
        labels.push('${c[0]}');
    </c:forEach>

    <c:forEach items="${frequencyMedicineUsageStatsByQuarter}" var="r">
        data2.push(${r[1]});
        labels2.push('${r[0]}');
    </c:forEach>
    <c:forEach items="${frequencyMedicineUsageStatsByMonth}" var="r">
        data3.push(${r[1]});
        labels3.push('${r[0]}');
    </c:forEach>
        frequencyMedicineUsageStatsByYear(labels, data);
        frequencyMedicineUsageStatsByQuarter(labels2, data2);
        frequencyMedicineUsageStatsByMonth(labels3, data3);
    }
</script>


