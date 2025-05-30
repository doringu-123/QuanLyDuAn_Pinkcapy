<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@page import="com.DB.*"%>
<%@page import="com.dao.*"%>
<%@page import="com.entity.*"%>
<%@page import="java.sql.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ - TalentHub</title>
<style>
body {
	background-color: #e6f3e6; /* Xanh lá nhạt Duolingo */
	color: #333; /* Chữ tối cho dễ đọc */
	margin: 0;
	padding: 0;
	overflow-x: hidden;
	min-height: 120vh;
}

.index-main {
	display: block;
	min-height: 120vh;
}

.background-image {
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	min-height: 100vh;
	background-color: #ffffff; /* Nền trắng sạch sẽ */
	opacity: 0.9;
	z-index: -1;
	display: block;
}

.hero-section {
	text-align: center;
	margin: 40px auto;
	padding: 40px;
	width: 80%;
	background-color: #ffffff; /* Nền trắng như job-details */
	border-radius: 10px;
	box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1); /* Bóng nhẹ giống job-details */
}

.hero-section h1 {
	font-family: 'Asap', cursive; /* Font vui tươi Duolingo */
	font-size: 2.8rem;
	color: #f7c948; /* Vàng Duolingo như jobTitle */
	margin-bottom: 15px;
}

.hero-section p {
	font-size: 1.2rem;
	color: #555; /* Xám nhẹ như job-field span */
	margin-bottom: 20px;
}

.hero-button {
	padding: 10px 20px;
	background-color: #58cc02; /* Xanh lá Duolingo như content button */
	border: none;
	border-radius: 5px;
	color: #fff;
	cursor: pointer;
	font-size: 1.1rem;
	transition: background-color 0.3s ease;
}

.hero-button:hover {
	background: linear-gradient(45deg, greenyellow, dodgerblue); /* Hiệu ứng hover giống content button */
}

.categories-container {
	display: flex;
	justify-content: center;
	gap: 20px;
	margin: 40px auto;
	width: 80%;
}

.category-card {
	background-color: #ffffff; /* Nền trắng như job-details */
	padding: 40px;
	border-radius: 10px;
	box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1); /* Bóng giống job-details */
	width: 200px;
	text-align: center;
	transition: transform 0.3s ease, box-shadow 0.3s ease;
}

.category-card:hover {
	transform: translateY(-5px); /* Nâng lên khi hover */
	box-shadow: 0px 6px 12px rgba(0, 0, 0, 0.2);
}

.category-card h3 {
	font-family: 'Asap', cursive;
	font-size: 1.4rem;
	color: #1cb0f6; /* Xanh dương Duolingo như job-form label */
	margin-bottom: 10px;
}

.category-card p {
	font-size: 1rem;
	color: #d4d4d4; /* Xám nhẹ như job-field span */
}

/* Hiệu ứng hoạt hình */
@keyframes slideIn {
	from {
		opacity: 0;
		transform: translateY(20px);
	}
	to {
		opacity: 1;
		transform: translateY(0);
	}
}
</style>
</head>

<body>

	<%@include file="components/navbar.jsp"%>
	<div class="index-main">

		<div class="background-image">
		</div>

		<div class="hero-section">
			<h1>Chào mừng đến với TalentHub!</h1>
			<p>Tìm kiếm công việc mơ ước của bạn tại Hà Nội, Hồ Chí Minh, Đà Nẵng và hơn thế nữa!</p>
			<a href="searchJobView.jsp"><button class="hero-button">Khám Phá Việc Làm</button></a>
		</div>

		<div class="categories-container">
			<div class="category-card">
				<h3>Kỹ Thuật</h3>
				<p>Khám phá các cơ hội lập trình, kỹ sư, và công nghệ!</p>
			</div>
			<div class="category-card">
				<h3>Bán Hàng</h3>
				<p>Tham gia đội ngũ bán hàng năng động và chinh phục mục tiêu!</p>
			</div>
			<div class="category-card">
				<h3>Tiếp Thị</h3>
				<p>Sáng tạo chiến lược và đưa thương hiệu vươn xa!</p>
			</div>
		</div>

	</div>
	<%@ include file="components/footer.jsp"%>
</body>
</html>