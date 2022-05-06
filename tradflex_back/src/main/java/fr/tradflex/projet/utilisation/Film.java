package fr.tradflex.projet.utilisation;

public class Film {

    // Attributs
    private int id;
    private String nom;
    private int duree;
    private int taille;

    // Getter
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public int getDuree() {
        return duree;
    }

    public int getTaille() {
        return taille;
    }

    // Setter
    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    // Constructeur
    public Film(int id, String nom, int duree, int taille) {
        this.id = id;
        this.nom = nom;
        this.duree = duree;
        this.taille = taille;
    }

    // Méthodes

    @Override
    public String toString() {
        System.out.println("Film{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", duree=" + duree +
                ", taille=" + taille +
                '}');
        return "Film{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", duree=" + duree +
                ", taille=" + taille +
                '}';
    }
}
