package control;

import dao.Connect;


import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Entity.Emprunt;
import Entity.Exemplaire;
import Entity.Oeuvre;
import Entity.Usager;
import Util.Exceprtions;

public class EmpruntControl {

    
        public boolean insert(Emprunt o){
        	try {
        		String query= "INSERT INTO `emprunt`(`ExemplaireId`, `UsagerID`, `DateEmprunt`, `DateRetourPrevu`, `DateRetourEffective`) VALUES (?,?,?,?,?)";
        		PreparedStatement st=Connect.getConnect().getCon().prepareStatement(query);
        		SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
        		st.setInt(1, o.getExemplairesEmprunt().getId());
        		st.setInt(2, o.getUsagerEmprunt().getId());
        		st.setDate(3,new java.sql.Date(o.getDateEmprunt().getTime()));
        		st.setDate(4, new java.sql.Date(o.getDateRetourPrevu().getTime()));
        		st.setDate(5,null);
        		st.execute();
        		st.close();
        		return true;
    		} catch (Exception e) {
    			JOptionPane.showMessageDialog(null, e.getMessage());
    		}
        	return false;
        }
        
        public ArrayList<Emprunt> getAll(){
        	try {
        		String query= "SELECT `ID`, `ExemplaireId`, `UsagerID`, `DateEmprunt`, `DateRetourPrevu`, `DateRetourEffective` FROM `emprunt` WHERE DateRetourEffective is null; ";
        		PreparedStatement st=Connect.getConnect().getCon().prepareStatement(query);
        		ResultSet rs=st.executeQuery();
        		ArrayList<Emprunt> tab=new ArrayList();
        		UsagerControl tc=new UsagerControl();
        		ExemplaireControl exc=new ExemplaireControl();
        		while(rs.next())
        		{
        			tab.add(new Emprunt(rs.getInt("ID"),rs.getDate("DateEmprunt"),rs.getDate("DateRetourPrevu"),rs.getDate("DateRetourEffective"),tc.getById(rs.getInt("UsagerID")),exc.getById(rs.getInt("ExemplaireId"))));
        		}
        		st.close();
        		rs.close();
        		return tab;
    		} catch (Exception e) {
    			JOptionPane.showMessageDialog(null, e.getMessage());
    		}
        	return null;
        }
        public boolean delete(Emprunt o){
        	try {
        		String query= "DELETE FROM `emprunt` WHERE ID=?";
        		PreparedStatement st=Connect.getConnect().getCon().prepareStatement(query);
        		SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
        		st.setInt(1, o.getExemplairesEmprunt().getId());
        		st.execute();
        		st.close();
        		return true;
    		} catch (Exception e) {
    			JOptionPane.showMessageDialog(null, e.getMessage());
    		}
        	return false;
        }
        public boolean updateDateRetourEffective(Emprunt o){
        	try {
        		String query= "UPDATE `emprunt` SET `DateRetourEffective`=? WHERE ID=?";
        		PreparedStatement st=Connect.getConnect().getCon().prepareStatement(query);
        		st.setDate(1,new Date(o.getDateRetourEffective().getTime()));
        		st.setInt(2,o.getId());
        		st.execute();
        		st.close();
        		return true;
    		} catch (Exception e) {
    			JOptionPane.showMessageDialog(null, e.getMessage());
    		}
        	return false;
        }
    	
    

}
