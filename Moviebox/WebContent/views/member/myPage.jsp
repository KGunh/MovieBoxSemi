<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.board.model.vo.Answer,com.kh.board.model.vo.Board,java.util.ArrayList,com.kh.member.model.vo.MemberGenre,java.util.List,com.kh.common.model.vo.Reservation,com.kh.movie.model.vo.Movie"%>

<!DOCTYPE html>
<html lang="en">
<head>

    <style>
        *{
            box-sizing: border-box;
            margin: 0;
            padding: 0;
        }
        body{
            background-color: #1A1A1A
        }
        a{
            text-decoration: none;
        }
        div{
        }
        .content{
            height: auto;
            width: 500px;
            margin: auto;
            margin-top: 50px;
            margin-bottom: 120px;
            
        }
        .title-area{
            
            height: auto;
            width: 100%;
            margin-bottom: 25px;
        }
        .mini-tit{
            color: white;
            font-weight: bold;
        }
        .tit{
            font-size: 30px;
            color: white;
            font-weight: bold;
            border-bottom: 4px solid#FFC145;
            
        }
        .info-area{
            height: 170px;
            margin-bottom: 20px;
            padding: 30px;
            color: black;
            font-weight: bold;
            background-color: rgb(224, 224, 224);
            border-radius: 8px;
            position: relative;
        }
        .history-area , .QNA-area , .store-area{ 
            height: 110px;
            padding: 15px;
            margin-bottom: 20px;
            background-color: rgb(224, 224, 224);
            border-radius: 8px;
        }

        .content > div{
            width: 100%;
        }
        .info-area-content{
            height: 100%;
            width: 70%;
        }
        .info-name{
            font-size: 30px;
        }
        #btn1{
            background-color: #FFC145;
            position: absolute;
            font-size: 14px;
            font-weight: bold;
            top: 10px;
            right: 10px;
            color: black;

        }
        
        .info-content1{          
            float: left;
            width: 100%;
            height: 100%;
            position: relative;
            padding: 10px;
            background-color: white;
        }
        .info-name{
            position: relative;
            font-size: 30px;
            width: 100%;
        }
        .info-id{
            position: absolute;
            top: 8px;
            right:20px;
            font-size: 20px;
            color: rgb(51, 51, 51);
        }
        .info-address, .info-email{
            font-size: 12px;
            position: absolute;
            color: rgb(51, 51, 51);
            left: 10px;
        }
        .info-genre{
        	font-size: 12px;
            position: absolute;
            color: rgb(51, 51, 51);
            bottom: 10px;
            right: 10px;
        }
        .info-address{
            top: 60px;
        }
        .info-email{
            bottom: 10px;
        }
        .history-area-image{
            float: left;
            height: 100%;
            width: 18%;
            border: 1px solid rgb(158, 157, 157);
        }
        .history-area-list{
            float:left;
            height: 100%;
            width: 55%;
        }
        .history-area-list > div{
            font-weight: bold;
            font-size: 12px;
            margin-left: 20px;
        }
        .history-area-price{
            float:right;
            height: 100%;
            width: 25%;
            background-color: white;
            border-radius: 5px;
            position: relative;
            border: 1px solid rgb(158, 157, 157);
        }
        .history-area-price > div{
            position: absolute;
            font-size: 12px;
            font-weight: bold;
            width: 100%;
           
        }
        .count{
            height: 100%;
        }
        .history-area-price span{
            padding-top: 3px;
            padding-left: 3px;
            display: block;
        }
        .history-area-content{
            width: 100%;
            height: 100%;
            border-radius: 5px;
            background-color: white;
            padding: 5px;
            border: 1px solid rgb(158, 157, 157);
        }
        .store-area-content{
        	width: 100%;
            height: 100%;
            border-radius: 5px;
            background-color: white;
            padding: 5px;
            border: 1px solid rgb(158, 157, 157);
        }
        .QNA-area-content{
            width: 100%;
            height: 100%;
            border-radius: 5px;
            background-color: white;
            border: 1px solid rgb(158, 157, 157);
        }
        .QNA-area-list{
            height: 50%;
            width: 100%;
        }
        .QNA-area-list > div{
            float: left;
            height: 100%;
            text-align: center;
            line-height: 40px;
            font-size: 16px;
        }
        #QNA-title{   
            width: 60%;
        }
        #QNA-createDate{
            width: 30%;
        }
        #QNA-yn{
            width: 10%;
        }
        .store-area-list{
            float: left;
            width: 48%;
            height: 100%;
        }
        .store-area-list2{
            float: right;
            width: 48%;
            height: 100%;
        }
        #poster{
        	width: 100%;
        	height: 100%;
        }

    </style>
    <title>마이페이지</title>
