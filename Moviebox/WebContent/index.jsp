<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://unpkg.com/swiper@8/swiper-bundle.min.css" />
<script src="https://unpkg.com/swiper@8/swiper-bundle.min.js"></script>
<style>
    div{
        border: 1px solid red;
    }
    #main-cotent{
        width: 1200px;
        height: auto;
        margin: auto;
    }
    #main-cotent > div{
        width: 100%;
    }
    #content_1{
        height: 350px;
        padding: 25px 100px 25px 100px;
    }
    .movie-chart-content{
        height: 400px;
    }
    .movie-genre-content{
        height: 290px;
        background-color: #FFC145;
    }
    .main-board-content{
        height: 460px;
    }
    /* 이미지 영역 사이즈 조절 */
    .swiper {
        width: 100%;
        height: 100%;
    }

    /* 이미지 사이즈 조절 */
    .swiper-slide>img {
        width : 100%;
        height : 100%;
    }

    /* 화살표 버튼색 변경 (기본색은 파란색) */
    div[class^=swiper-button] {
        color : white;
        /* display : none; */ /* 아니면 안보이게 숨기기도 가능 */
    }
    
    .title{
        height: 140px;
        width: 100%;
    }
    .movie-chart{
        height: 260px;
        width: 100%;
        padding: 0 100px 0 100px;
        display: flex;
        justify-content : space-between
    }
    .movie-chart > div{
        width: 190px;
        height: 100%;
    }
    </style>
</head>
<body>
    
    <%@ include file="views/common/header.jsp" %> 

    
    <div id="main-cotent">
        <div id="content_1">
            <!-- Slider main container -->
            <div class="swiper">
                <!-- Additional required wrapper -->
                <div class="swiper-wrapper" >
                    <!-- Slides -->
                    <div class="swiper-slide"><img src="https://i.namu.wiki/i/TOLSsGuigpIRPbZd4dBmJlSF0kVPpg_qKSxkJvzMM1478mNcNoAUvxvNeyhQ2FMv1Fbgd9n6nifRywMwp-R2niA3I3HtdKmDj-AHvCNEOxwAduOa3aCSJyREcDPq9itjO48cKiSPsUX3Nh3w21R2KQ.webp"></div>
                    <div class="swiper-slide"><img src="https://i.namu.wiki/i/4OFuqB8CBzUOpov4yJSBbzcaiHJKXBAWHh1P_xuIk3_83Hy65uwvLueqhFsosYwAE_Wm2aZJyj6NA4sv-Py14tqqr330nRPIBTn9hpwWBeVap_9Lkl8-Ewb1zobrTQ3rmhvbOsB0Dl9kNCrrtTefnw.webp"></div>
                    <div class="swiper-slide"><img src="https://i.namu.wiki/i/de5ZWH6baNks1yd7Ofo1TF8-vH-xndzsgkY0RGZ_RmW_swC35y99b_oCN60r3m1cFRSc9byHZBVu_eBCwPcw1jGS34ekCLqhgHHVPr19gxFHdEdOjT7XqGJxoQf-Knpui_CcZS94DP8mZ7fqqDQNDg.webp"></div>
                    <div class="swiper-slide"><img src="https://i.namu.wiki/i/UirbKQshXu0s_HnQPxDnKUblnfGyOK-Uzd1yERWftA49Li-j7k8KJ0cQJafOws8vmHLPbbBW1JIGf8SrMeFBVkxfosqId5HBRvOeGtt3rxIs1RotopHa_G2lhAoroNR0r0hikC1FHTWSBh-yh5DQUw.webp"></div>
                    <div class="swiper-slide"><img src="https://i.namu.wiki/i/jAZO3nN76J2qw032OpWmGM-LCyRog0hpVo5HWjgSTXWV_W1DIAHcoSVEzAKu8w-k8r42SlJWksOotiS5DudHOWm7YrCUP3-KfIQK9G_nkWSr9Unjm3r9Fd9YHsWWLmGbFmLyK9xzdaS9IbdXBlq91g.webp"></div>
                </div>
            
                <!-- If we need pagination -->
                <div class="swiper-pagination"></div>
            
                <!-- If we need navigation buttons -->
                <div class="swiper-button-prev"></div>
                <div class="swiper-button-next"></div>
            
                <!-- If we need scrollbar -->
                <div class="swiper-scrollbar"></div>
            </div>
        </div>
    
        <script>
            // 슬라이더 동작 정의
            const swiper = new Swiper('.swiper', {
                autoplay : {
                    delay : 1000 // 3초마다 이미지 변경
                },
                loop : true, //반복 재생 여부
                slidesPerView : 1, // 이전, 이후 사진 미리보기 갯수
                pagination: { // 페이징 버튼 클릭 시 이미지 이동 가능
                    el: '.swiper-pagination',
                    clickable: true
                },
                navigation: { // 화살표 버튼 클릭 시 이미지 이동 가능
                    prevEl: '.swiper-button-prev',
                    nextEl: '.swiper-button-next'
                }
            }); 
        </script>
        
        <div class="movie-chart-content">
            <div class="title">

            </div>
            <div class="movie-chart">
                <div></div>
                <div></div>
                <div></div>
                <div></div>
                <div></div>
            </div>
        </div>

        <div class="movie-genre-content">


        </div>

        <div class="main-board-content">

        </div>

    </div>
    
    
    
    <%@ include file="views/common/footer.jsp" %>
</body>
</html>