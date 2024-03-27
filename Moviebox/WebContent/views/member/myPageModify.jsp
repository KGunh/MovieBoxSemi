<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,com.kh.member.model.vo.MemberGenre"%>
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
        a{
            text-decoration: none;
        }
        #info-header{
            width: 100%;
            height: 175px;
        }
        #info-title{
            width: 100%;
            height: 100px;
        }
        .title{
            display: block;
            width: 100%;
            height: 100%;
            font-size: 30px;
            font-weight: bold;
            line-height: 100px;
            text-align: center;
            color: white;
        }
        #info-header-navi{
            width: 1050px;
            height: 75px;
            margin : auto;
        }
        #info-header-navi ul{
            list-style-type: none;
            display: flex;
            justify-content: center;
            width: 100%;
            height: 100%;
            padding: 0;
            margin: 0;
        }
        #info-header-navi li{
            width: 50%;
            height: 100%;
            display: flex;
            justify-content: center;
            align-items: center;
            
        }
        .info-navi{
            border-top: 1px solid lightgray;
            border-bottom: 1px solid lightgray;
        }
        .info-my{
            color: black;
            text-decoration: none;
            font-weight: bold;
            width: 100%;
            height: 100%;
            text-align: center;
            padding-top: 25px;
        }
        .info-list{
            color: #FFC145;
            font-weight: bold;
            width: 100%;
            height: 100%;
            text-align: center;
            padding-top: 25px;
        }
        .info-navi > a{
        	text-decoration: none;
        }
        
        
        #info-navi-first{
            background-color: #FFC145;
        }
        #info-navi-second{
            background-color: #1A1A1A;
        }
        .info-my:hover{
            text-decoration: none;
            color: black;
            
        }
        .info-list:hover{
            text-decoration: none;  
            color: #FFC145;   
        }
        
        #modal-margin{
        	margin: auto;
        	margin-top: 250px;
        	margin-bottom: 500px;
        	width: 40%;
        	height: 540px;
        }
        #modal-body{
        	padding:40px 75px 30px 75px;
        }
        #updatePwd{
        	margin: auto;
        	width: 100%;
        	height: auto;
            padding-left: 19px;
        }
        #modal-content{
        	width: 480px;
        	height: 540px;
        }
        #modal-header{
        	height: 70px;
        	font-size: 25px;
        	border-bottom: none;
        	padding: 35px 1rem 0px 1rem;
        }
        #userPwd,#changePwd,#checkPwd{
        	height: 50px;
        	background:rgb(224, 224, 224);
        }
        .form-group label{
        	font-size:16;
        	color:rgb(158, 158, 158);
        }
        #modal-btn{
        	margin-top:30px;
        	width: 100%;
        	height: 50px;
        	font-weight: bold;
        }
        #errorText{
            font-size: 12px;
            color: red;
        }
        .form-group{
            position: relative;
        }
        .form-group > span{
            display: block;
            position: absolute;
            bottom: -15px;
            font-size: 12px;
        }
    </style>
    
</head>
<body>
	<%@ include file="../common/header.jsp" %>
	
	<div id="info-header">
        <div id="info-title">
            <span class="title">마이페이지</span>
        </div>
        <div id="info-header-navi">
            
            <ul class="info-navi">
                <li id="info-navi-first">
                    <a href="<%=contextPath %>/mypage.me" class="info-my">회원정보</a>
                </li>
                <li id="info-navi-second">
                    <a href="<%=contextPath %>/resList.me" class="info-list">예매내역</a>
                </li>
            </ul>
        </div>

    </div>
    <%
	    String memberId = loginUser.getMemberId();
		String memberName = loginUser.getMemberName();
		String phone = loginUser.getPhone();
		String birthday = loginUser.getBirthday();
		String email = loginUser.getEmail();
		String memberPwd = loginUser.getMemberPwd();
		
		String address = loginUser.getAddress();
		String localCode = loginUser.getLocalCode();
		List<MemberGenre> list = loginUser.getGenreList();
		String genreList = "";
		
		for(int i = 0; i < list.size(); i++) {
        	 genreList += list.get(i).getGenreCode() + (i < (list.size()-1) ? "," : "");
		}
	%>
    %>

    <div class="content">
        <div class="input-title"><span class="tit">내정보 수정</span></div>
        <div id="input-list">
            <form action="<%=contextPath%>/update.me" method="post">
                <div class="inputdiv">
                    <span class="input-span">생년월일</span><br>
                    <input type="text" class="input-text N" value="<%=birthday %>" disabled>
                </div>
                <div class="inputdiv">
                    <span class="input-span">이름</span><br>
                    <input type="text" class="input-text N" value="<%=memberName %>" disabled>
                </div>
                <div class="inputdiv">
                    <span class="input-span">전화번호</span><br>
                    <input type="text" class="input-text N" value="<%=phone %>"  disabled>
                </div>
                <div class="inputdiv">
                    <span class="input-span">아이디</span><br>
                    <input type="text" class="input-text N" name="memberId" value="<%=memberId %>" disabled>
                </div>
                <div class="inputdiv pwd">
                    <span class="input-span">비밀번호</span><br>
                    <input type="password" class="input-text N password" value="<%=memberPwd %>"  disabled>
                    <button type="button" class="password-edit" data-toggle="modal" data-target="#updatePwd">변경</button>
                </div>
                <div class="inputdiv">
                    <span class="input-span">주소</span><br>
                    <select name="localCode" id="location">
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
                    <input type="text" class="input-text address" name="address" value="<%=address%>">
                </div>
                <div class="inputdiv">
                    <span class="input-span">이메일</span><br>
                    <input type="text" class="input-text" value="<%=email %>" name="email">
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
            <script>
                $(function(){
                    const local = '<%=localCode%>';
                    
                    const genreList = '<%=genreList%>'
                    $('#location').val(local).attr('selected',true);
                    
                    $('input[type=checkbox]').each(function(){	
    					if(genreList.search($(this).val()) != -1){
    						$(this).attr('checked',true);
    					}
    				});
                    
                });

                
                
            </script>
	
        </div>


    </div>
    

