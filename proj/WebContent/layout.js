$(".one").on("click",".s1",function(){
	$(this).toggleClass("completed");
	 $(".main1").toggle();
	 
});

$(".one").on("click",".s2",function(){
	$(this).toggleClass("completed");
	 $(".main2").toggle();
});

$(".one").on("click",".s3",function(){
	$(this).toggleClass("completed");
	 $(".main3").toggle();
});

$(".one").on("click",".s4",function(){
	$(this).toggleClass("completed");
	 $(".main4").toggle();
});

$(".coach1").on("click",".btn",function(){
	var text = $(this).text();
	var isConfirmed = prompt("Are you sure you want to select berth number "+ text + "? Yes or No");
	
	if(isConfirmed.toLowerCase()==="yes"){
		$(this).prop("disabled",true);
	}else{
		$(this).prop("disabled",false);
	}
});