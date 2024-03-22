<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <style>
        body{
            background-color: #1A1A1A;
        }

        div{
            /* border: 1px solid red; */
            box-sizing: border-box;
        }

        .wrap{
            width: 1200px;
            margin: 0 auto;
        }

        /* 영화 리스트 전체 감싸는 div */
        .movie-list{
            width: 1200px;
            height: auto;
            margin: 0 auto;
            position: relative;
        }

        .movie-list-header{
            width: 100%;
            height: 100px;
            margin-top: 20px;
        }

        #movie-list-category{
            width: 80%;
            height: 100px;
            left: 0;
            position: absolute;
            padding-top: 13px;
        }

        .movie-list-genre{
            width: 70px;
            height: 70px;
            color: white;
            text-align: center;
            font-size: 20px;
            font-weight: bold;
            float: left;
            padding-top: 20px;
        }

        .movie-list-genre1{
            width: 120px;
            height: 70px;
            color: white;
            text-align: center;
            font-size: 20px;
            font-weight: bold;
            float: left;
            padding-top: 20px;
        }

        .movie-list-genre:hover{
            background-color: #FFC145;
            border-radius: 25px;
            color: #1A1A1A;
            font-weight: bold;
        }

        .movie-list-genre1:hover{
            background-color: #FFC145;
            border-radius: 25px;
            color: #1A1A1A;
            font-weight: bold;        
        }

        /* 정렬 / 검색창 */
        #searchalign{
            width: 250px;
            height: 100px;
            position: absolute;
            right: 0;
            padding-top: 13px;
            color: #808080;
        }

        .align-a{
            color: white;
            cursor: pointer;
            font-size: 15px;
            text-decoration: none;
        }

        .align-a:hover{
            color: #FFC145;
            text-decoration: none;
        }

        #movie-list-search{
            width: 180px;
            height: 27px;
            border-radius: 7px;
            margin-right: 7px;
            margin-top: 10px;
        }
        
        #search-img{
            width: 30px;
            margin-left: 5px;
            margin-right: 5px;
            margin-top: 10px;
            float: left;
        }

        #search-img > img{
            width: 30px;
            height: 30px;
        }

        #movie-list-input::placeholder{
            padding-left: 7px;
            font-size: 15px;
        }

        /* 영화 목록 부분 */
        .movie-content-body{
            width: 100%;
            height: auto;
        }

        .movie-content{
            width: 230px;
            height: 400px;
            float: left;
            margin-left: 7px;
            color: white;
            border: 1px solid pink;
        }

        .movie-list-img{
            height: 300px;
        }

        .movie-list-title{
            height: 50px;
            border: 1px solid seagreen;
            text-align: center;
            font-size: 23px;
            font-weight: bold;
            padding-top: 6px;
            color: white;
        }

        #movie-content-btn1{
            width: 100px;
            height: 35px;
            margin-right: 10px;
            margin-left: 5px;
            border-radius: 8px;
            font-weight: bold;
            font-size: 15px;
        }

        #movie-content-btn2{
            width: 100px;
            height: 35px;
            border-radius: 8px;
            background-color: #FFC145;
            font-weight: bold;
            font-size: 15px;
        }

        .movie-conten1{
            height: 400px;
            margin-top: 20px;
        }

    </style>
