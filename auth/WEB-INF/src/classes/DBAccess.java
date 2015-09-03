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
 
    /**
     * �R���X�g���N�^
     * @param driver �h���C�o�[
     * @param url URL
     * @param user ���[�U�[��
     * @param password �p�X���[�h
     */
    public DBAccess(String driver, String url, String user, String password) {
        this.driver = driver;
        this.url = url;
        this.user = user;
        this.password = password;
    }
 
    /**
     * �����Ȃ��̃R���X�g���N�^
     * ����l���g�p����
     */
    public DBAccess() {
        driver = "oracle.jdbc.driver.OracleDriver";
        url = "jdbc:oracle:thin:@localhost:1521:myorcl";
        user = "sakuma";
        password = "neha";
    }
 
    /**
     * �f�[�^�x�[�X�ւ̐ڑ����s��
     */
    public void open() throws Exception {
        Class.forName(driver);
        connection = DriverManager.getConnection(url, user, password);
        statement = connection.createStatement();
    }
 
    /**
     * SQL �������s�������ʂ� ResultSet ��Ԃ�
     * @param sql SQL ��
     */
    public ResultSet getResultSet(String sql) throws Exception {
         statement.executeQuery(sql) ; 
            return statement.getResultSet();
        
        
    }
 
    /**
     * SQL ���̎��s
     * @param sql SQL ��
     */
    public void executeQuery(String sql) throws Exception {
        statement.execute(sql);
    }
 
    /**
     * �f�[�^�x�[�X�ւ̃R�l�N�V�����̃N���[�Y
     */
    public void close() throws Exception {
        if ( resultset != null ) resultset.close();
        if ( statement != null ) statement.close();
        if ( connection != null ) connection.close();
    }
    
    public  PreparedStatement prepareStatement(String str) throws SQLException{
			PreparedStatement rs = this.connection.prepareStatement(str);
			return rs;
    
    }
}




