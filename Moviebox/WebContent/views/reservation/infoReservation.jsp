<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
    body{
        color: rgb(32,32,32);
    }
	div{
        border: 1px solid red;
        box-sizing: border-box;
    }
    a{
        text-decoration: none;
        color: rgb(32,32,32);
    }

    #wrap{
        width: 1200px;
        height: 800px;
    }
</style>
<body>
<%@ include file="/views/common/header.jsp" %>
<div id="wrap">

<div id="content-info">
    <div id="print-info">
        <div id="movie-info-area">
            <div id="movie-poster"></div>
            <div id="movie-info"></div>
        </div>
        <div id="reservation-info-area"></div>
    </div>
</div>





</div>
<%@ include file="/views/common/footer.jsp" %>
</body>
</html>