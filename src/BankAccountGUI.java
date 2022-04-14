import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/*
 * This class is taking BankAccount class and giving a life to a GUI Application
 */
public class BankAccountGUI {

	static BankAccount bankAccount;
	static String userName;
	static String accountBalance;

	public static void main(String[] args) {

		bankAccount = new BankAccount();
		userName = "User";
		accountBalance = "0.00";

		displayWindow();

	}

	/*
	 * Creates the top level of the window with size, layout and by actually calling
	 * UIFrame method
	 */
	private static void displayWindow() {
		JFrame frame = new JFrame("Bank Management Application");
		frame.setLayout(new FlowLayout(FlowLayout.CENTER));
		frame.setResizable(false);

		JPanelWithBackground panel = new JPanelWithBackground("src/images/background.jpg");
		panel.setLayout(new FlowLayout()); // or whatever layout you want
		frame.setContentPane(panel);

		createUI(frame);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	// Responsible for creating the whole layout and placing all the elements on the panel
	// Also, calls actionsListeners method to listen for any activities
	private static void createUI(final JFrame frame) {
		JPanel top_panel = new JPanel();
		LayoutManager top_layout = new GridLayout(0, 2, 4, 4);
		top_panel.setLayout(top_layout);

		JPanel bottom_panel = new JPanel();
		LayoutManager bottom_layout = new GridLayout(0, 1, 4, 4);
		bottom_panel.setLayout(bottom_layout);

		top_panel.setOpaque(false);
		bottom_panel.setOpaque(false);

		JLabel title_label = new JLabel("Welcome To The Neighbour Bank!!", JLabel.CENTER);
		title_label.setFont(new Font("Calibri", Font.BOLD, 24));
		title_label.setForeground(Color.white);

		title_label.setOpaque(false);
		title_label.setBorder(new EmptyBorder(20, 0, 20, 0));

		title_label.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		frame.add(title_label);

		JButton create_account_btn = new JButton("Create Account");
		JButton login_btn = new JButton("Login");
		JButton deposit_btn = new JButton("Deposit");
		JButton withdraw_btn = new JButton("Withdraw");

		create_account_btn.setFocusPainted(false);
		login_btn.setFocusPainted(false);
		deposit_btn.setFocusPainted(false);
		withdraw_btn.setFocusPainted(false);

		create_account_btn.setMargin(new Insets(25, 25, 25, 25));
		login_btn.setMargin(new Insets(25, 25, 25, 25));
		deposit_btn.setMargin(new Insets(25, 25, 25, 25));
		withdraw_btn.setMargin(new Insets(25, 25, 25, 25));

		create_account_btn.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
		login_btn.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
		deposit_btn.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
		withdraw_btn.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));

		create_account_btn.setBackground(Color.decode("#6FAAFA"));
		create_account_btn.setForeground(Color.WHITE);
		login_btn.setBackground(Color.decode("#6FAAFA"));
		login_btn.setForeground(Color.WHITE);
		deposit_btn.setBackground(Color.decode("#6FAAFA"));
		deposit_btn.setForeground(Color.WHITE);
		withdraw_btn.setBackground(Color.decode("#6FAAFA"));
		withdraw_btn.setForeground(Color.WHITE);

		create_account_btn.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		login_btn.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		deposit_btn.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		withdraw_btn.setAlignmentX(JLabel.CENTER_ALIGNMENT);

		JLabel name_label = new JLabel("Hi " + userName + "!!", JLabel.CENTER);
		name_label.setFont(new Font("Calibri", Font.BOLD, 24));
		name_label.setForeground(Color.white);

		JLabel balance_label = new JLabel("Your Balance is: $" + accountBalance, JLabel.CENTER);
		balance_label.setFont(new Font("Calibri", Font.BOLD, 24));
		balance_label.setForeground(Color.white);

		name_label.setBorder(new EmptyBorder(30, 0, 0, 0));

		top_panel.add(create_account_btn);
		top_panel.add(login_btn);
		top_panel.add(deposit_btn);
		top_panel.add(withdraw_btn);

		bottom_panel.add(name_label);
		bottom_panel.add(balance_label);

		frame.getContentPane().add(top_panel);
		frame.getContentPane().add(bottom_panel);

