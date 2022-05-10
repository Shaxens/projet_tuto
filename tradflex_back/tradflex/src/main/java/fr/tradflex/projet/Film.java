package fr.tradflex.projet;

/**
 *
 * @param id On donne un id au Film
 * @param nom On lui donne un nom
 * @param duree On lui attribut une durée
 * @param taille Il possède une taille en octets
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