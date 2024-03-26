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
        height: 60px;
        width: 100%;
        margin-top: 50px;
        color: rgb(32,32,32);
        background-color: rgb(255, 193, 69);
        font-size: 28px;
        font-weight: 700;
        line-height: 60px;
        padding-left: 50px;
    }

</style>


<body>
	<%@ include file="/views/common/header.jsp" %>
	<div id="wrap">
	<div id="title">영화예매</div>

    <div id="selectPersonArea">
        <div id="selectText"></div>
        <div id="select-wrap">
            <div id="selectAge"></div>
            <div id="selectPerson"></div>
        </div>
    </div>
	
    <div id="seat-wrap">
        <div id="seat-title"></div>
        <div id="seat-arrange">
            <div id="a-line">
                <div class="a-seat"></div>
                <div class="a-seat"></div>
                <div class="a-seat"></div>
                <div class="a-seat"></div>
                <div class="a-seat"></div>
                <div class="a-seat"></div>
                <div class="a-seat"></div>
                <div class="a-seat"></div>
                <div class="a-seat"></div>
                <div class="a-seat"></div>
                <div class="a-seat"></div>
                <div class="a-seat"></div>
                <div class="a-seat"></div>
                <div class="a-seat"></div>
                <div class="a-seat"></div>
                <div class="a-seat"></div>
                <div class="a-seat"></div>
                <div class="a-seat"></div>
            </div>
            <div id="b-line">
                <div class="b-seat"></div>
                <div class="b-seat"></div>
                <div class="b-seat"></div>
                <div class="b-seat"></div>
                <div class="b-seat"></div>
                <div class="b-seat"></div>
                <div class="b-seat"></div>
                <div class="b-seat"></div>
                <div class="b-seat"></div>
                <div class="b-seat"></div>
                <div class="b-seat"></div>
                <div class="b-seat"></div>
                <div class="b-seat"></div>
                <div class="b-seat"></div>
                <div class="b-seat"></div>
                <div class="b-seat"></div>
                <div class="b-seat"></div>
                <div class="b-seat"></div>
            </div>
            <div id="c-line">
                <div class="c-seat"></div>
                <div class="c-seat"></div>
                <div class="c-seat"></div>
                <div class="c-seat"></div>
                <div class="c-seat"></div>
                <div class="c-seat"></div>
                <div class="c-seat"></div>
                <div class="c-seat"></div>
                <div class="c-seat"></div>
                <div class="c-seat"></div>
                <div class="c-seat"></div>
                <div class="c-seat"></div>
                <div class="c-seat"></div>
                <div class="c-seat"></div>
                <div class="c-seat"></div>
                <div class="c-seat"></div>
                <div class="c-seat"></div>
                <div class="c-seat"></div>
            </div>
            <div id="d-line">
                <div class="d-seat"></div>
                <div class="d-seat"></div>
                <div class="d-seat"></div>
                <div class="d-seat"></div>
                <div class="d-seat"></div>
                <div class="d-seat"></div>
                <div class="d-seat"></div>
                <div class="d-seat"></div>
                <div class="d-seat"></div>
                <div class="d-seat"></div>
                <div class="d-seat"></div>
                <div class="d-seat"></div>
                <div class="d-seat"></div>
                <div class="d-seat"></div>
                <div class="d-seat"></div>
                <div class="d-seat"></div>
                <div class="d-seat"></div>
                <div class="d-seat"></div>
            </div>
            <div id="e-line">
                <div class="e-seat"></div>
                <div class="e-seat"></div>
                <div class="e-seat"></div>
                <div class="e-seat"></div>
                <div class="e-seat"></div>
                <div class="e-seat"></div>
                <div class="e-seat"></div>
                <div class="e-seat"></div>
                <div class="e-seat"></div>
                <div class="e-seat"></div>
                <div class="e-seat"></div>
                <div class="e-seat"></div>
                <div class="e-seat"></div>
                <div class="e-seat"></div>
                <div class="e-seat"></div>
                <div class="e-seat"></div>
                <div class="e-seat"></div>
                <div class="e-seat"></div>
            </div>
            <div id="f-line">
                <div class="f-seat"></div>
                <div class="f-seat"></div>
                <div class="f-seat"></div>
                <div class="f-seat"></div>
                <div class="f-seat"></div>
                <div class="f-seat"></div>
                <div class="f-seat"></div>
                <div class="f-seat"></div>
                <div class="f-seat"></div>
                <div class="f-seat"></div>
                <div class="f-seat"></div>
                <div class="f-seat"></div>
                <div class="f-seat"></div>
                <div class="f-seat"></div>
                <div class="f-seat"></div>
                <div class="f-seat"></div>
                <div class="f-seat"></div>
                <div class="f-seat"></div>
            </div>
        </div>
    </div>
	
	</div>
	<%@ include file="/views/common/footer.jsp" %>
</body>
</html>