package rms;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.util.Date;

import java.awt.Color;
import javax.swing.SwingConstants;

public class Billing extends JPanel {
	protected static JTable table = null;
	protected static JTextField TableNo = null;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the panel.
	 */
	public Billing() {
		setBackground(new Color(0, 128, 128));
		
		setBounds(240, 0, 1680, 1080);
		setLayout(null);
		
		
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(0, 0, 1127, 755);
		add(contentPane);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(163, 256, 622, 402);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		TableNo = new JTextField();
		TableNo.setBackground(Color.WHITE);
		TableNo.setToolTipText("");
		TableNo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		TableNo.setColumns(10);
		TableNo.setBounds(325, 77, 209, 32);
		contentPane.add(TableNo);
		
		JLabel lblTableNo = new JLabel("Table no:");
		lblTableNo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTableNo.setBounds(239, 82, 70, 21);
		contentPane.add(lblTableNo);
		
		final JTextArea area = new JTextArea();
		area.setEditable(false);
		area.setFont(new Font("Monospaced", Font.BOLD, 14));
		area.setBounds(163, 256, 622, 402);
		contentPane.add(area);
		
		final JLabel total = new JLabel("");
		total.setFont(new Font("Tahoma", Font.BOLD, 17));
		total.setBounds(303, 690, 82, 21);
		contentPane.add(total);
		
		JButton btnViewOrder = new JButton("View order");
		btnViewOrder.setBackground(new Color(0, 128, 128));
		btnViewOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					if(TableNo.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null, "Enter Valid Table No ");
					}else 
					{
					
					
					
					area.setText("");
					 Connection con = null;
					 	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_management","root","Iloveyou@Raa");
					    Statement Stmt = null;
					    Stmt = (Statement) con.createStatement();
					    ResultSet rs = null;
					    Stmt.execute("set @row_number = 0");
					   rs = Stmt.executeQuery("SELECT    (@row_number:=@row_number + 1) as SN,food_name,qty,total FROM temp_order where table_no = '"+Integer.parseInt(TableNo.getText())+"'  ");
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
						 
							while(rs.next()) {
							String[] row = {rs.getString(1),rs.getString(2), rs.getString(3),rs.getString(4)};
							model.addRow(row);
							}
							
							rs = Stmt.executeQuery("SELECT SUM(total) as sum from temp_order where table_no = '"+Integer.parseInt(TableNo.getText())+"'");
							while(rs.next()) {
							total.setText(rs.getString(1));
							}
							
				}
				
							}
				
				catch(Exception en)
				{
						en.printStackTrace();
				}
			}
		});
		btnViewOrder.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnViewOrder.setBounds(355, 150, 163, 29);
		contentPane.add(btnViewOrder);
		
		JLabel lblGrandTotalRs = new JLabel("Grand total Rs.");
		lblGrandTotalRs.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblGrandTotalRs.setBounds(163, 690, 112, 21);
		contentPane.add(lblGrandTotalRs);

	
		
		
		
		JButton btnNewButton = new JButton("Generate bill");
		btnNewButton.setBackground(new Color(0, 128, 128));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try { 
		     	Connection con = null;
				Statement Stmt = null;
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_management","root","Iloveyou@Raa");
				Stmt = (Statement) con.createStatement();
				
				area.setText("	        	K & K Restaurant       \n");
				area.setText(area.getText()+"		\tDhangadhi, Kailali\n");
				area.setText(area.getText()+"		\tVat no:\n");
				area.setText(area.getText()+"		\tABBREVIATED TAX INVOICE\n");
				area.setText(area.getText()+"		\tBill To: Rajesh Ojha\n");
				area.setText(area.getText()+"		\tPayment mode : Cash\n");
//				area.setText(area.getText()+"		Transaction Date:"+java.time.LocalDate.now()+"\n");
				
				
				
				
				ResultSet rs = null;
				
				Stmt.execute("set @row_number = 0");
				rs = Stmt.executeQuery("select (@row_number:=@row_number + 1) as SN, food.food_name, qty,price, total from temp_order inner join food on temp_order.food_name = food.food_name where table_no ='"+Integer.parseInt(TableNo.getText())+"' order by sn asc ");
				
				
					
				
				
				area.setText(area.getText()+"SN"+ "\t"+"Particulars"+"\t\t"+"Qty\t"+"Rate"+"\t"+"Amount\n");
				area.setText(area.getText()+"------------------------------------------------------------\n");
				while(rs.next())
				{
					area.setText(area.getText()+ rs.getString(1)+"\t"+String.format("%-20s", rs.getString(2))+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\n");
				}
				area.setText(area.getText()+"------------------------------------------------------------\n");
				area.setText(area.getText()+"  \t     \t\t   \tGross Amount: " +Float.parseFloat(total.getText())+":\n");
				area.setText(area.getText()+"  \t     \t\t   \tDiscount:   \n");
				area.setText(area.getText()+"  \t   \t\t   \tNet Amount:  \n");
                 
				Stmt.executeUpdate("Delete from temp_order where table_no ='"+Integer.parseInt(TableNo.getText())+"' ");			
			}
				catch (SQLException e2) {
					e2.printStackTrace();
				}
			}});
		
		
		
		
		
		
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(406, 679, 174, 32);
		contentPane.add(btnNewButton);
		
		
		
		JButton btnPrintReceipt = new JButton("Print Receipt");
		btnPrintReceipt.setBackground(new Color(0, 128, 128));
		btnPrintReceipt.setIcon(new ImageIcon("icons/print.png"));
		btnPrintReceipt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				area.print();
				}
				catch (Exception e1)
				{
				e1.printStackTrace();
				}
			}
		});
		btnPrintReceipt.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnPrintReceipt.setBounds(616, 679, 163, 32);
		contentPane.add(btnPrintReceipt);
	
		

	}
}