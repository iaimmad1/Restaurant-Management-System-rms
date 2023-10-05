package rms;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.text.JTextComponent;

import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JProgressBar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class login {

	protected static final JTextComponent UserName = null;
	protected static final JTextComponent Password = null;
	private JFrame f;
	private JTextField textField;
	private JLabel p;
	private JPasswordField passwordField;
	protected JTextComponent txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.f.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @param <string>
	 */
	private <string> void initialize() {
		f = new JFrame();
		f.getContentPane().setBackground(new Color(0, 128, 128));
		f.getContentPane().setFont(new Font("Times New Roman", Font.BOLD, 17));
		f.setTitle("Restaurent Management System");
		f.setBounds(100, 100, 601, 323);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(null);
		f.setUndecorated(true);
		f.setResizable(false);
		//f.dispose();

		//code for centralizing
		/*Toolkit toolkit = f.getToolkit();
		Dimension size = toolkit.getScreenSize();
		f.setLocation((size.width/2 - f.getWidth()/2), (size.height/2 - f.getHeight()/2));*/
		//OR//
		f.setLocationRelativeTo(null);//code for centralizing




		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		textField.setBounds(411, 72, 158, 34);
		f.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel u = new JLabel("Username");
		u.setBackground(new Color(0, 51, 51));
		u.setForeground(Color.WHITE);
		u.setBounds(312, 68, 89, 40);
		u.setFont(new Font("Times New Roman", Font.BOLD, 17));
		f.getContentPane().add(u);

		p = new JLabel("Password ");
		p.setBackground(new Color(0, 51, 51));
		p.setForeground(Color.WHITE);
		p.setBounds(312, 109, 97, 40);
		p.setFont(new Font("Times New Roman", Font.BOLD, 17));
		f.getContentPane().add(p);

		JButton Login = new JButton("Login");
		Login.setIcon(new ImageIcon("icons/login.png"));
		//Image img = new ImageIcon(this.getClass().getResource("/o.png")).getImage();
		//Login.setIcon(new ImageIcon(img));
		Login.addActionListener(new ActionListener() {
			private JTextComponent txtusername;

			public void actionPerformed(ActionEvent e) {


				//for database login method

				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_management","root","Iloveyou@Raa");
					Statement stmt=con.createStatement();
					String sql="select * from login where UserName='"+textField.getText()+"'and Password='"+passwordField.getText().toString()+"'";
					ResultSet rs=stmt.executeQuery(sql);


					if(rs.next())
					{
						JOptionPane.showMessageDialog(null, "Login Successfully");

						Dashboard.main(null);
						f.dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Invalid Login Details");
						passwordField.setText("");
						textField.setText("");
					}
					con.close();					


				}catch(Exception e1) {
					System.out.print(e1);
				}



				/*

				//for direct login method


				String username=textField.getText();
				String password=passwordField.getText();

				    if (username.contains("admin")&&password.contains("admin")) {
					passwordField.setText("null");
					textField.setText("null");
						//f.setVisible(false);
				    	f.dispose();
				JOptionPane.showMessageDialog(null,"Login Succesful");


					Dashboard D = new Dashboard();
					D.main(null);
					Dashboard.main(null);

				}
				else
				{
					JOptionPane.showMessageDialog(null,"invalid Login Details","Login Error",JOptionPane.ERROR_MESSAGE);
					passwordField.setText("");
					textField.setText("");
				}
				 */



			}
		});
		Login.setBounds(352, 197, 114, 34);
		Login.setBackground(new Color(0, 128, 128));
		Login.setForeground(Color.BLACK);
		Login.setFont(new Font("Times New Roman", Font.BOLD, 17));
		f.getContentPane().add(Login);

		final JCheckBox Show = new JCheckBox("Show  Password");
		Show.setForeground(Color.WHITE);
		Show.setBackground(new Color(0, 128, 128));
		Show.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(Show.isSelected())
					passwordField.setEchoChar((char)0);
				else
					passwordField.setEchoChar('*');
			}


		});
		Show.setBounds(391, 156, 178, 34);
		Show.setFont(new Font("Tahoma", Font.BOLD, 17));
		f.getContentPane().add(Show);



		JLabel lblNewLabel_1 = new JLabel("Restaurent Management System");
		lblNewLabel_1.setBackground(new Color(0, 51, 51));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblNewLabel_1.setBounds(10, 6, 579, 56);
		f.getContentPane().add(lblNewLabel_1);

		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		passwordField.setBounds(411, 116, 158, 34);
		f.getContentPane().add(passwordField);

		JButton btnCancel = new JButton("Exit");
		btnCancel.setIcon(new ImageIcon("icons/logot.png"));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {




				int action=JOptionPane.showConfirmDialog(null, "Are you sure want to Exit","Exit",JOptionPane.YES_NO_OPTION);
				if(action==0)
				{

					System.exit(0);




				}



			}
		});
		btnCancel.setForeground(Color.BLACK);
		btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnCancel.setBackground(new Color(0, 128, 128));
		btnCancel.setBounds(480, 197, 97, 34);
		f.getContentPane().add(btnCancel);

		JLabel lblNewLabel = new JLabel("Forget Password");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				reset.main(null);
				f.dispose();
			}
		});
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(411, 249, 149, 27);
		f.getContentPane().add(lblNewLabel);

	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub

	}

}
