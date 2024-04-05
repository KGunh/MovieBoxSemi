<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스토어</title>

<style>

    .container{
        width: 900px;
    }

    .card{
        background-color: #fff;
        border:none;
        border-radius: 10px;
        height: 280px;
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
        font-size: 14px;
        color: grey;
    }

    .buy{
        font-size: 14px;
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

    .product-detail-container{
        margin-top: 55px;
    }

    .buy:hover, .rating-number:hover, .image-container:hover, .dress-name:hover{
        cursor: pointer;
    }

</style>
</head>
<body>

 	<jsp:include page="/views/common/header.jsp" />
 	
    <div id="wrap" style="padding-bottom: 50px;">
        <h1 align="center" style="margin-top:50px; color:crimson;">
            <img style="height: 210px; width: 1200px; border:rgba(252, 252, 252, 0.15);" src="https://cf.lottecinema.co.kr//Media/WebAdmin/f04df114813f45b18e63e06308211d0f.jpg" alt="스토어상품이미지">
        </h1>
        <div class="container mt-5" >
            <div class="row">
                <div class="col-md-3">

                    <c:if test="${ not empty goodsList }">
                
                    <div class="card">
                        <div class="image-container">
                            <div class="first">
                                <div class="d-flex justify-content-between align-items-center">
                                </div>
                            </div>
                            <img src="https://cf.lottecinema.co.kr//Media/WebAdmin/70fc20fe998a4ab7b44d1bfa0d1440e4.jpg" class="img-fluid rounded thumbnail-image">
                        </div>
                        <div class="product-detail-container p-2">
                            <div class="d-flex justify-content-between align-items-center">
                                <h5 class="dress-name" style="text-shadow: 0px 1px 2px lightgray;">오리지널팝콘L</h5>
                                <div class="d-flex flex-column mb-2">
                                    <span class="new-price"><strong>￦6,000</strong></span>
                                </div>
                            </div>
                            <div class="d-flex justify-content-between align-items-center pt-1">
                            </div>
                            <div class="d-flex justify-content-between align-items-center pt-1">
                                <div>
                                    <span class="rating-number">장바구니</span>
                                </div>
                                <span class="buy">구매</span>
                            </div>
                        </div>
                    </div>
                
                    </c:if>
                    
                </div>
            </div>
        </div>
    </div>
	
	<jsp:include page="/views/common/footer.jsp" />
    
    <script>
	/*
        $(window).on('load', function(){
            $.ajax({
                url : 'printInfo.reservationAjax',
            	type : 'post',
            	data : {
                    
                },
                success : function(result){
                    console.log('성공');
                },
                error : function(){
                    console.log('실패');
                }
            });
        });
	*/

    </script>


</body>
</html>