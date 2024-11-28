<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>약수 구하기</h2>
	<p>입력받은 숫자 : ${requestScope.num }</p>
	<p>약수 : 
	<c:forEach var="i" items="${requestScope.list }">
		${i }
	</c:forEach>
	</p>
</body>
</html>