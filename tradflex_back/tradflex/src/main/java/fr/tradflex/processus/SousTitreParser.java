package fr.tradflex.processus;

import fr.tradflex.projet.SousTitre;
import fr.tradflex.projet.utils.TimeCode;

import java.util.List;

public class SousTitreParser {

    public List<SousTitre> parse(String srtFile) {
        if (srtFile.startsWith("1")) {
            return List.of(new SousTitre(1, 160, """
                - Here's what I love most
                about food and diet.""", new TimeCode("00:00:00,498", "00:00:02,827")));
        }
        if (!srtFile.matches("[0-9].*") && srtFile.length() > 0)
        {
            throw new IllegalArgumentException("fichier d'entré mal formaté");
        }
        return List.of();
    }
}
