<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-light bg-light sticky-top">
    <!-- Container wrapper -->
    <div class="container-fluid">

        <!-- Button = -->
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>

        <!-- Cấu Hình Logo -->
        <a class="navbar-brand mt-2 mt-lg-0" href="#">
            <img
                src="https://res.cloudinary.com/vinhphuvtv2/image/upload/v1660815574/Web_QLPM/Logo/Logo5_cuvqlu.png"
                height="40"
                alt="MDB Logo"
                loading="lazy"
                />
        </a>

        <!-- Thu lại khi màn hình nhỏ -->
        <div class="collapse navbar-collapse" id="collapsibleNavbar">
            <!-- Link Liên Kết -->
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" href="">Giới thiệu</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="">Dịch vụ</a>

                <li class="nav-item">
                    <a class="nav-link" href="">Tin tức</a>
                </li>
            </ul>
        </div>

        <!-- Thông Báo - Tin Nhắn - Thông Tin Nhân Viên -->
        <div class="d-flex align-items-center">

            <a class="text-reset" href="#">
                <i class="fas fa-bell me-5"></i>
            </a>

            <a class="text-reset" href="#">
                <i class="fas fa-comment me-5"></i>
            </a>

            <!-- Avatar -->

            <div class="dropdown me-2">

                <div type="button" style="border: none" class="bg-dark btn btn-primary dropdown-toggle" 
                     data-bs-toggle="dropdown">

                    <c:if test="${currentUser != null}">
                        <a style="text-decoration:none; color:  #999999; margin-right: 5px">${currentUser.firstName} ${currentUser.lastName} </a>
                        <img
                            src="${currentUser.image}"
                            class="rounded-circle"
                            height="30"
                            width="30"
                            alt="Black and White Portrait of a Man"
                            loading="lazy"
                            />
                    </c:if>
                    <c:if test="${currentUser == null}">
                        <a style="text-decoration:none; color:  #999999;" href="<c:url value="/login" />">Username</a>

                        <img
                            src="https://res.cloudinary.com/vinhphuvtv2/image/upload/v1662139496/Web_QLPM/Avatar/user_2_sbwijr.png"
                            class="rounded-circle"
                            height="30"
                            width="30"
                            alt="Black and White Portrait of a Man"
                            loading="lazy"
                            />
                    </c:if>
                </div>

                <ul class="dropdown-menu dropdown-menu-end">
                    <li>
                        <c:if test="${currentUser == null}">
                            <a class="dropdown-item" href="<c:url value="/login" />">Đăng ký</a>
                        </c:if>
                    </li>
                    <li>
                        <c:if test="${currentUser.userRole.equals('ROLE_CUSTOMER')}">
                            <a id = "role" class="dropdown-item" href="/Web_QuanLyPhongMach/customers/customersProfile">Thông tin cá nhân</a>
                        </c:if>
                    </li>
                                        <li>
                        <c:if test="${currentUser.userRole.equals('ROLE_CUSTOMER')}">
                            <a id = "role" class="dropdown-item" href="/Web_QuanLyPhongMach/customers/changePasswordCustomer">Đổi mật khẩu</a>
                        </c:if>
                    </li>
                    <li>
                        <c:if test="${currentUser != null}">
                            <a class="dropdown-item" href="<c:url value="/logout" />">Đăng xuất</a>
                        </c:if>
                    </li>
                    <li>
                        <a class="dropdown-item" href="#">Trợ giúp</a>
                    </li>
                </ul>
            </div>
        </div>

    </div>
</nav>

