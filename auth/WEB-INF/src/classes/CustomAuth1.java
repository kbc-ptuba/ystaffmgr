package classes;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CustomAuth1 extends HttpServlet {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException{

    response.setContentType("text/html; charset=Shift_JIS");
    PrintWriter out = response.getWriter();
 
    out.println("<html>");
    out.println("<head>");
    out.println("<title>���[�U�[�F�؃e�X�g</title>");
    out.println("</head>");
    out.println("<body>");

    out.println("<p>�e�X�g�y�[�W1</p>");
    out.println("<p><a href=\"/auth/CustomAuth2\">�e�X�g�y�[�W2��</a></p>");
    out.println("<p><a href=\"/auth/Logout\">���O�A�E�g</a></p>");
    
    out.println("</body>");
    out.println("</html>");
  }
}