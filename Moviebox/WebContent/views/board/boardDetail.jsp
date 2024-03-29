<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.kh.board.model.vo.*" %>
    
<%
	Board board = (Board)request.getAttribute("board");

%>    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

    <style>
        body{
            background-color: #1A1A1A;
            margin: 0;
        }

        div{
            /* border: 1px solid red; */
            box-sizing: border-box;
        }

        .wrap{
            width: 1200px;
            margin: 0 auto;
        }

        /* 전체 감싸는 부분 */
        #notice-list{
            width: 1200px;
            margin: 0 auto;
            /*border: 1px solid pink;*/
        }

        /* 타이틀 */
        #title{
            text-align: center;
            color: white;
            padding-top: 50px;
            padding-bottom: 50px;
            font-size: 30px;
            font-weight: bold;
        }

        /* 카테고리*/
        #board-category{
            width: 1200px;
            height: 92px;
            text-align: center;
            line-height: 90px;
            font-size: 20px;
            font-weight: bold;
            color: white;
            border-top: 1px solid #8a8a8a;
            border-bottom: 1px solid #8a8a8a;
        }

        .notice-tap{
            width: 600px;
            height: 90px;
            float: left;
            font-weight: bolder;
            cursor: pointer;
            color: #FFC145;
        }
        
        .qna-tap{
            width: 600px;
            height: 90px;
            color: #1A1A1A;
            display: inline-block;
            left: 0;
            cursor: pointer;
            background-color: #FFC145;
        }

        .notice-tap:hover{
            background-color: #FFC145;
            color: #1A1A1A;
        }

        
        /* 내용 입력 */
        .notice-content{
            width: 1200px;
            height: auto;
            /* border: 1px solid pink; */
            color: white;
            margin-top: 30px;
        }

        .detail-box1{
            width: 1200px;
            /* border: 1px solid #FFC145; */
        }

        .detail-box2{
            width: 1200px;
            /* border: 1px solid red; */
        }

        .detail-title-box1{
            width: 1200px;
            padding-top: 20px;
            border-top: 1px solid #3f3f3f;
        }

        .detail-title-box2{
            width: 1200px;
            padding-bottom: 20px;
            border-bottom: 1px solid #3f3f3f;
        }


        .detail-category{
            width: 170px;
            height: 60px;
            line-height: 55px;
            font-size: 20px;
            font-weight: bold;
            padding-left: 10px;
            float: left;
        }

        .detail-title{
            width: 1030px;
            height: 60px;
            line-height: 55px;
            font-size: 20px;
            font-weight: bold;
            display: inline-block;
            
        }

        .detail-date{
            width: 170px;
            height: 30px;
            line-height: 25px;
            float: left;
            color: #8a8a8a;
            padding-left: 10px;
        }

        .detail-count{
            width: 1030px;
            height: 30px;
            line-height: 25px;
            color: #8a8a8a;
            display: inline-block;
        }

        /* 글 내용 */
        .detail-content-box{
            width: 1200px;
            height: auto;
        }

        .detail-content{
            padding: 10px;
            padding-top: 20px;
            padding-bottom: 25px;
            border-bottom: 1px solid #3f3f3f;
        }

        .detail-content-a-box{
            width: 1200px;
            height: auto;
            color: white;
        }

        .detail-a{
            padding: 10px;
            padding: 20px;
            border: 1px solid #3f3f3f;
        }

        #a-title{
            width: 1200px;
            font-size: 20px;
            color: white;
            font-weight: bold;
            padding-top: 50px;
            padding-bottom: 20px;
        }

        /* 버튼 */
        .notice-btn{
            margin-top: 30px;
            margin-bottom: 30px;
        }

        .board-detail-btn{
            width: 80px;
            padding: 8px;
            font-size: 20px;
            font-weight: bold;
            border: none;
            border-radius: 10px;
            background-color: #FFC145;
            text-decoration: none;
            color: #1A1A1A;
            margin-right: 10px;
        }
    </style>

</head>
<body>

	<%@ include file="../common/header.jsp" %>
	
    <div id="wrap">
        <div id="notice-detail">
            <!-- 전체 감싸는 부분 -->
            <div id="notice-list">

                <div id="title">고객센터</div>
        
                <!-- 카테고리 -->
                <div id="board-category">
	                <div class="notice-tap" onclick="openNoticePage();">공지사항</div>
	                <div class="qna-tap" onclick="openQnaPage();">QnA</div>
                </div> <!-- board-category -->

                <div class="notice-content">
                    <div class="detail-box1">
                        <div class="detail-title-box1">
                            <div class="detail-category"><span>No.<%=board.getBoardNo() %> [<%= board.getBoardCategory() %>]</span></div>
                            <div class="detail-title"><span><%= board.getBoardTitle() %></span></div>
                        </div>
                    </div>

                    <div class="detail-box2">
                        <div class="detail-title-box2">
                            <div class="detail-date"><a><%= board.getCreateDate() %></a></div>
                            <div class="detail-count"><a>작성자 : <%= board.getBoardWriter() %></div>
                        </div>
                    </div>

                    <div class="detail-content-box">
                        <div class="detail-content">
                        <%= board.getBoardContent() %>
                        </div>
                    </div>
                </div> <!-- notice-content -->

                <div id="a-title">답변</div>

                <div class="detail-content-a-box">
                    <div class="detail-a">
			        	댓글로 해야하나
                </div>
            </div> <!-- notice-content -->

                <div class="notice-btn" align="center">
                    <button class="board-detail-btn" onclick="backPage();">목록</button>
                    <% if(loginUser != null && loginUser.getMemberName() == board.getBoardWriter()) { %>
	                    <button class="notice-detail-btn" onclick="noticeUpdatePage();">수정</button> 
	                    <button class="notice-detail-btn" onclick="noticeDelete();">삭제</button>
                    <% } %>
                </div>



            </div> <!-- notice-list -->
        </div> <!-- notice-detail -->
	</div>
    
    	<%@ include file="../common/footer.jsp" %>
    	
    	<script>
			function openNoticePage(){
				location.href = '<%=contextPath %>/list.notice?currentPage=1';
			}
			
			function openQnaPage(){
				location.href = '<%= contextPath %>/list.board?currentPage=1';
			}
			
    		function backPage(){
    			location.href = '<%=contextPath%>/list.board?currentPage=1';
    		}

    	
    	</script>
    
</body>
</html>