<%@ page language="java" contentType="text/html; charset=Utf-8"
    pageEncoding="Utf-8"%>
<%@ page import="java.util.* ,Dto.*,Dao.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<title>Insert title here</title>
<link href="../css/style.css" rel='stylesheet' type='text/css' />
<script type="text/javascript" src="../js/LoginAndRegister.js"></script>
<link rel="stylesheet" type="text/css" href="../css/TableStyle.css" />
<style>
h1{
text-align: center;
color: orange;
font-size: 30px;
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

/* 閺勫墽銇氶悽銊﹀煕閸︺劏褰嶉崡鏇熺埉娑擄拷 */
Integer sSuper = (Integer)session.getAttribute("sSuper");
String Uname = (String)session.getAttribute("Uname");
System.out.println("Uname="+Uname);

String i = null;
if(sSuper == 1)
	  i = "Administrator";
else if(sSuper == 2)
	  i = "Examiner";
else if(sSuper == 3)  
	  i = "User";


Vector<ExaminerDto> v = (Vector<ExaminerDto>)session.getAttribute("AllExaminer"); 
Iterator<ExaminerDto> it = v.iterator();
String eid = request.getParameter("Eid");
System.out.println("Eid="+eid);

ExaminerDto e = null;
String name = null;
String Pnumber = null;

while(it.hasNext()){
e = it.next();


/* System.out.println("Phone="+e.getPhonenumber());
if(e.getName()=="鏃�"){
	System.out.println("Ename="+e.getName());
	name = "11";
}
else
	name = e.getName();

if(e.getPhonenumber()=="")
	Pnumber = "11";
else
	Pnumber = e.getPhonenumber(); */

if(e.getEid().equals(eid)){

%>

 <!-- 閼挎粌宕熼弽锟� -->
<ul class="menu" >
    <li style="left: 40px;top:25px;position: absolute; "><a href="Home.jsp" style="color:#89D9D0;">God's Activity System</a></li>
    <li style="right: 150px;top:25px; position: absolute;"><a href="#" style="color:#89D9D0;"><font color="orange"><%=i%>:</font><%=Uname%></a></li>
    <li style="right: 40px;top:25px; position: absolute;"><a href="LogOut" style="color:#89D9D0;">Loginout</a></li>

</ul>
<div class="login-form" style="width:800px;">
  <div class="close"> </div>
    <div class="head-info">
      <label class="lbl-1"> </label>
      <label class="lbl-2"> </label>
      <label class="lbl-3"> </label>
    </div>
      
  <div class="avtar">
    <img src="../images/avtar.png" />
  </div>
      <form name="form" action="UpdateExaminer">
        <h1>Change examiner <font color="yellow"><%=e.getEname() %></font>'s information</h1>
        
        <h1>Eid:<font color="yellow"><%=e.getEid() %></font>Level:<font color="yellow"><%=e.getLevel() %></font></h1>
        <input type="hidden"   name="Eid" value=<%=e.getEid() %>  >
        
         <h2>Real name</h2><input type="text" name="Name" id="Name" value=<%=e.getName() %>>
<!--         onfocus="if (this.value == 'Please input your real name'){this.value = '';}"    
        onblur="if (this.value == '') {this.value = 'Please input your real name' ;}"   -->
        
        <h2>Phonenumber:</h2><input type="text" name="Pnumber" id="Pnumber" value=<%=e.getPhonenumber() %>>
<!--         onfocus="if (this.value == 'Please input new Phonenumber'){this.value = '';}"    
        onblur="if (this.value == '') {this.value = 'Please input new Phonenumber' ;}"  > -->
        
        
        <%if(sSuper==1){ %>
        <h2>Level:</h2>
        <select name="Level">
			<option value=<%=e.getLevel() %> selected="selected"><%=e.getLevel() %>
           	<option value="部门">部门
           	<option value="院级" >院级
           	<option value="校级" >校级
		</select>
           <%}else if(sSuper==2){%>
           <input type="hidden" name="Level" value=<%=e.getLevel() %>>
           <%} %>
        
        <input class="button small blue" type="submit" value= "Change Now" >	
      </form>
      

</div>

<%}
}

%>





</body>
</html>