</head>
<body>

	


	<%@ include file="../common/header.jsp" %>
	<%@ include file="../common/informationNavi.jsp" %>
	<% if(loginUser == null) {%>
		<script>
			location.href = ('<%=contextPath%>/loginForm.me');
		</script>
	<%} else {%>
	
	<% 
		String memberId = loginUser.getMemberId();
		String memberName = loginUser.getMemberName();
		String phone = loginUser.getPhone();
		
		String email = loginUser.getEmail();
		
		String address = loginUser.getAddress();
		String localCode = loginUser.getLocalCode();
		
		ArrayList<MemberGenre> list = loginUser.getGenreList();
		List<Reservation> resList = (ArrayList)request.getAttribute("list");
		List<Movie> movieList = (ArrayList)request.getAttribute("movieList");
		List<Board> boardList = (ArrayList)request.getAttribute("boardList");
		List<Answer> answerList = (ArrayList)request.getAttribute("answerList");


	%>
	

    <div class="content">
        <div class="title-area">
            <span class="tit">회원정보</span>
        </div>
        <div class="info-area">
            <a class="btn btn-warning" id="btn1">정보수정</a>
            <div class="info-area-content">
                <div class="info-content1">
                    <div class="info-name"><%=memberName %> 님 <div class="info-id"><%=memberId %></div></div>
                    <div class="info-address"><%=localCode%> <%=address %></div>
                    <div class="info-email"><%=memberName%></div>
                    <div class="info-genre">
                    <%if(list == null) {%>
                    <%} else { %>
                    	<% for(int i = 0; i< list.size(); i++){ %>
                    		<%= list.get(i).getGenreCode()%>
                    	<%} %>
                    <%} %>
                    </div>
                </div>
                
                <div class="info-content2">

                </div>
            </div>
        </div>
        <div class="mini-tit">MY 예매내역</div>
        <div class="history-area">
            <div class="history-area-content">
            <%if(resList == null) {%>
            	<h5 align="center">고객님의 최근 예매 내역이 존재하지 않습니다.</h5>
            <%} else { %>
                <div class="history-area-image"><img id="poster" src="<%=contextPath %>/<%= movieList.get(0).getFilePath()%>/<%=movieList.get(0).getFileName() %>"></div>
                <div class="history-area-list">
                    <div>영화&emsp;<%=resList.get(0).getMovieTitle() %></div>
                    <div>날짜&emsp;<%=resList.get(0).getWatchDate() %></div>
                    <div>극장&emsp;<%=resList.get(0).getTheaterName() %></div>
                    <div>인원&emsp;&emsp;<%=(resList.get(0).getStudentCount()+resList.get(0).getCommonCount()) %>명</div>
                </div>
                <div class="history-area-price">
                    <div class="count">
                    <span>청소년 :&nbsp;<%=resList.get(0).getStudentCount()%>&emsp;<%=resList.get(0).getStudentPrice() %>원</span>
                    <span>성인 :&nbsp;<%=resList.get(0).getCommonCount() %>&emsp;&emsp;<%=resList.get(0).getCommonPrice() %>원</span>
                    <span style="border-top: 1px solid rgb(158, 157, 157);">금액 :&emsp;&emsp;&nbsp;&nbsp;&nbsp;<%=resList.get(0).getTotalPrice() %>원</span></div>

                </div>
            <%} %>
            </div>

        </div>
        <div class="mini-tit">MY 문의글내역</div>
        <div class="QNA-area">
            <div class="QNA-area-content">
            	<%if(boardList != null) {%>
            		<%for(int i=0;i < boardList.size(); i ++) {%>
                <div class="QNA-area-list" style="border-bottom: 1px solid rgb(158, 157, 157);">
                    <div id="QNA-title"><%=boardList.get(i).getBoardTitle() %></div>
                    <div id="QNA-createDate"><%=boardList.get(i).getcreateDate() %></div>
                    <%if(answerList == null){ %>
                    <div id="QNA-yn">N</div>
                    <%} else { %>
                    <div id="QNA-yn">Y</div>
                    <%} %>
                </div>
                	<%} %>
                
				<%} else { %>
					<h5 align="center">고객님의 최근 문의 내역이 존재하지 않습니다.</h5>
				<%} %>
            </div>
        </div>
        <div class="mini-tit">MY 상품구매내역</div>
            
        <div class="store-area">
            <div class="store-area-list">
                <div class="store-area-content">
                </div>
            </div>
            <div class="store-area-list2">
                <div class="store-area-content">
                </div>
            </div>
        </div>
    </div>
<%}%>
</body>
</html>