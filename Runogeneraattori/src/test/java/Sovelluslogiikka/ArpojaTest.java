/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sovelluslogiikka;

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
    public void ArpojaEiTulostaNegatiivistLukua() {
        
        Arpoja arpoja = new Arpoja();
        
        for (int i = 0; i < 20; i++) {
            
            int luku = arpoja.SatunnainenLuku(5);
            
            assertTrue(luku>=0);
        }
    }
    
    @Test
    public void ArpojaEiTulostaSamaaLukuaKolmeaKertaaPerakkain() {
        
        Arpoja arpoja = new Arpoja();
        
        for (int i = 0; i < 20; i++) {
            
            int l1 = arpoja.SatunnainenLuku(10);
            int l2 = arpoja.SatunnainenLuku(10);
            int l3 = arpoja.SatunnainenLuku(10);
        
            assertFalse("Arpoja ei saa tulostaa samaa lukua kolmea kertaa "
                    + "peräkkäin", l1 == l2 && l1 == l3 && l2 == l3);
        }
    }
   
}
