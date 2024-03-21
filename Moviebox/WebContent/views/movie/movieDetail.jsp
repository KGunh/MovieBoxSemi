<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

    <style>
        body{
            background-color: #1A1A1A;
        }

        div{
            /* border: 1px solid red; */
            box-sizing: border-box;
        }

        .wrap{
            width: 1200px;
            margin: 0 auto;
        }

        /* 전체 컨텐츠 영역 */
        #movie-detail{
            width: 1200px;
            margin: 0 auto;
            color: white;
        }


        /* 영화 상세정보(줄거리 등) */
        #movie-detail-box{
            width: 1200px;
            height: 470px;
            margin-top: 20px;
            color: white;
            border: 1px solid #FFC145;
            position: relative;
        }

        #movie-detail-poster{
            position: absolute;
            width: 300px;
            height: 422px;
            border: 1px solid red;            
            left: 0;
            padding: 10px;
            margin: 20px;
        }

        #movie-detail-content{
            position: absolute;
            width: 850px;
            right: 0;
            padding: 10px;
            margin: 20px;
            border: 1px solid blue;
        }

        #movie-detail-title{
            width: 830px;
            height: 60px;
            line-height: 60px;
            font-size: 25px;
            font-weight: bold;
            padding-left: 10px;
            border: 1px solid lightgreen;
        }

        #movie-detail-etc{
            width: 830px;
            height: 40px;
            line-height: 40px;
            padding-left: 10px;
            margin-bottom: 15px;
            border: 1px solid sienna;
        }

        #movie-detail-director{
            width: 830px;
            height: 40px;
            line-height: 40px;
            padding-left: 10px;
            border: 1px solid salmon;
        }

        #movie-detail-actor{
            width: 830px;
            height: 40px;
            line-height: 40px;
            margin-bottom: 15px;
            padding-left: 10px;
            border: 1px solid darkcyan;
        }

        #movie-detail-story{
            width: 830px;
            height: 130px;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid chartreuse;
        }

        #movie-detail-btn{
            width: 300px;
            height: 45px;
            border: none;
            border-radius: 8px;
            font-size: 19px;
            font-weight: bold;
            background-color: #FFC145;
        }


        /* 영화 예고편 */
        #movie-detail-video{
            width: 1200px;
            padding-bottom: 30px;
            color:white;
            border: 1px solid aqua;
        }

        h1{
            padding-left: 20px;
        }

        #detail-video{
            width: 1100px;
            padding-left: 50px;
        }

        /* 영화 스틸컷*/
        #movie-detail-still{
            width: 1200px;
            height: 630px;
            color: pink;
            border: 1px solid pink;
        }

        #detail-still-img{
            width: 1100px;
            height: 500px;
            margin: 0 auto;
            padding: 25px;
            border: 1px solid darkorange;
            padding-left: 45px;
        }

        .still-img{
            width: 321px;
            height: 450px;
            border: 1px solid salmon;
            float: left;
            margin-right: 20px;
        }


    </style>
    
</head>
<body>

<body>

    <%@ include file="/views/common/header.jsp" %>

    <div id="wrap">
        <div id="movie-detail">
            <div id="movie-detail-box">
                <div id="movie-detail-poster">
                    포스터
                </div>

                <div id="movie-detail-content">
                    <div id="movie-detail-title">파묘 </div>
                    <div id="movie-detail-etc">
                        <a>미스터리</a> | <a>134분</a> | <a>15세 이상 관람가</a> | <a>2024.02.22</a>
                    </div>
                    <div id="movie-detail-director">장재현</div>
                    <div id="movie-detail-actor">최민식, 김고은, 유해진, 이도현</div>
                    <div id="movie-detail-story">미국 LA, 거액의 의뢰를 받은 무당 ‘화림’(김고은)과 ‘봉길’(이도현)은<br>
                        기이한 병이 대물림되는 집안의 장손을 만난다.<br>
                        조상의 묫자리가 화근임을 알아챈 ‘화림’은 이장을 권하고,<br>
                        돈 냄새를 맡은 최고의 풍수사 ‘상덕’(최민식)과 장의사 ‘영근’(유해진)이 합류한다.
                    </div>
                    <button id="movie-detail-btn">예매하기</button>
                </div>
            </div>

            <div id="movie-detail-video">
                <h1>예고편</h1>
                <div id="video-src">
                    <iframe id="detail-video" width="1090" height="600" src="https://www.youtube.com/embed/rjW9E1BR_30?si=v4wZ9R1k-4jWv8RI" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
                </div>
            </div>

            <div id="movie-detail-still">
                <h1>스틸컷</h1>
                <div id="detail-still-img">
                    <div class="still-img">
                        스틸컷
                    </div>
                    <div class="still-img">
                        스틸컷
                    </div>
                    <div class="still-img">
                        스틸컷
                    </div>
                </div>
            </div>

        </div> <!-- movie-detail-->
    </div> <!-- wrap -->
    
        <%@ include file="/views/common/footer.jsp" %>
    
</body>

</body>
</html>