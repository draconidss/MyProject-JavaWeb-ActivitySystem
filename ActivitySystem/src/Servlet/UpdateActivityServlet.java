package Servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.ActivityDao;
import Dao.ConDao;
import Dao.UserDao;
import Dto.ActivityDto;
import Dto.ConDto;
import Dto.UserDto;

/**
 * Servlet implementation class UpdateUserServlet
 */
public class UpdateActivityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String f = request.getParameter("f");
		System.out.println("f="+f);
		boolean flag = false;
		ActivityDao adao = new ActivityDao();
		ActivityDto adto = new ActivityDto();
		ConDao cdao = new ConDao();
		ConDto cdto = new ConDto();
		HttpSession s = request.getSession();
		
		if(f == null){
			//更新用户
			//1
			String Aid = (String)s.getAttribute("Aid");
			String Con = request.getParameter("Con");
			System.out.println("Aid="+Aid);
			
			byte source0 [] = Con.getBytes("iso8859-1");
	        Con= new String (source0,"UTF-8");
	        System.out.println("Con="+Con);
			String Aname = request.getParameter("Aname");
			String Level = request.getParameter("Level");
			String OldLevel = (String)s.getAttribute("OldLevel");

			System.out.println("OldLevel="+OldLevel);
			String Place= request.getParameter("Place");
			String DurationS = request.getParameter("DurationS");
			String DurationE = request.getParameter("DurationE");
			String Duration = DurationS+"～"+DurationE;/*时间范围*/
			String Pname = request.getParameter("Pname");
			String Email = request.getParameter("Email");
			String Inf = request.getParameter("Inf");
			byte source [] = Aname.getBytes("iso8859-1");
	        Aname = new String (source,"UTF-8");
	        byte source1 [] = Level.getBytes("iso8859-1");
	        Level = new String (source1,"UTF-8");
	        byte source2 [] = Place.getBytes("iso8859-1");
	        Place = new String (source2,"UTF-8");
	        byte source3 [] = Pname.getBytes("iso8859-1");
	        Pname = new String (source3,"UTF-8");
	        byte source5 [] = Inf.getBytes("iso8859-1");
	        Inf = new String (source5,"UTF-8");
	        
			System.out.println("Level="+Level);
	        if(Level.equals(OldLevel)==false){/*如果级别更改，重置活动审核表*/
	        	cdto.setAid(Aid);
				cdto.setName("");
				cdto.setLevel(Level);
				cdto.setCon("待审核");
				cdto.setNreason("");
				
	        	cdao.UpdateConByaid(cdto);
	        	Con="待审核";
	        }
	        
			//2
	        adto.setAll(Aid, Aname, Level, Place, Duration, Pname, Email, Inf,Con,"1");
			flag = adao.UpdateActivityByaid(adto);
			System.out.println("flag="+flag);
			if(flag)
				System.out.println("更新成功！");
			/*else{
				System.out.println("您想更改的用户名已存在！");
				response.sendRedirect(request.getContextPath()+"/admin/AllTable1.jsp");
			}*/
		
	}
		
		else{
			//删除用户，将deletemark从1改为0
			//1
			if(f.equals("delall")){//批量删除
				System.out.println("准备开始批量删除");
				String[] allactivity = request.getParameterValues("Aid");
				String[] temp = allactivity[0].split(",");
				for(String a : temp){
					adto.setAid(a);
					System.out.println("Eid="+a);
					flag = adao.DeleteActivityByaid(adto);
				}
			}
		}
			
			
			
			//3
			
			
		Vector<ActivityDto> v = adao.FindAllActivity();
		s.setAttribute("AllActivity", v);
		

		Vector<ConDto> v1 = cdao.FindAllCondition();
		s.setAttribute("AllCondition", v1);

		if(flag)
			response.sendRedirect(request.getContextPath()+"/admin/AllTable1.jsp");
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
