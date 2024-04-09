<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.movie.model.vo.Movie,java.util.List,java.util.ArrayList,com.kh.theater.model.vo.Screen,com.kh.theater.model.vo.Theater,java.text.SimpleDateFormat,java.util.Date,com.kh.movie.model.vo.Movie"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	List<Screen> screenList = (ArrayList)request.getAttribute("screenList");
    
    Theater th = (Theater)request.getAttribute("theater");

    List<Movie> movieNameList = (ArrayList)request.getAttribute("movieNameList");
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date currentDate = new Date();

%>    
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <style>

        
        div{
           /* border : 1px solid red;  */
            box-sizing : border-box;
        }

        /* 전체를 감싸는 #wrap div */
        #wrap{
            /*width: 1200px;*/
            margin: 0 auto;
            /*border : 1px solid red;*/
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
            padding:20px 20px 40px 20px;

        }



        .menu {
            width: 200px;
            overflow: hidden;
            margin: 20px auto;
            padding: 0%;
            
        }

        .menu > li {
            width: 198px;
            text-align: center; /*텍스트 중앙에 배치*/
            line-height: 40px;
            background-color: #323232;
            list-style: none;

        }


        .menu a {
            color: #fff;
            text-decoration: none;
            font-weight: bold;
            display : block; /* 인라인 요소를 블럭요소로 바꿔줌 */
        }

        .menu a:hover {
            color: #1a1a1a;
            text-decoration: none;
            
        }


        .submenu > li { /*게시글관리 - 공지관리/문의 게시글 관리*/
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
            line-height: 150px;
        }



        .menu .submenu{
            padding-left: 0;
        } 


        /*-----------------------여기까지는 테두리------*/


        /* -------------------------------------------*/

        #content_2_box { /*컨텐트2 전체 div*/
            width: 770px;
            height: 690px;
        }




        /* -------------------------------------------*/
        .date-area{
            width: 100%;
            height: 10%;
            text-align: center;
            padding: 20px;
            color: white;
        }
        .date-area input{
            width: 30%;
        }

        .screenList-area{
            width: 100%;
            height: 90%;
        }
        .screenList-area > div{
            width: 100%;
            height: 50%;
            padding: 5% 5% 0 5%;
            display:flex;
            justify-content: space-between;
            
        }
        .screenList-area > div > div{
            width: 50%;
            height: 100%;
            position: relative;
        }
        .screenList-title{
            position: absolute;
            color: white;
            font-size: 25px;
            top: -40px;
            left: 50%;
            transform: translate(-50%, 0%);
        }
        .screenList input{
            float: left;
            display: block;
            width: 50%;
        }
        .screenList select{
            float: left;
            display: block;
            width: 50%;
        }
        #insertScreen-area{
        	text-align:center;
        	
        }
        


    </style>
