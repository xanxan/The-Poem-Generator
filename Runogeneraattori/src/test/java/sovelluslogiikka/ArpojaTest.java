/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

import sovelluslogiikka.Arpoja;
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
public class ArpojaTest {
    
    public ArpojaTest() {
    }
    
    
    
    @Test
    public void ArpojaEiTulostaYlarajaaTaiSitaSuurempaaLukua() {
        
        Arpoja arpoja = new Arpoja();
        
        for (int i = 0; i < 50; i++) {
            
            int luku = arpoja.SatunnainenLuku(20);
            
            assertTrue(luku<20);
        }
    }
    
    @Test
    public void ArpojaEiTulostaNegatiivistaLukua() {
        
        Arpoja arpoja = new Arpoja();
        
        for (int i = 0; i < 20; i++) {
            
            int luku = arpoja.SatunnainenLuku(5);
            
            assertTrue(luku>=0);
        }
    }
    
    @Test
    public void ArpojaEiTulostaSamaaLukuaViittaKertaaPerakkain() {
        
        Arpoja arpoja = new Arpoja();
        
        for (int i = 0; i < 20; i++) {
            
            int l1 = arpoja.SatunnainenLuku(10);
            int l2 = arpoja.SatunnainenLuku(10);
            int l3 = arpoja.SatunnainenLuku(10);
            int l4 = arpoja.SatunnainenLuku(10);
            int l5 = arpoja.SatunnainenLuku(10);
        
            assertFalse("Arpoja ei saa tulostaa samaa lukua neljaa kertaa "
                    + "peräkkäin", l1 == l2 && l1 == l3 && l2 == l3 && l4 == l1 && l4 == l2 && l4 == l3
                    && l5 == l1 && l5 == l2 && l5 == l3 && l5 == l4);
        }
    }
   
}
