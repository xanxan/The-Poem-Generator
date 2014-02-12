/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author anna
 */
public class RunokoneTest {
    private Hallinto hallinto;
    private Arpoja arpoja;
    private Tiedostonkirjaaja kirjaaja;
    private Tiedostonlukija lukija;
    
    
    public RunokoneTest() throws FileNotFoundException {
         this.arpoja = new Arpoja();
        this.lukija = new Tiedostonlukija();
        this.kirjaaja = new Tiedostonkirjaaja(lukija);
        this.hallinto = new Hallinto(lukija, kirjaaja, arpoja);
    }
    
    @Test
    
    public void kirjoitaRunoToimii() throws IOException {
        String runo = this.hallinto.getKone().kirjoitaRuno();
        assertFalse(runo.isEmpty());
        assertTrue(runo.length() > 2);
        
        
      
    }
    
    @Test
    public void sakeistoToimii() throws FileNotFoundException {
        String sakeisto = this.hallinto.getKone().sakeisto();
        assertFalse(sakeisto.isEmpty());
        assertTrue(sakeisto.length() > 0);
    }
    
    @Test
    public void riviToimii() throws FileNotFoundException {
        String rivi = this.hallinto.getKone().rivi();
        assertFalse("rivi ei saa olla tyhjä", rivi.isEmpty());
        assertTrue(" rivin on oltava vähintään kahden merkin pituinen", rivi.length() > 1);
        
    }
    
    @Test
    public void sanatToimii() throws FileNotFoundException {
        String sanat = this.hallinto.getKone().sanat(1);
        assertFalse(sanat.isEmpty());
        assertTrue(sanat.length() > 0);
    }
}
