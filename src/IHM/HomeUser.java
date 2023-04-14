package IHM;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class HomeUser extends JFrame {

	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public HomeUser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 984, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel SideBarMenu = new JPanel();
		SideBarMenu.setBackground(new Color(240, 255, 255));
		SideBarMenu.setBounds(0, 0, 294, 519);
		contentPane.add(SideBarMenu);
		SideBarMenu.setLayout(null);
		
		JPanel panel_1 = new JPanel();

		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(0, 0, 294, 456);
		SideBarMenu.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Gestion des Oeuvres et exemplaire");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1.setBounds(20, 241, 263, 29);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setIcon(new ImageIcon(HomeUser.class.getResource("/images/coloredbooks.png")));
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(10, 143, 263, 100);
		panel_1.add(lblNewLabel_1_1);
		
		JPanel panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Authentification auth=new Authentification();
				auth.setVisible(true);
				
			}
		});
		panel.setBackground(new Color(135, 206, 235));
		panel.setBounds(0, 454, 294, 65);
		SideBarMenu.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1_2 = new JLabel("Log Out");
		lblNewLabel_1_2.setBounds(82, 11, 69, 20);
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1.setIcon(new ImageIcon(HomeUser.class.getResource("/images/exit (1).png")));
		lblNewLabel_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_1_2_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1_2_1.setBounds(112, 5, 112, 39);
		panel.add(lblNewLabel_1_2_1);
		
		JDesktopPane bureau = new JDesktopPane();
		bureau.setBounds(284, 0, 691, 519);
		contentPane.add(bureau);
		GestionOeuvresExemplaires g=new GestionOeuvresExemplaires();
		g.table.setBounds(68, 247, 413, 630);
		g.getContentPane().setBackground(new Color(0, 128, 128));
		g.setBounds(10, 0, 699, 529);
		bureau.setLayout(null);
		bureau.add(g);
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GestionOeuvresExemplaires ge=new GestionOeuvresExemplaires();
				bureau.removeAll();
				bureau.add(ge);
			}
		});
	}
}
