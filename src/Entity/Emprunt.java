package Entity;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import Util.Exceprtions;


public class Emprunt {

    private int id;
    private Date dateEmprunt;
    private Date dateRetourPrevu;
    private Date dateRetourEffective;
    private Usager usagerEmprunt;
    private Exemplaire exemplairesEmprunt;

    public Emprunt() {
        dateEmprunt = new Date();
        dateRetourPrevu = new Date();
        dateRetourEffective = new Date();
        usagerEmprunt = new Usager();
        exemplairesEmprunt = new Exemplaire();
    }


    public Emprunt(int id, Date dateEmprunt, Date dateRetourPrevu) {
        this.id = id;
        this.dateEmprunt = dateEmprunt;
        this.dateRetourPrevu = dateRetourPrevu;
    }
    

    public Emprunt(int id, Date dateEmprunt, Date dateRetourPrevu, Date dateRetourEffective, Usager usagerEmprunt,
			Exemplaire exemplairesEmprunt) {
		super();
		this.id = id;
		this.dateEmprunt = dateEmprunt;
		this.dateRetourPrevu = dateRetourPrevu;
		this.dateRetourEffective = dateRetourEffective;
		this.usagerEmprunt = usagerEmprunt;
		this.exemplairesEmprunt = exemplairesEmprunt;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) throws Exceprtions {
        if (id <= 0) {
            throw new Exceprtions("Identifiant Oeuvre non valide !");
        }
        this.id = id;
    }

    public Date getDateRetourEffective() {
        return this.dateRetourEffective;
    }

    public void setDateRetourEffective(Date dateRetourEffective) throws Exceprtions {
        if (dateRetourEffective != null) {
            if (this.dateRetourEffective.compareTo(dateEmprunt) > 0) {
                throw new Exceprtions("La date de retour effective ne doit pas être avant la"
                        + " date d'emprunt");
            }
        }
        this.dateRetourEffective = dateRetourEffective;
    }

    public Date getDateEmprunt() {
        return this.dateEmprunt;
    }

    public void setDateEmprunt(Date dateEmprunt) throws Exceprtions {
        if (null == dateEmprunt) {
            throw new Exceprtions("Veuillez renseigner la date d'emprunt");
        }
        this.dateEmprunt = dateEmprunt;
    }

    public Date getDateRetourPrevu() {
        return this.dateRetourPrevu;
    }

    public void setDateRetourPrevu(Date dateRetourPrevu) throws Exceprtions {
        if (this.dateEmprunt.compareTo(dateRetourPrevu) > 0) {
            throw new Exceprtions("La date de retour prévu ne doit pas être avant"
                    + " la date d'emprunt");
        }
        this.dateRetourPrevu = dateRetourPrevu;
    }

    public Exemplaire getExemplairesEmprunt() {
        return exemplairesEmprunt;
    }

    public void setExemplairesEmprunt(Exemplaire exemplairesEmprunt) {
        this.exemplairesEmprunt = exemplairesEmprunt;
    }

    public Usager getUsagerEmprunt() {
        return usagerEmprunt;
    }

    public void setUsagerEmprunt(Usager usagerEmprunt) {
        this.usagerEmprunt = usagerEmprunt;
    }
    @Override
    public String toString() {
        return "Emprunt{" + "id=" + id + ", dateEmprunt=" + dateEmprunt + ", dateRetourPrevu=" + dateRetourPrevu + ", dateRetourEffective=" + dateRetourEffective + ", usagerEmprunt=" + usagerEmprunt + ", exemplairesEmprunt=" + exemplairesEmprunt + '}';
    }

}
