<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@page import="com.DB.*"%>
<%@page import="com.dao.*"%>
<%@page import="com.entity.*"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Xem Việc Làm - Cổng Việc Làm</title>
<link rel="stylesheet" href="components/all_css.jsp">
<style>
body {
	background-color: #e6f3e6; /* Tông xanh lá nhạt Duolingo */
	color: #333; /* Chữ tối cho dễ đọc */
	margin: 0;
	padding: 0;
	overflow-x: hidden;
	min-height: 120vh;
}

.content {
	padding: 30px;
	margin: 0 auto;
	width: 80vw;
	min-height: 85vh;
}

.headingText {
	margin-bottom: 15px;
	margin-top: 0;
	color: #f7c948; /* Vàng tươi Duolingo */
	text-align: center;
}

.job-details {
	background-color: #ffffff; /* Nền trắng sạch sẽ */
	padding: 40px;
	border-radius: 10px;
	box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1); /* Bóng nhẹ */
	margin-bottom: 30px;
}

.job-field {
	margin-bottom: 15px;
}

.job-field label {
	display: inline-block;
	width: 120px;
	font-weight: bold;
	color: #1cb0f6; /* Xanh dương Duolingo */
}

.job-field span {
	display: inline-block;
	color: #555; /* Màu chữ xám nhẹ */
}

.jobTitle {
	color: #f7c948; /* Vàng Duolingo cho tiêu đề */
}

.buttons {
	margin-top: 20px;
}

.buttons button {
	padding: 10px 20px;
	margin-right: 10px;
	background-color: #58cc02; /* Xanh lá cây Duolingo */
	border: none;
	border-radius: 5px;
	color: #fff;
	cursor: pointer;
	transition: background-color 0.3s ease;
	font-size: 16px;
}

.buttons .edit:hover {
	background-color: #1cb0f6; /* Xanh dương khi hover */
}

.buttons .delete:hover {
	background-color: #ff4b4b; /* Đỏ tươi khi hover */
}

footer {
	position: relative;
	bottom: 0px;
}
</style>
</head>
<body>

	<%@include file="components/navbar.jsp"%>

	<div class="content">
		<h1 class="headingText">Chi Tiết Việc Làm</h1>

		<%
		JobDAO dao = new JobDAO(DBConnect.getConn());
		List<Jobs> list = dao.getAllJobs();
		for (Jobs j : list) {
		%>
		<div class="job-details">
			<div class="jobTitle job-field">
				<label>Tiêu Đề:</label> <span> <%=j.getTitle()%>
				</span>
			</div>
			<div class="job-field">
				<label>Địa Điểm:</label> <span> <%=j.getLocation()%>
				</span>
			</div>
			<div class="job-field">
				<label>Danh Mục:</label> <span> <%=j.getCategory()%>
				</span>
			</div>
			<div class="job-field">
				<label>Trạng Thái:</label> <span> <%=j.getStatus()%>
				</span>
			</div>
			<div class="job-field">
				<label>Mô Tả:</label> <span> <%=j.getDescription()%>
				</span>
			</div>
			<div class="job-field">
				<label>Ngày Đăng:</label> <span> <%=j.getPdate()%>
				</span>
			</div>
			<div class="buttons">
				<a href="edit.jsp?id=<%=j.getId()%>"><button class="edit">Chỉnh Sửa</button></a>
				<a href="delete?id=<%=j.getId()%>">
					<button class="delete">Xóa</button>
				</a>
			</div>
		</div>
		<%
		}
		%>
	</div>

	<%@ include file="components/footer.jsp"%>
</body>
</html>