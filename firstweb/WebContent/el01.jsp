<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	pageContext.setAttribute("p1", "page scope value");
request.setAttribute("r1", "request scope value");
session.setAttribute("s1", "session scope value");
application.setAttribute("a1", "application scope value");
%>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	pageContext.getAttribute("p1") :
	<%=pageContext.getAttribute("p1")%><br>
	pageContext.getAttribute("p1") : ${pageScope.p1}
	<br>
	<br> requestContext.getAttribute("r1") :
	<%=request.getAttribute("r1")%><br>
	requestContext.getAttribute("r1") : ${requestScope.r1}
	<br>
	<br> sessionContext.getAttribute("s1") :
	<%=session.getAttribute("s1")%><br>
	sessionContext.getAttribute("s1") : ${sessionScope.s1}
	<br>
	<br> applicationContext.getAttribute("a1") :
	<%=application.getAttribute("a1")%><br>
	applicationContext.getAttribute("a1") : ${applicationScope.a1}
	<br>
	<br>
	<!-- 안겹치는 변수가 있으면 -->
	pageContext.getAttribute("p1") : ${p1}

</body>
</html>