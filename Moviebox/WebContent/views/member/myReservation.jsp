<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        div{
            border: 1px solid red;
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
            height: 1200px;
            padding-top: 50px;
        }
        #reservationList > div{
            width: 950px;
            height: 200px;
            margin: auto;
            margin-bottom: 50px;
            background-color: rgb(33, 33, 33);
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
        }
        .countPrice{
            width: 100%;
            height: 50%;
        }
        #contentTable{
            color: white;
            width: 100%;
        }
        #contentTable td{
            font-size: 13px;
            font-weight: bold;
        }
    </style>    
</head>
<body>
	<%@ include file="../common/header.jsp" %>
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
            <div id="reservationList-content">
                <div class="res-img">
                    <div><img src="" alt=""></div>
                </div>
                <div class="res-content">
                    <div>
                        <table id="contentTable">
                            <thead>
                                <tr>
                                    <th colspan="4">파묘</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>예약번호</td>
                                    <td>240302-0015-4243</td>
                                    <td>상영관</td>
                                    <td>1관</td>
                                </tr>
                                <tr>
                                    <td>극장</td>
                                    <td>CGV 양주옥정</td>
                                    <td>시간</td>
                                    <td>09:40~11~26</td>
                                </tr>
                                <tr>
                                    <td>날짜</td>
                                    <td>2024-03-02(토)</td>
                                    <td>좌석</td>
                                    <td>F9</td>
                                </tr>
                                <tr>
                                    <td>인원</td>
                                    <td>성인 1명</td>
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
                            <h6>총 인원 : </h6>
                        </div>
                        <div class="countPrice">
                            <h6>청소년 :</h6>
                            <h6>성인 :</h6>
                        </div>
                        <div class="totalPrice">
                            <h6>총 가격 : </h6>
                        </div>
                    </div>
                </div>
            </div>
            <div>

            </div>
        </div>
    </div>
	

</body>
</html>