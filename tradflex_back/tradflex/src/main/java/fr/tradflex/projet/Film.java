package fr.tradflex.projet;

/**
 * @param id On demande un id
 * @param nom On demande un nom de film
 * @param duree On récupère la durée du film
 * @param taille On récupère le poids en octets du film
 */
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