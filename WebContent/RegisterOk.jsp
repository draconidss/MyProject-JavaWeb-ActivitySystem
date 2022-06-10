<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
   <%@ page import="java.util.* ,Dto.UserDto,Dao.UserDao"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>Insert title here</title>
<style type="text/css">
h1{
text-align:center;
}

</style>
</head>
<body>
<%UserDto udto = (UserDto)session.getAttribute("Register");  %>
<%
String i = null;
if(udto.getsSuper()== 1)
	i = "管理员";
else
	i = "普通用户";
%>
<br>
<h1>恭喜您，注册成功</h1>
<form  action="Login">
<table cellspacing="0" background=black bordercolor=gray height=40 cellPadding=1 width=50% border=1 align=center >
<tr align=center>
	<td>Uid</td>
	<td>Uname</td>
	<td>Password</td>
	<td>Super</td>
	<td>Login Now</td>
	
</tr>

<tr align=center>
	<td><%=udto.getUid()%></td>
	<td><%=udto.getUname()%></td>
	<td><%=udto.getPassword()%></td>
	<input type="hidden" name="x" value="Register"><!-- 判断是从Register.jsp入口登陆 -->
	<%session.setAttribute("Uname", udto.getUname());%>
	<%session.setAttribute("Password", udto.getPassword());%>
	
	<td><%=i%></td>
	<td><input type="submit" value="Login Now" /></td>
</tr>
</table> 
</form>

</body>
</html>