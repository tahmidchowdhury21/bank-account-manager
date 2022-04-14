import java.sql.*;

/*
 * DatabaseManager class is a helper class which uses java.sql libraries 
 * and implement basic executeQuery and executeUpdateQuery
 */
public class DatabaseManager {

	static Connection con;
	static Statement stmt;
	static ResultSet rs;

	static String exceptionErrorMessage;

	// Initialize our constructor with port, name of the database, its user and
	// password
	public DatabaseManager(String port, String database_name, String user, String password) {
		exceptionErrorMessage = "";
		try {
			this.con = DriverManager.getConnection("jdbc:mysql://localhost:" + port + "/" + database_name, user,
					password);
			exceptionErrorMessage = "None";
		} catch (SQLException e) {
			exceptionErrorMessage = e.getMessage();
		}
	}

	// Execute simple sql query
	public static ResultSet executeQuery(String sql_query) {
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql_query);
			exceptionErrorMessage = "None";

		} catch (Exception e) {
			exceptionErrorMessage = e.getMessage();
		}
		return rs;

	}

	// Insert, Update or Delete
	public static void executeUpdateQuery(String sql_query) {
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(sql_query);
			exceptionErrorMessage = "None";

		} catch (Exception e) {
			exceptionErrorMessage = e.getMessage();
		}

	}

}
