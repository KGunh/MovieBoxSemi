<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<%
    String screenDate = (String)request.getAttribute("screenDate");
    String screenName = (String)request.getAttribute("screenName");
	String movieTitle = (String)request.getAttribute("movieTitle");
	String screenNo = (String)request.getAttribute("screenNo");
	String movieNo = (String)request.getAttribute("movieNo");
    String theaterName = (String)request.getAttribute("theaterName");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>좌석 선택</title>

<link rel="stylesheet" href="resources/css/reservation/seatReservation.css">

</head>

<body>

	<%@ include file="/views/common/header.jsp" %>

    <% if(loginUser == null) {%>
		<script>
			location.href = ('<%=contextPath%>/loginForm.me');
		</script>
	<%} else {%>
	<div id="wrap">
        <div id="title">영화 예매</div>

        <div id="selectPersonArea">
            <div id="selectText">
                인원 선택
                <div style="color:rgb(148, 145, 145); font-size: 16px;">
                    최대 8명까지 선택 가능
                </div>
            </div>
            <div id="movie-info">${ movieTitle } ${ theaterName } ${ screenName } ${ screenDate }</div>
            <div id="select-wrap">
                <div class="selectAge">
                    <button class="people-teen ageBtn" style="cursor: auto;">청소년</button>
                </div>
                <div id="selectPerson">
                    <button class="people-Count teenBtn">1</button>
                    <button class="people-Count teenBtn">2</button>
                    <button class="people-Count teenBtn">3</button>
                    <button class="people-Count teenBtn">4</button>
                    <button class="people-Count teenBtn">5</button>
                    <button class="people-Count teenBtn">6</button>
                    <button class="people-Count teenBtn">7</button>
                    <button class="people-Count teenBtn">8</button>
                </div>
                <div class="selectAge">
                    <button class="people-adult ageBtn" style="cursor: auto;">성인</button>
                </div>
                <div id="selectPerson">
                    <button class="people-Count adultBtn">1</button>
                    <button class="people-Count adultBtn">2</button>
                    <button class="people-Count adultBtn">3</button>
                    <button class="people-Count adultBtn">4</button>
                    <button class="people-Count adultBtn">5</button>
                    <button class="people-Count adultBtn">6</button>
                    <button class="people-Count adultBtn">7</button>
                    <button class="people-Count adultBtn">8</button>
                </div>
            </div>
            <div id="select-people"></div>
        </div>
        
        <div id="seat-wrap">
            <div id="seat-title"> 좌석 선택 </div>
            <div id="seat-arrange">
                <div class="screen-wrap">
                    <div class="screen rotate"></div>
                </div>
                <div id="a-line" class="line">
                    <div id="a-line-wrap" class="line-wrap">
                        <% for(int i = 1; i <= 12; i++){ %>
                        	<div class="a-seat seats">A<%= i %></div>
                        <% } %>
                    </div>
                </div>
                <div id="b-line" class="line">
                    <div id="b-line-wrap" class="line-wrap">
                        <% for(int i = 1; i <= 12; i++){ %>
                        	<div class="b-seat seats">B<%= i %></div>
                        <% } %>
                    </div>
                </div>
                <div id="c-line" class="line">
                    <div id="c-line-wrap" class="line-wrap">
                         <% for(int i = 1; i <= 12; i++){ %>
                        	<div class="c-seat seats">C<%= i %></div>
                         <% } %>
                    </div>
                </div>
                <div id="d-line" class="line">
                    <div id="d-line-wrap" class="line-wrap">
                         <% for(int i = 1; i <= 12; i++){ %>
                        	<div class="d-seat seats">D<%= i %></div>
                         <% } %>
                    </div>
                </div>
                <div id="e-line" class="line">
                    <div id="e-line-wrap" class="line-wrap">
                        <% for(int i = 1; i <= 12; i++){ %>
                        	<div class="e-seat seats">E<%= i %></div>
                        <% } %>
                    </div>
                </div>
                <div id="f-line" class="line">
                    <div id="e-line-wrap" class="line-wrap">
                         <% for(int i = 1; i <= 12; i++){ %>
                        	<div class="f-seat seats">F<%= i %></div>
                         <% } %>
                    </div>
                </div>
            </div>
        </div>
        <div id="select-btn">
            <button id="print-resv-info" >좌석 선택</button>
        </div>
        <div id="check-area" hidden>
            
        </div>
	</div>

    <% } %>

	<%@ include file="/views/common/footer.jsp" %>

    <script src="resources/js/reservation/seatReservation.js"></script>

</body>
</html>