package fr.tradflex.process.parser;

import fr.tradflex.model.sousTitre.SousTitre;
import fr.tradflex.process.parser.timer.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class TestSousTitreParser {

    @Autowired
    private SousTitreParser sousTitreParser;

    @Test
    void test() {
        // Given
        SousTitre sousTitre = new SousTitre(1,"Blablabla je suis un sous-titre", 3745, 3800,1);
        // 7When
        var resultat = sousTitreParser.parse(sousTitre, 1);
        // Then
        assertThat(resultat).isEqualTo("""
                1
                01:02:25,000 --> 01:03:20,000
                Blablabla je suis un sous-titre""");
    }
}