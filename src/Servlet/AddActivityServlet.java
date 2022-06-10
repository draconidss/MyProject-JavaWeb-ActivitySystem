package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sound.midi.MidiDevice.Info;

import Dao.*;
import Dto.*;

/**
 * Servlet implementation class AddActivityServlet
 */
public class AddActivityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddActivityServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("GBK");
		PrintWriter out = response.getWriter();/*�����ʾ��*/
		HttpSession s = request.getSession(); 
		
		String x =request.getParameter("x");
		System.out.println("x="+x);
		
		String Aname = request.getParameter("Aname");
		String Level = request.getParameter("Level");
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
		
		System.out.println("更新的Aname="+Aname);
		
		ActivityDao adao = new ActivityDao();
		ActivityDto adto = new ActivityDto();
		
		int arow = adao.GetRowForActivity();
		System.out.println("总记录有："+arow);
		String Aid = null;/*�Զ����*/
		if (arow < 9)// ���ݻ�����Զ����û���
			Aid = "a0" + (arow + 1);
		else
			Aid = "a" +  (arow + 1);
		System.out.println("自动编号为"+Aid);
		adto.setAll(Aid, Aname, Level, Place, Duration, Pname, Email, Inf,"待审核","1");
		boolean flag = adao.InsertActivity(adto);
		
		
		Vector<ActivityDto> v = adao.FindAllActivity();
		ConDto cdto = new ConDto();
		ConDao cdao = new ConDao();
		Vector<ConDto> v1 = cdao.FindAllCondition();
		s.setAttribute("AllActivity", v);
		s.setAttribute("AllCondition", v1);

		if(flag){
			if(x.equals("2"))
				out.print("<script>confirm('Add activity success!');window.location.href='AllTable2.jsp'</script>");
			else if(x.equals("3"))
				out.print("<script>confirm('Add activity success!');window.location.href='AllTable3.jsp'</script>");
			else
				out.print("<script>confirm('Add activity success!');window.location.href='AllTable1.jsp'</script>");
		}
		else
			out.print("<script>confirm('Add activity fail!');window.location.href='AllTable1.jsp'</script>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
