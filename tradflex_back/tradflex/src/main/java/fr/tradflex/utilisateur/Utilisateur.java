package fr.tradflex.utilisateur;

public class Utilisateur {

    // Attributs
    private int id;
    private String pseudo;

    // Getter
    public int getId() {
        return id;
    }
    public String getPseudo() {
        return pseudo;
    }

    // Setter
    public void setId(int id) {
        this.id = id;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    // Constructeur
    public Utilisateur(int id, String pseudo) {
        this.id = id;
        this.pseudo = pseudo;
    }

    // Méthodes
    public void creerProjet(int id, String nom) {

    }

    @Override
    public String toString() {
        return ("L'utilisateur " + this.getPseudo() + " possede l'id " + id);
    }

}