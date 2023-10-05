package rms;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;



@SuppressWarnings("serial")
public class setting extends JPanel {
	private userregg user;
	private pwc pwc;
	private table tabl;
	//private man man;

	/**
	 * Create the panel.
	 */
	public setting() {

		
		
		setBounds(0, 0, 1255, 836);
		setLayout(null);
		

		JPanel contentPane = new JPanel();
		contentPane.setBounds(-10, 0,1265, 836);
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		add(contentPane);

		user=new userregg();
		user.setBounds(0, 0, 1259, 708);
		pwc=new pwc();
		pwc.setBackground(new Color(0, 128, 128));
		pwc.setBounds(0, 0, 1600, 909);
		tabl=new table();
		tabl.setBounds(0, 0, 1610, 1058);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 0, 1255, 128);
		panel.setBackground(new Color(0, 128, 128));
		contentPane.add(panel);
		
		
		JPanel paneMenu = new JPanel();
		paneMenu.setBounds(687, 44, 255, 45);
		paneMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			 menuClicked(user);
			}
		});
		panel.setLayout(null);
		panel.add(paneMenu);
		paneMenu.setLayout(null);
		
		JPanel main = new JPanel();
		main.setBounds(10, 127, 1600, 906);
		main.setBackground(new Color(0, 128, 128));
		contentPane.add(main);
		menuClicked(paneMenu);
		
		
		
	
		JPanel paneOrder = new JPanel();
		paneOrder.setBounds(969, 44, 255, 45);
		paneOrder.setBackground(Color.WHITE);
		paneOrder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				menuClicked(pwc);
			}
		});
		panel.add(paneOrder);
		paneOrder.setLayout(null);
		
		
		
		
		
		
		JLabel lblNewLabel = new JLabel("Manage Users");
		lblNewLabel.setIcon(new ImageIcon("icons/user.png"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 235, 23);
		paneMenu.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Change Password");
		lblNewLabel_1.setIcon(new ImageIcon("icons/change.png"));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 11, 213, 29);
		paneOrder.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		
		
		
		
		paneOrder.addMouseListener(new PanelButtonMouseAdapter(paneOrder));
		paneMenu.addMouseListener(new PanelButtonMouseAdapter(paneMenu));
		
		JPanel panemanage = new JPanel();
		panemanage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				menuClicked(tabl);

				
				
			}
		});
		panemanage.setBounds(402, 44, 238, 45);
		panel.add(panemanage);
		panemanage.setLayout(null);
		
		JLabel lbl = new JLabel("Manage Table");
		lbl.setIcon(new ImageIcon("icons/manage.png"));
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		lbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl.setBounds(10, 11, 218, 23);
		panemanage.add(lbl);
		
		
		
		panemanage.addMouseListener(new PanelButtonMouseAdapter(panemanage));
			

		main.setLayout(null);
		main.add(pwc);
		pwc.setLayout(null);
		main.add(tabl);
		tabl.setLayout(null);
		main.add(user);
		user.setLayout(null);
	}
	
	

	
	
	public void menuClicked(JPanel panel) {
		pwc.setVisible(false);
		tabl.setVisible(false);
		user.setVisible(false);	
		
		panel.setVisible(true);
	}
	

	

private class PanelButtonMouseAdapter extends MouseAdapter{
		
		
		JPanel panel;
		public PanelButtonMouseAdapter(JPanel panel) {
			this.panel=panel;
		}
		
		
		@Override
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(Color.CYAN);
			
		}
		@Override
		public void mouseExited(MouseEvent e) {
			panel.setBackground(Color.WHITE);
			
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			panel.setBackground(Color.CYAN);
			
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(Color.CYAN);
			
		}
}
}
