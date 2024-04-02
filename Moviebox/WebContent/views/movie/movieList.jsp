<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.kh.movie.model.vo.*, java.util.ArrayList" %>
    
<%
	ArrayList<Movie> list = (ArrayList<Movie>)request.getAttribute("movieList");
	String type = (String)request.getAttribute("type");
	String genre = (String)request.getAttribute("genre");
	
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
            box-sizing: border-box;
        }

        .wrap{
            width: 1200px;
            margin: 0 auto;
        }

        /* 영화 리스트 전체 감싸는 div */
        #movie-list{
            width: 1200px;
            height: auto;
            margin: 0 auto;
            position: relative;
        }

        #movie-list-header{
            width: 1200px;
            height: 100px;
            margin-top: 10px;
            margin-bottom: 10px;
        }

        #movie-list-category{
            width: 940px;
            height: 100px;
            padding-top: 13px;
            float: left;
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
            float: left;
            padding-top: 13px;
            color: #808080;
        }

        .align-a{
            color: white;
            cursor: pointer;
            font-size: 15px;
        }

        .align-a:hover{
            color: #FFC145;
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
        #movie-content-body{
            width: 1200px;
            height: auto;
            /*border: 1px solid red;*/
            margin-bottom: 30px;
        }

        .movie-content{
            width: 235px;
            height: auto;
            color: white;
            border: 1px solid pink;
            display: inline-block;
            margin-bottom: 20px;
        }

        .movie-conten1{
            width: 1200px;

        }

        .movie-list-img{
            height: 300px;
        }

        .movie-list-title{
            height: 70px;
            border: 1px solid seagreen;
            text-align: center;
            font-size: 20px;
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

    </style>
</head>
<body>
    <%@ include file="/views/common/header.jsp" %>
    
    <div id="wrap">
    
 
        <div id="movie-list">

            <div id="movie-list-header">
            <!-- 카테고리 시작 -->
                <div id="movie-list-category">
                    <div class="movie-list-genre">전체</div>
                    <div class="movie-list-genre">액션</div>
                    <div class="movie-list-genre">로맨스</div>
                    <div class="movie-list-genre">스릴러</div>
                    <div class="movie-list-genre">코미디</div>
                    <div class="movie-list-genre">애니</div>
                </div>
                
                <!-- 장르 버튼 -->
                <form id="selectGenreForm" action="<%=contextPath%>/selectGenre.movie" method="get">
                	<input id="selectTypeGenre" type="hidden" name="type" value="genre">
                	<input id="genreInput" type="hidden" name="genre">
                </form>
                
                <script>
	                document.getElementById('movie-list-category').onclick = function(e){
	                    var selectGenre = e.target.innerHTML;
	                    document.getElementById('genreInput').value = selectGenre;
	                    document.getElementById('selectGenreForm').submit();
	            }
                </script>

                <!-- 정렬 / 검색창 -->
                <div id="searchalign">
                    <div id="movie-list-align">
                        <a class="align-a">예매순</a> | <a class="align-a">가나다순</a>
                    </div>

                     <div id="search-img">
                       <img src="<%= contextPath %>/resources/img/search.PNG" alt="검색 아이콘">
                    </div>
                    <div id="movie-list-input">
                        <input type="text" id="movie-list-search" placeholder="검색창">
                    </div>
                </div>
            </div> <!-- movie-list-header -->

            <div id="movie-content-body">
			<% if(list.isEmpty()) { %>
				<a style="color: white;">등록된 영화가 존재하지 않습니다.</a> <br>
			<% } else { %>

                <% for(Movie m : list) { %>
                    <div class="movie-content">
                    	<input type="hidden" id="inputId" name="movieNo" value="<%= m.getMovieNo()%>" />
                        <div class="movie-list-img">포스터</div>
                        <div class="movie-list-title"><%= m.getMovieTitle() %></div>
                        <button id="movie-content-btn1" onclick="detailPage(this);">상세정보</button>
                        <button id="movie-content-btn2">예매정보</button>
                    </div>
                 <% } %>
             <% } %>

            </div>

			<script>
			function detailPage(button) {
			    var movieNo = $(button).siblings('input[type="hidden"]').val();
			    location.href = '<%=contextPath%>/detail.movie?movieNo=' + movieNo;
			}
			</script>

        </div> <!-- movie-list -->
    </div> <!-- wrap -->
    
    
	<%@ include file="/views/common/footer.jsp" %>
    
</body>
</html>