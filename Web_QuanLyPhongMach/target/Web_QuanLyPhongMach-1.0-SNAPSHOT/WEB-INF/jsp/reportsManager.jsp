<%-- 
    Document   : reports
    Created on : Aug 21, 2022, 10:41:49 AM
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


<h2 style="text-align: center; margin-top: 10px">QUẢN LÝ DOANH THU</h2>


<div class="row mb-2 mt-2">
    <div data-bs-toggle="modal" data-bs-target="#myModal0" class="col-md-2 col-12"  style="text-align: center;">
        <div style="color: black; border: none" class="card bg-light shadow rounded-3"">
            <div class="mt-4 mb-3">
                <img class="card-img-top"
                     src="https://res.cloudinary.com/vinhphuvtv2/image/upload/v1662562119/Web_QLPM/Avatar/turnover_xyafsh.png"
                     alt="Card image"
                     style="width:40%">
            </div>
            <h6 class="card-title">Tổng Doanh Thu</h6>
        </div>
    </div>

    <div data-bs-toggle="modal" data-bs-target="#myModal" class="col-md-2 col-12"  style="text-align: center;">
        <div style="color: black; border: none" class="card bg-light shadow rounded-3"">
            <div class="mt-4 mb-3">
                <img class="card-img-top"
                     src="https://res.cloudinary.com/vinhphuvtv2/image/upload/v1662562119/Web_QLPM/Avatar/statistics_2_r18oez.png"
                     alt="Card image"
                     style="width:40%">
            </div>
            <h6 class="card-title">Doanh Thu Theo Năm</h6>
        </div>
    </div>
</div>

<div class="row mb-2 mt-2">
    <div data-bs-toggle="modal" data-bs-target="#myModal2" class="col-md-2 col-12"  style="text-align: center;">
        <div style="color: black; border: none" class="card bg-light shadow rounded-3"">
            <div class="mt-4 mb-3">
                <img class="card-img-top"
                     src="https://res.cloudinary.com/vinhphuvtv2/image/upload/v1662562259/Web_QLPM/Avatar/pie-graph_1_dwafob.png"
                     alt="Card image"
                     style="width:40%">
            </div>
            <h6 class="card-title">Doanh Thu Theo Quý</h6>
        </div>
        <c:if test="${err1 != null}">
            <div class="mt-1">
                <span style="color: red" class="fs-8">
                    ${err1}
                </span>
            </div>
        </c:if>
    </div>
    <div data-bs-toggle="modal" data-bs-target="#myModal3" class="col-md-2 col-12"  style="text-align: center;">
        <div style="color: black; border: none" class="card bg-light shadow rounded-3"">
            <div class="mt-4 mb-3">
                <img class="card-img-top"
                     src="https://res.cloudinary.com/vinhphuvtv2/image/upload/v1662562119/Web_QLPM/Avatar/diagram_phb81d.png"
                     alt="Card image"
                     style="width:40%">
            </div>
            <h6 class="card-title">Doanh Thu Theo Tháng</h6u>
        </div>
        <c:if test="${err2 != null}">
            <div class="mt-1">
                <span style="color: red" class="fs-8">
                    ${err2}
                </span>
            </div>
        </c:if>
    </div>
</div>



