package classes;

import java.io.*;
import java.sql.*;
import java.sql.PreparedStatement;

import javax.servlet.*;
import javax.servlet.http.*;

public class Proc extends HttpServlet {
	
	
	// ŽÀ‘•ƒƒ\ƒbƒh
    /**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	 public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
		 PrintWriter out = res.getWriter();
		 
		 // ƒ†[ƒUID‚ÌŽæ“¾0000
        String userid = req.getParameter("userId");	//ˆÙí‚È‚µA‚«‚¿‚ñ‚Æƒpƒ‰ƒƒ^‚ÍŽó‚¯Žæ‚ê‚Ä‚¢‚é
        int ss	= Integer.parseInt(userid);
        
     //DBAccess
        classes.DBAccess db = new classes.DBAccess();
       
        try {
			db.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
   		
        
     // MyDBManager
        //Connection db = DBManager.getConnection();
        
        try{        	    
        	//String sql = "select emp_id,emp_name from user_master where emp_id = ?";
        	//PreparedStatement pstmt = db.prepareStatement(sql);
        	
        	//pstmt.setInt(1,ss);
        	
        	//ResultSet rs = pstmt.executeQuery(sql);

        	ResultSet rs = db.getResultSet("select emp_id,emp_name from user_master");
        	     	
        	//out.println("ID="+ rs.getInt("emp_id"));
        	
        	while(rs.next()) {
        	int id = rs.getInt("emp_id");
        	String name = rs.getString("emp_name");
        	HttpSession session = req.getSession(true);
        	session.setAttribute("id",id);
        	session.setAttribute("name",name);
        	}
        	res.sendRedirect("/local_pro/show.jsp");
        	
        	}catch (SQLException e){
        	    log("SQLException:" + e.getMessage());
        	} catch (Exception e) {
				// TODO 自動生成された catch ブロック
        		log("Exception:" + e.getMessage());
				//e.printStackTrace();
			}
	 }
}
        

