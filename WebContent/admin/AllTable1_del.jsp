<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@ page import="java.util.* ,Dto.*,Dao.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>Insert title here</title>
<script type="text/javascript" src="../js/AllCheck.js"></script>

<link rel="stylesheet" type="text/css" href="../css/TableStyle.css" />
<link rel="stylesheet" type="text/css" href="../css/Search.css" />
<link rel="stylesheet" type="text/css" href="../css/buttons.css" />
<link type="text/css" rel="stylesheet" href="../css/colorfulTab.min.css"><!-- 闂侇偄顦甸弫鎾剁驳鐎ｎ亜骞ss -->

 <style type="text/css">

#img{
		width: 100%;
        position: fixed;
        z-index: -1;
        top: 0px;
}
body{
text-align: center;
}
 
 </style>
</head>
<body>
	<div id="img">
	<img src="../images/table.jpg" width="100%" height="800px">
	</div>
<!-- 闂佸吋鍎抽崲鑼躲亹閸ヮ剙鐭楅柛灞剧♁濞堬拷 -->
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
session.setAttribute("AllExaminer", v4);
Iterator<ExaminerDto> it4 = v4.iterator();
ExaminerDto e = null;

/* 闁哄嫬澧介妵姘舵偨閵婏箑鐓曢柛锔哄姀瑜板秹宕￠弴鐔哄焿濞戞搫鎷� */
Integer sSuper = (Integer)session.getAttribute("sSuper");
String Uname = (String)session.getAttribute("Uname");
session.setAttribute("Uname", Uname);
session.setAttribute("sSuper", sSuper);

String i = null;
if(sSuper == 1)
	  i = "Administrator";
else if(sSuper == 2)
	  i = "Examiner";
else if(sSuper == 3)  
	  i = "User";

/* 闁告帇鍊栭弻鍥传椤忓啴鍤嬪銈囨暬濞间即寮伴崜褋浠� 
String x1 = null,x2 = null,x3 = null,x4 = null;
if(x == 1)
	x1 = "active";
if(x == 2)
	x2 = "active";
if(x == 3)
	x3 = "active";
if(x == 4)
	x4 = "active"; */

%>

<!-- 闁兼寧绮屽畷鐔煎冀閿燂拷 -->
<ul class="menu" >
    <li style="left: 40px;top:25px;position: absolute; "><a href="Home.jsp" style="color:#89D9D0;">God's Activity System</a></li>
    <li style="right: 150px;top:25px; position: absolute;"><a href="#" style="color:#89D9D0;"><font color="orange"><%=i%>:</font><%=Uname%></a></li>
    <li style="right: 40px;top:25px; position: absolute;"><a href="LogOut" style="color:#89D9D0;">Loginout</a></li>
    
    <li style="left:550px;top:-90px; position: absolute;height: 0px;" ><!-- 閹兼粎绀屽锟� -->
	<form class="form-wrapper" action="SearchActivity" >
	<input type="hidden"   name="x" value=1 >
	<input type="text" id="search"  name="Anamekeyword" placeholder="Search activity by keyword..." >
	<input type="submit" value="Search" id="submit">
	</form>
	<script src="../js/Search.js"></script>
	</li>

	
</ul>


<div style="text-align:center; position:fixed;top:130px;right: 10px;width:140px;height: 300px;background: url('../images/table0.jpg');border-radius:20px;"><!-- 濠⒀呭仜婵偟鎷嬮弶璺ㄧЭ -->
<a href="AllTable?sSuper=<%=sSuper %>&Uname=<%=Uname %>" ><input class="button medium green rounded" id="btn4" type="button" value="Return table" /></a>
<a href="AddActivity.jsp?x=1" ><input class="button medium blue rounded" id="btn4" type="button" value="Insert activity" /></a>
</div>