<div class="row mb-2 mt-2">
    <div class="col-md-12 col-12">
        <div style="text-align: center"class="">
            <!-- The Modal --> <!--TỔNG DOANH THU-->
            <div class="modal" id="myModal0">
                <div class="modal-dialog">
                    <div class="modal-content">

                        <!-- Modal Header -->
                        <div class="modal-header">
                            <h4 class="modal-title">TỔNG DOANH THU</h4> 
                            <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                        </div>

                        <!-- Modal body -->
                        <div class="modal-body">
                            <fmt:formatNumber type="number" value="${total[0]}" maxFractionDigits="3" /> VNĐ
                        </div>
                    </div>
                </div>
            </div>

            <!-- The Modal --> <!--Doanh thu theo năm-->
            <div class="modal" id="myModal">
                <div class="modal-dialog">
                    <div class="modal-content">

                        <!-- Modal Header -->
                        <div class="modal-header">
                            <h4 class="modal-title">DOANH THU THEO NĂM</h4> 
                            <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                        </div>

                        <!-- Modal body -->
                        <div class="modal-body">
                            <div class="row mt-2">  
                                <div class="">
                                    <table class="table">
                                        <tr>
                                            <th>Năm</th>
                                            <th>Doanh thu</th>
                                        </tr>

                                        <c:forEach items="${revenueStats}" var="r">
                                            <tr>
                                                <td>${r[0]}</td>
                                                <td><fmt:formatNumber type="number" value="${r[1]}" maxFractionDigits="3" /> VNĐ</td>
                                            </tr>
                                        </c:forEach>
                                        </td></tr>
                                    </table>
                                </div>
                                <div class="">
                                    <canvas id="myChart"></canvas>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


            <!-- The Modal --> <!--doanh thu theo quý-->
            <div class="modal" id="myModal2">
                <div class="modal-dialog">
                    <div class="modal-content">

                        <!-- Modal Header -->
                        <div class="modal-header">
                            <h4 class="modal-title">DOANH THU THEO QUÝ (NĂM <c:out value="${year}" />)</h4>
                            <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                        </div>

                        <!-- Modal body -->
                        <div class="modal-body">
                            <div class="mt-2">

                                <div class="">
                                    <table class="table">
                                        <tr>
                                            <th>Quý</th>
                                            <th>Doanh thu</th>
                                        </tr>
                                        <c:if test="${not empty revenueStatsByQuarter[0][0]}"> 
                                            <c:forEach items="${revenueStatsByQuarter}" var="r">
                                                <tr>
                                                    <td>${r[0]}</td>
                                                    <td><fmt:formatNumber type="number" value="${r[1]}" maxFractionDigits="3" /> VNĐ</td>
                                                </tr>
                                            </c:forEach>
                                        </c:if>

                                        <c:if test="${revenueStatsByQuarter[0][0] == null}">
                                            <td></td>
                                            <td>Chưa có doanh thu</td>
                                        </c:if>
                                    </table>
                                </div>
                                <div class="" >
                                    <c:url value="/admins/reportsManager" var="action" />
                                    <form action="${action}">
                                        <div class="mb-2 mt-2">
                                            <input type="number" class="form-control" placeholder="Nhập năm" name="year">
                                        </div>
                                        <button type="submit" class="btn btn-primary" style="margin-bottom: 5px; margin-right: 0" >Thống kê</button>
                                    </form>
                                    <div style="width: 60%; margin-left: 20%"  >
                                        <canvas id="myChart2"></canvas>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


            <!-- The Modal --> <!--doanh thu theo tháng-->
            <div class="modal" id="myModal3">
                <div class="modal-dialog">
                    <div class="modal-content">

                        <!-- Modal Header -->
                        <div class="modal-header">
                            <h4 class="modal-title">DOANH THU THEO THÁNG (NĂM <c:out value="${year2}" />)</h4>
                            <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                        </div>

                        <!-- Modal body -->
                        <div class="modal-body">
                            <div class="mt-2">
                                <div class="">
                                    <table class="table">
                                        <tr>
                                            <th>Tháng</th>
                                            <th>Doanh thu</th>
                                        </tr>

                                        <c:if test="${not empty revenueStatsByMonth[0][0]}"> 
                                            <c:forEach items="${revenueStatsByMonth}" var="r">
                                                <tr>
                                                    <td>${r[0]}</td>
                                                    <td><fmt:formatNumber type="number" value="${r[1]}" maxFractionDigits="3" /> VNĐ</td>
                                                </tr>
                                            </c:forEach>
                                        </c:if>

                                        <c:if test="${revenueStatsByMonth[0][0] == null}">
                                            <td></td>
                                            <td>Chưa có doanh thu</td>
                                        </c:if>

                                    </table>
                                </div>

                                <div class="">
                                    <c:url value="/admins/reportsManager" var="action" />
                                    <form action="${action}" method="POST">
                                        <div class="mb-2 mt-2">
                                            <input type="number" id="year2" class="form-control" placeholder="Nhập năm" name="year2">
                                        </div>
                                        <button type="submit "class="btn btn-primary" style="margin-bottom: 5px">Thống kê</button>

                                    </form>
                                    <canvas id="myChart3"></canvas>
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

    <c:forEach items="${revenueStats}" var="c">
        data.push(${c[1]});
        labels.push('${c[0]}');
    </c:forEach>

    <c:forEach items="${revenueStatsByQuarter}" var="r">
        data2.push(${r[1]});
        labels2.push('${r[0]}');
    </c:forEach>
    <c:forEach items="${revenueStatsByMonth}" var="r">
        data3.push(${r[1]});
        labels3.push('${r[0]}');
    </c:forEach>

        revenueStats(labels, data);
        revenueStatsByQuarter(labels2, data2);
        revenueStatsByMonth(labels3, data3);
    }
</script>


