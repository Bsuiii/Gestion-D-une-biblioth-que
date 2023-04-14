package Entity;

public class Login {
private Usager user;
private String log;
private String mdp;
private String Role;


public Login() {
}

public Login(Usager user, String log, String mdp, String role) {
	super();
	this.user = user;
	this.log = log;
	this.mdp = mdp;
	Role = role;
}
@Override
public String toString() {
	return "Login [user=" + user + ", log=" + log + ", mdp=" + mdp + ", Role=" + Role + "]";
}
public Usager getUser() {
	return user;
}
public void setUser(Usager user) {
	this.user = user;
}
public String getLog() {
	return log;
}
public void setLog(String log) {
	this.log = log;
}
public String getMdp() {
	return mdp;
}
public void setMdp(String mdp) {
	this.mdp = mdp;
}
public String getRole() {
	return Role;
}
public void setRole(String role) {
	Role = role;
}


}
