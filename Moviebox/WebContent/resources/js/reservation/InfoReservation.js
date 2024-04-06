window.onload = function(){
    $.ajax({
        url : 'checkInfo.reservationAjax',
        type : 'post',
        data : {
            ticketNo : selectTicketNo
        },
        success : function(result) {
            console.log(result);
            var imgFilePath = path + '/' + result.movie.filePath + '/' + result.movie.fileName;
            var selectSeatList = '';

            $('#movie-poster').html('<img src="' + imgFilePath + '" alt="영화포스터">');
            $('#movie-info').children().eq(0).html(result.movie.movieTitle);
            $('#movie-info').children().eq(1).html('개봉일 : ' + result.movie.movieRelease);
            $('#movie-info').children().eq(2).html('장르 : ' + result.movie.genreName);
            $('#movie-info').children().eq(3).html('러닝타임 : ' + result.movie.movieRt + '분');
        
            $('#print-reservation-info').children().eq(0).html(result.ticketNo);
            $('#print-reservation-info').children().eq(1).html(result.watchDate);
            $('#print-reservation-info').children().eq(2).html(result.theaterName);
            $('#print-reservation-info').children().eq(3).html(result.screenName);
            $('#print-reservation-info').children().eq(4).html(Number(result.price.studentCount + result.price.commonCount) + '인');

            for(let i = 0; i < result.seatList.length; i++){
                selectSeatList += result.seatList[i].seatNo;
                
                if (i < result.seatList.length - 1) {
                    selectSeatList += ', ';
                };
            };

            $('#print-reservation-info').children().eq(5).html(selectSeatList);
            $('#print-reservation-info').children().eq(6).html(result.price.totalPrice + '원');
        },
        error : function(e) {
            alert('예매 실패!');
            location.href = (path + '/' + index.jsp);
        }
    });
};