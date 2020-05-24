<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="java.util.* ,Dto.*,Dao.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8" />

	<title>Add activity</title>

	<!-- CSS Files -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet" />
	<link href="assets/css/paper-bootstrap-wizard.css" rel="stylesheet" />

	<!-- CSS Just for demo purpose, don't include it in your project -->
	<link href="assets/css/demo.css" rel="stylesheet" />

	<!-- Fonts and Icons -->

	<link href="assets/css/themify-icons.css" rel="stylesheet">
	
<!-- 	<link rel="stylesheet" type="text/css" href="../css/TableStyle.css" />锟剿碉拷锟斤拷css -->
	
	<script src="laydate/laydate.js"></script> <!-- 时锟斤拷选锟斤拷js -->
	
	<style type="text/css">/*锟剿碉拷锟斤拷css*/
	/* 锟剿碉拷锟斤拷锟斤拷式 */
			   
        .menu {
        	z-index:100;
        	top: 0px;
        	position: fixed;
            width: 100%;
            height: 80px;
/*锟斤拷锟斤拷元锟斤拷水平锟斤拷锟斤拷*/
			text-align: center;
			background-color: white;
/*去锟斤拷锟斤拷锟斤拷元锟截硷拷隙*/

            font-size: 0;
/*去锟斤拷ul锟皆达拷锟斤拷.锟斤拷式*/

            list-style: none;
            padding: 0;
           text-decoration: none;
        }

        .menu li{
/*锟斤拷元锟斤拷转锟斤拷为锟斤拷锟节匡拷元锟斤拷*/

            display:inline-block;
            
            font-size:16px;
/*锟斤拷锟竭匡拷喜锟�*/

		text-decoration: none;
        }
        .menu a{
             color: #89D9D0;
/*去锟斤拷a元锟截碉拷锟铰伙拷锟斤拷*/

            text-decoration: none;
        }
/*锟斤拷锟轿伙拷锟皆拷锟轿伙拷锟绞憋拷谋锟皆拷锟斤拷锟绞�*/



        .menu a:hover{
            color:gray;
        }
	
	</style>
	
	<script type="text/javascript">
	lay('#version').html('-v'+ laydate.v);
	//时锟斤拷选锟斤拷锟斤拷
	laydate.render({
	  elem: '#test4'
	  ,type: 'datetime'
	});
	//时锟斤拷选锟斤拷锟斤拷
	laydate.render({
	  elem: '#test5'
	  ,type: 'datetime'
	});
	

	</script>
	
	<script type="text/javascript">/*锟斤拷锟斤拷欠锟斤拷锟叫达拷锟�*/
	function CheckAllValue(){
		if(form.Ename.value == ""||form.Con.value == ""){
			alert("Please input all information except the reason of activity doesn't passed!");
			return false;
			
		}
			
	}
	
	
	</script>
	
<style type="text/css">/*时锟斤拷选锟斤拷css*/
	 
  .demo-input{padding-left: 10px; height: 38px; min-width: 262px; line-height: 38px; border: 1px solid #e6e6e6;  background-color: #fff;  border-radius: 2px;}
	</style>
		
</head>


<body>
<!-- 锟剿碉拷锟斤拷 -->
<%
Vector<ConDto> v2 = (Vector<ConDto>)session.getAttribute("AllCondition"); 
Iterator<ConDto> it2 = v2.iterator();
ConDto c = null;

Vector<ExaminerDto> v4 = (Vector<ExaminerDto>)session.getAttribute("AllExaminer");
Iterator<ExaminerDto> it4 = v4.iterator();
ExaminerDto e = null;

String Uname = (String)session.getAttribute("Uname");
Integer sSuper = (Integer)session.getAttribute("sSuper");


String Ename = new String(request.getParameter("Ename").getBytes("ISO-8859-1"));




String aid = request.getParameter("Aid");
String i = null;
if(sSuper == 1)
	  i = "Administrator";
else if(sSuper == 2)
	  i = "Examiner";
else if(sSuper == 3)  
	  i = "User";



while(it2.hasNext()){
c = it2.next();
if(c.getAid().equals(aid)){
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
		                <div class="card wizard-card" data-color="green" id="wizard">
		                    <form name="form" action="UpdateCon" >
		                <!--        You can switch " data-color="azure" "  with one of the next bright colors: "blue", "green", "orange", "red"           -->
								<input type="hidden" name="Aid" value=<%=c.getAid() %> ><!-- 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷activity锟斤拷锟斤拷锟斤拷锟斤拷锟� -->

								<input type="hidden" name="Level" value=<%=c.getLevel() %> ><!-- 把级别传过去 --> 
		                    	<div class="wizard-header">
		                        	<h3 class="wizard-title">Change condition of examining</h3>
		                        	<p class="category">Condition:<font color="orange"><%=c.getCon() %></font></p>
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

										<%if(sSuper==1){ %><!-- 鍙湁绠＄悊鍛樿兘鍒嗛厤瀹℃牳浜� -->
			                           	<div class="col-sm-12">
			                                    <div class="form-group">
			                                        <label>Suitable examiner</label>
			                                        <select class="form-control" name="Ename" id="Ename" >
			                                        	<option value=<%=Ename %>><%=Ename %></option>
			                                            <%while(it4.hasNext()){
			                                            	e = it4.next();
			                                            	if(e.getLevel().equals(c.getLevel())&&e.getEname().equals(Ename)==false){
			                                            	%> 
			                                            <option value=<%=e.getEname() %>><%=e.getEname() %></option>
			                                            <%}} %>
			                                        </select>
			                                    </div>
			                                </div>
			                                <%}else if(sSuper==2){ %>
<%-- 			                                <%/* 乱码处理 */
			                                byte source [] = Ename.getBytes("iso8859-1");
			                    	        Ename = new String (source,"UTF-8");
			                    	        %> --%>
			                                <input type="hidden" name="Ename" id="Ename" value=<%=Ename %>>
			                                
			                                <%}System.out.println("更新审核状态中的Ename="+Ename); %>


			                                <div class="col-sm-12">
			                                    <div class="form-group">
			                                        <label>Condition</label>
			                                        <select class="form-control" name="Con" id="Con" >
			                                        <%if(c.getCon().equals("待审核")==false) {%>
			                                        	<option value=<%=c.getCon() %> selected="selected"><%=c.getCon() %></option>
			                                        <%}else{} %>
			                                            <option value="审核中">审核中</option>
			                                            <option value="已通过">已通过</option>
			                                            <option value="未通过">未通过</option>
			                                        </select>
			                                    </div>
			                                </div>

					
		                                	


		                            	</div>
		                        	</div>



		                            <div class="tab-pane" id="description">
		                                <div class="row">
		                                    <h5 class="info-text"> The reason of why this activity doesn't passed. </h5>
		                                    <div class="col-sm-6 col-sm-offset-1">
		                                        <div class="form-group">
		                                            <label>Desk description</label>
		                                            <textarea id="Nreason"  class="form-control" name="Nreason" placeholder="try input with details" rows="9" autofocus></textarea>
		                                        </div>
		                                    </div>
		                                    <div class="col-sm-4">
		                                        <div class="form-group">
		                                            <label>Tip</label>
		                                            <p class="description">"If this activity is in accordance,you can submit in straight."</p>
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

