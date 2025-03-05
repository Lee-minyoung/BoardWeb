<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h3>메인</h3>
<table class="table table-striped">
	<thead>
		<tr>
			<th>목록</th>
			<th>이름</th>
			<th>번호</th>
			<th>주소</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="student" items="${list }">
			<tr>
				<td>
				<c:out value="${student.student_no }"></c:out>
				</td>
				<td><a href="student.do?bno=${student.student_no }">
				<c:out value="${student.student_name }"></c:out>
				</a></td>
				<td>
				<c:out value="${student.phone }"></c:out>
				</td>
				<td>
				<c:out value="${student.address }"></c:out>
				</td>
		</c:forEach>
	</tbody>
	</table>