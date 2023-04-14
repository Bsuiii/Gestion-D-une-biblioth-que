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

public class Home extends JFrame {

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
	public Home() {
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
		panel_1.setBounds(0, 0, 294, 149);
		SideBarMenu.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Gestion des Oeuvres et exemplaire");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1.setBounds(20, 109, 263, 29);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setIcon(new ImageIcon(Home.class.getResource("/images/coloredbooks.png")));
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(10, 11, 263, 100);
		panel_1.add(lblNewLabel_1_1);
		
		JPanel panel_1_1 = new JPanel();
	
		panel_1_1.setBackground(new Color(47, 79, 79));
		panel_1_1.setBounds(0, 150, 294, 157);
		SideBarMenu.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gestion Des Emprunts");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 113, 235, 20);
		panel_1_1.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon(Home.class.getResource("/images/emprunter.png")));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_2.setBounds(33, 12, 235, 105);
		panel_1_1.add(lblNewLabel_2);
		
		JPanel panel_1_2 = new JPanel();

		panel_1_2.setBackground(new Color(119, 136, 153));
		panel_1_2.setBounds(0, 301, 294, 156);
		SideBarMenu.add(panel_1_2);
		panel_1_2.setLayout(null);
		
		JLabel lblGestionDesUtilisateurs = new JLabel("Gestion des Utilisateurs");
		lblGestionDesUtilisateurs.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionDesUtilisateurs.setForeground(Color.WHITE);
		lblGestionDesUtilisateurs.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblGestionDesUtilisateurs.setBounds(32, 136, 235, 20);
		panel_1_2.add(lblGestionDesUtilisateurs);
		
		JLabel lblGestionDesUtilisateurs_1 = new JLabel("");
		lblGestionDesUtilisateurs_1.setIcon(new ImageIcon(Home.class.getResource("/images/homme.png")));
		lblGestionDesUtilisateurs_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionDesUtilisateurs_1.setForeground(Color.WHITE);
		lblGestionDesUtilisateurs_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblGestionDesUtilisateurs_1.setBounds(22, 11, 235, 125);
		panel_1_2.add(lblGestionDesUtilisateurs_1);
		
		JPanel panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Authentification auth=new Authentification();
				auth.setVisible(true);
			}
		});
		panel.setLayout(null);
		panel.setBackground(new Color(135, 206, 235));
		panel.setBounds(0, 455, 294, 65);
		SideBarMenu.add(panel);
		
		JLabel lblNewLabel_1_2 = new JLabel("Log Out");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(70, 23, 69, 20);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("");
		lblNewLabel_1_2_1_1.setIcon(new ImageIcon(Home.class.getResource("/images/exit (1).png")));
		lblNewLabel_1_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_2_1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1_2_1_1.setBounds(130, 15, 112, 39);
		panel.add(lblNewLabel_1_2_1_1);
		
		JDesktopPane bureau = new JDesktopPane();
		bureau.setBounds(284, 0, 691, 519);
		contentPane.add(bureau);
		GestionOeuvresExemplaires g=new GestionOeuvresExemplaires();
		g.table.setBounds(68, 247, 413, 630);
		g.getContentPane().setBackground(new Color(0, 128, 128));
		g.setBounds(10, 0, 699, 529);
		bureau.setLayout(null);
		bureau.add(g);
		panel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GestionDesEmprunts ge=new GestionDesEmprunts();
				bureau.removeAll();
				bureau.add(ge);
				
			}
		});
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GestionOeuvresExemplaires ge=new GestionOeuvresExemplaires();
				bureau.removeAll();
				bureau.add(ge);
			}
		});
		panel_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GestionUtilisateur ge=new GestionUtilisateur();
				bureau.removeAll();
				bureau.add(ge);
			}
		});
	}
}