<!-- 闂侇偄顦甸妴宥夊础閿燂拷 -->
<div class="colorful-tab-wrapper" id="colorful-background-image"  >


	
	<ul class="colorful-tab-menu">
	  <li class="colorful-tab-menu-item active" tab-background="../images/bg1.jpg"><a href="#bg-0">Activity</a></li>
	  <li class="colorful-tab-menu-item " tab-background="../images/table.jpg"><a href="#bg-1">Examine Condition</a></li>
	  <li class="colorful-tab-menu-item " tab-background="../images/table2.jpg"><a href="#bg-2">User</a></li>
	  <li class="colorful-tab-menu-item " tab-background="../images/table3.jpg"><a href="#bg-3">Examiner</a></li>
	</ul>
	
	
	
	
	<div class="colorful-tab-container">  
	<!-- 闂佽法鍠撻悺鏃堝礉閵娾晜鏅搁柡鍌樺�栫�氬綊鏌ㄩ悤鍌涘 -->
	  <div class="colorful-tab-content active" id="bg-0">
	    
	  <!-- 闂佽法鍠愰弸濠氬箯閻戣姤鏅哥紓浣哄剳閹凤拷 -->
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
<tr style="color: black;word-break: break-all; ">
	
	<td><%=a.getAid()%></td>
	<td><%=a.getAname()%></td>
	<td><%=a.getLevel()%></td>
	<td><%=a.getPlace()%></td>
	<td><%=a.getDuration()%></td>
	<td><%=a.getPname()%></td>
	<td><%=a.getEmail()%></td>
	<td><%=a.getCon() %></td>
	<td><%=a.getInf()%></td>
</tr>
<%
	}
%>
			</tbody>
		</table>
	</div>

</div>
	  
	  
	 <!--  闂佽法鍠愰弸濠氬箯閻戣姤鏅搁柡鍌樺�栫�氬綊鏌ㄩ悢鍛婄伄闁归鍏橀弫鎾诲棘閵堝棗顏� -->
	  <div class="colorful-tab-content" id="bg-1"> 
	  <!-- 闂佽法鍠愰弸濠氬箯閻戣姤鏅哥紓浣哄剳閹凤拷 -->
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

                       
						
						
                    </tr>
                </thead>
                <tbody>

<%


while(it2.hasNext()){
	c = it2.next();
%>
<tr style="color: black;">
	
	<td><%=c.getAid()%></td>
	<td><%=c.getAname()%></td>
	<td><%=c.getName()%></td>
	<td><%=c.getLevel()%></td>
	<td><%=c.getCon()%></td>
	<td><%=c.getNreason()%></td>
	

</tr>
<%
	}
%>
			</tbody>
		</table>
	</div>
	  </div>
	  
	  
	  
	  <!-- 闂佽法鍠撻悡顐ｅ濞嗘劕顏堕梺璺ㄥ枑閺嬪骞忛悜鑺ユ櫢闁跨噦鎷� -->
	  <div class="colorful-tab-content" id="bg-2"> 
	  
		<div id="page-wrap" >

            <table style=" margin:auto; width:100%; ">
                <thead>
                    <tr>
                        <th>Uid</th>
                        <th>Uname</th>
                        <th>Password</th>
                        <th>Super</th>
            
						
						
                    </tr>
                </thead>
                <tbody>

<%


while(it3.hasNext()){
	u = it3.next();
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

	
</tr>
<%
	}
%>
			</tbody>
		</table>
	</div>
</div>
	  
	  
	  
	  
	  <!-- 闂佽法鍠愰弸濠氬箯閻戣姤鏅搁柡鍌樺�栫�氬綊宕ラ锟介弫鎾诲棘閵堝棗顏� -->
	  <div class="colorful-tab-content" id="bg-3"> 
	 <div id="page-wrap" >

            <table style=" margin:auto; width:100%; ">
                <thead>
                    <tr>
                        <th>Eid</th>
                        <th>Ename</th>
                        <th>Name</th>
                        <th>Level</th>
                        <th>Phonenumber</th>
                	
                    </tr>
                </thead>
                <tbody>

<%


while(it4.hasNext()){
	e = it4.next();
%>
<tr style="color: black;">
	
	<td><%=e.getEid()%></td>
	<td><%=e.getEname()%></td>
	<td><%=e.getName()%></td>
	<td><%=e.getLevel()%></td>
	<td><%=e.getPhonenumber()%></td>
	
</tr>
<%
	}
%>
			</tbody>
		</table>
	</div>
	
</div>
	  </div>
	 
	</div>
  </div>










 
 
 
 <!-- 闂侇偄顦甸弫鎾剁驳鐎ｎ亜骞s -->
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