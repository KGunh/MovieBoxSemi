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

        a{
            text-decoration: none;
        }

        .content{
            height: 1050px;
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
        .input-bottom{
            position: absolute;
            bottom: -17px;
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
            display: flex;
            justify-content: space-evenly;
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
			<form action="<%=contextPath%>/insert.me" method="post" id="insertForm">
				<div class="inputdiv">
					<span class="input-span id" >아이디</span><br> 
                    <input type="text" class="input-text id" id="memberId" name="memberId" placeholder="아이디입력(영문/숫자만 가능 12글자 제한)" maxlength="12">
					<button type="button" class="idCheck" onclick="idCheck();">중복확인</button>
                    <span class="input-bottom"></span>
				</div>
				<script>
					
					
				</script>
				
				
				<div class="inputdiv">
					<span class="input-span">비밀번호</span><br> 
                    <input type="password" id="memberPwd" class="input-text" name="memberPwd" placeholder="비밀번호(영문/숫자만 가능 16글자 제한)" maxlength="16">
                    <span class="input-bottom"></span>
				</div>
				<div class="inputdiv">
					<span class="input-span">비밀번호 확인</span><br> 
                    <input type="password" id="checkPwd" class="input-text" placeholder="비밀번호확인 (위와 동일한 비밀번호를 입력해주세요)" maxlength="16">
                    <span class="input-bottom"></span>
				</div>
                <script>
                     $(function(){
                                $('#checkPwd').blur(function(){
                                    const $memberPwd = $('#memberPwd').val();
                                    const $checkPwd = $(this).val();
                                    if($memberPwd != $checkPwd){
                                        $('#checkPwd').css('border','2px solid red');
                                        $(this).siblings('.input-bottom').html('잘못된 입력입니다. 다시입력해주세요').css('color','red');
                                    } 
                                    else{
                                        $('#checkPwd').removeAttr('style');
                                        $(this).siblings('.input-bottom').html('');
                                    }

                                });
                                
                            });
                            

                </script>
				<div class="inputdiv">
					<span class="input-span">이름</span><br> 
                    <input type="text" class="input-text" name="memberName" placeholder="이름" maxlength="5">
                    <span class="input-bottom"></span>
				</div>

                
				<div class="inputdiv">
					<span class="input-span">생년월일</span><br> 
                    <input type="text" class="input-text" name="birthday" placeholder="생년월일ex)19901218(YYYYMMDD)" maxlength="8">
                    <span class="input-bottom"></span>
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
                    <input type="email" class="input-text" name="email" placeholder="이메일입력 | ex)aaa@movie.box (***@***.***)" >
                    <span class="input-bottom"></span>
				</div>
				<div class="inputdiv">
					<span class="input-span">전화번호</span><br> 
                    <input type="text" class="input-text" name="phone" maxlength="11" placeholder="전화번호입력 | ex)01066665555">
                    <span class="input-bottom"></span>
				</div>

				<div class="inputdiv">
					<span class="input-span">지역</span><br> 
                    <select name="localCode" id="location">
						<option value="L1">서울</option>
						<option value="L2">경기</option>
						<option value="L3">인천</option>
						<option value="L4">강원</option>
						<option value="L5">대전</option>
						<option value="L6">충남</option>
						<option value="L7">충북</option>
						<option value="L8">대구</option>
						<option value="L9">경남</option>
						<option value="L10">경북</option>
						<option value="L11">울산</option>
						<option value="L12">부산</option>
						<option value="L13">제주</option>
						<option value="L14">광주</option>

					</select> <input type="text" name="address"class="input-text address">
                    <span class="input-bottom"></span>
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
							<label class="genre" for="anime">애니</label>
                            <input class="checkbox" type="checkbox" name="genre" value="애니" id="anime">
						</div>
						<div class="checkbox-div-label">
							<label class="genre" for="anime">판타지</label>
                            <input class="checkbox" type="checkbox" name="genre" value="판타지" id="fantasy">
						</div>
					</div>
				</div>
				<div class="input-button">
					<button type="button" id="insertMember" disabled > 가입하기</button>
				</div>
			</form>
		</div>
	</div>

    <script>
    	let idReg = /^[a-zA-Z0-9]+$/;
    	let nameReg = /^[가-힣]+$/;
        let phoneReg = /^\d{11}$/;
        let emailReg = /^[a-zA-Z0-9+-\_.]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/;
        let birthdayReg = '';
        let year = $('input[name=birthday]').val().substr(0,4);
    	let month = $('input[name=birthday]').val().substr(4,2);
    	if((year%4) == 0 && month == 02){
    	     //윤년
    	     console.log('윤년');
    		birthdayReg = /^(19|20)\d{2}(02)(0[1-9]|1[0-9]|2[0-9])$/;
    		
        } 
        else{
        	if(month == 02){
        		console.log('윤년x');
        		birthdayReg = /^(19|20)d{2}02(0[1-9]|1[0-9]|2[0-8])$/;
        	}
        	else if(month == 04 || month == 06 || month == 09 || month == 11){
        		console.log('윤년x46911');
        		birthdayReg = /^(19|20)d{2}(0[469]|11)(0[1-9]|1[0-9]|2[0-9]|30)$/;
    		}
    		else{
    			console.log('윤년x13578');
    			birthdayReg = /^(19|20)d{2}(0[13578]|1[02])(0[1-9]|1[0-9]|2[0-9]|31)$/;
    		}
        }
        function idCheck() {
			const $memberId = $('.inputdiv input[name=memberId]');
			
			if($memberId.val() == ''){
				$memberId.css('border','2px solid red');
				$memberId.siblings('.input-bottom').html('필수 정보입니다.').css('color','red');
	        } 
	        else if(idReg.test($memberId.val())){
	        	$memberId.removeAttr('style');
	        	$memberId.siblings('.input-bottom').html('');
	          //AJAX 요청
				$.ajax({
					url : 'idCheck.me',
					data : {
						checkId : $memberId.val()
					},
					success : function(result) {
						if (result == 'N') {
							$memberId.css('border','2px solid red');
							$('#memberId').siblings('.input-bottom').html('이미 존재하거나 탈퇴한 회원의 아이디입니다.').css('color','red');
							$memberId.val('').focus();
						} else {
							if (confirm('사용 가능한 아이디입니다. 사용하시겠습니까?')) {
								$memberId.removeAttr('style');
								$('#memberId').siblings('.input-bottom').html('');
	                            $('.input-button > button').removeAttr('disabled');
	                            $('.idCheck').css('background','#FFC145');
							} else {
								$memberId.focus();
							}
						}
					},
					error : function() {
						console.log('AJAX통신 실패');
					}
				});
	            
	            
	        }     
	        else {
	        	$memberId.css('border','2px solid red');
	        	$memberId.siblings('.input-bottom').html('형식에 맞지않습니다(영어,숫자만 입력해주세요).').css('color','red');
	        }

			
		}
        
        
        $('.inputdiv > input').blur(function(){
            checkInput($(this));
        });
        $('input[name=memberId]').blur(function(){
        	checkInputId($(this));
        });
        $('input[name=memberId]').keyup(function(){
        	$('.input-button > button').attr('disabled',true);
        	$('.idCheck').css('background','rgb(218, 218, 218)');
        	
        });
        $('input[name=memberName]').blur(function(){
        	checkInputName($(this));
        });
        
        $('input[name=phone]').blur(function(){
            checkInputPhone($(this));  
        });
        $('input[name=email]').blur(function(){
            checkInputEmail($(this));  
        });
        $('input[name=birthday]').blur(function(){
        	
        	checkInputBirthday($(this));
        	
            
        });
    
        $('.input-button > button').click(function(){
            const $input = $('.inputdiv > input');
            let flag = false;
            $input.each(function(){
                if ($(this).val() == ''){
                    $(this).css('border','2px solid red');
                    $(this).siblings('.input-bottom').html('필수 정보입니다.').css('color','red');
                }
                else {
                    checkInputAll();
                    if(phoneReg.test($('input[name=phone]').val()) && birthdayReg.test($('input[name=birthday]').val()) && emailReg.test($('input[name=email]').val())){
                        $('#insertForm').submit();
                    }
                }
                
            });

        });
        function checkInputAll(){
        	let msg = '';
        	const $memberNameInput = $('input[name=memberName]');
        	const $phoneInput = $('input[name=phone]');
        	const $birthdayInput = $('input[name=birthday]');
        	const $emailInput = $('input[name=email]');
        	if(nameReg.test($memberNameInput.val())){
        		removeAttr($memberNameInput)
            }
            else {
            	$memberNameInput.css('border','2px solid red');
            	$memberNameInput.siblings('.input-bottom').html('형식에 맞지않습니다(한글만 입력해주세요).').css('color','red');
                msg += '이름 ';
            }
            if(phoneReg.test($phoneInput.val())){
            	removeAttr($phoneInput)
            }
            else {
            	$phoneInput.css('border','2px solid red');
            	$phoneInput.siblings('.input-bottom').html('형식에 맞지않습니다(-를 제외한 11자리 숫자만 입력해주세요).').css('color','red');
                msg += '전화번호 ';
            }
            if(birthdayReg.test($birthdayInput.val())){
            	removeAttr($birthdayInput)
            }
            else{
            	$birthdayInput.css('border','2px solid red');
            	$birthdayInput.siblings('.input-bottom').html('형식에 맞지않습니다 | ex)19001124(YYYYMMDD).').css('color','red');
                msg += '생년월일 ';
            }
            if(emailReg.test($emailInput.val())){
            	removeAttr($emailInput)
                
            }
            else{
            	text = '형식에 맞지않습니다 | ex)aaa@movie.box(***@***.***).';
            	failInput($emailInput,text);
                msg += '이메일 ';

            }
            alert(msg+'입력되지 않았습니다.');
        };
    </script>

    <script>
    	function removeOrFail(reg,$input){
    		if(reg.test($input.val())){
    			$input.removeAttr('style');
        		$input.siblings('.input-bottom').html('');
                
            }
            else{
            	$input.css('border','2px solid red');
        		$input.siblings('.input-bottom').html('형식에 맞지않습니다 | '+ $input.attr('placeholder').substring(10)).css('color','red');
            }
    	}
    	
        function checkInput($input){
            if($input.val() == ''){
                    $input.css('border','2px solid red');
                    $input.siblings('.input-bottom').html('필수 정보입니다.').css('color','red');
            } 
            else {
                $input.removeAttr('style');
                $input.siblings('.input-bottom').html('');
            }     
        }
        function checkInputId($input){				
			if($input.val() == ''){
                $input.css('border','2px solid red');
                $input.siblings('.input-bottom').html('필수 정보입니다.').css('color','red');
	        } 
	        else if(idReg.test($input.val())){
	            $input.removeAttr('style');
	            $input.siblings('.input-bottom').html('');
	        }     
	        else {
	            $input.css('border','2px solid red');
	            $input.siblings('.input-bottom').html('형식에 맞지않습니다(영어,숫자만 입력해주세요).').css('color','red');
	        }
		}
        function checkInputName($input){
        	if($input.val() == ''){
                $input.css('border','2px solid red');
                $input.siblings('.input-bottom').html('필수 정보입니다.').css('color','red');
	        } 
	        else if(nameReg.test($input.val())){
	            $input.removeAttr('style');
	            $input.siblings('.input-bottom').html('');
	        }     
	        else {
	            $input.css('border','2px solid red');
	            $input.siblings('.input-bottom').html('형식에 맞지않습니다(한글만 입력해주세요).').css('color','red');
	        }
        }
        function checkInputPhone($input){
            if($input.val() == ''){
                    $input.css('border','2px solid red');
                    $input.siblings('.input-bottom').html('필수 정보입니다.').css('color','red');
            } 
            else if(phoneReg.test($input.val())){
                $input.removeAttr('style');
                $input.siblings('.input-bottom').html('');
            }     
            else {
                $input.css('border','2px solid red');
                $input.siblings('.input-bottom').html('형식에 맞지않습니다(-를 제외한 11자리 숫자만 입력해주세요).').css('color','red');
            }
        }
        function checkInputEmail($input){
            if($input.val() == ''){
                    $input.css('border','2px solid red');
                    $input.siblings('.input-bottom').html('필수 정보입니다.').css('color','red');
            } 
            else if(emailReg.test($input.val())){
                $input.removeAttr('style');
                $input.siblings('.input-bottom').html('');
            }     
            else {
                $input.css('border','2px solid red');
                $input.siblings('.input-bottom').html('형식에 맞지않습니다 | ex)aaa@movie.box(***@***.***).').css('color','red');
            }
        }

        function checkInputBirthday($input){
        
        	
            if($input.val() == ''){
                    $input.css('border','2px solid red');
                    $input.siblings('.input-bottom').html('필수 정보입니다.').css('color','red');
            } 
            else if(birthdayReg.test($input.val())){
                $input.removeAttr('style');
                $input.siblings('.input-bottom').html('');
            }     
            else {
                $input.css('border','2px solid red');
                $input.siblings('.input-bottom').html('형식에 맞지않습니다 | ex)19001124(YYYYMMDD).').css('color','red');
            }
        }
        
        
    </script>



<%@ include file="../common/footer.jsp" %>
</body>
</html>