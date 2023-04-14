package control;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import Entity.Login;
import dao.Connect;

public class securityController {
 
	public Login authenticate(String login,String mdps) {
		try {
			String query="SELECT `Login`, `password`,role FROM `login` WHERE login=? and password=?;";
			PreparedStatement statement =Connect.getConnect().getCon().prepareStatement(query);
			statement.setString(1,login);
			statement.setString(2, mdps);
			ResultSet rs=statement.executeQuery();
			if(rs.next())
				return new Login(null,rs.getString("Login"),rs.getString("password"),rs.getString("role"));
		
		
		} catch (Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());
			
			
		}
		return null;
	}
}
