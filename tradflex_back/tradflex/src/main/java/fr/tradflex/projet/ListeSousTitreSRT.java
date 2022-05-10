package fr.tradflex.projet;

import fr.tradflex.projet.utils.TimeCode;

import java.util.ArrayList;
import java.util.List;

public class ListeSousTitreSRT {

    // ATTRIBUTS
    private int id;
    private int nbCaractereMax;
    private List<SousTitre> fichierSRT;
    private int dernierId;
    private int nbSousTitres;

    // SETTERS
    public void setFichierSrt(ArrayList<SousTitre> fichierSRT)
    {
        this.fichierSRT = fichierSRT;
    }

    private void setNbSousTitres() {
        this.nbSousTitres = this.fichierSRT.size();
    }

    public void setDernierId() {
        if (this.nbSousTitres == 0)
        {
            this.dernierId = 0;
        }
        else
        {
            this.setNbSousTitres();
            int dernierIndex = this.getNbSousTitres() - 1;

            this.dernierId = this.getFichierSRT().get(dernierIndex).getId();
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNbCaractereMax(int nbCaractereMax) {
        this.nbCaractereMax = nbCaractereMax;
    }

    // GETTERS
    public List<SousTitre> getFichierSRT() {
        return fichierSRT;
    }

    public int getDernierId() {
        this.setDernierId(); // On refresh automatiquement à chaque get()
        return dernierId;
    }

    public int getNbSousTitres() {
        this.setNbSousTitres(); // idem
        return nbSousTitres;
    }

    public int getId() {
        return id;
    }

    public int getNbCaractereMax() {
        return nbCaractereMax;
    }

    // CONSTRUCTEUR
    public ListeSousTitreSRT(int id, int nbCaractereMax) {
        this.fichierSRT = new ArrayList<>();
        this.setId(id);
        this.setNbCaractereMax(nbCaractereMax);
        this.setNbSousTitres();
        this.setDernierId();
    }

    // METHODES
    private SousTitre creerSoutTitre(String texteSousTitre, TimeCode timeCode) throws Exception
    {
        try
        {
            return new SousTitre((this.getDernierId() + 1),this.getNbCaractereMax(), texteSousTitre, timeCode);
        }
        catch (Exception e)
        {
            throw new Exception("Erreur : Un problème est survenue lors de la creation du sous-titre -> " + e.getMessage());
        }
    }

    public boolean ajouterSousTitre(String texteSousTitre, TimeCode timeCode) throws Exception {
        this.getFichierSRT().add(creerSoutTitre(texteSousTitre, timeCode));
        // On refresh les attributs :
        this.setNbSousTitres();
        this.setDernierId();
        return true;
    }


    @Override
    public String toString() {
        System.out.println("\nFichier SRT [" + this.getId() + "] :");
        for (SousTitre sousTitre : this.getFichierSRT())
        {
            System.out.println(sousTitre);
        }
        return "[made by TradFlex]";
    }
}
