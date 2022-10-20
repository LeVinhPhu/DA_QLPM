
<%-- 
    Document   : reports3Manager
    Created on : Aug 31, 2022, 6:26:36 PM
    Author     : vinhp
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="row mb-2 mt-2">
    <div class="col-md-9 col-12">
        <div style="text-align: center" class="">
            <div class="bg-light">
                <div class="pt-2 pb-1">
                    <h4 class="text-center">QUẢN LÝ THỐNG KÊ - TẦN SUẤT SỬ DỤNG THUỐC</h4>
                </div>
            </div>

            <!--tần suất sử dụng thuốc theo năm-->
            <div class="mt-3 mb-2 pt-2 pb-1">
                <button style="width: 40%;" type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#myModal">TẦN SUẤT SỬ DỤNG THUỐC THEO NĂM</button>
                <c:if test="${err1 != null}">
                    <div class="mt-2">
                        <span style="color: red">
                            ${err1}
                        </span>
                    </div>
                </c:if>
            </div>

            <!--tần suất sử dụng thuốc theo quý-->
            <div class="mt-3 mb-2 pt-2 pb-1">
                <button style="width: 40%;" type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#myModal2">TẦN SUẤT SỬ DỤNG THUỐC THEO QUÝ</button>
                <c:if test="${err2 != null}">
                    <div class="mt-2">
                        <span style="color: red">
                            ${err2}
                        </span>
                    </div>
                </c:if>
            </div>

            <!--tần suất sử dụng thuốc theo tháng-->
            <div class="pt-2 pb-1">
                <button style="width: 40%;" type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#myModal3">TẦN SUẤT SỬ DỤNG THUỐC THEO THÁNG</button>
                <c:if test="${err3 != null}">
                    <div class="mt-2">
                        <span style="color: red">
                            ${err3}
                        </span>
                    </div>
                </c:if>
            </div>


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

    <div class="col-md-3 col-12">
        <div class="list-group">
            <a class="list-group-item list-group-item-action active">
                Tiện ích
            </a>
            <a href="/Web_QuanLyPhongMach/admins/adminIndex" class="list-group-item list-group-item-action">Trang Chủ</a>
            <a href="/Web_QuanLyPhongMach/admins/adminsManager" class="list-group-item list-group-item-action">Quản lý Admin</a>
            <a href="/Web_QuanLyPhongMach/admins/employeesManager" class="list-group-item list-group-item-action">Quản lý Nhân viên</a>
            <a href="/Web_QuanLyPhongMach/admins/medicinesManager" class="list-group-item list-group-item-action">Quản lý Thuốc</a>
            <a href="/Web_QuanLyPhongMach/admins/customersManager" class="list-group-item list-group-item-action">Quản lý Khách Hàng</a>
            <a href="/Web_QuanLyPhongMach/admins/reportsManager" class="list-group-item list-group-item-action">Quản lý Thống kê</a>
            <a href="/Web_QuanLyPhongMach/admins/onCallManager" class="list-group-item list-group-item-action">Quản lý Lịch trực</a>
        </div>

        <div class="list-group mt-2">
            <a class="list-group-item list-group-item-action active">
                Thống Kê
            </a>
            <a href="/Web_QuanLyPhongMach/admins/reportsManager" class="list-group-item list-group-item-action">Thống kê Doanh thu</a>
            <a href="/Web_QuanLyPhongMach/admins/reports2Manager" class="list-group-item list-group-item-action">Thống kê Số lượng Bệnh nhân</a>
            <a href="/Web_QuanLyPhongMach/admins/reports3Manager" class="list-group-item list-group-item-action">Thống kê Tần suất sử dụng Thuốc</a>
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


