package rms;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.DropMode;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class Staff extends JPanel {

	/**
	 * 
	 */
	int a;
	
	private static final long serialVersionUID = 1L;

	static String removeSubstring(String text, int startIndex, int endIndex) {
        if (endIndex < startIndex) {
            startIndex = endIndex;
        }

        String a = text.substring(0, startIndex);
        String b = text.substring(endIndex);
        return a + b;
    }
	
	
	private JLabel eid;
	private int flag = 0;// to determine whether to increase the id or not
	private JTextField name;
	private JTextField age;
	private JTextField mobile_no;
	private JTextField email;
	private JLabel dd;
	private JTextField hiredate;
	private JTextField ctz_no;
	private JTextField Search;
	private JTable table;
	private JTextField municipality;
	private JTextField tole;

	/**
	 * Create the panel.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes", "removal" })
	public Staff() {
		setBackground(new Color(0, 128, 128));
		
		setBounds(255, 11, 1213, 845);
		setLayout(null);
		

		final JComboBox districtComboBox = new JComboBox();
		districtComboBox.setBackground(Color.WHITE);
		districtComboBox.setMaximumRowCount(12);
		
		final JComboBox provienceComboBox = new JComboBox();
		provienceComboBox.setBackground(Color.WHITE);
		provienceComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(provienceComboBox.getSelectedItem().equals("Province No 1"))
		        {
		            districtComboBox.removeAllItems();
		            districtComboBox.addItem("Bhojpur");
		            districtComboBox.addItem("Dhankuta");
		            districtComboBox.addItem("Ilam");
		            districtComboBox.addItem("Jhapa");
		            districtComboBox.addItem("Khotang");
		            districtComboBox.addItem("Khotang");
		            districtComboBox.addItem("Okhaldhunga");
		            districtComboBox.addItem("Panchthar");
		            districtComboBox.addItem("Sankhuwasabha");
		            districtComboBox.addItem("Solukhumbu");
		            districtComboBox.addItem("Sunsari");
		            districtComboBox.addItem("Taplejung");
		            districtComboBox.addItem("Terhathum");
		            districtComboBox.addItem("Udayapur");
		            districtComboBox.setSelectedItem(null);
		        }

		        else
		        if(provienceComboBox.getSelectedItem().equals("Madhesh Pradesh"))
		        {
		            districtComboBox.removeAllItems();
		            districtComboBox.addItem("Bara");
		            districtComboBox.addItem("Dhanusa");
		            districtComboBox.addItem("Mahottari");
		            districtComboBox.addItem("Parsa");
		            districtComboBox.addItem("Rauthat");
		            districtComboBox.addItem("Saptari");
		            districtComboBox.addItem("Sarlahi");
		            districtComboBox.addItem("Siraha");
		            districtComboBox.setSelectedItem(null);
		        }

		        else
		        if(provienceComboBox.getSelectedItem().equals("Bagmati Pradesh"))
		        {
		            districtComboBox.removeAllItems();
		            //ProvienceComboBox.setSelectedItem(null);
		            districtComboBox.addItem("Bhaktapur ");
		            districtComboBox.addItem("Chitwan");
		            districtComboBox.addItem("Dhading");
		            districtComboBox.addItem("Dolakha");
		            districtComboBox.addItem("Kathmandu");
		            districtComboBox.addItem("Kavrepalanchok");
		            districtComboBox.addItem("Lalitpur");
		            districtComboBox.addItem("Makawanpur");
		            districtComboBox.addItem("Nuwakot");
		            districtComboBox.addItem("Ramechap");
		            districtComboBox.addItem("Rasuwa");
		            districtComboBox.addItem("Sindhuli");
		            districtComboBox.addItem("Sindhupalanchowk");
		            districtComboBox.setSelectedItem(null);
		        }

		        else
		        if(provienceComboBox.getSelectedItem().equals("Gandaki Pradesh"))
		        {
		            districtComboBox.removeAllItems();
		            //  ProvienceComboBox.setSelectedItem(null);
		            districtComboBox.addItem("Baglung ");
		            districtComboBox.addItem("Gorkha");
		            districtComboBox.addItem("Kaski");
		            districtComboBox.addItem("Lamjung");
		            districtComboBox.addItem("Manang");
		            districtComboBox.addItem("Mustang");
		            districtComboBox.addItem("Myagdi");
		            districtComboBox.addItem("Nawalparasi(Bardaghat Susta Purva)");
		            districtComboBox.addItem("Parbat");
		            districtComboBox.addItem("Syangja");
		            districtComboBox.addItem("Tanahu");
		            districtComboBox.setSelectedItem(null);
		        }

		        else
		        if(provienceComboBox.getSelectedItem().equals("Lumbini Pradesh"))
		        {
		            districtComboBox.removeAllItems();
		            //  ProvienceComboBox.setSelectedItem(null);
		            districtComboBox.addItem("Arghakhanchi ");
		            districtComboBox.addItem("Banke");
		            districtComboBox.addItem("Bardiya");
		            districtComboBox.addItem("Dang");
		            districtComboBox.addItem("Gulmi");
		            districtComboBox.addItem("Kapilvastu");
		            districtComboBox.addItem("Nawalparasi(Bardaghat Susta Paschim)");
		            districtComboBox.addItem("Palpa");
		            districtComboBox.addItem("Pyuthan");
		            districtComboBox.addItem("Rolpa");
		            districtComboBox.addItem("Purbi Rukum");
		            districtComboBox.addItem("Rupandehi");
		            districtComboBox.setSelectedItem(null);
		        }

		        else
		        if(provienceComboBox.getSelectedItem().equals("Karnali Pradesh"))
		        {
		            districtComboBox.removeAllItems();
		            //  ProvienceComboBox.setSelectedItem(null);
		            districtComboBox.addItem("Dailekh");
		            districtComboBox.addItem("Dolpa");
		            districtComboBox.addItem("Humla");
		            districtComboBox.addItem("Jajarkot");
		            districtComboBox.addItem("Jumla");
		            districtComboBox.addItem("Kalikot");
		            districtComboBox.addItem("Mugu");
		            districtComboBox.addItem("Rukum Pashim");
		            districtComboBox.addItem("Salyan");
		            districtComboBox.addItem("Surkhet");
		            districtComboBox.setSelectedItem(null);
		        }
		        else
		        {
		            districtComboBox.removeAllItems();
		            // ProvienceComboBox.setSelectedItem(null);
		            districtComboBox.addItem("Achham");
		            districtComboBox.addItem("Baitadi");
		            districtComboBox.addItem("Bajhang");
		            districtComboBox.addItem("Bajura");
		            districtComboBox.addItem("Darchula");
		            districtComboBox.addItem("Doti");
		            districtComboBox.addItem("Kailali");
		            districtComboBox.addItem("Kanchanpur");
		            districtComboBox.setSelectedItem(null);
		        }
			}
		});
		provienceComboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Province No 1", "Madhesh Pradesh", "Bagmati Pradesh", "Gandaki Pradesh", "Lumbini Pradesh", "arnali Pradesh", "sudurpaschim Pradesh"}));
		provienceComboBox.setSelectedIndex(0);
		provienceComboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		provienceComboBox.setBounds(181, 290, 149, 21);
		add(provienceComboBox);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(50, 42, 140, 105);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Total Employee");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(10, 59, 119, 36);
		panel.add(lblNewLabel);
		
		final JLabel total_employee = new JLabel("");
		total_employee.setFont(new Font("Tahoma", Font.PLAIN, 22));
		total_employee.setBounds(10, 10, 45, 39);
		panel.add(total_employee);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 128, 128));
		panel_1.setLayout(null);
		panel_1.setBounds(237, 42, 140, 105);
		add(panel_1);
		
		JLabel present_today = new JLabel("present Today");
		present_today.setFont(new Font("Tahoma", Font.PLAIN, 17));
		present_today.setBounds(10, 59, 119, 36);
		panel_1.add(present_today);
		
		final JLabel present_employee = new JLabel("");
		present_employee.setFont(new Font("Tahoma", Font.PLAIN, 22));
		present_employee.setBounds(10, 10, 45, 39);
		panel_1.add(present_employee);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 128, 128));
		panel_2.setLayout(null);
		panel_2.setBounds(425, 42, 140, 105);
		add(panel_2);
		
		JLabel asdhf = new JLabel("On Leave");
		asdhf.setFont(new Font("Tahoma", Font.PLAIN, 17));
		asdhf.setBounds(10, 59, 119, 36);
		panel_2.add(asdhf);
		
		JLabel on_leave = new JLabel("0");
		on_leave.setFont(new Font("Tahoma", Font.PLAIN, 22));
		on_leave.setBounds(10, 10, 45, 39);
		panel_2.add(on_leave);
		
		eid = new JLabel();
		eid.setBackground(new Color(0, 153, 153));
		eid.setFont(new Font("Tahoma", Font.PLAIN, 15));
		eid.setBounds(188, 182, 85, 21);
		add(eid);;
		
		JLabel label = new JLabel("New label");
		label.setBounds(50, 290, 98, -5);
		add(label);
		
		dd = new JLabel("Employee ID:");
		dd.setFont(new Font("Tahoma", Font.PLAIN, 17));
		dd.setBounds(60, 182, 106, 21);
		add(dd);
		
		name = new JTextField();
		name.setBackground(Color.WHITE);
		name.setFont(new Font("Tahoma", Font.PLAIN, 15));
		name.setColumns(10);
		name.setBounds(188, 213, 231, 21);
		add(name);
		
		JLabel fff = new JLabel("Name:");
		fff.setFont(new Font("Tahoma", Font.PLAIN, 17));
		fff.setBounds(60, 213, 106, 21);
		add(fff);
		
		JLabel ff = new JLabel("Age:");
		ff.setFont(new Font("Tahoma", Font.PLAIN, 17));
		ff.setBounds(714, 235, 106, 21);
		add(ff);
		
		final JComboBox dept = new JComboBox();
		dept.setModel(new DefaultComboBoxModel(new String[] {"", "Cook", "Reception", "Service"}));
		dept.setSelectedIndex(-1);
		dept.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dept.setBackground(Color.WHITE);
		dept.setBounds(876, 336, 231, 21);
		add(dept);
		
		final JComboBox position = new JComboBox();
		position.setModel(new DefaultComboBoxModel(new String[] {"", "Cashier", "Manager", "Waiter", "Delevery Man", "Cook"}));
		position.setSelectedIndex(-1);
		position.setFont(new Font("Tahoma", Font.PLAIN, 14));
		position.setBackground(Color.WHITE);
		position.setBounds(876, 303, 231, 21);
		add(position);
		
		age = new JTextField();
		age.setBackground(Color.WHITE);
		age.setFont(new Font("Tahoma", Font.PLAIN, 15));
		age.setColumns(10);
		age.setBounds(876, 236, 231, 21);
		add(age);
		
		JLabel E = new JLabel("Gender:");
		E.setFont(new Font("Tahoma", Font.PLAIN, 17));
		E.setBounds(60, 244, 106, 21);
		add(E);
		
		final JComboBox gender = new JComboBox();
		gender.setBackground(Color.WHITE);
		gender.setFont(new Font("Tahoma", Font.PLAIN, 14));
		gender.setModel(new DefaultComboBoxModel(new String[] {"male", "female", "Other"}));
		gender.setBounds(188, 241, 231, 21);
		add(gender);
		  gender.setSelectedIndex(-1);
		  
		  JLabel f = new JLabel("Address:");
		  f.setFont(new Font("Tahoma", Font.PLAIN, 17));
		  f.setBounds(60, 275, 106, 21);
		  add(f);
		  
		  JLabel d = new JLabel("Mobile no:");
		  d.setFont(new Font("Tahoma", Font.PLAIN, 17));
		  d.setBounds(714, 264, 106, 21);
		  add(d);
		  
		  mobile_no = new JTextField();
		  mobile_no.setBackground(Color.WHITE);
		  mobile_no.setFont(new Font("Tahoma", Font.PLAIN, 15));
		  mobile_no.setColumns(10);
		  mobile_no.setBounds(876, 267, 231, 21);
		  add(mobile_no);
		  
		  JLabel b = new JLabel("Emali Address");
		  b.setFont(new Font("Tahoma", Font.PLAIN, 17));
		  b.setBounds(60, 373, 116, 21);
		  add(b);
		  
		  email = new JTextField();
		  email.setBackground(Color.WHITE);
		  email.setFont(new Font("Tahoma", Font.PLAIN, 15));
		  email.setColumns(10);
		  email.setBounds(188, 374, 231, 21);
		  add(email);
		  
		  JLabel a = new JLabel("Department:");
		  a.setFont(new Font("Tahoma", Font.PLAIN, 17));
		  a.setBounds(714, 334, 106, 21);
		  add(a);
		  
		  JLabel c = new JLabel("Position");
		  c.setFont(new Font("Tahoma", Font.PLAIN, 17));
		  c.setBounds(714, 301, 106, 21);
		  add(c);
		  
		  final JSpinner ward_no = new JSpinner();
		  ward_no.setBackground(Color.WHITE);
			ward_no.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
			ward_no.setBounds(188, 343, 56, 21);
			add(ward_no);
		  
		  JButton button = new JButton("New button");
		  button.setBounds(63, 552, 140, 0);
		  add(button);
		  
		  JButton save = new JButton("Save");
		  save.setBackground(new Color(0, 128, 128));
		  save.setIcon(new ImageIcon("icons/Save-icon.png"));
		  save.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		if(name.getText().equals("")||age.getText().equals("")||mobile_no.getText().equals("")||position.getSelectedItem().equals("")||email.getText().equals("")||ctz_no.getText().equals(""));
		  		{
		  		
				JOptionPane pane = new JOptionPane("Please Fill all details", JOptionPane.INFORMATION_MESSAGE);
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
		  		
		  		
		  		
		  		Connection con = null;
		  		Statement stmt = null;
		  		ResultSet rs = null;
		  		try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_management?autoReconnect=true&useSSL=false","root","Iloveyou@Raa");
				stmt = (Statement) con.createStatement();
				stmt.executeUpdate("insert into employee (emp_name,age,gender,mobile_no,position,e_address,department,hiredate,citizenship_no,district,municipality,ward_no,tole) values ('"+ name.getText()+"','"+Integer.parseInt(age.getText())+"','"+gender.getSelectedItem()+"','"+Long.parseLong(mobile_no.getText())+"','"+position.getSelectedItem()+"','"+email.getText()+"','"+dept.getSelectedItem()+"' ,'"+hiredate.getText()+"','"+ctz_no.getText()+"','"+districtComboBox.getSelectedItem()+"','"+municipality.getText()+"','"+ward_no.getValue()+"','"+tole.getText()+"')");
				total_employee.setText(Integer.toString(Integer.parseInt(total_employee.getText())+1));
				
				rs = stmt.executeQuery("select * from employee");
				// for table
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				ResultSetMetaData restaurant_management = (ResultSetMetaData) rs.getMetaData();
				int col = restaurant_management.getColumnCount();	
				String [] colname = new String[col];
				
				
				int rows=model.getRowCount();
				
				while(rows>0) {
					rows--;
					model.removeRow(rows);
				}
				
				
				//for managing width
				
				 
				
			for(int i= 0;i<col;i++)
			{
				colname[i] = restaurant_management.getColumnName(i+1);
				model.setColumnIdentifiers(colname);
			}
			

			
			while(rs.next()) {
				String[] row = {rs.getString(1),rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7), rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12), rs.getString(13),rs.getString(14)};//name,price,category
				model.addRow(row);
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
                flag = 1;
				
		  		}
		  		 
		  		
		  		catch(SQLIntegrityConstraintViolationException m)
		  		{
		  		
					JOptionPane pane = new JOptionPane("duplicate entry", JOptionPane.INFORMATION_MESSAGE);
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
		  		
		  		catch(Exception e1)
		  		{
		  			e1.printStackTrace();
		  		}
		  		
		  		
		  		
		  	}
		  	
		  });
		  save.setFont(new Font("Tahoma", Font.PLAIN, 17));
		  save.setBounds(50, 436, 116, 30);
		  add(save);
		  
		  JButton btnClear = new JButton("clear");
		  btnClear.setBackground(new Color(0, 128, 128));
		  btnClear.setIcon(new ImageIcon("icons/clear.png"));
		  btnClear.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		name.setText("");
		  		age.setText("");
		  		hiredate.setEnabled(true);
		  		gender.setSelectedIndex(-1);
		  		mobile_no.setText("");
		  		email.setText("");
		  		position.setSelectedItem("");
		  		dept.setSelectedItem("");
		  		ctz_no.setText("");
		  		hiredate.setText("");
		  		districtComboBox.setSelectedIndex(-1);
		  		municipality.setText("");
		  		tole.setText("");
		  		ward_no.setValue(1);
		  		
		  		if( flag ==1)
		  		eid.setText(Integer.toString(Integer.parseInt(eid.getText())+1));
		  		else {
		  			eid.setText("");
		  		}
		  		flag = 0;
		  		
		  		
		  	}
		  });
		  btnClear.setFont(new Font("Tahoma", Font.PLAIN, 17));
		  btnClear.setBounds(214, 436, 116, 30);
		  add(btnClear);
		  
		  JButton btnUpdate = new JButton("Update");
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
					}
					else {
					
					
				
				Class.forName("com.mysql.cj.jdbc.Driver");
					 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_management","root","Iloveyou@Raa");
					Stmt = (Statement) con.createStatement();
					ResultSet rs = null;
					Stmt.executeUpdate("Update employee set emp_name ='"+name.getText()+"', age = '"+Integer.parseInt(age.getText())+"',gender = '"+gender.getSelectedItem()+"',mobile_no = '"+ Long.parseLong(mobile_no.getText())+"',position = '"+position.getSelectedItem()+"',e_address ='"+email.getText()+"'  ,department = '"+dept.getSelectedItem()+"',citizenship_no ='"+ctz_no.getText()+"',district ='"+districtComboBox.getSelectedItem()+"',municipality ='"+municipality.getText()+"', ward_no ='"+ward_no.getValue()+"', tole ='"+tole.getText()+"' where empid = '"+Integer.parseInt(eid.getText())+"'");
					
				
					
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
	                
	                rs = Stmt.executeQuery(" select * from employee");
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
					
					String[] row = {rs.getString(1),rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7), rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12), rs.getString(13),rs.getString(14)};
					model.addRow(row);
				    rows1++;
					if(rs.getString(1).equals(eid.getText()))
					{
				       
					
					table.addRowSelectionInterval(rows1-1,rows1-1);
				      table.setBackground(Color.white);
				     // table.setForeground(Color.BLUE);/
					
					}
				}
			}				
		}catch(Exception t1)
			{
				t1.printStackTrace();
			}
		  	}
		  });
		  btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 17));
		  btnUpdate.setBounds(366, 436, 127, 30);
		  add(btnUpdate);
		  
		  JButton btnDelete = new JButton("Delete");
		  btnDelete.setBackground(new Color(0, 128, 128));
		  btnDelete.setIcon(new ImageIcon("icons/Trash-Delete-Icon.png"));
		  btnDelete.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		try { 
		  			
		  			
		  			if(name.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null, "Enter Name of Employee to be deleted ");
					}else 
					{
		  			
		  			
					if(eid.getText().equals(""))
					{
						JOptionPane pane = new JOptionPane("Enter the Staff name to be deletd", JOptionPane.ERROR_MESSAGE);
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
					ResultSet rs = null;
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_management?autoReconnect=true&useSSL=false","root","Iloveyou@Raa");
					Statement Stmt = (Statement) con.createStatement();
					rs = Stmt.executeQuery("select status from attendance where empid = '"+Integer.parseInt(eid.getText())+"' and date = curdate()");
					rs.next();
					if(Integer.parseInt(rs.getString(1)) == 1){
						present_employee.setText(Integer.toString(Integer.parseInt(present_employee.getText())-1));
					}
					Stmt.executeUpdate("Delete from employee  where empid = '"+Integer.parseInt(eid.getText())+"'");
					
					rs = Stmt.executeQuery("SELECT * FROM  employee   ");
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
							table.getColumnModel().getColumn(0).setPreferredWidth(2);
							table.getColumnModel().getColumn(2).setPreferredWidth(2);
							table.getColumnModel().getColumn(3).setPreferredWidth(6);
							table.getColumnModel().getColumn(7).setPreferredWidth(30);
							table.getColumnModel().getColumn(5).setPreferredWidth(15);
							table.getColumnModel().getColumn(6).setPreferredWidth(20);
							table.getColumnModel().getColumn(11).setPreferredWidth(30);
							

							
							while(rs.next()) {
								String[] row = {rs.getString(1),rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7), rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12), rs.getString(13),rs.getString(14)};//name,price,category
								model.addRow(row);
							}
							
					}
					total_employee.setText(Integer.toString(Integer.parseInt(total_employee.getText())-1));
				
					
					}
				
		  		
		  		
		  		
		  		}
		  		
		  		}
					catch(Exception ex1)
					{
						ex1.printStackTrace();
					}
		  		
		  	}
		  });
		  btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 17));
		  btnDelete.setBounds(544, 436, 116, 30);
		  add(btnDelete);
		  
		  try {
			  Statement stmt = null;
			  Connection con = null;
			  Class.forName("com.mysql.cj.jdbc.Driver");
				 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_management?autoReconnect=true&useSSL=false","root","Iloveyou@Raa");
				stmt = (Statement) con.createStatement();
				 ResultSet rs = stmt.executeQuery("select max(empid)+1 from employee");
				 rs.next();
				 eid.setText(rs.getString(1));
				 
				rs = stmt.executeQuery("select count(empid) from employee");
				rs.next();
				total_employee.setText(rs.getString(1));
				
				rs =stmt.executeQuery("select count(empId) from attendance where status = 1 and date = curdate()");
				rs.next();
				present_employee.setText(rs.getString(1));
				
				
				rs = stmt.executeQuery("select count(empid) from attendance where `leave` = 1 and `date` = curdate()");
			    rs.next();
			    on_leave.setText(rs.getString(1));
			   
			        	    
			      
		  }
			catch(Exception t)
		  {
				t.printStackTrace();		  }
			   
				    
					
				JLabel lblNewLabel_1 = new JLabel("Date:");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
				lblNewLabel_1.setBounds(973, 11, 212, 42);
				add(lblNewLabel_1);
				java.util.Date date = new java.util.Date();    
				lblNewLabel_1.setText(lblNewLabel_1.getText()+date);
				lblNewLabel_1.setText(removeSubstring(lblNewLabel_1.getText(),16,28));
				
				JLabel hdate = new JLabel("Hire Date:");
				hdate.setFont(new Font("Tahoma", Font.PLAIN, 17));
				hdate.setBounds(60, 404, 106, 21);
				add(hdate);
				
				hiredate = new JTextField();
				hiredate.setBackground(Color.WHITE);
				hiredate.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
					if( hiredate.getText().equals("format: yyyy-mm-dd"))
					{
						hiredate.setText("");
						hiredate.setForeground(Color.BLACK);
					}
					}
					@Override
					public void mouseExited(MouseEvent e) {
					if( hiredate.getText().equals(""))
					{
						hiredate.setForeground(Color.LIGHT_GRAY);
						hiredate.setText("format: yyyy-mm-dd");
						
					}
					}

				});
				hiredate.setForeground(Color.LIGHT_GRAY);
				hiredate.setToolTipText("format: yyyy-mm-dd");
				hiredate.setDropMode(DropMode.INSERT);
				hiredate.setText("format: yyyy-mm-dd");
				hiredate.setFont(new Font("Tahoma", Font.PLAIN, 15));
				hiredate.setColumns(10);
				hiredate.setBounds(188, 405, 231, 21);
				add(hiredate);
				
				JLabel c_no = new JLabel("Citizenship no:");
				c_no.setFont(new Font("Tahoma", Font.PLAIN, 17));
				c_no.setBounds(714, 373, 134, 21);
				add(c_no);
				
				ctz_no = new JTextField();
				ctz_no.setBackground(Color.WHITE);
				ctz_no.setFont(new Font("Tahoma", Font.PLAIN, 15));
				ctz_no.setColumns(10);
				ctz_no.setBounds(876, 374, 231, 21);
				add(ctz_no);
				
				JLabel lblSearchEmployee = new JLabel("Search employee:");
				lblSearchEmployee.setFont(new Font("Tahoma", Font.PLAIN, 17));
				lblSearchEmployee.setBounds(714, 162, 134, 21);
				add(lblSearchEmployee);
				
				Search = new JTextField();
				Search.setBackground(Color.WHITE);
				Search.addKeyListener(new KeyAdapter() {
					@Override
					public void keyReleased(KeyEvent e) {
						try {
							flag = 0;
							 Connection con = null;
							 	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_management?autoReconnect=true&useSSL=false","root","Iloveyou@Raa");
							    Statement Stmt = null;
							    Stmt = (Statement) con.createStatement();
								DefaultTableModel model = (DefaultTableModel)table.getModel();
								ResultSet rs = null;
								rs = Stmt.executeQuery("select * from employee where emp_name like'"+Search.getText()+"%' or emp_name like'%"+Search.getText()+"' or emp_name like'%"+Search.getText()+"%' ");
								
								
								
								 model = (DefaultTableModel)table.getModel();
								ResultSetMetaData restaurant_management = (ResultSetMetaData) rs.getMetaData();
								int col = restaurant_management.getColumnCount();	
								String [] colname = new String[col];
								
								
								int rows=model.getRowCount();
								
								while(rows>0) {
									rows--;
									model.removeRow(rows);
								}
								
								
								//for managing width
								
								 
								
							for(int i= 0;i<col;i++)
							{
								colname[i] = restaurant_management.getColumnName(i+1);
								model.setColumnIdentifiers(colname);
							}
							table.getColumnModel().getColumn(0).setPreferredWidth(1);
							table.getColumnModel().getColumn(2).setPreferredWidth(2);
							table.getColumnModel().getColumn(3).setPreferredWidth(6);
							table.getColumnModel().getColumn(7).setPreferredWidth(50);
							table.getColumnModel().getColumn(5).setPreferredWidth(15);
							table.getColumnModel().getColumn(6).setPreferredWidth(20);
							table.getColumnModel().getColumn(11).setPreferredWidth(30);
							

							
							while(rs.next()) {
								String[] row = {rs.getString(1),rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7), rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12), rs.getString(13),rs.getString(14)};//name,price,category
								model.addRow(row);
							}
								
								
								
								
								
						}
						catch(Exception er)
						{
							er.printStackTrace();
						}
					}
				});
				Search.setFont(new Font("Tahoma", Font.PLAIN, 15));
				Search.setColumns(10);
				Search.setBounds(876, 163, 231, 21);
				add(Search);
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(28, 493, 1175, 330);
				add(scrollPane);
				
				table = new JTable() {
					
					
					private static final long serialVersionUID = 1L;

				public boolean isCellEditable(int row,int column) {
					return false;
				};
				};
				table.getTableHeader().setResizingAllowed(false);
				table.getTableHeader().setReorderingAllowed(false);
				
				
				table.setShowGrid(false);
				scrollPane.setViewportView(table);
				
				JButton btnNewButton = new JButton("Attendance");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btnNewButton.setBackground(new Color(0, 128, 128));
				btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
				
				btnNewButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						Attendance.main(null);
					}
				});
				
				
				btnNewButton.setBounds(736, 436, 134, 30);
				add(btnNewButton);
				
				
				districtComboBox.setSelectedIndex(-1);
				districtComboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
				districtComboBox.setBounds(355, 290, 154, 21);
				add(districtComboBox);
				
				
				JLabel lblNewLabel_2 = new JLabel("Province:");
				lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblNewLabel_2.setBounds(182, 270, 106, 21);
				add(lblNewLabel_2);
				
				municipality = new JTextField();
				municipality.setBackground(Color.WHITE);
				municipality.setFont(new Font("Tahoma", Font.PLAIN, 15));
				municipality.setColumns(10);
				municipality.setBounds(524, 290, 136, 21);
				add(municipality);
				
				
				
				JLabel lblNewLabel_2_1 = new JLabel("District");
				lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblNewLabel_2_1.setBounds(355, 268, 106, 21);
				add(lblNewLabel_2_1);
				
				JLabel lblNewLabel_2_2 = new JLabel("(Rural) Municipality");
				lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblNewLabel_2_2.setBounds(524, 268, 154, 21);
				add(lblNewLabel_2_2);
				
				JLabel lblNewLabel_2_1_1 = new JLabel("Ward no");
				lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblNewLabel_2_1_1.setBounds(191, 321, 71, 21);
				add(lblNewLabel_2_1_1);
				
				tole = new JTextField();
				tole.setBackground(Color.WHITE);
				tole.setFont(new Font("Tahoma", Font.PLAIN, 15));
				tole.setColumns(10);
				tole.setBounds(283, 343, 136, 21);
				add(tole);
				
				JLabel lblNewLabel_2_1_1_1 = new JLabel("Tole");
				lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblNewLabel_2_1_1_1.setBounds(283, 321, 74, 21);
				add(lblNewLabel_2_1_1_1);
				
				JButton button_1 = new JButton("New button");
				button_1.setBounds(50, 444, 85, 21);
				add(button_1);
				
				JButton btnViewAttendance = new JButton("View Attendance");
				btnViewAttendance.setBackground(new Color(0, 128, 128));
				btnViewAttendance.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						view_staff.main(null);
					}
				});
				btnViewAttendance.setFont(new Font("Tahoma", Font.PLAIN, 17));
				btnViewAttendance.setBounds(916, 436, 175, 30);
				add(btnViewAttendance);
				
				
				
				
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_management","root","Iloveyou@Raa");
					Statement Stmt = (Statement) con.createStatement();
					Statement stmt = (Statement) con.createStatement();
					
				ResultSet   rs = Stmt.executeQuery("Select empid from employee");
				   while( rs.next())
				   {
					stmt.executeUpdate("Insert into restaurant_management.attendance values('"+Integer.parseInt(rs.getString(1))+"',1,curdate(),0)");
					
				   }
				}
				catch(Exception eee)
				{
					eee.printStackTrace();
				}
				
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						hiredate.setEnabled(false);
						try {
							
							Connection con = null;
						 	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_management?autoReconnect=true&useSSL=false","root","Iloveyou@Raa");
						    Statement Stmt = null;
						    Stmt = (Statement) con.createStatement();
							DefaultTableModel model = (DefaultTableModel)table.getModel();
							ResultSet rs = null;
							rs = Stmt.executeQuery("select * from employee where emp_name like'"+model.getValueAt(table.getSelectedRow(),1).toString()+"%' or emp_name like'%"+model.getValueAt(table.getSelectedRow(),1).toString()+"' or emp_name like'%"+model.getValueAt(table.getSelectedRow(),1).toString()+"%' ");
							while(rs.next())
							{
								hiredate.setForeground(Color.BLACK);
								eid.setText(rs.getString(1));
								name.setText(rs.getString(2));
								age.setText(rs.getString(3));
								gender.setSelectedItem(rs.getString(4));
								mobile_no.setText(rs.getString(8));
								position.setSelectedItem(rs.getString(9));
								email.setText(rs.getString(10));
								dept.setSelectedItem(rs.getString(11));
								hiredate.setText(rs.getString(12));
								ctz_no.setText(rs.getString(13));
								municipality.setText(rs.getString(5));
								ward_no.setValue(Integer.parseInt(rs.getString(6)));
								tole.setText(rs.getString(7));
								districtComboBox.setSelectedItem(rs.getString(14));  
								
							}
						}
						

							
						
						catch(Exception rr)
						{ 
							rr.printStackTrace();
								
						}
						
					}
				});
				
				
					
			  
		  }
	}

