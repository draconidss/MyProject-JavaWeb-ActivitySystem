<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.* ,Dto.UserDto,Dao.UserDao"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../css/style.css" rel='stylesheet' type='text/css' />
<script type="text/javascript" src="../js/LoginAndRegister.js"></script>
<link rel="stylesheet" type="text/css" href="../css/TableStyle.css" />
<script type="text/javascript" src="../js/LoginAndRegister.js"></script>
<style>
h1{
text-align: center;
}
h2{
text-align: center;
color: white;
font-size: 20px;
}
</style>
</head>
<body>
<%

/* 鏄剧ず鐢ㄦ埛鍦ㄨ彍鍗曟爮涓� */
Integer sSuper = (Integer)session.getAttribute("sSuper");
String Uname = (String)session.getAttribute("Uname");
session.setAttribute("sSuper", sSuper);

Vector<UserDto> v = (Vector<UserDto>)session.getAttribute("AllUser"); 
Iterator<UserDto> it = v.iterator();

String Uid = request.getParameter("Uid");

UserDto u = null;
while(it.hasNext()){
u = it.next();
if(u.getUid().equals(Uid)){

	String i = null;
	if(u.getsSuper()==1)
		  i = "Administrator";
	else if(u.getsSuper()==2)
		  i = "Examiner";
	else if(u.getsSuper()==3)  
		  i = "User";
	
	String i1 = null;
	if(sSuper == 1)
		  i1 = "Administrator";
	else if(sSuper == 2)
		  i1 = "Examiner";
	else if(sSuper == 3)  
		  i1 = "User";
%>

 <!-- 鑿滃崟鏍� -->
<ul class="menu" >
    <li style="left: 40px;top:25px;position: absolute; "><a href="Home.jsp" style="color:#89D9D0;">God's Activity System</a></li>
    <li style="right: 150px;top:25px; position: absolute;"><a href="#" style="color:#89D9D0;"><font color="orange"><%=i1%>:</font><%=Uname%></a></li>
    <li style="right: 40px;top:25px; position: absolute;"><a href="LogOut" style="color:#89D9D0;">Loginout</a></li>

</ul>

<div class="login-form" style="width:600px;">
  <div class="close"> </div>
    <div class="head-info">
      <label class="lbl-1"> </label>
      <label class="lbl-2"> </label>
      <label class="lbl-3"> </label>
    </div>
      
  <div class="avtar">
    <img src="../images/avtar.png" />
  </div>
      <form name="form" action="UpdateUser">
      	<input type="hidden" name="Uid" value=<%=Uid %>>
      	
        <h2>Change<font color="orange"><%=u.getUname() %></font>'s information</h2><input type="text" disabled="disabled"  name="Uid" value=<%=u.getUid() %>  >
        
        <h2>Uname:</h2><input type="text" name="Uname" id="Uname" value=<%=u.getUname() %> 
        onfocus="if (this.value == '请输入10位以内的用户名'){this.value = '';}"  
        onblur="if (this.value == ''){this.value = '请输入10位以内的用户名';}" 
        >
        <!-- onblur="UsernameCheck()"  --> 

        
        <input type="hidden" name="OldUname" value=<%=u.getUname() %>><!-- 原来的名字传过去查看是否重复 -->
        
        <h2>Password:</h2><input type="text" name="Password" id="Password1" value=<%=u.getPassword() %>
        onfocus="if (this.value == '请输入5到15位由字母和数字组成的密码'){this.value = '';}"    
        onblur="if (this.value == '') {this.value = '请输入5到15位由字母和数字组成的密码' ;}"  >
        
		<%if(sSuper==1){ %>
		<h2>Super:</h2>
		<select name="NewsSuper">
           	<option value=<%=u.getsSuper() %>><%=i %>
           	<option value="1" >Administrator
           	<option value="2" >Examiner
           	<option value = "3">User
           </select>
    	<%} else{ %>
    	<input type="hidden" value=<%=u.getsSuper() %> name="NewsSuper">
    	<%} %>
    	
    	<%System.out.println("UserUpdate.jsp里面的sSuper="+sSuper); %>
    	
		<input type="hidden" name="OldsSuper" value=<%=u.getsSuper() %>><!-- 把之前的权限用来判定之前是不是审核人 -->
       

        <input class="button small green" type="submit" value= "Change Now" onclick="return Registercheck();">	
      </form>
      

</div>

<%}
}
%>





</body>
</html>