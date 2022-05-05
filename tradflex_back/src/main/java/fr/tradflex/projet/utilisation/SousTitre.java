package fr.tradflex.projet.utilisation;

public class SousTitre {

    // Attributs
    private int id;
    private int longueurMax; // Longueur maxi des sous-titres
    private String langue;

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

    // Setter
    public void setId(int id) {
        this.id = id;
    }

    public void setLongueurMax(int longueurMax) {
        this.longueurMax = longueurMax;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    // Constructeur
    public SousTitre(int id, int longueurMax, String langue) {
        this.id = id;
        this.longueurMax = longueurMax;
        this.langue = langue;
    }

    // Méthodes

}
