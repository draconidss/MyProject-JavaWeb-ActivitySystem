package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.*;
import Dto.ActivityDto;
import Dto.ConDto;
import Dto.ExaminerDto;
import Dto.UserDto;

public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("GBK");
		PrintWriter out = resp.getWriter();/*输出提示框*/
		//1.获取客户端提交的参数
		HttpSession s =req.getSession();
		UserDao u = new UserDao();
		String Uname = null;
		String Password = null;
		String x =req.getParameter("x");/*判断是从Login还是从RegistetOk登录来决定获取参数的方式*/

		if(x.equals("Login")){
			Uname = new String(req.getParameter("Uname").getBytes("ISO-8859-1"));
	        Password = req.getParameter("Password");
		}
		else if(x.equals("Register")){
			Uname = (String) s.getAttribute("Uname");
			Password = (String) s.getAttribute("Password"); 
		}

			
		System.out.println("Uname:"+Uname);
		System.out.println("Password:"+Password);
		
		
		//2.处理参数，调用业务逻辑
		
		int sSuper = u.UserLogin(Uname, Password);
		System.out.println("sSuper:"+sSuper);
		s.setAttribute("sSuper", sSuper);
		s.setAttribute("Uname", Uname);
		
		if(sSuper == 1||sSuper == 2||sSuper == 3)
			out.print("<script>confirm('Login success!');window.location.href='admin/Home.jsp'</script>");
		else
			out.print("<script>confirm('Username is  unexeist or password is wrong!');window.location.href='Login.jsp'</script>");
		//3.根据返回的结果处理
		
/*		查询所有表
		查找所有活动表
		ActivityDao a = new ActivityDao();
		Vector<ActivityDto> v1 = a.FindAllActivity();
		s.setAttribute("AllActivity", v1);
		
		查找所有活动审核情况表
		ConDao c = new ConDao();
		Vector<ConDto> v2 = c.FindAllCondition();
		s.setAttribute("AllCondition", v2);
		
		
		
		查找所有审核人
		ExaminerDao e = new ExaminerDao();
		Vector<ExaminerDto> v4 = e.FindAllExaminer();
		s.setAttribute("AllExaminer", v4);
*/
		
		/*if(sSuper !=0){
			if(sSuper == 1)管理员{
				查找所有用户,管理员才有资格看到所有用户
				Vector<UserDto> v3 = u.AllUser();	
				s.setAttribute("AllUser", v3);
				out.print("<script>confirm('Login success! Welcome, administrator .');window.location.href='admin/AllTable1.jsp'</script>");
			}	
			else if(sSuper == 2)审核人
				out.print("<script>confirm('Login success! Welcome, examiner .');window.location.href='admin/AllTable2.jsp'</script>");
			else if(sSuper == 3)普通用户
				out.print("<script>confirm('Login success! Welcome, user .');window.location.href='admin/AllTable3.jsp'</script>");
		}
		else
			out.print("<script>confirm('Register fail, Please login again!');window.location.href='Login.jsp'</script>");
	}*/
}
}
