/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

import sovelluslogiikka.Tiedostonkirjaaja;
import sovelluslogiikka.Tiedostonlukija;
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
       
        File testitiedosto = new File("tiedostonkirjaajaTest.txt");
        Tiedostonkirjaaja kirjuri = new Tiedostonkirjaaja(this.etsija);
        kirjuri.tyhjennaLista(testitiedosto);
        assertEquals(true, kirjuri.lisaaSana(testitiedosto, "marsu"));
        assertEquals(true, this.etsija.onkoSanaVarastossa("marsu", testitiedosto));
        kirjuri.tyhjennaLista(testitiedosto);
    }
    
    @Test
    public void KirjaajaEiLisaaSanaaJokaLoytyyVarastosta() throws IOException {
        
        File testitiedosto = new File("tiedostonkirjaajaTest.txt");
        Tiedostonkirjaaja kirjuri = new Tiedostonkirjaaja(this.etsija);
        kirjuri.lisaaSana(testitiedosto, "ankka");
        assertEquals(false, kirjuri.lisaaSana(testitiedosto, "ankka"));
        kirjuri.tyhjennaLista(testitiedosto);
    }
    
    @Test
    public void KirjaajaTyhjentaaListan() throws IOException {
        File testitiedosto = new File("tiedostonkirjaajaTest.txt");
        Tiedostonkirjaaja kirjuri = new Tiedostonkirjaaja(this.etsija);
        kirjuri.lisaaSana(testitiedosto, "helsinki");
        kirjuri.lisaaSana(testitiedosto, "tukholma");
        kirjuri.lisaaSana(testitiedosto, "tallinna");
        assertEquals(true, kirjuri.tyhjennaLista(testitiedosto));
    }
    
    @Test
    public void KirjaajaPoistaaSanan() throws IOException {
        File testitiedosto = new File("tiedostonkirjaajaTest.txt");
        Tiedostonkirjaaja kirjuri = new Tiedostonkirjaaja(this.etsija);
        kirjuri.lisaaSana(testitiedosto, "helmi");
        assertTrue(kirjuri.poistaSana(testitiedosto, "helmi"));
        kirjuri.tyhjennaLista(testitiedosto);
    }
    
    
           
}
