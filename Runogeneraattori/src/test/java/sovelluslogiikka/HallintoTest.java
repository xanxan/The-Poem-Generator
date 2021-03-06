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
public class HallintoTest {
    private Hallinto hallinto;
    private Tiedostonlukija lukija;
    private Tiedostonkirjaaja kirjaaja;
    private Arpoja arpoja;
    
    public HallintoTest() throws FileNotFoundException {
        this.lukija = new Tiedostonlukija();
        this.kirjaaja = new Tiedostonkirjaaja(lukija);
        this.arpoja = new Arpoja();
        this.hallinto = new Hallinto(lukija, kirjaaja, arpoja);
    }
    
    @Test
    public void lisaaUusiSanaLisaaUudenSanan() throws IOException {
        File tiedosto = new File("hallintoTest.txt");
       
        this.hallinto.lisaaUusiSana(tiedosto, "kello");
        
        assertTrue(this.lukija.onkoSanaVarastossa("kello", tiedosto));
    }
    
    @Test
    public void alustaOhjelmaToimii() {
        
        assertTrue(hallinto.getVarasto().getVerbit() != null);
        assertTrue(hallinto.getVarasto().getVerbit().size() > 0);
        
    }
    
    @Test
    public void kaynnistaRunokoneToimii() throws IOException {
        String runo = hallinto.kaynnistaRunokone();
        
        assertTrue(runo.length() != 0);
        assertFalse(runo.isEmpty());
        
    }
}
