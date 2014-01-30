/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sanavarasto;

import Sovelluslogiikka.Arpoja;
import java.io.FileNotFoundException;
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
public class LauseenrakentajaTest {
    private Sanavarasto varasto;
    private Lauseenrakentaja rakentaja;
    private Arpoja arpoja;
    
    public LauseenrakentajaTest() {
        this.arpoja = new Arpoja();
        this.rakentaja = new Lauseenrakentaja(this.arpoja);
        this.varasto = new Sanavarasto(this.arpoja);
    }
    
   @Test
   public void Rakenne1ToimiiOikein() throws FileNotFoundException {
       assertTrue(this.varasto.getVerbit().contains(this.rakentaja.Rakenne1()));
       
   }
   
   @Test
   public void Rakenne2ToimiiOikein() throws FileNotFoundException {
       assertTrue(!this.rakentaja.Rakenne2().isEmpty());
   }
   
   @Test
   public void Rakenne3ToimiiOikein() throws FileNotFoundException {
       assertTrue(!this.rakentaja.Rakenne3().isEmpty());
   }
   @Test
   public void Rakenne4ToimiiOikein() throws FileNotFoundException {
       assertTrue(!this.rakentaja.Rakenne4().isEmpty());
   }
   @Test
   public void Rakenn5ToimiiOikein() throws FileNotFoundException {
       assertTrue(!this.rakentaja.Rakenne5().isEmpty());
   }
}
