package Testing;


import static org.junit.Assert.*;


import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import Entity.Emprunt;
import Entity.Exemplaire;
import Entity.Usager;
import Util.Exceprtions;

public class EmpruntTest {
    private Emprunt emprunt;

    @Before
    public void setUp() throws Exception {
        emprunt = new Emprunt(1, new Date(), new Date());
    }

    @Test
    public void testSetId() throws Exceprtions {
        emprunt.setId(2);
        assertEquals(2, emprunt.getId());
   
        try {
            emprunt.setId(-1);
            fail("Expected Exceprtions to be thrown");
        } catch (Exceprtions e) {
            assertEquals("Identifiant Oeuvre non valide !", e.getMessage());
        }
    }

    @Test
    public void testSetDateRetourEffective() throws Exceprtions {
        Date dateRetourEffective = new Date();
        emprunt.setDateRetourEffective(dateRetourEffective);
        assertEquals(dateRetourEffective, emprunt.getDateRetourEffective());
        try {
            Date dateBeforeEmprunt = new Date(emprunt.getDateEmprunt().getTime() - 1000);
            emprunt.setDateRetourEffective(dateBeforeEmprunt);
            fail("Expected Exceprtions to be thrown");
        } catch (Exceprtions e) {
            assertEquals("La date de retour effective ne doit pas être avant la date d'emprunt", e.getMessage());
        }
    }

    @Test
    public void testSetDateEmprunt() throws Exceprtions {
        Date dateEmprunt = new Date();
        emprunt.setDateEmprunt(dateEmprunt);
        assertEquals(dateEmprunt, emprunt.getDateEmprunt());
        try {
            emprunt.setDateEmprunt(null);
            fail("Expected Exceprtions to be thrown");
        } catch (Exceprtions e) {
            assertEquals("Veuillez renseigner la date d'emprunt", e.getMessage());
        }
    }

    @Test
    public void testSetDateRetourPrevu() throws Exceprtions {
        Date dateRetourPrevu = new Date(emprunt.getDateEmprunt().getTime() + 1000);
        emprunt.setDateRetourPrevu(dateRetourPrevu);
        assertEquals(dateRetourPrevu, emprunt.getDateRetourPrevu());
        try {
            Date dateBeforeEmprunt = new Date(emprunt.getDateEmprunt().getTime() - 1000);
            emprunt.setDateRetourPrevu(dateBeforeEmprunt);
            fail("Expected Exceprtions to be thrown");
        } catch (Exceprtions e) {
            assertEquals("La date de retour prévu ne doit pas être avant la date d'emprunt", e.getMessage());
        }
    }

      @Test
    public void testToString() {
        Emprunt emprunt = new Emprunt(1, new Date(), new Date(), null, new Usager(), new Exemplaire());

        
        String expected = "Emprunt{id=1, dateEmprunt=" + emprunt.getDateEmprunt() +
                ", dateRetourPrevu=" + emprunt.getDateRetourPrevu() +
                ", dateRetourEffective=null, usagerEmprunt=" + emprunt.getUsagerEmprunt() +
                ", exemplairesEmprunt=" + emprunt.getExemplairesEmprunt() + "}";
        assertEquals(expected, emprunt.toString());
    }
}
