<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<footer class="footer">

<style>
.footer {
	position: relative;
	bottom: 0px;
	width: 100vw;
	height: 250px;
	left: 0px;
}

.container-footer {
	display: flex;
	justify-content: center;
	align-items: center;
	flex-wrap: wrap;
	padding: 10px;
	height: 100%;
	width: 100%;
	background-color: #F5F5F5; /* Xám nhạt giống Duolingo */
	bottom: 0px;
}

.footer-content {
	display: flex;
	gap: 120px;
	flex: 1;
	height: 70%;
	width: 100%;
	align-items: center;
	justify-content: center; 
}

.quick-links ul {
	list-style: none;
	padding-left: 0;
}

.quick-links a {
	color: #1CB0F6; /* Xanh dương Duolingo */
	text-decoration: none;
	transition: color 0.3s ease;
}

.quick-links a:hover {
	color: #FFC107; /* Vàng Duolingo */
}

.additional-info p {
	font-size: 14px;
	color: #333333; /* Màu chữ tối cho dễ đọc */
}

/* Copyright section */
.copyright {
	margin-top: 20px;
	text-align: center;
	font-size: 14px;
	flex-basis: 100%;
	color: #333333; /* Màu chữ tối */
}
</style>
	<div class="container-footer">
		<div class="footer-content">
			<div class="quick-links">
				<h3>Liên kết nhanh</h3>
				<ul>
					<li><a href="#">Giới thiệu</a></li>
					<li><a href="#">Liên hệ</a></li>
					<li><a href="#">Điều khoản và Điều kiện</a></li>
					<li><a href="#">Chính sách bảo mật</a></li>
				</ul>
			</div>
			<div class="additional-info">
				<h3>Thông tin bổ sung</h3>
				<p>TalentHub cung cấp nền tảng kết nối nhân tài và cơ hội việc làm tốt nhất.</p>
			</div>
		</div>
		<div class="copyright">
			<p>© 2025 TalentHub</p>
		</div>
	</div>
</footer>