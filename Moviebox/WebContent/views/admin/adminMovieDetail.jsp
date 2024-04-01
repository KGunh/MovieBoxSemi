<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = " java.util.ArrayList, com.kh.movie.model.vo.Movie" 
    %>
<%
	Movie m =(Movie)request.getAttribute("movie");
	String c =(String)request.getAttribute("cast");
%>        
    
<!DOCTYPE html>
<html lang="en">
<head>
    <title>영화 상세페이지</title>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>




    <style>

        
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
            padding-left: 50px;
            padding-top: 20px;

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
            /* border : 1px solid rgb(255, 150, 79); */
        }


        #p{
            margin-top: 24px;
            margin-bottom: 30px;
            font-size: x-large;
            font-weight: bold;
            color: #ffffff;
        }  

        td{
            color: #ffffff;
        }

        /* -------------------------------------------*/

        #box_1     
        {
            /* border: 1px solid rgb(0, 255, 64); */
            width: 250px;
            height: 690px;
            float: left;
        }

        #box_2 {
            /* border: 1px solid rgb(82, 0, 158); */
            width: 500px;
            height: 370px;
            float: left;
        }

        #box_3 {
            /* border: 1px solid rgb(0, 190, 181); */
            width: 500px;
            height: 350px;
            float: left;
            padding-left: 7px;
        }

        #plotPage {
            /* border: 1px solid rgb(255, 39, 85); */
            width: 650px;
            height: 300px;
            float: left;

            padding-left: 7px;
            margin-left: 15px;
        }
  
        #postimg {
            /* border: 1px solid rgb(255, 238, 0); */
            width: 250px;
            height: 350px;
            float: left;
        }

        #plot{
            /* border: 1px solid rgb(109, 0, 235); */
            width: 750px;
            height: 300px;
            float: left;
            margin-top: 20px;
            padding-left: 20px;
        }

        #left {
            /* border: 1px solid rgb(0, 236, 39); */
            width: 150px;
            height: 350px;
            float: left;
        }

        #right{
            /* border: 1px solid rgb(255, 0, 0); */
            width: 340px;
            height: 350px;
            float: left;
        }

        #right_1,
        #right_2,
        #right_3,
        #right_4,
        #right_5,
        #right_6,
        #right_7{
            margin-top: 8px;
            /* border: 1px solid rgb(255, 0, 149); */
            width: 330px;
            height: 40px;
            float: left;

        }

        .right-control{
            width: 330px;
            height: 40px;
            border-radius: 8px;
            border: 1px solid lightgray;
            font-size: 15px;
            color: #727272;
        }

        .title_p{
            float: right;
            padding-right: 15px;
            font-size: 16px;
            font-weight: bold;
            line-height: 40px;
            color: #ffffff;
        }

        #left_1,
        #left_2,
        #left_3,
        #left_4,
        #left_5,
        #left_6,
        #left_7
        {
            margin-top: 8px;
            /* border: 1px solid rgb(255, 0, 149); */
            width: 150px;
            height: 40px;
            float: left;


        }

        #plotStyle {
            font-size: 17px; 
            font-weight: bold; 
            color: #ffffff;
            float: left;
            padding-top: 12px;
            padding-l: 10px;
        }

        #sub8plot{
            width: 640px;
            height: 240px;
            border-radius: 8px;
            border: 1px solid lightgray;
            font-size: 15px;
            margin-top: 9px;
            color: #727272;
            padding-left: 7px;
            padding-top: 7px;
            resize: none;
        }

        #button{
            margin-top: 4px;
            margin-right: 20px;
            
        }


    </style>
</head>
<body>
	<!-- 헤더 -->
    <%@ include file="/views/common/header.jsp" %>
    
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
                        <a href="<%=contextPath %>/adminMovieCheck.admin?currentPage=1">영화 관리</a>
                        <ul class="submenu">

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
                <p id="p">영화 관리 > 상세보기</p>


                <div id="content_2_box"><!--컨텐트2 전체박스-->
                    <div id="box_1">
                        <div id="postimg"><img style="width: 250px; height: 350px; border: 1px solid rgb(177, 177, 177);" src="/image/파묘.jpg"></div>
                        <div id="plot">
                            <p id="plotStyle">줄거리</p>
                            <div id="plotPage">
                                <textarea name="text" class="form-control" id="sub8plot" cols="30" rows="10" placeholder="줄거리를 입력해 주세요." readonly><%=m.getMovieStory() %></textarea>
                                <div id="button"><!--등록 버튼-->
                                    <button type="button" class="btn btn-warning" style="height: 30px; font-size: 12px; background-color: #FFC145; float: right; margin-right: 5px;">삭제</button>
                                    <button type="button" class="btn btn-warning" style="height: 30px; font-size: 12px; background-color: #FFC145; float: right; margin-right: 5px;">수정</button>
                                    <button type="button" class="btn btn-warning" style="height: 30px; font-size: 12px; background-color: #FFC145; float: right; margin-right: 5px;">목록</button>
                                </div><!--등록 버튼-->
                            </div>
                        </div>
                    </div><!--box_1 끝-->
                    


                    <div id="box_2">
                        <div id="box_3">
                            <div id="left">
                                <div id="left_1">
                                    <p class="title_p">제목</p>
                                </div>

                                <div id="left_2">
                                    <p class="title_p">장르</p>
                                </div>

                                <div id="left_3">
                                    <p class="title_p">러닝타임</p>
                                </div>

                                <div id="left_4">
                                    <p class="title_p">관람등급</p>
                                </div>

                                <div id="left_5">
                                    <p class="title_p">개봉일</p>
                                </div>

                                <div id="left_6">
                                    <p class="title_p">감독</p>
                                </div>

                                <div id="left_7">
                                    <p class="title_p">출연진</p>
                                </div>
                            </div>



                            <div id="right">
                                <div id="right_1">
                                    <input type="text" class="form-control" name='title' value="<%= m.getMovieTitle() %>" readonly>
                                </div>    

                                <div id="right_2">
                                    <input type="text" class="form-control" name='title' value="<%= m.getGenreName() %>" readonly>
                                </div>    

                                <div id="right_3">
                                    <input type="text" class="form-control" name='title' value="<%= m.getMovieRt() %>" readonly>
                                </div>    

                                <div id="right_4">
                                    <input type="text" class="form-control" name='title' value="<%= m.getMovieRated() %>" readonly>
                                </div>    

                                <div id="right_5">
                                    <input type="text" class="form-control" name='title' value="<%= m.getMovieRelease()%>" readonly>
                                </div>    

                                <div id="right_6">
                                    <input type="text" class="form-control" name='title' value="<%= m.getDirectorName()%>" readonly>
                                </div>    

                                <div id="right_7">
                                    <input type="text" class="form-control" name='title' value="<%= c %>" readonly>
                                </div>    
                            
                            </div>

                        </div><!--box_3 끝-->


                    </div><!--box_2 끝-->
                    





                </div><!--컨텐트2 전체박스 끝-->




            </div><!--content_2끝-->
        </div>

    </div>
     	<%@ include file="/views/common/footer.jsp" %>
 		<!-- 푸터 -->

</body>
</html>