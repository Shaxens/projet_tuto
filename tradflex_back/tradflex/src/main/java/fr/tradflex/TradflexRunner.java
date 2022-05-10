package fr.tradflex;

import fr.tradflex.projet.*;
import fr.tradflex.utilisateur.Utilisateur;

import java.util.List;
import java.util.ArrayList;


public class TradflexRunner {
    public static void main( String[] args ) throws Exception {

        var utilisateur1 = new Utilisateur(1, "Goldorak");
        utilisateur1.toString();
        List<Utilisateur> groupeUtilisateur = new ArrayList<> ();
        groupeUtilisateur.add(utilisateur1);
        var film1 = new Film(1, "Avatar", 180, 2498452);

        var projet1 = new Projet(1, "AvatarProject", groupeUtilisateur, film1);
        projet1.toString();

        var film2 = new Film(2, "Matrix", 163, 986523);

        film1.toString();

        film2.toString();
    }
}