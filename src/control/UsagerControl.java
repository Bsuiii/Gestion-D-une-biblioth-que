package control;

import dao.Connect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Entity.Emprunt;
import Entity.Oeuvre;
import Entity.Usager;
import Util.Exceprtions;

public class UsagerControl {

	
    public ArrayList<Usager> getAll(){
    	try {
    		String query= "SELECT `ID`, `Nom`, `Prenom`, `DateNais`, `Sexe`, `Adresse`, `Tel` FROM `usager` WHERE 1;";
    		PreparedStatement st=Connect.getConnect().getCon().prepareStatement(query);
    		ResultSet rs=st.executeQuery();
    		ArrayList<Usager> tab=new ArrayList();
    		while(rs.next())
    		{
    		tab.add(new Usager(rs.getInt("ID"),rs.getString("Nom"),rs.getString("Prenom"),rs.getDate("DateNais"),rs.getString("Sexe"),rs.getString("Adresse"),rs.getString("Tel")));
    		}
    		
    		st.close();
    		rs.close();
    		return tab;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
    	return null;
    }
    public Usager getById(int id){
    	try {
    		String query= "SELECT `ID`, `Nom`, `Prenom`, `DateNais`, `Sexe`, `Adresse`, `Tel` FROM `usager` WHERE ID=?;";
    		PreparedStatement st=Connect.getConnect().getCon().prepareStatement(query);
    		st.setInt(1,id);
    		ResultSet rs=st.executeQuery();
    		if(rs.next())
    		{
    		return new Usager(rs.getInt("ID"),rs.getString("Nom"),rs.getString("Prenom"),rs.getDate("DateNais"),rs.getString("Sexe"),rs.getString("Adresse"),rs.getString("Tel"));
    		}
 
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
    	return null;
    }
    public int getNewId(){
    	try {
    		String query= "SELECT max(ID) as max FROM `usager`";
    		PreparedStatement st=Connect.getConnect().getCon().prepareStatement(query);
    		ResultSet rs=st.executeQuery();
    		if(rs.next())
    		{
    		return rs.getInt("max")+1;
    		}
 
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
    	return 1;
    }
    public boolean insert(Usager u){
    	try {
    		String query= "INSERT INTO `usager`(`Nom`, `Prenom`, `DateNais`, `Sexe`, `Adresse`, `Tel`) VALUES (?,?,?,?,?,?)";
    		PreparedStatement st=Connect.getConnect().getCon().prepareStatement(query);
    		SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
    		st.setString(1,u.getNom());
    		st.setString(2,u.getPrenom());
    		st.setDate(3,new java.sql.Date(u.getDateNais().getTime()));
    		st.setString(4,u.getSexe());
    		st.setString(5,u.getAdresse());
    		st.setString(6,u.getTel());
    		st.execute();
    		st.close();
    		return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
    	return false;
    }
    public boolean update(Usager u){
    	try {
    		String query= "UPDATE `usager` SET `Nom`=?,`Prenom`=?,`DateNais`=?,`Sexe`=?,`Adresse`=?,`Tel`=? WHERE ID=?";
    		PreparedStatement st=Connect.getConnect().getCon().prepareStatement(query);
    		SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
    		
    		st.setString(1,u.getNom());
    		st.setString(2,u.getPrenom());
    		st.setDate(3,new java.sql.Date(u.getDateNais().getTime()));
    		st.setString(4,u.getSexe());
    		st.setString(5,u.getAdresse());
    		st.setString(6,u.getTel());
    		st.setInt(7,u.getId());
    		st.execute();
    		st.close();
    		return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
    	return false;
    }
    public boolean delete(Usager u){
    	try {
    		String query= "DELETE FROM `usager` WHERE ID=?";
    		PreparedStatement st=Connect.getConnect().getCon().prepareStatement(query);
    		st.setInt(1,u.getId());
    		st.execute();
    		st.close();
    		return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
    	return false;
    }
}
