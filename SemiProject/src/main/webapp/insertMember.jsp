<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>회원가입</title>
<style>
/* 스타일 생략 (이전 스타일 유지) */
</style>

<script>
//폼 검증
function validateForm() {
    const password = document.getElementById("password").value;
    const confirmPassword = document.getElementById("confirmPassword").value;

    if (password !== confirmPassword) {
        alert("비밀번호가 일치하지 않습니다.");
        return false;
    }
    return true;
}

// 메시지 출력 재사용 함수
function showMessage(elementId, message, color) {
    const messageElement = document.getElementById(elementId);
    messageElement.textContent = message;
    messageElement.style.color = color;
}

// 버튼 활성화/비활성화 재사용 함수
function toggleButton(buttonId, isDisabled) {
    const button = document.getElementById(buttonId);
    button.disabled = isDisabled;
}

// 공통 fetch 요청 함수
async function fetchData(url, onSuccess, onError) {
    try {
        const response = await fetch(url);
        if (!response.ok) throw new Error(`서버 오류: ${response.status}`);
        const data = await response.json();
        onSuccess(data);
    } catch (error) {
        console.error(error);
        onError(error);
    }
}

// 아이디 중복 확인
function checkLoginId() {
        const loginId = document.getElementById("loginId").value;
        const messageElement = document.getElementById("idCheckMessage");
        const submitButton = document.getElementById("submitButton");

        if (!loginId) {
            messageElement.textContent = "아이디를 입력하세요.";
            messageElement.style.color = "red";
            return;
        }

        const url = "./checkLoginId.do?loginId=" + encodeURIComponent(loginId);

        fetch(url)
            .then(response => response.json())
            .then(data => {
                if (data.exists) {
                    messageElement.textContent = "이미 사용 중인 아이디입니다.";
                    messageElement.style.color = "red";
                    submitButton.disabled = true;
                } else {
                    messageElement.textContent = "사용 가능한 아이디입니다.";
                    messageElement.style.color = "green";
                    submitButton.disabled = false;
                }
            })
            .catch(error => {
                console.error("아이디 중복 체크 오류:", error);
                messageElement.textContent = "아이디 확인 중 문제가 발생했습니다.";
                messageElement.style.color = "red";
                submitButton.disabled = true;
            });
    }

// 이메일 중복 확인
function checkEmail() {
    const email = document.getElementById("userEmail").value;

    if (!email) {
        showMessage("emailCheckMessage", "이메일을 입력하세요.", "red");
        return;
    }

    const url = "./checkEmail.do?email=" + encodeURIComponent(email);
    fetchData(
        url,
        (data) => {
            if (data.exists) {
                showMessage("emailCheckMessage", "이미 사용 중인 이메일입니다.", "red");
                toggleButton("submitButton", true);
            } else {
                showMessage("emailCheckMessage", "사용 가능한 이메일입니다.", "green");
                toggleButton("submitButton", false);
            }
        },
        () => {
            showMessage("emailCheckMessage", "이메일 확인 중 문제가 발생했습니다.", "red");
            toggleButton("submitButton", true);
        }
    );
}



// 비밀번호 확인
function checkPasswordMatch() {
    const password = document.getElementById("password").value;
    const confirmPassword = document.getElementById("confirmPassword").value;

    if (password && confirmPassword) {
        if (password === confirmPassword) {
            showMessage("passwordMatchMessage", "비밀번호가 일치합니다.", "green");
        } else {
            showMessage("passwordMatchMessage", "비밀번호가 일치하지 않습니다.", "red");
        }
    } else {
        showMessage("passwordMatchMessage", "", "");
    }
}
//닉네임 중복 확인 함수
function checkNickName() {
    const nickName = document.getElementById("nickName").value; // 입력된 닉네임 값
    const messageElement = document.getElementById("nickNameCheckMessage"); // 결과 메시지 출력 요소

    // 닉네임이 비어 있는 경우
    if (!nickName) {
        messageElement.textContent = "닉네임을 입력해주세요.";
        messageElement.style.color = "red";
        return;
    }

    // fetch를 통해 서버로 요청 전송
    const encodedNickName = encodeURIComponent(nickName); // 명시적으로 JavaScript의 encodeURIComponent 사용
    fetch('/SemiProject/checkNickName.do?nickName=' + encodedNickName) // 템플릿 리터럴 제거
        .then(response => {
            if (!response.ok) {
                throw new Error(`서버 오류: ${response.status}`);
            }
            return response.json();
        })
        .then(data => {
            if (data.exists) {
                // 닉네임이 이미 존재하는 경우
                messageElement.textContent = "이미 사용 중인 닉네임입니다.";
                messageElement.style.color = "red";
            } else {
                // 닉네임이 사용 가능한 경우
                messageElement.textContent = "사용 가능한 닉네임입니다.";
                messageElement.style.color = "green";
            }
        })
        .catch(error => {
            // 요청 중 오류 발생
            console.error("닉네임 확인 중 오류:", error);
            messageElement.textContent = "닉네임 확인 중 문제가 발생했습니다.";
            messageElement.style.color = "red";
        });
}
</script>
</head>
<body>
	<div class="insert_member_container">
		<h1>회원가입</h1>
		<form id="registerForm" action="./insertMember.do" method="post"
			onsubmit="return validateForm()">
			<div>
				<label for="loginId">아이디</label> <input type="text" id="loginId"
					name="loginId" required>
				<button type="button" onclick="checkLoginId()">중복 확인</button>
				<small id="idCheckMessage"></small>
			</div>
			<div>
				<label for="password">비밀번호</label> <input type="password"
					id="password" name="password" required
					oninput="checkPasswordMatch()">
			</div>
			<div>
				<label for="confirmPassword">비밀번호 확인</label> <input type="password"
					id="confirmPassword" name="confirmPassword" required
					oninput="checkPasswordMatch()"> <small
					id="passwordMatchMessage"></small>
			</div>
			<div>
				<label for="userName">이름</label> <input type="text" id="userName"
					name="userName" required>
			</div>
			<div>
				<label for="userEmail">이메일</label> <input type="email"
					id="userEmail" name="userEmail" required>
				<button type="button" onclick="checkEmail()">중복 확인</button>
				<small id="emailCheckMessage"></small>
			</div>
			<div>
				<label for="nickName">닉네임</label> <input type="text" id="nickName"
					name="nickName" />
				<button type="button" onclick="checkNickName()">중복 확인</button>
				<small id="nickNameCheckMessage"></small>
			</div>
			<button type="submit" id="submitButton" disabled>회원가입</button>
		</form>
	</div>
</body>
</html>
