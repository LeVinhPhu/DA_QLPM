<%--
    Document   : prescribeTheDrug
    Created on : Sep 6, 2022, 10:59:32 AM
    Author     : phamt
--%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<div class="row  mb-2 mt-3" style="">
    <div class="col-md-10 col-12">
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
</div>   

<h2 style="text-align: center; margin-top: 10px">RA TOA THUỐC</h2>

<!-- The Modal -->
<div class="modal" id="myModal">
    <div class="modal-dialog">
        <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title">Thêm Thuốc</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>

            <!-- Modal body -->
            <div class="modal-body">

                <c:url value="/employees/prescription/${medicalRecordID}" var="action" />
                <form:form method="post" action="${action}" modelAttribute="prescription" enctype="multipart/form-data">
                    <div class="form-floating input-row">
                        <form:select path="medicineId" class="form-select" id="medicineId" name="medicineId">
                            <c:forEach items="${medicine}" var="m">
                                <option value="${m[0]}">${m[1]}</option>
                            </c:forEach>
                        </form:select>
                        <label for="medicineId" class="form-label">Tên thuốc</label>
                    </div>

                    <div class="form-floating input-row">
                        <form:input type="number" path="quantity" class="form-control" id="quantity" placeholder="Nhap so luong" name="name" />
                        <label for="name">Số lượng</label>
                        <%--<form:errors path="name" element="div" cssClass="alert alert-danger" />--%>
                        <small></small>
                    </div>

                    <div class="form-floating input-row">
                        <form:input type="text" path="note" class="form-control" id="note" placeholder="Nhap ghi chu" name="name" />
                        <label for="name">Ghi chú</label>
                        <small></small>
                    </div>

                    <div class="form-floating mt-2">
                        <input type="number" style="display: none" name="addMedicine" value="1"/>
                        <input type="submit" value="Thêm thuốc" class="btn btn-primary mb-3 mt-3"/>
                    </div>

                </form:form>
            </div>
        </div>
    </div>
</div>


<!--DANH SÁCH THUỐC TRONG PHIẾU KHÁM-->
<div class="row mt-4 mb-4">
    <div class="col-md-6 col-12 shadow">
        <div class="mb-4" style="border: dashed 1px white">
            <div class="mt-3 mb-3" style="text-align: center; color: black"><h5>HỒ SƠ BỆNH ÁN</h5></div>
            <hr>
            <div class="mt-3 mb-3" style="padding-left: 10px">Mã phiếu khám: <b><i><c:out value="${info[0][0]}" /></i></b></div>
            <div class="mt-3 mb-3" style="padding-left: 10px">Tên bệnh nhân: <b><i><c:out value="${info[0][1]}" /> <c:out value="${info[0][2]}" /></i></b></div>
            <div class="mt-3 mb-3" style="padding-left: 10px">Triệu chứng bệnh: <b><i><c:out value="${info[0][3]}" /></i></b></div>
            <div class="mt-3 mb-3" style="padding-left: 10px">Kết luận: <b><i><c:out value="${info[0][4]}" /></i></b></div>
        </div>
        <hr>
    </div>
    <div class="col-md-6 col-12 shadow"  style="overflow: auto">
        <div class="mt-3 mb-3" style="text-align: center; color: black"><h5>TOA THUỐC</h5></div>
        <button type="button" class="btn" data-bs-toggle="modal" data-bs-target="#myModal">
            <i style="font-size: 20px; color: #0d6efd"class="far fa-plus-square"></i>
        </button>
        <div class="mb-3" style="float:right">
            <a class="btn btn-primary" href="/Web_QuanLyPhongMach/employees/prescription">Hoàn thành</a>
        </div>
        <c:url value="/employees/prescription" var="action" />
        <form method="post" action="${action}">
            <table class="table table-hover shadow">
                <tr class="table-primary">
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
        </form>
    </div>
</div>

<div class="row mb-1">
    <div class="col-md-8 col-12"">

    </div>
    <div class="col-md-4 col-12"">
        <c:url value="/employees/prescription/${medicalRecordID}" var="action" />
        <form action="${action}" class="d-flex">
            <input class="form-control me-2" type="text" name="kw" placeholder="Nhập tên thuốc...">
            <button type="submit" class="btn"><i class="fas fa-search"></i></button>
        </form>
    </div>
</div>
<div class="row mb-5 shadow">
    <div class="col-md-12 col-12" style="font-size: 14px">
        <div class="mt-2" style="height: 300px; overflow: auto">
            <table class="table table-hover">
                <tr class="table-success">
                    <th></th>
                    <th>Tên</th>
                    <th>Đơn vị </th>
                    <th>Đơn giá</th>
                    <th>Ghi chú</th>
                </tr>
                <tbody>
                    <c:forEach items="${medicines}" var="m">
                        <tr>
                            <td><img src="${m[0]}" style="width: 50px"></td>
                            <td>${m[1]}</td>
                            <td>${m[2]}</td>
                            <td><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${m[3]}" /></td>
                            <td>${m[4]}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>






