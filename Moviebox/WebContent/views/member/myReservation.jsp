<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.reservation.model.vo.Seat,com.kh.common.model.vo.Price,java.util.ArrayList,com.kh.member.model.vo.MemberGenre,java.util.List,com.kh.common.model.vo.Reservation,com.kh.movie.model.vo.Movie"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	    <style>
    	.wrap{
            width: 1200px;
            height: auto;
            margin: auto;
        }
    	a{
            text-decoration: none;
        }
        #info-header{
            width: 100%;
            height: 175px;
        }
        #info-title{
            width: 100%;
            height: 100px;
        }
        .title{
            display: block;
            width: 100%;
            height: 100%;
            font-size: 30px;
            font-weight: bold;
            line-height: 100px;
            text-align: center;
            color: white;
        }
        #info-header-navi{
            width: 1050px;
            height: 75px;
            margin : auto;
        }
        #info-header-navi ul{
            list-style-type: none;
            display: flex;
            justify-content: center;
            width: 100%;
            height: 100%;
            padding: 0;
            margin: 0;
        }
        #info-header-navi li{
            width: 50%;
            height: 100%;
            display: flex;
            justify-content: center;
            align-items: center;
            
        }
        .info-navi{
            border-top: 1px solid lightgray;
            border-bottom: 1px solid lightgray;
        }
        .info-my{
        	color: #FFC145;
            
            text-decoration: none;
            font-weight: bold;
            width: 100%;
            height: 100%;
            text-align: center;
            padding-top: 25px;
        }
        .info-list{
            color: black;
            font-weight: bold;
            width: 100%;
            height: 100%;
            text-align: center;
            padding-top: 25px;
        }
        .info-navi > a{
        	text-decoration: none;
        }
        
        
        #info-navi-first{
        	background-color: #1A1A1A;
            
        }
        #info-navi-second{
            background-color: #FFC145;
        }
        .info-my:hover{
            text-decoration: none;
            color: #FFC145;
            
        }
        .info-list:hover{
            text-decoration: none;  
             
            color: black;  
        }
        #reservationList{
            width: 100%;
            height: auto;
            padding-top: 50px;
        }
        #reservationList > div{
            width: 950px;
            height: 200px;
            margin: auto;
            margin-bottom: 50px;
            background-color: rgb(33, 33, 33);
            border-radius: 8px;
        }

        #reservationList-content > div{
            float: left;
            height: 100%;
        }
        .res-img{
            width: 18%;
            padding: 40px 20px 40px 30px;
        }
        .res-content{
            width: 44%;
            padding: 40px 20px 40px 10px;
        }
        .res-btn{
            width: 10%;
            padding-top: 5px;
            
        }
        .res-result{
            width: 28%;
            padding: 10px 10px 10px 10px;
        }
        .res-img > div{
            width: 100%;
            height: 100%;
        }
        .res-content > div{
            width: 100%;
            height: 100%;
        }
        .res-btn > div{
            margin: auto;
            width: 75px;
        }
        #cancelBtn{
            width: 100%;
            height: 30px;
            color: black;
            font-size: 15px;
            font-weight: bold;
            padding: 0;
            
        }
        .res-result > div{
            width: 100%;
            height: 100%;
            color: white;
        }
        .totalCount, .totalPrice{
            width: 100%;
            height: 25%;
            padding: 10px 0px 10px 5px;
        }
        .countPrice{
            width: 100%;
            height: 50%;
            padding: 18px 0px 18px 5px;
            border-top: 1px solid lightgray;
            border-bottom: 1px solid lightgray;
        }
        #contentTable{
            color: white;
            width: 100%;
        }
        #contentTable td{
            font-size: 13px;
            font-weight: bold;
        }
        .res-result h6{
            margin: 0;
        }
        #studentText{
            margin-bottom: 10px;
        }
        #poster{
        	width: 100%;
            height: 100%;
        }

        #noData h3{
        	text-align: center; 
        	color: white;
        	line-height: 200px;
        }
    </style>    
