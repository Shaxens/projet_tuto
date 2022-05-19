package fr.tradflex.projet.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TimeCodeTest {


    @Test
    public void testConstructeur() throws Exception
    {
        try {
            new TimeCode("-1", "4");
        } catch (Exception e) {
            assertEquals(e.getMessage(),"Erreur : Probleme initialisation du TimeCode -> | int timeStampDebut >= -1 |");
        }

        try {
            new TimeCode("2", "1");
        } catch (Exception e)
        {
            assertEquals(e.getMessage(),"Erreur : Probleme initialisation du TimeCode -> | int timeStampFin <= this.timeStampDebut |");
        }
    }

}
