package fr.tradflex;

import fr.tradflex.projet.Projet;
import fr.tradflex.projet.Film;
import fr.tradflex.utilisateur.Utilisateur;

import java.util.ArrayList;


public class TradflexRunner
{
    public static void main( String[] args ) throws Exception {

        Utilisateur utilisateur1 = new Utilisateur(1, "Goldorak");
        utilisateur1.toString();

        ArrayList<Utilisateur> groupeUtilisateur = new ArrayList<> ();
        groupeUtilisateur.add(utilisateur1);
        Film film1 = new Film(1, "Avatar", 180, 2498452);

        Projet projet1 = new Projet(1, "AvatarProject", groupeUtilisateur, film1);
        projet1.toString();


        Film film2 = new Film(2, "Matrix", 163, 986523);
        projet1.ajouterFilm(film1);

        film1.toString();

        projet1.ajouterFilm(film2);
        film2.toString();
    }
}