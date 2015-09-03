package classes;

import java.sql.*;

public class DBAccess {

    private String driver;
    private String url;
    private String user;
    private String password;
    private Connection connection;
    private Statement statement;
    private ResultSet resultset;
 
    public DBAccess(String driver, String url, String user, String password) {
        this.driver = driver;
        this.url = url;
        this.user = user;
        this.password = password;
    }
 

    public DBAccess() {
        driver = "oracle.jdbc.driver.OracleDriver";
        url = "jdbc:oracle:thin:@localhost:1521:myorcl";
        user = "sakuma";
        password = "neha";
    }
 
    public void open() throws Exception {
        Class.forName(driver);
        connection = DriverManager.getConnection(url, user, password);
        statement = connection.createStatement();
    }
 
    public ResultSet getResultSet(String sql) throws Exception {
         statement.executeQuery(sql) ; 
            return statement.getResultSet();
        
        
    }
 
    public void executeQuery(String sql) throws Exception {
        statement.execute(sql);
    }
 
    public void close() throws Exception {
        if ( resultset != null ) resultset.close();
        if ( statement != null ) statement.close();
        if ( connection != null ) connection.close();
    }
    
    public  PreparedStatement prepareStatement(String str) throws SQLException{
			PreparedStatement rs = connection.prepareStatement(str);
			return rs;
    
    }
}




