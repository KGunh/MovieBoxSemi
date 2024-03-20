<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%


	String contextPath = request.getContextPath();
	
	String alertMsg = (String)session.getAttribute("alertMsg");
	
	//로그인 성공 전 null
	// 		    후 메시지문구
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>헤더</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    <style>
        * {
            box-sizing: border-box;
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
	<div class="header">
		<div class="header-line">
			<div class="top-header">
				<div class="login-area">
					<a href="#" class="member">회원가입</a>
                	<a href="#" class="member">로그인</a>
				</div>
			</div>
		</div>
		<div id="header-navigator">
            <div id="logo-div">
                <div id="logo"><a href="<%=contextPath %>"><img class="img-concert" src="<%=contextPath%>/resource/img/4.png"/></a></div>
            </div>
            <div id="navigator">
                <!-- A grey horizontal navbar that becomes vertical on small screens -->
                <ul class="nav">
                    <li class="nav-item">
                        <a class="nav-link" href="<%=contextPath %>"><span>예매</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<%=contextPath %>"><span>영화</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<%=contextPath %>/Theater.search"><span>영화관</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<%=contextPath %>"><span>고객센터</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<%=contextPath %>"><span>마이페이지</span></a>
                    </li>
                </ul>

            </div>

        </div>

	</div>

</body>
</html>