package fr.tradflex.projet;

import fr.tradflex.projet.utilisation.Film;
import fr.tradflex.utilisateur.Utilisateur;

import java.util.ArrayList;

public class Projet {

    // Attributs
    private int id;
    private String nom;
    private ArrayList<Utilisateur> groupeUtilisateur;
    private Film film;

    // Getter
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public ArrayList<Utilisateur> getGroupeUtilisateur() {
        return groupeUtilisateur;
    }

    public Film getFilm() {
        return film;
    }
    // Setter
    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setGroupeUtilisateur(ArrayList<Utilisateur> groupeUtilisateur) {
        this.groupeUtilisateur = groupeUtilisateur;
    }

    public void setFilm(Film film) {
        this.film = film;
    }
    // Constructeur
    public Projet(int id, String nom, ArrayList<Utilisateur> groupeUtilisateur) {
        this.id = id;
        this.nom = nom;
        this.groupeUtilisateur = groupeUtilisateur;
    }
    public Projet(int id, String nom, ArrayList<Utilisateur> groupeUtilisateur, Film film) {
        this.id = id;
        this.nom = nom;
        this.groupeUtilisateur = groupeUtilisateur;
        this.film = film;
    }

    // Méthodes
    public boolean ajoutUserProjet(Utilisateur utilisateur) {
        return true;
    }

    public boolean ajouterFilm(Film film) throws Exception { // Pas fini
        try {
            if (this.film == film) {
                System.out.println("Rechargement de la video");
                return false;
            } else {
                this.setFilm(film);
                System.out.println("Film ajoute avec succes");
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    @Override
    public String toString() {
        System.out.println("Le projet " + nom + " a bien ete créé.\nLes utilisateurs attribues sont : " + groupeUtilisateur);
        return("Le projet " + nom + " a bien ete créé.\nLes utilisateurs attribues sont : " + groupeUtilisateur);
    }
}
