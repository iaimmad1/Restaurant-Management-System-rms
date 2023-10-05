package rms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class hello extends JFrame {

	private JPanel contentPane;
	private Menu menu;
	private Order order;
	private Billing bill;
	private Inventoryy inventory;
	private Staff staff;
	private Sales sales;
	private Inventoryy inven;
	private setting setting;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hello frame = new hello();
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
	public hello() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1334, 764);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		
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
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 289, 725);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Dashboard");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				hello.main(null);
			}
		});
		btnNewButton.setBounds(0, 0, 289, 54);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Menu");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuClicked(menu);
			}
		});
		btnNewButton_1.setBounds(0, 51, 289, 54);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Order");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuClicked(order);
			}
		});
		btnNewButton_2.setBounds(0, 104, 289, 54);
		panel.add(btnNewButton_2);
		
		JButton btnSignOut = new JButton("Sign Out");
		btnSignOut.setBounds(0, 671, 289, 54);
		panel.add(btnSignOut);
		
		JButton btnBilling = new JButton("Inventory");
		btnBilling.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				menuClicked(inventory);
			}
		});
		btnBilling.setBounds(0, 156, 289, 54);
		panel.add(btnBilling);
		
		JButton btnNewButton_1_1 = new JButton("Sales");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuClicked(sales);
			}
		});
		btnNewButton_1_1.setBounds(0, 207, 289, 54);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_2_1 = new JButton("Staff");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuClicked(staff);
			}
		});
		btnNewButton_2_1.setBounds(0, 260, 289, 54);
		panel.add(btnNewButton_2_1);
		
		JButton btnSettings = new JButton("Settings");
		btnSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuClicked(setting);
			}
		});
		btnSettings.setBounds(0, 312, 289, 54);
		panel.add(btnSettings);
		
		JButton btnNewButton_1_2 = new JButton("Manage Tables");
		btnNewButton_1_2.setBounds(0, 363, 289, 54);
		panel.add(btnNewButton_1_2);
		
		JPanel main = new JPanel();
		main.setBounds(287, 0, 1031, 725);
		contentPane.add(main);
		
		
		
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
		
		
		
	}
	
	protected void hello() {
		// TODO Auto-generated method stub
		
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
	
	
}

