package Entity;

public class TypeOeuvre {
	private int id;
	private String Nom_Fr;
	
	public TypeOeuvre(int id, String nom_Fr) {
		super();
		this.id = id;
		Nom_Fr = nom_Fr;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom_Fr() {
		return Nom_Fr;
	}
	public void setNom_Fr(String nom_Fr) {
		Nom_Fr = nom_Fr;
	}
	@Override
	public String toString() {
		return "TypeOeuvre [id=" + id + ", Nom_Fr=" + Nom_Fr + ", getId()=" + getId() + ", getNom_Fr()=" + getNom_Fr()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	

}
