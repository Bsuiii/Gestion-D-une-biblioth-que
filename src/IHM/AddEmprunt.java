package IHM;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import Entity.Emprunt;
import Entity.Exemplaire;
import Entity.Oeuvre;
import Entity.TypeOeuvre;
import Entity.Usager;
import control.EmpruntControl;
import control.ExemplaireControl;
import control.TypeController;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddEmprunt extends JFrame {

	private JPanel contentPane;
	private JTextField txtUser;
	private JTextField txtOeuvre;
	private JTextField txtDate;
	private JComboBox cmbExemp;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddEmprunt frame = new AddEmprunt();
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
	public AddEmprunt(Usager u,Oeuvre o) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				txtUser.setText(u.getNom()+" "+u.getPrenom());
				txtOeuvre.setText(o.getTitre());
				ArrayList<Exemplaire> exes;
				ExemplaireControl ctrE = new ExemplaireControl();
					cmbExemp.removeAllItems();
					exes=ctrE.getAllByOeuvre(o);
					for(Exemplaire ex:exes){
						cmbExemp.addItem(ex.getEtat());
					}
					
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 781, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(new Color(240, 255, 255));
		contentPane_1.setBounds(0, 0, 821, 372);
		contentPane.add(contentPane_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 255, 255));
		panel.setBounds(817, 345, -807, -346);
		contentPane_1.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(10, 263, 787, 61);
		contentPane_1.add(panel_1);
		
		JButton cmdCon = new JButton("Ajouter");
		cmdCon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
				try {
					f.parse(txtDate.getText());
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Format du date est incorrecte essayer :yyyy-MM-dd");
				}
				EmpruntControl ec=new EmpruntControl();
				Emprunt emp=new Emprunt();
				ExemplaireControl exc=new ExemplaireControl();
				try {
					emp.setDateEmprunt(f.parse(f.format(new Date())));
					emp.setDateRetourPrevu(f.parse(txtDate.getText()));
					emp.setExemplairesEmprunt(exc.getByEtat(cmbExemp.getSelectedItem().toString()));
					emp.setUsagerEmprunt(u);
					emp.setDateRetourEffective(null);
					System.out.println(emp);
					if(ec.insert(emp))
						JOptionPane.showMessageDialog(null,"Emprunter Avec Succée");
					else
						JOptionPane.showMessageDialog(null,"Echec d'operation");
						
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
			
				
			}
		});
		cmdCon.setFont(new Font("Times New Roman", Font.BOLD, 16));
		cmdCon.setBorder(new LineBorder(new Color(255, 250, 240), 2, true));
		cmdCon.setBackground(Color.WHITE);
		cmdCon.setBounds(206, 11, 144, 31);
		panel_1.add(cmdCon);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnAnnuler.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnAnnuler.setBorder(new LineBorder(new Color(255, 250, 240), 2, true));
		btnAnnuler.setBackground(Color.WHITE);
		btnAnnuler.setBounds(438, 11, 144, 31);
		panel_1.add(btnAnnuler);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setForeground(new Color(95, 158, 160));
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panel_2.setBackground(new Color(95, 158, 160));
		panel_2.setBounds(10, 11, 787, 32);
		contentPane_1.add(panel_2);
		
		JLabel lblClose = new JLabel("X");
		lblClose.setVerticalAlignment(SwingConstants.TOP);
		lblClose.setHorizontalAlignment(SwingConstants.CENTER);
		lblClose.setForeground(Color.LIGHT_GRAY);
		lblClose.setFont(new Font("Sitka Heading", Font.BOLD, 27));
		lblClose.setBackground(Color.GRAY);
		lblClose.setBounds(760, 0, 17, 21);
		panel_2.add(lblClose);
		
		JLabel lbltitre = new JLabel("Mr/Mme");
		lbltitre.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lbltitre.setBounds(45, 79, 102, 32);
		contentPane_1.add(lbltitre);
		
		txtUser = new JTextField();
		txtUser.setEditable(false);
		txtUser.setColumns(10);
		txtUser.setBounds(157, 80, 242, 32);
		contentPane_1.add(txtUser);
		
		JLabel lblAuteur = new JLabel("Ouevre");
		lblAuteur.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblAuteur.setBounds(409, 79, 90, 32);
		contentPane_1.add(lblAuteur);
		
		txtOeuvre = new JTextField();
		txtOeuvre.setEditable(false);
		txtOeuvre.setColumns(10);
		txtOeuvre.setBounds(496, 80, 263, 32);
		contentPane_1.add(txtOeuvre);
		
		JLabel lblCategorie = new JLabel("Date Retour Prévu");
		lblCategorie.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblCategorie.setBounds(45, 192, 218, 32);
		contentPane_1.add(lblCategorie);
		
		txtDate = new JTextField();
		txtDate.setColumns(10);
		txtDate.setBounds(289, 196, 301, 32);
		contentPane_1.add(txtDate);
		
	    cmbExemp = new JComboBox();
		cmbExemp.setBounds(172, 136, 242, 32);
		contentPane_1.add(cmbExemp);
		
		JLabel lblExemplaire = new JLabel("Exemplaire");
		lblExemplaire.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblExemplaire.setBounds(45, 132, 117, 32);
		contentPane_1.add(lblExemplaire);
		
	}
}
