import java.sql.*;

/*
 * DatabaseManager class is a helper class which uses java.sql libraries 
 * and implement basic executeQuery and executeUpdateQuery
 */
public class DatabaseManager {

	static Connection con;
	static Statement stmt;
	static ResultSet rs;

	// Initialize our constructor with port, name of the database, its user and password
	public DatabaseManager(String port, String database_name, String user, String password) {
		try {
			this.con = DriverManager.getConnection("jdbc:mysql://localhost:" + port + "/" + database_name, user,
					password);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	// Execute simple sql query
	public static ResultSet executeQuery(String sql_query) {
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql_query);

		} catch (Exception e) {
			System.out.println(e);
		}
		return rs;

	}

	// Insert, Update or Delete
	public static void executeUpdateQuery(String sql_query) {
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(sql_query);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
