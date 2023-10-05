package rms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import javax.swing.JTextField;
import javax.swing.Timer;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.ImageIcon;

public class m_cat extends JFrame {

	private JPanel contentPane;
	private JTextField cat_name;
	private JTable table;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					m_cat frame = new m_cat();
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
	public m_cat() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 833, 551);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		table = new JTable();
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(411, 120, 290, 305);
		contentPane.add(scrollPane);
		
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
	int op;
				
				final JDialog dialog = new JDialog();
				dialog.setAlwaysOnTop(true);    
				 op = JOptionPane.showConfirmDialog(dialog, "Are you sure to delete", "DELETE", JOptionPane.YES_NO_OPTION);
				 try {
				if(op ==0) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_management","root","Iloveyou@Raa");
				Statement Stmt = (Statement) con.createStatement();
				Stmt.executeUpdate("Delete from FOOD_category  where category  = '"+model.getValueAt(table.getSelectedRow(),1).toString()+"'");
				JOptionPane pane2 = new JOptionPane( "  Deleted", JOptionPane.INFORMATION_MESSAGE);
               final JDialog dialog1 = pane2.createDialog(null, "Title");
                dialog1.setModal(false);
                dialog1.setVisible(true);

                new Timer(500, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dialog1.setVisible(false);
                    }
                }).start();
				 
                
                ResultSet rs = null;
	   			 Stmt.execute("set @row_number = 0");
	   			rs = Stmt.executeQuery("  SELECT   (@row_number:=@row_number + 1) as SN ,category from food_category");
	   			
					
					
					ResultSetMetaData restaurant_management = (ResultSetMetaData) rs.getMetaData();
					 model = (DefaultTableModel)table.getModel();
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
					while(rs.next())
					{
						String[] row = {rs.getString(1),rs.getString(2)};
						model.addRow(row);
						  rows1++;
						if(rs.getString(2).equals(cat_name.getText()))
						{
					       
							
						table.addRowSelectionInterval(rows1-1,rows1-1);
					      table.setBackground(Color.white);
					    
					     // table.setForeground(Color.BLUE);
						
						}
					}
                
                
				}
				 }
				 catch(Exception rr)
				 {
					 rr.printStackTrace();
				 }
			}
		});
		scrollPane.setViewportView(table);
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		cat_name = new JTextField();
		cat_name.setBackground(Color.WHITE);
		cat_name.setFont(new Font("Tahoma", Font.PLAIN, 17));
		cat_name.setColumns(10);
		cat_name.setBounds(73, 240, 233, 31);
		contentPane.add(cat_name);
		
		
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_management?autoReconnect=true&useSSL=false","root","Iloveyou@Raa");
			Statement Stmt = (Statement) con.createStatement();
			ResultSet rs = null;
			  rs = null;
	   			 Stmt.execute("set @row_number = 0");
	   			rs = Stmt.executeQuery("  SELECT   (@row_number:=@row_number + 1) as SN ,category from food_category");
	   			
					
					
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
					while(rs.next())
					{
						String[] row = {rs.getString(1),rs.getString(2)};
						model.addRow(row);
						 
					}
		}
		catch(Exception t)
		{
			t.printStackTrace();
		}
		
		
		
		JButton savebtn = new JButton("Save");
		savebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		savebtn.setBackground(new Color(0, 128, 128));
		savebtn.setIcon(new ImageIcon("icons/Save-icon.png"));
		
		
		savebtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					//Dashboard.main(null);
	                 if(cat_name.getText().equals(""))
	                 {
	                	 JOptionPane pane = new JOptionPane("Enter category name", JOptionPane.ERROR_MESSAGE);
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
					
					    
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_management","root","Iloveyou@Raa");
					Statement Stmt = (Statement) con.createStatement();
					ResultSet rs = null;
					
					
					Stmt.executeUpdate("  Insert into food_category (category) values ('"+cat_name.getText()+"')");
					Menu m = new Menu();
					
					//table
					
					JOptionPane pane = new JOptionPane("Category added", JOptionPane.INFORMATION_MESSAGE);
	                final JDialog dialog = pane.createDialog(null, "Title");
	                dialog.setModal(false);
	                dialog.setVisible(true);

	                new Timer(1000, new ActionListener() {
	                    @Override
	                    public void actionPerformed(ActionEvent e) {
	                        dialog.setVisible(false);
	                    }
	                }).start();
					
	                rs = null;
	   			 Stmt.execute("set @row_number = 0");
	   			rs = Stmt.executeQuery("  SELECT   (@row_number:=@row_number + 1) as SN ,category from food_category");
	   			
					
					
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
					while(rs.next())
					{
						String[] row = {rs.getString(1),rs.getString(2)};
						model.addRow(row);
						  rows1++;
						if(rs.getString(2).equals(cat_name.getText()))
						{
					       
							
						table.addRowSelectionInterval(rows1-1,rows1-1);
					      table.setBackground(Color.white);
					    
					     // table.setForeground(Color.BLUE);
						
						}
					}
					
	                 }
				}
				catch( Exception ee)
				{
					ee.printStackTrace();
				}
			}
		});
		savebtn.setFont(new Font("Tahoma", Font.PLAIN, 17));
		savebtn.setBounds(73, 288, 99, 31);
		contentPane.add(savebtn);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBackground(new Color(0, 128, 128));
		btnClear.setIcon(new ImageIcon("icons/clear.png"));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cat_name.setText("");
			}
		});
		
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnClear.setBounds(200, 288, 107, 31);
		contentPane.add(btnClear);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCategory.setBounds(524, 79, 92, 31);
		contentPane.add(lblCategory);
		
		JLabel lblclickOnRow = new JLabel("*Click on row to delete category");
		lblclickOnRow.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblclickOnRow.setBounds(442, 435, 242, 21);
		contentPane.add(lblclickOnRow);
		
		JLabel lblNewLabel = new JLabel("Add new Category");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(73, 200, 158, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("icons/close.png"));
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				hide();
			}
		});
		//lblNewLabel_1.setIcon(new ImageIcon(m_cat.class.getResource("/icons/Windows-Close-Program-icon.png")));
		lblNewLabel_1.setBounds(788, 0, 45, 43);
		contentPane.add(lblNewLabel_1);
		setUndecorated(true);
	}
}