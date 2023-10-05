package rms;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;

public class pwc extends JPanel {
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;
	private JLabel lblEnterOldPassword;
	private JTextField username;
	private JPasswordField password;
	private JPasswordField neww;
	private JPasswordField newww;

	/**
	 * Create the panel.
	 */
	public pwc() {
		setBounds(0, 0, 1259, 708);
		setLayout(null);
		
		setBackground(new Color(0, 128, 128));
		setLayout(null);
	
		JLabel lblNewLabel = new JLabel("Enter Old Password");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(453, 194, 176, 16);
		add(lblNewLabel);
		
		JLabel lblEnterNewPassword = new JLabel("Enter New Password");
		lblEnterNewPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEnterNewPassword.setBounds(453, 231, 176, 16);
		add(lblEnterNewPassword);
		
		JLabel lblNewLabel_1_1 = new JLabel("Confirm New Password");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(453, 270, 176, 16);
		add(lblNewLabel_1_1);
		
		lblNewLabel_1 = new JLabel("CHANGE PASSWORD");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 31));
		lblNewLabel_1.setBounds(453, 57, 443, 75);
		add(lblNewLabel_1);
		
		
		lblEnterOldPassword = new JLabel("Enter Username");
		lblEnterOldPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterOldPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEnterOldPassword.setBounds(453, 163, 176, 16);
		add(lblEnterOldPassword);
		
		username = new JTextField();
		username.setBackground(Color.WHITE);
		username.setColumns(10);
		username.setBounds(679, 153, 158, 30);
		add(username);
		
		password = new JPasswordField();
		password.setBackground(Color.WHITE);
		password.setEchoChar('*');
		password.setBounds(679, 194, 158, 26);
		add(password);
		
		neww = new JPasswordField();
		neww.setBackground(Color.WHITE);
		neww.setEchoChar('*');
		neww.setBounds(679, 231, 158, 28);
		add(neww);
		
		newww = new JPasswordField();
		newww.setBackground(Color.WHITE);
		newww.setEchoChar('*');
		newww.setBounds(679, 270, 158, 30);
		add(newww);
		
		final JCheckBox sh = new JCheckBox("Show");
		sh.setBackground(new Color(0, 128, 128));
		sh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(sh.isSelected())
					password.setEchoChar((char)0);
				else
					password.setEchoChar('*');
			}
				
		});
		sh.setFont(new Font("Tahoma", Font.PLAIN, 17));
		sh.setHorizontalAlignment(SwingConstants.CENTER);
		sh.setBounds(843, 194, 99, 26);
		add(sh);
		
		final JCheckBox sho = new JCheckBox("Show");
		sho.setBackground(new Color(0, 128, 128));
		sho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(sho.isSelected())
					neww.setEchoChar((char)0);
				else
					neww.setEchoChar('*');
			}
				
		});
		sho.setFont(new Font("Tahoma", Font.PLAIN, 17));
		sho.setHorizontalAlignment(SwingConstants.CENTER);
		sho.setBounds(843, 225, 99, 34);
		add(sho);
		
		final JCheckBox show = new JCheckBox("Show");
		show.setBackground(new Color(0, 128, 128));
		show.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(show.isSelected())
					newww.setEchoChar((char)0);
				else
					newww.setEchoChar('*');
			}
				
		});
		show.setFont(new Font("Tahoma", Font.PLAIN, 17));
		show.setHorizontalAlignment(SwingConstants.CENTER);
		show.setBounds(843, 266, 99, 32);
		add(show);

		
		btnNewButton = new JButton("SAVE");
		btnNewButton.setBackground(new Color(0, 128, 128));
		btnNewButton.setIcon(new ImageIcon("icons/Save-icon.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_management","root","Iloveyou@Raa");
					Statement stmt=con.createStatement();
				
					ResultSet re=stmt.executeQuery("select * from login where UserName= '"+username.getText()+"' and Password='"+password.getText()+"'");
										
						if(re.next()) {
							
						if(username.getText().equals("")||password.getText().equals(""))
						{
							JOptionPane.showMessageDialog(null, "Please Enter Full Details");
							
						}
						else {
													
						stmt.executeUpdate("update login set Password='"+neww.getText()+"' where UserName= '"+username.getText()+"'");						
						if (neww.getText().equals(newww.getText())) {
						
							JOptionPane.showMessageDialog(null, "Password Updated Successfully");
						
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Password Doesnot Match");
						}
						}
						}
						else {
							JOptionPane.showMessageDialog(null, "Username and Password Doesnot Match");
						}
						}
					catch(Exception e1) {
					System.out.print(e1);
					}
				
		
		
				
				
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBounds(548, 336, 158, 46);
		add(btnNewButton);

	}
}