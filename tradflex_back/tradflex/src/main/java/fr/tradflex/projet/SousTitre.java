package fr.tradflex.projet;

import fr.tradflex.projet.utils.TimeCode;

<<<<<<< HEAD
/**
 * On créé des sous-titre avec une taille maxi et un timeCode
 */
public class SousTitre {

    // ATTRIBUTS
    int id;
    int nbCaractereMax;
    int nbCaractere;
    String texteSousTitre;
    TimeCode timeCode;

    // SETTER
    public void setId(int id) {
        this.id = id;
    }

    public void setNbCaractereMax(int nbCaractereMax) {
        this.nbCaractereMax = nbCaractereMax;
    }

    public void setNbCaractere() {

        this.nbCaractere = this.texteSousTitre.length();
    }

    /**
     * @param texteSousTitre On vérifie la longueur du texte par rapport au nombre de caracteres maximum, si inférieur on set la valeur
     * @throws Exception Sinon on renvoie une exception
     */
    public void setTexteSousTitre(String texteSousTitre) throws Exception {
        if (texteSousTitre.length() <= this.nbCaractereMax)
        {
            this.texteSousTitre = texteSousTitre;
        } else {
            throw new Exception("Erreur : Le nombre de caracteres maximum [" + this.nbCaractereMax + "] est depasse de " + (texteSousTitre.length() - nbCaractereMax) + " caracteres");
        }

    }

    public void setTimeCode(TimeCode timeCode) {
        this.timeCode = timeCode;
    }

    // GETTERS
    public int getId() {
        return id;
    }

    public int getNbCaractereMax() {
        return nbCaractereMax;
    }

    public int getNbCaractere() {
        return nbCaractere;
    }

    public String getTexteSousTitre() {
        return texteSousTitre;
    }

    public TimeCode getTimeCode() {
        return timeCode;
    }

    /**
     * @param id On attribue un id
     * @param nbCaractereMax On attribue un nombre de caractères max par sous-titres
     * @param texteSousTitre On attribue le texte du sous-titre
     * @param timeCode On lui attribue un timeCode avec un début et une fin
     */
    // CONSTRUCTEUR
    public SousTitre(int id, int nbCaractereMax, String texteSousTitre, TimeCode timeCode) throws Exception {
        this.setId(id);
        this.setNbCaractereMax(nbCaractereMax);
        this.setTexteSousTitre(texteSousTitre);
        this.setNbCaractere(); // Automatiquement égal aux nombre de caractères de this.texteSoutitre
        this.setTimeCode(timeCode);
    }

    // METHODES
    @Override
    public String toString() {
        return "Sous-Titre [" + id + "] : " + texteSousTitre + "   " + timeCode;
    }
=======
    // Méthodes
>>>>>>> c61caa23e81fb1c182babdcf049ff00a2b5cf0b8

    /**
     *
     */
    public void ajoutSousTitre() {

    }
}