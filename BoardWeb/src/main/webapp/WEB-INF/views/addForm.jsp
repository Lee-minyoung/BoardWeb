<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="includes/header.jsp"></jsp:include>
<h3>글등록화면(addForm.jsp)</h3>
<form action="addBoard.do">
	<table class="table">
		<tr>
			<th>제목</th>
			<td><input class="form-contact" type="text" name="title"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><input class="form-control" rows="3" cols="45" name="content"></td>
		</tr>
		<tr>
		    <th>작성자</th>
			<td><input class="form-control" type="text" name="writer"></td>
		</tr>
		<tr>
			<td colspan="2">
			<input class="btn btn-primary" type="submit" value="등록">
			<input class="btn btn-warning" type="reset" value="취소">
			</td>
		</tr>
	</table>
</form>

<jsp:include page="includes/footer.jsp"></jsp:include>