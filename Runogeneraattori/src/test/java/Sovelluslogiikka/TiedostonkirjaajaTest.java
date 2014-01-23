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
public class TiedostonkirjaajaTest {
    private Tiedostonlukija etsija;
    
    public TiedostonkirjaajaTest() {
        this.etsija = new Tiedostonlukija();
    }
    
    @Test
    public void KirjaajaLisaaSanan() throws IOException {
       
        File testitiedosto = new File("testitiedosto.txt");
        Tiedostonkirjaaja kirjuri = new Tiedostonkirjaaja();
        assertEquals(true, kirjuri.lisaaSana(testitiedosto, "marsu"));
        assertEquals(true, this.etsija.onkoSanaVarastossa("marsu", testitiedosto));
    }
    
    @Test
    public void KirjaajaEiLisaaSanaaJokaLoytyyVarastosta() throws IOException {
        
        File testitiedosto = new File("testitiedosto.txt");
        Tiedostonkirjaaja kirjuri = new Tiedostonkirjaaja();
        kirjuri.lisaaSana(testitiedosto, "ankka");
        assertEquals(false, kirjuri.lisaaSana(testitiedosto, "ankka"));
    }
    
    @Test
    public void KirjaajaTyhjentaaListan() throws IOException {
        File testitiedosto = new File("testitiedosto.txt");
        Tiedostonkirjaaja kirjuri = new Tiedostonkirjaaja();
        kirjuri.lisaaSana(testitiedosto, "helsinki");
        kirjuri.lisaaSana(testitiedosto, "tukholma");
        kirjuri.lisaaSana(testitiedosto, "tallinna");
        assertEquals(true, kirjuri.tyhjennaLista(testitiedosto));
    }
    
    @Test
    public void KirjaajaPoistaaSanan() throws IOException {
        File testitiedosto = new File("testitiedosto.txt");
        Tiedostonkirjaaja kirjuri = new Tiedostonkirjaaja();
        kirjuri.lisaaSana(testitiedosto, "helmi");
        assertTrue(kirjuri.poistaSana(testitiedosto, "helmi"));
    }
           
}
