package fr.tradflex.processus;

import fr.tradflex.projet.SousTitre;
import fr.tradflex.projet.utils.TimeCode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class SousTitreParserTest {

    @Test
    void genere_une_liste_si_pas_de_sous_titre() {
        // Given
        var srtFile = "";
        // When
        var resultat = new SousTitreParser().parse(srtFile);
        // Then
        assertThat(resultat).isEmpty();
    }

    @Test
    void lance_une_exception_si_fichier_ne_commence_pas_par_un_nombre() {
        // Given
        var srtFile = """
                a
                00:00:00,498 --> 00:00:02,827
                - Here's what I love most
                about food and diet.""";
        // When - Then
        assertThatCode(() ->new SousTitreParser().parse(srtFile))
                .hasMessageContaining("fichier d'entré mal formaté");
    }

    @Test
    void name() throws Exception {
        var srtFile = """
                1
                00:00:00,498 --> 00:00:02,827
                - Here's what I love most
                about food and diet.""";

        var resultat = new SousTitreParser().parse(srtFile);
        var sousTitre = """
                - Here's what I love most
                about food and diet.""";

        assertThat(resultat).containsExactly(new SousTitre(1, 160, sousTitre, new TimeCode("00:00:00,498", "00:00:02,827")));
    }
}