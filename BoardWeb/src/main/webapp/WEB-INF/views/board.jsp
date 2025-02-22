<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="includes/header.jsp"></jsp:include>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h3>상세화면(board.jsp)</h3>

<form action="modifyForm.do">
<input type="hidden" name="bno" value="${board.boardNo }">
<table class="table">
	<tr>
		<th>글번호</th><td><c:out value="${board.boardNo }"></c:out></td>
		<th>조회수</th><td><c:out value="${board.viewCnt }"></c:out></td>
	</tr>
	<tr>
		<th>내용</th>
		<td colspan="3"><c:out value="${board.content }"></c:out></td></td>
	</tr>
	<tr>
		<th>제목</th>
		<td colspan="3"><c:out value="${board.title }"></c:out></td></td>
	</tr>
	<tr>
		<th>작성자</th>
		<td><c:out value="${board.writer }"></c:out></td></td>
		<th>작성일시</th>
		<td><c:out value="${board.writeDate }"></c:out></td></td>
	</tr>
	<tr>
		<td colspan="3" align="center">
		<button class="btn btn-warning" type="submit">수정</button>
		<button class="btn btn-danger" type="button">삭제</button>
		</td>
		</tr>
		
	<c:if test="${msg != null }">
	<tr><td colspan="3" align="center"><span style="color:red;">${msg }</span></td></tr>
	</c:if>
</table>
</form>
<script>
	let logid="${loginId}"; //자바의 변수값을 script 사용
	// 삭제버튼에 클릭 이벤트 등록
	document.querySelector('button.btn-danger').addEventListener('click', function(e){
		let writer = document.querySelector('table.table>tbody>tr:nth-of-type(4)>td').innerHTML;
		let bno = document.querySelector('input[name="bno"]').value;
		console.log(logid);
		if(writer == logid)
	    	location.href="removeBoard.do?bno=" + bno;
	    else
	    	alert("권한을 확인하세요.");
	});
</script>

<jsp:include page="includes/footer.jsp"></jsp:include>