/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sanavarasto;

import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.Test;
import sovelluslogiikka.Arpoja;

/**
 *
 * @author anna
 */
public class SanavarastoTest {
    private Sanavarasto varasto;
    private Arpoja arpoja;
    private ArrayList<String> testi;
    
    public SanavarastoTest() {
        this.arpoja = new Arpoja();
        this.varasto = new Sanavarasto(arpoja);
        this.testi = new ArrayList();
        this.testi.add("kirja");
        this.testi.add("tuoli");
        this.testi.add("pöytä");
        this.testi.add("lattia");
    }
    
    @Test
    
    public void valitseSatunnainenSanaToimiiOikein() {
        String sana = this.varasto.valitseSatunnainenSana(this.testi);
        assertFalse(sana.isEmpty());
    }
    
    @Test
    
    public void SatunnainenSanaEiValitseSamaaSanaaLiianUseasti() {
       
        String s1 = this.varasto.valitseSatunnainenSana(this.testi);
        String s2 = this.varasto.valitseSatunnainenSana(this.testi);
        String s3 = this.varasto.valitseSatunnainenSana(this.testi);
        String s4 = this.varasto.valitseSatunnainenSana(this.testi);
        assertFalse(s1.equals(s4) && s1.equals(s2) && s1.equals(3) &&
                   s2.equals(s4) && s2.equals(s3) && s3.equals(s4));
    }
    
    
}
