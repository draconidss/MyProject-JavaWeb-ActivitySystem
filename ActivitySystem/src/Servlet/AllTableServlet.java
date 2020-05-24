package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.lang.model.element.Element;
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

public class AllTableServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("GBK");
		PrintWriter out = resp.getWriter();/*输出提示框*/
		//1.获取客户端提交的参数
		HttpSession s =req.getSession();
		String sSuper1 = req.getParameter("sSuper");
		Integer sSuper = Integer.valueOf(sSuper1);
		System.out.println("进入查找所有表！");
		System.out.println("xxxxxxxxxxxxx！");
		System.out.println("sSuper:"+sSuper);
		
		String Uname = new String(req.getParameter("Uname").getBytes("ISO-8859-1"));
		System.out.println("AllTableServlet里面接收到的Uname="+Uname);
		/*传参数给表界面以便菜单显示名称*/
		s.setAttribute("sSuper", sSuper);
		s.setAttribute("Uname", Uname);
		//3.根据返回的结果处理
		
		/*查询所有表*/
		/*查找所有活动表*/
		ActivityDao a = new ActivityDao();
		Vector<ActivityDto> v1 = a.FindAllActivity();
		s.setAttribute("AllActivity", v1);
		s.setAttribute("Pass", "已通过");

		/*查找所有活动审核情况表*/
		ConDao c = new ConDao();
		Vector<ConDto> v2 = c.FindAllCondition();
		s.setAttribute("AllCondition", v2);
		
		/*查找所有用户,管理员才有资格看到所有用户*/
		UserDao u = new UserDao();
		Vector<UserDto> v3 = u.AllUser();	
		s.setAttribute("AllUser", v3);
		
		/*查找所有审核人*/
		ExaminerDao e = new ExaminerDao();
		Vector<ExaminerDto> v4 = e.FindAllExaminer();
		s.setAttribute("AllExaminer", v4);

		s.setAttribute("c1", "已通过");/*防止乱码显示显示审核状态*/
		s.setAttribute("c2", "未通过");
		s.setAttribute("c3", "审核中");
		s.setAttribute("c4", "待审核");
		
		if(sSuper !=0){
			if(sSuper == 1)/*管理员*/
				resp.sendRedirect(req.getContextPath()+"/admin/AllTable1.jsp");	
			else if(sSuper == 2)/*审核人*/
				resp.sendRedirect(req.getContextPath()+"/admin/AllTable2.jsp");
			else if(sSuper == 3)/*普通用户*/
				resp.sendRedirect(req.getContextPath()+"/admin/AllTable3.jsp");
		}
		else
			out.print("<script>confirm('Register fail, Please login again!');window.location.href='../Login.jsp'</script>");
	}
}
