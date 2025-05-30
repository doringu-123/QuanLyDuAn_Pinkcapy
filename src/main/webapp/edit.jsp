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
<title>Chỉnh sửa tin tuyển dụng - TalentHub</title>
<link rel="stylesheet" href="scomponents/all_css.jsp">
<style>
body {
	background-color: #F5F5F5;
	color: #333333;
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
	background-color: #FFFFFF;
	padding: 40px;
	border-radius: 10px;
	margin-top: 15px;
	width: 500px;
	text-align: left;
}

.jobHeading {
	font-size: 2em;
	border-left: 5px solid #1CB0F6;
	padding: 10px;
	color: #FF4B4B;
	letter-spacing: 2px;
	margin-bottom: 60px;
	font-weight: bold;
	padding-left: 10px;
}

.job-form label {
	display: block;
	margin-bottom: 15px;
	font-weight: bold;
	color: #333333;
}

.job-form input[type="text"], .job-form textarea, .job-form select {
	width: 100%;
	padding: 10px;
	margin-bottom: 25px;
	background-color: #F0F0F0;
	border: none;
	border-radius: 5px;
	color: #333333;
	font-size: 1rem;
}

.job-form input[type="text"]::placeholder, .job-form textarea::placeholder {
	color: #888888;
}

.job-form select {
	appearance: none;
	-webkit-appearance: none;
	background-color: #F0F0F0;
	padding: 15px;
}

.job-form button {
	padding: 15px 30px;
	background-color: #58CC02;
	border: none;
	border-radius: 5px;
	color: #FFFFFF;
	cursor: pointer;
	font-size: 1.1rem;
	transition: background-color 0.3s ease;
}

.job-form button:hover {
	background: linear-gradient(45deg, #FFC107, #1CB0F6);
}

.footer {
	margin-top: 40px;
	position: relative;
}
</style>
</head>
<body>

	<c:if test="${userobj.role ne 'admin' }">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>

	<%@include file="components/navbar.jsp"%>

	<div class="content">
		<form class="job-form" action="update" method="post">

			<%
			int id = Integer.parseInt(request.getParameter("id"));
			JobDAO dao = new JobDAO(DBConnect.getConn());
			Jobs j = dao.getJobById(id);
			%>

			<input type="hidden" name="id" value="<%=j.getId()%>">

			<h1 class="jobHeading">Chỉnh sửa tin tuyển dụng</h1>

			<label for="jobTitle">Tiêu đề:</label>
			<input type="text" id="jobTitle" name="title" value="<%=j.getTitle()%>" required>

			<label for="location">Địa điểm:</label>
			<select id="location" name="location" required>
				<option value="<%=j.getLocation()%>"><%=j.getLocation()%></option>
				<option value="Hà Nội">Hà Nội</option>
				<option value="TP. Hồ Chí Minh">TP. Hồ Chí Minh</option>
				<option value="Đà Nẵng">Đà Nẵng</option>
			</select>

			<label for="category">Loại công việc:</label>
			<select id="category" name="category" required>
				<option value="<%=j.getCategory()%>"><%=j.getCategory()%></option>
				<option value="Kỹ thuật">Kỹ thuật</option>
				<option value="Bán hàng">Bán hàng</option>
				<option value="Tiếp thị">Tiếp thị</option>
				<option value="Nhân sự">Nhân sự</option>
			</select>

			<label for="status">Trạng thái:</label>
			<select id="status" name="status" required>
				<option value="<%=j.getStatus()%>"><%=j.getStatus()%></option>
				<option value="Đang tuyển">Đang tuyển</option>
				<option value="Ngừng tuyển">Ngừng tuyển</option>
			</select>

			<label for="jobDescription">Mô tả công việc:</label>
			<textarea id="description" name="description" rows="6" required><%=j.getDescription()%></textarea>

			<button type="submit">Cập nhật</button>
		</form>
	</div>

	<%@ include file="components/footer.jsp"%>
</body>
</html>