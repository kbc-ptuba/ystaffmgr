package classes;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Proc extends HttpServlet {

	private static final long serialVersionUID = 2L;

	 public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		//下準備
		res.setContentType("text/html charset=UTF-8");
		res.setCharacterEncoding("UTF-8");
        String userid = req.getParameter("userId");
        int ss	= Integer.parseInt(userid);

        //DBAccess
        classes.DBAccess db = new classes.DBAccess();

        try {
			db.open();
		} catch (Exception e) {
			e.printStackTrace();
		}

        try{
            //GOODS_MASTER表
            	PreparedStatement pstmt = db.prepareStatement("select GOODS_ID,GOODS,FIELD_ID,STOCK,PRICE,SUPPLIER_ID from GOODS_MASTER where GOODS_ID = ?");
            	pstmt.setInt(1,ss);
            	ResultSet rs = pstmt.executeQuery();

            //FIELD表
            	PreparedStatement pstmt2 = db.prepareStatement("select FIELD from FIELD where FIELD_ID = any(select FIELD_ID from GOODS_MASTER where GOODS_ID = ?)");
            	pstmt2.setInt(1,ss);
            	ResultSet rs2 = pstmt2.executeQuery();

            //VOTE_SALES表
            	PreparedStatement pstmt3 = db.prepareStatement("select SUM(STOCK_NUM) from STOCKING where GOODS_ID = any(select GOODS_ID from GOODS_MASTER where GOODS_ID = ?)");
            	pstmt3.setInt(1,ss);
            	ResultSet rs3 = pstmt3.executeQuery();

            //SUPPLIER表
            	PreparedStatement pstmt4 = db.prepareStatement("select SUPPLIER from SUPPLIER where SUPPLIER_ID = any(select SUPPLIER_ID from GOODS_MASTER where GOODS_MASTER = ?)");
            	pstmt4.setInt(1,ss);
            	ResultSet rs4 = pstmt4.executeQuery();

        //データを取り出りして出力するための準備
        		rs.next();//user_master
        		int id = rs.getInt("emp_id");	//社員ID
        		String name = rs.getString("emp_name");	//名前
        		String ent  = rs.getString("ent");	//入社日
        		String addr  = rs.getString("addr");	//住所
        		String birth  = rs.getString("birth");	//生年月日
        		String gender  = rs.getString("gender");	//性別
        		String mail_pc  = rs.getString("mail_pc");	//メールPC
        		String mail_tel  = rs.getString("mail_tel");	//メール携帯
        		int tel  = rs.getInt("tel");	//電話番号
        		Timestamp renew  = rs.getTimestamp("renew");	//最終更新日時
        		String making  = rs.getString("making");	//作成日

        		req.setAttribute("id",id);
        		req.setAttribute("name",name);
        		req.setAttribute("ent",ent);
        		req.setAttribute("addr",addr);
        		req.setAttribute("birth",birth);
        		req.setAttribute("gender",gender);
        		req.setAttribute("mail_pc",mail_pc);
        		req.setAttribute("mail_tel",mail_tel);
        		req.setAttribute("tel",tel);
        		req.setAttribute("renew",renew);
        		req.setAttribute("making",making);

        		rs2.next();//exec
            	String exec  = rs2.getString("exec");	//役職
            	req.setAttribute("exec",exec);

                rs3.next();//dept1
                String dept1 = rs3.getString("dept1");	//所属部署
            	req.setAttribute("dept1",dept1);

                rs4.next();//dept2
                String dept2 = rs4.getString("dept2");	//所属課
            	req.setAttribute("dept2",dept2);

            	//show.jspへ移動
        		getServletConfig().getServletContext().
    				getRequestDispatcher("/show.jsp" ).
    					forward(req,res);

        	db.close();

        	}catch (SQLException e){
        	    log("SQLException:" + e.getMessage());
        	} catch (Exception e) {
        		log("Exception:" + e.getMessage());
			}finally{
				try {
					db.close();
				} catch (Exception e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}

	 }
}


