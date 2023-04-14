package Testing;
import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import Entity.Emprunt;
import Entity.Exemplaire;
import Entity.Oeuvre;
import Entity.Usager;
import Util.Exceprtions;
import control.EmpruntControl;

public class EmpruntControlTest {
    
    @Test
    public void testInsert() throws Exceprtions {
        EmpruntControl ec = new EmpruntControl();
        Usager u = new Usager(67, "Bessi", "Haitam", new Date(2003,04,23), "Male","Ouled Oujih","06798909");
        Oeuvre o=new Oeuvre();
        o.setId(2);
        Exemplaire e = new Exemplaire(1, "Bon", new Oeuvre());
        Emprunt emprunt = new Emprunt(1, new Date(), new Date(), null, u, e);
        assertTrue(ec.insert(emprunt));
    }
    
    @Test
    public void testGetAll() {
        EmpruntControl ec = new EmpruntControl();
        assertNotNull(ec.getAll());
    }
    
    @Test
    public void testDelete() throws Exceprtions {
        EmpruntControl ec = new EmpruntControl();
        Usager u = new Usager(67, "Bessi", "Haitam", new Date(2003,04,23), "Male","Ouled Oujih","06798909");
        Oeuvre o=new Oeuvre();
        o.setId(2);
       Exemplaire e = new Exemplaire(1, "Neuf",o);
        
        Emprunt emprunt = new Emprunt(1, new Date(), new Date(), null, u, e);
        assertTrue(ec.delete(emprunt));
    }
    
    @Test
    public void testUpdateDateRetourEffective() {
        EmpruntControl ec = new EmpruntControl();
        Usager u = new Usager(1, "Haitam", "Bessi"
        		+ "", new Date(2003,04,23), "Male","Ouled Oujih","06798909");
        Exemplaire e = new Exemplaire(1, "Bon", new Oeuvre());
        Emprunt emprunt = new Emprunt(1, new Date(), new Date(), null, u, e);
        assertTrue(ec.updateDateRetourEffective(emprunt));
    }
    
}
