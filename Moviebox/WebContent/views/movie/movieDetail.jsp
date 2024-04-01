<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.ArrayList, com.kh.movie.model.vo.*" %>

<%
	ArrayList<Movie> list = (ArrayList<Movie>)request.getAttribute("movieList");
	Movie movie = (Movie)request.getAttribute("movie");
	String cast = (String)request.getAttribute("cast");
	
	
	System.out.println("왜 안나와 list : " + list);
	System.out.println("왜 안나와 movie : " + movie);
	System.out.println("왜 안나와 cast : " + cast);
	
	
%>
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
            border: 1px solid #FFC145;
            position: relative;
        }

        #movie-detail-poster{
            position: absolute;
            width: 300px;
            height: 422px;
            border: 1px solid red;            
            left: 0;
            padding: 10px;
            margin: 20px;
        }

        #movie-detail-content{
            position: absolute;
            width: 850px;
            right: 0;
            padding: 10px;
            margin: 20px;
            border: 1px solid blue;
        }

        #movie-detail-title{
            width: 830px;
            height: 60px;
            line-height: 60px;
            font-size: 25px;
            font-weight: bold;
            padding-left: 10px;
            border: 1px solid lightgreen;
        }

        #movie-detail-etc{
            width: 830px;
            height: 40px;
            line-height: 40px;
            padding-left: 10px;
            margin-bottom: 15px;
            border: 1px solid sienna;
        }

        #movie-detail-director{
            width: 830px;
            height: 40px;
            line-height: 40px;
            padding-left: 10px;
            border: 1px solid salmon;
        }

        #movie-detail-actor{
            width: 830px;
            height: 40px;
            line-height: 40px;
            margin-bottom: 15px;
            padding-left: 10px;
            border: 1px solid darkcyan;
        }

        #movie-detail-story{
            width: 830px;
            height: 130px;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid chartreuse;
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
            padding-bottom: 30px;
            color:white;
            border: 1px solid aqua;
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


    </style>
    
</head>
<body>

<body>

    <%@ include file="/views/common/header.jsp" %>

    <div id="wrap">
        <div id="movie-detail">
            <div id="movie-detail-box">
            
            <input type="hidden" name="movieNo" value="<%= movie.getMovieNo()%>" />
            
                <div id="movie-detail-poster">
                    포스터
                </div>

                <div id="movie-detail-content">
                    <div id="movie-detail-title">제목 </div>
                    <div id="movie-detail-etc">
                        <a>장르</a> | <a>러닝타임</a> | <a>관람등급</a> | <a>개봉일</a>
                    </div>
                    <div id="movie-detail-director">감독</div>
                    <div id="movie-detail-actor">출연진</div>
                    <div id="movie-detail-story">줄거리
                    </div>
                    
                    <% if(loginUser == null) { %>
                    	<button id="movie-detail-btn" onclick="noMember();">예매하기</button>
                	<%} else { %>
                		<button id="movie-detail-btn" onclick="reservationPage();">예매하기</button>
                	<% } %>
                
                </div>
            </div>

            <div id="movie-detail-video">
                <h1>예고편</h1>
                <div id="video-src">
                    <iframe id="detail-video" width="1090" height="600" src="https://www.youtube.com/embed/rjW9E1BR_30?si=v4wZ9R1k-4jWv8RI" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
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