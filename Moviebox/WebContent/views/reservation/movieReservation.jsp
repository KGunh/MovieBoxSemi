<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%










%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://unpkg.com/swiper@8/swiper-bundle.min.css" />
<script src="https://unpkg.com/swiper@8/swiper-bundle.min.js"></script>
<style>
    div{
        box-sizing: border-box;
        border: 1px solid red;
    }

    #wrap{
        width: 1200px;
        height: 1530px;
    }

     /* 이미지 영역 사이즈 조절 */
     .swiper {
        width: 1200px;
        height: 400px;
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

    #title{
        padding-left: 50px;
        margin-top: 30px;
        background-color: rgb(255, 193, 69);
        font-size: 35px;
        color: rgb(32,32,32);
        font-weight: bold;
        border-bottom: 1px solid gray;
    }
    
    #selectMovieArea{
        background-color: rgb(255, 193, 69);
    }
    #selectDateArea{
        height: 100px;
        width: 100%;
    }
    #printToday{
        width: 1070px;
        height: 50px;
        margin-left: auto;
        margin-right: auto;
        margin-top: 20px;
        text-align: center;
        color: rgb(241, 241, 241);
        font-size: 30px;
        font-weight: bold;
        line-height: 40px;
    }
    
    #selectLocationArea{
        height: 60px;
    }
    #selectLocation{
        width: 1070px;
        height: 100%;
        line-height: 60px;
        float: left;
        margin-left: 62px;
    }
    #selectLocation > select{
        height: 40px;
        width: 150px;
        border-radius: 12px;
        padding-left: 8px;
        background-color: rgb(255, 193, 69);
        font-size: 20px;
    }
    #screenDate{
        height: 40px;
        border-radius: 12px;
        padding-left: 8px;
        background-color: rgb(255, 193, 69);
        width: 150px;
        font-size: 20px;
        margin-left: 15px;
    }
    #selectLocation > select:focus{
        outline: none;
    }
    #screenDate:focus{
        outline: none;
    }

    #selectScreenArea{
        height: 830px;
    }

    #printScreen{
        width: 1070px;
        height: 730px;
        margin: auto;
    }

    .screen{
        height: 155px;
        margin-top: 25px;
        border-radius: 25px;
        background-color: rgb(148, 145, 145);
    }
    .theaterName{
        height: 40px;
        padding-left: 50px;
        font-size: 25px;
        font-weight: bold;
        color: rgb(51,51,51);
    }
    .button-prev{
        font-size: 30px;
        line-height: 100px;
        width: 50px;
        height: 100px;
        float: left;
        text-align: center;
    }
    .button-next{
        font-size: 30px;
        line-height: 100px;
        width: 50px;
        height: 100px;
        float: right;
        text-align: center;
    }
    .button-prev:hover{
        cursor: pointer;
    }
    .button-next:hover{
        cursor: pointer;
    }
    .selectScreen{
        width: 750px;
        height: 100px;
        float: left;
        margin-left: 105px;
    }
    .screenName{
        float: left;
        width: 155px;
        height: 85px;
        margin-left: 65px;
        margin-top: 5px;
        border-radius: 25px;
        background-color: rgba(255, 255, 255, 0.6);
        text-align: center;
        font-size: 20px;
        font-weight: bold;
        line-height: 85px;
    }
    .screenName:hover{
        cursor: pointer;
    }

    .swiper-slide{
        position: relative;
        display: flex;
    }

    .poster{
        height: 280px;
        width: 180px;
        margin-top: 55px;
        margin-left: 20px;
        border-radius: 24px;
    }

    .poster:hover{
        cursor: pointer;
      
    }
    .poster img{
        width: 100%;
        height: 100%;
        border-radius: 24px;
        box-shadow: 2px 2px 4px rgb(32, 32, 32);
    }

    .poster:active{
        border: 1px solid black;
    }
    

</style>

