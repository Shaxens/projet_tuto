package fr.tradflex.projet.utils;

/**
 *
 */
public class TimeCode {

    // ATTRIBUTS
    int timeStampDebut;
    int timeStampFin;

    // GETTERS
    public int getTimeStampDebut() {
        return timeStampDebut;
    }

    public int getTimeStampFin() {
        return timeStampFin;
    }

    // SETTERS

    /**
     * @param timeStampDebut On donne un temps de début pour créer un sous-titre
     */
    public boolean setTimeStampDebut(int timeStampDebut) throws Exception {
        if (timeStampDebut > -1)
        {
            this.timeStampDebut = timeStampDebut;
            return true;
        }
        else
        {
            throw new Exception("Erreur : Probleme initialisation du TimeCode -> | int timeStampDebut >= -1 |");
        }
    }

    /**
     * @param timeStampFin On donne un temps de fin de sous-titre
     */
    public boolean setTimeStampFin(int timeStampFin) throws Exception {
        if (timeStampFin >= this.timeStampDebut) {
            this.timeStampFin = timeStampFin;
            return true;
        } else {
            throw new Exception("Erreur : Probleme initialisation du TimeCode -> | int timeStampFin <= this.timeStampDebut |");
        }

    }

    /**
     * @param debut
     * @param fin
     */
    // CONSTRUCTEUR
    public TimeCode(int debut, int fin) throws Exception
    {
        this.setTimeStampDebut(debut);
        this.setTimeStampFin(fin);
    }


    @Override
    public String toString() {
        return "[" + timeStampDebut + " | " + timeStampFin + "]";
    }
}
