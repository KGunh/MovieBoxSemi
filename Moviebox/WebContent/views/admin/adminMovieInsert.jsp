<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화관리 → 영화등록</title>

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
 			/* border : 1px solid red;  */
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

        /* -------------------------------------------*/

        
        .title{
            /* border: 1px solid rgb(172, 0, 0); */
            width: 170px;
            height: 60px;
            font-size: 15px;
            font-weight: bold;
            line-height: 60px;
            color:#ffffff;
            text-align: right;
            padding-right: 30px;
        }


        #box_1     
        {
            /* border: 1px solid rgb(245, 191, 229); */
            width: 170px;
            height: 690px;
            float: left;
        }

        #box_2 {
            /* border: 1px solid rgb(0, 16, 158); */
            width: 580px;
            height: 690px;
            float: left;
        }

        #sub_1 {
            /* border: 1px solid rgb(0, 236, 39); */
            width: 580px;
            height: 60px;
            float: left;
        }

        #sub_2 {
            /* border: 1px solid rgb(0, 155, 216); */
            width: 580px;
            height: 60px;
            float: left;
        }

        #sub_3 {
            /* border: 1px solid rgb(223, 145, 0); */
            width: 580px;
            height: 60px;
            float: left;
        }

        #sub_4 {
            /* border: 1px solid rgb(223, 0, 93); */
            width: 580px;
            height: 60px;
            float: left;
        }

        #sub_5 {
            /* border: 1px solid rgb(255, 57, 255); */
            width: 580px;
            height: 60px;
            float: left;
        }
        #sub_6 {
            /* border: 1px solid rgb(34, 156, 255); */
            width: 580px;
            height: 60px;
            float: left;
        }
        #sub_7 {
            /* border: 1px solid rgb(63, 243, 78); */
            width: 580px;
            height: 60px;
            float: left;
        }

        #sub_8 {
            /* border: 1px solid rgb(63, 111, 243); */
            width: 580px;
            height: 60px;
            float: left;
        }

        #sub_9 {
            /* border: 1px solid rgb(236, 193, 0); */
            width: 580px;
            height: 160px;
            float: left;
        }

        #sub_10{
            /* border: 1px solid rgb(63, 111, 243); */
            width: 530px;
            height: 60px;
            float: left;
        }


        /*-------------------------------------------------------*/
        #file {
            display: none;
            display: inline;
            float: left;
            color:#ffffff;
        }

        .fileBox{ /*파일선택버튼*/
            width: 135px;
            height: 40px;
            float: left;
            line-height: 40px;
        }
        
        .fileBox_2{/*파일명 박스*/
            border: 1px solid lightgray;
            width: 400px;
            height: 40px;
            float: left;
            margin-top: 10px;
            border-radius: 8px;
        }
        input[type=file]::file-selector-button {
            width: 130px;
            height: 40px;
            background-color: #FFC145;
            border: 1px solid lightgray;;
            border-radius: 8px;
            cursor: pointer;
            margin-top: 10px;
            text-align: center;
        }

        /*---------------------------------------*/


        #movieTitle, /*제목입력창*/
        #runningTime, /*러닝타임입력창*/
        #rating, /*관람등급입력창*/
        #director,/*감독입력창*/
        #cast /*출연진입력창*/
        { 
            width: 533px;
            height: 40px;
            border-radius: 8px;
            border: 1px solid lightgray;
            font-size: 15px;
            margin-top: 9px;
            color: #727272;
        }

        #plot{ /*줄거리 입력창*/
            width: 533px;
            height: 140px;
            border-radius: 8px;
            border: 1px solid lightgray;
            font-size: 15px;
            margin-top: 9px;
            color: #727272;
            padding-left: 7px;
            padding-top: 7px;
            resize: none;
            
        }

        #select_1{ /*장르셀렉박스1*/
            border: 1px solid gainsboro;
            border-radius: 8px;
            width: 256px;
            height: 40px;
            font-size: 15px;
            margin-top: 9px;
            margin-right: 14px;
            color: #727272;
            padding-left: 7px;

        }

        #select_2{ /*장르셀렉박스2*/
            border: 1px solid gainsboro;
            border-radius: 8px;
            width: 256px;
            height: 40px;
            font-size: 15px;
            margin-top: 9px;
            color: #727272;
            padding-left: 7px;
        }

        #date{ /*개봉일 선택창*/
            width: 533px;
            height: 40px;
            border-radius: 8px;
            border: 1px solid lightgray;
            font-size: 15px;
            margin-top: 9px;
            color: #727272;
            padding-left: 7px;
        }

        input::placeholder{
            padding-left: 7px;
            
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
                        <a href="#">회원 관리</a>
                        <ul class="submenu">

                        </ul>
                    </li>
                    <li>
                        <a href="<%=contextPath %>/adminMovieCheck.admin">영화 관리</a>
                        <ul class="submenu" >

                        </ul>
                    </li>
                    <li>
                        <a href="#">영화관 관리</a>
                        <ul class="submenu">

                        </ul>
                    </li> 
                    <li class="post">
                        <a href="#">게시글 관리</a>
                        <ul class="submenu">
                        <li><a href="<%=contextPath %>/adminBoardDetail.admin">공지 관리</a></li>
                        <li><a href="#">문의 게시글 관리</a></li>
                        </ul>
                    </li>
                </ul>    
            </div>

            <!------------------------------------------------------------>

            <div class="content_2"><!--content_2 시작-->
                <p id="p">영화 관리 > 영화 등록</p>

            <form>
                <div id="content_2_box"><!--컨텐트2 전체박스-->
                    <div id="box_1">
                        <div class="title">포스터</div>
                        <div class="title">제목</div>
                        <div class="title">장르</div>
                        <div class="title">러닝타임</div>
                        <div class="title">관람등급</div>
                        <div class="title">개봉일</div>
                        <div class="title">감독</div>
                        <div class="title">출연진</div>
                        <div class="title">줄거리</div>
                    </div>
                    <div id="box_2">
                        <div id="sub_1">
                            <div class="fileBox">
                                <input type="file" name="file" id="file">
                            </div>
                            <div class="fileBox_2"></div>
                        </div>

                        
                        <div id="sub_2">
                            <input type="text" id="movieTitle" placeholder="영화 제목을 입력해 주세요.">
                        </div>

                        <div id="sub_3">
                            <select name="#" id="select_1" >
                                <option value="">장르</option>
                                <option value="">액션</option>
                                <option value="">로맨스</option>
                                <option value="">공포/스릴러</option>
                                <option value="">코미디</option>
                                <option value="">애니메이션</option>
                            </select>
                            <select name="#" id="select_2" >
                                <option value="">장르2</option>
                                <option value="">액션</option>
                                <option value="">로맨스</option>
                                <option value="">공포/스릴러</option>
                                <option value="">코미디</option>
                                <option value="">애니메이션</option>
                            </select>
                        </div>

                        <div id="sub_4">
                            <input type="text" id="runningTime" placeholder="러닝타임을 입력해 주세요.">
                        </div>

                        <div id="sub_5">
                            <input type="text" id="rating" placeholder="관람 등급을 입력해 주세요.">
                        </div>

                        <div id="sub_6">
                            <input type="date" name="date" id="date">
                        </div>

                        <div id="sub_7">
                            <input type="text" id="director" placeholder="감독을 입력해 주세요.">
                        </div>

                        <div id="sub_8">
                            <input type="text" id="cast" placeholder="출연진을 입력해 주세요.">
                        </div>

                        <div id="sub_9">
                            <textarea name="text" id="plot" cols="30" rows="10" placeholder="줄거리를 입력해 주세요."></textarea>
                        </div>

                        <div id="sub_10"><!--등록 버튼-->
                            <button type="button" class="btn btn-warning" style="height: 30px; font-size: 12px; background-color: #FFC145; float: right;">등록</button>
                        </div><!--등록 버튼-->










                    </div><!--box2-->
                    





                </div><!--컨텐트2 전체박스 끝-->
            </form>



            </div><!--content_2끝-->
        </div>

    </div>


	 <%@ include file="/views/common/footer.jsp" %>
 	<!-- 푸터 -->


</body>
</html>