package rms;

import java.awt.EventQueue;//01442 pin code

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.mysql.cj.protocol.Resultset;
import javax.swing.SwingConstants;

public class Dashboard {

	private JFrame D;
	private Menu menu;
	private Order order;
	private Billing bill;
	private Inventoryy inventory;
	private Staff staff;
	private Sales sales;
	private Inventoryy inven;
	private setting setting;
	
	static String removeSubstring(String text, int startIndex, int endIndex) {
        if (endIndex < startIndex) {
            startIndex = endIndex;
        }

        String a = text.substring(0, startIndex);
        String b = text.substring(endIndex);
        return a + b;
    }
	
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard window = new Dashboard();
					window.D.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Dashboard() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		D = new JFrame();
		D.getContentPane().setBackground(new Color(0, 128, 128));
		D.setTitle("Dashboard");
		D.setBounds(0, 0, 1540, 864);
		D.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		D.setUndecorated(true);
		D.setLocationRelativeTo(null);
		D.getContentPane().setLayout(null);
		  
		java.util.Date date = new java.util.Date();    
	    
		
		
		menu=new Menu();
		
		
		
		menu.setBackground(new Color(0, 128, 128));
		menu.setBounds(0, 0, 1255, 836);
		order=new Order();
		order.setBounds(0, 0, 1610, 1069);
		bill=new Billing();
		bill.setBounds(0, 0, 1610, 1069);
		inventory=new Inventoryy();
		inventory.setBounds(0, 0, 1610, 1058);
		sales=new Sales();
		sales.setBounds(0, 0, 1610, 1058);
		staff=new Staff();
		staff.setBounds(0, 0, 1610, 1058);
		setting=new setting();
		setting.setBounds(0, 0, 1610, 1058);
		
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 255, 845);
		panel.setBackground(new Color(0, 128, 128));
		D.getContentPane().add(panel);
		
		
		
		Menu h=new Menu();
		JPanel paneMenu = new JPanel();
		paneMenu.setBounds(0, 242, 255, 45);
		paneMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			 menuClicked(menu);
			}
		});
		panel.setLayout(null);
		panel.add(paneMenu);
		paneMenu.setLayout(null);
		
		
		
		JLabel lblNewLabel = new JLabel("Menu");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("icons/menu (2).png"));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 0, 245, 45);
		paneMenu.add(lblNewLabel);
		
		final JPanel main = new JPanel();
		main.setBounds(255, 11, 1255, 838);
		main.setBackground(new Color(0, 128, 128));
		D.getContentPane().add(main);
		menuClicked(paneMenu);
		
		
		
		Order o=new Order();
		JPanel paneOrder = new JPanel();
		paneOrder.setBounds(0, 287, 255, 45);
		paneOrder.setBackground(Color.WHITE);
		paneOrder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				menuClicked(order);
			}
		});
		panel.add(paneOrder);
		paneOrder.setLayout(null);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Order");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon("icons/tray (1).png"));
//		lblNewLabel_1.setIcon(new ImageIcon(Dashboard.class.getResource("/icons/tray (1).png")));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 5, 235, 40);
		paneOrder.add(lblNewLabel_1);
		
		JPanel paneBill = new JPanel();
		paneBill.setBounds(0, 332, 255, 45);
		paneBill.setLayout(null);
		paneBill.setBackground(Color.WHITE);
		paneBill.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				menuClicked(bill);
			}
		});
		panel.add(paneBill);
		paneBill.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Billing");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setIcon(new ImageIcon("icons/bill (1).png"));
//		lblNewLabel_1_1.setIcon(new ImageIcon(Dashboard.class.getResource("/icons/bill (1).png")));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(10, 5, 235, 40);
		paneBill.add(lblNewLabel_1_1);
		
		JPanel PaneInventory = new JPanel();
		PaneInventory.setBounds(0, 377, 255, 45);
		PaneInventory.setLayout(null);
		PaneInventory.setBackground(Color.WHITE);
		PaneInventory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				menuClicked(inventory);
			}
		});
		panel.add(PaneInventory);
		PaneInventory.setLayout(null);
		
		
		JLabel lab = new JLabel("Inventory");
		lab.setHorizontalAlignment(SwingConstants.CENTER);
		lab.setIcon(new ImageIcon("icons/inventory (1).png"));
