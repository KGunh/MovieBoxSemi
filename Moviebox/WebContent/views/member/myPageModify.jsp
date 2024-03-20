<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내정보수정</title>
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

        .content{
            height: auto;
            width: 500px;
            margin: auto;
            margin-top: 50px;
            margin-bottom: 50px;
        }
        .input-title{
            height: 10%;
            width: 100%;
            margin-bottom: 50px; 
        }
        .tit{
            font-size: 30px;
            color: white;
            font-weight: bold;
            border-bottom: 4px solid#FFC145;
        }
        #input-list{
            height: 90%;
            width: 100%;

        }
        .inputdiv{
            position: relative;
            width: 500px;
            height: 75px;
            margin: auto;
            margin-bottom: 10px;
            
        }
        .inputdiv input {
            margin: 0;
            position: absolute;
            bottom: 0;
            
        }
        .inputdiv button{
            padding: 0;
            position: absolute;
            bottom: 0;
            right: 0;
        }
        .checkbox-div{
            width: 500px;
            height: 105px;
            margin: auto;
        }
        
        .input-span{
            color: rgb(158, 158, 158);
            font-size: 12px;
            
        }
        .input-text{
            width: 100%;
            height: 50px;
            border-radius: 8px;
            border: none;
            margin-top: 2px;
        }
        .checkbox-div-input{
            height: 85px;
            width: 100%;
            border: 1px solid rgb(158, 158, 158);
            border-radius: 8px;
        }
        .input-button{
            
            width: 500px;
            height: 50px;
            margin: auto;
            margin-top: 25px;
            
            
        }
        

        #edit, #secession{
            float: left;
            height: 100%;
            width: 49%;
            text-align: center;
            text-align: center;
            border: none;
            border-radius: 8px;
            font-size: 12px;
            font-weight: bold;
            
        }

        #secession{
            display: block;
            background-color: white;
            color: black;
            line-height: 50px;
        }
        #edit{
            margin-left: 2%;
            line-height: 50px;
            background-color: #FFC145;
        }
        .N{
            background-color: rgb(158, 158, 158);
        }
        .password{
            width: 78%;
            float: left;
            margin-right: 2%;
        }
        .password-edit{
            width: 20%;
            height: 50px;
            border: none;
            border-radius: 8px;
            background-color: rgb(218, 218, 218);
            font-weight: bold;
        }
        .address{
            width: 78%;
            right: 0;
        }
        #location{
            position: absolute;
            margin: 0;
            border: none;
            border-radius: 8px;
            text-align:center;
            height: 50px;
            width: 20%;
            left: 0;
            bottom: 0;
            font-weight: bold;
        }
        
        .checkbox-div-label{
            position: relative;
            width: 20%;
            height: 100%;
            float: left;
            text-align: center;
            color: white;
        }
        .genre{
            position: absolute;
            display: block;
            width: 100px;
            top: 30%; 
            left:50%;
            transform:translate(-50%, -50%);
        }
        .checkbox-div-label > input{
            display: block;
            position: absolute;

            top: 70%; 
            left:50%;
            transform:translate(-50%, -50%);
        }
    </style>
    
</head>
<body>

    <div class="content">
        <div class="input-title"><span class="tit">내정보 수정</span></div>
        <div id="input-list">
            <form action="">
                <div class="inputdiv">
                    <span class="input-span">생년월일</span><br>
                    <input type="text" class="input-text N" disabled>
                </div>
                <div class="inputdiv">
                    <span class="input-span">이름</span><br>
                    <input type="text" class="input-text N" disabled>
                </div>
                <div class="inputdiv">
                    <span class="input-span">전화번호</span><br>
                    <input type="text" class="input-text N" disabled>
                </div>
                <div class="inputdiv">
                    <span class="input-span">아이디</span><br>
                    <input type="text" class="input-text N" disabled>
                </div>
                <div class="inputdiv pwd">
                    <span class="input-span">비밀번호</span><br>
                    <input type="password" class="input-text N password" disabled>
                    <button class="password-edit">변경</button>
                </div>
                <div class="inputdiv">
                    <span class="input-span">주소</span><br>
                    <select name="" id="location">
                        <option>서울</option>
                        <option>경기</option>
                        <option>인천</option>
                        <option>강원</option>
                        <option>대전</option>
                        <option>충남</option>
                        <option>충북</option>
                        <option>대구</option>
                        <option>경남</option>
                        <option>경북</option>
                        <option>울산</option>
                        <option>부산</option>
                        <option>제주</option>
                        <option>광주</option>

                    </select>
                    <input type="text" class="input-text address">
                </div>
                <div class="inputdiv">
                    <span class="input-span">이메일</span><br>
                    <input type="text" class="input-text">
                </div>
                <div class="checkbox-div">
                    <span class="input-span">취향</span><br>
                    <div class="checkbox-div-input">
                        <div class="checkbox-div-label">
                            <label class="genre" for="horror">공포/스릴러</label><br>
                            <input class="checkbox" type="checkbox" name="genre" value="공포/스릴러" id="horror">
                        </div>
                        <div class="checkbox-div-label">
                            <label class="genre" for="romance">로맨스</label><br>
                            <input class="checkbox" type="checkbox" name="genre" value="로맨스" id="romance">
                        </div>
                        <div class="checkbox-div-label">
                            <label class="genre" for="action">액션</label><br>
                            <input class="checkbox" type="checkbox" name="genre" value="액션" id="action">
                        </div>
                        <div class="checkbox-div-label">
                            <label class="genre" for="comedy">코미디</label> <br>
                            <input class="checkbox" type="checkbox" name="genre" value="코미디" id="comedy">
                        </div>
                        <div class="checkbox-div-label">
                            <label class="genre" for="anime">애니메이션</label><br>
                            <input class="checkbox" type="checkbox" name="genre" value="애니메이션" id="anime">
                        </div>
                    </div>
                </div>
                <div class="input-button">
                    <a id="secession" href="">회원 탈퇴</a>
                    <input id="edit" type="submit" value="정보수정">
                </div>
            </form>


        </div>


    </div>


</body>
</html>