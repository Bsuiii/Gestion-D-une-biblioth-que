package control;

import dao.Connect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Entity.Exemplaire;
import Entity.Oeuvre;
import Entity.TypeOeuvre;
import Util.Exceprtions;

public class ExemplaireControl {

    public boolean insert(Exemplaire ex) {
    	try {
    		String query= "INSERT INTO `exemplaire`(`OeuvreID`, `etat`) VALUES (?,?)";
    		PreparedStatement st=Connect.getConnect().getCon().prepareStatement(query);
    		st.setInt(1, ex.getOeuvresExamplaire().getId());
    		st.setString(2, ex.getEtat());
    		st.execute();
    		st.close();
    		return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
    	return false;
    	
    	
    }
    public boolean Update(Exemplaire ex) {
    	try {
    		String query= "UPDATE `exemplaire` SET `etat`=? WHERE ID=?";
    		PreparedStatement st=Connect.getConnect().getCon().prepareStatement(query);
    		st.setString(1, ex.getEtat());
    		st.setInt(2, ex.getId());
    		st.execute();
    		st.close();
    		return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
    	return false;
    	
    	
    }
    public boolean delete(Exemplaire o){
    	try {
    		String query= "DELETE FROM `Exemplaire` WHERE ID=?";
    		PreparedStatement st=Connect.getConnect().getCon().prepareStatement(query);
    		st.setInt(1, o.getId());
    		st.execute();
    		st.close();
    		return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
    	return false;
    }
    
    public Exemplaire getById(int Id){
    	try {
    		PreparedStatement st=Connect.getConnect().getCon().prepareStatement("SELECT `ID`, `OeuvreID`, `etat` FROM `exemplaire` WHERE ID=?");
    		st.setInt(1, Id);
    		ResultSet rs=st.executeQuery();
    		OeuvreControl o=new OeuvreControl();
    		if(rs.next()) {
    		return new Exemplaire(rs.getInt("ID"),rs.getString("etat"),o.getById(rs.getInt("OeuvreID")));
    		}
    		rs.close();
    		st.close();
    	} catch (Exception e) {
    		JOptionPane.showMessageDialog(null, "ex contr"+e.getMessage());
    	}
    return null;
    	
    	
    }	
    public Exemplaire getByOeuvre(Oeuvre o){
    	try {
    		PreparedStatement st=Connect.getConnect().getCon().prepareStatement("SELECT `ID`, `OeuvreID`, `etat` FROM `exemplaire` WHERE OeuvreID=?");
    		st.setInt(1, o.getId());
    		ResultSet rs=st.executeQuery();
    		OeuvreControl oc=new OeuvreControl();
    		if(rs.next()) {
    		return new Exemplaire(rs.getInt("ID"),rs.getString("etat"),oc.getById(rs.getInt("OeuvreID")));
    		}
    		rs.close();
    		st.close();
    	} catch (Exception e) {
    		JOptionPane.showMessageDialog(null, "ex contr"+e.getMessage());
    	}
    return null;
    	
    	
    }	
    public Exemplaire getByEtat(String etat){
    	try {
    		PreparedStatement st=Connect.getConnect().getCon().prepareStatement("SELECT `ID`, `OeuvreID`, `etat` FROM `exemplaire` WHERE etat=?");
    		st.setString(1, etat);
    		ResultSet rs=st.executeQuery();
    		OeuvreControl oc=new OeuvreControl();
    		if(rs.next()) {
    		return new Exemplaire(rs.getInt("ID"),rs.getString("etat"),oc.getById(rs.getInt("OeuvreID")));
    		}
    		rs.close();
    		st.close();
    	} catch (Exception e) {
    		JOptionPane.showMessageDialog(null, "ex contr"+e.getMessage());
    	}
    return null;
    	
    	
    }	
    public ArrayList<Exemplaire> getAll(){
    	try {
    		ArrayList<Exemplaire> tab=new ArrayList();
    		PreparedStatement st=Connect.getConnect().getCon().prepareStatement("SELECT `ID`, `OeuvreID`, `etat` FROM `exemplaire` WHERE 1");
    		ResultSet rs=st.executeQuery();
    		OeuvreControl o=new OeuvreControl();
    		while(rs.next())
    			tab.add(new Exemplaire(rs.getInt("ID"),rs.getString("etat"),o.getById(rs.getInt("OeuvreID"))));
    		rs.close();
    		st.close();
    		return tab;
    	} catch (Exception e) {
    		JOptionPane.showMessageDialog(null, e.getMessage());
    	}
    return null;
    	
    	
    }	
    public ArrayList<Exemplaire> getAllByOeuvre(Oeuvre ov){
    	try {
    		ArrayList<Exemplaire> tab=new ArrayList();
    		PreparedStatement st=Connect.getConnect().getCon().prepareStatement("SELECT `ID`, `OeuvreID`, `etat` FROM `exemplaire` WHERE OeuvreId=?");
    		st.setInt(1, ov.getId());
    		ResultSet rs=st.executeQuery();
    		OeuvreControl o=new OeuvreControl();
    		while(rs.next())
    			tab.add(new Exemplaire(rs.getInt("ID"),rs.getString("etat"),o.getById(rs.getInt("OeuvreID"))));
    		rs.close();
    		st.close();
    		return tab;
    	} catch (Exception e) {
    		JOptionPane.showMessageDialog(null, e.getMessage());
    	}
    return null;
    	
    	
    }	
    
}
