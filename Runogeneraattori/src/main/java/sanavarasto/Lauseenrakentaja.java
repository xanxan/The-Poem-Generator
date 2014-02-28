/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sanavarasto;


import java.util.ArrayList;
import sovelluslogiikka.Arpoja;

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
     *  @return rakenne Palauttaa lauserakenteen.
     * 
     */
    public String Rakenne1() {
        String rakenne = "";
        while (true) {
            if (rakenne.matches("I|you|he|she|it|we|they")) {
                break;
            } else {
                rakenne = this.varasto.valitseSatunnainenSana(pronominit);
            }
        }
        if (rakenne.matches("he|she|it")) {
            String apu = this.varasto.valitseSatunnainenSana(verbit);
            if (apu.matches("cry|copy|bury|carry|empty|fancy|hurry|identify|"
                    + "marry|multiply|rely|reply|satisfy|supply|terrify|untidy|worry")) {
                apu = apu.substring(0, apu.length()-1) + "ies";
                rakenne += " " + apu +"\n";
            } else {
                rakenne += " " + apu + "s\n";
            }
        } else {
            rakenne += " " + this.varasto.valitseSatunnainenSana(verbit) + "\n";
        }
        return rakenne;
    }
    /**
     *Metodi lisää lauserakenteeseen verbin ja pronominin.
     * 
     *  @return rakenne Palauttaa lauserakenteen.
     * 
     */
    public String Rakenne2()  {
        String rakenne = this.varasto.valitseSatunnainenSana(verbit);
        String apu = this.varasto.valitseSatunnainenSana(pronominit);
        if (apu.matches("me|yourself|it|him|her|for us")) {
            rakenne += " " + apu + "!\n";
        } else if (apu.matches("I|who|what")) {
            rakenne += " " + apu + "?\n";
        } else {
            rakenne += "!\n";
        }
       
        return rakenne;
    }
    /**
     *Metodi lisää lauserakenteeseen pronominin ja verbin, sekä pronominista
     *riippuen preposition ja monikon tai pelkän substantiivin.
     * 
     *  @return rakenne Palauttaa lauserakenteen.
     * 
     */
    public String Rakenne3() {
        String rakenne = this.varasto.valitseSatunnainenSana(pronominit);
        if (rakenne.matches("he|she|it|what|who")) {
            rakenne += " is ";
            String apu =  this.varasto.valitseSatunnainenSana(verbit);
            if (apu.endsWith("e")) {
                apu = apu.substring(0, apu.length() - 1);
            
            }
            rakenne += apu + "ing";
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
     *  @return rakenne Palauttaa lauserakenteen.
     * 
     */
    public String Rakenne4()  {
        String rakenne = this.varasto.valitseSatunnainenSana(numeraalit);
        if (rakenne.matches("one")) {
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
     *  @return rakenne Palauttaa lauserakenteen.
     * 
     */
    public String Rakenne5() {
        String rakenne = this.varasto.valitseSatunnainenSana(partikkelit);
        rakenne += " " + this.varasto.valitseSatunnainenSana(pronominit);
        rakenne += " " + this.varasto.valitseSatunnainenSana(verbit);
        if (rakenne.matches("he|she|it")) {
            rakenne += "s";
        } 
        rakenne += " " + this.varasto.valitseSatunnainenSana(adjektiivit);
        rakenne += " " + this.varasto.valitseSatunnainenSana(substantiivit) + "\n";
        
        return rakenne;
    }
    /**
     * Metodi lisää lauserakenteeseen adjektiivin ja substantiivin.
     * 
     *  @return rakenne Palauttaa lauserakenteen.
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
     * @return rakenne Palauttaa lauserakenteen.
     * 
     */
    public String Rakenne7() {
        String rakenne = this.varasto.valitseSatunnainenSana(verbit);
        rakenne += " " + this.varasto.valitseSatunnainenSana(prepositiot);
        rakenne += " " + this.varasto.valitseSatunnainenSana(pronominit) + "\n";
        return rakenne;
    }
    /**
     * Metodi lisää lauserakenteeseen partikkelin, monikon, verbin ja preposition.
     * 
     * @return rakenne Palauttaa lauserakenteen.
     * 
     */
    public String Rakenne8() {
        String rakenne = this.varasto.valitseSatunnainenSana(partikkelit);
        rakenne += " " + this.varasto.valitseSatunnainenSana(monikko);
        rakenne += " " + this.varasto.valitseSatunnainenSana(verbit);
        rakenne += " " + this.varasto.valitseSatunnainenSana(prepositiot) + "\n";
        return rakenne;
    }
    /**
     * Metodi lisää lauserakenteeseen monikon, olla-verbin ja adjektiivin.
     * 
     * @return rakenne Palauttaa lauserakenteen.
     * 
     */
    public String Rakenne9() {
        String rakenne = this.varasto.valitseSatunnainenSana(monikko);
        rakenne += " are " + this.varasto.valitseSatunnainenSana(adjektiivit) + "\n";
        return rakenne;
    }
    /**
     * Metodi lisää lauserakenteeseen substantiivin, futuuri-verbin, ja verbin.
     * 
     * @return rakenne Palauttaa lauserakenteen.
     * 
     */
    public String Rakenne10() {
        String rakenne = this.varasto.valitseSatunnainenSana(substantiivit);
        rakenne += " will " + this.varasto.valitseSatunnainenSana(verbit) + "\n";
        return rakenne;
    }
}
