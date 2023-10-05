package rms;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Sales extends JPanel {
	@SuppressWarnings("unused")
	private JTextField textField;
	@SuppressWarnings("unused")
	private JTextField textField_1;
	@SuppressWarnings("unused")
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public Sales() {
		
		
		setBounds(0, 0, 1600, 909);
		setLayout(null);
		
		JPanel weekly = new JPanel();
		weekly.setBackground(new Color(0, 128, 128));
		weekly.setBorder(new EmptyBorder(5, 5, 5, 5));
		weekly.setBounds(0, 0, 1600, 909);
		add(weekly);
		weekly.setLayout(null);
		
		final JLabel netpay = new JLabel("");
		netpay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		netpay.setBackground(Color.MAGENTA);
		netpay.setBounds(26, 210, 196, 64);
		weekly.add(netpay);
		
		final JLabel lblNetPayout = new JLabel("Daily Sales");
		lblNetPayout.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNetPayout.setBackground(Color.MAGENTA);
		lblNetPayout.setBounds(26, 269, 374, 64);
		weekly.add(lblNetPayout);
		
		JLabel lblTopSellingMenu = new JLabel("Top selling Menu Items");
		lblTopSellingMenu.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTopSellingMenu.setBackground(Color.MAGENTA);
		lblTopSellingMenu.setBounds(26, 519, 231, 64);
		weekly.add(lblTopSellingMenu);
		
		JLabel graph = new JLabel("");
		graph.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 99));
		graph.setForeground(Color.BLACK);
		graph.setBounds(386, 141, 813, 401);
		weekly.add(graph);
		
		final JLabel onee = new JLabel("");
		onee.setHorizontalAlignment(SwingConstants.CENTER);
		onee.setFont(new Font("Tahoma", Font.BOLD, 37));
		onee.setBounds(26, 594, 374, 72);
		weekly.add(onee);
		
		final JLabel fourr = new JLabel("");
		fourr.setHorizontalAlignment(SwingConstants.CENTER);
		fourr.setFont(new Font("Tahoma", Font.BOLD, 37));
		fourr.setBounds(26, 711, 374, 72);
		weekly.add(fourr);
		
		final JLabel twoo = new JLabel("");
		twoo.setHorizontalAlignment(SwingConstants.CENTER);
		twoo.setFont(new Font("Tahoma", Font.BOLD, 37));
		twoo.setBounds(453, 594, 358, 72);
		weekly.add(twoo);
		
		final JLabel fivee = new JLabel("");
		fivee.setHorizontalAlignment(SwingConstants.CENTER);
		fivee.setFont(new Font("Tahoma", Font.BOLD, 37));
		fivee.setBounds(453, 711, 489, 72);
		weekly.add(fivee);
		
		final JLabel threee = new JLabel("");
		threee.setHorizontalAlignment(SwingConstants.CENTER);
		threee.setFont(new Font("Tahoma", Font.BOLD, 37));
		threee.setBounds(890, 594, 374, 72);
		weekly.add(threee);
		
		JButton btnNewButton = new JButton("Daily sales");
		btnNewButton.setBackground(new Color(0, 128, 128));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				lblNetPayout.setText("Daily Sales");
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
				     Connection	 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_management?autoReconnect=true&useSSL=false","root","Iloveyou@Raa");
					 Statement Stmt = (Statement) con.createStatement();
					 ResultSet rs = null;
					
					 rs = Stmt.executeQuery("select sum(total) from restaurant_management.order where order_date = curdate() ");
					rs.next();
					netpay.setText("Rs. "+rs.getString(1));
					
					
					
				}
				catch(Exception ew)
				{
					 ew.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(333, 26, 180, 49);
		weekly.add(btnNewButton);
		
		JButton btnMonthlySales = new JButton("Monthly sales");
		btnMonthlySales.setBackground(new Color(0, 128, 128));
		btnMonthlySales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				lblNetPayout.setText("Monthly Sales");
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
				     Connection	 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_management?autoReconnect=true&useSSL=false","root","Iloveyou@Raa");
					 Statement Stmt = (Statement) con.createStatement();
					 ResultSet rs = null;
					
					 rs = Stmt.executeQuery("select  sum(total) from restaurant_management.order where order_date > current_date - interval 30 day; ");
					rs.next();
					netpay.setText("Rs. "+rs.getString(1));
					rs = Stmt.executeQuery("select food_name , sum(qty) from restaurant_management.order where order_date > current_date - interval 30 day group by food_name order by sum(qty) desc");
					
						rs.next();
						onee.setText("1."+rs.getString(1)+"("+rs.getString(2)+")");
						rs.next();
						twoo.setText("2."+rs.getString(1)+"("+rs.getString(2)+")");
						rs.next();
						threee.setText("3."+rs.getString(1)+"("+rs.getString(2)+")");
						rs.next();
						fourr.setText("4."+rs.getString(1)+"("+rs.getString(2)+")");
						rs.next();
						fivee.setText("5."+rs.getString(1)+"("+rs.getString(2)+")");
					
					
				}
				catch(Exception we)
				{
					we.printStackTrace();
				}
			}
		});
		
		btnMonthlySales.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnMonthlySales.setBounds(726, 26, 180, 49);
		weekly.add(btnMonthlySales);
		
		JButton btnWeeklySales = new JButton("Weekly Sales");
		btnWeeklySales.setBackground(new Color(0, 128, 128));
		btnWeeklySales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				lblNetPayout.setText("Weekly Sales");
				try {
			
				Class.forName("com.mysql.cj.jdbc.Driver");
			     Connection	 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_management?autoReconnect=true&useSSL=false","root","Iloveyou@Raa");
				 Statement Stmt = (Statement) con.createStatement();
				 ResultSet rs = null;
				
				 rs = Stmt.executeQuery("select sum(total) from restaurant_management.order where order_date > current_date - interval 7 day ");
				rs.next();
				netpay.setText("Rs. "+rs.getString(1));
				rs = Stmt.executeQuery("select food_name , sum(qty) from restaurant_management.order where order_date > current_date - interval 7 day group by food_name order by sum(qty) desc");
				rs.next();
				onee.setText("1."+rs.getString(1)+"("+rs.getString(2)+")");
				rs.next();
				twoo.setText("2."+rs.getString(1)+"("+rs.getString(2)+")");
				rs.next();
				threee.setText("3."+rs.getString(1)+"("+rs.getString(2)+")");
				rs.next();
				fourr.setText("4."+rs.getString(1)+"("+rs.getString(2)+")");
				rs.next();
				fivee.setText("5."+rs.getString(1)+"("+rs.getString(2)+")");
				}
				catch(Exception t)
				{
					t.printStackTrace();
				}
				
			}
		});
		btnWeeklySales.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnWeeklySales.setBounds(526, 26, 180, 49);
		weekly.add(btnWeeklySales);
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
		     Connection	 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_management?autoReconnect=true&useSSL=false","root","Iloveyou@Raa");
			 Statement Stmt = (Statement) con.createStatement();
			 ResultSet rs = null;
			
			 rs = Stmt.executeQuery("select sum(total) from restaurant_management.order where order_date = curdate() ");
			rs.next();
			netpay.setText("Rs.    <dynamic>");
			
			
			
		}
		catch(Exception e)
		{
			 e.printStackTrace();
		}
		
		
		
		
		
		
		

	}

}