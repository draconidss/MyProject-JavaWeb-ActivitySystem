<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>RegisterOk</title>
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="css/style.css" rel='stylesheet' type='text/css' />
<script type="text/javascript" src="js/LoginAndRegister.js"></script>
<!--webfonts-->
</head>


<body>

 <!--Register-->
 <a href="Home.jsp"></a><h1><font color="white" size="20" >God's Activity System</font></h2></a>
 <h1><font color="white">Welcome joining</font></h1>
<div class="login-form">
  <div class="close"> </div>
    <div class="head-info">
      <label class="lbl-1"> </label>
      <label class="lbl-2"> </label>
      <label class="lbl-3"> </label>
    </div>
      
  <div class="avtar">
    <img src="images/avtar.png" />
  </div>
      <form name="form" action="Register">
        <input type="text"  value="请输入10位以内的用户名" name="Uname" id="Uname"  
        onfocus="if (this.value == '请输入10位以内的用户名') {this.value = '';}" onblur="UsernameCheck()">
        
        <input type="text"  value="请输入5到15位由字母和数字组成的密码" name="Password1" id="Password1"  
        onfocus="if (this.value == '请输入5到15位由字母和数字组成的密码') {this.value = '';}" onblur="if (this.value == '') {this.value = '请输入5到15位由字母和数字组成的密码';}" >
        
        <input type="text"  value="请再次输入相同的密码" name="Password2" id="Password2"  
        onfocus="if (this.value == '请再次输入相同的密码') {this.value = '';}" onblur="if (this.value == '') {this.value = '请再次输入相同的密码';}" >
         <input type="hidden" value="3" name="sSuper">
       

        <input type="submit" value= "Register Now" onclick="return Registercheck();">	
      </form>
      <a href="Login.jsp"><input type="submit" value= "I had account,Login Now" ></a>

</div>

</body>
</html>