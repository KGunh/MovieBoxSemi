<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	div{
        border: 1px solid red;
        box-sizing: border-box;
    }

    #wrap{
        width: 1200px;
        height: 1600px;
    }

    #title{
        height: 80px;
        width: 100%;
        margin-top: 50px;
        color: rgb(32,32,32);
        background-color: rgb(255, 193, 69);
        font-size: 32px;
        font-weight: 700;
        line-height: 80px;
        padding-left: 30px;
    }

    #selectPersonArea{
        height: 400px;
        width: 100%;
    }

    .line{
        height: 30px;
        width: 100%;
    }

    .seats{
        float: left;
        height: 30px;
        width: 30px;
    }

    .line-wrap{
        width: 550px;
        height: 30px;
        vertical-align: middle;
        margin: auto;
    }


</style>


<body>
	<%@ include file="/views/common/header.jsp" %>
	<div id="wrap">
	<div id="title">영화예매</div>

    <div id="selectPersonArea">
        <div id="selectText">
            인원 선택
            <div>
                최대 8명까지 선택 가능
            </div>
        </div>
        <div id="select-wrap">
            <div id="selectAge">
                <div>
                    청소년
                </div>
              
                <div>
                    성인
                </div>
            </div>
            <div id="selectPerson">
                selectPerson
            </div>
        </div>
    </div>
	
    <div id="seat-wrap">
        <div id="seat-title"></div>
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
	<%@ include file="/views/common/footer.jsp" %>
</body>
</html>