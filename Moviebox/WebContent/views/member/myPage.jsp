<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        .btn{
            background-color: #FFC145;
            width: auto;
            height: auto;
            position: absolute;
            font-size: 14px;
            font-weight: bold;
            top: 10px;
            right: 10px;
        }
        .btn:hover{
            border: 1px solid #1A1A1A;
        }
        .info-content1{          
            float: left;
            width: 70%;
            height: 100%;
            position: relative;
        }
        .info-name{
            position: relative;
            font-size: 30px;
            width: 100%;
        }
        .info-id{
            position: absolute;
            top: 15px;
            right:0;
            font-size: 12px;
            color: rgb(51, 51, 51);
        }
        .info-address, .info-email{
            font-size: 12px;
            position: absolute;
            color: rgb(51, 51, 51);
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
            width: 60%;
        }
        .history-area-list > div{
            font-weight: bold;
            font-size: 12px;
            margin-left: 20px;
        }
        .history-area-price{
            float:right;
            height: 100%;
            width: 20%;
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

    </style>
    <title>마이페이지</title>
</head>
<body>
    <div class="content">
        <div class="title-area">
            <span class="tit">회원정보</span>
        </div>
        <div class="info-area">
            <a class="btn">정보수정</a>
            <div class="info-area-content">
                <div class="info-content1">
                    <div class="info-name">김건희님<div class="info-id">rjsgml922</div></div>
                    <div class="info-address">경기도 양주</div>
                    <div class="info-email">rjsgml922naver.com</div>
                </div>
                
                <div class="info-content2">

                </div>
            </div>
        </div>
        <div class="mini-tit">MY 예매내역</div>
        <div class="history-area">
            <div class="history-area-content">
                <div class="history-area-image"></div>
                <div class="history-area-list">
                    <div>영화이름</div>
                    <div>날짜</div>
                    <div>극장</div>
                    <div>예매일시</div>
                </div>
                <div class="history-area-price">
                    <div class="count"><span>청소년</span><span>성인</span><span style="border-top: 1px solid rgb(158, 157, 157);;">금액</span></div>

                </div>
            </div>

        </div>
        <div class="mini-tit">MY 문의글내역</div>
        <div class="QNA-area">
            <div class="QNA-area-content">
                <div class="QNA-area-list">
                    <div id="QNA-title">제목</div>
                    <div id="QNA-createDate">날짜</div>
                    <div id="QNA-yn">Y/N</div>
                </div>
                <div class="QNA-area-list" style="border-top: 1px solid rgb(158, 157, 157);"></div>

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
    
</body>
</html>