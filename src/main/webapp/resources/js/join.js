/**
 * 
 */
 
 const put = document.getElementsByClassName('put');
 const btn = document.getElementById('btn1');
 const pws = document.getElementsByClassName('pw');
 const frm = document.getElementById('frm');
 const id = document.getElementById('id');
 const idResult = document.getElementById('idResult');
 const pw1 = document.getElementById('pw1');
 const pw2 = document.getElementById('pw2');
 const idCheck = document.getElementById('idCheck');
 
 idCheck.addEventListener('click', function(){
	open("./idCheck?id="+id.value, "", "width=400, height=200, top=200, left=300");
});
 
//아이디 체크
/*id.addEventListener('change', function(){
	alert('change');
});
*/


//비번 체크: 비번글자수, 비번확인 값 일치(미완)
pw2.addEventListener('blur', function(){
	if(pw2.value.trim().length!=pw1.value.trim().length){
		alert('비밀번호가 다릅니다');
	}
});
 
 
 
 
 //버튼 클릭시 실행
 btn.addEventListener('click', function(){
	//비어있는것들 검사
	let ce = checkEmpty(put);
	//비밀번호 == 비밀번호확인 검사
	let ce2 = checkEqual(pws[0], pws[1]);
	// 길이 6글자 이상 확인
	let c1 = checkLength();
	
	if(ce&&ce2&&c1){
		frm.submit(); //폼 이벤트 강제발생
	}else{
		alert('필수입력');
	}
	
});



//======================== 함수들 ==================================


function checkLength(){
	let l = pws[0].value.trim().length;
	if(l>=6){
		return true;
	}else{
		return false;
	}
}

// 굳이 이렇게 안 만들어도 상관은 없지만 만들 수 있다는 것을 보여주기 위함
function checkEqual(check1, check2){
	return check1.value == check2.value;
}

function checkEmpty(puts){
	let result = true;
	for(r of puts){
		if(r.value.trim() ==""){
			result=false;
			break;
		}
	}
	return result;
}