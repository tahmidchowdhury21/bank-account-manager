import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class BankAccountGUI {
	
	public static void main(String[] args) {
		
		

		BankAccount bankAccount = new BankAccount();
		// bankAccount.createUserAccount("John", "Herd", "top");
		// bankAccount.getUserInfo("top");
		// bankAccount.getamountInfo();
		//
		//
		// System.out.println(bankAccount.getAmount());
		// System.out.println(bankAccount.getFirstName());
		// System.out.println(bankAccount.getLastName());
		// System.out.println(bankAccount.getLoginPhrase());
		// System.out.println(bankAccount.getAmount());
		//
		//
		//
		//
		// bankAccount.withdraw(10.50);
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

		JPanelWithBackground panel = new JPanelWithBackground("src/background.jpg");
		panel.setLayout(new FlowLayout()); // or whatever layout you want
		frame.setContentPane(panel);

		createUI(frame);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	private static void createUI(final JFrame frame) {
		JPanel top_panel = new JPanel();
		LayoutManager top_layout = new BoxLayout(top_panel, BoxLayout.Y_AXIS);
		top_panel.setLayout(top_layout);

		top_panel.setOpaque(false);

		JLabel title_label = new JLabel("Welcome To The Neighbour Bank", JLabel.CENTER);
		title_label.setFont(new Font("Calibri", Font.BOLD, 18));
		title_label.setForeground(Color.white);

		title_label.setOpaque(false);
		title_label.setBorder(new EmptyBorder(20, 0, 0, 0));

		title_label.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		top_panel.add(title_label);

		JButton create_account_btn = new JButton("Create Account");
		JButton login_btn = new JButton("Login");
		JButton deposit_btn = new JButton("Deposit");
		JButton withdraw_btn = new JButton("Withdraw");

		create_account_btn.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		login_btn.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		deposit_btn.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		withdraw_btn.setAlignmentX(JLabel.CENTER_ALIGNMENT);

		top_panel.add(create_account_btn);
		top_panel.add(login_btn);
		top_panel.add(deposit_btn);
		top_panel.add(withdraw_btn);

		frame.getContentPane().add(top_panel);

		// Button Action Listeners
		actionsListeners(create_account_btn, login_btn, deposit_btn, withdraw_btn);
	}

	/*
	 * Takes four JRadioButton as a parameters Listens their actions and if one of
	 * them is selected, then the other will be disabled
	 */
	private static void actionsListeners(JButton create_account_btn, JButton login_btn, JButton deposit_btn,
			JButton withdraw_btn) {
		create_account_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("create_account!!");

			}
		});
		
		login_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("login!!");

			}
		});
		
		deposit_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("deposit!!");

			}
		});
		
		withdraw_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("withdraw!!");

			}
		});
	}

}