</head>
<body>
	<%@ include file="../common/header.jsp" %>
	
	<%
	
		List<Reservation> resList = (ArrayList)request.getAttribute("list");
		List<Movie> movieList = (ArrayList)request.getAttribute("movieList");

	
	%>
	
	<% if(loginUser == null) {%>
		<script>
			location.href = ('<%=contextPath%>/loginForm.me');
		</script>
	<%} else {%>
	<div class="wrap">
	    <div id="info-header">
            <div id="info-title">
            <span class="title">마이페이지</span>
            </div>
            <div id="info-header-navi">
                <ul class="info-navi">
                    <li id="info-navi-first">
                        <a href="<%=contextPath%>/mypage.me" class="info-my">회원정보</a>
                    </li>
                    <li id="info-navi-second">
                        <a href="#" class="info-list">예매내역</a>
                    </li>

                </ul>
            </div>

        </div>

        <div id="reservationList">

         <%if(resList != null) { %>
            	<%for(int i= 0; i<resList.size(); i++) {%>
            <div id="reservationList-content">
           
                <div class="res-img">

                    <div><img id="poster" src="<%=contextPath %>/<%= movieList.get(i).getFilePath()%>/<%=movieList.get(i).getFileName() %>" alt=""></div>
                </div>
                <div class="res-content">
                    <div>
                        <table id="contentTable">
                            <thead>
                                <tr>
                                    <th colspan="4"><%=resList.get(i).getMovieTitle() %></th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>예약번호</td>
                                    <td><%=resList.get(i).getTicketNo() %></td>
                                    <td>상영관</td>
                                    <td><%=resList.get(i).getScreenNo() %>관</td>
                                </tr>
                                <tr>
                                    <td>극장</td>
                                    <td><%=resList.get(i).getTheaterName() %></td>
                                    <td>시간</td>
                                    <td><%=resList.get(i).getRunningTime() %></td>
                                </tr>
                                <tr>
                                    <td>날짜</td>
                                    <td><%=resList.get(i).getWatchDate() %></td>
                                    <td>좌석</td>
                                    <td style="font-size: 12px;">
                                    <%
                                    	List<Seat> seatList = resList.get(i).getSeatList(); 
										for(Seat s : seatList){   
                                    %>
                                     <%=s.getSeatNo()%> <%} %>
                                     </td>
                                   
                                </tr>
                                <tr>
                                	<%Price price = resList.get(i).getPrice(); %>
                                    <td>인원</td>
                                    <td>
                                    <%if(price.getStudentCount() > 0) {%>
                                    		청소년 <%=price.getStudentCount()%>명
                                    <%} %>		
                                    <%if(price.getCommonCount() > 0) {%>
                                    		성인 <%=price.getCommonCount()%>명
                                    <%} %>				
                                    </td>
                                    <td>예매일시</td>
                                    <td>2024-02-25</td>   
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="res-btn">
                    <div><button type="button" id="cancelBtn" class="btn btn-warning">취소</button></div>
                    
                </div>
                <div class="res-result">
                    <div>
                        <div class="totalCount">
                            <h6>총 인원 : <%=resList.get(i).getPersonNum()%> 명</h6>
                        </div>
                        <div class="countPrice">
                            <h6 id="studentText">청소년 : <%=price.getStudentCount()%> X 11000  = <%=price.getStudentPrice() %></h6>
                            <h6>성인 : <%=price.getCommonCount()%> X 13000  = <%=price.getCommonPrice() %></h6>
                        </div>
                        <div class="totalPrice">
                            <h6>총 가격 : <%=price.getTotalPrice() %> 원</h6>
                        </div>
                    </div>
                </div>
                
            </div>
            <%}} else { %>
                		<div id="noData">
								<h3> 예매내역이 존재하지 않습니다.</h3>
            			</div>
                
                <%} %>
            
        </div>
    </div>
	
	<%} %>
	<%@ include file="../common/footer.jsp" %>
</body>
</html>