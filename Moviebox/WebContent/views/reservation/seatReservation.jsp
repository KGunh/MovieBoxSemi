<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page  %>
<%
	String screenNo = (String)request.getAttribute("screenNo");
	String movieNo = (String)request.getAttribute("movieNo");
	String screenDate = (String)request.getAttribute("screenDate");

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>좌석 선택</title>
</head>
<style>
    body{
        color: rgb(32,32,32);
    }
	div{
        /*border: 1px solid red;*/
        box-sizing: border-box;
    }
    a{
        text-decoration: none;
        color: rgb(32,32,32);
    }

    #wrap{
        width: 1200px;
        height: 1000px;
    }

    #title{
        height: 80px;
        width: 100%;
        margin-top: 30px;
        color: rgb(32,32,32);
        background-color: rgb(255, 193, 69);
        font-size: 35px;
        font-weight: 700;
        line-height: 80px;
        padding-left: 30px;
    }

    #selectPersonArea{
        height: 200px;
        width: 100%;
    }

    #seat-title{
        height: 50px;
        font-size: 24px;
        font-weight: 700;
        color: rgb(148, 145, 145);
        line-height: 50px;
        text-align: center;
    }

    .line{
        height: 50px;
        width: 100%;
    }

    .seats{
        float: left;        
        height: 30px;
        width: 30px;
        margin-top: 8px;
        margin-left: 10px;
        font-size: 14px;
        text-align: center;
        line-height: 30px;
        border-radius: 6px;
        background-color: rgba(70, 69, 69, 0.82);
        color: rgb(125, 124, 124);
    }

    .seats:hover{
        cursor: pointer;
        transform: scale(1.2);
    }

    .line-wrap{
        width: 750px;
        height: 50px;
        margin: auto;
        display: flex;
        align-items: center;
        justify-content: center;
    }

    #selectText{
        height: 100px;
        color: rgb(255, 193, 69);
        padding-top: 30px;
        padding-left: 30px;
        font-size: 28px;
        font-weight: 700;
    }
    
    #select-wrap{
        height: 150px;
        width: 600px;
        margin-left: 300px;
    }

    #selectAge{
        float: left; 
        margin-left: 70px;
        margin-top: 10px;
    }

    #selectAge > button{
        height: 35px;
        width: 65px;
        font-size: 16px;
        font-weight: 700;
        border-radius: 8px;
        border: none;
    }

    #selectPerson{
        float: left;
        margin-left: 20px;
        margin-top: 10px;
    }

    #selectPerson > button{
        height: 35px;
        width: 35px;
        border: none;
        border-radius: 8px;
    }

    #selectPerson > button:hover{
        background-color: rgb(255, 193, 69);
        color: rgb(32,32,32);
    }

    #seat-arrange{
        width: 800px;
        height: 450px;
        margin: auto;
        border: 1px solid rgb(125, 124, 124);
    }

    .screen-wrap {
        height: 100px;
        perspective: 1000px;
        display: flex;
        align-items: center;
        justify-content: center;
        margin: 0;
    }

    .screen {
        width: 400px;
        height: 80px;
        background-color: white;
        box-shadow: 0 3px 10px rgba(255, 255, 255, 0.7);
    }
    
    .rotate {
        transition: all 0.001ms ease-out;
        transform: rotateX(-50deg);
    }

</style>


<body>
	<%@ include file="/views/common/header.jsp" %>
	<div id="wrap">
        <div id="title">영화예매</div>

        <div id="selectPersonArea">
            <div id="selectText">
                인원 선택
                <div style="color:rgb(148, 145, 145); font-size: 16px;">
                    최대 8명까지 선택 가능
                </div>
            </div>
            <div id="select-wrap">
                <div id="selectAge">
                    <button>청소년</button>
                    <button>성인</button>
                </div>
                <div id="selectPerson">
                    <button class="people-Count">1</button>
                    <button class="people-Count">2</button>
                    <button class="people-Count">3</button>
                    <button class="people-Count">4</button>
                    <button class="people-Count">5</button>
                    <button class="people-Count">6</button>
                    <button class="people-Count">7</button>
                    <button class="people-Count">8</button>
                </div>
            </div>
        </div>
        
        <div id="seat-wrap">
            <div id="seat-title"> 좌석 선택 </div>
            <div id="seat-arrange">
                <div class="screen-wrap">
                    <div class="screen"></div>
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
        <button>좌석 선택</button>

        <div id="select-seat-area">
            <div id="select-seat">

            </div>
        </div>
	</div>
	<%@ include file="/views/common/footer.jsp" %>

    <style>
        .clicked{
            color: rgb(32,32,32);
            background-color: rgb(255, 193, 69);
        }

    </style>

    <script>
        var peopleCount = 0;
       
        window.onload = function() {
            $('.screen').addClass('rotate');
            
            $.ajax({
                url : 'seat.reservationAjax',
            	type : 'get',
            	data : {
                    screenNo : <%= screenNo %>
            	},
                success : function(result){
                    console.log(result);
                },
                error : function(){

                }
            });
            
        };

        // 인원수 버튼에 대한 스타일동작 및 값처리
        $('.people-Count').click(e => {
            peopleCount = (Number)($(e.target).html());
            $('.seats').removeClass('clicked');

            if($(e.target).hasClass('clicked')){
                $('.people-Count').removeClass('clicked');
                peopleCount = 0;
            } 
            else{
                $('.people-Count').removeClass('clicked');
                $(e.target).addClass('clicked');
            }
        });

        $('.seats').click(e => {
            if($(e.target).hasClass('clicked')){
                $(e.target).removeClass('clicked');
                peopleCount += 1;
            } 
            else{
                if(peopleCount < 1 ){
                    if(!$('.people-Count').hasClass('clicked')) alert('인원을 먼저 선택해주세요.');
                    else alert('좌석을 모두 선택하셨습니다.');
                }
                else{
                    $(e.target).addClass('clicked');
                    peopleCount -= 1;
                };
            };


        });

         
    	
        


    </script>



</body>
</html>