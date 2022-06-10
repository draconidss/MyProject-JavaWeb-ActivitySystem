<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<font size=4>
<p>请输入x的值：<br>
<form action="Example2.jsp" method=get name=from>
	<input type="text" name="xvalue">
	<input type="submit" value="calculate" name=submit>
</form>
<%! public class Square{
	int x;
	public int calculateSquare(int x){
		int y;
		y=x*x;
		return y;
	}
}
%>
<%String str = request.getParameter("xvalue");
	int x,y;
	if(str != null)
		x=Integer.valueOf(str).intValue();
	else
		x = 0;
	Square s = new Square();
	y = s.calculateSquare(x);
	System.out.println("x的平方值为："+y);
%>
<p><%=x%>平方值为：<%=y %>
</font>
</body>
</html>