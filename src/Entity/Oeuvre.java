package Entity;

import java.util.ArrayList;

import Util.Exceprtions;


public class Oeuvre {

    protected int id;
    protected String titre;
    protected String auteur;
    protected String categorie;
    protected int nbResa;
    public ArrayList<Exemplaire> examplairesOeuvre = new ArrayList<>();
    protected ArrayList<Reservation> reservationsOeuvre = new ArrayList<>();
   private int nbExemplaire;
    private int lending;
    private TypeOeuvre type;
   public Oeuvre() {
	   
   }
   
    public Oeuvre(int id,String titre, String auteur,String categorie,int nbResa,int nbExemplaire,int lending,TypeOeuvre type) {
    	this.id=id;
    	this.titre=titre;
    	this.auteur=auteur;
    	this.categorie=categorie;
    	this.nbResa=nbResa;
    	this.nbExemplaire=nbExemplaire;
    	this.lending=lending;
    	this.type=type;
    }
    public Oeuvre(String titre, String auteur,String categorie,int nbResa,int nbExemplaire,int lending,TypeOeuvre type) {
    	
    	this.titre=titre;
    	this.auteur=auteur;
    	this.categorie=categorie;
    	this.nbResa=nbResa;
    	this.nbExemplaire=nbExemplaire;
    	this.lending=lending;
    	this.type=type;
    }
    
    
    public int getNbExemplaire() {
		return nbExemplaire;
	}


	public void setNbExemplaire(int nbExemplaire) {
		this.nbExemplaire = nbExemplaire;
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

    public String getCategorie() {
        return this.categorie;
    }

    public void setCategorie(String categorie) throws Exceprtions {
        if (null != categorie) {
            if (categorie.length() < 3) {
                throw new Exceprtions("Le nom de la catégorie doit contenir "
                        + "au moins 3 caractères");
            }
        } else {
            throw new Exceprtions("Merci de saisir une catégorie ");
        }
        this.categorie = categorie;
    }

    public String getAuteur() {
        return this.auteur;
    }

    public void setAuteur(String auteur) throws Exceprtions {
        if (null != auteur) {
            if (auteur.length() < 3) {
                throw new Exceprtions("Le nom de l'auteur doit avoir "
                        + "au moins 3 caractères");
            }
        } else {
            throw new Exceprtions("Merci de saisir un nom ");
        }
        this.auteur = auteur;
    }

    public String getTitre() {
        return this.titre;
    }

    public void setTitre(String titre) throws Exceprtions {
        if (null != titre) {
            if (titre.length() < 3) {
                throw new Exceprtions("Le titre doit avoir "
                        + "au moins 3 caractères");
            }
        } else {
            throw new Exceprtions("Merci de saisir le titre de l'oeuvre ");
        }
        this.titre = titre;
    }

    public int getNbResa() {
        return this.nbResa;
    }

    public void setNbResa(int nbResa) {
        this.nbResa = nbResa;
    }

    public ArrayList<Exemplaire> getExamplairesOeuvre() {
        return examplairesOeuvre;
    }

    public void setExamplairesOeuvre(ArrayList<Exemplaire> examplairesOeuvre) {
        this.examplairesOeuvre = examplairesOeuvre;
    }

    public ArrayList<Reservation> getReservationsOeuvre() {
        return reservationsOeuvre;
    }

    public void setReservationsOeuvre(ArrayList<Reservation> reservationsOeuvre) {
        this.reservationsOeuvre = reservationsOeuvre;
    }
    
    public int getLending() {
        return this.lending;
    }

    public void setLending(int lending) throws Exceprtions {
        if (lending < 30) {
            throw new Exceprtions("La durée d'emprunt des Magazines "
                    + "doit être superieure ou égale à 30 jours");
        }
        this.lending = lending;
    }

    public TypeOeuvre getType() {
		return type;
	}


	public void setType(TypeOeuvre type) {
		this.type = type;
	}


	

    @Override
    public String toString() {
        return "id=" + id + ", titre=" + titre + ", auteur=" + auteur + ", categorie=" + categorie + ", nbResa=" + nbResa + " ";
    }

}
