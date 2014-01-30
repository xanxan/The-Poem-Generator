/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sanavarasto;


import Sovelluslogiikka.Arpoja;
import Sovelluslogiikka.Tiedostonlukija;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 *
 * @author anna
 */
public class Lauseenrakentaja {
    private Sanavarasto varasto;
    
    private ArrayList<String>  adjektiivit;
    private ArrayList<String>  substantiivit;
    private ArrayList<String>  verbit;
    private ArrayList<String>  partikkelit;
    private ArrayList<String>  numeraalit;
    private ArrayList<String>  pronominit;
    
    public Lauseenrakentaja(Arpoja arpoja) {
       
        this.varasto = new Sanavarasto(arpoja);
        this.adjektiivit = this.varasto.getAdjektiivit();
        this.numeraalit = this.varasto.getNumeraalit();
        this.substantiivit = this.varasto.getSubstantiivit();
        this.verbit = this.varasto.getVerbit();
        this.pronominit = this.varasto.getPronominit();
        this.partikkelit = this.varasto.getPartikkelit();
        
    }
    
    public String Rakenne1() throws FileNotFoundException {
        String rakenne = this.varasto.valitseSatunnainenSana(verbit);
        
        return rakenne;
    }
    public String Rakenne2() throws FileNotFoundException {
        String rakenne = this.varasto.valitseSatunnainenSana(partikkelit);
        rakenne += " " + this.varasto.valitseSatunnainenSana(verbit);
        
        return rakenne;
    }
    public String Rakenne3() throws FileNotFoundException {
        String rakenne = this.varasto.valitseSatunnainenSana(pronominit);
        rakenne += " " + this.varasto.valitseSatunnainenSana(verbit);
        rakenne += " " + this.varasto.valitseSatunnainenSana(substantiivit);
        return"";
    }
    public String Rakenne4() throws FileNotFoundException {
        String rakenne = this.varasto.valitseSatunnainenSana(numeraalit);
        rakenne += " " + this.varasto.valitseSatunnainenSana(substantiivit);
        rakenne += " " + this.varasto.valitseSatunnainenSana(verbit);
        rakenne += " " + this.varasto.valitseSatunnainenSana(substantiivit);
        
        return rakenne;
    }
    public String Rakenne5() throws FileNotFoundException {
        String rakenne = this.varasto.valitseSatunnainenSana(partikkelit);
        rakenne += " " + this.varasto.valitseSatunnainenSana(pronominit);
        rakenne += " " + this.varasto.valitseSatunnainenSana(verbit);
        rakenne += " " + this.varasto.valitseSatunnainenSana(adjektiivit);
        rakenne += " " + this.varasto.valitseSatunnainenSana(substantiivit);
        
        return rakenne;
    }
//    public String Rakenne6() {
//        return"";
//    }
//    public String Rakenne7() {
//        return"";
//    }
    
}
