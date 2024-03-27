<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page  %>
<%
    String screenDate = (String)request.getAttribute("screenDate");
    String screenName = (String)request.getAttribute("screenName");
	String movieTitle = (String)request.getAttribute("movieTitle");
	String screenNo = (String)request.getAttribute("screenNo");
	String movieNo = (String)request.getAttribute("movieNo");

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
        border: 1px solid red;
        box-sizing: border-box;
    }
    a{
        text-decoration: none;
        color: rgb(32,32,32);
    }

    #wrap{
        width: 1200px;
        height: auto;
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
        height: 280px;
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
        height: 55px;
        width: 500px;
        display: flex;
        align-items: center;
        justify-content: center;
        margin: auto;
    }

    .line-wrap{
        width: 750px;
        height: 55px;
        margin: auto;
        display: flex;
        align-items: center;
        justify-content: space-evenly;
    }

    .seats{
        height: 28px;
        width: 30px;
        margin-top: 8px;
        font-size: 14px;
        font-weight: 600;
        text-align: center;
        line-height: 30px;
        border-top-left-radius: 12px;
        border-top-right-radius: 12px;
        background-color: rgba(70, 69, 69, 0.82);
        color: rgb(125, 124, 124);
    }

    .seats:hover{
        cursor: pointer;
        transform: scale(1.2);
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
        height: 50px;
        width: 600px;
        margin-left: 300px;
    }
    #movie-info{
        width: 600px;
        height: 50px;
        margin-left: 300px;
        color: rgb(255, 193, 69);
        text-align: center;
        font-size: 24px;
        font-weight: 500;
    }

    #selectAge{
        float: left; 
        margin-left: 70px;
        margin-top: 5px;
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
        margin-top: 5px;
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

    #select-seat{
        color: rgb(125, 124, 124);
    }

    .ageBtn:hover{
        background-color: rgb(255, 193, 69);
    }

    #select-people{
        height: 80px;
        width: 200px;
        margin: auto;
        text-align: center;
        color: rgb(125, 124, 124);
        font-size: 16px;
        font-weight: 500;
    }

    #print-resv-info{
        color: rgb(32,32,32);
        background-color: rgb(255, 193, 69);
        height: 60px;
        width: 150px;
        border: 0;
        font-size: 24px;
        font-weight: 700;
        margin-left: 850px;
    }

    #select-seat-area{
        width: 800px;
        margin: auto;
        padding-top: 50px;
        padding-bottom: 50px;
        height: auto;
    }

    /* 스크린 모양 만들기 */
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
            <div id="movie-info"><%= movieTitle %> <%= screenName %> <%= screenDate %></div>
            <div id="select-wrap">
                <div id="selectAge">
                    <button class="people-teen ageBtn">청소년</button>
                    <button class="people-adult ageBtn">성인</button>
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
        <button id="print-resv-info" >좌석 선택</button>

        <div id="select-seat-area">
            <div id="select-seat">
                예매 예정 정보 출력 영역
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
        var selectPeople = 0;
        var ageType = '';
        var resvTeen = ['', 0];
        var resvAdult = ['', 0];

        window.onload = function() {
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
            
            printPeople();
        });
        // 청소년 성인 구분하여 숫자넣기
        $('.ageBtn').click(e => {
            if($(e.target).hasClass('clicked')){
                $('.ageBtn').removeClass('clicked');

                ageType = '';
            } 
            else{
                $('.ageBtn').removeClass('clicked');
                $('.people-Count').removeClass('clicked');
                $(e.target).addClass('clicked');
                ageType = ($(e.target).html() == '성인' ? 'adult' : 'teen');
            };
            
            printPeople();
        });
        // 선택한 인원 보여주기
        function printPeople(){
            if(ageType == 'teen'){
                resvTeen = [ageType, peopleCount];
                
            }
            else if(ageType == 'adult') {
                resvAdult = [ageType, peopleCount];

            };

            selectPeople = resvTeen[1] + resvAdult[1];

            if(Number(resvTeen[1] + resvAdult[1]) < 9){
                $('#select-people').html(
                    '<div>청소년 : ' + resvTeen[1] + '명</div>'
                   +'<div>  성인 : ' + resvAdult[1] + '명</div>'
                   +'<div>  전체 : ' + selectPeople + '명</div>'
                );
            } 
            else {
                alert('선택 가능한 인원은 최대 8명입니다!');
                $('#select-people').html('');
            };

            peopleCount = 0;
        };

        $('.seats').click(e => {
            if($(e.target).hasClass('clicked')){
                $(e.target).removeClass('clicked');
                selectPeople += 1;
            } 
            else{
                if(selectPeople < 1 ){
                    if(!$('.people-Count').hasClass('clicked')){
                         alert('인원을 먼저 선택해주세요.');
                    }
                    else {
                        alert('좌석을 모두 선택하셨습니다.');
                    }
                }
                else{
                    $(e.target).addClass('clicked');
                    selectPeople -= 1;
                };
            };
        });

        

        // 좌석 선택 후 예매정보 하단에 표시
        $('#print-resv-info').click(function(){
            $.ajax({
                url : 'printInfo.reservationAjax',
            	type : 'post',
            	data : {
                    screenNo : <%= screenNo %>,
                    movieNo : <%= movieNo %>
            	},
                success : function(result){
                    console.log(result);
                },
                error : function(){

                }
            });
        });






         
    	
        


    </script>



</body>
</html>