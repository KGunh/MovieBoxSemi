<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

<title>고객센터 공지사항</title>

    <style>
        body{
            background-color: #1A1A1A;
            margin: 0;
        }

        div{
            box-sizing: border-box;
        }

        .wrap{
            width: 1200px;
            margin: 0 auto;
        }

        /* 전체 감싸는 부분 */
        #board-list{
            width: 1200px;
            margin: 0 auto;
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
            background-color: #FFC145;
            font-weight: bolder;
        }
        
        .notice-tap a {
        	color: #1A1A1A;
        }        
        
        .notice-tap a:hover {
        	color: #1A1A1A;
        	text-decoration: none;
        }

        .qna-tap{
            width: 600px;
            height: 90px;
            color: #FFC145;
            display: inline-block;
            left: 0;
            cursor: pointer;
        }

        .qna-tap:hover{
            background-color: #FFC145;
        }
        
        .qna-tap a {
        	color: white;
        }
        
        .qna-tap:hover a{
        	color: #1A1A1A;
        }
        
        .qna-tap a:hover {
        	color: #1A1A1A;
        	text-decoration: none;
        }

        /* 검색 */
        #search-notice{
            width: 480px;
            height: 55px;
            margin: 0 auto;
            margin-top: 30px;
            margin-bottom: 30px;
            padding-top: 5px;
        }

        #search-img{
            width: 40px;
            height: 30px;
            float: left;
            margin-left: 10px;
        }

        #input-notice{
            width: 400px;
            height: 45px;
            border: none;
            float: left;
            border-radius: 8px;
            margin-left: 10px;
            background: none;
            color: white;
            padding-left: 8px;
            border: 1px solid #8a8a8a;
        }

        #input-notice::placeholder{
            font-size: 15px;
            color: #FFC145;
        }


        /* 게시판 */

        table{
            border-collapse: separate;
            border-spacing: 0;
            font-size: 15px;
            color: white;
        }
        

        .table-hover{
        	color: #ffffff;
        }

        th{
            background-color: #bbbbbb;
            color: #1A1A1A;
            font-weight: bold;
            font-size: 16px;
            border-bottom: none;
            line-height: 50px;
        }

        td{
            line-height: 40px;
        }

        tr:hover td{
            color: white;
            background-color: #d1d1d11f;
        }

  

        /* 게시판 너비 */
        
        #list-th{
        	color: 1A1A1A;
        	border-bottom: 1px solid #bbbbbb46;
        }
        
        #list-no{
            width: 70px;
            text-align: center;
            color: white;
            border-bottom: 1px solid #bbbbbb46;
        }

        #list-ca{
            width: 100px;   
            text-align: center;
            color: white;
            border-bottom: 1px solid #bbbbbb46;
        }

        #list-title{
            width: 700px;
            color: white;
            border-bottom: 1px solid #bbbbbb46;
        }

        #list-date{
            width: 110px;
            text-align: center;
            color: white;
            border-bottom: 1px solid #bbbbbb46;
        }

        #list-count{
            width: 80px;
            text-align: center;
            color: white;
            border-bottom: 1px solid #bbbbbb46;
        }
        
        #list-th-i{
        	text-align: center;
        	border-bottom: 1px solid #bbbbbb46;
        }

        /* 페이징바 */
        .btn-outline-danger:hover{
            background-color: #FFC145;
            border: none;
        }

        #page{
            width: 1200px;
            margin-top: 40px;
            margin-bottom: 40px;
        }


    </style>
    
</head>
<body>

	<%@ include file="../common/header.jsp" %>
	
    <div id="wrap">

        <!-- 전체 감싸는 부분 -->
        <div id="board-list">

            <div id="title"><a>고객센터</a></div>
                
            <!-- 카테고리 -->
            <div id="board-category">
                <div class="notice-tap"><a href="noticeList.jsp">공지사항</a></div>
                <div class="qna-tap"><a href="../board/qnaList.jsp">QnA</a></div>
            </div> <!-- board-category -->

            <!-- 검색 -->
            <div id="search-notice">

                <div id="search-notice-input">
                    <input id="input-notice" type="text" placeholder="검색어를 입력해 주세요.">
                </div>

                <div id="search-img">
                    <img src="<%= contextPath %>/resources/img/search.PNG" width="45" height="45">
                </div>

            </div> <!-- search-notice -->


            <!-- 게시판 -->
            <div class="container">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th id="list-th-i">번호</th>
                            <th id="list-th-i">카테고리</th>
                            <th id="list-th">제목</th>
                            <th id="list-th-i">작성일</th>
                            <th id="list-th-i">조회수</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td id="list-no">1</td>
                            <td id="list-ca">예매</td>
                            <td id="list-title">공지 제목 제목 공지 제목 공지사항 예매 공지</td>
                            <td id="list-date">2024-03-21</td>
                            <td id="list-count">50</td>
                        </tr>
                        <tr>
                            <td id="list-no">2</td>
                            <td id="list-ca">영화관</td>
                            <td id="list-title">공지 제목 제목 공지 제목 공지사항 예매 공지</td>
                            <td id="list-date">2024-03-21</td>
                            <td id="list-count">777</td>
                        </tr>
                        <tr>
                            <td id="list-no">3</td>
                            <td id="list-ca">기타</td>
                            <td id="list-title">공지 제목 제목 공지 제목 공지사항 예매 공지임 예매</td>
                            <td id="list-date">2024-03-21</td>
                            <td id="list-count">58</td>
                        </tr>
                    </tbody>
                </table>
            </div>


            <div id="page">
                <div class="paging-area" align="center" style="margin-top:12px;">
                    <button class="btn btn-outline-danger" style="color:white; background: none; border: 1px solid white;"> < </button>
                    <button class="btn btn-outline-secondary" style="color:white; border: 1px solid white;">1</button>
                    <button class="btn btn-outline-danger" style="color:white; background: none; border: 1px solid white;"> > </button>
                </div>
            </div>

        </div>
    </div>
    

    
    	<%@ include file="../common/footer.jsp" %>


</body>
</html>