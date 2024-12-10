<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>전체 책 정보 조회</title>
</head>
<body>
    <h2>전체 책 정보</h2>
    <table border="1">
        <tr>
            <th>ISBN</th>
            <th>책 이름</th>
            <th>저자</th>
            <th>출판일</th>
            <th>출판사</th>
            <th>가격</th>
        </tr>
        <c:choose>
            <c:when test="${not empty books}">
                <c:forEach var="book" items="${books}">
                    <tr>
                        <td>${book.isbn}</td>
                        <td>${book.bookName}</td>
                        <td>${book.author}</td>
                        <td>${book.publishDate}</td>
                        <td>${book.publisher}</td>
                        <td>${book.price}</td>
                    </tr>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <tr>
                    <td colspan="6">책 정보가 없습니다.</td>
                </tr>
            </c:otherwise>
        </c:choose>
    </table>
    <br>
    <a href="index.jsp">메인 페이지로 돌아가기</a>
</body>
</html>
