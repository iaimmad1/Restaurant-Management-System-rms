package rms;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class table extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public table() {
		setBackground(new Color(0, 128, 128));
		setBounds(0, 0, 1259, 708);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Manage Tables");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 49));
		lblNewLabel.setBounds(327, 67, 549, 56);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter No. of Tables");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(327, 246, 174, 39);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBackground(Color.WHITE);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setBounds(556, 246, 247, 39);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("SAVE");
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
						
						if(textField.getText().equals(""))
				  		{
							Stmt.executeQuery( "INSERT  INTO table ( no_of_table )values('"+textField.getText()+"') ");
							
							
							JOptionPane.showMessageDialog(null, "Table Inserted Successfully");
						
							
				  		}
				  		else
				  		{
				
				  			JOptionPane.showMessageDialog(null, "Tables are already inserted");
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
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(364, 337, 168, 48);
		add(btnNewButton);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setBackground(new Color(0, 128, 128));
		btnUpdate.setIcon(new ImageIcon("icons/Reload-icon.png"));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			
					
				try {
				
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_management","root","Iloveyou@Raa");
					Statement Stmt = (Statement) con.createStatement();
					ResultSet rs = null;
					rs = Stmt.executeQuery("select no_of_table from tableno ");
					rs.next();
					
					
				
					try {
						
						if(textField.getText().equals(""))
				  		{
							
							JOptionPane.showMessageDialog(null, "Tables can't be null");
							
							
							
				  		}
				  		else
				  		{
				
				  			Stmt.executeUpdate( "Update  tableno set no_of_table = '"+textField.getText()+"' ");
							
							
							JOptionPane.showMessageDialog(null, "Table Updated Successfully");
						
							
							
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
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnUpdate.setBounds(595, 337, 168, 48);
		add(btnUpdate);
		
		
		
	}
}
