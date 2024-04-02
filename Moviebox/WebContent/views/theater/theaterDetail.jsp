<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.kh.theater.model.vo.*, java.util.ArrayList" %>
    
<%
	ArrayList<Theater> list = (ArrayList<Theater>)request.getAttribute("theaterList");
	Theater theater = (Theater)request.getAttribute("theater");
	System.out.println(list);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

    <style>
        body{
            background-color: #1A1A1A;
            color: white;
        }

        div{
            /* border: 1px solid red; */
            box-sizing: border-box;
        }

        #wrap{
            width: 1200px;
            margin: 0 auto;
        }

        h1{
            padding-left: 5px;
            color: white;
        }


        /* 영화관 안내 전체 박스 */
        #theater-header{
            /*border: 1px solid salmon;*/
            margin-top: 30px;
            margin-bottom: 30px;
            padding-bottom: 30px;
            color: #1A1A1A;
            
        }

        #theater-content{
            color: #a7a7a7;
        }

        /* 현재 상영작 */


        
        /* 현재 상영작 목록 */
        .movie-content-body{
            width: 100%;
            height: auto;
            /* border: 4px solid red; */
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
            /*border: 1px solid seagreen;*/
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

        /* 오시는 길 */
        #theater-map{
            width: 1200px;
            /*border: 1px solid darkcyan;*/
            margin-top: 40px;
            color: #a7a7a7;;
        }

        #detail-map{
            padding-bottom: 20px;
            margin-top: 30px;
        }
        
    </style>
    
</head>
<body>
<%@ include file="../common/header.jsp" %>

    <div id="wrap">

        <!-- 영화관 안내 전체 박스 -->
        <div id="theater-header">
                <h1><%=  %></h1>
            <div id="theater-content">
                <!-- <a>총 상영관 수 : 10개 관 </a> | <a>총 좌석수 : 1785석 </a> -->
            </div>
        </div>

        <!-- 현재 상영작 -->
        <div id="theater-movie-now">
            <h1>현재 상영작</h1>
            <!-- 현재 상영작 목록 -->
            
            <div class="movie-content-body">

			
                <div class="movie-conten1">
                
            <% if(list.isEmpty()) { %>
				<a style="color: white;">등록된 영화가 존재하지 않습니다.</a> <br>
			<% } else { %>
			
                <% for(Theater m : list) { %>
                    <div class="movie-content">
                        <div class="movie-list-img"> 포스터 </div>
                        <div class="movie-list-title"> 영화 타이틀 </div>
                        <button id="movie-content-btn1">상세정보</button>
                        <button id="movie-content-btn2">예매정보</button>
                    </div>
                 <% } %>
             <% } %>
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
        </div>

        <!-- 오시는 길 -->
        <div id="theater-map">
            <h1>오시는 길</h1>
            <div id="theater-address">
                <a>서울특별시 중구 남대문로 120 그레이츠청계(구 대일빌딩) 2F</a>
            </div>
            <iframe id="detail-map" src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3162.454015026758!2d126.98046087561355!3d37.567925424048944!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357ca2eee632d73f%3A0x15cc2733ad91fd28!2zS0gg7KCV67O06rWQ7Jyh7JuQ!5e0!3m2!1sko!2skr!4v1710829514237!5m2!1sko!2skr" width="1200" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
        </div>




    </div> <!-- wrap -->

<%@ include file="../common/footer.jsp" %>
    
</body>
</html>