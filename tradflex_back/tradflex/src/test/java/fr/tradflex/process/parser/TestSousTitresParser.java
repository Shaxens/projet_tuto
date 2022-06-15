package fr.tradflex.process.parser;

import fr.tradflex.model.sousTitre.SousTitre;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
class TestSousTitresParser {
    @Autowired
    private SousTitresParser sousTitresParser;

    @Test
    void test_whith_empty_list() {
        assertThat(sousTitresParser.parse(List.of())).isEmpty();
    }

    @Test
    void test_whith_null_list() {
        assertThatThrownBy(() -> sousTitresParser.parse(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void test_when_list_size_is_one() {
        // Given
        SousTitre sousTitre = new SousTitre(1,"Blablabla je suis le sous-titre 1", 3745, 3800,1);
        // 7When
        var resultat = sousTitresParser.parse(List.of(sousTitre));
        // Then
        assertThat(resultat).isEqualTo("""
                1
                01:02:25,000 --> 01:03:20,000
                Blablabla je suis le sous-titre 1""");
    }

    @Test
    void test_when_list_size_is_three_ordered() {
        // Given
        SousTitre sousTitre1 = new SousTitre(1,"Blablabla je suis le sous-titre 1", 0, 2,1);
        SousTitre sousTitre2 = new SousTitre(2,"""
                                                         Blablabla je suis le sous-titre 2.1
                                                         Blablabla je suis le sous-titre 2.2""", 2, 800,1);
        SousTitre sousTitre3 = new SousTitre(3,"Blablabla je suis le sous-titre 3", 3745, 3800,1);
        // 7When
        var resultat = sousTitresParser.parse(List.of(sousTitre1, sousTitre2, sousTitre3));
        // Then
        assertThat(resultat).isEqualTo("""
                1
                00:00:00,000 --> 00:00:02,000
                Blablabla je suis le sous-titre 1
                
                2
                00:00:02,000 --> 00:13:20,000
                Blablabla je suis le sous-titre 2.1
                Blablabla je suis le sous-titre 2.2
                
                3
                01:02:25,000 --> 01:03:20,000
                Blablabla je suis le sous-titre 3""");
    }

    @Test
    void test_when_list_size_is_three_but_unordered() {
        // Given
        SousTitre sousTitre1 = new SousTitre(1,"Blablabla je suis le sous-titre 1", 0, 2,1);
        SousTitre sousTitre2 = new SousTitre(2,"""
                                                         Blablabla je suis le sous-titre 2.1
                                                         Blablabla je suis le sous-titre 2.2""", 2, 800,1);
        SousTitre sousTitre3 = new SousTitre(3,"Blablabla je suis le sous-titre 3", 3745, 3800,1);
        // 7When
        var resultat = sousTitresParser.parse(List.of(sousTitre1, sousTitre3, sousTitre2));
        // Then
        assertThat(resultat).isEqualTo("""
                1
                00:00:00,000 --> 00:00:02,000
                Blablabla je suis le sous-titre 1
                
                2
                00:00:02,000 --> 00:13:20,000
                Blablabla je suis le sous-titre 2.1
                Blablabla je suis le sous-titre 2.2
                
                3
                01:02:25,000 --> 01:03:20,000
                Blablabla je suis le sous-titre 3""");
    }

    @Test
    void test_when_list_size_is_three_but_some_inside_other() {
        // Given
        SousTitre sousTitre1 = new SousTitre(1,"Blablabla je suis le sous-titre 1", 0, 2,1);
        SousTitre sousTitre2 = new SousTitre(2,"Blablabla je suis le sous-titre 2", 2, 800,1);
        SousTitre sousTitre3 = new SousTitre(3,"Blablabla je suis le sous-titre 3", 2, 500,1);
        SousTitre sousTitre4 = new SousTitre(4,"Blablabla je suis le sous-titre 4", 150, 400,1);
        SousTitre sousTitre5 = new SousTitre(5,"Blablabla je suis le sous-titre 5", 3745, 3800,1);
        // 7When
        var resultat = sousTitresParser.parse(List.of(sousTitre1, sousTitre2, sousTitre3, sousTitre4, sousTitre5));
        // Then
        assertThat(resultat).isEqualTo("""
                1
                00:00:00,000 --> 00:00:02,000
                Blablabla je suis le sous-titre 1
                                
                2
                00:00:02,000 --> 00:08:20,000
                Blablabla je suis le sous-titre 3
                                
                3
                00:00:02,000 --> 00:13:20,000
                Blablabla je suis le sous-titre 2
                                
                4
                00:02:30,000 --> 00:06:40,000
                Blablabla je suis le sous-titre 4
                                
                5
                01:02:25,000 --> 01:03:20,000
                Blablabla je suis le sous-titre 56""");
    }
}