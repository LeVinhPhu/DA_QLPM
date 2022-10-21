<%-- 
    Document   : medicinesManager
    Created on : Aug 21, 2022, 10:35:40 AM
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


<h2 style="text-align: center; margin-top: 10px">QUẢN LÝ THUỐC</h2>

<!-- THÊM THUỐC -->
<div class="modal" id="myModal">
    <div class="modal-dialog">
        <div class="modal-content">

            <!-- HEADER & NÚT TẮT -->
            <div class="modal-header" style="text-align:center">
                <h4 class="modal-title" >Thêm thuốc</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>

            <!-- BODY -->
            <div class="modal-body">
                <div>
                    <c:url value="/admins/medicinesManager" var="action" />
                    <form:form id="myForm" method="post" action="${action}" modelAttribute="medicineUP" enctype="multipart/form-data">

                        <div class="form-floating input-row">
                            <form:input type="text" path="name" class="form-control" id="name" placeholder="Nhap ten" name="name" />
                            <label for="name">Tên thuốc <span style="color: red">*</span></label>
                            <%--<form:errors path="name" element="div" cssClass="alert alert-danger" />--%>
                            <small></small>
                        </div>

                        <div class="form-floating input-row">
                            <form:select path="unitId" class="form-select" id="unitId" name="unitId">
                                <c:forEach items="${units}" var="u">
                                    <option value="${u.id}">${u.name}</option>
                                </c:forEach>
                            </form:select>
                            <label for="unitId" class="form-label">Đơn vị</label>
                        </div>

                        <div class="form-floating input-row">
                            <form:input type="number" path="unitPrice" class="form-control" id="unitPrice" placeholder="Nhap gia" name="unitPrice" />
                            <label for="unitPrice">Đơn giá <span style="color: red">*</span></label>
                            <%--<form:errors path="unitPrice" element="div" cssClass="alert alert-danger" />--%>
                            <small></small>
                        </div>

                        <div class="form-floating input-row">
                            <form:input type="number" path="quantity" class="form-control" id="quantity" placeholder="Nhap so luong" name="quantity" />
                            <label for="quantity">Số lượng <span style="color: red">*</span></label>
                            <small></small>
                        </div>

                        <div class="form-floating input-row">
                            <form:select path="supplierId" class="form-select" id="supplierId" name="supplierId">
<!--                                <option disabled="disabled" selected="selected" value=""}>Chọn nhà cung cấp</option>-->
                                <c:forEach items="${suppliers}" var="s">
                                    <option value="${s.id}">${s.companyName}</option>
                                </c:forEach>
                            </form:select>
                            <label for="supplierId" class="form-label">Nhà cung cấp</label>
                        </div>

                        <div class="input-row">
                            <label style="margin-left: 4.5%;" class="ml-2"for="file">Chọn ảnh</label>
                            <form:input type="file" path="file" name="file" id="file" class="form-control" />
                        </div>

                        <div class="form-floating input-row">
                            <form:input type="text" path="note" class="form-control" id="note" placeholder="Ghi chu" name="note" />
                            <label for="note">Ghi chú</label>
                        </div>

                        <div class="form-floating mt-2" style="text-align: right">
                            <input type="submit" id="btnAdd" value="Thêm thuốc" class="btn mb-3 mt-3" style="background-color: #d1e7dd" />
                        </div>

                    </form:form>    
                </div>
            </div>

        </div>
    </div>
</div>   

<div class="row mt-4 mb-4">
    <div class="col-md-9 col-12"><div data-bs-toggle="modal" data-bs-target="#myModal" style="margin: 8px; width: 20%"><i class="fas fa-plus"></i>  Thêm thuốc</div></div>
    <div class="col-md-3 col-12">
        <c:url value="/admins/medicinesManager" var="action" />
        <form action="${action}" class="d-flex">
            <input class="form-control me-2" type="text" name="kw" placeholder="Nhập tên thuốc...">
            <button type="submit" class="btn"><i class="fas fa-search"></i></button>
        </form>
    </div>
</div>




<!--DANH SÁCH THUỐC-->
<div class="row mt-3 mb-3">
    <div class="col-md-12 col-12 shadow" style="overflow: auto; height: 500px; border-radius: 10px">

        <table class="table table-hover">
            <tr class="table-success">
                <th>
                    <i onclick="load()" class="fas fa-redo-alt"></i>
                </th>
                <th>Tên thuốc</th>
                <th>Số lượng</th>
                <th>Đơn giá</th>
                <th>Đơn vị</th>
                <th></th>
                <th></th>
                <th></th>
            </tr>
            <tbody id="myMedicine">
            </tbody>
        </table>
    </div>
</div>


<!--CHI TIẾT THUỐC-->
<!-- The Modal Detail -->
<div class="modal" id="detailModal">
    <div class="modal-dialog modal-dialog-centered modal-fullscreen-sm-down">
        <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header">
                <h5 class="modal-title">Chi tiết thuốc</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>

            <!-- Modal body -->
            <div class="modal-body" id="detailMedicine">

            </div>
            <!-- Modal footer -->
        </div>
    </div>
</div>





<!--sử dụng api lấy danh sách thuốc-->
<script src="<c:url value="/js/medicine.js" />"></script>
<script>
    <c:url value="/api/medicines" var="m" />
                        window.onload = function () {
                            getMedicines('${m}');
                        };
</script>


<script>
    function load() {
    <c:url value="/api/medicines" var="m" />
        getMedicines('${m}');
    }
</script>