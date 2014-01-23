/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sovelluslogiikka;

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
public class TiedostonlukijaTest {
    
    public TiedostonlukijaTest() {
    }
    
   @Test
   public void SanaEiOleVarastossa() throws FileNotFoundException, IOException {
       
       Tiedostonkirjaaja kirjuri = new Tiedostonkirjaaja();
       Tiedostonlukija lukija = new Tiedostonlukija();
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
       Tiedostonkirjaaja kirjuri = new Tiedostonkirjaaja();
       File testitiedosto = new File("testitiedosto.txt");
       
       kirjuri.lisaaSana(testitiedosto, "anna");
       
       assertEquals(true,lukija.onkoSanaVarastossa("anna", testitiedosto));
       
   }
   
   @Test
   public void SamaaSanaaEiValitaKolmeaKertaaPerakkain() throws FileNotFoundException, IOException {
       
       Tiedostonlukija lukija = new Tiedostonlukija();
       File testitiedosto = new File("testitiedosto.txt");
       Tiedostonkirjaaja kirjuri = new Tiedostonkirjaaja();
       
       kirjuri.lisaaSana(testitiedosto, "hevonen");
       kirjuri.lisaaSana(testitiedosto, "aasi");
       kirjuri.lisaaSana(testitiedosto, "zeebra");
       
       for (int i = 0; i < 10; i++) {
           
         String s1 = lukija.valitseSatunnainenSana(testitiedosto);
         String s2 = lukija.valitseSatunnainenSana(testitiedosto);
         String s3 = lukija.valitseSatunnainenSana(testitiedosto);
         
         assertFalse("Sama sana ei saa tulla kolmea kertaa peräkkäin", s1.equals(s3) && s1.equals(s2) && s2.equals(s3));
       }
   }
     
}
