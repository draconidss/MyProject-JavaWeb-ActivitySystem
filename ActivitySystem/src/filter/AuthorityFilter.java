package filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AuthorityFilter1
 */
public class AuthorityFilter implements Filter {


	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException, ServletException {
				
				
				HttpServletRequest req = (HttpServletRequest) arg0;
				HttpServletResponse resp = (HttpServletResponse) arg1;
				HttpSession s =req.getSession();
				Integer flag = (Integer) s.getAttribute("sSuper");
				System.out.println("flag="+flag);
				if(flag != null){
					if(flag == 1||flag == 2||flag == 3){
						arg2.doFilter(arg0, arg1);
					}else{
						resp.sendRedirect(req.getContextPath()+"/Authority.html");
					}
				}else{
					/*out.print("<script>confirm('Please login fistly.');window.location.href='../Login.jsp'</script>");*/
					resp.sendRedirect(req.getContextPath()+"/Login.jsp");
				}


	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
