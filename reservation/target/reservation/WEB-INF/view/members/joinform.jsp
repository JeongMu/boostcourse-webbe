<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<h1>회원가입</h1>
	<hr>
	<div>
		<div>
			<form method="post" action="/reservation_war/members/join">
				<div>
					<label>ID</label> <input type="text" name="name">
				</div>
				<div>
					<label>암호</label> <input type="password" name="password">
				</div>
				<div>
					<label>email</label> <input type="email" name="email">
				</div>
				<div>
					<label></label> <input type="submit" value="회원가입">
				</div>
			</form>
		</div>
	</div>
</body>
</html>