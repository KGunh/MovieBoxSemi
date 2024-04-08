window.onload = function(){
    $.ajax({
        url : 'checkInfo.reservationAjax',
        type : 'post',
        data : {
            ticketNo : selectTicketNo
        },
        success : function(result) {
            let imgFilePath = path + '/' + result.movie.filePath + '/' + result.movie.changeName;
            let selectSeatList = '';

            let resvItems = [
                result.ticketNo,
                result.watchDate,
                result.theaterName,
                result.screenName,
                Number(result.price.studentCount + result.price.commonCount) + '인'
            ];

            let InfoItems = [
                result.movie.movieTitle,
                '개봉일 : ' + result.movie.movieRelease,
                result.movie.genreName + ' | ' + result.movie.movieRt + '분'
            ];

            for(let i = 0; i < result.seatList.length; i++){
                selectSeatList += result.seatList[i].seatNo;
                
                if (i < result.seatList.length - 1) {
                    selectSeatList += ', ';
                };
            };

            $('#movie-poster').html('<img src="' + imgFilePath + '" alt="영화포스터">');
            
            $('#movie-info').children().each(function(i) {
                $(this).html(InfoItems[i]);
            });

            $('#print-reservation-info').children().each(function(i) {
                $(this).html(resvItems[i]);
            });

            $('#print-reservation-info').children().eq(5).html(selectSeatList);
            $('#print-reservation-info').children().eq(6).html(result.price.totalPrice + '원');
        },
        error : function(e) {
            alert('예매 실패!');
            location.href = (path + '/' + index.jsp);
        }
    });
};