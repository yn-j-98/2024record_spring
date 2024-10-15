
$(document).ready(function() {
    $('#searchButton').click(function() {
        const condition = $('#condition').val();
        const keyword = $('#keyword').val();
		console.log('condition' + condition);
		console.log('keyword' + keyword);
	    var searchResults = $('#searchResults');
        $.ajax({
            url: 'search.do',
            type: 'POST',
            data: JSON.stringify({ condition: condition, keyword: keyword }),
            contentType: 'application/json',
			dataType:'json',
			success: function(data){
				console.log('data : ['+data+']');
				searchResults.empty();
				data.forEach(datas => {
					var html = '<li>' +
					      '<strong>글 번호:</strong> ' + datas.bid + '<br>' +
					      '<strong>내용:</strong> ' + (condition === 'CONTENT' ? datas.content : datas.title) + '<br>' +
					      '<strong>작성자:</strong> ' + (condition === 'NAME' ? datas.name : datas.name) + '<br>' +
					      '</li>';
				searchResults.append(html);
				});	
			},
            error: function() {
				searchResults.empty();
				searchResults.append('<li>검색 결과가 없습니다.</li>');
            }
        });
    });
});
