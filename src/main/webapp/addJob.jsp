<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng tin tuyển dụng - TalentHub</title>
<link rel="stylesheet" href="scomponents/all_css.jsp">
<style>
body {
	background-color: #F5F5F5; /* Xám nhạt giống Duolingo */
	color: #333333; /* Màu chữ tối cho dễ đọc */
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	overflow-x: hidden;
}

.content {
	padding: 40px;
	margin: 0 auto;
	max-width: 1200px;
	text-align: center;
}

.job-form {
	background-color: #FFFFFF; /* Nền trắng Duolingo */
	padding: 40px;
	border-radius: 10px;
	margin-top: 15px;
	width: 500px;
	text-align: left;
}

.jobHeading {
	font-size: 2em;
	border-left: 5px solid #1CB0F6; /* Xanh dương Duolingo */
	padding: 10px;
	color: #FF4B4B; /* Cam Duolingo */
	letter-spacing: 2px;
	margin-bottom: 60px;
	font-weight: bold;
	padding-left: 10px;
}

.job-form label {
	display: block;
	margin-bottom: 15px;
	font-weight: bold;
	color: #333333; /* Màu chữ tối */
}

.job-form input[type="text"], .job-form textarea, .job-form select {
	width: 100%;
	padding: 10px;
	margin-bottom: 25px;
	background-color: #F0F0F0; /* Xám nhạt cho input */
	border: none;
	border-radius: 5px;
	color: #333333; /* Màu chữ tối */
	font-size: 1rem;
}

.job-form select {
	appearance: none;
	-webkit-appearance: none;
	background-color: #F0F0F0; /* Xám nhạt */
	padding: 15px;
}

.job-form button {
	padding: 15px 30px;
	background-color: #58CC02; /* Xanh lá cây Duolingo */
	border: none;
	border-radius: 5px;
	color: #FFFFFF;
	cursor: pointer;
	font-size: 1.1rem;
	transition: background-color 0.3s ease;
}

.job-form button:hover {
	background: linear-gradient(45deg, #FFC107, #1CB0F6); /* Gradient vàng và xanh dương */
}

footer {
	margin-top: 40px;
	position: relative;
	bottom: 0px;
}

.succTxt {
	text-align: center;
	margin-bottom: 40px;
	color: #1CB0F6; /* Xanh dương Duolingo */
	font-size: 1.3rem;
}

.errorTxt {
	text-align: center;
	margin-bottom: 40px;
	color: #FF4B4B; /* Cam Duolingo */
	font-size: 1.3rem;
}
</style>
</head>
<body>

	<c:if test="${userobj.role ne 'admin'}">
		<!-- ne not equals to -->
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>

	<%@include file="components/navbar.jsp"%>

	<div personally identifiable information removed class="content">
		<form class="job-form" action="add_job" method="post">

			<h1 class="jobHeading">Đăng tin tuyển dụng mới</h1>

			<c:if test="${not empty succMsg }">
				<p class="succTxt">${succMsg}</p>
				<c:remove var="succMsg" />
			</c:if>

			<c:if test="${not empty errMsg }">
				<p class="errorTxt">${errMsg}</p>
				<c:remove var="errorMsg" />
			</c:if>

			<label for="jobTitle">Tiêu đề:</label>
			<input type="text" id="jobTitle" name="title" required>
			
			<label for="location">Địa điểm:</label>
			<select id="location" name="location" required>
				<option value="">Chọn địa điểm</option>
				<option value="Hà Nội">Hà Nội</option>
				<option value="TP. Hồ Chí Minh">TP. Hồ Chí Minh</option>
				<option value="Đà Nẵng">Đà Nẵng</option>
			</select>
			
			<label for="category">Loại công việc:</label>
			<select id="category" name="category" required>
				<option value="">Chọn loại công việc</option>
				<option value="Kỹ thuật">Kỹ thuật</option>
				<option value="Bán hàng">Bán hàng</option>
				<option value="Tiếp thị">Tiếp thị</option>
			</select>
			
			<label for="status">Trạng thái:</label>
			<select id="status" name="status" required>
				<option value="">Chọn trạng thái</option>
				<option value="Đang tuyển">Đang tuyển</option>
				<option value="Ngừng tuyển">Ngừng tuyển</option>
			</select>
			
			<label for="jobDescription">Mô tả công việc:</label>
			<textarea id="description" name="description" rows="6" required></textarea>

			<button type="submit">Gửi</button>
		</form>
	</div>

	<%@ include file="components/footer.jsp"%>
</body>
</html>