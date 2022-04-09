package bank_account_manager;

import java.sql.*;

public class DatabaseManager {
	
	static Connection con;
	static Statement stmt;
	static ResultSet rs;
	
	public DatabaseManager(String port, String database_name, String user, String password) {
		try {
			this.con = DriverManager.getConnection("jdbc:mysql://localhost:"+port+"/"+database_name, user, password);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	public static ResultSet executeQuery(String sql_query) {
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql_query);
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return rs;
		
	}

}
