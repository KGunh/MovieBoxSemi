<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    String contextPath = request.getContextPath();
    
    %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>


    <style>
        
 *{
            box-sizing: border-box;
        }
        body {
            background-color: #1A1A1A
        }
        #header{
           margin: auto;
            height : 200px;
            width: 1200px;
        }

        #top-header{
            height: 75px;
            position: relative;
            border-bottom: 1px solid lightgray;
        }
        #login-area{
            position: absolute;
            right: 30px;
            top: 20px;

        }
        #login-area > a{
            display: block;
            float: right;
            text-decoration-line: none;
            color: white;
            font-size: 16px;
            margin-left: 30px;
            font-weight: bold;
        }
        

        #header-navigator{
            height : 125px;
            
            border-bottom: 1px solid lightgray;
        }

        #logo-div{
            position: relative;
            float: left;
            height: 100%;
            width: 30%;

        }

        #content{height : 1500px;}

        #logo{
            position: absolute; 
            top: 50%;
            margin-top: -25px;
            width: 100%;
            height: 50px;
            font-size: 50px;
            font-weight: bold;
            color: #FFC145;
            line-height: 45px;
            
            text-align: center;
        }
        a {
            text-decoration-line: none;
        }
        #logo > a{
            text-decoration-line: none;
            color: #FFC145;
        }
        #navigator{
            float: right;
            width: 50%;
            height: 100%;
            margin-right: 15%;
        }
        .navi{
            float:left;
            width: 20%;
            height: 100%;
            text-align:center;
            margin: 0 auto;
        }
        .navi > a{
            display: block;
            text-align: center;
            width: 100%;
            height: 100%;
            color: white;
            text-decoration-line: none;
            line-height: 125px;
            font-size: 18px;
            font-weight: bold;
        }

          
            div{
           
           
          
            box-sizing : border-box;
        }
        /* 전체를 감싸는 #wrap div */
        #wrap{
            /*width: 1200px;*/
            margin: 0 auto;
        }
        #top_wrap{
            width: 1200px;
            height : 150px;
            margin: 0 auto;
            background-color: #212121;
        }
        .top_1{
            display: inline-block;
            width: 200px;
            height: 150px;
            background-color: #212121;
        }
        .top_2{
            display: inline-block;
            width: 200px;
            height: 150px;
            background-color: #212121;
            float: right;
            margin-right: 150px;
        }
        #content{
            width: 1200px;
            height : 800px;
            margin: 0 auto;
            
        }
        .content_1{
            display: inline-block;
            vertical-align: top;
            width : 200px;
            height : 800px;
            padding-top: 20px;
            background-color: #323232;
        }
        .content_2{
            display: inline-block;
            vertical-align: top;
            width : 880px;
            height : 800px;
            padding-left: 50px;
            padding-top: 20px;
            color: white;
            
        
        }

        .content_2_top{
            padding: 20px 0px 0px 40px;
            height: 80px;
            width: 880px;
            border-bottom: 2px solid lightgray;
            
        }
        .menu {
            width: 200px;
            overflow: hidden;
            margin: 20px auto;
            padding: 0%;
            height: 500px;
        }
        .menu > li {
            width: 198px;
            text-align: center;
            line-height: 60px;
            background-color: #323232;
            list-style: none;
           
            
          
        }
        .menu a {
            color: #fff;
            text-decoration: none;
            font-weight: bold;
            display : block;
        }


        .menu a:hover {
            color: #1A1A1A;
            text-decoration: none;
        }
        .submenu > li {
            line-height: 57px;
            background-color: #FFC145;
            list-style: none;
            
            
        }
       

        .submenu {
            height: 0; /*ul의 높이를 안보이게 처리*/
            overflow: hidden;
           
        }

      
        .menu > li:hover {
            background-color: #FFC145;
            transition-duration: 0.5s;
        }
        .menu > li.post:hover .submenu {
            height: 100px; /*서브메뉴 li한개의 높이 50*5*/
            transition-duration: 1s;
        }
        .top_1 > h1{
            color: #FFC145;
            text-align: center;
            padding-top: 30px;
        }
        .top_2 > span > a{
            text-decoration: none;
            color: white;
            display: inline-block;
            text-align: center;
        }
        .top_2 {
            line-height: 150px;
            text-align: center;
        }

        .menu .submenu{
            padding-left: 0;
        } 


     
     #select{
        
        display: inline;
     }
       
       

      
       

       
       #btn1{
        width: 100px;
        border: none;
        font-size: 14px;
        height: 35px;
        border-radius: 8px;
        
        background-color: #FFC145;
      }

      #btn1:hover{
        box-shadow: 10px;
      }


       #btn{
        height: 31px;
        width: 35px;
        border: none;
        border-radius: 5px;
        margin-right: 0px;
       }

       #delete{
        float: right;
        width: 100px;
        height: 50px;
        
       }

       #content_2_content{
        height: 500px;
        width: 880px;
        margin-top: 110px;
        
       
       }
       #content_2_content> div {
     
        
        height: 40px;
      
        margin: 20px 0px 20px;
       
       }
     

      
      .input{
       float: right;
       text-align: center;
       height: 39px;
       width: 650px;
       border-radius: 5px;
       font-size: 15px;
       border: 1px solid white;
       color: dimgray;
       
    }

    .input1{
        float: right;
        text-align: center;
        height: 39px;
        width: 527px;
        font-size: 15px;
        border-radius: 5px;
        margin-left: 25px;
        border: 1px solid white;
        color: dimgray
     

    }

    .input2{
        float: right;
        text-align: center;
        height: 39px;
        width: 99px;
        font-size: 15px;
        border-radius: 5px;
        margin-left: 25px;
        border: 1px solid #fff;
        color: dimgray
      
    }
    .name {
        font-size: 20px;
        font-weight:600;
        color: #a7a6a6;
        margin-left: 15px;
    }

    #address{
        width: 200px;
        display: inline;
        
    }
    
    #map {
    
     	float: right;
        text-align: center;
        height: 39px;
        width: 650px;
        font-size: 15px;
        border-radius: 5px;
        margin-left: 25px;
        border: 1px solid #fff;
        color: dimgray;
       	background-color:white;
    
    
    
    }

    

       
     

     


    </style>
