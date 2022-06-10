<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@ page import="java.util.* ,Dto.*,Dao.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset=GBK>
<title>Insert title here</title>
<script type="text/javascript" src="../js/AllCheck.js"></script>

<link rel="stylesheet" type="text/css" href="../css/buttons.css" />
<link rel="stylesheet" type="text/css" href="../css/Search.css" />
<link rel="stylesheet" type="text/css" href="../css/TableStyle.css" />
<link type="text/css" rel="stylesheet" href="../css/colorfulTab.min.css"><!-- 閫夐敓绛嬪崱css -->
<style type="text/css">
#img{
		width: 100%;
        position: fixed;
        z-index: -1;
        top: 0px;
}

</style>
</head>
<body >
	<div id="img">
	<img src="../images/table.jpg" width="100%" height="800px">
	</div>
<!-- 閿熸枻鎷峰彇閿熸枻鎷烽敓鏂ゆ嫹 -->
<%
Vector<ActivityDto> v1 = (Vector<ActivityDto>)session.getAttribute("AllActivity"); 
Iterator<ActivityDto> it1 = v1.iterator();
ActivityDto a = null;

Vector<ConDto> v2 = (Vector<ConDto>)session.getAttribute("AllCondition"); 
Iterator<ConDto> it2 = v2.iterator();
ConDto c = null;

Vector<UserDto> v3 = (Vector<UserDto>)session.getAttribute("AllUser"); 
Iterator<UserDto> it3 = v3.iterator();
UserDto u = null;

Vector<ExaminerDto> v4 = (Vector<ExaminerDto>)session.getAttribute("AllExaminer"); 
Iterator<ExaminerDto> it4 = v4.iterator();
ExaminerDto e = null;

/* 鏄剧ず鐢ㄦ埛鍦ㄨ彍鍗曟爮涓� */
Integer sSuper = (Integer)session.getAttribute("sSuper");
String Uname = (String)session.getAttribute("Uname");
System.out.println("Uname="+Uname);

String c1 = (String)session.getAttribute("c1");/* 防止乱码，判断审核状况用那种按钮 */
String c2 = (String)session.getAttribute("c2");
String c3 = (String)session.getAttribute("c3");
String c4 = (String)session.getAttribute("c4");

int sum=0;/* 显示审核人所负责的有多少审核状况为审核中的审核记录 */
Iterator<ConDto> it2sum = v2.iterator();
while(it2sum.hasNext()){
	c = it2sum.next();
	if(Uname.equals(c.getName())&&c.getCon().equals(c3)){
		sum++;
	}
}

String i = null;
if(sSuper == 1)
	  i = "Administrator";
else if(sSuper == 2)
	  i = "Examiner";
else if(sSuper == 3)  
	  i = "User";
%>

<!-- 鑿滃崟鏍� -->
<ul class="menu" >
    <li style="left: 40px;top:25px;position: absolute; "><a href="Home.jsp" style="color:#89D9D0;">God's Activity System</a></li>
    <li style="left: 235px;top:15px;position: absolute; "><a class="button big orange"><font color="white" size="4">You have <%=sum %> activities to handle</font></a></li>
    <li style="right: 150px;top:25px; position: absolute;"><a href="#" style="color:#89D9D0;"><font color="orange"><%=i%>:</font><%=Uname%></a></li>
    <li style="right: 40px;top:25px; position: absolute;"><a href="LogOut" style="color:#89D9D0;">Loginout</a></li>
    
    <li style="left:550px;top:-90px; position: absolute;height: 0px;" ><!-- 鎼滅礌妗� -->
	<form class="form-wrapper" action="SearchActivity" >
	<input type="hidden"   name="x" value=1 >
	<input type="text" id="search"  name="Anamekeyword" placeholder="Search activity by keyword..." >
	<input type="submit" value="Search" id="submit">
	</form>
	<script src="../js/Search.js"></script>
	</li>

	
</ul>

<!-- 閫夐敓绛嬪崱 -->
<div class="colorful-tab-wrapper" id="colorful-background-image" >
	<ul class="colorful-tab-menu">
	  <li class="colorful-tab-menu-item active" tab-background="../images/bg1.jpg"><a href="#bg-0">Activity</a></li>
	  <li class="colorful-tab-menu-item " tab-background="../images/table.jpg"><a href="#bg-1">Examine Condition</a></li>
	  <li class="colorful-tab-menu-item " tab-background="../images/table3.jpg"><a href="#bg-2">Examiner</a></li>
	  	  <li class="colorful-tab-menu-item " tab-background="../images/table2.jpg"><a href="#bg-3">Personal details</a></li>
	</ul>
	
