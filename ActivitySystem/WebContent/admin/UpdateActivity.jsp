<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.* ,Dto.*,Dao.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8" />

	<title>Add activity</title>

	<!-- CSS Files -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet" />
	<link href="assets/css/paper-bootstrap-wizard.css" rel="stylesheet" />

	<!-- CSS Just for demo purpose, don't include it in your project -->
	<link href="assets/css/demo.css" rel="stylesheet" />

	<!-- Fonts and Icons -->

	<link href="assets/css/themify-icons.css" rel="stylesheet">
	
<!-- 	<link rel="stylesheet" type="text/css" href="../css/TableStyle.css" />菜单栏css -->
	
	<script src="laydate/laydate.js"></script> <!-- 时间选择js -->
	
	<style type="text/css">/*菜单栏css*/
	/* 菜单栏样式 */
			   
        .menu {
        	z-index:100;
        	top: 0px;
        	position: fixed;
            width: 100%;
            height: 80px;
/*设置元素水平居中*/
			text-align: center;
			background-color: white;
/*去除内联元素间隙*/

            font-size: 0;
/*去掉ul自带的.格式*/

            list-style: none;
            padding: 0;
           text-decoration: none;
        }

        .menu li{
/*将元素转换为行内块元素*/

            display:inline-block;
            
            font-size:16px;
/*将边框合并*/

		text-decoration: none;
        }
        .menu a{
             color: #89D9D0;
/*去掉a元素的下划线*/

            text-decoration: none;
        }
/*鼠标位于元素位置时改变元素样式*/



        .menu a:hover{
            color:gray;
        }
	
	</style>
	
	
	<script type="text/javascript">
	lay('#version').html('-v'+ laydate.v);
	//时间选择器
	laydate.render({
	  elem: '#test4'
	  ,type: 'datetime'
	});
	//时间选择器
	laydate.render({
	  elem: '#test5'
	  ,type: 'datetime'
	});
	

	</script>
	
	<script type="text/javascript">/*检查是否都填写了*/
	function CheckAllValue(){
		if(form.Aname.value == ""||form.Level.value == ""||form.Place.value ==""||form.test4.value == ""||form.test5.value == ""||form.Money.value ==""||form.Name.value ==""||form.Email.value ==""||form.Inf.value ==""){
			alert("Please input all information ");
			return false;
			
		}
			
	}
	
	
	</script>
	
