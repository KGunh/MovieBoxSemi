<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.ArrayList, com.kh.movie.model.vo.*" %>

<%
	ArrayList<Movie> list = (ArrayList<Movie>)request.getAttribute("movieList");
	Movie movie = (Movie)request.getAttribute("movie");
	String cast = (String)request.getAttribute("cast");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 상세정보</title>

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

        /* 전체 컨텐츠 영역 */
        #movie-detail{
            width: 1200px;
            margin: 0 auto;
            color: white;
        }


        /* 영화 상세정보(줄거리 등) */
        #movie-detail-box{
            width: 1200px;
            height: 470px;
            margin-top: 20px;
            color: white;
            position: relative;
        }

        #movie-detail-poster{
            position: absolute;
            width: 300px;
            height: 422px;
            left: 0;
            margin: 20px;
        }

        #movie-detail-content{
            position: absolute;
            width: 850px;
            right: 0;
            padding: 10px;
            margin: 20px;
        }

        #movie-detail-title{
            width: 830px;
            height: 60px;
            line-height: 60px;
            font-size: 25px;
            font-weight: bold;
            padding-left: 10px;
        }

        #movie-detail-etc{
            width: 830px;
            height: 40px;
            line-height: 40px;
            padding-left: 10px;
            margin-bottom: 15px;
        }

        #movie-detail-director{
            width: 830px;
            height: 40px;
            line-height: 40px;
            padding-left: 10px;
        }

        #movie-detail-actor{
            width: 830px;
            height: 40px;
            line-height: 40px;
            margin-bottom: 15px;
            padding-left: 10px;
        }

        #movie-detail-story{
            width: 830px;
            height: 130px;
            padding: 10px;
            margin-bottom: 15px;
        }

        #movie-detail-btn{
            width: 300px;
            height: 45px;
            border: none;
            border-radius: 8px;
            font-size: 19px;
            font-weight: bold;
            background-color: #FFC145;
        }


        /* 영화 예고편 */
        #movie-detail-video{
            width: 1200px;
            margin-top: 20px;
        }

        h1{
            padding-left: 20px;
        }

        #detail-video{
            width: 1100px;
            padding-left: 50px;
        }

        /* 영화 스틸컷*/
        #movie-detail-still{
            width: 1200px;
            height: 630px;
            color: pink;
            border: 1px solid pink;
        }

        #detail-still-img{
            width: 1100px;
            height: 500px;
            margin: 0 auto;
            padding: 25px;
            border: 1px solid darkorange;
            padding-left: 45px;
        }

        .still-img{
            width: 321px;
            height: 450px;
            border: 1px solid salmon;
            float: left;
            margin-right: 20px;
        }
        
        #video-src{
        	margin-bottom: 30px;
        	padding-top: 20px;
        	padding-bottom: 20px;
        }
        
        #youtube{
        	margin-top: 20px;
        	font-size: 30px;
        	color: white;
        	font-weight: bold;
        }


    </style>
    
</head>
<body>

<body>

    <%@ include file="/views/common/header.jsp" %>

    <div id="wrap">
        <div id="movie-detail">
            <div id="movie-detail-box">
            
           
            
                <div id="movie-detail-poster">
                    <img src="<%= movie.getFilePath() %>/<%= movie.getChangeName() %>" width="300" height="422">
                    
                </div>

                <div id="movie-detail-content">
                    <div id="movie-detail-title"><%= movie.getMovieTitle() %></div>
                    <div id="movie-detail-etc">
                        <a><%= movie.getGenreName() %></a> | <a><%= movie.getMovieRt() %>분</a> | <a><%= movie.getMovieRated() %>이상 관람가</a> | <a><%= movie.getMovieRelease() %> 개봉</a>
                    </div>
                    <div id="movie-detail-director">감독 | <%= movie.getDirectorName() %></div>
                    <div id="movie-detail-actor">출연진 | <%= cast %></div>
                    <div id="movie-detail-story"><%= movie.getMovieStory() %>
                    </div>
                    
                    <% if(loginUser == null) { %>
                    	<button id="movie-detail-btn" onclick="noMember();">예매하기</button>
                	<%} else { %>
                		<button id="movie-detail-btn" onclick="reservationPage();">예매하기</button>
                	<% } %>
                
                </div>
            </div>

            <div id="movie-detail-video">
                <a id="youtube">예고편</a>
                
                <div id="video-src">
                    <%= movie.getTrailerVideo() %>
                </div>
            </div>

            <div id="movie-detail-still">
                <h1>스틸컷</h1>
                <div id="detail-still-img">
                    <div class="still-img">
                        	스틸컷
                    </div>
                    <div class="still-img">
                        	스틸컷
                    </div>
                    <div class="still-img">
                        	스틸컷
                    </div>
                </div>
            </div>

        </div> <!-- movie-detail-->
    </div> <!-- wrap -->
    
        <%@ include file="/views/common/footer.jsp" %>
        
    <script>
    	// 예매하기 버튼 -> 예매 페이지
    	function reservationPage(){
    		location.href = '<%= contextPath %>/movie.reservation';
    	}
    	
		function noMember(){
			location.href = ('<%=contextPath%>/loginForm.me');
			alert('로그인이 필요한 서비스 입니다.');
		}
    </script>
    
</body>

</body>
</html>