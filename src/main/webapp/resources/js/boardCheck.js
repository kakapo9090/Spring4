/**
 * 
 */
 
 const btn = document.getElementById("btn");
 

 btn.addEventListener("click", function(){
	 const title = document.getElementById("title");
	 const writer = document.getElementById("writer");
	const frm = document.getElementById("frm");	// 폼 영역 전체를 묶은 변수
	const t1 = document.getElementById("t_1");
	const w1 = document.getElementById("w_1");
	t1.innerHTML=""; //클릭하면 t_1 영역에 글자 없애기
	w1.innerHTML="";
	
	let t = title.value; 	// id title에 입력한 값을 저장하는 변수 선언
	let w = writer.value;	// id writer에 입력한 값을 저장하는 변수 선언
	
	let check=true;		// 체크용 변수 선언
	
	if(t == ""){	// 입력값 t가 비어있다면 
		check=false;	// check값을 false로
		t1.innerHTML="필수 입력";	// t_1 영역에 메시지 출력
	}
	if(w == ""){
		check=false;
		w1.innerHTML="필수 입력";
	}


	if(check==true){
		frm.submit();	//폼 양식 제출
	}else{
		alert('please input')
	}
	
	
	//1
/*	if(t != "" && w != ""){
		alert(true);
	}else{
		alert(false);
	}*/


/*	if(t == ""){
		alert('null');
	}
	if(w == ""){
		alert('null');
	}*/
});
 
