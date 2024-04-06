<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.kh.common.model.vo.Location, com.kh.movie.model.vo.Movie" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

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
<link rel="stylesheet" href="resources/css/reservation/movieReservation.css">

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
    
    <script src="resources/js/reservation/movieReservation.js"></script>

</body>
</html>