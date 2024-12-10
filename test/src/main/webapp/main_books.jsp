<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 정보 조회</title>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

h2 {
	padding: 20px 0px;
	text-align: center;
}

table {
	border-collapse: collapse;
	margin: 20px auto;
}

th, td {
	border: 1px solid black;
	padding: 10px 5px;
}

.search_bar {
	text-align: center;
}
</style>
<script>
    	window.onload = () => {
    		const search = document.querySelector("#search");
    		const result = document.querySelector("#result");
    		const btnSearch = document.querySelector("#btn_search");
    		btnSearch.onclick = () => {
    		const url = "./searchBook.do" + `?search=${search.value}`;
    			fetch(url).then((response) => {
    				return response.json();
    			}).then((json) => {
    				console.log(json);
    				result.innerHTML = '';
    				json.list.forEach(item =>{
    				const tr = document.createElement('tr');
					tr.innerHTML = `<td>${item.isbn}</td>
						<td>${item.bookName}</td>
						<td>${item.author}</td>
						<td>${item.publishDate}</td>
						<td>${item.publisher}</td>
						<td>${item.price}</td>`;
						result.appendChild(tr);
    			})
    				
    			}).catch((error) => {
    				console.log(error);
    			});
    		}
    		
    	}
    </script>
</head>
<body>
	<h2>도서 정보 조회 페이지</h2>
	<table border="1">
		<thead>
			<tr>
				<td colspan="6" class="search_bar"><input type="text"
					placeholder="도서명 일부로 검색" id="search">
					<button id="btn_search">검색</button></td>
			</tr>
			<tr>
				<th>ISBN</th>
				<th>책 이름</th>
				<th>저자</th>
				<th>출판일</th>
				<th>출판사</th>
				<th>가격</th>
			</tr>
		</thead>
		<tbody id="result">
		</tbody>
	</table>
</body>
</html>
