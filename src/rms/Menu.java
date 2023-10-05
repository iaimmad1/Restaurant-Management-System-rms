package rms;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.ImageIcon;

public class Menu extends JPanel {
	private JTextField name;
	private JTextField price;
	private JTextField Search;
	private JTable table;
	private JLabel lblNewLabel_1;
	private m_cat c;
	private int cat_clicked = 0;
	private int flag = 0;
	

	
	
	/**
	 * Create the panel.
	 */
	public Menu() {
		
		setBackground(new Color(0, 128, 128));
		setBounds(255, 11,1610, 1058);
	
		setLayout(null);
		
		final JPanel contentPane = new JPanel();
		contentPane.setBounds(198, 81, 1127, 755);
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		add(contentPane);
		
		
		final m_cat	c= new m_cat();
		c.setBackground(new Color(0, 128, 128));
		c.setBounds(50, 20, 854, 577);
		
		c.setVisible(false);
		
         
		final JComboBox category = new JComboBox();
		category.setBackground(Color.WHITE);
		category.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(cat_clicked == 1)
				{
				category.removeAllItems();
				
				cat_clicked = 0;
				try {
					 Connection con = null;
					 	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_management?autoReconnect=true&useSSL=false","root","Iloveyou@Raa");
					    Statement Stmt = null;
					    Stmt = (Statement) con.createStatement();
					
					ResultSet rs = null;
					 rs = Stmt.executeQuery("SELECT Category FROM food_Category ");

					 while(rs.next()) {
						category.addItem(rs.getString(1)); 
					 }
					}
					 
						catch(Exception ee)
					{
						ee.printStackTrace();	
					}
				
				}
			}
		});
		
		
		
		
		category.setToolTipText("enter category");
		category.setFont(new Font("Tahoma", Font.PLAIN, 17));
		category.removeAllItems();
		try {
			 Connection con = null;
			 	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_management?autoReconnect=true&useSSL=false","root","Iloveyou@Raa");
			    Statement Stmt = null;
			    Stmt = (Statement) con.createStatement();
			
			ResultSet rs = null;
			 rs = Stmt.executeQuery("SELECT Category FROM food_Category ");

			 while(rs.next()) {
				category.addItem(rs.getString(1)); 
			 }
			}
			 
				catch(Exception ee)
			{
				ee.printStackTrace();	
			}
		
		JButton btnManage = new JButton("MANAGE CATEGORY");
		btnManage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cat_clicked = 1;
				c.setVisible(true);
				
				
			}
		});
		btnManage.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnManage.setBounds(91, 707, 234, 38);
		contentPane.add(btnManage);
		
	   
		
		JLabel lblNewLabel_1_1 = new JLabel("NAME:");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_1.setBounds(63, 171, 78, 30);
		contentPane.add(lblNewLabel_1_1);
		category.setBounds(527, 201, 160, 38);
		contentPane.add(category);
	
		
		
		
		category.setSelectedIndex(-1);
		
		JLabel lblNewLabel = new JLabel("Manage Items");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(520, 32, 188, 47);
		contentPane.add(lblNewLabel);
		
		name = new JTextField();
		name.setBackground(Color.WHITE);
		name.setToolTipText("Enter food name");
		name.setFont(new Font("Tahoma", Font.PLAIN, 17));
		name.setColumns(10);
		name.setBounds(147, 168, 167, 38);
		contentPane.add(name);
		
		price = new JTextField();
		price.setBackground(Color.WHITE);
		price.setFont(new Font("Tahoma", Font.PLAIN, 17));
		price.setColumns(10);
		price.setBounds(520, 121, 167, 38);
		contentPane.add(price);
		
		Search = new JTextField();
		Search.setBackground(Color.WHITE);
		Search.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				try {
					if( flag == 0)
					{
				    Connection con = null;
				 	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_management?autoReconnect=true&useSSL=false","root","Iloveyou@Raa");
				    Statement Stmt = null;
				    Stmt = (Statement) con.createStatement();
				
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				ResultSet rs = null;
				 rs = Stmt.executeQuery("SELECT f.food_name,f.price,c.Category FROM  food f inner join food_Category c on f.cid = c.cid where food_name like'"+Search.getText()+"%' or food_name like'%"+Search.getText()+"' or food_name like'%"+Search.getText()+"%' ");
				ResultSetMetaData restaurant_management = (ResultSetMetaData) rs.getMetaData();
				int col = restaurant_management.getColumnCount();	
				String [] colname = new String[col];
				
				for(int i= 0;i<col;i++)
				{
					colname[i] = restaurant_management.getColumnName(i+1);
					model.setColumnIdentifiers(colname);
				}
			
				
				int rows=model.getRowCount();
				System.out.println(" "+rows);
					
					while(rows>0) {
						rows--;
						model.removeRow(rows);
					}
 
		
				while(rs.next()) {
				String[] row = {rs.getString(1),rs.getString(2),rs.getString(3)};
				model.addRow(row);
				}
					}
				}
				
				
	        
				catch (SQLException e2) {
					e2.printStackTrace();
				}
				};
			
			@Override
			public void keyPressed(KeyEvent e) {
				
				 if (e.getKeyCode()==40)
				    {
					 System.out.println("i clicked up in search text box");
					
					 DefaultTableModel model = (DefaultTableModel)table.getModel();
					 table.setRowSelectionInterval(table.getSelectedRow()+1, table.getSelectedRow()+1);
						price.setText(model.getValueAt(table.getSelectedRow()+1,1).toString());
						name.setText(model.getValueAt(table.getSelectedRow()+1,0).toString());
						category.setSelectedItem(model.getValueAt(table.getSelectedRow()+1,2).toString());
					flag = 1;
				                //up arrow key code
				    }

				    else if (e.getKeyCode()==38)
				    { System.out.println("i clicked down in search text box");
				    
				    	 DefaultTableModel model = (DefaultTableModel)table.getModel();
				    	 table.setRowSelectionInterval(table.getSelectedRow()-1, table.getSelectedRow()-1);
							price.setText(model.getValueAt(table.getSelectedRow()-1,1).toString());
							name.setText(model.getValueAt(table.getSelectedRow()-1,0).toString());
							category.setSelectedItem(model.getValueAt(table.getSelectedRow()-1,2).toString());
						flag = 1;
				                //down arrow key code
				    }
				    else {
				    	flag = 0;
				    }
			}
		});
		Search.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Search.setColumns(10);
		Search.setBounds(824, 121, 167, 38);
		contentPane.add(Search);
		
		
		JLabel lblNewLabel_1_3 = new JLabel("PRICE");
		lblNewLabel_1_3.setForeground(Color.BLACK);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_3.setBounds(396, 124, 99, 30);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("CATEGORY");
		lblNewLabel_1_4.setForeground(Color.BLACK);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_4.setBounds(366, 201, 99, 30);
		contentPane.add(lblNewLabel_1_4);
		
		JButton SAVE = new JButton("   SAVE");
		SAVE.setBackground(new Color(0, 128, 128));
		SAVE.setIcon(new ImageIcon("icons/Save-icon.png"));
		//SAVE.setIcon(new ImageIcon(Menu.class.getResource("/icons/Save-icon.png")));
		SAVE.setHorizontalAlignment(SwingConstants.LEFT);
		SAVE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//id = Integer.parseInt(ItemID.getText());
				
				Connection con = null;
				Statement Stmt = null;
					
				try {
					
					if(name.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null, "Enter Details of Item ");
					}else 
					{
				
					Class.forName("com.mysql.cj.jdbc.Driver");
					 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_management?autoReconnect=true&useSSL=false","root","Iloveyou@Raa");
					Stmt = (Statement) con.createStatement();
					try {
					Stmt.executeUpdate( "INSERT  INTO food_category (Category)values('"+category.getSelectedItem().toString()+"') ");
					}
					catch(Exception e3)
					{
						System.out.println("you have already inserted category.getSelectedItem().toString() ");
						
					}
					
					
					
					ResultSet rs;
					rs = Stmt.executeQuery("SELECT max(CID) FROM FOOD_CATEGORY where Category = '"+category.getSelectedItem().toString()+"'");
					int cid =0;
				while(	rs.next())
				{
					cid =Integer.parseInt(rs.getString(1));
				}
					System.out.println("the cid is "+cid);
					int flag = 0;
					try {
					Stmt.executeUpdate("INSERT INTO food values ( '"+name.getText()+"', '"+Float.parseFloat(price.getText())+"','"+cid+"')");
					}
					catch(Exception ex)
					{
						final JDialog dialog = new JDialog();
						dialog.setAlwaysOnTop(true);    
						JOptionPane.showMessageDialog(dialog, "Duplicate entry for food name!","error",JOptionPane.INFORMATION_MESSAGE);
						name.setText(null);
						price.setText(null);
						flag = 1;
						
					 
					}
					
					 rs = Stmt.executeQuery("SELECT f.food_name,f.price,c.Category FROM  food f inner join food_Category c on f.cid = c.cid  ");
					ResultSetMetaData restaurant_management = (ResultSetMetaData) rs.getMetaData();
					DefaultTableModel model = (DefaultTableModel)table.getModel();
					int col = restaurant_management.getColumnCount();	
					String [] colname = new String[col];
					
					int rows=model.getRowCount();
						
						while(rows>0) {
							rows--;
							model.removeRow(rows);
						}
					for(int i= 0;i<col;i++)
					{
						colname[i] = restaurant_management.getColumnName(i+1);
						model.setColumnIdentifiers(colname);
					}
				 int   rows1 = 0;
					while(rs.next()) {
					String[] row = {rs.getString(1),rs.getString(2), rs.getString(3)};//name,price,category
					model.addRow(row);
				    rows1++;
					if(rs.getString(1).equals(name.getText()))
					{
				       
					
					table.addRowSelectionInterval(rows1-1,rows1-1);
				      table.setBackground(Color.white);
				     // table.setForeground(Color.BLUE);
					
					}
					
					}

					
					
					if( flag ==0)
					{
						JOptionPane pane = new JOptionPane("inserted", JOptionPane.INFORMATION_MESSAGE);
		                final JDialog dialog = pane.createDialog(null, "Title");
		                dialog.setModal(false);
		                dialog.setVisible(true);

		                new Timer(1000, new ActionListener() {
		                    @Override
		                    public void actionPerformed(ActionEvent e) {
		                        dialog.setVisible(false);
		                    }
		                }).start();
					}
					
					
				}		
				}
					catch(Exception e1) {
						e1.printStackTrace();
						
						
					}
				
				
				
				
			
			}
		});
		SAVE.setFont(new Font("Tahoma", Font.PLAIN, 17));
		SAVE.setBounds(63, 296, 133, 38);
		contentPane.add(SAVE);
		
		JButton edit = new JButton("   DELETE");
		edit.setBackground(new Color(0, 128, 128));
		edit.setIcon(new ImageIcon("icons/Trash-Delete-Icon.png"));
		//edit.setIcon(new ImageIcon(Menu.class.getResource("/icons/Trash-Delete-icon.png")));
		edit.setHorizontalAlignment(SwingConstants.LEFT);
		edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try { 
					if(name.getText().equals(""))
					{
						JOptionPane pane = new JOptionPane("Enter the food name to be deletd", JOptionPane.ERROR_MESSAGE);
		                final JDialog dialog = pane.createDialog(null, "Title");
		                dialog.setModal(false);
		                dialog.setVisible(true);

		                new Timer(2000, new ActionListener() {
		                    @Override
		                    public void actionPerformed(ActionEvent e) {
		                        dialog.setVisible(false);
		                    }
		                }).start();
					}
					else {
					int op;
					final JDialog dialog = new JDialog();
					dialog.setAlwaysOnTop(true);    
					 op = JOptionPane.showConfirmDialog(dialog, "Are you sure to delete", "DELETE", JOptionPane.YES_NO_OPTION);
					 
					if(op ==0) {
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_management?autoReconnect=true&useSSL=false","root","Iloveyou@Raa");
					Statement Stmt = (Statement) con.createStatement();
					Stmt.executeUpdate("Delete from FOOD  where food_name = '"+name.getText()+"'");
					ResultSet rs = null;
					category.setSelectedItem(null);name.setText(null);
					price.setText(null);
					rs = Stmt.executeQuery("SELECT f.food_name,f.price,c.Category FROM  food f inner join food_Category c on f.cid = c.cid  ");
					JOptionPane pane2 = new JOptionPane(name.getText()+ "  Deleted", JOptionPane.INFORMATION_MESSAGE);
	               final JDialog dialog1 = pane2.createDialog(null, "Title");
	                dialog1.setModal(false);
	                dialog1.setVisible(true);

	                new Timer(2000, new ActionListener() {
	                    @Override
	                    public void actionPerformed(ActionEvent e) {
	                        dialog1.setVisible(false);
	                    }
	                }).start();
					 
					
					
					//refresh the table after data is deleted
	                DefaultTableModel model = (DefaultTableModel)table.getModel();
					ResultSetMetaData restaurant_management = (ResultSetMetaData) rs.getMetaData();
					int col = restaurant_management.getColumnCount();	
					String [] colname = new String[col];
					
					int rows=model.getRowCount();
					
					while(rows>0) {
						rows--;
						model.removeRow(rows);
					}
					for(int i= 0;i<col;i++)
					{
						colname[i] = restaurant_management.getColumnName(i+1);
						model.setColumnIdentifiers(colname);
					}
					
					while(rs.next()) {
						String[] row = {rs.getString(1),rs.getString(2),rs.getString(3)};
						model.addRow(row);
						}
					}
					
					}
				}
					catch(Exception ex1)
					{
						ex1.printStackTrace();
					}
			}
		});
		edit.setFont(new Font("Tahoma", Font.PLAIN, 17));
		edit.setBounds(242, 296, 133, 38);
		contentPane.add(edit);
		
		JButton Del = new JButton(" UPDATE");
		Del.setBackground(new Color(0, 128, 128));
		Del.setIcon(new ImageIcon("icons/Reload-icon.png"));
		
		Del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					
					
					if(name.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null, "Enter Name of Item ");
					}else 
					{
					
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_management?autoReconnect=true&useSSL=false","root","Iloveyou@Raa");
				Statement Stmt = (Statement) con.createStatement();
				ResultSet rs = null;
				rs = Stmt.executeQuery("select price from food where food_name = '"+name.getText()+"'");
				rs.next();
				
				if(rs.getString(1).equals(price.getText().toString())) {
					 JOptionPane pane = new JOptionPane("Food price is same", JOptionPane.WARNING_MESSAGE);
		                final JDialog dialog = pane.createDialog(null, "Title");
		                dialog.setModal(false);
		                dialog.setVisible(true);

		                new Timer(1000, new ActionListener() {
		                    @Override
		                    public void actionPerformed(ActionEvent e) {
		                        dialog.setVisible(false);
		                    }
		                }).start();
				}
				else {
				
				Stmt.executeUpdate("UPDATE FOOD set price ='"+Float.parseFloat(price.getText())+"' where food_name = '"+name.getText()+"'");
				JOptionPane pane = new JOptionPane("Updated", JOptionPane.INFORMATION_MESSAGE);
                final JDialog dialog = pane.createDialog(null, "Title");
                dialog.setModal(false);
                dialog.setVisible(true);

                new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dialog.setVisible(false);
                    }
                }).start();
				 rs = Stmt.executeQuery("SELECT f.food_name,f.price,c.Category FROM  food f inner join food_Category c on f.cid = c.cid  ");
				 DefaultTableModel model = (DefaultTableModel)table.getModel();
					ResultSetMetaData restaurant_management = (ResultSetMetaData) rs.getMetaData();
					int col = restaurant_management.getColumnCount();	
					String [] colname = new String[col];
					
					int rows=model.getRowCount();
					
					while(rows>0) {
						rows--;
						model.removeRow(rows);
					}
					for(int i= 0;i<col;i++)
					{
						colname[i] = restaurant_management.getColumnName(i+1);
						model.setColumnIdentifiers(colname);
					}
					
					while(rs.next()) {
						String[] row = {rs.getString(1),rs.getString(2),rs.getString(3)};
						model.addRow(row);
						}
				 
				}
				
				
				}
				}
				catch(Exception ex1)
				{
					ex1.printStackTrace();
				}
			}
				
		});
		Del.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Del.setBounds(423, 296, 160, 38);
		contentPane.add(Del);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.setBackground(new Color(0, 128, 128));
		btnClear.setIcon(new ImageIcon("icons/clear.png"));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name.setText(null);
				price.setText(null);
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				int rows=model.getRowCount();
					
					while(rows>0) {
						rows--;
						model.removeRow(rows);
					}
					category.setSelectedItem(null);
				
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnClear.setBounds(646, 296, 133, 38);
		contentPane.add(btnClear);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("SEARCH");
		lblNewLabel_1_3_1.setForeground(Color.BLACK);
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_3_1.setBounds(732, 124, 83, 30);
		contentPane.add(lblNewLabel_1_3_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 344, 960, 320);
		contentPane.add(scrollPane);
		
		table = new JTable() {
		
		
			private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int row,int column) {
			return false;
		};
		};
		table.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				 if (e.getKeyCode()==38)
				    {
					 DefaultTableModel model = (DefaultTableModel)table.getModel();
						price.setText(model.getValueAt(table.getSelectedRow(),1).toString());
						name.setText(model.getValueAt(table.getSelectedRow(),0).toString());
						category.setSelectedItem(model.getValueAt(table.getSelectedRow(),2).toString());
					
				                //up arrow key code
				    }

				    else if (e.getKeyCode()==40)
				    {
				    	 DefaultTableModel model = (DefaultTableModel)table.getModel();
							price.setText(model.getValueAt(table.getSelectedRow(),1).toString());
							name.setText(model.getValueAt(table.getSelectedRow(),0).toString());
							category.setSelectedItem(model.getValueAt(table.getSelectedRow(),2).toString());
						
				                //down arrow key code
				    }
			}
		});
		table.setShowGrid(false);
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				
				
				price.setText(model.getValueAt(table.getSelectedRow(),1).toString());
				name.setText(model.getValueAt(table.getSelectedRow(),0).toString());
				category.setSelectedItem(model.getValueAt(table.getSelectedRow(),2).toString());
			}
		});
		scrollPane.setViewportView(table);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(new Color(0, 128, 128));
		lblNewLabel_1.setBounds(0, 0, 1127, 771);
		contentPane.add(lblNewLabel_1);
		
		
		
			}


	
	
}
