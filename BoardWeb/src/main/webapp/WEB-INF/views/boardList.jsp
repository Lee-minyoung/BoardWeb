<%@page import="com.yedam.PageVO"%>
	<%@page import="com.yedam.vo.BoardVO"%>
	<%@page import="java.util.List"%>
	<%@ page language="java" contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 부트스트랩 css, js -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
<title>Insert title here</title>
</head>
<body>

	
	<jsp:include page="includes/header.jsp"></jsp:include>
	
	<!-- html 주석문 -->
	<%
	// boardList.do -> request -> boardList.jsp
	String result = (String) request.getAttribute("msg");
	List<BoardVO> list = (List<BoardVO>) request.getAttribute("list");
	//Control에서 paging의 값을 얻어오기
	PageVO paging = (PageVO) request.getAttribute("paging");
	%>
	<p>page의 값은<%=paging %></p>
	<h3>게시글 목록(boardList.jsp)</h3>
	<table class="table table-striped">
		<thead style="font-weight: bold;">
		<td>번호</td>
		<td>제목</td>
		<td>작성자</td>
		<td>작성날짜</td>
		<td>공감수</td>
		</thead>
		<tbody>
			<%
			for (BoardVO board : list) {
			%>
			<tr>
				<td><%=board.getBoardNo()%></td>
				<td><a href="board.do?bno=<%=board.getBoardNo()%>"><%=board.getTitle()%></a></td>
				<td><%=board.getWriter()%></td>
				<td><%=board.getWriteDate()%></td>
				<td><%=board.getViewCnt()%></td>
			</tr>
			<%
			} //for 종료
			%>
		</tbody>
	</table>
	<!-- paging 시작 -->
	<nav aria-label="...">
  	<ul class="pagination">
 
    <!-- 이전 페이지 여부 -->
    <%if (paging.isPrev()) {%>
    <li class="page-item">
    	<a class="page-link" href="boardList.do?page=<%=paging.getStartPage()-1 %>">Previous</a>
    </li>
    <%} else {%>
     <li class="page-item disabled">
    	<span class="page-link">Previous</span>
    </li>
	<%} %>
	
    
    <!-- 페이지 start ~ end 반복 -->
    <%for (int p = paging.getStartPage(); p <= paging.getEndPage(); p++){ %>
    <% if (p == paging.getCurrentPage()) {%>
    <li class="page-item active" aria-current="page">
    	<span class="page-link"><%=p %></span>
    </li>
    <%} else {%>
    <li class="page-item"> <a class="page-link" href="boardList.do?page=<%=p %>"><%=p %></a>
      </li>
    <%} 
    } %>

	<!-- 이후 페이지 여부. -->
	<%if (paging.isNext()) {%>
	<li class="page-item">
      <a class="page-link" href="boardList.do?page=<%=paging.getEndPage()+1 %>">Next</a>
    </li>
    <%} else {%>
    <li class="page-item disabled">
      <span class="page-link">Next</span>
    </li>
    <%} %>
  </ul>
</nav>
	<!-- paging 끝 -->
	
	
	<jsp:include page="includes/footer.jsp"></jsp:include>