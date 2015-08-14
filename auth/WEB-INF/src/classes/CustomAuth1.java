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
    
    String target = request.getRequestURI();

    HttpSession session = request.getSession(false);

    if (session == null){
      /* �܂��F�؂���Ă��Ȃ� */
      session = request.getSession(true);
      session.setAttribute("target", target);

      response.sendRedirect("/auth/Login");
    }else{
      Object loginCheck = session.getAttribute("login");
      if (loginCheck == null){
        /* �܂��F�؂���Ă��Ȃ� */
        session.setAttribute("target", target);
        response.sendRedirect("/auth/Login");
      }
    }

    out.println("<html>");
    out.println("<head>");
    out.println("<title>���[�U�[�F�؃e�X�g</title>");
    out.println("</head>");
    out.println("<body>");

    out.println("<p>�e�X�g�y�[�W1</p>");
    out.println("<p><a href=\"/auth/CustomAuth2\">�e�X�g�y�[�W2��</a></p>");

    out.println("</body>");
    out.println("</html>");
  }
}