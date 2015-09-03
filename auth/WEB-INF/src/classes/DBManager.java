package classes;


import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager  {

	public static Connection getConnection() {
		try {
		    Class.forName("oracle.jdbc.driver.OracleDriver");
		    Connection con = DriverManager.getConnection(
		    		"jdbc:oracle:thin:@localhost:1521:myorcl","sakuma","neha");

		    return con;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}	
	
	public static void main(String[] args) throws Exception {
        Connection con = getConnection();
        System.out.println("con=" + con);
        con.close();
    }

}
