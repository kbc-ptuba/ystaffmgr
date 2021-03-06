package classes;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class Login2 extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException{

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>ログインページ</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>ログイン</h1>");
        HttpSession session = request.getSession(true);

        /* 認証失敗から呼び出されたのかどうか */
        Object status = session.getAttribute("status");

        if (status != null){
            out.println("<p>認証に失敗しました</p>");
            out.println("<p>再度ユーザー名とパスワードを入力して下さい</p>");

            session.setAttribute("status", null);
        }
        
        /*ServletContext context = this.getServletContext();		//
        out.println("ContetPatsh=" + context.getContextPath());		//
        out.println("ServletPath=" + request.getServletPath());	*/
    
        out.println("<form method=\"POST\" action=\"/auth/LoginCheck\" name=\"loginform\">");
        out.println("<table>");
        out.println("<tr>");
        out.println("<td>ユーザー名</td>");
        out.println("<td><input type=\"text\" name=\"user\" size=\"32\"></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>パスワード</td>");
        out.println("<td><input type=\"password\" name=\"pass\" size=\"32\"></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td><input type=\"submit\" value=\"login\"></td>");
        out.println("<td><input type=\"reset\" value=\"reset\"></td>");
        out.println("</tr>");
        out.println("</table>");
        out.println("</form>");

        out.println("</body>");
        out.println("</html>");
    }
}