/**
 * 
 */
/*全选或取消全选*/
function allcheck(){
	var oBtn1 = document.getElementById('btn1');
	var oCheck = document.getElementsByName('check');
	for(var i=0;i<oCheck.length;i++){
		oCheck[i].checked = true;
	}
	
}

function allcanclecheck(){
	var oBtn2 = document.getElementById('btn2');
	var oCheck = document.getElementsByName('check');
	for(var i=0;i<oCheck.length;i++){
		oCheck[i].checked = false;
	}
	
}



/*批量删除用户,如果删除审核人，审核人表也会删除对应的人*/
function DelAllUser(){
	var alluser = new Array();
	var flag = false;
	var oCheck = document.getElementsByName('check');
	for(var i=0;i<oCheck.length;i++){
		if(oCheck[i].checked){
			alluser.push(oCheck[i].value);	
			flag = true;
		}
	}
	if(flag){/*您确定要删除这些记录吗？请选择！*/
		if(confirm("Are you sure to delete these record?")){
			location.href="UpdateUser?f=delall&Uname="+alluser;
/*			location.href="UpdateExaminer?f=delall&Uname="+alluser;*/
		}
	}	
		else{
		alert("Please choose one at least befor delete!");
	
  }
}
	
	
	
function DelAllActivity(){
		var allactivity = new Array();
		var flag = false;
		var oCheck = document.getElementsByName('check');
		for(var i=0;i<oCheck.length;i++){
			if(oCheck[i].checked){
				allactivity.push(oCheck[i].value);	
				flag = true;
			}
		}
		if(flag){/*您确定要删除这些记录吗？请选择！*/
			if(confirm("Are you sure to delete these record?")){
				location.href="UpdateActivity?f=delall&Aid="+allactivity;
			}
		}	
			else{
			alert("Please choose one at least befor delete!");
		
	  }	
}
	

	
	
/*
	批量删除审核人
function DelAllExaminer(){
	var allexaminer = new Array();
	var flag = false;
	var oCheck = document.getElementsByName('check');
	for(var i=0;i<oCheck.length;i++){
		if(oCheck[i].checked){
			allexaminer.push(oCheck[i].value);
			flag = true;
		}
	}
	if(flag){您确定要删除这些记录吗？请选择！
		if(confirm("Are you sure to delete these record?")){
			location.href="UpdateExaminer?f=delall&Eid="+allexaminer;
		}
	}	
		else{
		alert("Please choose one at least befor delete!");
		
	 }
	}*/

