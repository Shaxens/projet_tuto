package fr.tradflex.projet;

import fr.tradflex.utilisateur.Utilisateur;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Créer un projet
 *
 * @param id                Nécessite un id de Projet
 * @param nom               On donne un nom au Projet
 * @param groupeUtilisateur On attribut un groupe d'utilisateur à un projet
 * @param film On lui associe un film
 * */
public record Projet(int id, String nom, List<Utilisateur> groupeUtilisateur, Film film) {

    public Projet(int id, String nom, Film film) {
        this(id, nom, new ArrayList<>(), film);
    }

    @Override
    public List<Utilisateur> groupeUtilisateur() {
        return Collections.unmodifiableList(groupeUtilisateur);
    }

    // Méthodes

    /**
     * @param utilisateur On demande un utilisateur en paramètre
     */
    public void ajoutUtilisateurDuProjet(Utilisateur utilisateur) {
        if (this.groupeUtilisateur.size() > 0) {
            for (Utilisateur utilisateurDejaPresent : this.groupeUtilisateur) {
                if (utilisateurDejaPresent.id() == utilisateur.id()) {
                    System.out.println("Erreur : l'utilistateur numero : " + utilisateur.id() + " est deja present dans le projet " + this.id);
                    return;
                }
            }
        }
        this.groupeUtilisateur.add(utilisateur);
    }

    /**
     * @param film
     * @return vrai (true) si la taille est supérieur à 0 sinon throws Exception
     * @throws Exception Fichier vide
     */
    public boolean modifierFilm(Film film) throws Exception { // Pas fini
        if (film.taille() > 0) {
            // this.film = film; <-- Comment faire sans setter ?
            return true;
        } else {
            throw new Exception("Erreur : le film est un fichier vide");
        }
    }

    /**
     * @param nom
     * @return vrai (true) si le nom est supérieur à 0 sinon throws Exception
     * @throws Exception Saisie vide
     */
    public boolean modifierNom(String nom) throws Exception {
        if (nom.length() > 0) {
            // this.nom = nom; <-- Comment faire sans setter ?
            return true;
        } else {
            throw new Exception("Erreur : la saisie est vide");
        }
    }





    @Override
    public String toString() {
        System.out.println("Le projet " + nom + " a bien ete créé.\nLes utilisateurs attribues sont : " + groupeUtilisateur);
        return("Le projet " + nom + " a bien ete créé.\nLes utilisateurs attribues sont : " + groupeUtilisateur);
    }
}
