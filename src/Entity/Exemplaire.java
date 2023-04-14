package Entity;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import Util.Exceprtions;

public class Exemplaire {

    private int id;
    private String etat;
    private Oeuvre oeuvre;
    private Vector<Emprunt> empruntsExamplaire = new Vector<Emprunt>();
    private Oeuvre oeuvresExamplaire ;


    public Exemplaire(int id, String etat, Oeuvre oeuvre) {
		super();
		this.id = id;
		this.etat = etat;
		this.oeuvresExamplaire = oeuvre;
	}

	public Exemplaire(int id, String etat) {
        this.id = id;
        this.etat = etat;
    }
	public Exemplaire() {
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Oeuvre getOeuvresExamplaire() {
        return oeuvresExamplaire;
    }

    public void setOeuvresExamplaire(Oeuvre oeuvresExamplaire) {
        this.oeuvresExamplaire = oeuvresExamplaire;
    }


    @Override
    public String toString() {
        return "Exemplaire{" + "id=" + id + ", empruntsExamplaire=" + empruntsExamplaire + ", oeuvresExamplaire=(" + oeuvresExamplaire + ")}\n";
    }

}
