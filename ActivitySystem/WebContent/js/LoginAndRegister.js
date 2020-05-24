function Logincheck(){
	

	if(form.Uname.value == ""||form.Uname.value == "Uname"){
		alert("Username is empty");
		form.Uname.focus();
		return false;
	}
	
	if(form.Password.value == ""||(form.Password.value == "Password")){
		alert("Password is empty");
		form.Password.focus();
		return false;
	}

}





function Registercheck(){
	/*用户名*/

	if(form.Uname.value == ""||form.Uname.value == "请输入10位以内的用户名"){
		alert("Username is empty");
		form.Uname.focus();
		return false;
	}
	
	if(form.Uname.value.length>10){
		alert("Your username is more than 10 bits!");
		form.Uname.focus();
		return false;
	}
	

	
	
	
	
	
	
		
	
	/*密码*/
	if(form.Password1.value == ""||form.Password1.value == "请输入5到15位由字母和数字组成的密码"){
		alert("Password is empty");
		form.Password1.focus();
		return false;
	}
	
	if(form.Password1.value.length>15||form.Password1.value.length<5){
		alert("You password must between 5 to 15 byte!");
		form.Password1.focus();
		return false;
	}
	
	
	
	var regm = /^[a-zA-Z0-9_]+$/;
	if(form.Password1.value !="" && !form.Password1.value.match(regm)){
		alert("Your password's format is wrong,please input the password consist of word and number!");
		form.Password1.focus();
		return false;
	}
	
	
	if(form.Password2.value == ""||form.Password2.value == "请再次输入相同的密码"){
		alert("Please input the same password");
		form.Password2.focus();
		return false;
	}
	
	if(form.Password1.value != form.Password2.value){
		alert("You passwords is different,Please input the same password");
		form.Password2.focus();
		return false;
	}
}


/*ajax判断用户名是否重复*/
function createXmlHttpRequest(){
    var xmlreq = false;
    if (window.XMLHttpRequest){
        xmlreq = new XMLHttpRequest();
    }else
        if (window.ActiveXObject){
    	try{
    	    xmlreq = new ActiveXObject("Msxml2.XMLHTTP");
    	}catch(e1){
    	    try{
    	        xmlreq = new ActiveXObject("Microsoft.XMLHTTP");
    	    }catch(e2){
    	}
         }
    }
    return xmlreq;   	
}

/*失去焦点后,判断是否用户名重复*/
function UsernameCheck(){
    var request = createXmlHttpRequest();
    var Uname = document.all.Uname.value;

    request.open("post","UsernameCheck?Uname="+Uname);

    request.send();
    request.onreadystatechange = function(){
	if(request.readyState==4){
	        var value = request.responseText;
	        if(value=="true"){
	                document.all.Uname.value="This username is exist";
	                
	        }
    	}
    }
}