</head>
<body>
    <%@ include file="/views/common/header.jsp" %>
    <div id="wrap">
        <form action="서블릿맵핑">
            <div id="title">영화예매</div>
            <div id="selectMovieArea">
                <div id="content_1">
                    <!-- Slider main container -->
                    <div class="swiper">
                        <!-- Additional required wrapper -->
                        <div class="swiper-wrapper">
                            <!-- Slides -->
                            <div class="swiper-slide">
                                <!--TB_MOVIE에서 SELECT-->
                                <div class="poster">
                                    <img src="/moviebox/resource/img/poster/poster_Exhuma.jpg">
                                </div>
                            </div>
                            <div class="swiper-slide">
                                <div class="poster">
                                    <img src="/moviebox/resource/img/poster/poster_Dune.jpg">
                                </div>
                            </div>
                            <div class="swiper-slide">    
                                <div class="poster">
                                    <img src="/moviebox/resource/img/poster/poster_SpyXFamily.jpg">
                                </div>
                            </div>
                            <div class="swiper-slide">    
                                <div class="poster">
                                    <img src="/moviebox/resource/img/poster/poster_SlamDunk.jpg">
                                </div>
                            </div>
                            <div class="swiper-slide">    
                                <div class="poster">
                                    <img src="/moviebox/resource/img/poster/poster_Wonka.jpg">
                                </div>
                            </div>
                           
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

            </div>
            <div id="selectDateArea">
                <div id="printToday"></div>
            </div>
            <div id="selectLocationArea">
                <div id="selectLocation">
                    <select>
                        <!--TB_LOCATION에서 SELECT-->
                        <option value="전체">전체</option>
                        <option value="서울">서울</option>
                        <option value="경기">경기</option>
                        <option value="인천">인천</option>
                        <option value="강원">강원</option>
                        <option value="대전">대전</option>
                        <option value="충남">충남</option>
                        <option value="충북">충북</option>
                        <option value="대구">대구</option>
                        <option value="경북">경북</option>
                        <option value="울산">울산</option>
                        <option value="부산">부산</option>
                        <option value="경남">경남</option>
                        <option value="광주">광주</option>
                        <option value="제주">제주</option>
                    </select>
                    <input id="screenDate" type="date" name="screenDate">
                </div>
            </div>
            <div id="selectScreenArea">
                <!-- 영화관 스크린 정보 -->
                <div id="printScreen">
                    <div class="screen">
                        <!--TB_SCREEN에서 SELECT-->
                        <div class="theaterName">CGV 강남</div>
                        <div class="button-prev">◀</div>
                        <div class="selectScreen">
                            <div class="screenName">
                                <span style="color: black;">23:10</span>~<span style="color: gray;">25:34</span>
                            </div>
                            <div class="screenName">
                                <span style="color: black;">23:10</span>~<span style="color: gray;">25:34</span>
                            </div>
                            <div class="screenName">
                                <span style="color: black;">23:10</span>~<span style="color: gray;">25:34</span>
                            </div>
                        </div>
                        <div class="button-next">▶</div>

                    </div>
                    <div class="screen">
                        <div class="theaterName">CGV 강북</div>
                        <div class="button-prev">◀</div>
                        <div class="selectScreen">
                            <div class="screenName">
                                <span style="color: black;">23:10</span>~<span style="color: gray;">25:34</span>
                            </div>
                            <div class="screenName">
                                <span style="color: black;">23:10</span>~<span style="color: gray;">25:34</span>
                            </div>
                            <div class="screenName">
                                <span style="color: black;">23:10</span>~<span style="color: gray;">25:34</span>
                            </div>
                        </div>
                        <div class="button-next">▶</div>
                    </div>
                    <div class="screen">
                        <div class="theaterName">메가박스</div>
                        <div class="button-prev">◀</div>
                        <div class="selectScreen">
                            <div class="screenName">
                                <span style="color: black;">23:10</span>~<span style="color: gray;">25:34</span>
                            </div>
                            <div class="screenName">
                                <span style="color: black;">23:10</span>~<span style="color: gray;">25:34</span>
                            </div>
                            <div class="screenName">
                                <span style="color: black;">23:10</span>~<span style="color: gray;">25:34</span>
                            </div>
                        </div>
                        <div class="button-next">▶</div>
                    </div>
                    <div class="screen">
                        <div class="theaterName">롯데시네마</div>
                        <div class="button-prev">◀</div>
                        <div class="selectScreen">
                            <div class="screenName">
                                <span style="color: black;">23:10</span>~<span style="color: gray;">25:34</span>
                            </div>
                            <div class="screenName">
                                <span style="color: black;">23:10</span>~<span style="color: gray;">25:34</span>
                            </div>
                            <div class="screenName">
                                <span style="color: black;">23:10</span>~<span style="color: gray;">25:34</span>
                            </div>
                        </div>
                        <div class="button-next">▶</div>
                    </div>
                </div>
            </div>
        </form>
    </div>
    <%@ include file="/views/common/footer.jsp" %>


    <script>
        // 슬라이더 동작 정의
        const swiper = new Swiper('.swiper', {
            loop : true, //반복 재생 여부
            slidesPerView : 4, // 이전, 이후 사진 미리보기 갯수
            pagination: { // 페이징 버튼 클릭 시 이미지 이동 가능
                el: '.swiper-pagination',
                clickable: true
            },
            navigation: { // 화살표 버튼 클릭 시 이미지 이동 가능
                prevEl: '.swiper-button-prev',
                nextEl: '.swiper-button-next'
            }
        }); 

        window.onload = function() {
            var today = new Date();
            var year = today.getFullYear();
            var month = (String)(today.getMonth() + 1).padStart(2, '0');
            var day = (String)(today.getDate()).padStart(2, '0');
            document.getElementById('printToday').innerHTML = year + '-' + month + '-' + day;
        }


        document.getElementById("content_1").onclick = function(e){
            /*
            for(){
                if(내가 클릭한 애랑 같은 번호일경우){
                    사이즈 조정
                }
                else{
                    기본 스타일속성 적용
                }
            }
            */
        };
        
    </script>
</body>
</html>