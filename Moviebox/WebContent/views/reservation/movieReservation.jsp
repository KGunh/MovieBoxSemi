<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.common.model.vo.Location, com.kh.movie.model.vo.Movie" %>

<%
	ArrayList<Movie> movieList = (ArrayList<Movie>)request.getAttribute("movieList");
	ArrayList<Location> locationList = (ArrayList<Location>)request.getAttribute("locationList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://unpkg.com/swiper@8/swiper-bundle.min.css" />
<script src="https://unpkg.com/swiper@8/swiper-bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<style>
    div{
        box-sizing: border-box;
    }

    #wrap{
        width: 1200px;
        height: 1600px;
    }

     /* 이미지 영역 사이즈 조절 */
     .swiper {
        width: 1200px;
        height: 400px;
    }

    /* 이미지 사이즈 조절 */
    .swiper-slide img {
        width : 100%;
        height : 100%;
    }

    /* 화살표 버튼색 변경 (기본색은 파란색) */
    div[class^=swiper-button] {
        color : rgb(32, 32, 32);
        /* display : none; */ /* 아니면 안보이게 숨기기도 가능 */
    }

    #title{
        padding-left: 50px;
        height: 60px;
        margin-top: 30px;
        background-color: rgb(255, 193, 69);
        font-size: 35px;
        color: rgb(32,32,32);
        font-weight: bold;
        border-bottom: 1px solid gray;
    }
    
    #selectMovieArea{
        background-color: rgb(255, 193, 69);
    }

    .poster:hover{
        transform: scale(1.1);
    }

    #selectDateArea{
        height: 100px;
        width: 100%;
    }

    #printToday{
        width: 1070px;
        height: 50px;
        margin-left: auto;
        margin-right: auto;
        margin-top: 20px;
        text-align: center;
        color: rgb(241, 241, 241);
        font-size: 30px;
        font-weight: bold;
        line-height: 40px;
    }
    
    #selectLocationArea{
        height: 60px;
    }

    #selectLocation{
        width: 1070px;
        height: 100%;
        line-height: 60px;
        float: left;
        margin-left: 62px;
    }
    
    #selectLocation > select{
        height: 40px;
        width: 150px;
        border-radius: 12px;
        padding-left: 15px;
        background-color: rgb(255, 193, 69);
        font-size: 20px;
        font-weight: 700;
        border: none;
    }

    #screenDate{
        height: 40px;
        border-radius: 12px;
        padding-left: 15px;
        background-color: rgb(255, 193, 69);
        width: 200px;
        font-size: 20px;
        font-weight: 700;
        margin-left: 15px;
        border: none;
    }
    #selectLocation > select:focus{
        outline: none;
    }

    #screenDate:focus{
        outline: none;
    }

    #selectScreenArea{
        height: 800px;
    }

    #printScreen{
        width: 1070px;
        height: auto;
        margin: auto;
    }

    .screen{
        height: 175px;
        margin-top: 25px;
        border-radius: 25px;
        background-color: rgb(148, 145, 145);
    }

    .theaterName{
        height: 60px;
        padding-left: 60px;
        line-height: 60px;
        font-size: 25px;
        font-weight: bold;
        color: rgb(51,51,51);
    }
    
    .selectScreen{
        width: 900px;
        height: 100px;
        display: flex;
        justify-content: space-around;
        margin-left: 80px;
    }

    .screenName{
        float: left;
        width: 155px;
        height: 85px;
        margin-top: 5px;
        border-radius: 25px;
        background-color: rgba(255, 255, 255, 0.6);
        text-align: center;
        font-size: 20px;
        font-weight: bold;
        line-height: 85px;
    }

    .screenName:hover{
        cursor: pointer;
    }

    .swiper-slide{
        display: flex;
    }

    .poster{
        height: 280px;
        width: 180px;
        margin: auto;
        border-radius: 24px;
    }

    .base{
        height: 280px !important; 
        width: 180px !important;
        margin: auto;
        border-radius: 24px;
    }

    .poster img{
        width: 100%;
        height: 100%;
        border-radius: 24px;
        margin: auto;
        box-shadow: 4px 4px 8px rgb(32, 32, 32);
    }

    .poster img:hover{
        cursor: pointer;
    }

    #submit-btn{
        height: 60px;
        width: 180px;
        border-radius: 12px;
        font-weight: 600;
        font-size: 28px;
        background-color: rgb(255, 193, 69);
        float: right;
        margin-right: 65px;
        border: none;
    }

  
</style>

