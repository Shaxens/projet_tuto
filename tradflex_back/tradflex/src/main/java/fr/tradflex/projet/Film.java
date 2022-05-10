package fr.tradflex.projet;

/**
<<<<<<< HEAD
 *
 * @param id On donne un id au Film
 * @param nom On lui donne un nom
 * @param duree On lui attribut une durée
 * @param taille Il possède une taille en octets
=======
 * @param id On demande un id
 * @param nom On demande un nom de film
 * @param duree On récupère la durée du film
 * @param taille On récupère le poids en octets du film
>>>>>>> c61caa23e81fb1c182babdcf049ff00a2b5cf0b8
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