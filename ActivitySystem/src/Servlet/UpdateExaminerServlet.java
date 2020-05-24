package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.ActivityDao;
import Dao.ConDao;
import Dao.ExaminerDao;
import Dao.UserDao;
import Dto.ActivityDto;
import Dto.ConDto;
import Dto.ExaminerDto;
import Dto.UserDto;

/**
 * Servlet implementation class UpdateUserServlet
 */
public class UpdateExaminerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateExaminerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();/*输出提示框*/
		request.setCharacterEncoding("GB2312");
		String f = request.getParameter("f");
		System.out.println("UpdateExaminer里面的f="+f);
		boolean flag = false;
		ExaminerDao edao = new ExaminerDao();
		ExaminerDto edto = new ExaminerDto();
		ConDao cdao = new ConDao();
		ConDto cdto = new ConDto();
		ActivityDao adao = new ActivityDao();
		ActivityDto adto = new ActivityDto();
		
		HttpSession s = request.getSession();	
		int sSuper = (Integer)s.getAttribute("sSuper");/*判断用户身份*/
		
		if(f == null){
			//
			//1
			HttpSession session = request.getSession(); 
			String Eid = request.getParameter("Eid");
			
			
			String Name = request.getParameter("Name");
			byte source [] = Name.getBytes("iso8859-1");
	        Name = new String (source,"UTF-8");
			
			String Level = request.getParameter("Level");
			byte source1 [] = Level.getBytes("iso8859-1");
	        Level = new String (source1,"UTF-8");
	        
			String Pnumber = request.getParameter("Pnumber");
			
			System.out.println("..");
			System.out.println("Eid="+Eid);
			System.out.println("Name="+Name);
			System.out.println("Level="+Level);
			System.out.println("Pnumber="+Pnumber);
			
			edto.setName(Name);
			edto.setEid(Eid);
			edto.setLevel(Level);
			edto.setPhonenumber(Pnumber);
			
			
			//2
			flag = edao.UpdateExaminerByeid(edto);
			System.out.println("flag="+flag);
			if(flag)
				System.out.println("..");
			/*else{
				System.out.println("..");
				response.sendRedirect(request.getContextPath()+"/admin/AllTable1.jsp");
			}*/
		
	}
		
/*		else{
			//..
			//1
			if(f.equals("delall")){//..
				System.out.println("Examiner table delete");
				String[] alluser = request.getParameterValues("Uname");
				String[] temp = alluser[0].split(",");
				for(String a : temp){
					a = new String(a.getBytes("ISO-8859-1"),"GBK");
					if(edao.FindExaminerByename(a)==true){
						edto.setEname(a);
						System.out.println("Ename="+a);
						flag = edao.DeleteExaminerByename(edto);
					}
					
				}
			}
			
			
			
			//3
			
			}*/
		Vector<ExaminerDto> v = edao.FindAllExaminer();
		Vector<ConDto> v1 = cdao.FindAllCondition();
		Vector<ActivityDto> v2 = adao.FindAllActivity();
		
		s.setAttribute("AllExaminer", v);
		s.setAttribute("AllCondition", v1);
		s.setAttribute("AllActivity", v2);
		if(flag){
			if(sSuper==1)
				out.print("<script>confirm('Execute success!');window.location.href='AllTable1.jsp'</script>");
			else if(sSuper==2)
				out.print("<script>confirm('Execute success!');window.location.href='AllTable2.jsp'</script>");
			else if(sSuper==3)
				out.print("<script>confirm('Execute success!');window.location.href='AllTable3.jsp'</script>");
		}
		else{
			if(sSuper==1)
				out.print("<script>confirm('Execute fail!');window.location.href='AllTable1.jsp'</script>");
			else if(sSuper==2)
				out.print("<script>confirm('Execute fail!');window.location.href='AllTable2.jsp'</script>");
			else if(sSuper==3)
				out.print("<script>confirm('Execute fail!');window.location.href='AllTable3.jsp'</script>");
			}
		}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