<div style="text-align:center; position:fixed;top:130px;right: 10px;width:140px;height: 300px;background: url('../images/table0.jpg');border-radius:20px;"><!-- 婢х偛濮炵拋鏉跨秿 -->
<a href="AllTable?sSuper=<%=sSuper %>&Uname=<%=Uname %>" ><input class="button medium green rounded" id="btn4" type="button" value="Refresh table" /></a>
<a href="AddActivity.jsp?x=2" ><input class="button medium blue rounded" id="btn4" type="button" value="Insert activity" /></a>
</div>	

	
	<div class="colorful-tab-container">  
	<!-- 閿熺瓔鍔ㄩ敓鏂ゆ嫹閿燂拷 -->
	  <div class="colorful-tab-content active" id="bg-0">
	    
	  <!-- 閿熸枻鎷烽敓缁烇拷 -->
		<div id="page-wrap" >
            <table style=" margin:auto; width:100%; ">
                <thead>
                    <tr>
                       <th>Aid</th>
                        <th>Aname</th>
                        <th>level</th>
                        <th>Place</th>
                        <th>Duration</th>
                        <th>Principle</th>
                        <th>Email</th>
                        <th>Condition</th>
                        <th>Information</th>
                    </tr>
                </thead>
                <tbody>

<%


while(it1.hasNext()){
	a = it1.next();
%>
<tr style="color: black;">
	
	<td><%=a.getAid()%></td>
	<td><%=a.getAname()%></td>
	<td><%=a.getLevel()%></td>
	<td><%=a.getPlace()%></td>
	<td><%=a.getDuration()%></td>
	<td><%=a.getPname()%></td>
	<td><%=a.getEmail()%></td>
	
	<%if(a.getCon().equals(c1)){%>
	<td ><a class="button small green" ><%= a.getCon()%></a></td>
	<%}else if(a.getCon().equals(c2)){%>
	<td ><a class="button small gray" ><%= a.getCon()%></a></td>
	<%}else if(a.getCon().equals(c3)){%>
	<td ><a class="button small blue" ><%= a.getCon()%></a></td>
	<%}else if(a.getCon().equals(c4)){%>
	<td ><a class="button small orange" ><%= a.getCon()%></a></td>
	<%} %>
	
	<td><%=a.getInf()%></td>
	
</tr>
<%
	}
%>
			</tbody>
		</table>
	</div>

</div>
	  
	  
	 <!--  閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹 -->
	  <div class="colorful-tab-content" id="bg-1"> 
	  <!-- 閿熸枻鎷烽敓缁烇拷 -->
		<div id="page-wrap" >
            <table style=" margin:auto; width:100%; ">
                <thead>
                    <tr>
                        <th>Aid</th>
                        <th>Aname</th>
                        <th>Examiner</th>
                        <th>level</th>
                        <th>Condition</th>
                        <th>Unpass Reason</th>
                        <th>Execute</th>

                    </tr>
                </thead>
                <tbody>

<%


while(it2.hasNext()){
	c = it2.next();
	if(Uname.equals(c.getName())){
%>
<tr style="color: black;">
	
	<td><%=c.getAid()%></td>
	<td><%=c.getAname()%></td>
	<td><%=c.getName()%></td>
	<td><%=c.getLevel()%></td>
	
	<%if(c.getCon().equals(c1)){%>
	<td ><a class="button small green" ><%= c.getCon()%></a></td>
	<%}else if(c.getCon().equals(c2)){%>
	<td ><a class="button small gray" ><%= c.getCon()%></a></td>
	<%}else if(c.getCon().equals(c3)){%>
	<td ><a class="button small blue" ><%= c.getCon()%></a></td>
	<%}else if(c.getCon().equals(c4)){%>
	<td ><a class="button small orange" ><%= c.getCon()%></a></td>
	<%} %>
	
	<td><%=c.getNreason()%></td>
	<td>
		<a href="UpdateCon.jsp?Aid=<%=c.getAid()%>&Con=<%=c.getCon()%>&Ename=<%=c.getName()%>" class="button small blue">Change</a>
		

	</td>

</tr>
<%
}
	}
%>

<%

Iterator<ConDto> it2_2 = v2.iterator();
while(it2_2.hasNext()){
	c = it2_2.next();
	if(Uname.equals(c.getName()) == false){
%>
<tr style="color: black;">
	
	<td><%=c.getAid()%></td>
	<td><%=c.getAname()%></td>
	<td><%=c.getName()%></td>
	<td><%=c.getLevel()%></td>
	
	<%if(c.getCon().equals(c1)){%>
	<td ><a class="button small green" ><%= c.getCon()%></a></td>
	<%}else if(c.getCon().equals(c2)){%>
	<td ><a class="button small gray" ><%= c.getCon()%></a></td>
	<%}else if(c.getCon().equals(c3)){%>
	<td ><a class="button small blue" ><%= c.getCon()%></a></td>
	<%}else if(c.getCon().equals(c4)){%>
	<td ><a class="button small orange" ><%= c.getCon()%></a></td>
	<%} %>
	
	<td><%=c.getNreason()%></td>
	<td>

		

	</td>

</tr>
<%
}
	}
