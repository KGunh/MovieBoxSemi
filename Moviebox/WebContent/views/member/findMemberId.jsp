<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
    body {
        background-color: #1A1A1A
    }
    div{
        box-sizing: border-box;
    }
    #wrap{
        width: 1200px;
        margin: auto;
    }
    #contentArea{
        height: 650px;
        margin: 50px 275px 50px 275px;
    }
    #findNaviArea{
        height: 80px;
        position: relative;
    }
    #findNaviArea > #findId, #findPwd{
        float: left;
        height: 100%;
        width: 50%;
        text-align: center;
        line-height: 100px;
    }
    #findNaviArea a{
        text-decoration: none;
        color: rgb(238, 238, 238);
        font-size: 30px;
        font-weight: 700;
    }
    #idFocusBar, #pwdFocusBar{
        float: left;
        height: 7px;
    }
    #idFocusBar{
        background-color: rgb(255, 193, 69);
        margin-left: 75px;
        margin-right: 75px;
        width: 175px;        
    }
    #pwdFocusBar{
        margin-left: 60px;
        margin-right: 30px;
        width: 200px;        

    }
    input:focus{
        outline: none;
    }
    input{
        height: 50px;
    }
    #infoInputArea{
        position: relative;
        height: 470px;
        margin: 50px 70px 50px 75px;
    }
    #infoInputForm h4{
        color: rgb(238, 238, 238);
        margin: 15px 5px 5px 5px;
        font-size: 16px;
    }
    #infoInputForm input{
        font-size: 16px;
        background-color: rgb(238, 238, 238);
        padding-left: 7px;
        border-radius: 8px;
    }
    input[name="name"], [name="birthday"]{
        width: 500px;
        box-sizing: border-box;
    }
    input[name="phoneNum"]{
        width: 395px;
        margin-left: 8px;
        box-sizing: border-box;
    }
    select{
        height: 49px;
        background-color: rgb(238, 238, 238);
        font-size: 16px;
        border-radius: 8px;
        width: 90px;
        box-sizing: border-box;
        padding-left: 5px;
    }
    button{
        margin-top: 30px;
        height: 50px;
        width: 500px;
        font-size: 20px;
        font-weight: 700;
        border-radius: 8px;
        background-color: rgb(255, 193, 69);
    }
    
    
</style>
<script>


</script>

</head>
<body>
    <div id="wrap">
        <div id="header" style="height: 200px; color: white;">header include</div>
        <div id="contentArea">
            <div id="findNaviArea">
                <div id="findId"><a href="#">아이디 찾기</a></div>
                <div id="findPwd"><a href="#">비밀번호 찾기</a></div>
                <div id="idFocusBar"></div>
                <div id="pwdFocusBar"></div>
            </div>
            <div id="infoInputArea">
                <form id="infoInputForm" action="findId" method="post">
                    <h4>이름</h4>
                    <input type="text" name="name" placeholder="이름을 입력해주세요" required>
                    <h4>생년월일</h4>
                    <input type="text" name="birthday" placeholder="생년월일을 입력해주세요 ex)19900928" required>
                    <h4>전화번호</h4>
                    <select name="agency">
                        <option value="KT">KT</option>
                        <option value="SKT">SKT</option>
                        <option value="LGU+">LGU+</option>
                    </select>
                    <input type="text" name="phoneNum" placeholder="전화번호를 입력해주세요 ex)01011112222" required><br>
                    <button type="submit">아이디 찾기</button>
                </form>
            </div>
        </div>      
        <div id="footer" style="height: 250px; color: white;"><%@ include file="/views/common/footer.jsp" %></div>
    </div>
</body>
</html>