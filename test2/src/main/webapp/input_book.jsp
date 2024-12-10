<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>책 정보 입력 폼</title>
</head>
<body>
    <h2>책 정보 입력</h2>
    <form action="./insertBook" method="post">
        <label for="isbn">ISBN:</label><br>
        <input type="text" id="isbn" name="isbn" required><br><br>
        
        <label for="book_name">책 이름:</label><br>
        <input type="text" id="book_name" name="book_name" required><br><br>
        
        <label for="author">저자:</label><br>
        <input type="text" id="author" name="author" required><br><br>
        
        <label for="publish_date">출판일:</label><br>
        <input type="date" id="publish_date" name="publish_date"><br><br>
        
        <label for="publisher">출판사:</label><br>
        <input type="text" id="publisher" name="publisher"><br><br>
        
        <label for="price">가격:</label><br>
        <input type="number" id="price" name="price" step="0.01"><br><br>
        
        <input type="submit" value="제출">
    </form>
</body>
</html>