</head>
<body>
    <%@ include file="/views/common/header.jsp" %>
    <div id="wrap">
        <form action="/moviebox/seat.reservation" method="get">
            <div id="title">영화예매</div>
            <div id="selectMovieArea">
                <div id="content_1">
                    <div class="swiper">
                        <div id="swiper-select" class="swiper-wrapper">
                            <!-- Slides -->
                            <% for(Movie m : movieList) { %>
	                           	<div class="swiper-slide">
	                                <div class="poster">
	                                    <img src="/<%= m.getFilePath() %>/<%= m.getFileName() %>">
	                                </div>
	                            </div>
                            <% } %>
                        </div>
                    	
                        <div class="swiper-pagination"></div>
                    
                        <div class="swiper-button-prev"></div>
                        <div class="swiper-button-next"></div>
                    
                        <div class="swiper-scrollbar"></div>
                    </div>
                </div>

            </div>
            <div id="selectDateArea">
                <div id="printToday"></div>
            </div>
            <div id="selectLocationArea">
                <div id="selectLocation">
                    <select>
                        <option>전체</option>
                        <% for(Location l : locationList){ %>
                        	<option><%= l.getLocationName() %></option>
                        <% } %>
                    </select>
                    <input id="screenDate" type="date" name="screenDate">
                </div>
            </div>
            <div id="selectScreenArea">
                <div id="printScreen">
                    <div class="screen">
                        <!--TB_SCREEN에서 SELECT-->
                        <div class="theaterName">CGV 강남</div>
                        <div class="selectScreen">
                            <div class="screenName">
                                <span style="color: black;">23:10</span>~<span style="color: gray;">25:34</span>
                            </div>
                            <div class="screenName">
                                <span style="color: black;">23:10</span>~<span style="color: gray;">25:34</span>
                            </div>
                            <div class="screenName">
                                <span style="color: black;">23:10</span>~<span style="color: gray;">25:34</span>
                            </div>
                            <div class="screenName">
                                <span style="color: black;">23:10</span>~<span style="color: gray;">25:34</span>
                            </div>
                        </div>
                    </div>
                    <div class="screen">
                        <div class="theaterName">CGV 강북</div>
                        <div class="selectScreen">
                            <div class="screenName">
                                <span style="color: black;">23:10</span>~<span style="color: gray;">25:34</span>
                            </div>
                            <div class="screenName">
                                <span style="color: black;">23:10</span>~<span style="color: gray;">25:34</span>
                            </div>
                            <div class="screenName">
                                <span style="color: black;">23:10</span>~<span style="color: gray;">25:34</span>
                            </div>
                            <div class="screenName">
                                <span style="color: black;">23:10</span>~<span style="color: gray;">25:34</span>
                            </div>
                        </div>
                    </div>
                    <div class="screen">
                        <div class="theaterName">메가박스</div>
                        <div class="selectScreen">
                            <div class="screenName">
                                <span style="color: black;">23:10</span>~<span style="color: gray;">25:34</span>
                            </div>
                            <div class="screenName">
                                <span style="color: black;">23:10</span>~<span style="color: gray;">25:34</span>
                            </div>
                            <div class="screenName">
                                <span style="color: black;">23:10</span>~<span style="color: gray;">25:34</span>
                            </div>
                            <div class="screenName">
                                <span style="color: black;">23:10</span>~<span style="color: gray;">25:34</span>
                            </div>
                        </div>
                    </div>
                    <div class="screen">
                        <div class="theaterName">롯데시네마</div>
                        <div class="selectScreen">
                            <div class="screenName">
                                <span style="color: black;">23:10</span>~<span style="color: gray;">25:34</span>
                            </div>
                            <div class="screenName">
                                <span style="color: black;">23:10</span>~<span style="color: gray;">25:34</span>
                            </div>
                            <div class="screenName">
                                <span style="color: black;">23:10</span>~<span style="color: gray;">25:34</span>
                            </div>
                            <div class="screenName">
                                <span style="color: black;">23:10</span>~<span style="color: gray;">25:34</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <button id="submit-btn" type="submit">좌석 선택</button>
        </form>
    </div>
    <%@ include file="/views/common/footer.jsp" %>


    <script>
        // 슬라이더 동작 정의
        const swiper = new Swiper('.swiper', {
            loop : true, //반복 재생 여부
            slidesPerView : 4, // 이전, 이후 사진 미리보기 갯수
            pagination: { // 페이징 버튼 클릭 시 이미지 이동 가능
                el: '.swiper-pagination',
                clickable: true
            },
            navigation: { // 화살표 버튼 클릭 시 이미지 이동 가능
                prevEl: '.swiper-button-prev',
                nextEl: '.swiper-button-next'
            }
        }); 

        window.onload = function() {
            var today = new Date();
            var year = today.getFullYear();
            var month = (String)(today.getMonth() + 1).padStart(2, '0');
            var day = (String)(today.getDate()).padStart(2, '0');
            document.getElementById('printToday').innerHTML = year + '-' + month + '-' + day;
        }

        $(function(){
            $('.poster').click(function(){
                $('.poster').not(this).removeAttr('style');
                $(this).css('transform', 'scale(1.1)');
            });
        });

        
    </script>
</body>
</html>