//		lab.setIcon(new ImageIcon(Dashboard.class.getResource("/icons/inventory (1).png")));
		lab.setFont(new Font("Tahoma", Font.BOLD, 18));
		lab.setBounds(10, 0, 245, 45);
		PaneInventory.add(lab);
		
		
		
		
		JPanel paneStaff = new JPanel();
		paneStaff.setBounds(0, 422, 255, 45);
		paneStaff.setLayout(null);
		paneStaff.setBackground(Color.WHITE);
		paneStaff.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				menuClicked(staff);
			}
		});

		panel.add(paneStaff);
		paneStaff.setLayout(null);
		
		JLabel lblNewLabel_1_3 = new JLabel("Staff");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setIcon(new ImageIcon("icons/multiple-users-silhouette (1).png"));
//		lblNewLabel_1_3.setIcon(new ImageIcon(Dashboard.class.getResource("/icons/multiple-users-silhouette (1).png")));
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_3.setBounds(10, 5, 235, 40);
		paneStaff.add(lblNewLabel_1_3);
		
		JPanel paneSales = new JPanel();
		paneSales.setBounds(0, 467, 255, 45);
		paneSales.setLayout(null);
		paneSales.setBackground(Color.WHITE);
		paneSales.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				menuClicked(sales);
			}
		});
		panel.add(paneSales);
		paneSales.setLayout(null);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Sales");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setIcon(new ImageIcon("icons/increasing (1).png"));
//		lblNewLabel_1_1_1.setIcon(new ImageIcon(Dashboard.class.getResource("/icons/increasing (1).png")));
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1_1.setBounds(10, 5, 235, 40);
		paneSales.add(lblNewLabel_1_1_1);
		
		JPanel paneSignout = new JPanel();
		paneSignout.setBounds(0, 555, 255, 45);
		paneSignout.setLayout(null);
		paneSignout.setBackground(Color.WHITE);
		paneSignout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int action=JOptionPane.showConfirmDialog(null,"Do you want to sign out","Confirmation", JOptionPane.YES_NO_OPTION);
					
				
				if(action==0)
				{
				
					
					login.main(null);
					D.dispose();

				
				}
				
			}
		});
		panel.add(paneSignout);
		paneSignout.setLayout(null);
		
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Signout");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1.setIcon(new ImageIcon("icons/logout (1).png"));
//		lblNewLabel_1_2_1.setIcon(new ImageIcon(Dashboard.class.getResource("/icons/logout (1).png")));
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_2_1.setBounds(10, 0, 235, 45);
		paneSignout.add(lblNewLabel_1_2_1);
		
		final JPanel dashboard = new JPanel();
		dashboard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				 menuClicked(dashboard);
				
				 D.dispose();
				 Dashboard.main(null);
		
			}
		});
		dashboard.setBounds(0, 197, 255, 45);
		panel.add(dashboard);
		dashboard.setLayout(null);
		
		
		
		
		
		
		
		JLabel lblDashboard = new JLabel("Dashboard");
		lblDashboard.setHorizontalAlignment(SwingConstants.CENTER);
		lblDashboard.setIcon(new ImageIcon("icons/home (1).png"));
