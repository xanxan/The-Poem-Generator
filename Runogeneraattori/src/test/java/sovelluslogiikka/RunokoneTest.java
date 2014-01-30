/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

import sovelluslogiikka.Tiedostonkirjaaja;
import sovelluslogiikka.Tiedostonlukija;
import sovelluslogiikka.Runokone;
import sovelluslogiikka.Arpoja;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author anna
 */
public class RunokoneTest {
    private Runokone kone;
    private Arpoja arpoja;
    private Tiedostonkirjaaja kirjaaja;
    private Tiedostonlukija lukija;
    
    public RunokoneTest() {
        this.arpoja = new Arpoja();
        this.lukija = new Tiedostonlukija();
        this.kirjaaja = new Tiedostonkirjaaja(lukija);
        this.kone = new Runokone(arpoja, kirjaaja, lukija);
    }
    
    @Test
    
    public void kirjoitaRunoToimii() throws IOException {
        File runo = this.kone.kirjoitaRuno();
        assertTrue(runo.canRead());
        assertTrue(runo.exists());
        assertTrue(runo.canWrite());
        
      
    }
    
    @Test
    public void sakeistoToimii() throws FileNotFoundException {
        String sakeisto = this.kone.sakeisto();
        assertFalse(sakeisto.isEmpty());
        assertTrue(sakeisto.length() > 3);
    }
    
    @Test
    public void riviToimii() throws FileNotFoundException {
        String rivi = this.kone.rivi();
        assertFalse(rivi.isEmpty());
        assertTrue(rivi.length() > 3);
        
    }
    
    @Test
    public void sanatToimii() throws FileNotFoundException {
        String sanat = this.kone.sanat(1);
        assertFalse(sanat.isEmpty());
        assertTrue(sanat.length() > 0);
    }
}
