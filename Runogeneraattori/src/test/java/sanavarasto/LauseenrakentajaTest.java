/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sanavarasto;

import java.io.FileNotFoundException;
import java.io.IOException;
import static org.junit.Assert.*;
import org.junit.Test;
import sovelluslogiikka.Arpoja;
import sovelluslogiikka.Hallinto;
import sovelluslogiikka.Tiedostonkirjaaja;
import sovelluslogiikka.Tiedostonlukija;

/**
 *
 * @author anna
 */
public class LauseenrakentajaTest {

    
    private Arpoja arpoja;
    private Hallinto hallinto;
    private Tiedostonlukija lukija;
    private Tiedostonkirjaaja kirjaaja;
    
    public LauseenrakentajaTest() throws FileNotFoundException, IOException {
        this.arpoja = new Arpoja();
        this.lukija = new Tiedostonlukija();
        this.kirjaaja = new Tiedostonkirjaaja(lukija);
        this.hallinto = new Hallinto(lukija, kirjaaja, arpoja);
       
        
       
    }
    
   @Test
   public void Rakenne1ToimiiOikein() throws FileNotFoundException {
       assertFalse(this.hallinto.getKone().getRakentaja().Rakenne1().isEmpty());
       
   }
   
   @Test
   public void Rakenne2ToimiiOikein() throws FileNotFoundException {
      
       assertFalse(this.hallinto.getKone().getRakentaja().Rakenne2().isEmpty());
   }
  
   @Test
   public void Rakenne3ToimiiOikein() throws FileNotFoundException {
       assertFalse(this.hallinto.getKone().getRakentaja().Rakenne3().isEmpty());
   }
   @Test
   public void Rakenne4ToimiiOikein() throws FileNotFoundException {
       assertFalse(this.hallinto.getKone().getRakentaja().Rakenne4().isEmpty());
   }
   @Test
   public void Rakenne5ToimiiOikein() throws FileNotFoundException {
       assertFalse(this.hallinto.getKone().getRakentaja().Rakenne5().isEmpty());
   }
   @Test
   public void Rakenne6ToimiiOikein() throws FileNotFoundException {
       assertFalse(this.hallinto.getKone().getRakentaja().Rakenne6().isEmpty());
   }
   @Test
   public void Rakenne7ToimiiOikein() throws FileNotFoundException {
       assertFalse(this.hallinto.getKone().getRakentaja().Rakenne6().isEmpty());
   }
}
