/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import sanavarasto.Lauseenrakentaja;
import sanavarasto.Sanavarasto;

/**
 * Luokan tehtävä on laatia runo omaan tiedostoonsa. 
 * Luokkaa määrää sanojen, 
 * rivien, ja säkeistöjen määrän sekä kokoaa ne yhteen.
 * 
 * 
 *
 * @author anna
 */
public class Runokone {
    private Arpoja arpoja;
    private Sanavarasto varasto;
    private Lauseenrakentaja rakentaja;
    private FileWriter kirjoittaja;
    
    
    public Runokone(Arpoja arpoja, Sanavarasto varasto) {
        this.arpoja = arpoja;
        this.varasto = varasto;
        this.rakentaja =  new Lauseenrakentaja(arpoja, varasto);
        
    }
    
    public Lauseenrakentaja getRakentaja() {
        return rakentaja;
    }
    /**
     * Metodi kokoaa yhteen ohjelman laatiman runon ja 
     * palauttaa sen.
     * 
     * @return runo Palauttaa koneen kokoaman runon.
     * 
     */
    public String kirjoitaRuno() throws IOException {

        int sakeistoja = 1 + arpoja.SatunnainenLuku(6);
        
        String runo = "";
         for (int i = 0; i < sakeistoja; i++) {
              runo += this.sakeisto() + '\n';
          } 
        
        return runo;
        
    }
    /**
     * Metodi arpoo säkeistön rivimäärän ja palauttaa kokoamansa säkeistön.
     * 
     * @return sakeisto Palauttaa koneen kokoaman säkeistön.
     * 
     */
    public String sakeisto() throws FileNotFoundException {
        int riveja =1 + arpoja.SatunnainenLuku(6);
        String sakeisto = "";
        
        for (int i = 0; i < riveja; i++) {
            sakeisto += this.rivi();
        }
        
        return sakeisto;
    }
     /**
     *Metodi arpoo lauserakenteen ja palauttaa Lauseenrakentajan kokoaman lauseen.
     * 
     * @return rivi Palauttaa koneen tuottaman rivin.
     * 
     */       
    public String rivi() throws FileNotFoundException {
        int sanoja = 1 + arpoja.SatunnainenLuku(6);
        String rivi = "";
        
        rivi += this.sanat(sanoja);
        
        return rivi;
    }
    /**
     * Metodi käynnistää annetun parametrin avulla halutun lauserakenteen 
     * kokoajan ja palauttaa kootun lauseen.
     * 
     * @param sanoja Antaa rivin sanamäärän.
     * 
     * @return sanat Palauttaa ohjelman arpoman sanarakenteen.
     * 
     */
    public String sanat(int sanoja) throws FileNotFoundException {
        String sanat = "";
        if (sanoja == 7) {
             sanat = rakentaja.Rakenne7();
             
        } else if (sanoja == 6) {
             sanat = rakentaja.Rakenne6();
             
        } else if (sanoja == 5) {
             sanat = rakentaja.Rakenne5();
             
        } else if (sanoja == 4) {
             sanat = rakentaja.Rakenne4();
             
        } else if (sanoja == 3) {
             sanat = rakentaja.Rakenne3();
            
        } else if (sanoja == 2) {
             sanat = rakentaja.Rakenne2();
             
        } else if (sanoja == 1) {
             sanat = rakentaja.Rakenne1();
        }
        
        return sanat;
    }
}
