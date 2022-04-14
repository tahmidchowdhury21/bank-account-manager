import java.sql.*;

/*
 * BankAccount class has four basic functionalities:
 * Create User Account & Login
 * Deposit & Withdraw
 */
public class BankAccount {

	DatabaseManager dm;

	private String userID;
	private double amount;
	private String firstName, LastName, loginPhrase;

	private String error_message;

	// Initialized our custom DatabaseManager class
	public BankAccount() {
		this.dm = new DatabaseManager("3307", "bank_db", "root", "");
	}

	// Responsible for creating users
	// Takes 3 parameter: first name, last name and login phrase
	public void createUserAccount(String firstName, String lastName, String loginPhrase) {
		DatabaseManager.executeUpdateQuery(String.format(
				"INSERT INTO `user`(`first_name`, `last_name`, `login_phrase`) " + "VALUES ('%s','%s','%s')", firstName,
				lastName, loginPhrase));
		getUserInfo(loginPhrase);
		DatabaseManager.executeUpdateQuery(
				String.format("INSERT INTO `account`(`user_id`, `balance`) " + "VALUES ('%s','%s')", userID, 0.00));

		setError_message(DatabaseManager.exceptionErrorMessage);
	}

	// Using the loginPhrase get and set the basic user information in the class
	public void getUserInfo(String loginPhrase) {
		boolean success = false;
		ResultSet rs = DatabaseManager.executeQuery("SELECT * FROM user");

		try {
			while (rs.next()) {
				if (rs.getString("login_phrase").equals(loginPhrase)) {
					this.setUserID(rs.getString("ID"));
					this.setFirstName(rs.getString("first_name"));
					this.setLastName(rs.getString("last_name"));
					this.setLoginPhrase(rs.getString("login_phrase"));

					success = true;
					break;
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
			setError_message(DatabaseManager.exceptionErrorMessage);
		}
	}

	// Responsible for getting the amount for the specific user
	public void getamountInfo() {
		boolean success = false;
		ResultSet rs = DatabaseManager.executeQuery("SELECT * FROM `account` WHERE user_id=" + userID);
		try {
			while (rs.next()) {
				if (rs.getInt("user_id") == Integer.parseInt(userID)) {

					this.setAmount(Double.parseDouble(rs.getString("balance")));
					success = true;
					break;

				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
			setError_message(DatabaseManager.exceptionErrorMessage);
		}

		if (success) {
		} else {

			this.setAmount(-1);
		}
	}

	// Responsible for adding the current amount with the deposit amount and add
	// them to the db
	public void deposit(double amount) {
		double current_amount = this.getAmount();
		current_amount += amount;

		this.setAmount(current_amount);

		DatabaseManager.executeUpdateQuery(String.format("UPDATE `account` SET `user_id`='%s',`balance`='%s'", userID,
				Double.toString(current_amount)));
		setError_message(DatabaseManager.exceptionErrorMessage);
	}

	// Responsible for subtracting the current amount with the withdraw amount and
	// add them to the db
	public void withdraw(double amount) {
		double current_amount = this.getAmount();
		if (amount > current_amount) {
			setError_message("Insuffient amount!!");
		} else {
			current_amount -= amount;
			this.setAmount(current_amount);
		}

		DatabaseManager.executeUpdateQuery(String.format("UPDATE `account` SET `user_id`='%s',`balance`='%s'", userID,
				Double.toString(current_amount)));
		setError_message(DatabaseManager.exceptionErrorMessage);
	}

	// Gets userID
	public String getUserID() {
		return userID;
	}

	// Sets userID
	public void setUserID(String userID) {
		this.userID = userID;
	}

	// Gets amount
	public double getAmount() {
		return amount;
	}

	// Sets amount
	public void setAmount(double amount) {
		this.amount = amount;
	}

	// Gets firstName
	public String getFirstName() {
		return firstName;
	}

	// Sets firstName
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	// Gets LastName
	public String getLastName() {
		return LastName;
	}

	// Sets lastName
	public void setLastName(String lastName) {
		LastName = lastName;
	}

	// Gets loginPhrase
	public String getLoginPhrase() {
		return loginPhrase;
	}

	// Sets loginPhrase
	public void setLoginPhrase(String loginPhrase) {
		this.loginPhrase = loginPhrase;
	}

	// Gets errorMessage
	public String getError_message() {
		return error_message;
	}

	// Sets errorMessage
	public void setError_message(String error_message) {
		this.error_message = error_message;
	}

}