$(document).ready(function() {
    $('#searchButton').on('click', function(event) {
		event.preventDefault();
        console.log('검색 버튼 클릭됨'); 

        const condition = $('#condition').val();
        const key= $('#keyword').val().trim(); // 키워드의 공백을 제거

        console.log('condition:', condition); 
        console.log('key['+key+']'); 

        $.ajax({
            url: 'search.do', 
            type: 'POST',
            data: JSON.stringify({ condition: condition, keyword: key }),
            contentType: 'application/json',
            dataType: 'json',
            success: function(data) {
				$("#rs").empty();
                console.log('data['+data+']'); 
                // 데이터가 배열인지 확인하고 길이 체크
               
                  
                    if (data.length > 0) {
                       // 결과가 있는 경우
                        data.forEach(datas => {
                            var html = '<li>' +
                                '<strong>글 번호:</strong> ' + datas.bid + '<br>' +
                                '<strong>내용:</strong> ' + datas.content + '<br>' +
                                '<strong>작성자:</strong> ' + datas.writer + '<br>' +
                                '</li>';
                            $("#rs").append(html);
                        });
                    } else {
                        // 결과가 없을 경우
                        console.log('검색 결과가 없습니다.');  // 검색 결과가 없을 때 로그 추가
						$("#rs").append('<li>검색 결과가 없습니다.</li>');
                    }
            },
            error: function(status, error) {
                console.error('AJAX 요청 실패:', status, error); // 에러 로그
            }
        });
    });
}); 
