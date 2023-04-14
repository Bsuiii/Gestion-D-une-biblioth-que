package Entity;

import java.util.Date;
import java.util.Vector;

import Util.Exceprtions;

public class Usager {

    private int id;
    private String nom;
    private String prenom;
    private Date dateNais;
    private String sexe;
    private String adresse;
    private String tel;
    private Vector<Emprunt> empruntsUsager = new Vector<Emprunt>();
    private Vector<Reservation> reservationsUsager = new Vector<Reservation>();

    public Usager() {
    }

    public Usager(String nom, String prenom, Date dateNais,
            String sexe, String adresse, String tel) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNais = dateNais;
        this.sexe = sexe;
        this.adresse = adresse;
        this.tel = tel;

    }

    public Usager(int id, String nom, String prenom, Date dateNais,
            String sexe, String adresse, String tel) {
        this(nom, prenom, dateNais, sexe, adresse, tel);
        this.id = id;

    }

    public Usager(Usager usager) {
        this(usager.id, usager.nom, usager.prenom, usager.dateNais,
                usager.sexe, usager.adresse, usager.tel);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) throws Exceprtions {
        if (id <= 0) {
            throw new Exceprtions("Identifiant Usager non valide !");
        }
        this.id = id;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) throws Exceprtions {
        if (null != nom) {
            if (nom.length() < 2) {
                throw new Exceprtions("Le nom de l'usager doit contenir "
                        + "au moins 3 caractères");
            }
        } else {
            throw new Exceprtions("Merci de saisir le nom de l'usager");
        }
        this.nom = nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) throws Exceprtions {
        if (null != prenom) {
            if (prenom.length() < 3) {
                throw new Exceprtions("Le prénom de l'usager doit contenir "
                        + "au moins 3 caractères");
            }
        } else {
            throw new Exceprtions("Merci de saisir le prénom de l'usager");
        }
        this.prenom = prenom;
    }

    public Date getDateNais() {
        return dateNais;
    }

    public void setDateNais(Date dateNais) {
        this.dateNais = dateNais;
    }

    public String getSexe() {
        return this.sexe;
    }

    public void setSexe(String sexe) throws Exceprtions {
        if (null == sexe) {
            throw new Exceprtions("Merci de préciser le sexe de l'usager");
        }
        this.sexe = sexe;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public void setAdresse(String adresse) throws Exceprtions {
        if (null != adresse) {
            if (adresse.length() < 5) {
                throw new Exceprtions("L'adresse doit contenir "
                        + "au moins 10 caractères");
            }
        } else {
            throw new Exceprtions("Merci de renseigner l'adresse de l'usager");
        }
        this.adresse = adresse;
    }

    public String getTel() {
        return this.tel;
    }

    public void setTel(String tel) throws Exceprtions {
        if (null != tel) {
            if (tel.length() > 8) {
                throw new Exceprtions("Le numero de téléphone doit se composer \n"
                        + "au moins de 8 chiffres");
            }
        } else {
            throw new Exceprtions("Merci de saisir un numéro de téléphone ");
        }
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Usager{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom
                + ", dateNais=" + dateNais + ", sexe=" + sexe + ", adresse="
                + adresse + ", tel=" + tel + '}';
    }

}
