<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page  %>
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
        margin-top: 50px;
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
        height: 100px;
        width: 500px;
        margin: auto;
    }

    #movie-info{
        width: 800px;
        height: 50px;
        margin: auto;
        color: rgb(255, 193, 69);
        text-align: center;
        font-size: 24px;
        font-weight: 500;
    }

    .selectAge{
        float: left; 
        margin-left: 70px;
        margin-top: 5px;
    }

    .selectAge > button{
        height: 35px;
        width: 65px;
        font-size: 16px;
        font-weight: 700;
        border-radius: 8px;
        border: none;
        cursor: none;
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
        margin-bottom: 20px;
        background-color: #0e0e0e;
    }

    #select-seat{
        color: rgb(125, 124, 124);
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

    #select-btn{
        width: 100%;
        background-color: rgb(39, 39, 39);
        margin-bottom: 20px;
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
        box-shadow: 0 5px 15px rgba(255, 255, 255, 0.7);
    }
    
    .rotate {
        transform: rotateX(-50deg);
    }


</style>


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

    <style>
        .clicked{
            color: rgb(32,32,32);
            background-color: rgb(255, 193, 69);
        }

        .disabled{
            height: 28px;
            width: 30px;
            margin-top: 8px;
            font-size: 18px;
            font-weight: bold;
            text-align: center;
            line-height: 30px;
            border-top-left-radius: 12px;
            border-top-right-radius: 12px;
            background-color: crimson;
            color: black;
            pointer-events: none;
        }
        
        #check-reservation{
            float: left;
            width: 250px;
            height: 400px;
        }

        #check-info{
            position: relative;
            float: left;
            width: 500px;
            height: 350px;
            margin-top: 20px;
            margin-left: 25px;
            border-left: 1px solid rgb(125, 124, 124);
        }

        #check-movie{
            float: left;
            width: 200px;
            height: 350px;
            margin-top: 20px;
            margin-left: 25px;
        }
        
        #check-movie div{
            font-size: 12px;
            font-weight: 700;
        }

        #reservation-info{
            float: left;
            width: auto;
            height: 300px;
            margin: 0px auto auto 50px;
        }

        #reservation-info > div {
            float: left;
            font-size: 14px;
            font-weight: 700;
        }

        #poster-select{
            width: 180px;
            height: 260px;
            margin: auto;
        }

        #check-area{
            width: 800px;
            height: 400px;
            margin: 0px auto 50px auto;
            background-color: #0e0e0e;
        }

        #check-area div{
            color: rgb(125, 124, 124);
        }
        
        .select-info{
            width: 100px;
        }

        .print-info{
            width: auto;
        }

        .select-info, .print-info{
            height: 40px;
            line-height: 40px;
        }

        #payment-btn{
            position: absolute;
            right: 30px;
            bottom: 20px;
            height: 40px;
            width: 100px;
            border: 0;
            color: rgb(32,32,32);
            background-color: rgb(255, 193, 69);
            font-size: 18px;
            font-weight: 700;
        }

    </style>

    <script>
        let teenCount = 0; // 연령별 선택한 인원
        let adultCount = 0;
        let peopleCount = 0;
        let selectPeople = 0; // 총 인원
        let resvTeen = ['', 0]; 
        let resvAdult = ['', 0];
        let selectSeat = []; // 선택 좌석

        // 상영관 예약정보 가져와서 예약좌석 비활성화
        window.onload = function() {
            $.ajax({
                url : 'seat.reservationAjax',
            	type : 'get',
            	data : {
                    screenNo : <%= screenNo %>
            	},
                success : function(result){

                    result.forEach(function(seat) {
                        
                        // .line div요소 html과 배열요소 비교
                        $('.seats').each(function() {
                            if ($(this).html() === seat.seatNo) {
                                // 값이 같으면 disabled 속성 부여
                                $(this).addClass('disabled');
                                $(this).html('X');
                            };
                        });
                    });
                },
                error : function(){
                    // 경고창 보여주고 영화 선택화면으로 이동시키기
                }
            });
        };
///////////////////////////////
        $('.seats').mousedown(function() {
            $(this).addClass('aa');
        });
        
        $('.seats').mouseenter(function() {
            $(this).addClass('aa');
        });
