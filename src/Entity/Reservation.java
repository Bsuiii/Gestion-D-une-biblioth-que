package Entity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

import Util.Exceprtions;


public class Reservation {

    private int id;
    private Date dateReservation;
    private Date dateAnnulation;
    private Usager usagerReservation;
    private Oeuvre oeuvresReservation;
//    static final String SQL_SELECT_JOINTURE= "SELECT reservation.*, o.titre, u.nom,"
//                + " u.prenom FROM reservation, oeuvre o, usager u"
//                + " WHERE OeuvreID = o.id"
//                + " AND UsagerID = u.id"
//                + " AND ";
    public Reservation() {
        this.dateReservation = Date.from(Instant.now());
        this.dateAnnulation = null;
        this.usagerReservation = new Usager();
        this.oeuvresReservation = new Oeuvre();
    }

    public Reservation(Usager usager, Oeuvre oeuvre, Date dateJour) {
        this.usagerReservation = usager;
        this.oeuvresReservation = oeuvre;
        this.dateReservation = dateJour;
        this.dateAnnulation = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) throws Exceprtions {
        if (id <= 0) {
            throw new Exceprtions("Identifiant Reservation non valide !");
        }
        this.id = id;
    }

    public Date getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }

    public Date getDateAnnulation() {
        return dateAnnulation;
    }

    public void setDateAnnulation(Date dateAnnulation) {
        this.dateAnnulation = dateAnnulation;
    }

    public Oeuvre getOeuvresReservation() {
        return oeuvresReservation;
    }

    public void setOeuvresReservation(Oeuvre oeuvresReservation) {
        this.oeuvresReservation = oeuvresReservation;
    }

    public Usager getUsagerReservation() {
        return usagerReservation;
    }

    public void setUsagerReservation(Usager usagerReservation) {
        this.usagerReservation = usagerReservation;
    }

    @Override
    public String toString() {
        return "Reservation{" + "id=" + id + ", dateReservation=" + dateReservation + ", dateAnnulation=" + dateAnnulation + ", usagerReservation=" + usagerReservation + ", oeuvresReservation=" + oeuvresReservation + "}\n";
    }

}
