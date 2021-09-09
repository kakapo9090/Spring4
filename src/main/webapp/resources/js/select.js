/**
 *  select.js
 */
 
 const btn = document.getElementById('btn');
 const c1 = document.getElementsByClassName('c1');
 
btn.addEventListener('click', function(){
	for(let ch of c1){
		ch.checked= true;
	}
	alert('check all');
});


for(let ch of c1){
	if(ch.checked){
		ch.checked= !ch.checked;
	}else{
		ch.checked= !ch.checked;
	}
}
 
 for(let ch of c1){
	ch.addEventListener('click', function(){
		alert(ch.checked);
	//	let t2=2; //지역변수

	});
}