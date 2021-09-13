/**
 * 약관동의
 */
 
 const all = document.getElementById('all'); //전체 체크하기 id
 const checks = document.getElementsByClassName('checks');//배열 반환
 const btn = document.getElementById('btn');
 const pilsu = document.getElementsByClassName('pilsu'); // 필수항목
 
 //버튼 클릭시 주소 이동
 /*btn.addEventListener('click', function(){
	let result=0;

		for(let p of pilsu){
			if(p.checked){
				result=result+1;
			}
		}
		if(result==pilsu.length){
			location.href="./join";
		}else{
			alert('필수 약관에 동의 하세요')
		}
		
});*/
// 버튼 클릭시 주소 이동 - 다른 정답
btn.addEventListener('click', function(){
	let result=true;
	for(let p of pilsu){
		if(!p.checked){
			result=false;
			break;
		}
	}
	if(result){
			location.href="./join";
		}else{
			alert('필수 약관에 동의 하세요')
		}
	});

//=======================================================
// 모두 체크 하기 버튼
all.addEventListener('click', function(){
	
	for(let ch of checks){
		ch.checked = all.checked;
	}
});
//-------------------------------------------------
// 전부 체크하면 전부 체크 버튼에 체크되는 함수
for(let ch of checks){//반복문
	ch.addEventListener('click', function(){
		let result = true;	//
		
		for(c of checks){
			if(!c.checked){		//박스에 하나라도 체크가 되어 있지 않다면,
				result = false;		// result에 false 대입 후 빠져나옴
				break;
			}
		}
		all.checked=result;
	});
}