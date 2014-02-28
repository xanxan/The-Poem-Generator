/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

import java.io.File;
import java.io.IOException;
import static org.junit.Assert.*;
import org.junit.Test;

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
        
        assertFalse(kirjuri.tyhjennaLista(testitiedosto));
        assertTrue(testitiedosto.length() == 0);
    }
    
    @Test
    public void KirjaajaPoistaaSanan() throws IOException {
        
        File testitiedosto = new File("tiedostonkirjaajaTest.txt");
        Tiedostonkirjaaja kirjuri = new Tiedostonkirjaaja(this.etsija);
        
        kirjuri.lisaaSana(testitiedosto, "helmi");
        
        assertTrue(kirjuri.poistaSana(testitiedosto, "helmi"));
        
        kirjuri.tyhjennaLista(testitiedosto);
    }
    
    @Test
    public void luoTiedostoksiToimii() throws IOException {
        
        Tiedostonkirjaaja kirjuri = new Tiedostonkirjaaja(this.etsija);
        String teksti = "Tuu pois sielt netistä, tai mä kiskon sua letistä!";
        File tiedosto = kirjuri.luoTiedostoksi("tiedostonkirjaaja.txt", teksti);
        
        assertTrue(tiedosto.length() == teksti.length());
    }
          
}
