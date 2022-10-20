<%-- 
    Document   : prescription
    Created on : Aug 21, 2022, 10:56:47 AM
    Author     : vinhp
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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


<h2 style="text-align: center; margin-top: 10px">DANH SÁCH BỆNH NHÂN CẦN KÊ TOA THUỐC</h2>

<!--DANH SÁCH PHIẾU KHÁM BỆNH-->
<div class="row"> 
    <div class="col-md-12 col-12" style="overflow: auto; height: 500px; border-radius: 10px">
        <c:url value="/employees/prescription" var="action" />
        <form method="post" action="${action}">
            <table class="table table-hover">
                <tr class="table-primary">
                    <th>Mã phiếu khám</th>
                    <th>Tên khách hàng</th>
                    <th></th>
                </tr>
                <tbody id="myMedicalRecord">
                    <c:forEach items="${medicalRecord2}" var="d">
                        <tr>
                            <td>${d[0]}</td>
                            <td>${d[1]} ${d[2]}</td>
                            <td style="text-align: right"><a class="btn btn-primary" href="/Web_QuanLyPhongMach/employees/prescription/${d[0]}">Kê toa</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </form>
    </div>

    <div class="col-md-6 col-12"></div>
</div>