</head>
<body>
	<!-- 헤더 -->
   <jsp:include page="/views/common/header.jsp"></jsp:include>

	<c:choose>
		<c:when test="${ loginUser eq null }">
			
			<script>
				location.href = ('${ path }/loginForm.me');
			</script>
			
		</c:when>
		<c:when test='${ loginUser.privilege eq "Y" }'>
			<script>
				location.href = ('${ path }');
			</script>
		</c:when>
		<c:otherwise>
			<script>
		        window.onload = function() {
		            today = new Date();
		            today = today.toISOString().slice(0, 10);
		            bir = document.getElementById("today");
		            bir.value = today;
		        }
		        
		    </script>
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
                        <a href="${ path }/selectAdmin.mb">회원 관리</a>
                        <ul class="submenu">

                        </ul>
                    </li>
                    <li>
                        <a href="${ path }/adminScreenList.admin">상영관 관리</a>
                        <ul class="submenu" >

                        </ul>
                    </li>
                    <li>
                        <a href="${ path }/adminMovieCheck.admin?currentPage=1">영화 관리</a>
                        <ul class="submenu" >

                        </ul>
                    </li>
                    <li>
                        <a href="${ path }/checkAdmin.cm">영화관 관리</a>
                        <ul class="submenu">

                        </ul>
                    </li> 
                    <li class="post">
                        <a href="#">게시글 관리</a>
                        <ul class="submenu">
                        <li><a href="${ path }/adminBoardCheck.admin?currentPage=1">공지 관리</a></li>
                        <li><a href="${ path }/adminQnACheck.admin?currentPage=1">문의 게시글 관리</a></li>
                        </ul>
                    </li>
                </ul>    
            </div>

            <!------------------------------------------------------------>

            <div class="content_2"><!--content_2 시작-->
                <div class="date-area">
                    ${ theater.theaterName }
                    <input type="date" id="today">
                </div>

                <div id="screenList-top">
                <c:choose>
                	<c:when test="${empty screenList }">
                	<div class="row" >
                		<c:forEach var="i" begin="0" end="3">
                			<div class="screenList col-sm-6 " style="height: 250px;margin-top: 40px">
                        
	                            <div class="screenList-title">${ screenList[i].screenName }관</div>
	                            <c:set var="movieList" value="${ screenList[i].movieList }"/>
	                            <c:forEach var="j" begin="0" end="${ movieList.size()-1 }" >
	                            	<div>
	                            		 <select name="movie" id="${ movieList[j].screenNo }">
	                            		 <c:forEach var="m" items="${ movieNameList }">
	                            		 	<option value="${ m.movieNo }">${ m.movieTitle }</option>	
	                            		 </c:forEach>
	                            		 
	                            		 </select>
	                            		 <input type="time" value="${ movieList[j].watchDate }">
	                            		 
	                            		  <script>
	                            		  	$('#${ movieList[j].screenNo }').val('${ movieList[j].movieNo }').prop("selected",true);
			                              </script>
	                            	</div>
	                            </c:forEach>

	          
                           </div>>
                		</c:forEach>
                	
                	
                	</div>
                	</c:when>
                </c:choose>
                
                </div>
				<div id="insertScreen-area">
					<select id="screenName">
						<c:forEach var="i" begin="1" end="4">
							<option value="${ i }">${ i }관</option>
						</c:forEach>
						
					</select>
					<select id="selectMovie" >
						<c:forEach var="m" items="${ movieNameList }">
                           	<option value="${ m.movieNo }">${ m.movieTitle }</option>
 
                       	</c:forEach>
					</select>
					<select id="watchTime">
						<option>01:00</option>
						<option>07:00</option>
						<option>10:00</option>
						<option>13:00</option>
						<option>16:00</option>
						<option>19:00</option>
						<option>21:00</option>
					</select>
					<button id="insertScreen">추가</button>
				</div>
				<script>
					$('#insertScreen').on('click',function(){
						let $screenName = $('#screenName');
						let $selectMovie = $('#selectMovie');
						let $watchTime = $('#watchTime');
						let $today = $('#today');
						 $.ajax({
								url : 'insertScreen.admin',
								type : 'get',
								data : {
									screenName : $screenName.val(),
									theaterNo : ${ theater.theaterNo },
									selectMovie : $selectMovie.val(),
									watchTime : $watchTime.val(),
									watchDate : $today.val()
								},
								success : function(result){
									
									if(result == 1){
										view($today);	
									}else{
										alert('실패');
									}
									
								}
							 });
					});
				
				</script>



            </div><!--content_2끝-->
        </div>

    </div>
		</c:otherwise>
		
	</c:choose>
	
    
    
    <script>
        $('#today').on('change' , function(){
            let $today = $(this);
            
            view($today);
                      
        });
        
        function view(today){
        	$.ajax({
                url : 'selectDate.admin',
                type : 'get',
                data : {
                    watchDate : today.val(),
                    theaterNo : ${ theater.theaterNo }
                },
                success : function(result){
                    let resultStr = '';
                    let resultOption = '';
                    $('#screenList-top').html('');
                    resultStr += '<div class="row">';
					
                    for(let i = 0;i< result.length; i++){
                        resultOption = '';
                        resultStr += '<div class="screenList col-sm-6 " style="height: 250px;margin-top: 40px">' +
                                        '<div class="screenList-title">'+ 
                                            result[i].screenName +'관' +
                                        '</div>';
                        for(let j = 0; j< result[i].movieList.length;j++){
                        	resultOption +='<div>' + '<select name="movie" id="' + result[i].movieList[j].screenNo + '">';
							for(let k = 0; k < result[i].movieNameList.length;k++){
								resultOption += 'option value="' + result[i].movieNameList[k].movieNo + '">' + result[i].movieNameList[k].movieTitle + '</option>';  
							}
            				resultOption +=	'</select>' + 
            									'<input type="time" value="'+ result[i].movieList[j].watchDate +'">'  +
            								'</div>';
        				}      
                        resultStr += resultOption + '</div>';                
                                        
                    }
                    resultStr += '</div>';
                    $('#screenList-top').html(resultStr);
                    
                    
                    
                  for(let i= 0; i< result.length; i++){
                	   for(let j = 0; j< result[i].movieList.length;j++){
                		   const aaa = '#' + result[i].movieList[j].screenNo;
                		   const bbb = result[i].movieList[j].movieNo;
                		   $(aaa).val(bbb).prop("selected",true);
                		   
                	   }
                   }
                }
                
            });
        }

        
    </script>

 	<%@ include file="/views/common/footer.jsp" %>
 	<!-- 푸터 -->
 	<%} %>
</body>
</html>