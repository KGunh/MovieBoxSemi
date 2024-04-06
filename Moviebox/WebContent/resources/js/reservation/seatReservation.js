let resvAdult = ['', 0];
let resvTeen = ['', 0]; 
let selectSeat = [];
let mousedrag = false;
let selectPeople = 0;
let peopleCount = 0;
let adultCount = 0;
let teenCount = 0;

window.onload = function() {
    $.ajax({
        url : 'seat.reservationAjax',
        type : 'get',
        data : {
            screenNo : <%= screenNo %>
        },
        success : function(result){
            result.forEach(function(seat) {
                $('.seats').each(function() {
                    if ($(this).html() === seat.seatNo) {
                        $(this).addClass('disabled');
                        $(this).html('X');
                    };
                });
            });
        },
        error : function(){
            alert('잘못된 상영관 정보입니다. 상영관을 다시 선택해주세요!');
            location.href = '/moviebox/movie.reservation';
        }
    });
};

$('.people-Count').on('click', function() {
    let ageType = $(this).parent().prev().children().eq(0);

    if(ageType.html() == '청소년'){
        teenCount = Number($(this).html());
        $('.people-teen').addClass('clicked');

        if($(this).hasClass('clicked')) {
            $('.teenBtn').removeClass('clicked');
            ageType.removeClass('clicked');
            
            teenCount = 0;
        }
        else{
            $('.teenBtn').removeClass('clicked');
            $(this).addClass('clicked');
            ageType.addClass('clicked');
        }
    }
    else{
        adultCount = Number($(this).html());
        $('.people-adult').addClass('clicked');

        if($(this).hasClass('clicked')) {
            $('.adultBtn').removeClass('clicked');
            ageType.removeClass('clicked');
            
            adultCount = 0;
        }
        else{
            $('.adultBtn').removeClass('clicked');
            $(this).addClass('clicked');
            ageType.addClass('clicked');
        }
    }

    peopleCount = teenCount + adultCount;
    selectSeat = [];

    $('.seats').removeClass('clicked');
    $("#check-area").hide();

    printPeople();
});

function printPeople() {
    selectPeople = teenCount + adultCount;

    if(selectPeople < 9) {
        $('#select-people').html(
            '<div>청소년 : ' + teenCount + '명</div>'
           +'<div>  성인 : ' + adultCount + '명</div>'
           +'<div>  전체 : ' + selectPeople + '명</div>'
        );
    } 
    else {
        alert('선택 가능한 인원은 최대 8명입니다!');
        $('.people-Count').removeClass('clicked');
        $('.ageBtn').removeClass('clicked');
        $('#select-people').html('');

        teenCount = 0;
        adultCount = 0;
    };
    
    peopleCount = 0;
};

$('.seats').on('mousedown', function(){
    mousedrag = true;
    selectSeats(this);
    arrangeSeat();
});

$('.seats').on('mouseenter', function(){
    if(mousedrag){
        selectSeats(this);
        arrangeSeat();
    }
});

$(document).on('mouseup', function() {
    mousedrag = false;
});

function selectSeats(e) {
    let index = selectSeat.indexOf($(e).html());

    if($(e).hasClass('clicked')) {
        $(e).removeClass('clicked');
        $("#check-area").hide();

        selectSeat.splice(index, 1);
        selectPeople += 1;
    } 
    else {
        if(selectPeople < 1 ) {
            if(!$('.people-Count').hasClass('clicked')) alert('인원을 먼저 선택해주세요.');
            else alert('좌석을 모두 선택하셨습니다.'); mousedrag = false;
        }
        else {
            $(e).addClass('clicked');
            selectSeat.push($(e).html());
            selectPeople -= 1;
        };
    };
};

function arrangeSeat(){
    selectSeat.sort(function(a, b) {
        let strA = a.match(/[A-F]/);
        let strB = b.match(/[A-F]/);
        
        if (strA < strB) {
            return -1;
        } 
        else if (strA > strB) {
            return 1;
        };
        
        let numA = parseInt(a.match(/\d+/));
        let numB = parseInt(b.match(/\d+/));

        return numA - numB;
    });
};

$('#print-resv-info').click(function(){
    $.ajax({
        url : 'printInfo.reservationAjax',
        type : 'post',
        data : {
            screenNo : <%= screenNo %>,
            movieNo : <%= movieNo %>,
            teenAge : teenCount,
            adultAge : adultCount 
        },
        success : function(result){
            if(!(selectSeat.length == 0) && selectPeople == 0){
                let selectSeats = selectSeat.join(', ');
                let resultStr = '';
                
                $("#check-area").removeAttr("hidden");
                $("#check-area").show();
                
                resultStr += '<div id="check-reservation">'
                           +     '<div id="check-movie">'
                           +         '<div id="poster-select"><img style="width: 100%; height: 100%;" src="<%= contextPath %>/'+ result.movie.filePath + '/' + result.movie.fileName + '" alt="영화포스터"></div>'
                           +         '<div id="movie-select">'
                           +             '<div style="text-align: center; font-size:20px; font-weight: 700; margin-top: 5px; margin-bottom: 5px;">' + result.movieTitle + '</div>'
                           +             '<div style="text-align: center;">개봉일 ' + result.movie.movieRelease + '</div>'
                           +             '<div style="text-align: center;">' + result.movie.genreName + ' / ' + result.movie.movieRt + '분</div>'
                           +         '</div>'
                           +     '</div>'
                           + '</div>'
                           + '<div id="check-info">'
                           +     '<div id="reservation-info">'
                           +         '<div>'
                           +             '<div class="select-info">상영일시</div>'
                           +             '<div class="select-info">관람극장</div>'
                           +             '<div class="select-info">상영관</div>'
                           +             '<div class="select-info">관람인원</div>'
                           +             '<div class="select-info">선택좌석</div>'
                           +             '<div class="select-info" style="margin-top: 50px;">결제금액</div>'
                           +         '</div>'
                           +         '<div>'
                           +             '<div class="print-info">'+ result.watchDate +'</div>'
                           +             '<div class="print-info">' + result.theaterName + '</div>'
                           +             '<div class="print-info">' + result.screenName + '</div>'
                           +             '<div class="print-info">' + Number(teenCount + adultCount) + '인</div>'
                           +             '<div class="print-info">' + selectSeats + '</div>'
                           +             '<div class="print-info" style="margin-top: 50px;">' + result.price.totalPrice + '원</div>'
                           +         '</div>'
                           +     '</div>'
                           +     '<form id="payment-form" action="/moviebox/payment.reservation" method="post">'
                           +         '<input type="hidden" name="movieNo" value="' + <%= movieNo %> + '">'
                           +         '<input type="hidden" name="screenNo" value="' + <%= screenNo %> + '">'
                           +         '<input type="hidden" name="memberNo" value="' + <%= loginUser.getMemberNo() %> + '">'
                           +         '<input type="hidden" name="teen" value="' + teenCount + '">'
                           +         '<input type="hidden" name="adult" value="' + adultCount + '">'
                           +         '<input type="hidden" name="seatNo" value="' + selectSeats + '">'
                           +         '<button type="submit" id="payment-btn" onclick="return payment()">결제 하기</button>'
                           +     '</form>'
                           + '</div>';

                $('#check-area').html(resultStr);
            }
            else {
                alert('좌석을 모두 선택해주세요!');
                $("#check-area").hide();
            };
        },
        error : function(e){
            alert('예매정보 오류!');
            location.href = '\moviebox';
        }
    });
});

function payment(){
    if(confirm('현재 예매 정보로 결제하시겠습니까?')) {
        return true;
    };

    return false;
};