</head>
<body>
   <div id="header">
      <div id="top-header">
         <div id="login-area">
            <a href="#" class="member">회원가입</a> <a href="#" class="member">로그인</a>
         </div>
      </div>
      <div id="header-navigator">
         <div id="logo-div">
            <div id="logo">
               <a href="#">MOVIE MOX</a>
            </div>
         </div>
         <div id="navigator">
            <div class="navi">
               <a href="#" id="reservation">예매</a>
            </div>
            <div class="navi">
               <a href="#" id="movie">영화</a>
            </div>
            <div class="navi">
               <a href="#" id="theater">영화관</a>
            </div>
            <div class="navi">
               <a href="#" id="notice">고객센터</a>
            </div>
            <div class="navi">
               <a href="#" id="myPage">마이페이지</a>
            </div>
         </div>

      </div>

   </div>
<!-- 여기까지가 헤더 -->

<body>
    <div id="wrap">
        <!-- jsp에서 header include하기 -->
    
        <div id="top_wrap">
            <div class="top_1">
                <h1>관리자</h1>
            </div>
            <div class="top_2" style="color: white;">
               
            </div>
        </div>
       <div id="content">
            <div class="content_1">
                <ul class="menu">
                    <li>
                        <a href="<%=contextPath %>/selectAdmin.mb">회원 관리</a>
                        <ul class="submenu">

                        </ul>
                    </li>
                    <li>
                        <a href="<%=contextPath %>/adminMovieCheck.admin?currentPage=1">영화 관리</a>
                        <ul class="submenu" >

                        </ul>
                    </li>
                    <li>
                        <a href="<%=contextPath%>/checkAdmin.cm">영화관 관리</a>
                        <ul class="submenu">

                        </ul>
                    </li> 
                    <li class="post">
                        <a href="#">게시글 관리</a>
                        <ul class="submenu">
                        <li><a href="<%=contextPath %>/adminBoardCheck.admin?currentPage=1">공지 관리</a></li>
                        <li><a href="<%=contextPath %>/adminQnACheck.admin?currentPage=1">문의 게시글 관리</a></li>
                        </ul>
                    </li>
                </ul>    
            </div>
            <div class="content_2">
                <h2>영화관 관리 〉영화관 등록</h2>
                <div class="content_2_top">
                
            </div>
            <div id="content_2_content" >
                
                <form action="<%=contextPath%>/insertAdmin.cm" method="get"> 
               
                <div>
                    <span class="name" id="region">지역</span>
                    <select name="region" class="input" style="width: 650px; height: 39px;">
                        <option value="지역" name="서울">서울</option>
                        <option value="지역">경기</option>
                        <option vlaue="지역">인천</option>
                        <option value="지역">강원</option>
                        <option value="지역">충남</option>
                        <option value="지역">충북</option>
                        <option value="지역">대구</option>
                        <option value="지역">경북</option>
                        <option value="지역">울산</option>
                        <option value="지역">부산</option>
                        <option value="지역">경남</option>
                        <option value="지역">광주</option>
                        <option value="지역">제주</option>
                    </select>
                
                </div>
                <div>
                    <span class="name">영화관 이름</span>
                    <input type="text" class="input" placeholder="영화관 이름을 입력하시오" name="name">
                </div>
              
                <div><span class="name">주소</span>
                    <div id="address">
                        <input type="text" class="input1" placeholder="상세주소를 입력해주시오" name="address">

                   <script>
                   
                   
                   
                   </script>

                   

                    <select name="" id="city" class="input2">
                        <option value="시" >시/군/구</option>
                        <option value=""></option>
                        <option value=""></option>

                    </select>
                    <div>
                       
                          
                      </div>   
                </div>

                </div>
                <div>
                    <span class="name">지도</span>
                    <div id="map">
                    a태그 자리
                    </div>
                </div>
                <div id="delete" >
                    <input type="submit" id="btn1" value="등록"></button>
                </div>
                
                </form>
                
            </div>
               
                </div>
       
                </div>
                      
                </div>

       

               </div > 
                
             






</body>
</html>