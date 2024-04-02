<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>

    .container{
        width: 900px;
    }

    .card{
        background-color: #fff;
        border:none;
        border-radius: 10px;
        width: 190px;
        box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
    }

    .image-container{
        position: relative;
    }

    .thumbnail-image{
        border-radius: 10px !important;
    }

    .discount{
        background-color: red;
        padding-top: 1px;
        padding-bottom: 1px;
        padding-left: 4px;
        padding-right: 4px;
        font-size: 10px;
        border-radius: 6px;
        color: #fff;
    }

    .wishlist{
        height: 25px;
        width: 25px;
        background-color: #eee;
        display: flex;
        justify-content: center;
        align-items: center;
        border-radius: 50%;
        box-shadow:  0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
    }

    .first{
        position: absolute;
        width: 100%;
        padding: 9px;
    }

    .dress-name{
        font-size: 13px;
        font-weight: bold;
        width: 75%;
    }

    .new-price{
        font-size: 13px;
        font-weight: bold;
        color: red;
    }

    .old-price{
        font-size: 8px;
        font-weight: bold;
        color: grey;
    }

    .btn{
        width: 14px;
        height: 14px;
        border-radius: 50%;
        padding: 3px;
    }

    .creme{
        background-color: #fff;
        border: 2px solid grey;
    }

    .creme:hover {
        border: 3px solid grey;
    }

    .creme:focus {
        background-color: grey;
    }

    .red{
        background-color: #fff;
        border: 2px solid red;

    }

    .red:hover {
        border: 3px solid red;
    }

    .red:focus {
        background-color: red;
    }

    .blue{
        background-color: #fff;
        border: 2px solid #40C4FF;
    }

    .blue:hover {
        border: 3px solid #40C4FF;
    }

    .blue:focus {
        background-color: #40C4FF;
    }

    .darkblue{
        background-color: #fff;
        border: 2px solid #01579B;
    }

    .darkblue:hover {
        border: 3px solid #01579B;
    }

    .darkblue:focus {
        background-color: #01579B;
    }

    .yellow{
        background-color: #fff;
        border: 2px solid #FFCA28;
    }

    .yellow:hover {
        border-radius: 3px solid #FFCA28;
    }

    .yellow:focus {
        background-color: #FFCA28;
    }

    .item-size{
        width: 15px;
        height: 15px;
        border-radius: 50%;
        background: #fff;
        border: 1px solid grey;
        color: grey;
        font-size: 10px;
        text-align: center;
        align-items: center;
        display: flex;
        justify-content: center;
    }

    .rating-star{
        font-size: 10px !important;
    }

    .rating-number{
        font-size: 10px;
        color: grey;
    }

    .buy{
        font-size: 12px;
        color: purple;
        font-weight: 500;
    }

    .voutchers{
        background-color: #fff;
        border:none;
        border-radius: 10px;
        width: 190px;
        box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
        overflow: hidden;
    }

    .voutcher-divider{
        display: flex;
    }

    .voutcher-left{
        width: 60%
    }

    .voutcher-name{
        color: grey;
        font-size: 9px;
        font-weight: 500;
    }

    .voutcher-code{
        color: red;
        font-size: 11px;
        font-weight: bold;
    }

    .voutcher-right{
        width: 40%;	 
        background-color: purple;
        color: #fff;
    }

    .discount-percent{
        font-size: 12px;
        font-weight: bold;
        position: relative;
        top: 5px;
    }

    .off{
        font-size: 14px;
        position: relative;
        bottom: 5px;
    }

</style>
</head>
<body>
    <%@ include file="/views/common/header.jsp" %>
 
    <div id="wrap" style="padding-bottom: 50px;">
        <h1 align="center" style="margin-top:50px; color:crimson;">콤보맛있으면 0칼로리, 아는 맛이 제일 맛있어요!</h1>
        <div class="container mt-5">
            <div class="row">
                <div class="col-md-3">
                        <div class="card">
                            <div class="image-container">
                                <div class="first">
                                    <div class="d-flex justify-content-between align-items-center">
                                    <span class="wishlist"><i class="fa fa-heart-o"></i></span>
                                    </div>
                                </div>
                                <img src="http://img.cgv.co.kr/GiftStore/Product/Pc/List/16678903563480.jpg" class="img-fluid rounded thumbnail-image">
                            </div>
                            <div class="product-detail-container p-2">
                                    <div class="d-flex justify-content-between align-items-center">
                                        <h5 class="dress-name">팝콘세트 ㅋ</h5>
                                        <div class="d-flex flex-column mb-2">
                                            <span class="new-price">￦13,000</span>
                                        </div>
                                    </div>
                                    <div class="d-flex justify-content-between align-items-center pt-1">
                                    </div>
                                    <div class="d-flex justify-content-between align-items-center pt-1">
                                        <div>
                                            <i class="fa fa-star-o rating-star"></i>
                                            <span class="rating-number">4.8</span>
                                        </div>
                                        <span class="buy">BUY +</span>
                                    </div>
                            </div>
                        </div>
                        
                </div>
                
            </div>
        </div>
    </div>

    <div class="btn btn-lg btn-info" style="width:180px; height:40px; position: fixed; bottom: 300px; right:350px;">
        무 어쩔 ~ 
    </div>
    <%@ include file="/views/common/footer.jsp" %>
    
</body>
</html>