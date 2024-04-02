<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.kh.common.model.vo.Location, com.kh.movie.model.vo.Movie" %>

<%
	List<Movie> movieList = (List<Movie>)request.getAttribute("movieList");
	List<Location> locationList = (List<Location>)request.getAttribute("locationList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 예매</title>
<link rel="stylesheet" href="https://unpkg.com/swiper@8/swiper-bundle.min.css" />
<script src="https://unpkg.com/swiper@8/swiper-bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<style>
    div{
        box-sizing: border-box;
    }

    #wrap{
        width: 1200px;
        height: auto;
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
        height: 80px;
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
        height: auto;
        padding-bottom: 100px;
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
        margin-left: 48px;
        border-radius: 25px;
        background-color: rgba(255, 255, 255, 0.6);
        text-align: center;
        font-size: 18px;
        font-weight: bold;
        line-height: 85px;
    }

    .screenName:hover{
        cursor: pointer;
        background-color: rgb(255, 193, 69);
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

    #select-screen-area{
        height: 300px;
        width: 140px;
        border: 1px solid rgb(255, 193, 69);
        position: fixed; 
        bottom: 300px; 
        right: 150px;
        border-radius: 12px;
    }

    #select-screen{
        height: 210px;
        width: 100%;
        text-align: center;
        color: rgb(148, 145, 145);
        font-size: 12px;
        font-weight: 500;
    }

    #select-screen > div{
        margin-top: 30px;
    }

    #submit-btn{
        height: 60px;
        width: 140px;
        border-bottom-right-radius: 12px;
        border-bottom-left-radius: 12px;
        font-weight: 600;
        font-size: 24px;
        background-color: rgb(255, 193, 69);
        border: none;
    }
  
</style>

</head>
<body>
    <%@ include file="/views/common/header.jsp" %>

    <% if(loginUser == null) {%>
		<script>
			location.href = ('<%=contextPath%>/loginForm.me');
		</script>
	<%} else {%>
    <div id="wrap">
        <form action="/moviebox/seat.reservation" method="post">
            <div id="title">영화예매</div>
            <div id="selectMovieArea">
                <div id="content_1">
                    <div class="swiper">
                        <div id="swiper-select" class="swiper-wrapper">
                            <% for(Movie m : movieList) { %>
	                           	<div class="swiper-slide">
	                                <div class="poster">
	                                    <img src="<%= contextPath %>/<%= m.getFilePath() %>/<%= m.getFileName() %>" alt="영화포스터">
                                        <input type="hidden" value="<%= m.getMovieNo() %>">
                                        <input type="hidden" value="<%= m.getMovieTitle() %>">
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
                    <select id="locationOption">
                        <option>전체</option>
                        <% for(Location l : locationList){ %>
                        	<option><%= l.getLocationName() %></option>
                        <% } %>
                    </select>
                    <input id="screenDate" type="date" name="screenDate">
                </div>
            </div>
            <div id="selectScreenArea">
                <div id="printScreen"></div>
                <input id="movieTitle" type="hidden" name="movieTitle">
                <input id="movieNo" type="hidden" name="movieNo">
                <input id="theaterName" type="hidden" name="theaterName">
                <input id="screenName" type="hidden" name="screenName">
                <input id="screenNo" type="hidden" name="screenNo">
                <div id="select-screen-area">
                    <div id="select-screen">
                        <div></div>
                        <div></div>
                        <div></div>
                        <div></div>
                    </div>
                    <button id="submit-btn" type="button">좌석 선택</button>
                </div>
            </div>
        </form>
    </div>
    <%} %>

    <%@ include file="/views/common/footer.jsp" %>

    <style>
        .clicked{
            color: rgb(32,32,32);
            background-color: rgb(255, 193, 69);
        }

    </style>

    <script>
		
        const swiper = new Swiper('.swiper', {
            loop : true,
            slidesPerView : 4,
            pagination: {
                el: '.swiper-pagination',
                clickable: true
            },
            navigation: {
                prevEl: '.swiper-button-prev',
                nextEl: '.swiper-button-next'
            }
        }); 

        let movieTitle = '';

        window.onload = function() {
            let today = new Date();
            let year = today.getFullYear();
            let month = (String)(today.getMonth() + 1).padStart(2, '0');
            let day = (String)(today.getDate()).padStart(2, '0');
            document.getElementById('printToday').innerHTML = year + '-' + month + '-' + day;
        };

        $(function(){
            $('.poster').click(function(){
                $('.poster').not(this).removeAttr('style');
                $(this).css('transform', 'scale(1.1)');
                $('#movieNo').val($(this).children().eq(1).val());

                movieTitle = $(this).children().eq(2).val();
                $('#movieTitle').val(movieTitle);
            });
        });
		
        function selectScreenNo(e){
            if($(e).hasClass('clicked')){
                $('.screenName').removeClass('clicked');
                $('#screenNo').removeAttr('value');
                $('#screenName').removeAttr('value');
                return '';
            } 
            else{
                $('.screenName').removeClass('clicked');
                $(e).addClass('clicked');
            }

            $('#select-screen').children().eq(0).html($(e).parent().children().eq(0).html());
            $('#select-screen').children().eq(1).html(movieTitle);
            $('#select-screen').children().eq(2).html($(e).children().eq(2).html());
            $('#select-screen').children().eq(3).html($(e).children().eq(0).html());
            $('#screenNo').val(e.children[1].value);
            $('#screenName').val(e.children[2].value);
            $('#theaterName').val($(e).parent().children().eq(0).html());
        };
       
        function selectScreen(){
            $.ajax({
            	url : 'screen.reservationAjax',
            	type : 'get',
            	data : {
                    date : $('#screenDate').val(),
                    location : $('#locationOption').val(),
                    movieNo : $('#movieNo').val()
            	},
            	success : function(result){
                    let resultStr = '';
                    for(let i = 0; i < result.length; i++){
                        resultStr += '<div class="screen">'
                                    +     '<div class="theaterName">' + result[i].theaterName + '</div>';
                                    +     '<div class="selectScreen">'
                        for(let j = 0; j < result[i].watchDateList.length; j++){
                            resultStr +=        '<div class="screenName" onclick="selectScreenNo(this);">'
                                        +            '<span style="color: black;">' + result[i].watchDateList[j] + '</span>'
                                        +            '<input type="hidden" value="' + result[i].screenNoList[j] + '">'
                                        +            '<input type="hidden" value="' + result[i].screenNameList[j] + '">'
                                        +        '</div>'
                        };
                        resultStr +=    '</div>';
                                    + '</div>';
                    };
                
                    $('#printScreen').html(resultStr);
                    
            	},
            	error : function(){
					$('#printScreen').html('조회된 영화관이 없습니다.');
				}
            });
        };
            
        $('.poster').click(function(e){
            selectScreen();
        });

        $('#screenDate').change(function(e){
            selectScreen();
        });

        $('#locationOption').change(function(){
            selectScreen();
        });

        $('#submit-btn').click(function(){
            if(!$('#screenNo').val()){
                alert('상영관을 선택해주세요!');
            } else {
                $('form').submit();
            }
        });

        
    </script>
</body>
</html>