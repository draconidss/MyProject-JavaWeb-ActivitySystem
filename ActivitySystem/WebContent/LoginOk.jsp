<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>LoginOk</title>
<link href="css/style.css" rel='stylesheet' type='text/css' />
</head>
<body>
<%String Uname = (String)session.getAttribute("Uname"); 
  int sSuper = (Integer)session.getAttribute("sSuper");
  String i = null;
  if(sSuper == 1)
	  i = "管理员";
  else if(sSuper == 2)
	  i = "审核人";
  else if(sSuper == 3)  
	  i = "普通用户";
%>
<h1>Login success!</h1>
<h1>用户名:<%=Uname %></h1>
<h1>权限:<%=i %></h1>
<br> 

<a href="admin/admin.html"><input type="submit" value="点击进入主页"></a>

</body>
</html>