package fr.tradflex.projet;

import fr.tradflex.utilisateur.*;

import java.util.List;

public record Projet(int id, String nom, List<Utilisateur> groupeUtilisateur, Film film) {

    // Getter
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public List<Utilisateur> getGroupeUtilisateur() {
        return groupeUtilisateur;
    }

    public Film getFilm() {
        return film;
    }

    // Méthodes
    public boolean ajoutUserProjet(Utilisateur utilisateur) {
        return true;
    }

    public boolean ajouterFilm(Film film) throws Exception { // Pas fini
        try {
            return true;
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
