<%-- 
    Document   : onCallManager
    Created on : Aug 21, 2022, 10:58:34 AM
    Author     : vinhp
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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


<h2 style="text-align: center; margin-top: 10px">QUẢN LÝ LỊCH TRỰC</h2>


<div class="row mt-4 mb-5">
    <div class="col-md-5 col-12 shadow">
        <div style="text-align: center;" ><h4>DANH SÁCH NHÂN VIÊN</h4></div>
        <div class="col-md-12 col-12 mt-2" style="overflow: auto; height: 500px; border-radius: 10px">
            <table class="table table-hover ">
                <tr class="table-primary">
                    <th>
                        <i onclick="load()" class="fas fa-redo-alt"></i>
                    </th>
                    <th>Họ và tên</th>
                    <th>Chức vụ</th>
                    <th>Chuyên khoa</th>
                    <th></th>
                </tr>
                <tbody id="myEmployeeOnCall">
                </tbody>
            </table>
        </div>
    </div>

    <div class="col-md-7 col-12 shadow">
        <div style="text-align: center;" ><h4>LỊCH PHÂN CÔNG</h4></div>
        <div class="col-md-12 col-12 mt-2" style="overflow: auto; height: 500px; border-radius: 10px">   
            <table class="table table-hover">
                <tr class="table-success">
                    <th>
                        <i onclick="load()" class="fas fa-redo-alt"></i>
                    </th>
                    <th>Tên nhân viên</th>
                    <th>Tên Admin</th>
                    <th>Ngày</th>
                    <th>Phòng Trực</th>
                    <th></th>
                </tr>
                <tbody id="myOnCall">
                </tbody>
            </table>
        </div>
    </div>
</div>


<!-- The Modal -->
<div class="modal" id="addOncall">
    <div class="modal-dialog modal-dialog-centered modal-fullscreen-sm-down">
        <div class="modal-content">

            <h6></h6>
            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title">Thêm Lịch Trực</h4>

                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>

            <!-- Modal body -->
            <div class="modal-body" id="addOncall">
                <div class = "col-md-12 col-xs-12">
                    <c:url value="/admins/onCallManager" var="action"></c:url>
                    <form:form id="myForm" method="post" action="${action}" modelAttribute="onCall" enctype="multipart/form-data">
                        <div class="input-row form-floating">
                            <form:input type="date" class="form-control" path="date" id="date2"/>
                            <label for="date">Ngày Trực:</label>
                            <!--Sinh lổi-->
                            <small></small>
                        </div>      

                        <div class="input-row form-floating">
                            <form:select path="departmentId" class="form-select" id="departmentId" name="departmentId">
                                <c:forEach items="${department}" var="p">
                                    <option value="${p.id}">${p.name}</option>
                                </c:forEach>
                            </form:select>
                            <label for="departmentId" class="form-label">Phòng ban</label>
                            <!--Sinh lổi-->
                            <small></small>
                        </div>

                        <div class="input-row form-floating">
                            <form:input type="hidden" class="form-control" path="adminId" id="adminId"/>
                            <label for="adminId"></label>
                            <!--Sinh lổi-->
                            <small></small>
                        </div>

                        <div class="input-row form-floating">
                            <form:input type="hidden" class="form-control" path="employeeId" id="employeeId"/>
                            <label for="employeeId"></label>
                            <!--Sinh lổi-->
                            <small></small>
                        </div>

                        <div class="form-floating mb-2" style="text-align: right;">
                            <input type="submit" value="Xác nhận" class="btn btn-danger" id="bt-submit"/>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment-with-locales.min.js"></script>        


<script src="<c:url value="/js/oncall.js"/>" ></script>

<script>document.getElementById('adminId').value = "${currentUser.id}";</script>

<script>
    <c:url value="/api/employeesOncall" var="u" />
    <c:url value="/api/onCallManager" var="ocl" />
    window.onload = function () {
        getEmployeeOncal("${u}"),
                getOnCall("${ocl}");
    }
</script>

<script>
        $('#addOncall').modal('show');
</script>
