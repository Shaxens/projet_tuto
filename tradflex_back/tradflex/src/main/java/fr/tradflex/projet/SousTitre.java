package fr.tradflex.projet;

public record SousTitre(int id, int longueurMax, String langue) {

    // Getter
    public int getId() {
        return id;
    }

    public int getLongueurMax() {
        return longueurMax;
    }

    public String getLangue() {
        return langue;
    }

    // Méthodes

}