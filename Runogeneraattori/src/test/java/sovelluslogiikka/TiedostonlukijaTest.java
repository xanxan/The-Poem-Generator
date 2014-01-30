/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

import sovelluslogiikka.Tiedostonkirjaaja;
import sovelluslogiikka.Tiedostonlukija;
import sanavarasto.Sanavarasto;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
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
public class TiedostonlukijaTest {
    
    public TiedostonlukijaTest() {
    }
    
   @Test
   public void SanaEiOleVarastossa() throws FileNotFoundException, IOException {
       
     
       Tiedostonlukija lukija = new Tiedostonlukija();
       Tiedostonkirjaaja kirjuri = new Tiedostonkirjaaja(lukija);
       File testitiedosto = new File("testitiedosto.txt");
       
       kirjuri.lisaaSana(testitiedosto, "ankka");
       kirjuri.lisaaSana(testitiedosto, "kissa");
       
       assertEquals(false, lukija.onkoSanaVarastossa("dgdjhfh", testitiedosto));
       assertEquals(false, lukija.onkoSanaVarastossa(" ", testitiedosto));
       assertEquals(false, lukija.onkoSanaVarastossa("", testitiedosto));
       assertEquals(false, lukija.onkoSanaVarastossa("ankka kissa", testitiedosto));
       assertEquals(false, lukija.onkoSanaVarastossa("kissan", testitiedosto));
       assertEquals(false, lukija.onkoSanaVarastossa("ankkakissa", testitiedosto));
       assertEquals(false, lukija.onkoSanaVarastossa("ankka/nkissa", testitiedosto));
   }
   
   @Test
   public void SanaOnVarastossa() throws FileNotFoundException, IOException {
       
       Tiedostonlukija lukija = new Tiedostonlukija();
       Tiedostonkirjaaja kirjuri = new Tiedostonkirjaaja(lukija);
       File testitiedosto = new File("testitiedosto.txt");
       
       kirjuri.lisaaSana(testitiedosto, "anna");
       
       assertEquals(true,lukija.onkoSanaVarastossa("anna", testitiedosto));
       
   }
   
   @Test
   public void luoListaEiLuoTyhjaaListaa() throws FileNotFoundException, IOException {
       
       File testitiedosto = new File ("testitiedosto.txt");
       Tiedostonlukija lukija = new Tiedostonlukija();
       Tiedostonkirjaaja kirjaaja = new Tiedostonkirjaaja(lukija);
       kirjaaja.lisaaSana(testitiedosto, "leijona");
       ArrayList<String> lista = lukija.luoLista(testitiedosto);
       assertEquals("leijona", lista.get(lista.size()-1));
       
       
   }
   
     
}
