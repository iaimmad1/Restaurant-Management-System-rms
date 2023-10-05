package rms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.DropMode;
import javax.swing.ImageIcon;
import java.awt.Color;

public class adminreg extends JFrame {

	private JPanel contentPane;
	private JTextField first;
	private JTextField last;
	private JTextField username;
	private JTextField phone;
	private JTextField address;
	private JPasswordField password;
	private JButton btnNewButton;
	private JPasswordField answer;
	private JTextField email;
	private JTextField ctz;
	private JTextField status;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminreg frame = new adminreg();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public adminreg() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 701, 432);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		
		JLabel lblNewLabel = new JLabel("ADMIN  REGISTRATION");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblNewLabel.setBounds(74, 11, 550, 48);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(46, 68, 121, 35);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Last Name");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_1.setBounds(353, 68, 128, 35);
		contentPane.add(lblNewLabel_1_1);
		
		first = new JTextField();
		first.setBackground(Color.WHITE);
		first.setFont(new Font("Tahoma", Font.PLAIN, 17));
		first.setColumns(10);
		first.setBounds(165, 73, 178, 25);
		contentPane.add(first);
		
		last = new JTextField();
		last.setBackground(Color.WHITE);
		last.setFont(new Font("Tahoma", Font.PLAIN, 17));
		last.setColumns(10);
		last.setBounds(484, 70, 178, 25);
		contentPane.add(last);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Username");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_2_1.setBounds(46, 166, 116, 35);
		contentPane.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Address");
		lblNewLabel_1_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_2_1_1.setBounds(46, 104, 116, 35);
		contentPane.add(lblNewLabel_1_2_1_1);
		
		final JComboBox question = new JComboBox();
		question.setBackground(new Color(0, 128, 128));
		question.setFont(new Font("Tahoma", Font.PLAIN, 17));
		question.setModel(new DefaultComboBoxModel(new String[] {"", "What is your birth city?", "What is your birth date?", "What is your childhood nickname?", "What is your father name?", "What is your favorite dish?", "Which is your favorite place?", "What is your favorite pet name?", "Which is your first school name?"}));
		question.setBounds(165, 232, 416, 35);
		contentPane.add(question);
		
		username = new JTextField();
		username.setBackground(Color.WHITE);
		username.setFont(new Font("Tahoma", Font.PLAIN, 17));
		username.setColumns(10);
		username.setBounds(165, 171, 178, 25);
		contentPane.add(username);
		
	
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Phone No");
		lblNewLabel_1_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_2_2.setBounds(353, 104, 121, 35);
		contentPane.add(lblNewLabel_1_2_2);
		
		phone = new JTextField();
		phone.setBackground(Color.WHITE);
		phone.setToolTipText("Enter Phone");
		phone.setFont(new Font("Tahoma", Font.PLAIN, 17));
		phone.setColumns(10);
		phone.setBounds(484, 109, 178, 25);
		contentPane.add(phone);
		
		JLabel lblNewLabel_1_2_1_2 = new JLabel("Password");
		lblNewLabel_1_2_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_2_1_2.setBounds(370, 166, 80, 35);
		contentPane.add(lblNewLabel_1_2_1_2);
		
		password = new JPasswordField();
		password.setBackground(Color.WHITE);
		password.setEchoChar('*');
		password.setFont(new Font("Tahoma", Font.PLAIN, 17));
		password.setBounds(484, 171, 178, 28);
		contentPane.add(password);
		
		final JCheckBox Show = new JCheckBox("Show Password");
		Show.setBackground(new Color(0, 128, 128));
		Show.setFont(new Font("Tahoma", Font.BOLD, 17));
		Show.setHorizontalAlignment(SwingConstants.CENTER);
		Show.setBounds(488, 203, 174, 23);
		contentPane.add(Show);
		Show.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(Show.isSelected())
					password.setEchoChar((char)0);
				else
					password.setEchoChar('*');
			}
				
				
		});
		

		
		JLabel lblNewLabel_1_2_1_3 = new JLabel("Question");
		lblNewLabel_1_2_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_2_1_3.setBounds(46, 227, 116, 35);
		contentPane.add(lblNewLabel_1_2_1_3);
		
		JLabel lblNewLabel_1_2_1_4 = new JLabel("Answer");
		lblNewLabel_1_2_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_2_1_4.setBounds(46, 274, 116, 35);
		contentPane.add(lblNewLabel_1_2_1_4);
		
		address = new JTextField();
		address.setBackground(Color.WHITE);
		address.setFont(new Font("Tahoma", Font.PLAIN, 17));
		address.setColumns(10);
		address.setBounds(165, 109, 178, 25);
		contentPane.add(address);
		
		
		answer = new JPasswordField();
		answer.setBackground(Color.WHITE);
		answer.setFont(new Font("Tahoma", Font.PLAIN, 17));
		answer.setEchoChar('*');
		answer.setBounds(165, 274, 416, 34);
		contentPane.add(answer);
		
		
		final JCheckBox answerr = new JCheckBox("Show Answer");
		answerr.setBackground(new Color(0, 128, 128));
		answerr.setFont(new Font("Tahoma", Font.BOLD, 17));
		answerr.setHorizontalAlignment(SwingConstants.CENTER);
		answerr.setBounds(503, 316, 159, 23);
		contentPane.add(answerr);
		answerr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(answerr.isSelected())
					answer.setEchoChar((char)0);
				else
					answer.setEchoChar('*');
			}
				
				
		});
		
		
		
		
		

		JLabel lblNewLabel_1_2 = new JLabel("Email");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_2.setBounds(46, 134, 106, 35);
		contentPane.add(lblNewLabel_1_2);
		
		email = new JTextField();
		email.setBackground(Color.WHITE);
		email.setFont(new Font("Tahoma", Font.PLAIN, 17));
		email.setColumns(10);
		email.setBounds(165, 139, 178, 25);
		contentPane.add(email);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Citizenship No. ");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_1_1.setBounds(353, 136, 132, 35);
		contentPane.add(lblNewLabel_1_1_1);
		
		ctz = new JTextField();
		ctz.setBackground(Color.WHITE);
		ctz.setFont(new Font("Tahoma", Font.PLAIN, 17));
		ctz.setColumns(10);
		ctz.setBounds(484, 139, 178, 25);
		contentPane.add(ctz);
		
		JLabel lblNewLabel_1_2_1_5 = new JLabel("Status");
		lblNewLabel_1_2_1_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_2_1_5.setBounds(46, 203, 109, 35);
		contentPane.add(lblNewLabel_1_2_1_5);
		
		status = new JTextField();
		status.setBackground(new Color(0, 128, 128));
		status.setText("admin");
		status.setEditable(false);
		status.setFont(new Font("Tahoma", Font.PLAIN, 17));
		status.setColumns(10);
		status.setBounds(165, 207, 178, 25);
		contentPane.add(status);
		

		
		
		
		
			
		
		
		btnNewButton = new JButton("save");
		btnNewButton.setBackground(new Color(0, 128, 128));
		btnNewButton.setIcon(new ImageIcon("icons/Save-icon.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				Connection con = null;
				Statement Stmt = null;
					
				try {
				
					Class.forName("com.mysql.cj.jdbc.Driver");
					 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_management","root","Iloveyou@Raa");
					Stmt = (Statement) con.createStatement();
					
					
				
					try {
						
						if(first.getText().equals("")||last.getText().equals("")||phone.getText().equals("")||question.getSelectedItem().equals("")||answer.getText().equals("")||address.getText().equals("")||username.getText().equals("")||password.getText().equals("")||email.getText().equals("")||ctz.getText().equals(""))
				  		{
							JOptionPane.showMessageDialog(null, "Enter Full details");
							
				  		}
				  		else
				  		{
					Stmt.executeUpdate( "INSERT  INTO login (UserName, Password, First_Name, Last_Name, Question, Answer, Phone_no, Address, Email, Ctz, Status)values('"+ username.getText()+"','"+password.getText()+"','"+first.getText()+"','"+last.getText()+"','"+question.getSelectedItem()+"','"+answer.getText()+"','"+Long.parseLong(phone.getText())+"','"+address.getText()+"','"+ email.getText()+"','"+ctz.getText()+"','"+status.getText()+"') ");
					first.setText(null);
					last.setText(null);
					phone.setText(null);
					address.setText(null);
					answer.setText(null);
					username.setText(null);
					password.setText(null);
					question.setSelectedItem(null);
					email.setText(null);
					ctz.setText(null);
					
					dispose();
					JOptionPane.showMessageDialog(null, "Admin Registered Successfully");
					login.main(null);
					
				  		}
					}
					catch(Exception e1)
					{
						e1.printStackTrace();						
					}
			}
				catch(Exception e2)			
				{
					e2.printStackTrace();
					
				}
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBounds(293, 337, 159, 42);
		contentPane.add(btnNewButton);
			
	}
}
