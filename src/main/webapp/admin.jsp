<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản trị viên - TalentHub</title>
<%@include file="components/all_css.jsp"%>
</head>

<style>
body {
	background-color: #F5F5F5; /* Xám nhạt giống Duolingo */
	color: #333333; /* Màu chữ tối cho dễ đọc */
	overflow-x: hidden;
}

.index-main {
	display: flex;
	flex-direction: column;
	min-height: 120vh;
	align-items: center;
}

.background-image {
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	min-height: 100vh;
	background-color: #FFFFFF; /* Nền trắng Duolingo */
	opacity: 0.9;
	z-index: -1;
	display: block;
}

.welcome-text {
	font-family: 'Asap', cursive; /* Font vui tươi giống Duolingo */
	text-align: center;
	margin-top: 25px;
	font-size: 38px;
	padding: 15px;
	border-radius: 20px;
	color: #FF4B4B; /* Cam Duolingo */
	box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
	letter-spacing: 2px;
	background-color: rgba(255, 255, 255, 0.9); /* Nền trắng mờ */
	backdrop-filter: blur(10px);
}

.hero-section {
	text-align: center;
	margin: 20px 0;
	padding: 20px;
	width: 80%;
}

.hero-section h2 {
	font-family: 'Asap', cursive;
	font-size: 1.8rem;
	color: #1cb0f6; /* Xanh dương Duolingo */
	margin-bottom: 15px;
}

.hero-section p {
	font-size: 1.2rem;
	color: #555;
	margin-bottom: 20px;
}

.hero-button {
	padding: 12px 30px;
	background-color: #58cc02; /* Xanh lá Duolingo */
	color: #fff;
	border: none;
	border-radius: 25px;
	font-size: 1.1rem;
	cursor: pointer;
	transition: background-color 0.3s ease, transform 0.2s ease;
}

.hero-button:hover {
	background-color: #1cb0f6; /* Xanh dương khi hover */
	transform: scale(1.05);
}

.stats-container {
	display: flex;
	justify-content: center;
	gap: 20px;
	margin: 30px 0;
	width: 80%;
}

.stat-card {
	background-color: #ffffff;
	padding: 20px;
	border-radius: 10px;
	box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
	width: 200px;
	text-align: center;
	transition: transform 0.3s ease;
}

.stat-card:hover {
	transform: translateY(-5px);
}

.stat-card h3 {
	font-family: 'Asap', cursive;
	font-size: 1.4rem;
	color: #f7c948; /* Vàng Duolingo */
	margin-bottom: 10px;
}

.stat-card p {
	font-size: 1.6rem;
	color: #333;
	font-weight: bold;
}
</style>

<body>

	<c:if test="${userobj.role ne 'admin' }">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>

	<%@include file="components/navbar.jsp"%>
	<div class="index-main">

		<div class="background-image">
			<!-- Loại bỏ quote-container vì không dùng hình ảnh -->
		</div>
		<h1 class="welcome-text">Chào mừng Quản trị viên!</h1>

		<div class="hero-section">
			<h2>Quản lý TalentHub dễ dàng!</h2>
			<p>Khám phá các công cụ để thêm, chỉnh sửa hoặc xóa việc làm, quản lý người dùng, và hơn thế nữa!</p>
			<a href="add_job.jsp"><button class="hero-button">Thêm Việc Làm Mới</button></a>
		</div>

		<div class="stats-container">
			<div class="stat-card">
				<h3>Số Việc Làm</h3>
				<p>150</p> <!-- Giả lập số liệu -->
			</div>
			<div class="stat-card">
				<h3>Số Người Dùng</h3>
				<p>500</p> <!-- Giả lập số liệu -->
			</div>
			<div class="stat-card">
				<h3>Đơn Ứng Tuyển</h3>
				<p>320</p> <!-- Giả lập số liệu -->
			</div>
		</div>

	</div>
	<%@ include file="components/footer.jsp"%>
</body>
</html>