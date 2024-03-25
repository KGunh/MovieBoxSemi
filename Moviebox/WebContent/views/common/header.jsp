<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.member.model.vo.Member"  %>
<%
	
	Member loginUser = (Member)session.getAttribute("loginUser");

	String contextPath = request.getContextPath();
	
	String alertMsg = (String)session.getAttribute("alertMsg");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>헤더</title>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap" rel="stylesheet">


<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <style>
    
        * {
            box-sizing: border-box;
  			font-family: "Noto Sans KR", sans-serif;
        }
        
        .content{
            height: 910px;
            width: 500px;
            margin: auto;
            margin-top: 50px;
            margin-bottom: 50px;
        }

        body {
            background-color: #1A1A1A
        }

        .header {
            width: 1200px;
            height: 200px;
            margin: auto;
            border-bottom: 1px solid lightgray;
        }
        .header-line{
        	width: 100%;
        	height: 75px;
        	border-bottom: 1px solid lightgray;
        }

        .top-header {
        	margin:auto;
        	width: 1200px;
            height: 75px;
            position: relative;
            
        }

        .login-area {
            position: absolute;
            right: 30px;
            top: 20px;
        }

        .login-area>a {
            display: block;
            float: right;
            text-decoration-line: none;
            color: white;
            font-size: 16px;
            margin-left: 30px;
            font-weight: bold;
        }

        #header-navigator {
        	margin: auto;
        	width: 1200px;
            height: 125px;
        }

        #logo-div {
            position: relative;
            float: left;
            height: 100%;
            width: 30%;
        }

        #logo {
            position: absolute;
            top: 50%;
            margin-top: -25px;
            width: 100%;
            height: 50px;
            font-size: 36px;
            font-weight: bold;
            color: #FFC145;
            line-height: 45px;
            text-align: center;
        }

        a {
            text-decoration-line: none;
        }

        #logo>a {
            text-decoration-line: none;
            color: #FFC145;
        }

        #navigator {
            float: right;
            width: 68%;
            height: 100%;
        }

        .navi {
            float: left;
            width: 20%;
            height: 100%;
            text-align: center;
            margin: 0 auto;
        }

        .navi>a {

            display: block;
            text-align: center;
            width: auto;
            height: 100%;
            color: white;
            text-decoration-line: none;
            line-height: 125px;
            font-size: 18px;
            font-weight: bold;
        }
        .nav{
            height: 100%;
            width: 100%;
        }
        .nav li{
            overflow: auto;
            
        }
        .nav a{
            padding: 0;
            padding-left: 40px;
            padding-right: 40px;
            height: 100%;
            position: relative;
        }
        .nav span{
            text-align: center;
            line-height: 118px;
            font-size: 19px;
            list-style: none;
            color: white;
            font-weight: bold;
        }
        .img-concert{
            width: 80%;
            height: 80%;
        }


    </style>
</head>
<body>


	

	<script>
		
		const msg = '<%= alertMsg %>';
		
		if(msg != 'null'){
			alert(msg);
		
			<% session.removeAttribute("alertMsg"); %>
		}
		
	
	</script>
	<div class="header">
		<div class="header-line">
			<div class="top-header">
				<div class="login-area">
				<% if(loginUser == null) { %>
					<a href="<%=contextPath%>/insertForm.me" class="member">회원가입</a>
					
                	<a href="<%=contextPath%>/loginForm.me" class="member">로그인</a>
                	
				<%}else {  if(loginUser.getPrivilege().equals("Y")) {%>
					<a href="<%= contextPath %>/adminMain.me" class="member">관리자 기능</a><!-- 관리자로 로그인시 관리자 기능 활성화 -->
				<%} %>
					<a href="<%=contextPath%>/logout.me" class="member">로그아웃</a>
				<%} %>
				</div>
			</div>
		</div>
		<div id="header-navigator">
            <div id="logo-div">
                <div id="logo"><a href="<%=contextPath %>"><img class="img-concert" src="<%=contextPath%>/resources/img/4.png"/></a></div>
            </div>
            <div id="navigator">
                <!-- A grey horizontal navbar that becomes vertical on small screens -->
                <ul class="nav">
                    <li class="nav-item">
                        <a class="nav-link" href="<%=contextPath %>/movie.reservation"><span>예매</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<%=contextPath %>/list.movie"><span>영화</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<%=contextPath %>/search.theater"><span>영화관</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<%=contextPath %>/list.notice"><span>고객센터</span></a>
                    </li>
                    <li class="nav-item">
       					<% if(loginUser == null) { %>
                        <a class="nav-link" href="<%=contextPath %>/loginForm.me"><span>마이페이지</span></a>
                        <%} else { %>
                        <a class="nav-link" href="<%=contextPath %>/mypage.me"><span>마이페이지</span></a>
                        <%} %>
                    </li>
                </ul>

            </div>

        </div>

	</div>

</body>
</html>