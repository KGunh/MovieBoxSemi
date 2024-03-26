<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
    body{
        color: rgb(32,32,32);
    }
	div{
        border: 1px solid red;
        box-sizing: border-box;
    }
    a{
        text-decoration: none;
        color: rgb(32,32,32);
    }

    #wrap{
        width: 1200px;
        height: 1000px;
    }

    #title{
        height: 80px;
        width: 100%;
        margin-top: 30px;
        color: rgb(32,32,32);
        background-color: rgb(255, 193, 69);
        font-size: 35px;
        font-weight: 700;
        line-height: 80px;
        padding-left: 30px;
    }

    #selectPersonArea{
        height: 250px;
        width: 100%;
    }

    #seat-title{
        height: 50px;
        font-size: 24px;
        font-weight: 700;
        color: rgb(148, 145, 145);
        line-height: 50px;
        text-align: center;
    }

    .line{
        height: 50px;
        width: 100%;
    }

    .seats{
        float: left;
        height: 30px;
        width: 30px;
        margin-top: 8px;
    }

    .line-wrap{
        width: 550px;
        height: 50px;
        margin: auto;
    }

    #selectText{
        height: 150px;
        color: rgb(255, 193, 69);
        padding-top: 30px;
        padding-left: 30px;
        font-size: 28px;
        font-weight: 700;
    }
    
    #select-wrap{
        height: 150px;
    }

    #selectAge{
        height: 100px;   
        float: left; 
    }

    #selectAge > div{
        float: left;
        height: 30px;
        width: 60px;
        line-height: 25px;
        font-size: 16px;
        font-weight: 700;
        text-align: center;
        border-radius: 8px;
        background-color: rgba(70, 69, 69, 0.82);
        color: rgb(125, 124, 124);
    }

    #selectPerson{
        float: left;
    }


</style>


