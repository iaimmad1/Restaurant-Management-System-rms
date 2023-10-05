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

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("serial")
public class Order extends JPanel {
	private JTextField Total;
	private JTextField Name;
	private JTextField Price;
	private JTextField Search;
	private JTextField tableNo;
	private JTable table;
	private JTable table_1;

	/**
	 * Create the panel.
	 */

	public Order() {
		setBackground(new Color(0, 128, 128));
		
		setBounds(240, 0, 1680, 1080);
		setLayout(null);
		
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(135, 82, 1127, 755);
		add(contentPane);
		
		
		final JSpinner Quantity = new JSpinner();
		Quantity.setBackground(Color.WHITE);
		Quantity.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int qty = (int) Quantity.getValue();
				 float total = (Float.parseFloat(Price.getText())*qty);
				 
				Total.setText(String.valueOf(total));
			}
		});
		Quantity.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		Quantity.setBounds(364, 155, 209, 32);
		contentPane.add(Quantity);
		
		
		final JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {""}));
		comboBox.setBackground(Color.WHITE);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					 Connection con = null;
					 	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_management?autoReconnect=true&useSSL=false","root","Iloveyou@Raa");
					    Statement Stmt = null;
					    Stmt = (Statement) con.createStatement();
					
					    ResultSet rs = null;
					    rs = Stmt.executeQuery("SELECT f.food_name,f.price,c.Category FROM  food f inner join food_category c on f.cid = c.cid where Category = '"+comboBox.getSelectedItem().toString()+"' ");
						ResultSetMetaData restaurant_management = (ResultSetMetaData) rs.getMetaData();
						DefaultTableModel model = (DefaultTableModel)table.getModel();
						int col = restaurant_management.getColumnCount();	
						String [] colname = new String[col];
						
						for(int i= 0;i<col;i++)
						{
							colname[i] = restaurant_management.getColumnName(i+1);
							model.setColumnIdentifiers(colname);
						}
						int rows=model.getRowCount();
							
							while(rows>0) {
								rows--;
								model.removeRow(rows);
							}
						while(rs.next()) {
						String name,p,cat;
						name =  rs.getString(1);
						p = rs.getString(2);
						cat = rs.getString(3);
						String[] row = {name,p,cat};
						model.addRow(row);
						}

					}
					 
						catch(Exception en)
					{
							en.printStackTrace();
					}
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(57, 204, 255, 429);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				int i = table.getSelectedRow();

				Name.setText(model.getValueAt(i,0).toString());
				Price.setText(model.getValueAt(i,1).toString());
				Total.setText(Price.getText());
				Quantity.setValue(1);
				 
				
				
			}
		});
		scrollPane.setViewportView(table);
		comboBox.setBounds(66, 67, 245, 32);
		contentPane.add(comboBox);
		try {
		 Connection con = null;
		 	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_management?autoReconnect=true&useSSL=false","root","Iloveyou@Raa");
		    Statement Stmt = null;
		    Stmt = (Statement) con.createStatement();
		
		ResultSet rs = null;
		 rs = Stmt.executeQuery("SELECT Category FROM food_Category ");

		 while(rs.next()) {
			comboBox.addItem(rs.getString(1)); 
		 }
		}
		 
			catch(Exception e)
		{
			e.printStackTrace();	
		}
		
		JLabel lblNewLabel = new JLabel("Category:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(102, 24, 82, 21);
		contentPane.add(lblNewLabel);
		
		Search = new JTextField();
		Search.setBackground(Color.WHITE);
		Search.addKeyListener(new KeyAdapter() {
			@Override
				public void keyReleased(KeyEvent e) {
					try {
					    Connection con = null;
					 	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_management?autoReconnect=true&useSSL=false","root","Iloveyou@Raa");
					    Statement Stmt = null;
					    Stmt = (Statement) con.createStatement();
					
					DefaultTableModel model = (DefaultTableModel)table.getModel();
					ResultSet rs = null;
					 rs = Stmt.executeQuery("SELECT f.food_name,f.price,c.Category FROM  food f inner join food_Category c on f.cid = c.cid where food_name like'"+Search.getText()+"%' or food_name like '%"+Search.getText()+"' or food_name like '%"+Search.getText()+"%' ");
					ResultSetMetaData restaurant_management = (ResultSetMetaData) rs.getMetaData();
					int col = restaurant_management.getColumnCount();	
					String [] colname = new String[col];
					
					for(int i= 0;i<col;i++)
					{
						colname[i] = restaurant_management.getColumnName(i+1);
						model.setColumnIdentifiers(colname);
					}
				
					
					int rows=model.getRowCount();
						
						while(rows>0) {
							rows--;
							model.removeRow(rows);
						}

			
					while(rs.next()) {
					
					String[] row = {rs.getString(1),rs.getString(2),rs.getString(3)};
					model.addRow(row);
					
					}
						}
					
					
		        
					catch (SQLException e2) {
						e2.printStackTrace();
					}
			}
		});
		Search.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Search.setBounds(57, 152, 254, 32);
		contentPane.add(Search);
		Search.setColumns(10);
		
		JLabel lblSearch = new JLabel("Search:");
		lblSearch.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSearch.setBounds(102, 120, 82, 21);
		contentPane.add(lblSearch);
		
		JLabel lblBillId = new JLabel("OrderID :");
		lblBillId.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblBillId.setBounds(22, 0, 82, 21);
		contentPane.add(lblBillId);
		
		JLabel lblCategory = new JLabel("");
		lblCategory.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCategory.setBounds(102, 0, 82, 21);
		contentPane.add(lblCategory);
		
		
		JLabel lblSearch_1 = new JLabel("Name:");
		lblSearch_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSearch_1.setBounds(364, 24, 82, 21);
		contentPane.add(lblSearch_1);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblQuantity.setBounds(364, 120, 82, 21);
		contentPane.add(lblQuantity);
		
		Name = new JTextField();
		Name.setBackground(Color.WHITE);
		Name.setEditable(false);
		Name.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Name.setColumns(10);
		Name.setBounds(364, 67, 209, 32);
		contentPane.add(Name);
		
	
		
		Price = new JTextField();
		Price.setBackground(Color.WHITE);
		Price.setEditable(false);
		Price.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Price.setColumns(10);
		Price.setBounds(611, 67, 209, 32);
		contentPane.add(Price);
		
		Total = new JTextField();
		Total.setBackground(Color.WHITE);
		Total.setEditable(false);
		Total.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Total.setColumns(10);
		Total.setBounds(611, 153, 209, 32);
		contentPane.add(Total);
		
		JLabel lblSearch_1_1 = new JLabel("Price :");
		lblSearch_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSearch_1_1.setBounds(611, 31, 82, 21);
		contentPane.add(lblSearch_1_1);
		
		JLabel lblSearch_1_2 = new JLabel("Total :");
		lblSearch_1_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSearch_1_2.setBounds(611, 127, 82, 21);
		contentPane.add(lblSearch_1_2);
		
		JButton btnNewButton = new JButton("Clear");
		btnNewButton.setBackground(new Color(0, 128, 128));
		btnNewButton.setIcon(new ImageIcon("icons/clear.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Name.setText(null);
				Price.setText(null);
				Total.setText(null);
				Quantity.setValue(1);
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(364, 214, 112, 40);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(364, 264, 521, 368);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int op;
					final JDialog dialog = new JDialog();
					dialog.setAlwaysOnTop(true);    
					 op = JOptionPane.showConfirmDialog(dialog, "Are you sure to delete", "DELETE", JOptionPane.YES_NO_OPTION);
					 
					if(op ==0) {
					Class.forName("com.mysql.cj.jdbc.Driver");
					ResultSet Rs = null;
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_management?autoReconnect=true&useSSL=false","root","Iloveyou@Raa");
					Statement Stmt = (Statement) con.createStatement();
					DefaultTableModel model = (DefaultTableModel)table_1.getModel();
					Stmt.executeUpdate("Delete from temp_order  where food_name = '"+model.getValueAt(table_1.getSelectedRow(),1).toString()+"'");
					Stmt.executeUpdate("Delete from restaurant_management.order  where food_name = '"+model.getValueAt(table_1.getSelectedRow(),1).toString()+"'");
                    Rs = Stmt.executeQuery("SELECT T.SN, T.food_name,f.price ,T.Qty,T.total from food f inner join temp_order T on f.food_name = t.food_name where Table_no = '"+Integer.parseInt(tableNo.getText())+"'");
					
					
					ResultSetMetaData restaurant_management = (ResultSetMetaData) Rs.getMetaData();
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
					
					while(Rs.next()) {
					String[] row = {Rs.getString(1),Rs.getString(2),Rs.getString(3),Rs.getString(4),Rs.getString(5)};
					model.addRow(row);
					
					
					
			
						
					}
					}
					}
					
					
					catch(Exception ex1)
					{
						ex1.printStackTrace();
					}
			}
		});
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblGrandTotalRs = new JLabel("Grand total Rs.");
		lblGrandTotalRs.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblGrandTotalRs.setBounds(502, 645, 112, 21);
		contentPane.add(lblGrandTotalRs);
		
		final JLabel grand_total = new JLabel("");
		grand_total.setFont(new Font("Tahoma", Font.BOLD, 17));
		grand_total.setBounds(622, 645, 82, 21);
		contentPane.add(grand_total);
		
		JButton btnAddToCart = new JButton("Add to cart");
		btnAddToCart.setBackground(new Color(0, 128, 128));
		btnAddToCart.setIcon(new ImageIcon("icons/add-to-cart.png"));
		btnAddToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Connection con = null;
				Statement Stmt = null;
				ResultSet Rs = null;
					
				try {
				
					Class.forName("com.mysql.cj.jdbc.Driver");
					 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_management?autoReconnect=true&useSSL=false","root","Iloveyou@Raa");
					Stmt = (Statement) con.createStatement();
					Rs = Stmt.executeQuery("select food_name from temp_order where food_name = '"+Name.getText()+"' and table_no = '"+Integer.parseInt(tableNo.getText())+"'");
					if(Rs.next())
					{
						
						Stmt.executeUpdate("Update temp_order set Qty = Qty + '"+(Quantity.getValue())+"' , total = total + '"+Float.parseFloat(Total.getText())+"' where food_name = '"+Name.getText()+"' and table_no = '"+Integer.parseInt(tableNo.getText())+"'");
						Stmt.executeUpdate( "INSERT  INTO restaurant_management.order (food_name,Qty,Total,order_date)values('"+Name.getText()+"','"+Quantity.getValue()+"','"+Float.parseFloat(Total.getText())+"',curdate()) ");

					}
					else {
						Stmt.executeUpdate( "INSERT  INTO temp_order (food_name,Table_no,Qty,Total)values('"+Name.getText()+"','"+Integer.parseInt(tableNo.getText())+"','"+(Quantity.getValue())+"','"+Float.parseFloat(Total.getText())+"') ");
					    Stmt.executeUpdate( "INSERT  INTO restaurant_management.order (food_name,Qty,Total,order_date)values('"+Name.getText()+"','"+Quantity.getValue()+"','"+Float.parseFloat(Total.getText())+"',curdate()) ");
						
					}
					
					
					
					
				    Stmt.execute("set @row_number = 0");
					Rs = Stmt.executeQuery("  SELECT   (@row_number:=@row_number + 1) as SN, T.food_name,f.price ,T.Qty,T.total from food f inner join temp_order T on f.food_name = t.food_name where Table_no = '"+Integer.parseInt(tableNo.getText())+"'");
					
					
					ResultSetMetaData restaurant_management = (ResultSetMetaData) Rs.getMetaData();
					DefaultTableModel model = (DefaultTableModel)table_1.getModel();
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
					
					while(Rs.next()) {
					String[] row = {Rs.getString(1),Rs.getString(2),Rs.getString(3),Rs.getString(4),Rs.getString(5)};
					model.addRow(row);
					
					}
					Rs = Stmt.executeQuery("SELECT SUM(total) as sum from temp_order where table_no = '"+Integer.parseInt(tableNo.getText())+"'");
					while(Rs.next()) {
					grand_total.setText(Rs.getString(1));
					}
					
					

				}
				catch( NumberFormatException ee)
				{
					final JDialog dialog = new JDialog();
					dialog.setAlwaysOnTop(true);    
					JOptionPane.showMessageDialog(dialog, "Please enter valid table no");
				}
				
				
				catch(SQLException e3)
				{
					e3.printStackTrace();
				}

				catch(Exception e4)
				{
					e4.printStackTrace();
				}
				
				
				
			}
		});
		btnAddToCart.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnAddToCart.setBounds(725, 214, 160, 40);
	
		btnAddToCart.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnAddToCart.setBounds(725, 214, 160, 40);
		contentPane.add(btnAddToCart);
		
		JLabel lblSearch_1_1_1 = new JLabel("table No. :");
		lblSearch_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSearch_1_1_1.setBounds(876, 31, 82, 21);
		contentPane.add(lblSearch_1_1_1);
		
		tableNo = new JTextField();
		tableNo.setBackground(Color.WHITE);
		tableNo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tableNo.setColumns(10);
		tableNo.setBounds(876, 67, 82, 32);
		contentPane.add(tableNo);
		
		
		
		
		
		
		
		

	}
}