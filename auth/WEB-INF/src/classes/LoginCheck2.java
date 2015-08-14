package classes;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class LoginCheck2 extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Connection conn = null;

    public void init() throws ServletException{
        String url = "jdbc:oracle:thin:@localhost:1521:myorcl";
        String user = "sakuma";
        String password = "neha";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            conn = DriverManager.getConnection(url, user, password);
        }catch (ClassNotFoundException e){
            log("ClassNotFoundException:" + e.getMessage());
        }catch (SQLException e){
            log("SQLException:" + e.getMessage());
        }catch (Exception e){
            log("Exception:" + e.getMessage());
        }
    }

    public void destory(){
        try{
            if (conn != null){
                conn.close();
            }
        }catch (SQLException e){
            log("SQLException:" + e.getMessage());
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException{

        response.setContentType("text/html; charset=Shift_JIS");
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");

        HttpSession session = request.getSession(true);

        boolean check = authUser(user, pass);
        if (check){
            /* �F�؍ς݂ɃZ�b�g */	//������	�@//�����l
            session.setAttribute("login", "OK");

            /* �{���̃A�N�Z�X��֔�΂� */		//target�����̑����l��Ԃ�
            String target = (String)session.getAttribute("target");
            response.sendRedirect(target);
        }else{
            /* �F�؂Ɏ��s������A���O�C����ʂɖ߂� */
            session.setAttribute("status", "Not Auth");
            response.sendRedirect("/auth/Login");
        }
    }

    protected boolean authUser(String user, String pass){
        /* ��肠�������[�U�[���ƃp�X���[�h�����͂���Ă���ΔF�؂��� */
        if (user == null || user.length() == 0 || pass == null || pass.length() == 0){
            return false;
        }

        try {
        	
            String sql = "SELECT * FROM user_table WHERE users = ? and pass = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            
            pstmt.setString(1,user);
            pstmt.setString(2,pass);
        	
            ResultSet rs = pstmt.executeQuery();
			
        /* �ǂ��ɃG���[�����邩�m���߂悤�Ƃ������	
        String sql = "SELECT * FROM user_table WHERE users = 'itou' and pass = 'itou'";
        	 PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
        */
        	
            
            if (rs.next()){
                return true;
            }else{
                return false;
            }
        }catch (SQLException e){
            log("SQLException:" + e.getMessage());
            return false;
        }
    }
}