//		lblDashboard.setIcon(new ImageIcon(Dashboard.class.getResource("/icons/home (1).png")));
		lblDashboard.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDashboard.setBounds(31, 5, 190, 35);
		dashboard.add(lblDashboard);
		
		JPanel paneSetting = new JPanel();
		paneSetting.setLayout(null);
		paneSetting.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				menuClicked(setting);
			}
		});

		paneSetting.setBackground(Color.WHITE);
		paneSetting.setBounds(0, 510, 255, 45);
		panel.add(paneSetting);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Settings");
		lblNewLabel_1_2_1_1.setIcon(new ImageIcon("icons/setting.png"));
		lblNewLabel_1_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_2_1_1.setBounds(0, 0, 255, 40);
		paneSetting.add(lblNewLabel_1_2_1_1);
		
		
		paneMenu.addMouseListener(new PanelButtonMouseAdapter(paneMenu));
		paneOrder.addMouseListener(new PanelButtonMouseAdapter(paneOrder));
		paneBill.addMouseListener(new PanelButtonMouseAdapter(paneBill));
		PaneInventory.addMouseListener(new PanelButtonMouseAdapter(PaneInventory));
		paneSales.addMouseListener(new PanelButtonMouseAdapter(paneSales));
		paneStaff.addMouseListener(new PanelButtonMouseAdapter(paneStaff));
		paneSignout.addMouseListener(new PanelButtonMouseAdapter(paneSignout));
		paneSetting.addMouseListener(new PanelButtonMouseAdapter(paneSetting));
		dashboard.addMouseListener(new PanelButtonMouseAdapter(dashboard));
		
		
		
		final JLabel X = new JLabel("X");
		X.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Do you want to close application","Confirm",JOptionPane.YES_NO_OPTION)==0) {
					X.setForeground(Color.RED);
					D.dispose();
									
				}
				//System.exit(0);
			}
				@Override
				public void mouseEntered(MouseEvent arg0) {
					X.setForeground(Color.RED);
					
				}
				@Override
				public void mouseExited(MouseEvent arg0) {
					X.setForeground(Color.WHITE);
				}
				
				
			
		});
		X.setForeground(Color.WHITE);
		X.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		X.setBounds(1514, 0, 26, 21);
		D.getContentPane().add(X);
		
		
			

		main.setLayout(null);
		
		
		
		
		main.add(menu);
		menu.setLayout(null);
		main.add(order);
		order.setLayout(null);
		main.add(inventory);
		inventory.setLayout(null);
		main.add(bill);
		bill.setLayout(null);
		main.add(staff);
		staff.setLayout(null);
		main.add(sales);
		setting.setLayout(null);
		main.add(setting);
		
		
		
		
		
		final JLabel exp_month = new JLabel("");
		exp_month.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				inventory.setVisible(true);
				inventory.show_expire(30);
			}
		});
		exp_month.setFont(new Font("Tahoma", Font.PLAIN, 22));
		exp_month.setBounds(954, 535, 114, 27);
		main.add(exp_month);
		
		final JLabel exp_week = new JLabel("");
		exp_week.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				inventory.setVisible(true);
				inventory.show_expire(7);
			}
		});
		exp_week.setFont(new Font("Tahoma", Font.PLAIN, 22));
		exp_week.setBounds(954, 590, 114, 27);
		main.add(exp_week);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 128, 128));
		panel_1.setBounds(56, 30, 140, 105);
		main.add(panel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Total Employee");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(10, 59, 119, 36);
		panel_1.add(lblNewLabel_2);
		
		JLabel total_employee = new JLabel((String) null);
		total_employee.setFont(new Font("Tahoma", Font.PLAIN, 22));
		total_employee.setBounds(10, 10, 45, 39);
		panel_1.add(total_employee);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(0, 128, 128));
		panel_1_1.setBounds(243, 30, 140, 105);
		main.add(panel_1_1);
		
		JLabel present_today = new JLabel("present Today");
		present_today.setFont(new Font("Tahoma", Font.PLAIN, 17));
		present_today.setBounds(10, 59, 119, 36);
		panel_1_1.add(present_today);
		
		JLabel present_employee = new JLabel((String) null);
		present_employee.setFont(new Font("Tahoma", Font.PLAIN, 22));
		present_employee.setBounds(10, 10, 45, 39);
		panel_1_1.add(present_employee);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(0, 128, 128));
		panel_2.setBounds(431, 30, 140, 105);
		main.add(panel_2);
		
		JLabel asdhf = new JLabel("On Leave");
		asdhf.setFont(new Font("Tahoma", Font.PLAIN, 17));
		asdhf.setBounds(10, 59, 119, 36);
		panel_2.add(asdhf);
		
		JLabel on_leave = new JLabel((String) null);
		on_leave.setFont(new Font("Tahoma", Font.PLAIN, 22));
		on_leave.setBounds(10, 10, 45, 39);
		panel_2.add(on_leave);
		sales.setLayout(null);
		

        try {
     	   int i= 0,j = 0;
     	   Connection con = null;
			 	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_management?autoReconnect=false&useSSL=false","root","Iloveyou@Raa");
			    Statement Stmt = null;
			    Stmt = (Statement) con.createStatement();
			
			ResultSet rs = null;
			 rs = Stmt.executeQuery("SELECT no_of_table from tableno ");
			 rs.next();
			 int table_no = Integer.parseInt(rs.getString(1));
			 int k = 1;
//			 System.out.println(rs.getString(1));
				   for( i = 0; i<9;i++)
				   {
					   for(  j = 0 ;j<7;j++)
					   {
						   JLabel tbl = new JLabel("");
						   tbl.setBackground(Color.GREEN);
							tbl.setOpaque(true);
							 tbl.setIcon(new ImageIcon("icons/chair (1).png"));
							 
							tbl.setBounds(150+85*j, 220+80*i, 50, 50);
							main.add(tbl);
							
							JLabel tbl_no = new JLabel("");
							tbl_no.setFont(new Font("Tahoma", Font.PLAIN, 21));
							tbl_no.setBounds(165+85*j, 270+80 *i, 41, 31);
							main.add(tbl_no);
							tbl_no.setText(Integer.toString(k));
							  
							
							rs = Stmt.executeQuery("select table_no from temp_order where table_no = '"+k+"'");
							if(rs.next()== true)
							{
								tbl.setBackground(Color.red);
							}
							
							k++;
							if( k > table_no)
							{
							break;	
							}
							
				   }
					   if(table_no < k)
						{
							break;
						}
				   }
				   JLabel tbl_no = new JLabel("");
					tbl_no.setFont(new Font("Tahoma", Font.PLAIN, 26));
					tbl_no.setBounds(165+85+9, 270+80 *(i+1), 300, 31);
					main.add(tbl_no);
					tbl_no.setText("Table Management");
					
			 
        			}
        			catch(Exception er)
        			{
        				er.printStackTrace();
        			}
		
		
		
           try {
 			  Statement stmt = null;
 			  Connection con = null;
 			  Class.forName("com.mysql.cj.jdbc.Driver");
 				 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_management?autoReconnect=true&useSSL=false","root","Iloveyou@Raa");
 				stmt = (Statement) con.createStatement();
 				 ResultSet rs = stmt.executeQuery("select count(empid) from employee");
 				rs.next();
 				total_employee.setText(rs.getString(1));
 				
 				rs =stmt.executeQuery("select count(empId) from attendance where status = 1 and date = curdate()");
 				rs.next();
 				present_employee.setText(rs.getString(1));
 				rs = stmt.executeQuery("select count(empid) from attendance where `leave` = 1 and date = curdate()");
 			    rs.next();
 			    on_leave.setText(rs.getString(1));
 			   
 			    
 			    JLabel lblNewLabel_3 = new JLabel("Date:");
 			    lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
 			    lblNewLabel_3.setBounds(1011, 10, 221, 31);
 			    main.add(lblNewLabel_3);
 			   lblNewLabel_3.setText(lblNewLabel_3.getText()+date);
 				lblNewLabel_3.setText(removeSubstring(lblNewLabel_3.getText(),16,28));
 				
 				JLabel tbl_no = new JLabel("Daily Payout:");
 				tbl_no.setFont(new Font("Tahoma", Font.PLAIN, 22));
 				tbl_no.setBounds(779, 213, 145, 31);
 				main.add(tbl_no);
 				
 				JLabel tbl_no_1 = new JLabel("Weekly Payout: ");
 				tbl_no_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
 				tbl_no_1.setBounds(779, 264, 161, 31);
 				main.add(tbl_no_1);
 				
 				JLabel tbl_no_1_1 = new JLabel("Reserved Tables: ");
 				tbl_no_1_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
 				tbl_no_1_1.setBounds(779, 318, 178, 31);
 				main.add(tbl_no_1_1);
 				
 				
 				final JLabel reserved = new JLabel("");
 				reserved.setFont(new Font("Tahoma", Font.PLAIN, 22));
 				reserved.setBounds(967, 318, 178, 31);
 				main.add(reserved);
 				
 				final JLabel wkly = new JLabel("");
 				wkly.setFont(new Font("Tahoma", Font.PLAIN, 22));
 				wkly.setBounds(942, 264, 212, 31);
 				main.add(wkly);
 				
 				final JLabel dly = new JLabel("");
 				dly.setFont(new Font("Tahoma", Font.PLAIN, 22));
 				dly.setBounds(922, 213, 178, 31);
 				main.add(dly);
 			    
 				JLabel tbl_no_1_1_1 = new JLabel("Expiring  products");
                tbl_no_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
                tbl_no_1_1_1.setBounds(779, 493, 178, 31);
                main.add(tbl_no_1_1_1);
                
                JLabel tbl_no_1_1_1_1 = new JLabel("In a month: ");
                tbl_no_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
                tbl_no_1_1_1_1.setBounds(819, 535, 126, 27);
                main.add(tbl_no_1_1_1_1);
                
                JLabel tbl_no_1_1_1_2 = new JLabel("In a week :");
                tbl_no_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
                tbl_no_1_1_1_2.setBounds(819, 590, 114, 27);
                main.add(tbl_no_1_1_1_2);
 				
 				rs = stmt.executeQuery("select sum(total) from restaurant_management.order where order_date = curdate() ");
				rs.next();
				dly.setText("RS. "+rs.getString(1));
				rs = stmt.executeQuery("select sum(total) from restaurant_management.order where order_date > current_date - interval 7 day ");
				rs.next();
				wkly.setText("Rs. "+rs.getString(1));
 			    rs = stmt.executeQuery("select count( distinct table_no) from temp_order");
                 rs.next();
                 reserved.setText(rs.getString(1));
                 
                 rs  = stmt.executeQuery("select count(ItemId) from inventory where expiry_date <= current_date + interval 7 day");
                 rs.next();
                 exp_week.setText(rs.getString(1));
                 
                rs  = stmt.executeQuery("select count(ItemId) from inventory where expiry_date <= current_date + interval 30 day");
                 rs.next();
                 exp_month.setText(rs.getString(1)); 
                 
 			    // creating a new object of the class Date  
 			    
 			    
 			    
// 				  long millis=System.currentTimeMillis();  
// 			      
// 				    // creating a new object of the class Date  
// 				    java.sql.Date date = new java.sql.Date(millis);  
 				    
 		  }
 			catch(Exception t)
 		  {
 				t.printStackTrace();		  }
 			   
 				    
				
	}
	
	



	public void menuClicked(JPanel panel) {
		menu.setVisible(false);
		order.setVisible(false);
		inventory.setVisible(false);
		staff.setVisible(false);
		sales.setVisible(false);
		bill.setVisible(false);
		setting.setVisible(false);
		
		panel.setVisible(true);
	}
	

	

private class PanelButtonMouseAdapter extends MouseAdapter{
		
		
		JPanel panel;
		public PanelButtonMouseAdapter(JPanel panel) {
			this.panel=panel;
		}
		
		
		@Override
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(Color.CYAN);
			
		}
		@Override
		public void mouseExited(MouseEvent e) {
			panel.setBackground(Color.WHITE);
			
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			panel.setBackground(Color.CYAN);
			
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(Color.CYAN);
			
		}
		
		
}
}