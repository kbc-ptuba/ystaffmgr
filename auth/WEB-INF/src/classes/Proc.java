package classes;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class Proc extends HttpServlet {
	
	private static final long serialVersionUID = 2L;

	 public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
		 res.setContentType("text/html charset=UTF-8");
		 PrintWriter out = res.getWriter();
		 String na = "前田";

        String userid = req.getParameter("userId");	//受け渡しは絶対にできている
        int ss	= Integer.parseInt(userid);
        
     //DBAccess
        classes.DBAccess db = new classes.DBAccess();
       
        try {
			db.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
        
     // MyDBManager
       // Connection db = DBManager.getConnection();
        
       try{        	    
        	String sql = "select emp_id,emp_name from user_master where emp_id = ?";
        	PreparedStatement pstmt = db.prepareStatement(sql);
        	
        	pstmt.setInt(1,ss);
        	
        	//ResultSet rs = pstmt.executeQuery(sql);

        	ResultSet rs = db.getResultSet("select emp_id,emp_name from user_master");
        	
        	while(rs.next()) {
        	int id = rs.getInt("emp_id");
        	String name = rs.getString("emp_name");
        	
        	HttpSession session = req.getSession(true);
        	session.setAttribute("id",id);
        	session.setAttribute("name",name);
        	res.sendRedirect("/local_pro/show.jsp");
       	
            //SQL文が発行出来ているのかチェック用
            //out.println("emp_id = " + id);
            //out.println("名前は = " + name);
            System.out.print(name);
        	}
        	}catch (SQLException e){
        	    log("SQLException:" + e.getMessage());
        	} catch (Exception e) {
        		log("Exception:" + e.getMessage());
				//e.printStackTrace();
			}
			
        //itiran.jspからのデータの受け渡しができているかのチェック用
        //out.println("userID = " + userid);
	 }
}
        

