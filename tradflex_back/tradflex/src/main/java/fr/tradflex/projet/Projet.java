package fr.tradflex.projet;

import fr.tradflex.utilisateur.*;

import java.util.List;

/**
 * Créer un projet
 * @param id Nécessite un id de Projet
 * @param nom On donne un nom au Projet
 * @param groupeUtilisateur On attribut un groupe d'utilisateur à un projet
 * @param film On lui associe un film
* */
public record Projet(int id, String nom, List<Utilisateur> groupeUtilisateur, Film film) {

    // Méthodes
    /**
     * @param utilisateur On demande un utilisateur en paramètre
     * @return faux (false) si l'utilisateur est déjà ajouté au projet ou vrai (true) si ce n'est pas le cas
     * */
    public boolean ajoutUtilisateurDuProjet(Utilisateur utilisateur) {
        if (this.groupeUtilisateur.size() > 0)
        {
            for (Utilisateur utilisateurDejaPresent : this.groupeUtilisateur) {
                if (utilisateurDejaPresent.id() == utilisateur.id()) {
                    System.out.println("Erreur : l'utilistateur numero : " + utilisateur.id() + " est deja present dans le projet " + this.id);
                    return false;
                }
            }
        }
        this.groupeUtilisateur.add(utilisateur);
        return true;
    }

    @Override
    public String toString() {
        System.out.println("Le projet " + nom + " a bien ete créé.\nLes utilisateurs attribues sont : " + groupeUtilisateur);
        return("Le projet " + nom + " a bien ete créé.\nLes utilisateurs attribues sont : " + groupeUtilisateur);
    }
}
