<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>JSP 기본 문법</h2>
	<!-- 선언문 : 필드 및 메서드 작성 -->
	<%!//필드
	String message = "Hellow World";

	//메서드
	String getMessage() {
		return message;
	}%>

	<!-- 표현식 : html 출력할 곳에 자바 데이터 출력하는 표현식 -->
	<p>선언문 필드 테스트 : <%=message%></p>
	<p>선언문 메서드 테스트 : <%=getMessage()%></p>
	<!--
		스크립트릿 : 사용자가 서버에 데이터를 전달을 하면, 실제로 jsp에서 사용자가 보낸 데이터를 받아서 일하는 부분
	-->
	<%
		int num = Integer.parseInt(request.getParameter("num"));
		String msg = request.getParameter("msg");
	%>
	스크립트릿 테스트 : <%=num %> <br>
	스크립트릿 테스트 : <%=msg %>
</body>
</html>