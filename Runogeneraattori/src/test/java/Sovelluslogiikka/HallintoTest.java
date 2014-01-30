/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sovelluslogiikka;

import java.io.File;
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
public class HallintoTest {
    private Hallinto hallinto;
    private Tiedostonlukija lukija;
    private Tiedostonkirjaaja kirjaaja;
    private Arpoja arpoja;
    
    public HallintoTest() {
        this.lukija = new Tiedostonlukija();
        this.kirjaaja = new Tiedostonkirjaaja(lukija);
        this.arpoja = new Arpoja();
        this.hallinto = new Hallinto(lukija, kirjaaja, arpoja);
    }
    
    public void lisaaUusiSanaLisaaUudenSanan() throws IOException {
        File tiedosto = new File("testitiedosto.txt");
       
        this.hallinto.lisaaUusiSana(tiedosto, "kello");
        assertTrue(this.lukija.onkoSanaVarastossa("kello", tiedosto));
    }
}
