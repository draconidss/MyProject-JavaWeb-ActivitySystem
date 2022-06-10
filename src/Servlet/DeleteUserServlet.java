/*package Servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.UserDao;
import Dto.UserDto;

*//**
 * Servlet implementation class DeleteUserServlet
 *//*
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    *//**
     * @see HttpServlet#HttpServlet()
     *//*
    public DeleteUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	*//**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 *//*
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1
		String Uid = req.getParameter("Uid");
		UserDto udto = new UserDto();
		udto.setUid(Uid);
		
		//2
		UserDao udao = new UserDao();
		boolean flag = udao.DeleteUserByaid(udto);
		Vector<UserDto> v = udao.AllUser();
		HttpSession s = req.getSession();
		s.setAttribute("AllUser", v);
		
		//3
		if(flag)
			resp.sendRedirect(req.getContextPath()+"/admin/DeleteUserServlet.jsp");
		else
			resp.sendRedirect(req.getContextPath()+"/Error.html");
	}

	*//**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 *//*
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
*/