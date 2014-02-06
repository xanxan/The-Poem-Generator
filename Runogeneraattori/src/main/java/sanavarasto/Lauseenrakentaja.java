/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sanavarasto;


import sovelluslogiikka.Arpoja;
import sovelluslogiikka.Tiedostonlukija;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Luokan tehtävänä on koota satunnaisesti valitut sanat yhteen.
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
    private ArrayList<String>  prepositiot;
    private ArrayList<String>  monikko;
    
    public Lauseenrakentaja(Arpoja arpoja, Sanavarasto varasto) {
       
        this.varasto = varasto;
        this.adjektiivit = this.varasto.getAdjektiivit();
        this.numeraalit = this.varasto.getNumeraalit();
        this.substantiivit = this.varasto.getSubstantiivit();
        this.verbit = this.varasto.getVerbit();
        this.pronominit = this.varasto.getPronominit();
        this.partikkelit = this.varasto.getPartikkelit();
        this.prepositiot = this.varasto.getPrepositiot();
        this.monikko = this.varasto.getMonikko();
        
    }
    /**
     *Metodi lisää lauserakenteeseen verbin.
     * 
     * 
     * 
     */
    public String Rakenne1() throws FileNotFoundException {
        String rakenne = this.varasto.valitseSatunnainenSana(verbit) + "\n";
        
        return rakenne;
    }
    /**
     *Metodi lisää lauserakenteeseen verbin ja pronominin.
     * 
     * 
     * 
     */
    public String Rakenne2() throws FileNotFoundException {
        String rakenne = this.varasto.valitseSatunnainenSana(verbit);
        rakenne += " " + this.varasto.valitseSatunnainenSana(pronominit) + "\n";
        
       
        return rakenne;
    }
    /**
     *Metodi lisää lauserakenteeseen pronominin ja verbin, sekä pronominista
     *riippuen preposition ja monikon tai pelkän substantiivin.
     * 
     * 
     * 
     */
    public String Rakenne3() throws FileNotFoundException {
        String rakenne = this.varasto.valitseSatunnainenSana(pronominit);
        if (rakenne.equals("he") || rakenne.equals(("she")) || rakenne.equals("it")
           || rakenne.equals("what") || rakenne.equals("who")) {
            rakenne += " is " + this.varasto.valitseSatunnainenSana(verbit) + "ing";
            rakenne += " " + this.varasto.valitseSatunnainenSana(prepositiot);
            rakenne += " " + this.varasto.valitseSatunnainenSana(monikko);
        } else {
            rakenne += " " + this.varasto.valitseSatunnainenSana(verbit);
            rakenne += " " + this.varasto.valitseSatunnainenSana(substantiivit) + "\n";
        }
        return rakenne;
    }
    /**
     * Metodi lisää lauserakenteeseen numeraalin ja siitä riippuen joko 
     * substantiivin, verbin preposition ja substantiivin tai monikon, verbin,
     * preposition ja monikon.
     * 
     * 
     * 
     */
    public String Rakenne4() throws FileNotFoundException {
        String rakenne = this.varasto.valitseSatunnainenSana(numeraalit);
        if (rakenne.contains("one")) {
            rakenne += " " + this.varasto.valitseSatunnainenSana(substantiivit);
            rakenne += " " + this.varasto.valitseSatunnainenSana(verbit) + "s";
            rakenne += " " + this.varasto.valitseSatunnainenSana(prepositiot);
            rakenne += " " + this.varasto.valitseSatunnainenSana(substantiivit);        
        } else {
            rakenne += " " + this.varasto.valitseSatunnainenSana(monikko);
            rakenne += " " + this.varasto.valitseSatunnainenSana(verbit);
            rakenne += " " + this.varasto.valitseSatunnainenSana(prepositiot);
            rakenne += " " + this.varasto.valitseSatunnainenSana(monikko) + "\n";
        }
        return rakenne;
    }
    /**
     * Metodi lisää lauserakenteeseen partikkelin, pronominin, verbin, 
     * adjektiivin ja substantiivin.
     * 
     * 
     * 
     */
    public String Rakenne5() {
        String rakenne = this.varasto.valitseSatunnainenSana(partikkelit);
        rakenne += " " + this.varasto.valitseSatunnainenSana(pronominit);
        rakenne += " " + this.varasto.valitseSatunnainenSana(verbit);
        if (rakenne.contains("he") || rakenne.contains(("she")) || rakenne.contains("it")) {
            rakenne += "s";
        } 
        rakenne += " " + this.varasto.valitseSatunnainenSana(adjektiivit);
        rakenne += " " + this.varasto.valitseSatunnainenSana(substantiivit) + "\n";
        
        return rakenne;
    }
    /**
     * Metodi lisää lauserakenteeseen adjektiivin ja substantiivin.
     * 
     * 
     * 
     */
    public String Rakenne6() {
        String rakenne = this.varasto.valitseSatunnainenSana(adjektiivit);
        rakenne += " " + this.varasto.valitseSatunnainenSana(substantiivit) + "\n";
        return rakenne;
    }
    /**
     * Metodi lisää lauserakenteeseen verbin, preposition ja pronominin.
     * 
     * 
     * 
     */
    public String Rakenne7() {
        String rakenne = this.varasto.valitseSatunnainenSana(verbit);
        rakenne += " " + this.varasto.valitseSatunnainenSana(prepositiot);
        rakenne += " " + this.varasto.valitseSatunnainenSana(pronominit) + "\n";
        return rakenne;
    }
    
}
