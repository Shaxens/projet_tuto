package fr.tradflex.utilisateur;

<<<<<<< HEAD
/**
 *
 * @param id On demande un id
 * @param pseudo On demande un pseudo pour l'utilisateur
 */
=======
>>>>>>> c61caa23e81fb1c182babdcf049ff00a2b5cf0b8
public record Utilisateur(int id, String pseudo) {

    // Méthodes

    /**
<<<<<<< HEAD
=======
     *
>>>>>>> c61caa23e81fb1c182babdcf049ff00a2b5cf0b8
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