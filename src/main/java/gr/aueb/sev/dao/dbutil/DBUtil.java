package gr.aueb.sev.dao.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Utility class
 * No instances of this class should be available
 */
public class DBUtil {
	
	private static Connection conn;
	private DBUtil() {}
	
	public static Connection getConnection() throws SQLException{
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/teachersdb?serverTimezone=UTC";
			String username = "agg";
			String password = "am3037";
			
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("connection successfull");
			return conn;
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void closeConnection() throws SQLException{
		
		conn.close();
	}
}
