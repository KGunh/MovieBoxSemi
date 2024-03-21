<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>

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
            margin-bottom: 120px;
        }
        .title-area{
            height: auto;
            width: 100%;
            margin-bottom: 25px;
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
            padding: 5px;
            
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
        .id{
            width: 70%;
            float: left;
            margin-right: 2%;
        }
        .idCheck{
            width: 28%;
            height: 50px;
            border: none;
            border-radius: 8px;
            background-color: rgb(218, 218, 218);
            font-weight: bold;
        }
        .address{
            width: 80%;
            right: 0;
        }
        #location{
            position: absolute;
            margin: 0;
            border: none;
            border-radius: 8px;
            height: 50px;
            width: 19%;
            left: 0;
            bottom: 0;
            font-weight: bold;
        }
        .checkbox{
            display: block;
            margin:auto;
            margin-bottom: 0;
            margin-top: 10px;
        }
    

        .genre{
            display: block;
            height: auto;
        }
        .checkbox-div-label{
            width: 20%;
            height: 100%;
            float: left;
            text-align: center;
            padding-top: 20px;
            padding-bottom: 20px;
            color: white;
            

        }

        input[type="radio"] {
            width: 15px;
            vertical-align: middle;
            margin-right: 15px;
        }
        #insertMember{
            float: left;
            height: 100%;
            width: 100%;
            text-align: center;
            text-align: center;
            border: none;
            border-radius: 8px;
            font-size: 12px;
            font-weight: bold;
            line-height: 50px;
            background-color: #FFC145;
            
        }
        
        .gender{
            margin-bottom: 0;
            color: white;
            height: 60%;
            text-align: center;

        }
        .f{
            float: left;
            margin-left: 30%;
            width: 20%;
        }
        
        .m{
            float:right;
            margin-right: 30%;
            width: 20%;

        }
        .gender input{
            display: block;
            margin-left: 9%;
            margin-right: 9%;
        }

    </style>

</head>
<body>
	
	<%@ include file="../common/header.jsp" %>

	<div class="content">
	<div class="title-area">
			<span class="tit">회원가입</span>
		</div>

		<div id="input-list">
			<form action="" method="post">
				<div class="inputdiv">
					<span class="input-span id" name="memberId">아이디</span><br> 
                    <input type="text"
						class="input-text id">
					<button class="idCheck" onclick="idCheck();">중복확인</button>
				</div>
				
				
				<div class="inputdiv">
					<span class="input-span">비밀번호</span><br> 
                    <input type="password" class="input-text" name="memberPwd">
				</div>
				<div class="inputdiv">
					<span class="input-span">비밀번호 확인</span><br> 
                    <input type="password" class="input-text">
				</div>
				<div class="inputdiv">
					<span class="input-span">이름</span><br> 
                    <input type="text" class="input-text" name="memberName">
				</div>
				<div class="inputdiv">
					<span class="input-span">생년월일</span><br> 
                    <input type="text" class="input-text" name="birthday">
				</div>
				<div class="inputdiv">
					<span class="input-span">성별</span><br> 
                    <div class="gender f">
                        여자 
                        <input type="radio" name=gender value="F" checked> 
                    </div>
                    <div class="gender m">
                        남자 <input type="radio" name="gender" value="M">
                    </div>
                   
				</div>
				<div class="inputdiv">
					<span class="input-span">이메일</span><br> 
                    <input type="email" class="input-text" name="email">
				</div>
				<div class="inputdiv">
					<span class="input-span">전화번호</span><br> 
                    <input type="text" class="input-text" name="phone">
				</div>

				<div class="inputdiv">
					<span class="input-span">지역</span><br> 
                    <select name="locationCode" id="location">
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

					</select> <input type="text" name="address"class="input-text address">
				</div>
				<div class="checkbox-div">
					<span class="input-span">취향</span><br>
					<div class="checkbox-div-input">
						<div class="checkbox-div-label">
							<label class="genre" for="horror">공포/스릴러</label>
                            <input class="checkbox" type="checkbox" name="genre" value="공포/스릴러" id="horror">
						</div>
						<div class="checkbox-div-label">
							<label class="genre" for="romance">로맨스</label>
                            <input class="checkbox" type="checkbox" name="genre" value="로맨스" id="romance">
						</div>
						<div class="checkbox-div-label">
							<label class="genre" for="action">액션</label> 
                            <input class="checkbox" type="checkbox" name="genre" value="액션" id="action">
						</div>
						<div class="checkbox-div-label">
							<label class="genre" for="comedy">코미디</label> 
                            <input class="checkbox" type="checkbox" name="genre" value="코미디" id="comedy">
						</div>
						<div class="checkbox-div-label">
							<label class="genre" for="anime">애니메이션</label>
                            <input class="checkbox" type="checkbox" name="genre" value="애니메이션" id="anime">
						</div>
					</div>
				</div>
				<div class="input-button">
					<input id="insertMember" type="submit" value="가입하기" >
				</div>
			</form>
		</div>
	</div>







</body>
</html>