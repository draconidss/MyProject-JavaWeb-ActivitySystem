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
import Dto.UserDto;

/**
 * Servlet implementation class UpdateUserServlet
 */
public class UpdateConServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();/*输出提示框*/
		request.setCharacterEncoding("GBK");
		String f = request.getParameter("f");
		System.out.println("f="+f);
		boolean flag = false;
		ConDao cdao = new ConDao();
		ConDto cdto = new ConDto();
		HttpSession session = request.getSession(); 
		int sSuper = (Integer)session.getAttribute("sSuper");
		
		if(f == null){
			//�����û�
			//1
			
			String Aid = request.getParameter("Aid");
			/*String Ename = request.getParameter("Ename");
			String Level = request.getParameter("Level");*/
			String Ename = request.getParameter("Ename");
			String Con = request.getParameter("Con");
			String Nreason= request.getParameter("Nreason");
			String Level = request.getParameter("Level");
			

			byte source [] = Ename.getBytes("iso8859-1");
	        Ename = new String (source,"UTF-8");
	        byte source1 [] = Con.getBytes("iso8859-1");
	        Con = new String (source1,"UTF-8");
	        byte source2 [] = Nreason.getBytes("iso8859-1");
	        Nreason = new String (source2,"UTF-8");
	        byte source3 [] = Level.getBytes("iso8859-1");
	        Level = new String (source3,"UTF-8");
	        
/*	        byte source3 [] = Ename.getBytes("iso8859-1");
	        Ename = new String (source3,"UTF-8");
	        byte source4 [] = Level.getBytes("iso8859-1");
	        Level = new String (source4,"UTF-8");*/

			System.out.println("Ename="+Ename);
			System.out.println("Nreason="+Nreason);
			System.out.println("Con="+Con);
			
			
/*			
			String Con1 = null;乱码转换
			if(Con == "1")
				Con1="审核中";
			else if(Con == "2")
				Con1="已通过";
			else if(Con == "3")	
				Con1="未通过";*/
			
			cdto.setAid(Aid);
			cdto.setName(Ename);
			cdto.setLevel(Level);
			cdto.setCon(Con);
			cdto.setNreason(Nreason);
			
			
			//2
			flag = cdao.UpdateConByaid(cdto);
			System.out.println("flag="+flag);
			if(flag)
				System.out.println("Update success!");
			/*else{
				System.out.println("������ĵ��û����Ѵ��ڣ�");
				response.sendRedirect(request.getContextPath()+"/admin/AllTable1.jsp");
			}*/
		
	}
		
		/*else{
			//ɾ���û�����deletemark��1��Ϊ0
			//1
			if(f.equals("delall")){//����ɾ��
				System.out.println("׼����ʼ����ɾ��");
				String[] allexaminer = request.getParameterValues("Eid");
				String[] temp = allexaminer[0].split(",");
				for(String a : temp){
					edto.setEid(a);
					System.out.println("Eid="+a);
					flag = edao.DeleteConByeid(edto);
				}
			}*/
			
			
			
			//3
			
		Vector<ConDto> v = cdao.FindAllCondition();
		HttpSession s = request.getSession();
		s.setAttribute("AllCondition", v);
		
		ActivityDao adao = new ActivityDao();
		ActivityDto adto = new ActivityDto();
		Vector<ActivityDto> v1 = adao.FindAllActivity();
		s.setAttribute("AllActivity", v1);

		if(flag){
			if(sSuper==1){
				out.print("<script>confirm('Change success!');window.location.href='AllTable1.jsp'</script>");
			}
			else if(sSuper==2)
				out.print("<script>confirm('Change success!');window.location.href='AllTable2.jsp'</script>");
		}
			
		else
			response.sendRedirect(request.getContextPath()+"/Error.html");
		}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
