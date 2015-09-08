package classes;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
            	PreparedStatement pstmt = db.prepareStatement("select GOODS_ID,GOODS,STOCK,PRICE, from GOODS_MASTER where GOODS_ID = ?");
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
            	PreparedStatement pstmt4 = db.prepareStatement("select SUM(STOCK_NUM) from STOCKING where GOODS_ID = any(select GOODS_ID from GOODS_MASTER where GOODS_ID = ?)");
            	pstmt4.setInt(1,ss);
            	ResultSet rs4 = pstmt4.executeQuery();
            	PreparedStatement pstmt5 = db.prepareStatement("select SUM(STOCK_NUM) from STOCKING where GOODS_ID = any(select GOODS_ID from GOODS_MASTER where GOODS_ID = ?)");
            	pstmt5.setInt(1,ss);
            	ResultSet rs5 = pstmt5.executeQuery();
            	PreparedStatement pstmt6 = db.prepareStatement("select SUM(STOCK_NUM) from STOCKING where GOODS_ID = any(select GOODS_ID from GOODS_MASTER where GOODS_ID = ?)");
            	pstmt6.setInt(1,ss);
            	ResultSet rs6 = pstmt6.executeQuery();

            //SUPPLIER表
            	PreparedStatement pstmtX = db.prepareStatement("select SUPPLIER from SUPPLIER where SUPPLIER_ID = any(select SUPPLIER_ID from GOODS_MASTER where GOODS_ID = ?)");
            	pstmtX.setInt(1,ss);
            	ResultSet rsX = pstmtX.executeQuery();

        //データを取り出りして出力するための準備
        		rs.next();//user_master
        		int GOODS_ID = rs.getInt("GOODS_ID");	//商品ID
        		String GOODS = rs.getString("GOODS");	//商品名
        		int STOCK  = rs.getInt("STOCK");	//在庫数
        		int PRICE  = rs.getInt("PRICE");	//販売単価


        		req.setAttribute("GOODS_ID",GOODS_ID);
        		req.setAttribute("GOODS",GOODS);
        		req.setAttribute("STOCK",STOCK);
        		req.setAttribute("PRICE",PRICE);

        		rs2.next();//exec
            	String FIELD  = rs2.getString("FIELD");	//商品分野
            	req.setAttribute("FIELD",FIELD);

                rs3.next();//dept1
                String STOCK_NUM = rs3.getString("STOCK_NUM");	//所属部署
            	req.setAttribute("STOCK_NUM",STOCK_NUM);

                rsX.next();//dept2
                String dept2 = rsX.getString("dept2");	//所属課
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


