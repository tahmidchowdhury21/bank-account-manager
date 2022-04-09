package bank_account_manager;

import java.sql.*;

public class BankAccount {

	public static void main(String[] args) {

		
		DatabaseManager dm = new DatabaseManager("3307", "bank_db", "root", "");
		ResultSet rs = DatabaseManager.executeQuery("SELECT * FROM user");
		try {
			while(rs.next()) {
				System.out.println(rs.getString("first_name") + "  " + rs.getString("last_name"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
			

	}

}
