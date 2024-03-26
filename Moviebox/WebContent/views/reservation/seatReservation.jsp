<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.kh.reservation.model.vo.Seat" %>

<%
	List<Seat> list = (List<Seat>)request.getAttribute("seatList");
%>    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>좌석 선택</title>
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
        height: 200px;
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
        margin-left: 10px;
        font-size: 14px;
        text-align: center;
        line-height: 26px;
        border-radius: 6px;
        background-color: rgba(70, 69, 69, 0.82);
        color: rgb(125, 124, 124);
    }

    .seats:hover{
        cursor: pointer;
    }

    .line-wrap{
        width: 750px;
        height: 50px;
        margin: auto;
    }

    #selectText{
        height: 100px;
        color: rgb(255, 193, 69);
        padding-top: 30px;
        padding-left: 30px;
        font-size: 28px;
        font-weight: 700;
    }
    
    #select-wrap{
        height: 150px;
        width: 600px;
        margin-left: 300px;
    }

    #selectAge{
        float: left; 
        margin-left: 15px;
        margin-top: 20px;
    }

    #selectAge > button{
        height: 45px;
        width: 75px;
        font-size: 20px;
        font-weight: 700;
        border-radius: 8px;
        background-color: rgba(70, 69, 69, 0.82);
        color: rgb(125, 124, 124);
        border: none;
    }

    #selectPerson{
        float: left;
        margin-left: 20px;
        margin-top: 20px;
    }

    #selectPerson > button{
        background-color: rgba(70, 69, 69, 0.82);
        color: rgb(125, 124, 124);
        height: 45px;
        width: 45px;
        border: none;
        border-radius: 8px;
    }

    #select-wrap button:hover{
        background-color: rgb(255, 193, 69);
        color: rgb(32,32,32);
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
                    <button>청소년</button>
                    <button>성인</button>
                </div>
                <div id="selectPerson">
                    <button class="people-Count">1</button>
                    <button class="people-Count">2</button>
                    <button class="people-Count">3</button>
                    <button class="people-Count">4</button>
                    <button class="people-Count">5</button>
                    <button class="people-Count">6</button>
                    <button class="people-Count">7</button>
                    <button class="people-Count">8</button>
                </div>
            </div>
        </div>
        
        <div id="seat-wrap">
            <div id="seat-title"> 좌석 선택 </div>
            <div id="seat-arrange">
                <div id="a-line" class="line">
                    <div id="a-line-wrap" class="line-wrap">
                        <% for(int i = 1; i <= 18; i++){ %>
                        	<div class="a-seat seats">A<%= i %></div>
                        <% } %>
                    </div>
                </div>
                <div id="b-line" class="line">
                    <div id="b-line-wrap" class="line-wrap">
                        <% for(int i = 1; i <= 18; i++){ %>
                        	<div class="b-seat seats">B<%= i %></div>
                        <% } %>
                    </div>
                </div>
                <div id="c-line" class="line">
                    <div id="c-line-wrap" class="line-wrap">
                         <% for(int i = 1; i <= 18; i++){ %>
                        	<div class="c-seat seats">C<%= i %></div>
                         <% } %>
                    </div>
                </div>
                <div id="d-line" class="line">
                    <div id="d-line-wrap" class="line-wrap">
                         <% for(int i = 1; i <= 18; i++){ %>
                        	<div class="d-seat seats">D<%= i %></div>
                         <% } %>
                    </div>
                </div>
                <div id="e-line" class="line">
                    <div id="e-line-wrap" class="line-wrap">
                        <% for(int i = 1; i <= 18; i++){ %>
                        	<div class="e-seat seats">E<%= i %></div>
                        <% } %>
                    </div>
                </div>
                <div id="f-line" class="line">
                    <div id="e-line-wrap" class="line-wrap">
                         <% for(int i = 1; i <= 18; i++){ %>
                        	<div class="f-seat seats">F<%= i %></div>
                         <% } %>
                    </div>
                </div>
            </div>
        </div>
        <button>결제</button>
	</div>
	<%@ include file="/views/common/footer.jsp" %>

    <style>
        .clicked{
            color: rgb(32,32,32);
            background-color: rgb(255, 193, 69);
        }

        .unClicked{
            border : none;
            background-color: rgba(70, 69, 69, 0.82);
        }

    </style>

    <script>

        var peopleCount = 0;

    	window.onload = function(){
            $.ajax({
                url : 'screen.reservation',
            	type : 'get',
            	data : {
                    
            	},
                success : function(result){

                }
            });
        };

        $('.seats').click(e => {
            const $e = $(e.target);
            
            if(peopleCount < 8){
                if($e.hasClass('clicked')){
                    $e.removeClass('clicked');
                    $e.addClass('unClicked');
                    peopleCount -= 1;
                } 
                else{
                    peopleCount += 1;
                    $e.removeClass('unClicked');
                    $e.addClass('clicked');
                }
            }
            else{
                alert('선택 가능한 인원은 최대 8명입니다');
                peopleCount = 0;
                $('.seats').removeClass('clicked');
                $('.people-Count').removeAttr('style');
                count();
            }

            count();
        });

        function count(){
            console.log(peopleCount);
            var clickSeat = $('#selectPerson').children().eq(peopleCount - 1);
            clickSeat.css('background', 'rgb(255, 193, 69)'); 
            $('#selectPerson').children().not(clickSeat).not().removeAttr('style');
        };
       


    </script>



</body>
</html>