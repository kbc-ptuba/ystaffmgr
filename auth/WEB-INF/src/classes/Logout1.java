package classes;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Logout1 extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 5L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException{

        response.setContentType("text/html; charset=Shift_JIS");
        HttpSession session = request.getSession(true);
        session.invalidate();

        response.sendRedirect("/auth/CustomAuth1");
    }
}