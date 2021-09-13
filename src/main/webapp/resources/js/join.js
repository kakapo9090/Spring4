/**
 * 
 */
 
 //id, pw, name, email, phone 비어 있으면 안된다.
 $("#btn1").click(function(){
		let result = true;
		let t;
	
	$(".put").each(function(s1, s2){
		if($(s2).val() == ""){
			result = false;
			t=s2;
		}
	});
		if(result){
			alert('submit 성공');
			//$("#frm").submit();
		}else{
			alert('필수 입력');
			$(t).focus();
		}
	
});
 