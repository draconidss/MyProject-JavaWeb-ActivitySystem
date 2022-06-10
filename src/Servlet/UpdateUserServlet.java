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
public class UpdateUserServlet extends HttpServlet {


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();/*输出提示框*/
		request.setCharacterEncoding("GB2312");
		String f = request.getParameter("f");
		System.out.println("faa="+f);
		boolean flag = false;
		UserDao udao = new UserDao();
		UserDto udto = new UserDto();
		ExaminerDao edao = new ExaminerDao();
		ExaminerDto edto = new ExaminerDto();
		ConDao cdao = new ConDao();
		ConDto cdto = new ConDto();
		ActivityDao adao = new ActivityDao();
		ActivityDto adto = new ActivityDto();
		HttpSession s = request.getSession();	
		
		int sSuper = (Integer)s.getAttribute("sSuper");/*判断用户身份*/
		

		if(f == null){
			//閿熸枻鎷烽敓鏂ゆ嫹閿熺煫浼欐嫹
			//1
			
			String Uid = request.getParameter("Uid");
			
			String OldUname =request.getParameter("OldUname");
			byte source [] = OldUname.getBytes("iso8859-1");
			OldUname = new String (source,"UTF-8");
			
			String Uname = request.getParameter("Uname");
			byte source1 [] = Uname.getBytes("iso8859-1");
	        Uname = new String (source1,"UTF-8");
	        
			String Password = request.getParameter("Password");
			String NewsSuper = request.getParameter("NewsSuper");
			String OldsSuper =request.getParameter("OldsSuper");/*获取之前的权限*/
			
			System.out.println("Uname="+Uname);
			System.out.println("OldUname="+OldUname);
			System.out.println("sSuper="+sSuper);
			System.out.println("OldsSuper="+OldsSuper);
			System.out.println("NewsSuper"+NewsSuper);
			
			
			
			
			if(udao.FindByUname(Uname) == false||OldUname.equals(Uname)){/*判定名字是否重复*/
			udto.setUid(Uid);
			udto.setUname(Uname);
			udto.setPassword(Password);
			udto.setsSuper(Integer.valueOf(NewsSuper));
			
			if(NewsSuper.equals("2") &&OldsSuper.equals("2")){/*权限没变，其他更改*/
				edao.UpdateExaminerEnameByEname(Uname, OldUname);
			}
			
			if(NewsSuper.equals("2") &&OldsSuper.equals("2")==false){/*如果原来不是审核人改为审核人就要在审核人表添加审核人*/
				int Eu = edao.GetRowForExaminer();/*获取记录数，准备自动编号*/
				String Eid = null;
				if (Eu < 9)// 根据活动数量自动设置活动编号
					Eid = "e0" + (Eu + 1);
				else
					Eid = "e" +  (Eu + 1);
				edto.setAll(Eid, Uname, "", "部门", "", "1");
				edao.InsertExaminer(edto);/*insert examiner*/
			}
			
			if(NewsSuper.equals("2")==false&&OldsSuper.equals("2")){/*如果之前是审核人改为其他身份时要删除对应的审核人表*/
				
				edao.UpdateExaminerEnameByEname(Uname, OldUname);/*再删除之前把审核情况表的审核人名字改变*/
				edto.setEname(Uname);
				edao.DeleteExaminerByename(edto);
				System.out.println("审核人删除成功");
			}
				
			
			//2
			flag = udao.UpdateUser(udto);
			if(sSuper==2||sSuper==3){/*如果不是管理员修改自己的用户信息，就更改关于Uname的session*/
				s.setAttribute("Uname", Uname);
				}
			}
			
		}

		
		else{
			//鍒犻敓鏂ゆ嫹閿熺煫浼欐嫹閿熸枻鎷烽敓鏂ゆ嫹deletemark閿熸枻鎷�1閿熸枻鎷蜂负0
			//1
			
			if(f.equals("delall")){//閿熸枻鎷烽敓鏂ゆ嫹鍒犻敓鏂ゆ嫹
				System.out.println("User表删除");
				String[] alluser = request.getParameterValues("Uname");
				String[] temp = alluser[0].split(",");
				int i = 0;
				for(String a : temp){
					a = new String(a.getBytes("ISO-8859-1"),"GBK");
					if(edao.FindExaminerByename(a) == true){
						edto.setEname(a);
						edao.DeleteExaminerByename(edto);
						}
					udto.setUname(a);
					System.out.println("Uname="+a);
					flag = udao.DeleteUserByUname(udto);
					i ++;
				}
			}
			
			
			
			}
		Vector<UserDto> v = udao.AllUser();
		Vector<ExaminerDto> v1 = edao.FindAllExaminer();
		Vector<ConDto> v2 = cdao.FindAllCondition();
		Vector<ActivityDto> v3 = adao.FindAllActivity();
		
		
		s.setAttribute("AllUser", v);
		s.setAttribute("AllExaminer", v1);
		s.setAttribute("AllCondition", v2);
		s.setAttribute("AllActivity", v3);
		System.out.println("在删除后返回到时的sSuper="+sSuper);

		
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