%>
			</tbody>
		</table>
	</div>
</div>
	  
	 

	 
	  
	  
	 
	  
	  
	  <!-- 閿熸枻鎷烽敓鏂ゆ嫹鍚敓鏂ゆ嫹 --><!-- 閿熸枻鎷烽敓鏂ゆ嫹鐬敓鏂ゆ嫹鑺ㄩ敓鏂ゆ嫹绾﹂敓鏂ゆ嫹鍕熼敓鏂ゆ嫹绌戭儛閿熸枻鎷烽敓鏂ゆ嫹鎰块敓鏂ゆ嫹绾﹂敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熻緝锟� -->
	  <div class="colorful-tab-content" id="bg-2"> 
	 <div id="page-wrap" >

            <table style=" margin:auto; width:100%; ">
                <thead>
                    <tr>
                        <th>Eid</th>
                        <th>Ename</th>
                        <th>Name</th>
                        <th>Level</th>
                        <th>Phonenumber</th>
                        <th>Execute</th>
                        	
                    </tr>
                </thead>
                <tbody>

<%


while(it4.hasNext()){
	e = it4.next();
	if(Uname.equals(e.getEname())){
%>
<tr style="color: black;">
	
	<td><%=e.getEid()%></td>
	<td><%=e.getEname()%></td>
	<td><%=e.getName()%></td>
	<td><%=e.getLevel()%></td>
	<td><%=e.getPhonenumber()%></td>
	<td>
		<a href="UpdateExaminer.jsp?Eid=<%=e.getEid()%>" class="button small blue">Change</a>

	</td>
</tr>
<%
	}
}
%>



<%
Iterator<ExaminerDto> it4_2 = v4.iterator();
while(it4_2.hasNext()){
	e = it4_2.next();
	if(Uname.equals(e.getEname()) ==false){
%>
<tr style="color: black;">
	
	<td><%=e.getEid()%></td>
	<td><%=e.getEname()%></td>
	<td><%=e.getName()%></td>
	<td><%=e.getLevel()%></td>
	<td><%=e.getPhonenumber()%></td>
	<td>
		

	</td>
</tr>
<%
	}
}
%>

			</tbody>
		</table>
	</div>
	
</div>

 <!-- 闂佽法鍠撻悡顐ｅ濞嗘劕顏堕梺璺ㄥ枑閺嬪骞忛悜鑺ユ櫢闁跨噦鎷� -->
	  <div class="colorful-tab-content" id="bg-3"> 
	  
		<div id="page-wrap" >

            <table style=" margin:auto; width:100%; ">
                <thead>
                    <tr>
                        <th>Uid</th>
                        <th>Uname</th>
                        <th>Password</th>
                        <th>Super</th>
                        <th>Change</th>
						
                    </tr>
                </thead>
                <tbody>

<%


while(it3.hasNext()){
	u = it3.next();
	if(u.getUname().equals(Uname)){
%>
<tr style="color: black;">
	
	<td><%=u.getUid()%></td>
	<td><%=u.getUname()%></td>
	<td><%=u.getPassword()%></td>
	<td>
	<%if(u.getsSuper() == 1){ %>
		Administrator
		<%} %>
	<%if(u.getsSuper() == 2) {%>
		Examiner
		<%} %>
	<%if(u.getsSuper() == 3) {%>
		User
		<%} %>
	</td>
	<td>
		
		<a href="UpdateUser.jsp?Uid=<%=u.getUid()%>&sSuper=<%=i%>&Uname=<%=Uname%>" class="button small blue">Change</a>
		
	</td>
	

	
</tr>
<%
	}
}
%>
			</tbody>
		</table>
	</div>
</div>	 
	 





	</div>
	 
	</div>











 
 
 
 <!-- 閫夐敓绛嬪崱js -->
<script type="text/javascript" src="../js/jquery-1.11.0.min.js" ></script>
<script type="text/javascript" src="../js/colorfulTab.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
	$("#colorful").colorfulTab();    
	
	$("#colorful-elliptic").colorfulTab({
		theme: "elliptic"
	}); 
   
   $("#colorful-flatline").colorfulTab({
		theme: "flatline"
	});    
	
	$("#colorful-background-image").colorfulTab({
		theme: "flatline",
		backgroundImage: "true",
		overlayColor: "#002F68",
		overlayOpacity: "0.8"
	});   

});
</script>
 
</body>
</html>