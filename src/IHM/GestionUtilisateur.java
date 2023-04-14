package IHM;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

import Entity.Login;
import Entity.Oeuvre;
import Entity.Usager;
import control.LoginControl;
import control.OeuvreControl;
import control.UsagerControl;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GestionUtilisateur extends JInternalFrame {
	private JTextField txtNom;
	private JTextField txtPrenom;
	private JTextField txtAdr;
	private JTextField txtTel;
	private JTextField txtDateN;
	private JTable table;
	private JComboBox cmbTitle,cmbRole ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionUtilisateur frame = new GestionUtilisateur();
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
	public GestionUtilisateur() {
		getContentPane().setBackground(new Color(119, 136, 153));
		setBounds(0, 0, 789, 645);
		setVisible(true);
		getContentPane().setLayout(null);
		
		JPanel panListeOeuvre = new JPanel();
		panListeOeuvre.setBorder(BorderFactory.createTitledBorder("Information Personelle"));
		panListeOeuvre.setBackground(new Color(119, 136, 153));
		panListeOeuvre.setBounds(10, 37, 751, 231);
		getContentPane().add(panListeOeuvre);
		
		JLabel lblNewLabel = new JLabel("Titre");
		lblNewLabel.setBounds(27, 27, 113, 22);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		JLabel lblNewLabel_1 = new JLabel("Nom");
		lblNewLabel_1.setBounds(382, 27, 113, 22);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		txtNom = new JTextField();
		txtNom.setBounds(499, 29, 190, 20);
		txtNom.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Prenom");
		lblNewLabel_2.setBounds(27, 86, 113, 22);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		txtPrenom = new JTextField();
		txtPrenom.setBounds(144, 88, 190, 20);
		txtPrenom.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Adresse");
		lblNewLabel_3.setBounds(382, 88, 113, 22);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		txtAdr = new JTextField();
		txtAdr.setBounds(499, 90, 190, 20);
		txtAdr.setColumns(10);
		
	    cmbTitle = new JComboBox();
		cmbTitle.setBounds(144, 28, 190, 22);
		cmbTitle.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mr", "Mme"}));
		JLabel lblNewLabel_2_1 = new JLabel("Telephone");
		lblNewLabel_2_1.setBounds(27, 137, 113, 22);
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		txtTel = new JTextField();
		txtTel.setBounds(144, 139, 190, 20);
		txtTel.setColumns(10);
		panListeOeuvre.setLayout(null);
		panListeOeuvre.add(lblNewLabel_2_1);
		panListeOeuvre.add(txtTel);
		panListeOeuvre.add(lblNewLabel_2);
		panListeOeuvre.add(txtPrenom);
		panListeOeuvre.add(lblNewLabel);
		panListeOeuvre.add(cmbTitle);
		panListeOeuvre.add(lblNewLabel_1);
		panListeOeuvre.add(txtNom);
		panListeOeuvre.add(lblNewLabel_3);
		panListeOeuvre.add(txtAdr);
		
		JLabel lblNewLabel_2_2 = new JLabel("Date Naissance");
		lblNewLabel_2_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_2_2.setBounds(382, 137, 113, 22);
		panListeOeuvre.add(lblNewLabel_2_2);
		
		txtDateN = new JTextField();
		txtDateN.setColumns(10);
		txtDateN.setBounds(499, 139, 190, 20);
		panListeOeuvre.add(txtDateN);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(314, 177, 379, 43);
		panListeOeuvre.add(panel);
		
		JButton ajouterBouton = new JButton();
		ajouterBouton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
				try {
					f.parse(txtDateN.getText());
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Format du date est incorrecte essayer :yyyy-MM-dd");
				}
				try {

					UsagerControl uc=new UsagerControl();
					Usager user=new Usager();
					user.setId(uc.getNewId());
					user.setAdresse(txtAdr.getText());
					user.setDateNais(f.parse(txtDateN.getText()));
					user.setTel(txtTel.getText());
					user.setNom(txtNom.getText());
					user.setPrenom(txtPrenom.getText());
					
					Login login=new Login();
					LoginControl logcl=new LoginControl();
					login.setLog(user.getNom()+user.getPrenom()+"@gmail.com");
					login.setMdp(user.getNom()+"1234");
					login.setRole(cmbRole.getSelectedItem().toString());
					login.setUser(user);
					String sexe="Male";
					if(!cmbTitle.getSelectedItem().toString().equalsIgnoreCase("Mr"))
					sexe="Femelle";
					user.setSexe(sexe);
					if(uc.insert(user) && logcl.insert(login)) {
						JOptionPane.showMessageDialog(null, "Ajout Avec Succée");
						listing();
					}else
						JOptionPane.showMessageDialog(null, "Echec D'ajout");
					
				}
				catch(Exception ex) {
					
				}
				
			}
		});
		ajouterBouton.setText("Ajouter");
		ajouterBouton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		ajouterBouton.setAlignmentY(1.0f);
		ajouterBouton.setAlignmentX(1.0f);
		ajouterBouton.setBounds(10, 11, 93, 29);
		panel.add(ajouterBouton);
		
		JButton cmdUpdate = new JButton();
		cmdUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
				try {
					f.parse(txtDateN.getText());
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Format du date est incorrecte essayer :yyyy-MM-dd");
				}
				try {
					int row =table.getSelectedRow();
					int val =Integer.parseInt(table.getValueAt(row,0).toString());
					UsagerControl uc=new UsagerControl();
					Usager user=new Usager();
					user.setId(val);
					user.setAdresse(txtAdr.getText());
					user.setDateNais(f.parse(txtDateN.getText()));
					user.setTel(txtTel.getText());
					user.setNom(txtNom.getText());
					user.setPrenom(txtPrenom.getText());
					String sexe="Male";
					if(!cmbTitle.getSelectedItem().toString().equalsIgnoreCase("Mr"))
					sexe="Femelle";
					user.setSexe(sexe);
					if(uc.update(user)) {
						JOptionPane.showMessageDialog(null, "Modifié Avec Succée");
					     listing();
					}else
						JOptionPane.showMessageDialog(null, "Echec");
					
				}
				catch(Exception ex) {
					
				}

			}
		});
		cmdUpdate.setText("Modifier");
		cmdUpdate.setFont(new Font("Times New Roman", Font.BOLD, 18));
		cmdUpdate.setEnabled(false);
		cmdUpdate.setBounds(122, 11, 101, 29);
		panel.add(cmdUpdate);
		
		JButton cmdDel = new JButton();
		cmdDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					    int row =table.getSelectedRow();
						int val =Integer.parseInt(table.getValueAt(row,0).toString());
						UsagerControl uc=new UsagerControl();
						Usager user=new Usager();
						LoginControl lgl=new LoginControl();
						user.setId(val);
						Login login=new Login();
						login.setUser(user);
						
						if(lgl.delete(login) && uc.delete(user)) {
							JOptionPane.showMessageDialog(null, "Supression Avec Succée");
						     listing();
						}else
							JOptionPane.showMessageDialog(null, "Echec");
				} catch (Exception e2) {
					// TODO: handle exception
				}	
				  

			}
		});
		cmdDel.setText("Supprimer");
		cmdDel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		cmdDel.setEnabled(false);
		cmdDel.setBounds(233, 11, 117, 29);
		panel.add(cmdDel);
		
		JLabel lblNewLabel_4 = new JLabel("Role");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(27, 177, 113, 22);
		panListeOeuvre.add(lblNewLabel_4);
		
		cmbRole = new JComboBox();
		cmbRole.setBounds(144, 178, 104, 22);
		cmbRole.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "User", "Bibiliochetaire"}));
		panListeOeuvre.add(cmbRole);
		
		JPanel panListeOeuvre_1 = new JPanel();
		panListeOeuvre_1.setBorder(BorderFactory.createTitledBorder("Liste des Oeuvres"));
		panListeOeuvre_1.setBackground(new Color(119, 136, 153));
		panListeOeuvre_1.setBounds(10, 301, 751, 268);
		getContentPane().add(panListeOeuvre_1);
		
		JScrollPane jScrollPane1 = new JScrollPane();
		jScrollPane1.setBackground(Color.WHITE);
		GroupLayout gl_panListeOeuvre_1 = new GroupLayout(panListeOeuvre_1);
		gl_panListeOeuvre_1.setHorizontalGroup(
			gl_panListeOeuvre_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panListeOeuvre_1.createSequentialGroup()
					.addGap(24)
					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 648, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(57, Short.MAX_VALUE))
		);
		gl_panListeOeuvre_1.setVerticalGroup(
			gl_panListeOeuvre_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panListeOeuvre_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(39, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cmdUpdate.setEnabled(true);
				cmdDel.setEnabled(true);
				int row =table.getSelectedRow();
				int val =Integer.parseInt(table.getValueAt(row,0).toString());
				UsagerControl uc=new UsagerControl();
				Usager user=uc.getById(val);
				txtNom.setText(user.getNom());
				txtPrenom.setText(user.getPrenom());
				txtAdr.setText(user.getAdresse());
				txtTel.setText(user.getTel());
				String sexe="Mr";
				if(!user.getSexe().equalsIgnoreCase("Mr"));
				sexe="Mme";
				cmbTitle.setSelectedItem(sexe);
				txtDateN.setText(user.getDateNais().toString());
				
			}
		});
		table.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "ID", "Nom", "Prenom", "DateNaissance", "Sexe", "Telephone", "Adresse"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
		jScrollPane1.setViewportView(table);
		panListeOeuvre_1.setLayout(gl_panListeOeuvre_1);
		setBorder(null);
        BasicInternalFrameUI bui=(BasicInternalFrameUI) this.getUI();
        bui.setNorthPane(null);
        listing();

	}
	private void listing(){
    	try {
    		UsagerControl userC= new UsagerControl();
        	ArrayList<Usager> allU= userC.getAll();
        	DefaultTableModel m=(DefaultTableModel)table.getModel();
        	m.setNumRows(0);
        	for(Usager o:allU)
        	    m.addRow(new Object[] {o.getId(),o.getNom(),o.getPrenom(),o.getDateNais(),o.getSexe(),o.getTel(),o.getAdresse()});	
    	} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
    	
    	}

}
