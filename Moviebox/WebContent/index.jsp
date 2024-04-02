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

    #main-cotent{
        height: auto;
        margin: auto;
    }
    #content_1{
        height: 350px;
        padding: 25px 100px;
        width: 1200px;
        margin: auto;
        
    }
    .movie-chart-content{
        height: 400px;
        width: 1200px;
        margin: auto;
    }
    .movie-genre-content{
        margin: auto;
        height: 290px;
        background-color: #FFC145;
        width: 1200px;
        margin: auto;
        padding: 40px 100px;
        display: flex;
        justify-content : space-between
        
    }
    .main-board-content{
        height: 460px;
        padding: 105px 120px;
        width: 1200px;
        margin: auto;
    }
    
    
    .movie-title{
        height: 90px;
        width: 100%;
        padding: 45px 0 0 100px;

    }
    .movie-chart{
        height: 260px;
        width: 100%;
        padding: 0 100px;
        display: flex;
        justify-content : space-between;
        
    }
    .movie-chart > div{
        width: 170px;
        height: 100%;
    }

    .genre-content{
        width: 190px;
        height: 100%;
        padding: 35px 0px;
        font-size: 32px;
    }
    .genre-content-img{
        width: 100%;
        height: 100%;
        text-align: center;
        font-size: 20px;
        font-weight: bold;
        line-height: 50px;
    }
    .genre-content-img > img{
        display: block;
        margin: auto;
        width: 92px;
        height: 92px;
    }

    .main-board-content > div{
        float: left;
        height: 100%;
    }
    .center-number{
        background-color: white;
        border-radius: 8px;
        padding: 70px 40px;    
    	width: 40%;
    }
    .board-content{
        background-color: white;
        border-radius: 8px;
        padding: 30px;
        float: left;
        margin-left: 5%;
        width: 55%;
    }
    .tit{
        color: #FFC145;
        font-size: 32px;
    }
    .board-area{
        font-size: 16px;
    }
    .board-content table{
        width: 100%;
        border-collapse: collapse;
    }
    .board-content thead{
        height: 65px;
    }
    .tit{
        text-align: left;
        vertical-align: top;
    }
    .board-content td{
        width: 50%;
        height: 30px;
    }
    .board-area td:first-child {
    text-align: left;
    }
    .board-area td:last-child {
    text-align: right;
    }
    .number-area{
        float: left;
        width: 65%;
        height: 100%;
        position: relative;
    }
    .phone-img{
        float: left;
        width: 35%;
        height: 100%;
    }
    .phone-title{
        font-size: 32px;
        font-weight: bold;
        position: absolute;
        top: 0;
    }
    .phone-number{
        color: #FFC145;
        font-size: 36px;
        font-weight: bold;
        position: absolute;
        bottom: 0;
    }
    .phone-img {
        display: flex;
        justify-content: center; 
        align-items: center; 
        height: 100%; 
    }
    .phone-img > img{
        width: 90px;
        height: 90px;
    }
    .movie-chart img{
        width: 100%;
        height: 100%;
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
    .movie-title > div{
        color:white;
        font-size: 20px;
        font-weight: bold;
    }
    .long-div{
    	margin:auto;
    	width: 1200px;
        height: 290px;
        background-color: #FFC145;
        
    }
    </style>
</head>
<body>

	
    
    <%@ include file="views/common/header.jsp" %> 
    <script>
    window.onload = function(){
        $.ajax({
            url : 'ad.main',
            type : 'get',
            success : function(result) {

				
				let resultStr = '';
				for(let i = 0; i < result.length; i++){
					resultStr += '<div class="swiper-slide" ><img src="<%=contextPath%>/' + result[i].filePath +'/'+ result[i].changeName+'"' +'/></div>'; 

					
				}
				


				$('.swiper-wrapper').html(resultStr);
				
            },
            async : false
        });
        
        $.ajax({
        	url : 'chart.main',
        	type : 'get',
        	success : function(result) {
				
				
				let resultStr = '';
				for(let i = 0; i < result.length; i++){
					if(i==5) break;
					resultStr += '<div><img src="<%=contextPath%>/' + result[i].filePath +'/'+ result[i].changeName+'"' +'/></div>'; 
				}
				
				$('.movie-chart').html(resultStr);
				
            },
            async : false
        });
        
        $.ajax({
        	url : 'board.main',
        	type : 'get',
        	success : function(result) {

				
        		let resultStr = '';
        		for(let i = 0;i< result.length; i++){

        			if(i==4) break;

        			resultStr += '<tr class="board-area"> <td> ' + result[i].noticeTitle + '</td><td> ' + result[i].createDate + '</td> </tr>';
        			console.log(result[i].noticeTitle);
        		}
        		
        		$('.board-content tbody').html(resultStr);
        	},
        	async : false
        });
        
     // 슬라이더 동작 정의
        const swiper = new Swiper('.swiper', {
            autoplay : {
                delay : 10000 // 3초마다 이미지 변경
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
    }
    </script>

    
    <div id="main-cotent">
        <div id="content_1">
            <!-- Slider main container -->
            <div class="swiper">
                <!-- Additional required wrapper -->
                <div class="swiper-wrapper" >
                    <!-- Slides -->
                    
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
            
        </script>
        
        <div class="movie-chart-content">
            <div class="movie-title">
                <div>무비차트</div>
            </div>
            <div class="movie-chart">
                
            </div>
        </div>
        <div class="long-div">
            <div class="movie-genre-content">
                <div class="genre-content">
                    <div class="genre-content-img"><img src="data:image/jpeg;base64,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" alt="">액션</div>
                </div>
                <div class="genre-content">
                    <div class="genre-content-img"><img src="data:image/jpeg;base64,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" alt="">로맨스</div>
                </div>
                <div class="genre-content">
                    <div class="genre-content-img"><img src="data:image/jpeg;base64,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" alt="">공포/스릴러</div>
                </div>
                <div class="genre-content">
                    <div class="genre-content-img"><img src="data:image/jpeg;base64,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" alt="">코미디</div>
                </div>
                <div class="genre-content">
                    <div class="genre-content-img"><img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTX7yeOKvdGbl8pukNz4TnbuHcI5SnG79YBIg&s" alt="">애니메이션</div>
                </div>
            </div>
        </div>

        <div class="main-board-content">
            <div class="center-number">
                <div class="number-area">
                    <div class="phone-title">고객센터</div>
                    <div class="phone-number">1588-8888</div>
                </div>
                <div class="phone-img">
                    <img src="" alt="">
                </div>
            </div>
            <div class="board-content">
                <table>
                    <thead>
                        <tr>
                            <th class="tit">공지사항</th>
                        </tr>
                    </thead>
                    <tbody>
                        
                        
                    </tbody>
                </table>
            </div>
        </div>

    </div>
    
    
    
    <%@ include file="views/common/footer.jsp" %>
</body>
</html>