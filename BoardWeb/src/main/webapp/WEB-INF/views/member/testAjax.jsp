<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h3>Ajax 연습페이지</h3>
이름: <input type="text" name="name"><br>
나이: <input type="number" name="age">

<h3>회원목록</h3>
<table class="table">
<thead>
	<tr>
		<th>아이디</th>
		<th>비밀번호</th>
		<th>이름</th>
		<th>권한</th>
		<th>삭제</th>
	</tr>
	</thead>
	<tbody id="list"></tbody>
<!--	<tr><td>user01</td><td>1111</td><td>홍길동</td><td>User</td></tr> -->
</table>

<script src="js/member.js"></script>