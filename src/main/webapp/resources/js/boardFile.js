/**
 * boardFile.js
 	최대 5개까지만 추가 가능
 	보드파일 추가
 */
  let files = '<div class="input-group mb-3">';
 files = files + '<input type="file" name="files" class="form-control">';
 files = files + '<button class="btn btn-outline-secondary del" type="button">X</button>';
 files = files + '</div>';
 let count = 0;
 //let index=0;
 
 function setCount(c){
	count = c;
}
 
 
 $("#fileAdd").click(function(){
	/*index++;
 let files = '<div class="input-group mb-3" id="del'+index+'">';
 files = files + '<input type="file" class="form-control">';
 files = files + '<button data-btn-id="'+index+'" class="btn btn-outline-secondary del" type="button">X</button>';
 files = files + '</div>'*/
	if(count<5){
		count++;
		$("#fileAddResult").append(files);	
	}else{
		alert('최대 5개까지만 가능')
	}
});

$("#fileAddResult").on('click', '.del' ,function(){
/*	let num = $(this).attr('data-btn-id');
	$("#del"+num).remove();*/
	
	$(this).parent().remove();
	
	count--;
});


/*$(".del").click(function(){
	alert('test');
});
*/
/*file = file + '<label for="photo" class="form-label">Photo</label>';
file = file + '<input type="file" name="photo" class="form-control put" id="photo" >';
file = file +  '</div>'
*/