		// Button Action Listeners
		actionsListeners(create_account_btn, login_btn, deposit_btn, withdraw_btn, frame, name_label, balance_label);
	}

	/*
	 * Takes four JButtons as a parameters Listens their actions
	 */
	private static void actionsListeners(JButton create_account_btn, JButton login_btn, JButton deposit_btn,
			JButton withdraw_btn, JFrame frame, JLabel name_label, JLabel balance_label) {
		create_account_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!Double.toString(bankAccount.getAmount()).equals("0.0")){
					JOptionPane.showMessageDialog(null, "Already Logged in", "Message", 1);
				}

				else {
					JTextField field1 = new JTextField();
					JTextField field2 = new JTextField();
					JTextField field3 = new JTextField();

					Object[] message = { "First Name:", field1, "Last Name:", field2, "Login Phrase:", field3, };
					int option = JOptionPane.showConfirmDialog(frame, message, "Create Account",
							JOptionPane.OK_CANCEL_OPTION);
					if (option == JOptionPane.OK_OPTION) {
						String firstName = field1.getText();
						String lastName = field2.getText();
						String loginPhrase = field3.getText();

						bankAccount.createUserAccount(firstName, lastName, loginPhrase);
						if (bankAccount.getError_message().equals("None")) {
							JOptionPane.showMessageDialog(null, "Account has created successfully", "Account Creation", 1);

							userName = bankAccount.getFirstName();
							accountBalance = Double.toString(bankAccount.getAmount());

							name_label.setText("Hi " + userName + "!!");
							balance_label.setText("Your Balance is: $" + accountBalance);
						} else {
							JOptionPane.showMessageDialog(null, "Duplicate Name", "Error", 2);
						}
					}
				}

			}
		});

		login_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JTextField field1 = new JTextField();

				Object[] message = { "Login Phrase:", field1 };
				int option = JOptionPane.showConfirmDialog(frame, message, "Login", JOptionPane.OK_CANCEL_OPTION);
				if (option == JOptionPane.OK_OPTION) {
					bankAccount.getUserInfo(field1.getText());
					bankAccount.getamountInfo();
					accountBalance = Double.toString(bankAccount.getAmount());
					userName = bankAccount.getFirstName();
					if (accountBalance.equals("-1.0")) {
						JOptionPane.showMessageDialog(null, "Wrong Login Phrase", "Error", 2);
					} else {
						JOptionPane.showMessageDialog(null, "Successfully logged in", "Success", 1);
						name_label.setText("Hi " + userName + "!!");
						balance_label.setText("Your Balance is: $" + accountBalance);
					}

				}

			}
		});

		deposit_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				JTextField field1 = new JTextField();

				if (accountBalance.equals("0.00")) {
					JOptionPane.showMessageDialog(null, "Login Required", "Error", 2);
				} else {
					Object[] message = { "Deposit Amount:", field1 };
					int option = JOptionPane.showConfirmDialog(frame, message, "Deposit", JOptionPane.OK_CANCEL_OPTION);
					if (option == JOptionPane.OK_OPTION) {
						try {
							bankAccount.deposit(Double.parseDouble(field1.getText()));
							JOptionPane.showMessageDialog(null, "Deposit Success", "Success", 1);
							accountBalance = Double.toString(bankAccount.getAmount());
							balance_label.setText("Your Balance is: $" + accountBalance);
						} catch (NumberFormatException ne) {
							JOptionPane.showMessageDialog(null, "Enter a valid amount", "Error", 2);
						}

					}
				}

			}
		});

		withdraw_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JTextField field1 = new JTextField();

				if (accountBalance.equals("0.00")) {
					JOptionPane.showMessageDialog(null, "Login Required", "Error", 2);
				}

				else {
					Object[] message = { "Withdraw Amount:", field1 };
					int option = JOptionPane.showConfirmDialog(frame, message, "Withdraw",
							JOptionPane.OK_CANCEL_OPTION);
					if (option == JOptionPane.OK_OPTION) {

						try {
							if (Double.parseDouble(field1.getText()) > bankAccount.getAmount()) {
								JOptionPane.showMessageDialog(null, "Insuffient amount!!", "Error", 2);
							} else {
								bankAccount.withdraw(Double.parseDouble(field1.getText()));
								JOptionPane.showMessageDialog(null, "Withdraw Success", "Success", 1);
								accountBalance = Double.toString(bankAccount.getAmount());
								balance_label.setText("Your Balance is: $" + accountBalance);
							}

						}

						catch (NumberFormatException ne) {
							JOptionPane.showMessageDialog(null, "Enter a valid amount", "Error", 2);
						}

					}
				}

			}
		});
	}

}
