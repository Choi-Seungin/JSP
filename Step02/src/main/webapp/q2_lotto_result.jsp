<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>로또번호</h2>
<table>
<c:forEach var="lottoSet" items="${requestScope.lottoSet }" >
<tr>
<c:forEach var="lottoNo" items="${lottoSet }">
	<td>${lottoNo }</td>
</c:forEach>
</tr>
</c:forEach>
</table>
</body>
</html>