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
            background-color: #ecedee
        }

        .card{
            border: none;overflow: hidden
        }

        .main_image{
            display: flex;justify-content: center;align-items: center;border-bottom: 1px solid #eee;height: 400px;width: 100%;overflow: hidden
        }

        .heart{
            height: 29px;width: 29px;background-color: #eaeaea;border-radius: 50%;display: flex;justify-content: center;align-items: center
        }

        .content p{
            font-size: 12px
        }

        .ratings span{
            font-size: 14px;margin-left: 12px
        }

        .right-side{
            position: relative
        }

        .buttons .btn{
            height: 50px;width: 150px;border-radius: 0px !important
        }

    </style>


<body>

    <%@ include file="/views/common/header.jsp" %>

    <div class="container mt-5 mb-5">	
        <div class="card">	
            <div class="row g-0">	
                <div class="col-md-6 border-end">	
                    <div class="d-flex flex-column justify-content-center">	
                        <div class="main_image">	
                            <img src="https://i.imgur.com/TAzli1U.jpg" id="main_product_image" width="350">	
                        </div>	
                    </div>	
                </div>	
                    <div class="col-md-6">	
                        <div class="p-3 right-side">	
                            <div class="d-flex justify-content-between align-items-center">	
                                <h3>IIlana</h3>	
                            </div>	
                            <div class="mt-2 pr-3 content">	
                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua</p>	
                            </div>	
                            <h3>$430.99</h3>	
                        <div class="ratings d-flex flex-row align-items-center">	
                            <div class="d-flex flex-row">	
                                <i class='bx bxs-star' ></i>	
                                <i class='bx bxs-star' ></i>	
                                <i class='bx bxs-star' ></i>	
                                <i class='bx bxs-star' ></i>	
                                <i class='bx bx-star' ></i>	
                            </div>	
                            <span>441 reviews</span>	
                        </div>	
                        
                        <div class="buttons d-flex flex-row mt-5 gap-3">	
                            <button class="btn btn-outline-dark">Buy Now</button>	
                            <button class="btn btn-dark">Add to Basket</button>	
                        </div>	
                        
                    </div>	
                </div>	
            </div>	
        </div> 
    </div>

    <%@ include file="/views/common/footer.jsp" %>

<script>
    function changeImage(element) {

        var main_prodcut_image = document.getElementById('main_product_image');
        main_prodcut_image.src = element.src;
    }

</script>




</body>
</html>