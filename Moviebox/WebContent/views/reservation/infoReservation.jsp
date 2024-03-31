<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                <div id="movie-poster">
                    <img src="" alt="영화포스터">
                </div>
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
                        <div class="select-info">상영일시</div>
                        <div class="select-info">관람극장</div>
                        <div class="select-info">상영관</div>
                        <div class="select-info">관람인원</div>
                        <div class="select-info">선택좌석</div>
                        <div class="select-info" style="margin-top: 50px;">결제금액</div>
                    </div>
                    <div>
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
/*
    window.onload = function(){
        $.ajax({
            url : ,
            type : ,
            data : {

            },
            success : function(result) {

            },
            else{

            };
        });
    }

*/

</script>




</body>
</html>