<body>
	<%@ include file="/views/common/header.jsp" %>
	<div id="wrap">
	<div id="title">영화예매</div>

    <div id="selectPersonArea">
        <div id="selectText">
            인원 선택
            <div style="color:rgb(148, 145, 145); font-size: 16px;">
                최대 8명까지 선택 가능
            </div>
        </div>
        <div id="select-wrap">
            <div id="selectAge">
                <div>청소년</div><div>성인</div>
            </div>
            <div id="selectPerson">
                selectPerson
            </div>
        </div>
    </div>
	
    <div id="seat-wrap">
        <div id="seat-title"> 좌석 선택</div>
        <div id="seat-arrange">
            <div id="a-line" class="line">
                <div id="a-line-wrap" class="line-wrap">
                    <div class="a-seat seats"></div>
                    <div class="a-seat seats"></div>
                    <div class="a-seat seats"></div>
                    <div class="a-seat seats"></div>
                    <div class="a-seat seats"></div>
                    <div class="a-seat seats"></div>
                    <div class="a-seat seats"></div>
                    <div class="a-seat seats"></div>
                    <div class="a-seat seats"></div>
                    <div class="a-seat seats"></div>
                    <div class="a-seat seats"></div>
                    <div class="a-seat seats"></div>
                    <div class="a-seat seats"></div>
                    <div class="a-seat seats"></div>
                    <div class="a-seat seats"></div>
                    <div class="a-seat seats"></div>
                    <div class="a-seat seats"></div>
                    <div class="a-seat seats"></div>
                </div>
            </div>
            <div id="b-line" class="line">
                <div id="b-line-wrap" class="line-wrap">
                    <div class="b-seat seats"></div>
                    <div class="b-seat seats"></div>
                    <div class="b-seat seats"></div>
                    <div class="b-seat seats"></div>
                    <div class="b-seat seats"></div>
                    <div class="b-seat seats"></div>
                    <div class="b-seat seats"></div>
                    <div class="b-seat seats"></div>
                    <div class="b-seat seats"></div>
                    <div class="b-seat seats"></div>
                    <div class="b-seat seats"></div>
                    <div class="b-seat seats"></div>
                    <div class="b-seat seats"></div>
                    <div class="b-seat seats"></div>
                    <div class="b-seat seats"></div>
                    <div class="b-seat seats"></div>
                    <div class="b-seat seats"></div>
                    <div class="b-seat seats"></div>
                </div>
            </div>
            <div id="c-line" class="line">
                <div id="c-line-wrap" class="line-wrap">
                    <div class="c-seat seats"></div>
                    <div class="c-seat seats"></div>
                    <div class="c-seat seats"></div>
                    <div class="c-seat seats"></div>
                    <div class="c-seat seats"></div>
                    <div class="c-seat seats"></div>
                    <div class="c-seat seats"></div>
                    <div class="c-seat seats"></div>
                    <div class="c-seat seats"></div>
                    <div class="c-seat seats"></div>
                    <div class="c-seat seats"></div>
                    <div class="c-seat seats"></div>
                    <div class="c-seat seats"></div>
                    <div class="c-seat seats"></div>
                    <div class="c-seat seats"></div>
                    <div class="c-seat seats"></div>
                    <div class="c-seat seats"></div>
                    <div class="c-seat seats"></div>
                </div>
            </div>
            <div id="d-line" class="line">
                <div id="d-line-wrap" class="line-wrap">
                    <div class="d-seat seats"></div>
                    <div class="d-seat seats"></div>
                    <div class="d-seat seats"></div>
                    <div class="d-seat seats"></div>
                    <div class="d-seat seats"></div>
                    <div class="d-seat seats"></div>
                    <div class="d-seat seats"></div>
                    <div class="d-seat seats"></div>
                    <div class="d-seat seats"></div>
                    <div class="d-seat seats"></div>
                    <div class="d-seat seats"></div>
                    <div class="d-seat seats"></div>
                    <div class="d-seat seats"></div>
                    <div class="d-seat seats"></div>
                    <div class="d-seat seats"></div>
                    <div class="d-seat seats"></div>
                    <div class="d-seat seats"></div>
                    <div class="d-seat seats"></div>
                </div>
            </div>
            <div id="e-line" class="line">
                <div id="e-line-wrap" class="line-wrap">
                    <div class="e-seat seats"></div>
                    <div class="e-seat seats"></div>
                    <div class="e-seat seats"></div>
                    <div class="e-seat seats"></div>
                    <div class="e-seat seats"></div>
                    <div class="e-seat seats"></div>
                    <div class="e-seat seats"></div>
                    <div class="e-seat seats"></div>
                    <div class="e-seat seats"></div>
                    <div class="e-seat seats"></div>
                    <div class="e-seat seats"></div>
                    <div class="e-seat seats"></div>
                    <div class="e-seat seats"></div>
                    <div class="e-seat seats"></div>
                    <div class="e-seat seats"></div>
                    <div class="e-seat seats"></div>
                    <div class="e-seat seats"></div>
                    <div class="e-seat seats"></div>
                </div>
            </div>
            <div id="f-line" class="line">
                <div id="e-line-wrap" class="line-wrap">
                    <div class="f-seat seats"></div>
                    <div class="f-seat seats"></div>
                    <div class="f-seat seats"></div>
                    <div class="f-seat seats"></div>
                    <div class="f-seat seats"></div>
                    <div class="f-seat seats"></div>
                    <div class="f-seat seats"></div>
                    <div class="f-seat seats"></div>
                    <div class="f-seat seats"></div>
                    <div class="f-seat seats"></div>
                    <div class="f-seat seats"></div>
                    <div class="f-seat seats"></div>
                    <div class="f-seat seats"></div>
                    <div class="f-seat seats"></div>
                    <div class="f-seat seats"></div>
                    <div class="f-seat seats"></div>
                    <div class="f-seat seats"></div>
                    <div class="f-seat seats"></div>
                </div>
            </div>
        </div>
    </div>
	
	</div>
</a>
	<%@ include file="/views/common/footer.jsp" %>
</body>
</html>