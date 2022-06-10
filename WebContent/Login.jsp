<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html>
<html>  
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>Login</title>
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="css/style.css" rel='stylesheet' type='text/css' />
<script type="text/javascript" src="js/LoginAndRegister.js"></script>
<!--webfonts-->


</head>


<body>

 <!--SIGN UP-->
 <a href="Home.jsp"><h1><font color="white" size="20" >God's Activity System</font></h2></a>
 <h1><font color="orange">Welcome back</font></h1>
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
      <form name="form" action="Login">
        <input type="text" class="text" value=God name="Uname" id="Uname"  
        onfocus="if (this.value == 'Uname') {this.value = '';}" onblur="if (this.value == '') {this.value = 'Uname';}" >
        
            <div class="key">
          <input type="password"  value="a1138312802" name="Password" id="Password" 
          onfocus="if (this.value == 'Password'){this.value = '';}"  onblur="if (this.value == '') {this.value = 'Password';}">
            </div>
            
           <input type="hidden" name="x" value="Login"><!-- 判断是从Login.html入口登陆 -->
              
    	<input type="submit" value= "Login" onclick="return Logincheck();">
      </form>
		 <a href="Register.jsp"><input type="submit" value= "Register Now" ></a>
</div>


</body>
</html>