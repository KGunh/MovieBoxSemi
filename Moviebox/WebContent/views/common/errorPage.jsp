<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String errorMsg = (String)request.getAttribute("errorMsg");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나는 서비스 실패 시 오는 곳이야..ㅠ</title>
	<style>
		#errorMsg{
			color : skyblue;
			margin-top : 80px;
			text-align : center;
			font-size : 33px;
			font-weight : bold;
		}
	</style>
</head>
<body>

	<%@ include file="header.jsp" %>

	<h1 id="errorMsg"><%= errorMsg %></h1>


</body>
</html>