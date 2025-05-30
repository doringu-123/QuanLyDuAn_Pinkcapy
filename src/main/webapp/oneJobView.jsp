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
<title>Xem tin tuyển dụng - TalentHub</title>
<link rel="stylesheet" href="components/all_css.jsp">
<style>
body {
	background-color: #F5F5F5;
	color: #333333;
	margin: 0;
	padding: 0;
	overflow-x: hidden;
	min-height: 120vh;
}

.contentMain {
	padding: 30px;
	margin: 0 auto;
	width: 80vw;
	min-height: 85vh;
}

.headingText {
	margin-bottom: 15px;
	margin-top: 0;
	color: #FF4B4B;
	text-align: center;
}

.job-details {
	background-color: #FFFFFF;
	padding: 40px;
	border-radius: 10px;
	box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
	margin-bottom: 30px;
}

.job-field {
	margin-bottom: 15px;
}

.job-field label {
	display: inline-block;
	width: 120px;
	font-weight: bold;
	color: #333333;
}

.job-field span {
	display: inline-block;
	color: #555555;
}

.jobTitle {
	color: #1CB0F6;
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
		<%
		JobDAO dao = new JobDAO(DBConnect.getConn());
		List<Jobs> list = dao.getAllJobsForUser();
		for (Jobs j : list) {
		%>

		<h1 class="headingText">Chi tiết tin tuyển dụng</h1>

		<div class="job-details">
			<div class="jobTitle job-field">
				<label>Tiêu đề:</label> <span> <%=j.getTitle()%>
				</span>
			</div>

			<div class="job-field">
				<label>Địa điểm:</label> <span> <%=j.getLocation()%>
				</span>
			</div>
			<div class="job-field">
				<label>Loại công việc:</label> <span> <%=j.getCategory()%>
				</span>
			</div>
			<div class="job-field">
				<label>Trạng thái:</label> <span> <%=j.getStatus()%>
				</span>
			</div>
			<div class="job-field">
				<label>Mô tả:</label> <span> <%=j.getDescription()%></span>
			</div>
			<div class="job-field">
				<label>Ngày đăng:</label> <span> <%=j.getPdate()%>
				</span>
			</div>

		</div>
		<%
		}
		%>

	</div>

	<%@ include file="components/footer.jsp"%>
</body>
</html>