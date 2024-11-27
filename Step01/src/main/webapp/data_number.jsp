<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--
		사용자가 보낸 데이터를 꺼내서 num에 저장 
	-->
	<%
		int num = Integer.parseInt(request.getParameter("number"));
	%>
	<p>사용자가 보낸 값 : <%=num %></p>
	<%
		for(int i=1;i<=num;i++){
	%>
		<p><%=i %></p>
	<%
		}
	%>
</body>
</html>