</head>
<body>
    <%@ include file="/views/common/header.jsp" %>
    
    <div id="wrap">
 
        <div class="movie-list">

            <div class="movie-list-header">
            <!-- 카테고리 시작 -->
                <div id="movie-list-category">
                    <div class="movie-list-genre">전체</div>
                    <div class="movie-list-genre">액션</div>
                    <div class="movie-list-genre">로맨스</div>
                    <div class="movie-list-genre1">공포/스릴러</div>
                    <div class="movie-list-genre">코미디</div>
                    <div class="movie-list-genre1">애니메이션</div>
                </div>

                <!-- 정렬 / 검색창 -->
                <div id="searchalign">
                    <div id="movie-list-align">
                        <a class="align-a">예매순</a> | <a class="align-a">가나다순</a>
                    </div>

                     <div id="search-img">
                       <img src="<%= contextPath %>/resource/img/search.PNG" alt="검색 아이콘">
                    </div>
                    <div id="movie-list-input">
                        <input type="text" id="movie-list-search" placeholder="검색창">
                    </div>
                </div>
            </div> <!-- movie-list-header -->

            <div class="movie-content-body">

                <div class="movie-conten1">
                    <div class="movie-content">
                        <div class="movie-list-img"> 포스터 </div>
                        <div class="movie-list-title"> 영화 타이틀 </div>
                        <button id="movie-content-btn1" onclick="detailPage();">상세정보</button>
                        <button id="movie-content-btn2">예매정보</button>
                    </div>

                    <div class="movie-content">
                        <div class="movie-list-img"> 포스터 </div>
                        <div class="movie-list-title"> 영화 타이틀 </div>
                        <button id="movie-content-btn1">상세정보</button>
                        <button id="movie-content-btn2">예매정보</button>
                    </div>

                    <div class="movie-content">
                        <div class="movie-list-img"> 포스터 </div>
                        <div class="movie-list-title"> 영화 타이틀 </div>
                        <button id="movie-content-btn1">상세정보</button>
                        <button id="movie-content-btn2">예매정보</button>
                    </div>

                    <div class="movie-content">
                        <div class="movie-list-img"> 포스터 </div>
                        <div class="movie-list-title"> 영화 타이틀 </div>
                        <button id="movie-content-btn1">상세정보</button>
                        <button id="movie-content-btn2">예매정보</button>
                    </div>

                    <div class="movie-content">
                        <div class="movie-list-img"> 포스터 </div>
                        <div class="movie-list-title"> 영화 타이틀 </div>
                        <button id="movie-content-btn1">상세정보</button>
                        <button id="movie-content-btn2">예매정보</button>
                    </div>
                </div>

                <div class="movie-conten1">
                    <div class="movie-content">
                        <div class="movie-list-img"> 포스터 </div>
                        <div class="movie-list-title"> 영화 타이틀 </div>
                        <button id="movie-content-btn1">상세정보</button>
                        <button id="movie-content-btn2">예매정보</button>
                    </div>

                    <div class="movie-content">
                        <div class="movie-list-img"> 포스터 </div>
                        <div class="movie-list-title"> 영화 타이틀 </div>
                        <button id="movie-content-btn1">상세정보</button>
                        <button id="movie-content-btn2">예매정보</button>
                    </div>

                    <div class="movie-content">
                        <div class="movie-list-img"> 포스터 </div>
                        <div class="movie-list-title"> 영화 타이틀 </div>
                        <button id="movie-content-btn1">상세정보</button>
                        <button id="movie-content-btn2">예매정보</button>
                    </div>

                    <div class="movie-content">
                        <div class="movie-list-img"> 포스터 </div>
                        <div class="movie-list-title"> 영화 타이틀 </div>
                        <button id="movie-content-btn1">상세정보</button>
                        <button id="movie-content-btn2">예매정보</button>
                    </div>

                    <div class="movie-content">
                        <div class="movie-list-img"> 포스터 </div>
                        <div class="movie-list-title"> 영화 타이틀 </div>
                        <button id="movie-content-btn1">상세정보</button>
                        <button id="movie-content-btn2">예매정보</button>
                    </div>
                </div>

                <div class="movie-conten1">
                    <div class="movie-content">
                        <div class="movie-list-img"> 포스터 </div>
                        <div class="movie-list-title"> 영화 타이틀 </div>
                        <button id="movie-content-btn1">상세정보</button>
                        <button id="movie-content-btn2">예매정보</button>
                    </div>

                    <div class="movie-content">
                        <div class="movie-list-img"> 포스터 </div>
                        <div class="movie-list-title"> 영화 타이틀 </div>
                        <button id="movie-content-btn1">상세정보</button>
                        <button id="movie-content-btn2">예매정보</button>
                    </div>

                    <div class="movie-content">
                        <div class="movie-list-img"> 포스터 </div>
                        <div class="movie-list-title"> 영화 타이틀 </div>
                        <button id="movie-content-btn1">상세정보</button>
                        <button id="movie-content-btn2">예매정보</button>
                    </div>

                    <div class="movie-content">
                        <div class="movie-list-img"> 포스터 </div>
                        <div class="movie-list-title"> 영화 타이틀 </div>
                        <button id="movie-content-btn1">상세정보</button>
                        <button id="movie-content-btn2">예매정보</button>
                    </div>

                    <div class="movie-content">
                        <div class="movie-list-img"> 포스터 </div>
                        <div class="movie-list-title"> 영화 타이틀 </div>
                        <button id="movie-content-btn1">상세정보</button>
                        <button id="movie-content-btn2">예매정보</button>
                    </div>
                </div>

                <div class="movie-conten1">
                    <div class="movie-content">
                        <div class="movie-list-img"> 포스터 </div>
                        <div class="movie-list-title"> 영화 타이틀 </div>
                        <button id="movie-content-btn1">상세정보</button>
                        <button id="movie-content-btn2">예매정보</button>
                    </div>

                    <div class="movie-content">
                        <div class="movie-list-img"> 포스터 </div>
                        <div class="movie-list-title"> 영화 타이틀 </div>
                        <button id="movie-content-btn1">상세정보</button>
                        <button id="movie-content-btn2">예매정보</button>
                    </div>

                    <div class="movie-content">
                        <div class="movie-list-img"> 포스터 </div>
                        <div class="movie-list-title"> 영화 타이틀 </div>
                        <button id="movie-content-btn1">상세정보</button>
                        <button id="movie-content-btn2">예매정보</button>
                    </div>

                    <div class="movie-content">
                        <div class="movie-list-img"> 포스터 </div>
                        <div class="movie-list-title"> 영화 타이틀 </div>
                        <button id="movie-content-btn1">상세정보</button>
                        <button id="movie-content-btn2">예매정보</button>
                    </div>

                    <div class="movie-content">
                        <div class="movie-list-img"> 포스터 </div>
                        <div class="movie-list-title"> 영화 타이틀 </div>
                        <button id="movie-content-btn1">상세정보</button>
                        <button id="movie-content-btn2">예매정보</button>
                    </div>
                </div>
            </div>
            
            <script>
            function detailPage(){
            	
            	location.href = '<%= contextPath %>/views/movie/movieDetail.jsp';
            }
            
            </script>
            


        </div> <!-- movie-list -->
    </div> <!-- wrap -->
    
    
	<%@ include file="/views/common/footer.jsp" %>
    
</body>
</html>