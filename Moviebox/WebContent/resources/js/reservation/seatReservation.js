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
            screenNo : selectScreenNo
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

        CountPeple(ageType);
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

        CountPeple(ageType);
    }

    peopleCount = teenCount + adultCount;
    selectSeat = [];

    $('.seats').removeClass('clicked');
    $("#check-area").hide();

    printPeople();
});

function CountPeple(ageType) {
    let ageBtns = (ageType.html() === '청소년') ? $('.adultBtn') : $('.teenBtn');
    let maxCount = (ageType.html() === '청소년') ? (8 - teenCount) : (8 - adultCount);

    for (let i = 0; i < ageBtns.length; i++) {
        if(Number(ageBtns.eq(i).html()) > maxCount) {
            ageBtns.eq(i).prop('disabled', true);
        } else {
            ageBtns.eq(i).prop('disabled', false);
        }
    }
};

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
            screenNo : selectScreenNo,
            movieNo : selectMovieNo,
            teenAge : teenCount,
            adultAge : adultCount 
        },
        success : function(result){
            if(!(selectSeat.length == 0) && selectPeople == 0){
                
                let selectSeats = selectSeat.join(', ');
                let MovieItems = [
                    result.movieTitle,
                    result.movie.movieRelease,
                    result.movie.genreName + ' / ' + result.movie.movieRt + '분'
                ];
                
                let resvItems = [
                    result.watchDate,
                    result.theaterName,
                    result.screenName,
                    Number(teenCount + adultCount) + '인',
                    selectSeats,
                    result.price.totalPrice + '원'
                ];

                let inputval = [
                    selectMovieNo, 
                    selectScreenNo, 
                    memberNo,
                    teenCount, 
                    adultCount, 
                    selectSeats
                ];

                $('#poster-select > img').attr('src', path + '/'+ result.movie.filePath + '/' + result.movie.changeName);
                
                for(let i = 0; i < $('#movie-select').children().length; i++){
                    $('#movie-select').children().eq(i).html(MovieItems[i]);
                };
                
                for(let i = 0; i < $('#print-reservation-info').children().length; i++){
                    $('#print-reservation-info').children().eq(i).html(resvItems[i]);
                };

                for(let i = 0; i < $('#payment-form').children().length; i++){
                    $('#payment-form').children().eq(i).val(inputval[i]);
                };
                
                $("#check-area").removeAttr("hidden");
                $("#check-area").show();
            }
            else {
                alert('좌석을 모두 선택해주세요!');
                $("#check-area").hide();
            };
        },
        error : function(){
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