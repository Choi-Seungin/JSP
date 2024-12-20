<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 조회</title>
<link rel="stylesheet" type="text/css" href="css/board_view.css">
<script>
        window.onload = () => {
            //좋아요/싫어요 링크 클릭 -> 경고창 띄우기(글번호 같이 띄움)
            document.querySelectorAll('#btn_like, #btn_hate').forEach(item => {
            	item.onclick = (e) => {
            	const bno = '${board.bno}';
            	let baseUrl = item.id == 'btn_like' ? './boardLike.do' : './boardHate.do';
            	baseUrl += '?bno='+ bno;
            	console.log(baseUrl);
            	fetch(baseUrl).then(response => response.json())
            	.then(result => {
            		//좋아요, 싫어요 결과 출력
            		//개수 최신
            		alert(result.msg);
            		document.querySelector('#like_count').innerText = result.blike;
            		document.querySelector('#hate_count').innerText = result.bhate;
            	})
            	
            	}
            })
            //댓글 좋아요/싫어요 -> 경고창 띄우기(글번호 같이 띄움)
        	document.querySelectorAll('.btn_comment_like, .btn_comment_hate').forEach(item => {
				item.onclick = (e) => {
					const cno = e.target.parentNode.parentNode.querySelector('input').value;
					let baseUrl = item.className == 'btn_comment_like' ? './boardCommentLike.do' : './boardCommentHate.do';
					baseUrl += '?cno='+cno;
					console.log(baseUrl);
					fetch(baseUrl).then(response => response.json())
	            	.then(result => {
	            		//좋아요, 싫어요 결과 출력
	            		alert(result.msg);
	            		//개수 최신 - 새로고침
	            		location.reload();
	            	})
				}
			})
        }
    </script>
</head>
<body>
	<div class="container">
		<h1>게시글 조회</h1>
		<table class="board-view-table">
			<tr>
				<th>번호</th>
				<td>${board.bno}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${board.title}</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${board.id}</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td>${board.writeUpdateDate}</td>
			</tr>
			<tr>
				<th>조회수</th>
				<td>${board.bcount}</td>
			</tr>
			<tr>
				<th>좋아요</th>
				<td>${board.blike}</td>
			</tr>
			<tr>
				<th>싫어요</th>
				<td>${board.bhate}</td>
			</tr>
			<tr>
				<th colspan="2" style="text-align: left;">내용</th>
			</tr>
			<tr>
				<td colspan="2">${board.content}</td>
			</tr>
			<tr>
				<td colspan="2"><a href="#" id="btn_like">좋아요 : <span
						id="like_count">${board.blike }</span></a> <a href="#" id="btn_hate">싫어요
						: <span id="hate_count">${board.bhate }</span>
				</a></td>
			</tr>
			<tr>
				<td colspan="2">
					<p>첨부파일 목록</p> <c:forEach var="file" items="${fileList }">
						<a href="./fileDown.do?fno=${file.fno }">${file.fileName }</a>
						<br>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<!-- 댓글 입력 폼 -->
					<div class="comment_form">
						<form action="commentWrite.do" method="post">
							<input type="hidden" name="bno" value="${board.bno }">
							<textarea name="comment" placeholder="댓글을 입력하세요"></textarea>
							<button>댓글작성</button>
						</form>
					</div>
				</td>
			</tr>
		</table>
		<div class="actions">
			<a href="./boardMain.do" class="btn">목록으로</a>
			<!-- 게시글 삭제, 수정 버튼 출력 ./boardUpdateView.do?bno=글번호 ./boardDelete.do?bno=글번호-->
			<c:if test="${board.id == sessionScope.user.id}">
				<a href="./boardDelete.do?bno=${board.bno }" class="btn edit-btn">삭제</a>
				<a href="./boardUpdateView.do?bno=${board.bno }"
					class="btn delete-btn">수정</a>
			</c:if>
		</div>
		<hr>
		<!-- 댓글 내용 출력 -->
		<c:forEach var="comment" items="${commentList }">
			<div class="comment">
				<p>
					<input type="hidden" name="cno" value="${comment.cno }"> <span>${comment.id }</span>
					<span>작성일${comment.cdate }</span> <span><a href="#"
						class="btn_comment_like">좋아요 : <span>${comment.clike }</span></a></span>
					<span><a href="#" class="btn_comment_hate">싫어요 : <span>${comment.chate }</span></a></span>
				</p>
				<p>${comment.content }</p>
				<c:if test="${comment.id == sessionScope.user.id}">
					<a
						href="./boardCommentDelete.do?cno=${comment.cno}&bno=${board.bno}">댓글
						삭제</a>
				</c:if>
			</div>
			<hr>
		</c:forEach>
	</div>
</body>
</html>