<div class="modal" id="updatePwd" >
		<div class="modal-dialog" id="modal-margin">
			<div class="modal-content" id="modal-content">

				<div class="modal-header" id="modal-header">
					<h4 class="modal-title">비밀번호 변경</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				
				<div class="modal-body" id="modal-body">
					<form action="<%=contextPath%>/updatePwd.me" method="post" id="pwdUpdateForm">
						<div class="form-group">
							<label for="userPwd">현재 비밀번호</label> 
							<input type="password" class="form-control" name="userPwd" placeholder="비밀번호를 입력해주세요" id="userPwd">
                            <span id="errorText1"></span>
						</div>
						<div class="form-group">
							<label for="changePwd">변경할 비밀번호</label> 
							<input type="password" class="form-control"  name="changePwd" placeholder="변경할 비밀번호를 입력해주세요" id="changePwd">
                            <span id="errorText2"></span>
						</div>
						
						<div class="form-group">
							<label for="checkPwd">변경할 비밀번호 확인</label> 
							<input type="password" class="form-control"  placeholder="다시 한번 입력해주세요" id="checkPwd">
                            <span id="errorText3"></span>
						</div>
						<button type="button" class="btn btn-warning" id="modal-btn">비밀번호 변경</button>
						<input type="hidden" value="<%=loginUser.getMemberNo() %>" name="userNo">
                        <script>
                            $(function(){
                                $('#userPwd').blur(function(){
                                    const $userPwd = $('#userPwd');
                                    
                                    $.ajax({
                                        url : 'pwdDuplicationCheck.me',
                                        data : {
                                            checkPwd : $userPwd.val()
                                        },
                                        success : function(result){
                                            if(result == 'N') {
                                                $userPwd.css('border','1px solid red');
                                                $userPwd.val('').focus();
                                                $('#errorText1').html('잘못된 입력입니다. 다시입력해주세요').css('color','red');
                                            } else{
                                            	$userPwd.removeAttr('style');
                                                $('#errorText1').html('');
                                            }
                                        }


                                    })

                                });

                            });

                        </script>
                        <script>
                        $(function(){
                        	$('#modal-btn').click(function(){
                                const $userPwd = $('#userPwd');
                                const $changePwd = $('#changePwd');
                                const $checkPwd = $('#checkPwd');

                                if($userPwd.val() == ''){
                                    $('#errorText1').html('값이 비어있습니다').css('color','red');
                                } 
                                if($changePwd.val() == ''){
                                    $('#errorText2').html('값이 비어있습니다').css('color','red');
                                }
                                if($checkPwd.val() == ''){
                                    $('#errorText3').html('값이 비어있습니다').css('color','red');
                                }
								
                                if($userPwd.val() != '' && $changePwd.val() != '' && $checkPwd.val() != ''){
                                	$('#pwdUpdateForm').submit();
                                }

                            });
                        	
                        });
                        </script>
                        <script>
					
                            $(function(){

                                $('#changePwd').blur(function(){
                                    const $changePwd = $(this).val();
                                    const $checkPwd = $('#checkPwd').val();
                                    if($changePwd != ''){
                                        $('#changePwd').removeAttr('style');
                                        $('#errorText2').html('');
                                    }
                                    if($changePwd != $checkPwd){
                                        $('#checkPwd').css('border','1px solid red');
                                        $('#errorText3').html('잘못된 입력입니다. 다시입력해주세요').css('color','red');
                                    } 
                                    else{
                                        $('#checkPwd').removeAttr('style');
                                        $('#errorText3').html('');
                                    }

                                });
                                
                            });
                            
                            
                        </script>
						<script>
					
                            $(function(){

                                $('#checkPwd').blur(function(){
                                    const $changePwd = $('#changePwd').val();
                                    const $checkPwd = $(this).val();
                                    if($changePwd != $checkPwd){
                                        $('#checkPwd').css('border','1px solid red');
                                        $('#errorText3').html('잘못된 입력입니다. 다시입력해주세요').css('color','red');
                                    } 
                                    else{
                                        $('#checkPwd').removeAttr('style');
                                        $('#errorText3').html('');
                                    }

                                });
                                
                            });
                            
                            
                        </script>
						
					</form>

				</div>

			</div>
		</div>
	</div>

</body>
</html>