<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.kh.theater.model.vo.*, java.util.ArrayList,
				 com.kh.movie.model.vo.*, com.kh.common.model.vo.*" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<%
	ArrayList<Movie> movies = (ArrayList<Movie>)request.getAttribute("movie");
	ArrayList<Attachment> attachment = (ArrayList<Attachment>)request.getAttribute("attachment");
	Theater theater = (Theater)request.getAttribute("theater");
	
	System.out.println("theater : " + theater);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화관 정보</title>

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
            font-size: 15px;
        }
        

        /* 영화관 안내 전체 박스 */
        #theater-header{
            margin-top: 30px;
            margin-bottom: 30px;
            padding-bottom: 30px;
            color: #1A1A1A;
            border-bottom: 1px solid #8A8A8A;
        }

        #theater-content{
            color: #a7a7a7;
        }

        /* 항목별 글씨 */
		#theaterTitle{
			font-size: 35px;
			color: #FFC145;
			font-weight: bold;
		}
		
		#theaterSubTitle1{
			font-size: 30px;
			color: white;
			font-weight: bold;
		}
		
		#theaterSubTitle2{
			font-size: 30px;
			color: white;
			font-weight: bold;
		}
		
		/* 조회 결과 없을 때 */
        #noMovieList{
        	width:1200px;
        	height: 500px;
        	text-align: center;
        	line-height: 490px;
        }
        
        #noMovie{
        	width: 1200px;
        	font-size: 20px;
        	text-align: center;
        	color:white;
        }
		
        /* 현재 상영작 목록 */
        #movie-content-body{
            width: 1200px;
            height: auto;
            margin-top: 30px;
            margin-bottom: 30px;
        }

        .movie-content{
            width: 235px;
            height: auto;
            color: white;
            display: inline-block;
            margin-bottom: 20px;
            border: 1px solid #383838;
            padding-bottom: 10px;
        }

        .movie-conten1{
            width: 1200px;
        }

        .movie-list-img{
            height: 300px;
        }

        .movie-list-title{
            height: 70px;
            text-align: center;
            font-size: 20px;
            font-weight: bold;
            padding-top: 6px;
            color: white;
        }

        #movie-content-btn1{
        	width: 100px;
        	height: 35px;
        	float:left;
            margin-right: 10px;
            margin-left: 10px;
            border-radius: 8px;
            background-color: white;
            text-align: center;
            line-height: 32px;
        }
        
        #detailbtn{
        	text-decoration: none;
        	color: black;
        	font-size: 15px;
        	font-weight: bold;
        	display: block;
        }

        #movie-content-btn2{
            width: 100px;
            height: 35px;
            border-radius: 8px;
            background-color: #FFC145;
            font-weight: bold;
            font-size: 15px;
            border: none;
        }

        .movie-conten1{
            height: 400px;
            margin-top: 20px;
        }

        /* 오시는 길 */
        #theater-map{
            width: 1200px;
            border-top: 1px solid #8A8A8A;
            padding-top: 25px;
            margin-top: 30px;
            color: #a7a7a7;;
        }

        #detail-map{
            padding-bottom: 20px;
            margin-top: 30px;
        }
        
        #theater-address{
        	margin-top: 20px;
        	margin-bottom: 30px;	
        	font-size: 20px;
        }
        
        #theater-mapLink{
        	margin-top: 20px;
        	margin-bottom: 50px;
        }
        
        #theaterAddress{
        	color: #cccccc;
        	font-size: 18px;
        }
        
    </style>
    
</head>
<body>
<%@ include file="../common/header.jsp" %>

    <div id="wrap">

        <!-- 영화관 안내 전체 박스 -->
        
        <c:choose>
        	<c:when test="${ theater.theaterName eq null }">
				<div id="noMovieList">
					<a id="noMovie">조회 된 영화관이 없습니다.</a>
				</div>
       	 	</c:when>
       	 	<c:otherwise>
        <div id="theater-header">
                <a id="theaterTitle"><%= theater.getTheaterName() %></a>
            <div id="theater-content">
                <!-- <a>총 상영관 수 : 10개 관 </a> | <a>총 좌석수 : 1785석 </a> -->
            </div>
        </div>

        <!-- 현재 상영작 -->
        <div id="theater-movie-now">
            <a id="theaterSubTitle1">현재 상영작</a>
            <!-- 현재 상영작 목록 -->
            
            <div id="movie-content-body">
                <% for(Movie m : movies) { %>
               <!-- <div class="movie-conten1"> -->
                
                    <div class="movie-content">
                    <input type="hidden" id="inputId" name="movieNo" value="<%= m.getMovieNo()%>" />
                    	
                        <div class="movie-list-img">
                        <img src="<%= m.getFilePath() %>/<%= m.getChangeName() %>" width="232" height="300"> </div>
                    
                        <div class="movie-list-title"><%= m.getMovieTitle() %></div>
                        
                        <div id="movie-content-btn1"><a href="<%=contextPath%>/detail.movie?movieNo=<%= m.getMovieNo()%>" id="detailbtn">상세정보</a></div>
	                    <% if(loginUser == null) { %>
	                    	<button id="movie-content-btn2" onclick="noMember();">예매하기</button>
	                	<%} else { %>
	                		<button id="movie-content-btn2" onclick="reservationPage();">예매하기</button>
	                	<% } %>
                        <%--<button id="movie-content-btn2">예매하기</button> --%>
                    </div>
				<% } %>
            </div>
        </div>

        <!-- 오시는 길 -->
        <div id="theater-map">
            <a id="theaterSubTitle2">오시는 길</a>
            <div id="theater-address">
                <a id="theaterAddress"><%= theater.getTheaterAddr() %></a>
            </div>
            <div id="theater-mapLink"><iframe src="<%= theater.getMapLink() %>"></iframe></div>
        </div>

    </div> <!-- wrap -->
		</c:otherwise>
	</c:choose>



<%@ include file="../common/footer.jsp" %>

        
    <script>
		function noMember(){
			location.href = ('<%=contextPath%>/loginForm.me');
			alert('로그인이 필요한 서비스 입니다.');
		}
    	// 예매하기 버튼 -> 예매 페이지
    	function reservationPage(){
    		location.href = '<%= contextPath %>/movie.reservation';
    	}

   // var movieNo = $(this).siblings('input[type="hidden"]').val();
   // location.href = '< %=contextPath%>/detail.movie?movieNo=' + movieNo;
  //	  });

	</script>
    
</body>
</html>