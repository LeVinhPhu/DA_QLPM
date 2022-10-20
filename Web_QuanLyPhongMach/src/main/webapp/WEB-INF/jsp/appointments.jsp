<%-- 
    Document   : appointments
    Created on : Aug 21, 2022, 11:13:05 AM
    Author     : vinhp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
        <a href="/Web_QuanLyPhongMach/customers/customersIndex" style="color: black; text-decoration: none">
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
        <a href="/Web_QuanLyPhongMach/customers/appointments" style="color: black; text-decoration: none">
            <div class="card bg-light shadow rounded-3" style="text-align: center; align-items: center;border: none">
                <div class="mt-3 mb-2">
                    <img class="card-img-top"
                         src="https://res.cloudinary.com/vinhphuvtv2/image/upload/v1662268251/Web_QLPM/Avatar/timetable_pzzi91.png"
                         alt="Card image"
                         style="width:50%">
                </div>
                <h6 class="card-title" style="font-size: 13px;font-weight: bold">Lịch Khám</h6>
            </div>
        </a>
    </div>

    <div class = "col-md-1 col-12 mt-2 mb-2" style="align-items: center;">
        <a href="/Web_QuanLyPhongMach/customers/customersIndex" style="color: black; text-decoration: none">
            <div class="card bg-light shadow rounded-3" style="text-align: center; align-items: center;border: none">
                <div class="mt-3 mb-2">
                    <img class="card-img-top"
                         src="https://res.cloudinary.com/vinhphuvtv2/image/upload/v1662268258/Web_QLPM/Avatar/checklist_cppfzb.png"
                         alt="Card image"
                         style="width:50%">
                </div>
                <h6 class="card-title" style="font-size: 13px;font-weight: bold">Tra Cứu</h6>
            </div>
        </a>
    </div>
</div>   


<h2 style="text-align: center; margin-top: 10px">DANH SÁCH ĐĂNG KÝ KHÁM BỆNH</h2>

    <div data-bs-toggle="modal" data-bs-target="#myModal" style="margin: 8px; width: 20%;"><i class="fas fa-plus"></i>  Đặt lịch</div>
    <!--đặt lịch khám-->
    <div class="modal" id="myModal">
        <div class="modal-dialog">
            <div class="modal-content">

                <!-- HEADER & NÚT TẮT -->
                <div class="modal-header" style="text-align:center">
                    <h4 class="modal-title" >Đặt lịch khám</h4>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                </div>

                <!-- BODY -->
                <div class="modal-body">
                    <div>
                        <c:url value="/customers/appointments" var="action" />
                        <form:form method="post" action="${action}" modelAttribute="setAppointments">
                            <div class="input-row form-floating">
                                <form:input path="date" class="form-control" type="date" id="date" name="date" />
                                <label for="date">Chọn ngày</label>
                                <small>Error</small>
                            </div> 
                            <div class="form-floating input-row">
                                <form:input type="text" path="time" class="form-control" id="time" placeholder="Nhap ngay" name="name" />
                                <label for="name">Nhập giờ</label>
                                <small>Error</small>
                            </div>
                            <div class="form-floating input-row">
                                <form:input type="text" path="note" class="form-control" id="note" placeholder="note" name="name" />
                                <label for="name">Ghi chú</label>
                                <small>Error</small>
                            </div>
                            <div class="mt-2" style="text-align: center">
                                <input id="btnSubmit" type="submit" value="Đặt lịch khám" class="btn btn-primary" />
                            </div>
                        </form:form>
                    </div>
                </div>

            </div>
        </div>
    </div>   

<%--</c:if>--%>



<!--DANH SÁCH PHIẾU ĐẶT CỦA 1 KHÁCH HÀNG-->
<div class="mb-5">
    <table class="table table-hover ">
        <tr>
            <th>
                <i onclick="load()" class="fas fa-redo-alt"></i>
            </th>
            <th>Mã phiếu đặt</th>
            <th>Ngày</th>
            <th>Giờ</th>
            <th>Ghi chú</th>
            <th>Trạng thái</th>
            <th></th>
        </tr>
        <tbody id="myAppointment">
        </tbody>
    </table>
</div>


<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment-with-locales.min.js"></script>        

<script src="<c:url value="/js/appointment.js" />"></script>
<script>
    <c:url value="/api/appointment" var="m" />
                    window.onload = function () {
                        getAppointment('${m}');
                    };
</script>
