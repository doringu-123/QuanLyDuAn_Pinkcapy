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
	background-color: #e6f3e6; /* Light green background (Duolingo) */
	color: #333; /* Dark text for readability */
	margin: 0;
	padding: 0;
	overflow-x: hidden;
	min-height: 120vh;
}

.contentMain {
	padding: 20px;
	margin: 0 auto;
	width: 80vw;
	min-height: 85vh;
}

.content {
	padding: 40px;
	margin: 0 auto;
	width: 100%;
	text-align: center;
	background-color: #ffffff; /* White background for form container */
	padding: 40px;
	border-radius: 10px;
	text-align: left;
	margin-bottom: 30px;
}

.job-form {
	display: flex;
	align-items: center; 
	justify-content: flex-start;
}

.jobHeading {
	font-size: 1.4em;
	border-left: 5px solid #1cb0f6; /* Blue border (Duolingo) */
	padding: 6px;
	color: #f7c948; /* Yellow accent (Duolingo) */
	margin-bottom: 20px;
	font-weight: bold;
	padding-left: 10px;
}

.job-form label {
	display: block;
	margin-bottom: 15px;
	font-weight: bold;
	color: #1cb0f6; /* Blue labels (Duolingo) */
}

.job-form input[type="text"], .job-form textarea, .job-form select {
	width: 100%;
	padding: 10px;
	margin-bottom: 25px;
	background-color: #e6f3e6; /* Light green for inputs */
	border: none;
	border-radius: 5px;
	color: #333; /* Dark text for inputs */
	font-size: 1rem;
}

.job-form select {
	appearance: none;
	-webkit-appearance: none;
	background-color: #e6f3e6; /* Light green for select */
	padding: 10px;
	width: 25%;
	margin-right: 15px;
}

.content button {
	padding: 10px 20px;
	background-color: #58cc02; /* Green button (Duolingo) */
	border: none;
	border-radius: 5px;
	color: #fff;
	cursor: pointer;
	font-size: 1.1rem;
	transition: background-color 0.3s ease;
}

.content button:hover {
	background-color: #1cb0f6; /* Blue hover effect (Duolingo) */
}

.headingText {
	margin-bottom: 15px;
	margin-top: 0;
	color: #f7c948; /* Yellow heading (Duolingo) */
	text-align: center;
}

.job-details {
	background-color: #ffffff; /* White job detail cards */
	padding: 40px;
	border-radius: 10px;
	box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1); /* Subtle shadow */
	margin-bottom: 30px;
}

.job-field {
	margin-bottom: 15px;
}

.job-field label {
	display: inline-block;
	width: 120px;
	font-weight: bold;
	color: #1cb0f6; /* Blue labels (Duolingo) */
}

.job-field span {
	display: inline-block;
	color: #555; /* Grayish text for content */
}

.jobTitle {
	color: #f7c948; /* Yellow job title (Duolingo) */
}

.buttons {
	margin-top: 20px;
}

.viewMore {
	padding: 10px 20px;
	margin-right: 10px;
	background-color: #58cc02; /* Green button (Duolingo) */
	border: none;
	border-radius: 5px;
	color: #fff;
	cursor: pointer;
	transition: background-color 0.3s ease;
	font-size: 18px;
}

.buttons .viewMore:hover {
	background-color: #1cb0f6; /* Blue hover effect (Duolingo) */
}

footer {
	position: relative;
	bottom: 0px;
}
</style>
</head>
<body>

	<c:if test="${empty userobj }">
		<c:redirect url="login.jsp" />
	</c:if>

	<%@include file="components/navbar.jsp"%>

	<div class="contentMain">

		<div class="content">

			<h1 class="jobHeading">Tìm Kiếm Việc Làm Mới</h1>

			<form action="searchJobView.jsp" method="get">

				<div class="job-form">
					<label for="location">Địa Điểm: </label> <select id="location"
						name="loc">
						<option value="lo">Chọn Địa Điểm</option>
						<option value="HaNoi">Hà Nội</option>
						<option value="HoChiMinh">Hồ Chí Minh</option>
						<option value="DaNang">Đà Nẵng</option>
						<option value="CanTho">Cần Thơ</option>
						<option value="HaiPhong">Hải Phòng</option>
					</select> <label for="category">Danh Mục Công Việc: </label> <select
						id="cat" name="cat">
						<option value="ca">Chọn Danh Mục</option>
						<option value="Engineering">Kỹ Thuật</option>
						<option value="Sales">Bán Hàng</option>
						<option value="Marketing">Tiếp Thị</option>
					</select>
				</div>
				<button type="submit">Gửi</button>
			</form>
		</div>

		<h1 class="headingText">Chi Tiết Việc Làm</h1>

		<%
		JobDAO dao = new JobDAO(DBConnect.getConn());
		List<Jobs> list = dao.getAllJobsForUser();
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
				<label>Mô Tả:</label> <span> <%
 if (j.getDescription().length() > 0 && j.getDescription().length() < 120) {
 %>
					<p><%=j.getDescription()%></p> <%
 } else {
 %>
					<p><%=j.getDescription().substring(0, 120)%>...
					</p> <%
 }
 %>
				</span>
			</div>

			<div class="job-field">
				<label>Ngày Đăng:</label> <span> <%=j.getPdate()%>
				</span>
			</div>
			<a href="oneJobView.jsp?id=<%=j.getId()%>" class="buttons"><button
					class="viewMore">Xem Thêm</button></a>
		</div>
		<%
		}
		%>

	</div>

	<%@ include file="components/footer.jsp"%>
</body>
</html>