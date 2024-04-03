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
            background-color: #ecedee;
        }

        .card{
            border: none;
            overflow: hidden;
        }

        .main_image{
            display: flex;
            justify-content: center;
            align-items: center;
            border-bottom: 1px solid #eee;
            height: 400px;
            width: 100%;
            overflow: hidden;
        }

        .heart{
            height: 29px;
            width: 29px;
            background-color: #eaeaea;
            border-radius: 50%;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .content p{
            font-size: 16px;
        }

        .ratings span{
            font-size: 18px;
            margin-left: 12px;
        }

        .right-side{
            position: relative;
            margin-top: 50px;
            
        }

        .buttons .btn{
            height: 50px;
            width: 150px;
            border-radius: 0px !important;
        }

        #btn-buy{
            border: 2px solid rgb(255, 193, 69);
            font-weight: 500;
        }

        #btn-back{
            border: 2px solid rgb(255, 193, 69);
            background-color: rgb(255, 193, 69);
            font-weight: 500;
        }
        
        



    </style>


<body>

    <%@ include file="/views/common/header.jsp" %>

    <div class="container mt-5 mb-5" style="width: 800px;">	
        <div class="card">	
            <div class="row g-0">	
                <div class="col-md-6 border-end">	
                    <div class="d-flex flex-column justify-content-center">	
                        <div class="main_image">	
                            <img src="https://cf.lottecinema.co.kr//Media/WebAdmin/70fc20fe998a4ab7b44d1bfa0d1440e4.jpg" id="main_product_image" width="350">	
                        </div>	
                    </div>	
                </div>	
                    <div class="col-md-6">	
                        <div class="p-3 right-side">	
                            <div class="d-flex justify-content-between align-items-center">	
                                <h3>오리지널팝콘L</h3>	
                            </div>	
                            <div class="mt-2 pr-3 content">	
                                <p>캡짱 맛있는 팝콘</p>	
                            </div>	
                            <h3>9,000원</h3>	
                        <div class="buttons d-flex flex-row mt-5 gap-3">	
                            <button class="btn" id="btn-buy">바로 구매</button>	
                            <button class="btn" id="btn-back">장바구니에 넣기</button>	
                        </div>	
                        
                    </div>	
                </div>	
            </div>	
        </div> 
    </div>

    <%@ include file="/views/common/footer.jsp" %>

    <script>
    

    </script>




</body>
</html>