/////////////////
        // 인원수 버튼에 대한 스타일동작 및 값처리
        $('.people-Count').click(e => {
            // 인원선택 상위 연령요소
            let ageType = $(e.target).parent().prev().children().eq(0);

            if(ageType.html() == '청소년'){
                teenCount = Number($(e.target).html());
                $('.people-teen').addClass('clicked');

                if($(e.target).hasClass('clicked')) {
                    $('.teenBtn').removeClass('clicked');
                    ageType.removeClass('clicked');
                    
                    teenCount = 0;
                }
                else{
                    $('.teenBtn').removeClass('clicked');
                    $(e.target).addClass('clicked');
                    ageType.addClass('clicked');
                }
            }
            else{
                adultCount = Number($(e.target).html());
                $('.people-adult').addClass('clicked');

                if($(e.target).hasClass('clicked')) {
                    $('.adultBtn').removeClass('clicked');
                    ageType.removeClass('clicked');
                    
                    adultCount = 0;
                }
                else{
                    $('.adultBtn').removeClass('clicked');
                    $(e.target).addClass('clicked');
                    ageType.addClass('clicked');
                }
            }
            // 총 인원수
            peopleCount = teenCount + adultCount;
            // 인원선택 초기화 -> 선택한 좌석 배열 초기화
            selectSeat = [];
             // 청소년,성인 선택 -> 좌석선택 초기화
            $('.seats').removeClass('clicked');

            printPeople();
        });

        // 선택한 인원 보여주기
        function printPeople() {
            selectPeople = teenCount + adultCount;

            if(selectPeople < 9) {
                $('#select-people').html(
                    '<div>청소년 : ' + teenCount + '명</div>'
                   +'<div>  성인 : ' + adultCount + '명</div>'
                   +'<div>  전체 : ' + selectPeople + '명</div>'
                );
            } 
            else {
                alert('선택 가능한 인원은 최대 8명입니다!');
                $('.people-Count').removeClass('clicked');
                $('.ageBtn').removeClass('clicked');
                $('#select-people').html('');

                teenCount = 0;
                adultCount = 0;
            };
            
            peopleCount = 0;
        };

        // 인원수대로 좌석선택
        $('.seats').click(e => {
            let seat = $(e.target).html();
            let index = selectSeat.indexOf(seat);

            if($(e.target).hasClass('clicked')) {
                $(e.target).removeClass('clicked');
                $("#check-area").hide();

                selectSeat.splice(index, 1);
                selectPeople += 1;
            } 
            else {
                if(selectPeople < 1 ) {
                    if(!$('.people-Count').hasClass('clicked')) alert('인원을 먼저 선택해주세요.');
                    else alert('좌석을 모두 선택하셨습니다.');
                }
                else {
                    $(e.target).addClass('clicked');
                    selectSeat.push(seat);
                    selectPeople -= 1;
                };
            };
            // 좌석 배열 오름차순 정렬 -> 정규표현식 활용
            selectSeat.sort(function(a, b) {
                // 배열요소의 문자 추출
                let strA = a.match(/[A-Z]+/)[0];
                let strB = b.match(/[A-Z]+/)[0];
                
                // 문자 비교
                if (strA < strB) {
                    return -1;
                } 
                else if (strA > strB) {
                    return 1;
                };
                
                // 문자가 같을때 숫자 추출
                let numA = parseInt(a.match(/\d+/)[0], 10);
                let numB = parseInt(b.match(/\d+/)[0], 10);

                // 숫자를 비교
                return numA - numB;
            });
        });

        // 좌석 선택 후 예매정보 하단에 표시
        $('#print-resv-info').click(function(){
            $.ajax({
                url : 'printInfo.reservationAjax',
            	type : 'post',
            	data : {
                    screenNo : <%= screenNo %>,
                    movieNo : <%= movieNo %>,
                    teenAge : resvTeen[1],
                    adultAge : resvAdult[1] 
                },
                success : function(result){
                    if(!(selectSeat.length === 0) && selectPeople === 0){
                        $("#check-area").removeAttr("hidden");
                        $("#check-area").show();

                        let resultStr = '';
                        
                        resultStr += '<div id="check-reservation">'
                                   +     '<div id="check-movie">'
                                   +         '<div id="poster-select"><img style="width: 100%; height: 100%;" src="<%= contextPath %>/'+ result.movie.filePath + '/' + result.movie.fileName + '" alt="영화포스터"></div>'
                                   +         '<div id="movie-select">'
                                   +             '<div style="text-align: center; font-size:20px; font-weight: 700; margin-top: 5px; margin-bottom: 5px;">' + result.movieTitle + '</div>'
                                   +             '<div style="text-align: center;">개봉일 ' + result.movie.movieRelease + '</div>'
                                   +             '<div style="text-align: center;">' + result.movie.genreName + ' / ' + result.movie.movieRt + '분</div>'
                                   +         '</div>'
                                   +     '</div>'
                                   + '</div>'
                                   + '<div id="check-info">'
                                   +     '<div id="reservation-info">'
                                   +         '<div>'
                                   +             '<div class="select-info">상영일시</div>'
                                   +             '<div class="select-info">관람극장</div>'
                                   +             '<div class="select-info">상영관</div>'
                                   +             '<div class="select-info">관람인원</div>'
                                   +             '<div class="select-info">선택좌석</div>'
                                   +             '<div class="select-info" style="margin-top: 50px;">결제금액</div>'
                                   +         '</div>'
                                   +         '<div>'
                                   +             '<div class="print-info">'+ result.watchDate +'</div>'
                                   +             '<div class="print-info">' + result.theaterName + '</div>'
                                   +             '<div class="print-info">' + result.screenName + '</div>'
                                   +             '<div class="print-info">' + Number(resvTeen[1] + resvAdult[1]) + '인</div>'
                                   +             '<div class="print-info">' + selectSeat.join(', ') + '</div>'
                                   +             '<div class="print-info" style="margin-top: 50px;">' + result.price.totalPrice + '원</div>'
                                   +         '</div>'
                                   +     '</div>'
                                   +     '<form id="payment-form" action="/moviebox/payment.reservation" method="post">'
                                   +         '<input type="hidden" name="movieNo" value="' + <%= movieNo %> + '">'
                                   +         '<input type="hidden" name="screenNo" value="' + <%= screenNo %> + '">'
                                   +         '<input type="hidden" name="memberNo" value="' + <%= loginUser.getMemberNo() %> + '">'
                                   +         '<input type="hidden" name="teen" value="' + resvTeen[1] + '">'
                                   +         '<input type="hidden" name="adult" value="' + resvAdult[1] + '">'
                                   +         '<input type="hidden" name="seatNo" value="' + selectSeat.join(',') + '">'
                                   +         '<button type="submit" id="payment-btn" onclick="return payment()">결제 하기</button>'
                                   +     '</form>'
                                   + '</div>';

                        $('#check-area').html(resultStr);
                    }
                    else {
                        alert('좌석을 모두 선택해주세요!');
                        $("#check-area").hide();
                    };
                },
                error : function(e){
                    alert('예매정보 오류!');
                }
            });
        });
        
        // 결제하기
        function payment(){
            if(confirm('현재 예매 정보로 결제하시겠습니까?')) {
                return true;
            };

            return false;
        };
    </script>

</body>
</html>