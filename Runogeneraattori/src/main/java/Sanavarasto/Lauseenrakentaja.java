/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sanavarasto;


import Sovelluslogiikka.Tiedostonlukija;
import java.io.File;
import java.io.FileNotFoundException;

/**
 *
 * @author anna
 */
public class Lauseenrakentaja {
    private Sanavarasto varasto;
    private Tiedostonlukija lukija;
    private File adjektiivit;
    private File substantiivit;
    private File verbit;
    private File partikkelit;
    private File numeraalit;
    private File pronominit;
    
    public Lauseenrakentaja(Tiedostonlukija lukija) {
        this.lukija = lukija;
        this.varasto = new Sanavarasto();
        this.adjektiivit = this.varasto.getAdjektiivit();
        this.numeraalit = this.varasto.getNumeraalit();
        this.substantiivit = this.varasto.getSubstantiivit();
        this.verbit = this.varasto.getVerbit();
        this.pronominit = this.varasto.getPronominit();
        this.partikkelit = this.varasto.getPartikkelit();
    }
    
    public String Rakenne1() throws FileNotFoundException {
        String rakenne = this.lukija.valitseSatunnainenSana(verbit);
        
        return rakenne;
    }
    public String Rakenne2() throws FileNotFoundException {
        String rakenne = this.lukija.valitseSatunnainenSana(partikkelit);
        rakenne += " " + this.lukija.valitseSatunnainenSana(verbit);
        
        return rakenne;
    }
    public String Rakenne3() throws FileNotFoundException {
        String rakenne = this.lukija.valitseSatunnainenSana(pronominit);
        rakenne += " " + this.lukija.valitseSatunnainenSana(verbit);
        rakenne += " " + this.lukija.valitseSatunnainenSana(substantiivit);
        return"";
    }
    public String Rakenne4() throws FileNotFoundException {
        String rakenne = this.lukija.valitseSatunnainenSana(numeraalit);
        rakenne += " " + this.lukija.valitseSatunnainenSana(substantiivit);
        rakenne += " " + this.lukija.valitseSatunnainenSana(verbit);
        rakenne += " " + this.lukija.valitseSatunnainenSana(substantiivit);
        
        return rakenne;
    }
    public String Rakenne5() throws FileNotFoundException {
        String rakenne = this.lukija.valitseSatunnainenSana(partikkelit);
        rakenne += " " + this.lukija.valitseSatunnainenSana(pronominit);
        rakenne += " " + this.lukija.valitseSatunnainenSana(verbit);
        rakenne += " " + this.lukija.valitseSatunnainenSana(adjektiivit);
        rakenne += " " + this.lukija.valitseSatunnainenSana(substantiivit);
        
        return rakenne;
    }
    public String Rakenne6() {
        return"";
    }
    public String Rakenne7() {
        return"";
    }
    
}
