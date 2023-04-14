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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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

import Entity.Emprunt;
import Entity.Exemplaire;
import Entity.Oeuvre;
import Entity.TypeOeuvre;
import Util.Exceprtions;
import Util.ModelTableau;
import control.EmpruntControl;
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

public class Emprunted extends JFrame{

	private JPanel contentPane;
	private ExemplaireControl ctrExe;
	private JTable table;
	  private Object dataLigneSelected[];
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
	public Emprunted() {
		setUndecorated(true);
		setEnabled(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 821, 458);
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
		panel_1.setBounds(10, 366, 787, 61);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton cmdCon = new JButton("Rendre");
		cmdCon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
					int row =table.getSelectedRow();
					int val =Integer.parseInt(table.getValueAt(row,0).toString());
					if(row==-1) {
						JOptionPane.showMessageDialog(null, "Veuiller choisir une ligne svp");
						return;
					}
					Emprunt emp=new Emprunt();
					EmpruntControl empC=new EmpruntControl();
					emp.setId(val);
					emp.setDateRetourEffective(f.parse(f.format(new Date())));
					if(empC.updateDateRetourEffective(emp))
						JOptionPane.showMessageDialog(null, "Success");
					else
						JOptionPane.showMessageDialog(null, "Echec");
						
					
				} catch (Exception e2) {
					
				}
	    listing();
			}
		});
		cmdCon.setFont(new Font("Times New Roman", Font.BOLD, 16));
		cmdCon.setBorder(new LineBorder(new Color(255, 250, 240), 2, true));
		cmdCon.setBackground(Color.WHITE);
		cmdCon.setBounds(245, 11, 144, 31);
		panel_1.add(cmdCon);
		
		JButton btnAnnuler_1 = new JButton("Annuler");
		btnAnnuler_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnAnnuler_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnAnnuler_1.setBorder(new LineBorder(new Color(255, 250, 240), 2, true));
		btnAnnuler_1.setBackground(Color.WHITE);
		btnAnnuler_1.setBounds(417, 11, 144, 31);
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
		
		JPanel panListeOeuvre = new JPanel();
		panListeOeuvre.setBorder(BorderFactory.createTitledBorder("Liste des Oeuvres"));
		panListeOeuvre.setBackground(new Color(224, 255, 255));
		panListeOeuvre.setBounds(55, 71, 685, 272);
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
	       table.setModel(new DefaultTableModel(
	                new Object[][]{},
	                new String[]{
	                    "ID", "Utilisateur","Oeuvre","Etat"
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
			listing();
					
			}
		});


	}

	
    private void listing(){
    	try {
    		EmpruntControl ctrEmp=new EmpruntControl();
        	ArrayList<Emprunt> tab= ctrEmp.getAll();
        	DefaultTableModel m=(DefaultTableModel)table.getModel();
        	m.setNumRows(0);
        	for(Emprunt e:tab)
        	    m.addRow(new Object[] {e.getId(),e.getUsagerEmprunt().getNom()+" "+e.getUsagerEmprunt().getNom(),e.getExemplairesEmprunt().getOeuvresExamplaire().getTitre(),e.getExemplairesEmprunt().getEtat()});	
    	} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
    	
    	}

	}


