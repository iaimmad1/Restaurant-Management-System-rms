package rms;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.DropMode;
import javax.swing.ImageIcon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import com.toedter.calendar.JDateChooser;

public class Inventoryy extends JPanel {
	private JTextField batch;
	private JTextField price;
	private JTextField name;
	private JTextField brand;
	private JTextField vendor;
	private JTextField search;
	private JTable table;
	private ButtonGroup bg = new ButtonGroup();
	public void show_expire(int a)
	{
		try {
			Connection con = null;
			Statement Stmt = null;
				
			
			
				Class.forName("com.mysql.cj.jdbc.Driver");
				 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_management?autoReconnect=true&useSSL=false","root","Iloveyou@Raa");
				Stmt = (Statement) con.createStatement();
				ResultSet rs = Stmt.executeQuery("select * from inventory where expiry_date <= current_date + interval '"+a+"' day");
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				while(rs.next()) {
					String[] row = {rs.getString(1),rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5), rs.getString(6),rs.getString(7),rs.getString(8), rs.getString(9),rs.getString(10)};//name,price,category
					model.addRow(row);
				    
					
					}
				
				
		}
		catch(Exception er)
		{
			er.printStackTrace();
		}
	}

	/**
	 * Create the panel.
	 */
	public Inventoryy() {
		setBackground(new Color(0, 128, 128));
		

		setBounds(255, 11, 1350, 800);
		setLayout(null);
		
		final JLabel item = new JLabel("");
		item.setBounds(149, 211, 85, 41);
		item.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(item);
		
		
		final JDateChooser expiry = new JDateChooser();
		expiry.setBackground(new Color(0, 128, 128));
		expiry.setBounds(974, 331, 231, 33);
		expiry.setDateFormatString("yyyy-MM-dd");
		add(expiry);
		
		final JSpinner quantity = new JSpinner();
		quantity.setBackground(Color.WHITE);
		quantity.setBounds(145, 272, 231, 28);
		quantity.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		add(quantity);
		
		final JDateChooser mfg = new JDateChooser();
		mfg.setBackground(new Color(0, 128, 128));
		mfg.setBounds(535, 327, 231, 33);
		mfg.setDateFormatString("yyyy-MM-dd");
		add(mfg);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 499, 1192, 291);
		add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 DefaultTableModel model = (DefaultTableModel)table.getModel();
				 price.setText(model.getValueAt(table.getSelectedRow(),4).toString());
					name.setText(model.getValueAt(table.getSelectedRow(),1).toString());
					item.setText(model.getValueAt(table.getSelectedRow(),0).toString());
					brand.setText(model.getValueAt(table.getSelectedRow(),2).toString());
					quantity.setValue(Integer.parseInt(model.getValueAt(table.getSelectedRow(),3).toString()));
					vendor.setText(model.getValueAt(table.getSelectedRow(),5).toString());
					batch.setText(model.getValueAt(table.getSelectedRow(),6).toString());
					java.util.Date date;
					try {
						date =  new SimpleDateFormat("yyyy-MM-dd").parse( (model.getValueAt(table.getSelectedRow(),7 ).toString()));
						mfg.setDate(date);
						 date =  new SimpleDateFormat("yyyy-MM-dd").parse( (model.getValueAt(table.getSelectedRow(),8 ).toString()));
							expiry.setDate(date);
					} catch (ParseException e1) {
						
						e1.printStackTrace();
					}
					
					
					
					
					
					
					
					
			}
		});
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "name", "brand", "Qty", "price", "vendor", "batch no", "Mfd. date", "Exp_date", "Total"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true, true, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		final JRadioButton indate = new JRadioButton("In Date");
		indate.setBackground(new Color(0, 128, 128));
		indate.setBounds(1093, 370, 103, 21);
		indate.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(indate);
		final JRadioButton inmonth = new JRadioButton("In Months");
		inmonth.setBackground(new Color(0, 128, 128));
		inmonth.setBounds(974, 370, 103, 21);
		
		
		
		
		
		
		inmonth.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(inmonth);
		
		JLabel lblNewLabel = new JLabel("Inventory");
		lblNewLabel.setBounds(420, 11, 521, 114);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 99));
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Item No. :");
		lblNewLabel_1.setBounds(33, 211, 85, 41);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Quantity :");
		lblNewLabel_1_1.setBounds(33, 263, 85, 41);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Brand Name:");
		lblNewLabel_1_1_1.setBounds(826, 211, 115, 41);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Name :");
		lblNewLabel_1_2.setBounds(420, 211, 74, 41);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Expiry Date :");
		lblNewLabel_1_1_1_1.setBounds(848, 327, 110, 41);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Batch No. :");
		lblNewLabel_1_2_1.setBounds(36, 327, 96, 41);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_3 = new JLabel("Price :");
		lblNewLabel_1_3.setBounds(420, 263, 74, 41);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("MFD. Date :");
		lblNewLabel_1_1_2.setBounds(420, 327, 105, 41);
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblNewLabel_1_1_2);
		
		batch = new JTextField();
		batch.setBackground(Color.WHITE);
		batch.setBounds(145, 336, 231, 28);
		batch.setColumns(10);
		add(batch);
		
		price = new JTextField();
		price.setBackground(Color.WHITE);
		price.setBounds(535, 272, 231, 28);
		price.setColumns(10);
		add(price);
		
		name = new JTextField();
		name.setBackground(Color.WHITE);
		name.setBounds(535, 220, 231, 28);
		name.setColumns(10);
		add(name);
		
		brand = new JTextField();
		brand.setBackground(Color.WHITE);
		brand.setBounds(974, 220, 231, 28);
		brand.setColumns(10);
		add(brand);
		
		vendor = new JTextField();
		vendor.setBackground(Color.WHITE);
		vendor.setBounds(974, 272, 231, 28);
		vendor.setColumns(10);
		add(vendor);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("Vendor :");
		lblNewLabel_1_1_2_1.setBounds(848, 263, 74, 41);
		lblNewLabel_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblNewLabel_1_1_2_1);
		
		JButton btnNewButton = new JButton("SAVE");		
		btnNewButton.setBackground(new Color(0, 128, 128));
		btnNewButton.setIcon(new ImageIcon("icons/Save-icon.png"));
		btnNewButton.setBounds(126, 420, 149, 41);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				

				Connection con = null;
				Statement Stmt = null;
					
				try {
					
					if(name.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null, "Enter Name of Item ");
					}else 
					{
					
					
					
				
					Class.forName("com.mysql.cj.jdbc.Driver");
					 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_management","root","Iloveyou@Raa");
					Stmt = (Statement) con.createStatement();
					int total = (int) quantity.getValue() * Integer.parseInt(price.getText()) ;
				if(indate.isSelected())
				{
				
				
					Stmt.executeUpdate( "INSERT  INTO inventory (name,brand,quantity,price,vendor,batch_no,mfg_date,expiry_date,total) values('"+name.getText()+"','"+brand.getText()+"','"+quantity.getValue()+"','"+Float.parseFloat(price.getText())+"','"+vendor.getText()+"','"+batch.getText()+"','"+((JTextField) (mfg.getDateEditor().getUiComponent())).getText()+"','"+((JTextField) (expiry.getDateEditor().getUiComponent())).getText()+"','"+total+"' ) ");
				}
				else if(inmonth.isSelected())
				{
					Stmt.executeUpdate( "INSERT  INTO inventory  (name,brand,quantity,price,vendor,batch_no,mfg_date,expiry_date,total)  values('"+name.getText()+"','"+brand.getText()+"','"+quantity.getValue()+"','"+Float.parseFloat(price.getText())+"','"+vendor.getText()+"','"+batch.getText()+"','"+((JTextField) (mfg.getDateEditor().getUiComponent())).getText()+"', '"+((JTextField) (mfg.getDateEditor().getUiComponent())).getText()+"'+ interval  '"+(Integer.parseInt(((JTextField) (expiry.getDateEditor().getUiComponent())).getText()))+"' month,'"+total+"') ");
	
				}
					
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
                item.setText(Integer.toString(Integer.parseInt(item.getText())+1));
					
					ResultSet rs = null;
					rs = Stmt.executeQuery(" select * from inventory");
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
						String[] row = {rs.getString(1),rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5), rs.getString(6),rs.getString(7),rs.getString(8), rs.getString(9),rs.getString(10)};//name,price,category
						model.addRow(row);
					    rows1++;
						if(rs.getString(1).equals(item.getText()))
						{
					       
						
						table.addRowSelectionInterval(rows1-1,rows1-1);
					      table.setBackground(Color.white);
					     // table.setForeground(Color.BLUE);
						
						}
					
			
				
						}
		
				
				}
						
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
					
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		add(btnNewButton);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.setBackground(new Color(0, 128, 128));
		btnClear.setIcon(new ImageIcon("icons/clear.png"));
		btnClear.setBounds(353, 420, 149, 41);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				name.setText(null);
				brand.setText(null);
				quantity.setValue(0);
				price.setText(null);
				vendor.setText(null);
				batch.setText(null);
				mfg.setCalendar(null);
				expiry.setCalendar(null);
				
				
				
				
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 18));
		add(btnClear);
		
		JButton btnNewButton_1_1 = new JButton("DELETE");
		btnNewButton_1_1.setBackground(new Color(0, 128, 128));
		btnNewButton_1_1.setIcon(new ImageIcon("icons/Trash-Delete-Icon.png"));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					
					
					if(name.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null, "Enter Name of Item ");
					}else 
					{
					
					
					
					int op;
					final JDialog d = new JDialog();
					d.setAlwaysOnTop(true);    
					 op = JOptionPane.showConfirmDialog(d, "Are you sure to delete", "DELETE", JOptionPane.YES_NO_OPTION);
					 
					if(op ==0) {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_management?autoReconnect=true&useSSL=false","root","Iloveyou@Raa");
					Statement Stmt = (Statement) con.createStatement();
					
					Stmt.executeUpdate("delete from inventory where itemid = '"+Integer.parseInt(item.getText())+"'");
					
					JOptionPane pane = new JOptionPane("Deleted", JOptionPane.INFORMATION_MESSAGE);
	                final JDialog dialog = pane.createDialog(null, "Title");
	                dialog.setModal(false);
	                dialog.setVisible(true);

	                new Timer(1000, new ActionListener() {
	                    @Override
	                    public void actionPerformed(ActionEvent e) {
	                        dialog.setVisible(false);
	                    }
	                }).start();
	                ResultSet rs = null;
					
					rs = Stmt.executeQuery(" select * from inventory");
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
					String[] row = {rs.getString(1),rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5), rs.getString(6),rs.getString(7),rs.getString(8), rs.getString(9),rs.getString(10)};//name,price,category
					model.addRow(row);
				    rows1++;
					if(rs.getString(1).equals(item.getText()))
					{
				       
					
					table.addRowSelectionInterval(rows1-1,rows1-1);
				      table.setBackground(Color.white);
				     // table.setForeground(Color.BLUE);
					
					}
				
		
			
					}
					}
				}	
				
			}
				catch(Exception er)
				{
					
				}}
		});
		btnNewButton_1_1.setBounds(797, 420, 149, 41);
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		add(btnNewButton_1_1);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setBackground(new Color(0, 128, 128));
		btnUpdate.setIcon(new ImageIcon("icons/Reload-icon.png"));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Connection con = null;
				Statement Stmt = null;
					
				try {
					
					
					if(name.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null, "Enter Name of Item ");
					}else 
					{
					
					
				
					Class.forName("com.mysql.cj.jdbc.Driver");
					 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_management","root","Iloveyou@Raa");
					Stmt = (Statement) con.createStatement();
					ResultSet rs = null;
					Stmt.executeUpdate("Update inventory set name = '"+name.getText()+"',brand = '"+brand.getText()+"',quantity = '"+quantity.getValue()+"',price = '"+Float.parseFloat(price.getText())+"',vendor = '"+ vendor.getText()+"',batch_no = '"+Integer.parseInt(batch.getText())+"',mfg_date ='"+((JTextField) (mfg.getDateEditor().getUiComponent())).getText()+"'  ,expiry_date = '"+((JTextField) (expiry.getDateEditor().getUiComponent())).getText()+"' where itemid = '"+Integer.parseInt(item.getText())+"'");

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
	                rs = Stmt.executeQuery(" select * from inventory");
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
					String[] row = {rs.getString(1),rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5), rs.getString(6),rs.getString(7),rs.getString(8), rs.getString(9),rs.getString(10)};//name,price,category
					model.addRow(row);
				    rows1++;
					if(rs.getString(1).equals(item.getText()))
					{
				       
					
					table.addRowSelectionInterval(rows1-1,rows1-1);
				      table.setBackground(Color.white);
				     // table.setForeground(Color.BLUE);
					
					}
				
		
			
					}
				
				}
				
				
				
				}
				
				catch(Exception tt)
				{
					tt.printStackTrace();
				}
			}
		});
		btnUpdate.setBounds(570, 420, 149, 41);
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 18));
		add(btnUpdate);
		
		JButton btnViewItems = new JButton("VIEW ITEMS");
		btnViewItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				

				Connection con = null;
				Statement Stmt = null;
					
				try {
					
					
					
					
				
					Class.forName("com.mysql.cj.jdbc.Driver");
					 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_management","root","Iloveyou@Raa");
					Stmt = (Statement) con.createStatement();
						
					
					ResultSet rs = null;
					rs = Stmt.executeQuery(" select * from inventory");
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
						String[] row = {rs.getString(1),rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5), rs.getString(6),rs.getString(7),rs.getString(8), rs.getString(9),rs.getString(10)};//name,price,category
						model.addRow(row);
					    rows1++;
						if(rs.getString(1).equals(item.getText()))
						{
					       
						
						table.addRowSelectionInterval(rows1-1,rows1-1);
					      table.setBackground(Color.white);
					     // table.setForeground(Color.BLUE);
						
						}
					
			
				
						}						
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
					
				}
	
			}
		});
		btnViewItems.setBackground(new Color(0, 128, 128));
		btnViewItems.setBounds(1024, 420, 159, 41);
		btnViewItems.setFont(new Font("Tahoma", Font.BOLD, 18));
		add(btnViewItems);
		
		search = new JTextField();
		search.setBackground(Color.WHITE);
		search.setBounds(974, 168, 231, 28);
		search.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
					try {
						 Connection con = null;
						 	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_management?autoReconnect=true&useSSL=false","root","Iloveyou@Raa");
						    Statement Stmt = null;
						    Stmt = (Statement) con.createStatement();
						
						ResultSet rs = null;
						DefaultTableModel model = (DefaultTableModel)table.getModel();
						 rs = Stmt.executeQuery("SELECT * from restaurant_management.inventory where name like '%"+search.getText()+"' or name like '"+search.getText()+"%' or name like '%"+search.getText()+"%' ");
						 int rows=model.getRowCount();
							JOptionPane pane = new JOptionPane(rows, JOptionPane.INFORMATION_MESSAGE);
			              
								
								while(rows>0) {
									rows--;
									model.removeRow(rows);
								}
								
						 while(rs.next())
						 {
							 String[] row = {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10)};
								model.addRow(row);
						 }
				}
				catch(Exception rt)
				{
					rt.printStackTrace();
				}
			}

		});
		search.setColumns(10);
		add(search);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Search :");
		lblNewLabel_1_1_1_2.setBounds(848, 159, 74, 41);
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblNewLabel_1_1_1_2);
		
		bg.add(inmonth);
		bg.add(indate);
		indate.setSelected(true);
		try {
			ResultSet rs = null;
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_management?autoReconnect=true&useSSL=false","root","Iloveyou@Raa");
		    Statement Stmt = null;
		    Stmt = (Statement) con.createStatement();
		    rs = Stmt.executeQuery("select max(itemid)+1 from inventory");
		    rs.next();
		    String item_id_incremented = rs.getString(1);
		    item.setText(rs.getString(1));
		}
		catch(Exception t)
		{
			t.printStackTrace();
		}
		
		
		

	}
}