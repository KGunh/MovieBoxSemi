const swiper = new Swiper('.swiper', {
    loop : true,
    slidesPerView : 4,
    pagination: {
        el: '.swiper-pagination',
        clickable: true
    },
    navigation: {
        prevEl: '.swiper-button-prev',
        nextEl: '.swiper-button-next'
    }
}); 

let movieTitle = '';

window.onload = function() {
    let today = new Date();
    let year = today.getFullYear();
    let month = (String)(today.getMonth() + 1).padStart(2, '0');
    let day = (String)(today.getDate()).padStart(2, '0');
    document.getElementById('printToday').innerHTML = year + '-' + month + '-' + day;
};

$('.poster').click(function(){
    $('.poster').not(this).removeAttr('style');
    $(this).css('transform', 'scale(1.1)');
    $('#movieNo').val($(this).children().eq(1).val());

    movieTitle = $(this).children().eq(2).val();
    
    $('#movieTitle').val(movieTitle);
});

function selectScreenNo(e){
    if($(e).hasClass('clicked')){
        $('.screenName').removeClass('clicked');
        $('#screenNo').removeAttr('value');
        $('#screenName').removeAttr('value');
       
        return '';
    } 
    else{
        $('.screenName').removeClass('clicked');
        $(e).addClass('clicked');
    }

    $('#select-screen').children().eq(0).html($(e).parent().prev().html());
    $('#select-screen').children().eq(1).html(movieTitle);
    $('#select-screen').children().eq(2).html($(e).children().eq(2).val());
    $('#select-screen').children().eq(3).html($(e).children().eq(0).html());
    $('#screenNo').val(e.children[1].value);
    $('#screenName').val(e.children[2].value);
    $('#theaterName').val($(e).children().eq(2).html());
};

function selectScreen(){
    $.ajax({
        url : 'screen.reservationAjax',
        type : 'get',
        data : {
            date : $('#screenDate').val(),
            location : $('#locationOption').val(),
            movieNo : $('#movieNo').val()
        },
        success : function(result){
            let resultStr = '';

            if(result.length != 0){

                for(let i = 0; i < result.length; i++){
                    resultStr += '<div class="screen">'
                               +    '<div class="theaterName">' + result[i].theaterName + '</div>'
                               +        '<div class="selectScreen">';
                    
                    for(let j = 0; j < result[i].watchDateList.length; j++){
                        resultStr +=        '<div class="screenName" onclick="selectScreenNo(this);">'
                                   +            '<span style="color: black;">' + result[i].watchDateList[j] + '</span>'
                                   +            '<input type="hidden" value="' + result[i].screenNoList[j] + '">'
                                   +            '<input type="hidden" value="' + result[i].screenNameList[j] + '">'
                                   +        '</div>';
                    };
                    
                    resultStr +=        '</div>'
                               +    '</div>'
                               + '</div>';
                };
                
            }
            else{
                resultStr = '<div class="resultMsg">조회된 상영관이 없습니다</div>';
            }

            $('#printScreen').html(resultStr);
        },
        error : function(){
            $('#printScreen').html('조회된 영화관이 없습니다.');
        }
    });
};
    
$('.poster').click(function(e){
    selectScreen();
});

$('#screenDate').change(function(e){
    selectScreen();
});

$('#locationOption').change(function(){
    selectScreen();
});

$('#submit-btn').click(function(){
    if(!$('#screenNo').val()){
        alert('상영관을 선택해주세요!');
    } else {
        $('form').submit();
    }
});