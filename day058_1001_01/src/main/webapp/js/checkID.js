
// 데이터 1개 받기
/*$(document).ready(function(){
	$('#mid').on('change', function(){
		var mid = $(this).val();
		console.log('['+mid+']');
		
		if(mid){
			$.ajax({
				url : 'checkMID.do',
				type : 'POST',
				data : { mid : mid }, // mid라는 이름으로 mid 값을 보냄
				success : function(data){
					console.log('['+data+']');
					console.log(typeof data);
					
					if(data == 'true'){
						$('#result').text('DB에 존재하는 아이디입니다.').css('color','red');
					}
					else{
						$('#result').text('DB에 없는 아이디입니다.').css('color','blue');
					}
				}
			});
		}
		else{
			$('#result').text('');
		}
	});
});*/

// 데이터 여러개 받기
$(document).ready(function(){
	$('#mid').on('change', function(){
		var mid = $(this).val();
		console.log('['+mid+']');
		
		if(mid){
			$.ajax({
				url : 'check.do',
				type : 'POST',
				contentType : 'application/json', // 요청 data 형식도 json
				data : JSON.stringify({ mid : mid }), // 실제로 data도 json으로 보내야 함
				dataType : json, // 타입또한
				success : function(data){
					console.log('['+data+']');
					console.log(typeof data);
					
					if(data == 'true'){
						$('#result').text('DB에 존재하는 아이디입니다.').css('color','red');
					}
					else{
						$('#result').text('DB에 없는 아이디입니다.').css('color','blue');
					}
				}
			});
		}
		else{
			$('#result').text('');
		}
	});
});