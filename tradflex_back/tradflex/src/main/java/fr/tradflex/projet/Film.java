package fr.tradflex.projet;

public record Film(int id, String nom, int duree, int taille) {

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