package fr.tradflex.utilisateur;

/**
 *
 * @param id On demande un id
 * @param pseudo On demande un pseudo pour l'utilisateur
 */
public record Utilisateur(int id, String pseudo) {

    // Méthodes

    /**
     * @param id On demande un id
     * @param nom On demande un nom pour créer un projet
     */
    public void creerProjet(int id, String nom) {

    }

    @Override
    public String toString() {
        return ("L'utilisateur " + this.pseudo + " possede l'id " + this.id);
    }

}