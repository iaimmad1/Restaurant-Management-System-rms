package rms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Attendance extends JFrame {

	private JPanel contentPane;
	private Dashboard d;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Attendance frame = new Attendance();
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
	public Attendance() {
		int distance = 1;
		setBounds(255, 11, 1213, 845);

		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("  EmpID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(73, 59, 84, 21);
		contentPane.add(lblNewLabel);

		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblName.setBounds(178, 59, 84, 21);
		contentPane.add(lblName);

		JLabel lblAttendance = new JLabel("Attendance");
		lblAttendance.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblAttendance.setBounds(346, 59, 103, 21);
		contentPane.add(lblAttendance);


		JLabel lbl_leave = new JLabel("leave");
		lbl_leave.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_leave.setBounds(480, 59, 103, 21);
		contentPane.add(lbl_leave);





		//		final JRadioButton rdbtnNewRadioButton = new JRadioButton("Absent");
		//		
		//		rdbtnNewRadioButton.setBounds(330, 75  + 19, 84, 21);
		//		contentPane.add(rdbtnNewRadioButton);




		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_management?autoReconnect=true&useSSL=false","root","Iloveyou@Raa");
			final Statement Stmt = (Statement) con.createStatement();
			ResultSet rs = null;
			rs = Stmt.executeQuery("select empid,emp_name from employee");



			while(rs.next())
			{

				final int id = Integer.parseInt(rs.getString(1));
				JLabel lblEmpid = new JLabel("");
				lblEmpid.setFont(new Font("Tahoma", Font.PLAIN, 17));
				lblEmpid.setBounds(92, 73+distance * 23,283, 21);
				contentPane.add(lblEmpid);
				lblEmpid.setText(String.format("%3s",rs.getString(1)));
				lblEmpid.setText(lblEmpid.getText()+ String.format("     %-20s", rs.getString(2)));

				final JRadioButton status = new JRadioButton("Present");
				status.setBounds(350, 75  + 23*distance, 84, 21);
				status.setSelected(false);
				contentPane.add(status);

				final JRadioButton leave = new JRadioButton("");
				leave.setBounds(480, 75  + 23*distance, 84, 21);
				leave.setSelected(false);
				contentPane.add(leave);

				ResultSet ps = null;
				Statement smt =(Statement) con.createStatement();
				ps = smt.executeQuery("select status from attendance where empid = '"+rs.getString(1)+"' and date = curdate()");
				ps.next();




				if(Integer.parseInt(ps.getString(1))== 1)
				{
					status.setSelected(true);
					status.setText("Present");


				}
				else
				{
					status.setSelected(false);
					status.setText("Absent");

				}

				ResultSet s = smt.executeQuery("select `leave` from attendance where empid = '"+rs.getString(1)+"' and date = curdate()");

				s.next();
				if(Integer.parseInt(s.getString(1))== 1)
				{
					leave.setSelected(true);
					leave.setText("On leave");


				}
				else
				{
					leave.setSelected(false);
					leave.setText("On Duty");

				}

				status.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {

						if(status.isSelected())
						{   leave.setSelected(false);
						status.setText("Present");
						try {
							Stmt.executeUpdate("Update attendance set `status` = 1 where empid ='"+id+"' and date = curdate() ");
						} catch (SQLException e1) {

							e1.printStackTrace();
						}

						}

						else {
							status.setText("Absent");
							System.out.println(id);
							try {
								Stmt.executeUpdate("Update attendance set `status` = 0 where empid = '"+id+"' and date = curdate() ");
							} catch (SQLException e1) {

								e1.printStackTrace();
							}

						}
					}
				});
				leave.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {

						if(leave.isSelected())
						{
							status.setSelected(false);
							status.setText("Absent");

							try {
								Stmt.executeUpdate("UPDATE `restaurant_management`.`attendance` SET `leave` = 1 WHERE (EmpID = '"+id+"') and (Date = curdate())");
							} catch (SQLException e1) {

								e1.printStackTrace();
							}

						}
						else {
							status.setSelected(true);
							status.setText("Present");

							try {
								Stmt.executeUpdate("UPDATE `restaurant_management`.`attendance` SET `leave` = 0 WHERE (EmpID = '"+id+"') and (Date = curdate()) ");
							} catch (SQLException e1) {

								e1.printStackTrace();
							}
						}
					}
				});

				distance ++;
			}
		}
		catch(Exception er)
		{
			er.printStackTrace();
		}

		distance = distance +2;
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {



				dispose();


			}
		});
	
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(350, 75  + 23*distance, 84, 21);
		contentPane.add(btnNewButton);


	}
}