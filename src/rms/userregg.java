package rms;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

@SuppressWarnings("serial")
public class userregg extends JPanel {
	private JTextField first;
	private JTextField last;
	private JTextField address;
	private JTextField username;
	private JTextField phone;
	private JPasswordField password;
	private JTextField email;
	private JTextField ctz;
	private JPasswordField answer;
	private JTextField Status;
	private JTextField search;
	private JTable table;

	/**
	 * Create the panel.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public userregg() {
		setBackground(new Color(0, 128, 128));
		setBounds(0, 0, 1259, 708);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MANAGE USER");
		lblNewLabel.setBounds(420, 62, 383, 48);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 35));
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setBounds(113, 173, 100, 35);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Last Name");
		lblNewLabel_1_1.setBounds(420, 175, 110, 35);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		add(lblNewLabel_1_1);
		
		first = new JTextField();
		first.setBackground(Color.WHITE);
		first.setBounds(232, 178, 178, 25);
		first.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		first.setColumns(10);
		add(first);
		
		last = new JTextField();
		last.setBackground(Color.WHITE);
		last.setBounds(556, 175, 178, 25);
		last.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		last.setColumns(10);
		add(last);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Username");
		lblNewLabel_1_2_1.setBounds(108, 297, 105, 35);
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Address");
		lblNewLabel_1_2_1_1.setBounds(113, 209, 100, 35);
		lblNewLabel_1_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		add(lblNewLabel_1_2_1_1);
		
		address = new JTextField();
		address.setBackground(Color.WHITE);
		address.setBounds(232, 214, 178, 25);
		address.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		address.setColumns(10);
		add(address);
		
		final JComboBox question = new JComboBox();
		question.setBackground(Color.WHITE);
		question.setBounds(232, 377, 416, 31);
		question.setModel(new DefaultComboBoxModel(new String[] {"", "What is your birth city?", "What is your birth date?", "What is your childhood nickname?", "What is your father name?", "What is your favorite dish?", "Which is your favorite place?", "What is your favorite pet name?", "Which is your first school name?"}));
		add(question);
		
		username = new JTextField();
		username.setBackground(Color.WHITE);
		username.setBounds(232, 302, 178, 25);
		username.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		username.setColumns(10);
		add(username);
		

		JLabel lblNewLabel_1_2_2 = new JLabel("Phone No");
		lblNewLabel_1_2_2.setBounds(430, 209, 100, 35);
		lblNewLabel_1_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_2.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		add(lblNewLabel_1_2_2);
		
		phone = new JTextField();
		phone.setBackground(Color.WHITE);
		phone.setBounds(556, 214, 178, 25);
		phone.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		phone.setColumns(10);
		add(phone);
		
		JLabel lblNewLabel_1_2_1_2 = new JLabel("Password");
		lblNewLabel_1_2_1_2.setBounds(430, 297, 100, 35);
		lblNewLabel_1_2_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		add(lblNewLabel_1_2_1_2);
		

		password = new JPasswordField();
		password.setBackground(Color.WHITE);
		password.setBounds(556, 304, 178, 25);
		add(password);
		
		JLabel lblNewLabel_1_2_1_3 = new JLabel("Question");
		lblNewLabel_1_2_1_3.setBounds(108, 373, 116, 35);
		lblNewLabel_1_2_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		add(lblNewLabel_1_2_1_3);
		
		JLabel lblNewLabel_1_2_1_4 = new JLabel("Answer");
		lblNewLabel_1_2_1_4.setBounds(113, 408, 116, 35);
		lblNewLabel_1_2_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_4.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		add(lblNewLabel_1_2_1_4);
		
		JLabel lblNewLabel_1_2 = new JLabel("Email");
		lblNewLabel_1_2.setBounds(108, 255, 105, 35);
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		add(lblNewLabel_1_2);
		
		email = new JTextField();
		email.setBackground(Color.WHITE);
		email.setBounds(232, 260, 178, 25);
		email.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		email.setColumns(10);
		add(email);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Citizenship No. ");
		lblNewLabel_1_1_1.setBounds(425, 255, 121, 35);
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		add(lblNewLabel_1_1_1);
		
		ctz = new JTextField();
		ctz.setBackground(Color.WHITE);
		ctz.setBounds(556, 260, 178, 25);
		ctz.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		ctz.setColumns(10);
		add(ctz);
		
		final JCheckBox Show = new JCheckBox("Show Password");
		Show.setBackground(new Color(0, 128, 128));
		Show.setBounds(545, 336, 189, 31);
		Show.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Show.setHorizontalAlignment(SwingConstants.CENTER);
		add(Show);
		Show.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(Show.isSelected())
					password.setEchoChar((char)0);
				else
					password.setEchoChar('*');
			}
				
				
		});
		
		
		answer = new JPasswordField();
		answer.setBackground(Color.WHITE);
		answer.setBounds(232, 414, 416, 26);
		add(answer);
		
		final JCheckBox answ = new JCheckBox("Show Answer");
		answ.setBackground(new Color(0, 128, 128));
		answ.setBounds(665, 409, 151, 31);
		answ.setFont(new Font("Tahoma", Font.PLAIN, 17));
		answ.setHorizontalAlignment(SwingConstants.CENTER);
		add(answ);
		answ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(answ.isSelected())
					answer.setEchoChar((char)0);
				else
					answer.setEchoChar('*');
			}
				
				
		});
		
		
		
		
		
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setBackground(new Color(0, 128, 128));
		btnNewButton.setIcon(new ImageIcon("icons/Save-icon.png"));
		btnNewButton.setBounds(204, 454, 116, 42);
		btnNewButton.addActionListener(new ActionListener() {
@SuppressWarnings("deprecation")
public void actionPerformed(ActionEvent e) {
				

	Connection con = null;
	Statement Stmt = null;
		
	try {
	
		Class.forName("com.mysql.cj.jdbc.Driver");
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_management","root","Iloveyou@Raa");
		Stmt = (Statement) con.createStatement();
		
		
	
		try {
			
			if(first.getText().equals("")||last.getText().equals("")||phone.getText().equals("")||question.getSelectedItem().equals("")||answer.getText().equals("")||address.getText().equals("")||username.getText().equals("")||password.getText().equals("")||email.getText().equals("")||ctz.getText().equals(""))
	  		{
				JOptionPane.showMessageDialog(null, "Enter Full details");
				
	  		}
	  		else
	  		{
		Stmt.executeUpdate( "INSERT  INTO login (UserName, Password, First_Name, Last_Name, Question, Answer, Phone_no, Address, Email, Ctz, Status)values('"+ username.getText()+"','"+password.getText()+"','"+first.getText()+"','"+last.getText()+"','"+question.getSelectedItem()+"','"+answer.getText()+"','"+Long.parseLong(phone.getText())+"','"+address.getText()+"','"+ email.getText()+"','"+ctz.getText()+"','"+Status.getText()+"') ");
		first.setText(null);
		last.setText(null);
		phone.setText(null);
		address.setText(null);
		answer.setText(null);
		username.setText(null);
		password.setText(null);
		question.setSelectedItem(null);
		email.setText(null);
		ctz.setText(null);
		
		
		JOptionPane.showMessageDialog(null, "User Registered Successfully");
	
		
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
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 17));
		add(btnNewButton);
		
		JLabel lblNewLabel_1_2_1_5 = new JLabel("Status");
		lblNewLabel_1_2_1_5.setBounds(108, 330, 109, 35);
		lblNewLabel_1_2_1_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(lblNewLabel_1_2_1_5);
		
		Status = new JTextField();
		Status.setBackground(new Color(0, 128, 128));
		Status.setBounds(232, 337, 178, 29);
		Status.setText("user");
		Status.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Status.setEditable(false);
		Status.setColumns(10);
		add(Status);
		
		search = new JTextField();
		search.setBackground(Color.WHITE);
		search.setBounds(556, 144, 178, 25);
		search.addKeyListener(new KeyAdapter() {
		
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					
					 Connection con = null;
					 	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_management","root","Iloveyou@Raa");
					    Statement Stmt = null;
					    Stmt = (Statement) con.createStatement();
						DefaultTableModel model = (DefaultTableModel)table.getModel();
						ResultSet rs = null;
						rs = Stmt.executeQuery("select * from login where UserName like'"+search.getText()+"%' or Username like'%"+search.getText()+"' or UserName like'%"+search.getText()+"%' ");
						
						
						
						 model = (DefaultTableModel)table.getModel();
						@SuppressWarnings("unused")
						ResultSetMetaData restaurant_management = (ResultSetMetaData) rs.getMetaData();
						
						
						
						int rows=model.getRowCount();
						
						while(rows>0) {
							rows--;
							model.removeRow(rows);
						}
						
						
						//for managing width
						
						 
					
					
					
					while(rs.next()) {
						String[] row = {rs.getString(2),rs.getString(6),rs.getString(7)};//username
						model.addRow(row);
					}
						
						
						
						
						
				}
				catch(Exception er)
				{
					er.printStackTrace();
				}
			}
		});
		add(search);
		search.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Search");
		lblNewLabel_2.setBounds(414, 144, 116, 25);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.setBackground(new Color(0, 128, 128));
		btnNewButton_1.setIcon(new ImageIcon("icons/Reload-icon.png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				
				
				try {
					
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_management","root","Iloveyou@Raa");
					Statement Stmt = (Statement) con.createStatement();
					ResultSet rs = null;
					rs = Stmt.executeQuery("select Question , Answer from login where UserName = '"+username.getText()+"'");
					rs.next();
					
					
					if (rs.getString(1).equals("")&&rs.getString(2).equals("")){
						
						JOptionPane.showMessageDialog(null, "Please enter Security Question and Answer");
						
						
					}
					else
					{
					
					if(rs.getString(1).equals(question.getSelectedItem())&&rs.getString(2).equals(answer.getText())) {
					
						JOptionPane.showMessageDialog(null, "Same Security Question and Answer ");

						 
					}
					else {
					
					Stmt.executeUpdate("UPDATE login set Question ='"+question.getSelectedItem()+"' ,Answer ='"+answer.getText()+"' where UserName = '"+username.getText()+"'");
					
					
					
					JOptionPane.showMessageDialog(null, "Security Question and Answer updated successfully");
					
					}
					}
						}
					catch(Exception ex1)
					{
						ex1.printStackTrace();
					}
				
				
			}
		});
		btnNewButton_1.setBounds(350, 454, 159, 42);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.setBackground(new Color(0, 128, 128));
		btnNewButton_2.setIcon(new ImageIcon("icons/Trash-Delete-Icon.png"));
		btnNewButton_2.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e) {
				
				try { 
					if(username.getText().equals(""))
					{
						JOptionPane pane = new JOptionPane("Enter the Username to be deleted", JOptionPane.ERROR_MESSAGE);
		               
					}
					else {
					int op;
					final JDialog dialog = new JDialog();
					dialog.setAlwaysOnTop(true);    
					 op = JOptionPane.showConfirmDialog(dialog, "Are you sure to delete", "DELETE", JOptionPane.YES_NO_OPTION);
					 
					if(op ==0) {
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_management","root","Iloveyou@Raa");
					Statement Stmt = (Statement) con.createStatement();
					Stmt.executeUpdate("Delete from login  where UserName = '"+username.getText()+"'");
					ResultSet rs = null;
					
					first.setText(null);
					last.setText(null);
					ctz.setText(null);
					phone.setText(null);
					email.setText(null);
					address.setText(null);
					username.setText(null);
					password.setText(null);
					question.setSelectedItem(null);
					answer.setText(null);
					
					
					
					JOptionPane.showMessageDialog(null, "user deleted");
	              
						
					
					//refresh the table after data is deleted
						rs = Stmt.executeQuery("select UserName from login");
	                DefaultTableModel model = (DefaultTableModel)table.getModel();
					ResultSetMetaData restaurant_management = (ResultSetMetaData) rs.getMetaData();
					
					
					int rows=model.getRowCount();
					
					while(rows>0) {
						rows--;
						model.removeRow(rows);
					}
					
					
					while(rs.next()) {
						String[] row = {rs.getString(0)};
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
		btnNewButton_2.setBounds(532, 454, 116, 42);
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 17));
		add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(740, 148, 467, 203);
		add(scrollPane);
		table = new JTable() {
			
			
			private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int row,int column) {
			return false;
		};
		};
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				
				
				username.setText(model.getValueAt(table.getSelectedRow(),0).toString());
//				password.setText(model.getValueAt(table.getSelectedRow(),0).toString());
//				first.setText(model.getValueAt(table.getSelectedRow(),0).toString());
//				last.setText(model.getValueAt(table.getSelectedRow(),0).toString());
//				address.setText(model.getValueAt(table.getSelectedRow(),0).toString());
//				phone.setText(model.getValueAt(table.getSelectedRow(),0).toString());
//				ctz.setText(model.getValueAt(table.getSelectedRow(),0).toString());
				answer.setText(model.getValueAt(table.getSelectedRow(),2).toString());
				question.setSelectedItem(model.getValueAt(table.getSelectedRow(),1).toString());
				
				
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Username", "Security Question", "Answer"},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		table.getTableHeader().setResizingAllowed(false);
		table.getTableHeader().setReorderingAllowed(false);
		
		table.setShowGrid(false);
		scrollPane.setColumnHeaderView(table);
		
		

	}
}
