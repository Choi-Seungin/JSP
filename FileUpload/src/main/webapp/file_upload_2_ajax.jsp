<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	window.onload = () => {
		document.querySelector('.btn_upload').onclick = () => {
			const fileList = document.querySelectorAll('input[name=file]');		
			console.log(fileList);
			const inputList = document.querySelectorAll('input:not(input[type=file])');
 
			const formData = new FormData();
			
			fileList.forEach((item) => {
				formData.append('file',item.files[0]);
			});
			inputList.forEach((item) => {
				formData.append(item.name,item.value);
			})
			
			fetch("./fileUpload.do",{
				method:"POST",
				body:formData
			}).then(response => response.json())
			.then(result => {
				console.log('succes :',result);
			}).catch(error => {
				console.log('error :',error);
			});
		}
	}
</script>
</head>
<body>
	<h1>파일 업로드 테스트</h1>
	<input type="text" name="txt1">
	<br>
	<input type="text" name="txt2">
	<br> 파일 :
	<input type="file" name="file">
	<br> 파일 :
	<input type="file" name="file">
	<br> 파일 :
	<input type="file" name="file">
	<br>
	<button type="button" class="btn_upload">파일 업로드</button>
</body>
</html>