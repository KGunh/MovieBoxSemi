<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	int ticketNo = (int)request.getAttribute("ticketNo");

%>    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예매 완료</title>
</head>
<style>
    body{
        color: rgb(32,32,32);
    }

	div{
        box-sizing: border-box;
    }
    
    a{
        text-decoration: none;
        color: rgb(32,32,32);
    }

    #wrap{
        width: 1200px;
        height: 800px;
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

    #content-info{
        width: 1000px;
        height: 600px;
        margin: 50px auto 100px auto;
        background-color: rgb(39, 39, 39);
        padding-top: 1px;
    }

    #print-info-area{
        width: 800px;
        height: 500px;
        margin: 50px auto auto auto;
    }

    #movie-info-area{
        float: left;
        width: 250px;
        height: 450px;
        margin-top: 5px;
    }

    #reservation-info-area{
        float: left;
        width: 548px;
        height: 450px;
    }
    
    #check-btn{
        width: 100px;
        height: 50px;
        font-size: 20px;
        font-weight: 700;
        background-color: rgb(255, 193, 69);
        border: 0;
        float: right;
        margin-right: 50px;
    }

    #movie-poster{
        width: 200px;
        height: 300px;
        margin: 10px auto auto auto;
    }

    #movie-poster img{
        height: 100%;
        width: 100%;
    }

    .movie-detail-info{
        text-align: center;
        font-size: 16px;
        font-weight: 700;
    }

    #movie-info div{
        color: rgb(125, 124, 124);
    }

    #reservation-info{
        width: 500px;
        height: 400px;
        margin: 30px auto auto 50px;
    }
    #reservation-info > div{
        float: left;
        margin: 20px auto auto auto;
    }
    .select-info{
        width: 150px;
        font-size: 18px;
        font-weight: 700;
        color: rgb(125, 124, 124);
        margin-top: 15px;
        margin-bottom: 15px;
    }

    .print-info{
        width: 300px;
        font-size: 18px;
        font-weight: 400;
        color: rgb(125, 124, 124);
        margin-top: 15px;
        margin-bottom: 15px;
    }

    #check-btn a{
        color: black;
        text-decoration: none;
    }

</style>

<body>

    <%@ include file="/views/common/header.jsp" %>

    <div id="wrap">
        <div id="title">예매 완료</div>
        <div id="content-info">
            <div id="print-info-area">
                <div id="movie-info-area">
                    <div id="movie-poster"></div>
                    <div id="movie-info">
                        <div class="movie-detail-info" style="font-size: 24px; margin-top: 10px;">제목</div>
                        <div class="movie-detail-info">개봉일</div>
                        <div class="movie-detail-info">장르</div>
                        <div class="movie-detail-info">분</div>
                    </div>
                </div>
                <div id="reservation-info-area">
                    <div id="reservation-info">
                        <div>
                            <div class="select-info">티켓번호</div>
                            <div class="select-info">상영일시</div>
                            <div class="select-info">관람극장</div>
                            <div class="select-info">상영관</div>
                            <div class="select-info">관람인원</div>
                            <div class="select-info">선택좌석</div>
                            <div class="select-info" style="margin-top: 50px;">결제금액</div>
                        </div>
                        <div id="print-reservation-info">
                            <div class="print-info">티켓번호</div>
                            <div class="print-info">일시</div>
                            <div class="print-info">이름</div>
                            <div class="print-info">상영관</div>
                            <div class="print-info">인</div>
                            <div class="print-info">좌석</div>
                            <div class="print-info" style="margin-top: 50px;">금액</div>
                        </div>
                    </div>
                </div>
                <button id="check-btn"><a href="<%= contextPath %>/index.jsp">메인으로</a></button>
            </div>
        </div>
    </div>

    <%@ include file="/views/common/footer.jsp" %>


    <script>

        window.onload = function(){
            $.ajax({
                url : 'checkInfo.reservationAjax',
                type : 'post',
                data : {
                    ticketNo : <%= ticketNo %>
                },
                success : function(result) {
                    var imgFilePath = '<%= contextPath %>/' + result.movie.filePath + '/' + result.movie.fileName;
                    var selectSeatList = '';

                    $('#movie-poster').html('<img src="' + imgFilePath + '" alt="영화포스터">');
                    $('#movie-info').children().eq(0).html(result.movie.movieTitle);
                    $('#movie-info').children().eq(1).html('개봉일 : ' + result.movie.movieRelease);
                    $('#movie-info').children().eq(2).html('장르 : ' + result.movie.genreName);
                    $('#movie-info').children().eq(3).html('러닝타임 : ' + result.movie.movieRt + '분');
                
                    $('#print-reservation-info').children().eq(0).html(result.ticketNo);
                    $('#print-reservation-info').children().eq(1).html(result.watchDate);
                    $('#print-reservation-info').children().eq(2).html(result.theaterName);
                    $('#print-reservation-info').children().eq(3).html(result.screenName);
                    $('#print-reservation-info').children().eq(4).html(Number(result.price.studentCount + result.price.commonCount));

                    for(let i = 0; i < result.seatList.length; i++){
                        selectSeatList += result.seatList[i].seatNo;
                        if (i < result.seatList.length - 1) {
                            selectSeatList += ', ';
                        }
                    }

                    $('#print-reservation-info').children().eq(5).html(selectSeatList);
                    $('#print-reservation-info').children().eq(6).html(result.price.totalPrice + '원');

                },
                error : function(e) {

                }
            });
        };

    </script>

</body>
</html>