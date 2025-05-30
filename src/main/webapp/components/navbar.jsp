<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>

<%@include file="all_css.jsp"%>

<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
 /

a {
	font-style: none;
	color: inherit;
	text-decoration: none;
}

body {
	background-color: #F5F5F5; /* Xám nhạt giống Duolingo */
	color: #333333; /* Màu chữ tối cho dễ đọc */
	font-family: 'Open Sans', Arial, sans-serif;
	display: flex;
	align-items: center;
	flex-direction: column;
}

/* Navbar styles */
.navbar {
	background-color: rgba(255, 255, 255, 0.9); /* Nền trắng mờ */
	backdrop-filter: blur(10px);
	padding: 15px 0;
	transition: background-color 0.3s ease;
	width: 95vw;
	border-radius: 20px;
	margin: 10px 0px;
}

.container-nav {
	display: flex;
	justify-content: space-between;
	align-items: center;
	padding: 0 30px;
}

.logo-job {
	color: #58CC02; /* Xanh lá cây Duolingo */
	font-size: 28px;
	text-decoration: none;
	font-weight: bold;
}

.nav-links {
	list-style: none;
	display: flex;
	gap: 30px;
}

.nav-links a {
	color: #1CB0F6; /* Xanh dương Duolingo */
	text-decoration: none;
	font-size: 20px;
	transition: color 0.3s ease;
	font-weight: 600;
}

.nav-links a:hover {
	color: #FFC107; /* Vàng Duolingo */
}

.user-links {
	display: flex;
	gap: 15px;
}

.login, .registerBtn {
	color: #58CC02; /* Xanh lá cây Duolingo */
	text-decoration: none;
	border: 1px solid #58CC02;
	padding: 8px 15px;
	border-radius: 5px;
	font-size: 16px;
	transition: color 0.3s ease, border-color 0.3s ease, background-color 0.3s ease;
}

.login:hover, .registerBtn:hover {
	color: #FFFFFF;
	background-color: #58CC02; /* Xanh lá cây khi hover */
}

/* Responsive styles */
@media ( max-width : 768px) {
	.container {
		flex-direction: column;
	}
	.nav-links {
		margin-top: 10px;
	}
	.user-links {
		margin-top: 10px;
	}
}

/* modal css */
.modal_container {
	position: fixed;
	top: 30%;
	left: 50%;
	display: flex;
	flex-direction: column;
	justify-content: space-between;
	transform: translate(-50%, -50%);
	width: 550px;
	height: 300px;
	padding: 50px;
	box-shadow: 0 5px 30px rgba(0, 0, 0, 0.1);
	background: #FFFFFF; /* Nền trắng Duolingo */
	visibility: hidden;
	opacity: 0;
	transition: 0.5s;
	color: #333333; /* Màu chữ tối */
	border-radius: 20px;
}

.modal_container.active {
	top: 50%;
	visibility: visible;
	opacity: 1;
	transition: 0.5s;
	z-index: 5;
}

.modal_container h1 {
	color: #FF4B4B; /* Cam Duolingo */
	margin-bottom: 20px;
}

.profile-fields {
	margin-bottom: 15px;
}

.profile-fields label {
	display: inline-block;
	width: 120px;
	font-weight: bold;
}

.profile-fields span {
	display: inline-block;
	color: #555555; /* Xám đậm cho dễ đọc */
}

.modal_container .btn {
	display: inline;
	padding: 10px 20px;
	font-weight: 500;
	border: 1px solid #1CB0F6; /* Xanh dương Duolingo */
	border-radius: 5px;
	margin-top: 20px;
	cursor: pointer;
	color: #1CB0F6;
}

.modal_container .btn:hover {
	background-color: #1CB0F6; /* Xanh dương khi hover */
	color: #FFFFFF;
}
</style>

<nav class="navbar">
	<div class="container-nav">
		<a href="#" class="logo-job">TalentHub</a>
		<ul class="nav-links">
			<c:choose>
				<c:when test="${userobj.role eq 'admin'}">
					<li><a href="./admin.jsp"><i class="fas fa-home"></i> Trang chủ</a></li>
					<li><a href="./addJob.jsp"><i class="fas fa-file-alt"></i> Đăng việc</a></li>
					<li><a href="./viewJob.jsp"><i class="fas fa-eye"></i> Xem việc</a></li>
				</c:when>
				<c:when test="${userobj.role eq 'user'}">
					<li><a href="./index.jsp"><i class="fas fa-home"></i> Trang chủ</a></li>
					<li><a href="./viewJob_user.jsp"><i class="fas fa-eye"></i> Xem việc</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="./index.jsp"><i class="fas fa-home"></i> Trang chủ</a></li>
				</c:otherwise>
			</c:choose>
		</ul>

		<div class="user-links">
			<c:if test="${userobj.role eq 'admin'}">
				<a href="#" class="login"> Quản trị viên </a>
				<a href="logout" class="registerBtn"> Đăng xuất </a>
			</c:if>
			<c:if test="${userobj.role eq 'user'}">
				<a href="#" class="modal-btn login">
					<div id="myBtn" onclick="toggle()">${userobj.name }</div>
				</a>
				<a href="logout" class="registerBtn"> Đăng xuất </a>
			</c:if>
			<c:if test="${empty userobj.role}">
				<a href="./login.jsp" class="login"> Đăng nhập </a>
				<a href="./signup.jsp" class="registerBtn"> Đăng ký </a>
			</c:if>
		</div>
	</div>
</nav>

<div class="modal_container">
	<h1>Hồ sơ của bạn</h1>
	<div>
		<div class="profile-fields">
			<label>Tên:</label> <span> ${userobj.name } </span>
		</div>
		<div class="profile-fields">
			<label>Trình độ:</label> <span>${userobj.qualification }</span>
		</div>
		<div class="profile-fields">
			<label>E-mail:</label> <span> ${userobj.email } </span>
		</div>
	</div>
	<div class="modal_but">
		<div class="btn" type="submit" onclick="toggle()">Đóng</div>
		<a href="./edit_profile.jsp">
			<div class="btn">Chỉnh sửa</div>
		</a>
	</div>
</div>

<script type="text/javascript" src="components/modal.js"></script>