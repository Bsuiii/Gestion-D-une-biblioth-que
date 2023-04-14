package IHM;

import static java.lang.Integer.parseInt;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Entity.Exemplaire;
import Entity.Oeuvre;
import Entity.TypeOeuvre;
import Util.Exceprtions;
import Util.ModelTableau;
import control.ExemplaireControl;
import control.OeuvreControl;
import control.TypeController;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Component;
import javax.swing.ListSelectionModel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionExemplaire extends JFrame implements MouseListener{

	private JPanel contentPane;
    private JTextField txtTitre;
	private JTextField txtAuteur;
	private JTextField txtCat;
	private ExemplaireControl ctrExe;
	private JTable table;
	private JComboBox cmbEtat ;
	  private Object dataLigneSelected[];
	  private JButton cmdUpdate,cmdDelete;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionExemplaire frame = new GestionExemplaire();
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
	public GestionExemplaire(Oeuvre o) {
		setUndecorated(true);
		setEnabled(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 821, 648);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        
       		setContentPane(contentPane);
		
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 255, 255));
		panel.setBounds(817, 345, -807, -346);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 263, 787, 61);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton cmdCon = new JButton("Ajouter");
		cmdCon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		ExemplaireControl ExControl=new ExemplaireControl();
	    Exemplaire ex=new Exemplaire();
	    ex.setEtat(cmbEtat.getSelectedItem().toString());
	    ex.setOeuvresExamplaire(o);
	    if(ExControl.insert(ex)) JOptionPane.showMessageDialog(null, "Ajout Avec Succées");
	    else JOptionPane.showMessageDialog(null, "Echec D'Ajout");
	    listing();
			}
		});
		cmdCon.setFont(new Font("Times New Roman", Font.BOLD, 16));
		cmdCon.setBorder(new LineBorder(new Color(255, 250, 240), 2, true));
		cmdCon.setBackground(Color.WHITE);
		cmdCon.setBounds(104, 11, 144, 31);
		panel_1.add(cmdCon);
		
	    cmdDelete = new JButton("Supprimer");
	    cmdDelete.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		int row =table.getSelectedRow();
			    int val =Integer.parseInt(table.getValueAt(row, 0).toString());
			    ExemplaireControl xc=new ExemplaireControl();
			    Exemplaire ex=xc.getById(val);
				    if(xc.delete(ex)) {
				    	JOptionPane.showMessageDialog(null, "Suppression Avec Succées");
				    	listing();
				    }else JOptionPane.showMessageDialog(null, "Echec de Suppression");
				

			}
	    	
	    });
		cmdDelete.setFont(new Font("Times New Roman", Font.BOLD, 16));
		cmdDelete.setBorder(new LineBorder(new Color(255, 250, 240), 2, true));
		cmdDelete.setBackground(Color.WHITE);
		cmdDelete.setBounds(412, 11, 144, 31);
		panel_1.add(cmdDelete);
		
		 cmdUpdate = new JButton("Modifier");
		cmdUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row =table.getSelectedRow();
			    int val =Integer.parseInt(table.getValueAt(row, 0).toString());
			    ExemplaireControl xc=new ExemplaireControl();
			    Exemplaire ex=xc.getById(val);
				ex.setId(val);
				ex.setEtat(cmbEtat.getSelectedItem().toString());
				    if(xc.Update(ex)) {
				    	JOptionPane.showMessageDialog(null, "Modifier Avec Succées");
				    	listing();
				    }else JOptionPane.showMessageDialog(null, "Echec de modification");
				

			}
		});
		cmdUpdate.setFont(new Font("Times New Roman", Font.BOLD, 16));
		cmdUpdate.setBorder(new LineBorder(new Color(255, 250, 240), 2, true));
		cmdUpdate.setBackground(Color.WHITE);
		cmdUpdate.setBounds(258, 11, 144, 31);
		panel_1.add(cmdUpdate);
		
		JButton btnAnnuler_1 = new JButton("Annuler");
		btnAnnuler_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnAnnuler_1.setBorder(new LineBorder(new Color(255, 250, 240), 2, true));
		btnAnnuler_1.setBackground(Color.WHITE);
		btnAnnuler_1.setBounds(577, 11, 144, 31);
		panel_1.add(btnAnnuler_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setForeground(new Color(95, 158, 160));
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panel_2.setBackground(new Color(95, 158, 160));
		panel_2.setBounds(10, 13, 787, 32);
		contentPane.add(panel_2);
		
		JLabel lblClose = new JLabel("X");
		lblClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				dispose();
			}
		});

		lblClose.setVerticalAlignment(SwingConstants.TOP);
		lblClose.setHorizontalAlignment(SwingConstants.CENTER);
		lblClose.setForeground(Color.LIGHT_GRAY);
		lblClose.setFont(new Font("Sitka Heading", Font.BOLD, 27));
		lblClose.setBackground(Color.GRAY);
		lblClose.setBounds(760, 0, 17, 21);
		panel_2.add(lblClose);
		
		JLabel lbltitre = new JLabel("Titre");
		lbltitre.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lbltitre.setBounds(45, 79, 90, 32);
		contentPane.add(lbltitre);
		
	    cmbEtat = new JComboBox();
		cmbEtat.setBounds(562, 193, 197, 32);
		cmbEtat.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
		cmbEtat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Neuf", "Bon", "Vieux" }));
        cmbEtat.setPreferredSize(new java.awt.Dimension(123, 26));
		contentPane.add(cmbEtat);
		
		txtTitre = new JTextField();
		txtTitre.setEnabled(false);
		txtTitre.setBounds(157, 80, 197, 32);
		contentPane.add(txtTitre);
		txtTitre.setColumns(10);
		
		JLabel lbltitre_1 = new JLabel("Etat");
		lbltitre_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lbltitre_1.setBounds(450, 189, 90, 32);
		contentPane.add(lbltitre_1);
		
		JLabel lblAuteur = new JLabel("Auteur");
		lblAuteur.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblAuteur.setBounds(450, 79, 90, 32);
		contentPane.add(lblAuteur);
		
		txtAuteur = new JTextField();
		txtAuteur.setEditable(false);
		txtAuteur.setColumns(10);
		txtAuteur.setBounds(562, 80, 197, 32);
		contentPane.add(txtAuteur);
		
		JLabel lblCategorie = new JLabel("Categorie");
		lblCategorie.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblCategorie.setBounds(45, 192, 107, 32);
		contentPane.add(lblCategorie);
		
		txtCat = new JTextField();
		txtCat.setEditable(false);
		txtCat.setColumns(10);
		txtCat.setBounds(157, 193, 197, 32);
		contentPane.add(txtCat);
		
		JPanel panListeOeuvre = new JPanel();
		panListeOeuvre.setBorder(BorderFactory.createTitledBorder("Liste des Oeuvres"));
		panListeOeuvre.setBackground(new Color(224, 255, 255));
		panListeOeuvre.setBounds(45, 335, 685, 272);
		contentPane.add(panListeOeuvre);
		
		JScrollPane jScrollPane1 = new JScrollPane();
		jScrollPane1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		jScrollPane1.setBackground(Color.WHITE);
		GroupLayout gl_panListeOeuvre = new GroupLayout(panListeOeuvre);
		gl_panListeOeuvre.setHorizontalGroup(
			gl_panListeOeuvre.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panListeOeuvre.createSequentialGroup()
					.addGap(65)
					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 563, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(35, Short.MAX_VALUE))
		);
		gl_panListeOeuvre.setVerticalGroup(
			gl_panListeOeuvre.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panListeOeuvre.createSequentialGroup()
					.addContainerGap(49, Short.MAX_VALUE)
					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
					.addGap(39))
		);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row =table.getSelectedRow();
			    int val =Integer.parseInt(table.getValueAt(row, 0).toString());
			    ExemplaireControl xc=new ExemplaireControl();
			    Exemplaire ex=xc.getById(val);
			    System.out.println(ex);
			    txtTitre.setText(ex.getOeuvresExamplaire().getTitre());
			    txtAuteur.setText(ex.getOeuvresExamplaire().getAuteur());
			    txtCat.setText(ex.getOeuvresExamplaire().getCategorie());
				ex.setId(val);
				ex.setEtat(cmbEtat.getSelectedItem().toString());
				cmbEtat.setSelectedItem(table.getValueAt(row, 1).toString());
			}
		});
	       table.setModel(new DefaultTableModel(
	                new Object[][]{},
	                new String[]{
	                    "ID", "Etat"
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
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setRowHeight(30);
		panListeOeuvre.setLayout(gl_panListeOeuvre);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
		    txtTitre.setText(o.getTitre());
		    txtAuteur.setText(o.getAuteur());
		    txtCat.setText(o.getCategorie());
		    
			listing();
					
			}
		});


	}
	@Override
    public void mouseReleased(MouseEvent e) {
        int row = table.getSelectedRow();
        int nbreCol = table.getColumnCount();

        dataLigneSelected = new Object[nbreCol];
        if (row >= 0) {
            for (int i = 0; i < nbreCol; i++) {
                dataLigneSelected[i] = table.getModel().getValueAt(row, i);
            }
            cmdUpdate.setEnabled(true);
            cmdDelete.setEnabled(true);
        } else {
        	cmdUpdate.setEnabled(false);
        	cmdDelete.setEnabled(false);
        }
    }

	 private Oeuvre getOeuvreInfos() {
	        Oeuvre oeuvre = null;
	        if (table.getSelectedRow() != -1) {
	            int id = parseInt(dataLigneSelected[0].toString());
	            String titre = dataLigneSelected[1].toString();
	            String auteur = dataLigneSelected[2].toString();
	            String categorie = dataLigneSelected[3].toString();
	            String typeOeuvre = dataLigneSelected[4].toString();
	            int nbExemplaire = parseInt(dataLigneSelected[5].toString());
	            int nbResa = parseInt(dataLigneSelected[6].toString());
	                
	            oeuvre = new Oeuvre(id, titre, auteur, categorie, nbResa,nbExemplaire,0,null);
	        }
	        return oeuvre;

	    }
    private void listing(){
    	try {
    		ctrExe=new ExemplaireControl();
        	ArrayList<Exemplaire> allOv= ctrExe.getAll();
        	DefaultTableModel m=(DefaultTableModel)table.getModel();
        	m.setNumRows(0);
        	for(Exemplaire o:allOv)
        	    m.addRow(new Object[] {o.getId(),o.getEtat()});	
    	} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
    	
    	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	}


