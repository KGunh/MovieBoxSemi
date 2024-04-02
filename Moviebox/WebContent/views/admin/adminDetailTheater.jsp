<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,java.util.ArrayList,com.kh.theater.model.vo.Screen,com.kh.theater.model.vo.Theater,java.text.SimpleDateFormat,java.util.Date"%>
<%
	List<Screen> screenList = (ArrayList)request.getAttribute("screenList");
    
    Theater th = (Theater)request.getAttribute("theater");

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date currentDate = new Date();


%>    
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <style>
        div{
            border: 1px solid red;
        }
        
        div{
           /* border : 1px solid red;  */
            box-sizing : border-box;
        }

        /* 전체를 감싸는 #wrap div */
        #wrap{
            /*width: 1200px;*/
            margin: 0 auto;
            /*border : 1px solid red;*/
        }

        #top_wrap{
            width: 1200px;
            height : 150px;
            margin: 0 auto;
            background-color: #212121;
        }

        .top_1{
            display: inline-block;
            width: 200px;
            height: 150px;
            background-color: #212121;
        }



        #content{
            width: 1200px;
            height : 800px;
            margin: 0 auto;


        }

        .content_1{
            display: inline-block;
            vertical-align: top;
            width : 200px;
            height : 800px;
            padding-top: 20px;
            background-color: #323232;


        }

        .content_2{
            display: inline-block;
            vertical-align: top;
            width : 880px;
            height : 800px;
            padding:20px 20px 40px 20px;

        }



        .menu {
            width: 200px;
            overflow: hidden;
            margin: 20px auto;
            padding: 0%;
            
        }

        .menu > li {
            width: 198px;
            text-align: center; /*텍스트 중앙에 배치*/
            line-height: 40px;
            background-color: #323232;
            list-style: none;

        }


        .menu a {
            color: #fff;
            text-decoration: none;
            font-weight: bold;
            display : block; /* 인라인 요소를 블럭요소로 바꿔줌 */
        }

        .menu a:hover {
            color: #1a1a1a;
            text-decoration: none;
            
        }


        .submenu > li { /*게시글관리 - 공지관리/문의 게시글 관리*/
            line-height: 50px;
            background-color: #FFC145;
            list-style: none;
            
        }

        .submenu {
            height: 0; /*ul의 높이를 안보이게 처리*/
            overflow: hidden;
            
        }

        .menu > li:hover {
            background-color: #FFC145;
            transition-duration: 0.5s;
        }


        .menu > li.post:hover .submenu {
            height: 100px; /*서브메뉴 li한개의 높이 50*5*/
            transition-duration: 1s;
        }




        .top_1 > h1{
            color: #FFC145;
            text-align: center;
            line-height: 150px;
        }



        .menu .submenu{
            padding-left: 0;
        } 


        /*-----------------------여기까지는 테두리------*/


        /* -------------------------------------------*/

        #content_2_box { /*컨텐트2 전체 div*/
            width: 770px;
            height: 690px;
        }




        /* -------------------------------------------*/
        .date-area{
            width: 100%;
            height: 10%;
            text-align: center;
            padding: 20px;
            color: white;
        }
        .date-area input{
            width: 30%;
        }

        .screenList-area{
            width: 100%;
            height: 90%;
        }
        .screenList-area > div{
            width: 100%;
            height: 50%;
            padding: 5% 5% 0 5%;
            display:flex;
            justify-content: space-between;
            
        }
        .screenList-area > div > div{
            width: 30%;
            height: 100%;
            position: relative;
        }
        .screenList-title{
            position: absolute;
            color: white;
            font-size: 25px;
            top: -40px;
            left: 50%;
            transform: translate(-50%, 0%);
        }
        .screenList input{
            float: left;
            display: block;
            width: 50%;
        }



    </style>
</head>
<body>
	<!-- 헤더 -->
    <%@ include file="/views/common/header.jsp" %>

    <script>
        window.onload = function() {
            today = new Date();
            today = today.toISOString().slice(0, 10);
            bir = document.getElementById("todaybirthday");
            bir.value = today;
        }
    </script>
    <div id="wrap">


        <div id="top_wrap">
            <div class="top_1">
                <h1>관리자</h1>
            </div>

        </div>

        <div id="content">
            <div class="content_1">
                <ul class="menu">
                    <li>
                        <a href="<%=contextPath %>/selectAdmin.mb">회원 관리</a>
                        <ul class="submenu">

                        </ul>
                    </li>
                    <li>
                        <a href="<%=contextPath %>/adminScreenList.admin">예매 관리</a>
                        <ul class="submenu" >

                        </ul>
                    </li>
                    <li>
                        <a href="<%=contextPath %>/adminMovieCheck.admin?currentPage=1">영화 관리</a>
                        <ul class="submenu" >

                        </ul>
                    </li>
                    <li>
                        <a href="<%=contextPath%>/checkAdmin.cm">영화관 관리</a>
                        <ul class="submenu">

                        </ul>
                    </li> 
                    <li class="post">
                        <a href="#">게시글 관리</a>
                        <ul class="submenu">
                        <li><a href="<%=contextPath %>/adminBoardCheck.admin?currentPage=1">공지 관리</a></li>
                        <li><a href="<%=contextPath %>/adminQnACheck.admin?currentPage=1">문의 게시글 관리</a></li>
                        </ul>
                    </li>
                </ul>    
            </div>

            <!------------------------------------------------------------>

            <div class="content_2"><!--content_2 시작-->
                <div class="date-area">
                    <%= th.getTheaterName() %>
                    <input type="date" id="todaybirthday">
                </div>

                <div class="screenList-area">
                <%if(screenList != null) {%>
                
                    <div>
							                        
                        <div class="screenList">
                        
                            <div class="screenList-title">1관</div>
                            <div><input type="text"><input type="time" value=""></div>
                            <div><input type="text"><input type="time" value=""></div>
                            <div><input type="text"><input type="time" value=""></div>
                            <div><input type="text"><input type="time" value=""></div>
                            <div><input type="text"><input type="time" value=""></div>
                            <div><input type="text"><input type="time"></div>
                        </div>
                        <div></div>
                        <div></div>
                    </div>
                    <div>
                        
                        <div>
                            <div class="screenList-title">4관</div>
                        </div>
                        <div></div>
                        <div></div>
                    </div>
                <%} %>
                </div>
                



            </div><!--content_2끝-->
        </div>

    </div>
    <script>
        

    </script>

 	<%@ include file="/views/common/footer.jsp" %>
 	<!-- 푸터 -->
</body>
</html>