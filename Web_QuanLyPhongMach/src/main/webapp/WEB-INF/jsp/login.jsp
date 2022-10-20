<%-- 
    Document   : login
    Created on : Aug 25, 2022, 3:25:33 PM
    Author     : phamt
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<div class="row m-5">

    <div class="col-md-7 col-12 ">
        <div class="">
            <h2 style="font-family: fantasy;">P&Q CLINCI</h2>
            <h6 style="font-family: courier">Welcome ..........</h6>
        </div>
    </div>

    <div class="col-md-1 col-12"></div>

    <div class="col-md-4 col-12 bg-light shadow rounded-3">

        <div class="row mt-2 mb-2" style="">
            <div class="col-md-8 col-8"><h2 style="font-family: Helvetica">Login</h2></div>
            <div class="col-md-4 col-4" style="text-align: right;">
                <a class="fas fa-home" href="/Web_QuanLyPhongMach/" 
                   style="text-decoration: none; color: black;margin-right:10px; margin-top: 15px"></a>
            </div>
        </div>
        <div class="mb-3">
            <c:url value="/login" var="action"></c:url>
            <form method="post" action="${action}">
                <div class="input-row form-floating">
                    <input type="text" class="form-control" path="username" id="username" name="username" placeholder="phoneNumber" />
                    <label for="address">Tài khoản</label>
                    <c:if test="${param.erorr != null}">
                        <span style="color:red" class="fs-8">Tài khoản hoặc mật khẩu không chính xác</span>
                    </c:if>
                </div>
                <div class="input-row form-floating">
                    <input type="password" class="form-control" path="password" id="password" name="password" placeholder="password" />
                    <label for="address">Mật khẩu</label>
                </div>
                <hr>

                <div class="form-floating"  style="text-align: center">
                    <input type="submit" value="Đăng nhập" class="btn btn-primary" id="bt-submit"/>
                </div>
                
                <div class="form-floating" style="text-align: center">
                    <span style="font-size: 12px">Bạn chưa có tài khoản? <a href="/Web_QuanLyPhongMach/register" style="text-decoration: none">Đăng ký</a></span>
                </div>
            </form>
        </div>
    </div>
</div>
</div>