<style type="text/css">/*时间选择css*/
	 
  .demo-input{padding-left: 10px; height: 38px; min-width: 262px; line-height: 38px; border: 1px solid #e6e6e6;  background-color: #fff;  border-radius: 2px;}
	</style>
		
</head>


<body>
<!-- 菜单栏 -->
<%

String Uname = (String)session.getAttribute("Uname");
Integer sSuper = (Integer)session.getAttribute("sSuper");
String i = null;
if(sSuper == 1)
	  i = "Administrator";
else if(sSuper == 2)
	  i = "Examiner";
else if(sSuper == 3)  
	  i = "User";

Vector<ActivityDto> v = (Vector<ActivityDto>)session.getAttribute("AllActivity"); 
Iterator<ActivityDto> it = v.iterator();
String aid = request.getParameter("Aid");
String con = (String)session.getAttribute("Con");

System.out.println("更新表里面Aid="+aid);
System.out.println("更新表里面Con="+con);
session.setAttribute("Con", con);
session.setAttribute("Aid", aid);

ActivityDto a = null;


while(it.hasNext()){
a = it.next();


if(a.getAid().equals(aid)){
	String[] array = a.getDuration().split("");
	int n = 0;
	for(String b : array){
		 if(b.equals("～"))
			break; 
		n++;
	}
	String DurationS = "2019-06-10 00:00:00";
	String DurationE = a.getDuration().substring(n+1);
	System.out.println(DurationS);
	System.out.println(DurationE);
%>
<ul class="menu" >
    <li style="left: 40px;top:25px;position: absolute; "><a href="Home.jsp" style="color:#89D9D0;">God's Activity System</a></li>
    <li style="right: 150px;top:25px; position: absolute;"><a href="#" style="color:#89D9D0;"><font color="orange"><%=i%>:</font><%=Uname%></a></li>
    <li style="right: 40px;top:25px; position: absolute;"><a href="LogOut" style="color:#89D9D0;">Loginout</a></li>

</ul>

	<div class="image-container set-full-height" style="background-image: url('../images/table2.jpg')">
	    <!--   Creative Tim Branding   -->
	    

		<!--  Made With Paper Kit  -->


	    <!--   Big container   -->
	    <div class="container">
	        <div class="row">
		        <div class="col-sm-8 col-sm-offset-2">

		            <!--      Wizard container        -->
		            <div class="wizard-container">
		                <div class="card wizard-card" data-color="orange" id="wizard"><!-- 换肤 -->
		                    <form name="form" action="UpdateActivity" >
		                <!--        You can switch " data-color="azure" "  with one of the next bright colors: "blue", "green", "orange", "red"           -->
								<input type="hidden" name="Con" value=<%=a.getCon() %> ><!-- 审核情况不能再activity表里面更改 -->
		                    	<div class="wizard-header">
		                        	<h3 class="wizard-title">Change activity's information</h3>
		                        	<p class="category">Aid: <font color="orange"><%=aid %></font>,Condition:<font color="orange"><%=a.getCon() %></font></p>
		                    	</div>

								<div class="wizard-navigation">
									<div class="progress-with-circle">
									     <div class="progress-bar" role="progressbar" aria-valuenow="1" aria-valuemin="1" aria-valuemax="3" style="width: 21%;"></div>
									</div>
									<ul>
			                            <li>
											<a href="#details" data-toggle="tab">
												<div class="icon-circle">
													<i class="ti-list"></i>
												</div>
												Details
											</a>
										</li>
			                            <li>
											<a href="#captain" data-toggle="tab">
												<div class="icon-circle">
													<i class="ti-briefcase"></i>
												</div>
												Principle
											</a>
										</li>
			                            <li>
											<a href="#description" data-toggle="tab">
												<div class="icon-circle">
													<i class="ti-pencil"></i>
												</div>
												Description
											</a>
										</li>
			                        </ul>
								</div>
		                        <div class="tab-content">
		                            <div class="tab-pane" id="details">
		                            	<div class="row">
		                                	<div class="col-sm-12">
		                                    	<h5 class="info-text"> Let's start with the basic details</h5>
		                                	</div>


			                                <div class="col-sm-5 col-sm-offset-1">
			                                    <div class="form-group">
			                                        <label>Activity name</label>
			                                        <input type="text" id="Aname" name="Aname" class="form-control"  value=<%=a.getAname() %>>
			                                    </div>
			                                </div>


			                                <div class="col-sm-5">
			                                    <div class="form-group">
			                                        <label>Level<font color="gray" size="1.5">(Change this will reset examin condition)</font></label>
			                                        <select class="form-control" name="Level" id="Level" >
			                                            <option value=<%=a.getLevel() %> selected=""><%=a.getLevel() %></option>
			                                            <%session.setAttribute("OldLevel",a.getLevel());  %>
			                                            <option value="校级">校级</option>
			                                            <option value="院级">院级</option>
			                                            <option value="部门">部门</option>
			                                        </select>
			                                    </div>
			                                </div>

											


			                                <div class="col-sm-5 col-sm-offset-1">
			                                    <div class="form-group">
			                                        <label>Place</label>
			                                        <input type="text" name="Place" class="form-control" id="Place" value=<%=a.getPlace() %>>
			                                    </div>
			                                </div>
			                                
			                                
			                                <div class="col-sm-5">
		                                    	<div class="form-group">
		                                        	<label>Budget</label>
		                                        	<div class="input-group">
		                                            	<input type="text" id="Money" name="money" class="form-control" placeholder="more than 100m ">
		                                            	<span class="input-group-addon">$</span>
		                                        	</div>
		                                    	</div>
		                                	</div>
											

											<div class="col-sm-5 col-sm-offset-1">
			                                    <div class="form-group">
			                                        <label>StartTime</label>
			                                        <input type="text"  name="DurationS" class="form-control" value=<%=DurationS %> id="test4">
			                                    </div>
			                                </div>
											
											<div class="col-sm-5">
		                                    	<div class="form-group">
		                                        	<label>EndTime</label>
		                                        	
		                                            	<input type="text" name="DurationE" class="form-control" value=<%=DurationE %> id="test5">
				                                    </div>
		                                	</div>
											
		                                	


		                            	</div>
		                        	</div>



		                            <div class="tab-pane" id="captain">
		                                <h5 class="info-text">Principle's information</h5>
		                                <div class="row">
		                                
		                                    
		       									<div class="col-sm-5 col-sm-offset-1">
			                                    <div class="form-group">
			                                        <label>Name</label>
			                                        <input type="text" name="Pname" class="form-control" id="Name" value=<%=a.getPname() %>>
			                                    </div>
			                                </div>
											


			                                <div class="col-sm-5" >
												<div class="form-group">
													<label>Email</label>
													<input name="Email" id="Email" type="email" class="form-control" value=<%=a.getEmail() %>>
												</div>
											</div>

											






		                                    
		                                </div>
		                            </div>
		                            <div class="tab-pane" id="description">
		                                <div class="row">
		                                    <h5 class="info-text"> Tell us about your activity's information. </h5>
		                                    <div class="col-sm-6 col-sm-offset-1">
		                                        <div class="form-group">
		                                            <label>Desk description</label>
		                                            <textarea id="Inf"  class="form-control" name="Inf" value="41511" rows="9" autofocus><%=a.getInf() %></textarea>
		                                        </div>
		                                    </div>
		                                    <div class="col-sm-4">
		                                        <div class="form-group">
		                                            <label>Tip</label>
		                                            <p class="description">"Please specify your activity's information as far as possible,beacuse that will prove the possible of passing."</p>
		                                        </div>
		                                    </div>
		                                </div>
		                            </div>
		                        </div>
		                        <div class="wizard-footer">
		                        	<div class="pull-right">
		                                <input type='button' class='btn btn-next btn-fill btn-primary btn-wd' name='next' value='Next' />
		                                <input type='submit' class='btn btn-finish btn-fill btn-primary btn-wd' name='finish' value='Finish' onclick="return CheckAllValue();" />
		                            </div>

		                            <div class="pull-left">
		                                <input type='button' class='btn btn-previous btn-default btn-wd' name='previous' value='Previous' />
		                            </div>
		                            <div class="clearfix"></div>
		                        </div>
		                    </form>
		                    
		                    
		                    
		                    
		                    
		                </div>
		            </div> <!-- wizard container -->
		        </div>
	        </div> <!-- row -->
	    </div> <!--  big container -->

	    
	</div>
	<%} %>
<%} %>

</body>

	<!--   Core JS Files   -->
	<script src="assets/js/jquery-2.2.4.min.js" type="text/javascript"></script>
	<script src="assets/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="assets/js/jquery.bootstrap.wizard.js" type="text/javascript"></script>

	<!--  Plugin for the Wizard -->
	<script src="assets/js/paper-bootstrap-wizard.js" type="text/javascript"></script>

	<!--  More information about jquery.validate here: http://jqueryvalidation.org/	 -->
	<script src="assets/js/jquery.validate.min.js" type="text/javascript"></script>

</html>

