<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = " java.util.ArrayList, com.kh.member.model.vo.Member" %>
 <% Member m = (Member)request.getAttribute("member"); %>
        
 

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원조회</title>

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
       

        

        #content{height : 1500px;}

      
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
                
           /* border : 1px solid red; */
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
        .menu {
            width: 200px;
            overflow: hidden;
            margin: 20px auto;
            padding: 0%;
        }
        .menu > li {
            width: 198px;
            text-align: center;
            line-height: 57px;
            background-color: #323232;
            list-style: none;
        }
        .menu a {
            color: #fff;
            text-decoration: none;
            font-weight: bold;
        }
        .menu a:hover {
            color: #1A1A1A;
            text-decoration: none;
        }
        .submenu > li {
            line-height: 50px;
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


        .table table-hover{
            
            
            border: 1px solid white;             
        }

        .title{
            background-color: rgba(211, 211, 211, 0.171);
            width: 100px;
            text-align: center;
            color: rgb(255, 255, 255);
            font-size: 14px;
            font-weight: bolder;
           
           
        }

        #table > tr,td {
            height: 50px;
            width: 250px;
            font-size: 14px;
            text-align: left;
            margin-top: 10px;
            margin-right: 10px;
            color:white;
            border-bottom: 1px solid white;
            
            
        }

       
      

       
       
       #buttoon{
        float: right;
        margin-top: 50px;
        margin-right: 30px;
       }
            
       .btn1{
        height: 30px;
        width: 60px;
        background-color:   #FFC145;
        color: rgb(77, 77, 77);
        border: gainsboro;
        border-radius: 5px;
        font-size: 12px;
        font-weight: bold;
       } 

       .content_2_top {
        margin-top: 70px;
        height: 550px;
       }
       
       
        div{
           /* border : 1px solid red;  */
            box-sizing : border-box;
        }

      
        /*-----------------------여기까지는 테두리------*/


        /* -------------------------------------------*/

       


        #p{
            margin-top: 24px;
            margin-bottom: 30px;
            font-size: x-large;
            font-weight: bold;
            
        }
        
         .input1{
        width: 500px;
        height: 27px;
        border: none;
        color: rgba(255, 255, 255, 0.959);
        background-color: #1A1A1A;
        border-radius: 5px;
       }
        
         #content2{
        height: 800px;
        width: 995.6px;
        display: inline-block;
        background-color: #1A1A1A;
        
       }
        
        
        
        
          

   



    </style>
</head>
<body>
  
  	<!-- 헤더 -->
    <%@ include file="/views/common/header.jsp" %>
    
    <div id="wrap">


        <div id="top_wrap">
            <div class="top_1">
                <h1>관리자</h1>
            </div>

        </div>

        <div id="content">
            <div class="content_1">
                <ul class="menu">
                    <li>
                        <a href="#">회원 관리</a>
                        <ul class="submenu">

                        </ul>
                    </li>
                    <li>
                        <a href="#">영화 관리</a>
                        <ul class="submenu">

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
                        <li><a href="#">공지 관리</a></li>
                        <li><a href="#">문의 게시글 관리</a></li>
                        </ul>
                    </li>
                </ul>    
            </div>

            <!------------------------------------------------------------>
			 <div id="content2">
            <div class="content_2">
                <h2> 회원 기본 정보</h2>
                <div class="content_2_top">
                 
                 
                 
                 
                      <table class="table table-hover"  style="height: 490px;">
                      <tbody>
                        <tr>
                            
                            <th class="title">회원번호</th>
                            <td><input type="text" class="input1" name="memberNo" value="<%=m.getMemberNo()%>" readonly></td>
                        </tr>
                           
                            <tr>  
                              <th class="title">이름</th>
                              <td><input type="text" class="input1" name="memberName" value="<%=m.getMemberName()%>" ></td>
                              
                            </tr>
                            
                             <tr>
                              <th class="title">아이디</th>
                              <td><input type="text" class="input1" name=memberId value="<%=m.getMemberId()%>" readonly></td>
                            </tr>
                            
                             <tr>
                              <th class="title">비밀번호</th>
                              <td><input type="text" class="input1" value="<%=m.getMemberPwd()%>" readonly></td>
                            </tr>
                            
                            <tr>  
                            
                              <th class="title">성별</th>
                              <td><input type="text" class="input1" value="<%=m.getGender()%>" readonly></td>
                            </tr>  
                            <tr>
                              <th class="title">생년월일</th>
                              <td><input type="text" class="input1" value="<%=m.getBirthday()%>"></td> 
                            </tr>
                             <tr>
                              <th class="title">이메일</th>
                              <td><input type="text" class="input1" name="Email" value="<%=m.getEmail()%>" readonly></td> 
                            </tr>
                            <tr>
                              <th class="title">주소</th>
                              <td><input type="text" class="input1" name="address" value="<%=m.getAddress()%>" ></td>
                            </tr>
                            <tr>  
                              <th class="title">전화번호</th>
                              <td><input type="text" class="input1" name="phone" value="<%=m.getPhone()%>" ></td>
                            </tr>
                            <tr>
                              <th class="title">가입일</th>
                              <td><input type="text" class="input1" value="<%=m.getEnrollDate()%>"></td>
                            </tr>  
                            <tr>
                              <th class="title">탈퇴여부</th>
                              <td><input type="text" class="input1" name="status" value="<%=m.getStatus()%>"></td>
                            </tr>
                            
                           
                          </tbody>
                              </table>


                </div>
                <div id="buttoon">
                   <button class="btn1" onclick="enrollment();">수정</button>
                   <button class="btn1" onclick=>닫기</button>
                </div>
                
                <script>
                
                function enrollment(){                	
                	location.href='<%=contextPath%>/revisedAdmin.mb';
                }
                
                </script>
            </div>
            </div>
            <%@ include file="/views/common/footer.jsp" %>
 	<!-- 푸터 -->
  
        </div>
</div>


    

 	
  
  
  

</body>
</html>
