package control;

import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import Entity.Exemplaire;
import Entity.Login;
import dao.Connect;

public class LoginControl {
    public boolean insert(Login ex) {
    	try {
    		String query= "INSERT INTO `login` (`idUser`, `login`, `password`, `role`) VALUES (?,?,?,?);";
    		PreparedStatement st=Connect.getConnect().getCon().prepareStatement(query);
    		st.setInt(1, ex.getUser().getId());
    		st.setString(2, ex.getLog());
    		st.setString(3, ex.getMdp());
    		st.setString(4, ex.getRole());
    		st.execute();
    		st.close();
    		return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
    	return false;
    	
    	
    }
    public boolean delete(Login ex) {
    	try {
    		String query= "Delete from `login` WHERE `idUser`=?;";
    		PreparedStatement st=Connect.getConnect().getCon().prepareStatement(query);
    		st.setInt(1, ex.getUser().getId());
    		st.execute();
    		st.close();
    		return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
    	return false;
    	
    	
    }
}
