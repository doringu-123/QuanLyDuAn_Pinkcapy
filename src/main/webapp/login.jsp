<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập - TalentHub</title>
<link rel="stylesheet" href="components/form.css">
</head>

<style>
* {
	margin: 0px;
	padding: 0px;
	box-sizing: border-box;
}

body {
	background-color: #F5F5F5;
	color: #333333;
	overflow-x: hidden;
}

.container-form {
	width: 100%;
	display: flex;
	flex-direction: column;
	align-items: center;
	margin-bottom: 20px;
	overflow: hidden;
}

.succTxt {
	text-align: center;
	margin-bottom: 40px;
	color: #1CB0F6;
	font-size: 1.3rem;
}

.errorTxt {
	text-align: center;
	margin-bottom: 40px;
	color: #FF4B4B;
	font-size: 1.3rem;
}

.mainForm {
	width: 100%;
	display: flex;
	justify-content: center;
}

.center {
	background-color: #FFFFFF;
	padding: 40px;
	border-radius: 10px;
	width: 500px;
	text-align: left;
}

.center h1 {
	color: #FF4B4B;
	margin-bottom: 20px;
	font-size: 2em;
}

.inputbox {
	margin-bottom: 25px;
}

.inputLable {
	display: block;
	margin-bottom: 10px;
	font-weight: bold;
	color: #333333;
}

.inputbox input {
	width: 100%;
	padding: 10px;
	background-color: #F0F0F0;
	border: none;
	border-radius: 5px;
	color: #333333;
	font-size: 1rem;
}

.inputbox input::placeholder {
	color: #888888;
}

.submitButton {
	padding: 15px 30px;
	background-color: #58CC02;
	border: none;
	border-radius: 5px;
	color: #FFFFFF;
	cursor: pointer;
	font-size: 1.1rem;
	transition: background-color 0.3s ease;
}

.submitButton:hover {
	background: linear-gradient(45deg, #FFC107, #1CB0F6);
}
</style>

<body>

	<div class="container-form">

		<%@include file="components/navbar.jsp"%>
		
		<main class="mainForm">
			<div class="center">
		
				<h1>Đăng nhập</h1>
				
				<c:if test="${not empty succMsg }">
					<p class="errorTxt">${succMsg}</p>
					<c:remove var="succMsg"/>
				</c:if>

				<form action="login" method="post">				

					<div class="inputbox">
						<label class="inputLable">Email</label>
						<input type="text" name="email" required="required">
					</div>
					<div class="inputbox">
						<label class="inputLable">Mật khẩu</label>
						<input type="password" name="password" required="required">
					</div>
					<div class="inputbox">
						<button type="submit" class="submitButton">Gửi</button>
					</div>
				</form>
			</div>

		</main>
	</div>
	<%@include file="components/footer.jsp"%>
</body>
</html>