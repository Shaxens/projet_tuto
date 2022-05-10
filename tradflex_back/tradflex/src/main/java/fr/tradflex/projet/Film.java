package fr.tradflex.projet;

public record Film(int id, String nom, int duree, int taille) {

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