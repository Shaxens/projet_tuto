package fr.tradflex.projet;

import fr.tradflex.projet.utils.TimeCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.tradflex.projet.SousTitre;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class SousTitreTest {


    @Test
    void testConstructeur() throws Exception {
        String texteSousTitre = "Abracadabrajkplvwjfdsqhsokqfl,f;dnlksjdiokvcblp,gfdnsjovcxpklcbm;gf:,dnlkjvxklbmgfdbmghjfqlkghfkqbgkjqnbogjnqogrjnqelkjrgnqlkegrnprqmker,bmkfrnqgqimegnpkrqenblkqhenrljrhnqelkre";
        try {
            SousTitre testSouTitre = new  SousTitre(1, 160, texteSousTitre, new TimeCode(1,2));
        } catch (Exception e) {
            assertEquals(e.getMessage(),"Erreur : Le nombre de caracteres maximum [" + 160 + "] est depasse de " + (texteSousTitre.length() - 160) + " caracteres");
        }
    }

    @Test
    void testToString() throws Exception {
        String texteSousTitre = "Bonjour, je suis un superbe sous-titre !";

        TimeCode timeCodeValide = new TimeCode(1, 6);
        SousTitre sousTitreValide = new SousTitre(1,160, texteSousTitre, timeCodeValide);
        try
        {
            assertEquals(("Sous-Titre [" + 1 + "] : " + texteSousTitre + "   " + timeCodeValide),(sousTitreValide.toString()));
            new SousTitre(1,160,texteSousTitre, new TimeCode(4, 2));
        } catch (Exception e)
        {
            assertEquals("Erreur : Probleme initialisation du TimeCode -> | int timeStampFin <= this.timeStampDebut |", e.getMessage());
        }
    }
}
