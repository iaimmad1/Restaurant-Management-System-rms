package rms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import javax.swing.ImageIcon;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class view_staff extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					view_staff frame = new view_staff();
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
	public view_staff() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(255, 11, 1171, 819);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		setLocationRelativeTo(null);
		
		final JDateChooser to = new JDateChooser();
		to.setBackground(new Color(0, 128, 128));
		to.setDateFormatString("yyyy-MM-dd");
		to.setBounds(675, 61, 180, 31);
		contentPane.add(to);
		
		final JDateChooser frm = new JDateChooser();
		frm.setBackground(new Color(0, 128, 128));
		frm.setDateFormatString("yyyy-MM-dd");
		frm.setBounds(325, 61, 180, 31);
		contentPane.add(frm);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setForeground(new Color(245, 255, 250));
		scrollPane.setBackground(new Color(0, 128, 128));
		scrollPane.setBounds(197, 145, 802, 622);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(240, 255, 255));
		table.setForeground(new Color(0, 0, 0));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Emp ID", "Name", "present days", "Total_days"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("icons/close.png"));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				hide();
			}
		});
//		lblNewLabel.setIcon(new ImageIcon(view_staff.class.getResource("/icons/Windows-Close-Program-icon.png")));
		lblNewLabel.setBounds(1130, 0, 41, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Search by Date");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(515, 20, 152, 31);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("From:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_1.setBounds(260, 61, 72, 31);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("To:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_1_1.setBounds(630, 61, 35, 31);
		contentPane.add(lblNewLabel_1_1_1);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setBackground(new Color(0, 128, 128));
		btnNewButton.setIcon(new ImageIcon("icons/search.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					
					
					
				 Connection con = null;
				 	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_management?autoReconnect=true&useSSL=false","root","Iloveyou@Raa");
				    Statement Stmt = null;
				    Stmt = (Statement) con.createStatement();
				
				ResultSet rs = null;
				rs = Stmt.executeQuery("SELECT  a.empid ,emp_name , count(a.empid), datediff('"+((JTextField) (to.getDateEditor().getUiComponent())).getText()+"','"+((JTextField) (frm.getDateEditor().getUiComponent())).getText()+"')FROM attendance a inner join employee e on a.EmpID = e.empid where status = 1 and date between  '"+((JTextField) (frm.getDateEditor().getUiComponent())).getText()+"' and  '"+((JTextField) (to.getDateEditor().getUiComponent())).getText()+"' group by a.empid ; ");
				ResultSetMetaData restaurant_management = (ResultSetMetaData) rs.getMetaData();
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				
				
				int rows=model.getRowCount();
					
					while(rows>0) {
						rows--;
						model.removeRow(rows);
					}
				while(rs.next())
				{
					String[] row = {rs.getString(1),rs.getString(2), rs.getString(3),rs.getString(4)};//name,price,category
					model.addRow(row);
				}
				}
			 
				catch(Exception te)
				{
					te.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(929, 61, 132, 37);
		contentPane.add(btnNewButton);
	}
}