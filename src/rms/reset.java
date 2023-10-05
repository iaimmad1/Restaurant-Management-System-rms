package rms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import com.mysql.cj.protocol.Resultset;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JEditorPane;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;

public class reset extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField answer;
	private JPasswordField password;
	private JPasswordField password1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					reset frame = new reset();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public reset() {
		setTitle("Forgot Password");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 565, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setBounds(12, 29, 115, 30);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 17));
		contentPane.add(lblUsername);
		
		JLabel lblNewLabel_1_2_1_4 = new JLabel("Answer");
		lblNewLabel_1_2_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_4.setBounds(12, 126, 115, 30);
		lblNewLabel_1_2_1_4.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		contentPane.add(lblNewLabel_1_2_1_4);
		
		JLabel lblNewLabel_1_2_1_3 = new JLabel("Question");
		lblNewLabel_1_2_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_3.setBounds(10, 69, 111, 34);
		lblNewLabel_1_2_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		contentPane.add(lblNewLabel_1_2_1_3);
		
		final JComboBox question = new JComboBox();
		question.setBounds(131, 73, 397, 30);
		question.setModel(new DefaultComboBoxModel(new String[] {"", "What is your birth city?", "What is your birth date?", "What is your childhood nickname?", "What is your father name?", "What is your favorite dish?", "Which is your favorite place?", "What is your favorite pet name?", "Which is your first school name?"}));
		contentPane.add(question);
		
		
		answer = new JPasswordField();
		answer.setBounds(131, 126, 397, 30);
		contentPane.add(answer);
		

		username = new JTextField();
		username.setBounds(131, 32, 215, 30);
		username.setColumns(10);
		contentPane.add(username);
		
		final JCheckBox Show = new JCheckBox("Show Answer");
		Show.setHorizontalAlignment(SwingConstants.CENTER);
		Show.setBounds(408, 167, 135, 23);
		Show.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(Show.isSelected())
					answer.setEchoChar((char)0);
				else
					answer.setEchoChar('*');
			}
				
				
		});
		Show.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(Show);
		
		JLabel lblNewLabel = new JLabel("Enter New Password");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(17, 189, 154, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblConfirmNewPassword = new JLabel("Confirm New password");
		lblConfirmNewPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirmNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblConfirmNewPassword.setBounds(12, 238, 159, 38);
		contentPane.add(lblConfirmNewPassword);
		
		password = new JPasswordField();
		password.setEchoChar('*');
		password.setBounds(213, 190, 189, 37);
		contentPane.add(password);
		
		password1 = new JPasswordField();
		password1.setEchoChar('*');
		password1.setBounds(213, 241, 189, 35);
		contentPane.add(password1);
		
		final JCheckBox chckbxShow = new JCheckBox("Show");
		chckbxShow.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(chckbxShow.isSelected())
					password1.setEchoChar((char)0);
				else
					password1.setEchoChar('*');
			}
		});
		chckbxShow.setBounds(419, 237, 58, 23);
		contentPane.add(chckbxShow);
		
		final JCheckBox chckbxNewCheckBox = new JCheckBox("Show");
		chckbxNewCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(chckbxNewCheckBox.isSelected())
					password.setEchoChar((char)0);
				else
					password.setEchoChar('*');
			}
				
		});
		chckbxNewCheckBox.setBounds(419, 202, 58, 23);
		contentPane.add(chckbxNewCheckBox);
		
		

		
		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.setBounds(131, 299, 115, 36);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_management","root","Iloveyou@Raa");
					Statement stmt=con.createStatement();
				
					ResultSet re=stmt.executeQuery("select * from login where UserName= '"+username.getText()+"' and Question='"+question.getSelectedItem()+"' and Answer= '"+answer.getText()+"'");
					
						if(re.next()) {
							
						}
						if(username.getText().equals("")||answer.getText().equals("")||question.getSelectedItem().equals(""))
						{
							JOptionPane.showMessageDialog(null, "Please Enter Full Details");
							
						}
						else {
						
						stmt.executeUpdate("update login set Password='"+password1.getText()+"' where UserName= '"+username.getText()+"'");						
						if (password.getText().equals(password1.getText())) {
						
							JOptionPane.showMessageDialog(null, "Password Updated Successfully");
							dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Password Doesnot Match");
						}
					}
					
				
					
				}catch(Exception e1) {
					System.out.print(e1);
					}
				
		
		
				
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(287, 299, 115, 36);
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				login.main(null);
			}
		});
		contentPane.add(btnCancel);
		
	
	
		
		
	}
}
