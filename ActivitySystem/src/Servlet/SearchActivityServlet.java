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

import org.omg.CORBA.Request;

import Dao.*;
import Dto.ActivityDto;
import Dto.ConDto;
import Dto.ExaminerDto;
import Dto.UserDto;

public class SearchActivityServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("GBK");
		PrintWriter out = resp.getWriter();/*閿熸枻鎷烽敓鏂ゆ嫹閿熺粸鎾呮嫹閿燂拷*/
		//1.閿熸枻鎷峰彇閿熼叺浼欐嫹閿熸枻鎷烽敓缁撲氦閿熶茎璇ф嫹閿熸枻鎷�
		HttpSession s =req.getSession();
		String Anamekeyword = new String(req.getParameter("Anamekeyword").getBytes("ISO-8859-1"));
		System.out.println("关键词为"+Anamekeyword);
		int sSuper = (Integer)s.getAttribute("sSuper");

		//3.閿熸枻鎷烽敓鎹峰嚖鎷烽敓鎴殑鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿燂拷
		
		/*閿熸枻鎷疯閿熸枻鎷烽敓鍙唻鎷�*/
		/*閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鍙椿鍔ㄩ敓鏂ゆ嫹*/
		UserDao udao = new UserDao();
		UserDto udto = new UserDto();
		ExaminerDao edao = new ExaminerDao();
		ExaminerDto edto = new ExaminerDto();
		ConDao cdao = new ConDao();
		ConDto cdto = new ConDto();
		ActivityDao adao = new ActivityDao();
		ActivityDto adto = new ActivityDto();
		
		Vector<ActivityDto> v = adao.FindActivityByAnamekeyword(Anamekeyword);
		Vector<ConDto> v1 = cdao.FindAllCondition();
		Vector<UserDto> v2 = udao.AllUser();
		Vector<ExaminerDto> v3 = edao.FindAllExaminer();
		
		
		int r = adao.GetRowForActivity();/*閿熸枻鎷烽敓鏂ゆ嫹*/
		s.setAttribute("AllActivity", v);
/*		System.out.println("v1="+v1.elementAt(0).getAid());
		System.out.println("v2="+v1.elementAt(1).getAid());*/
		s.setAttribute("AllCondition", v1);
		s.setAttribute("AllUser", v2);
		s.setAttribute("AllExaminer", v3);
		s.setAttribute("r", r);/*行数*/
		
		if(sSuper==1)
			resp.sendRedirect(req.getContextPath()+"/admin/AllTable1.jsp");
		else if(sSuper==2)
			resp.sendRedirect(req.getContextPath()+"/admin/AllTable2.jsp");
		else if(sSuper==3)
			resp.sendRedirect(req.getContextPath()+"/admin/AllTable3.jsp");
	}
}
