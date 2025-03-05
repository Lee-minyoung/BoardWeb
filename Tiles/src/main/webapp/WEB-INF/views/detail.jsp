<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h3>상세화면(board.jsp)</h3>
<form action="modifyForm.do">
<input type="hidden" name="bno" value="${board.boardNo }">
<table class="table">
  <tr>
    <th>목록</th><td><c:out value="${student.student_no }"></c:out></td>
    <th>조회수</th><td><c:out value="${board.viewCnt }"></c:out></td>
  </tr>
  <tr>
    <th>내용</th>
    <td colspan="3"><c:out value="${board.content }"></c:out></td>
  </tr>
  <tr>
    <th>제목</th>
    <td colspan="3"><c:out value="${board.title }"></c:out></td>
  </tr>
  <tr>
    <th>작성자</th>
    <td><c:out value="${board.writer }"></c:out></td>
    <th>작성일시</th>
    <td><c:out value="${board.writeDate }"></c:out></td>
  </tr>    
  <tr>
    <th>이미지</th>
    <td colspan="3">
      <c:if test="${board.img != null }">
      <img src="images/${board.img }" width="100px">
      </c:if>
    </td>
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