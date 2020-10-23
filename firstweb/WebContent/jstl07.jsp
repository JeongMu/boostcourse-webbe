<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="t" value="<script type='text/javascript'>alert(1);</script>"/>

<c:out value="${t }" escapeXml="false"/> <!-- 태그로 인식 -->
<c:out value="${t }" escapeXml="true"/> <!-- 태그로 인식하지 않음 -->

</body>
</html>