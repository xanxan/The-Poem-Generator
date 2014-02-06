/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

import sanavarasto.Lauseenrakentaja;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
     * Metodi kirjoittaa annettuun tiedostoon ohjelman laatiman runon ja 
     * palauttaa sen.
     * 
     * 
     * 
     */
    public File kirjoitaRuno() throws IOException {
        File runo = new File("runo.txt");
        int sakeistoja = 1 + arpoja.SatunnainenLuku(6);
        
        this.kirjoittaja = new FileWriter(runo, true);
            for (int i = 0; i < sakeistoja; i++) {
                kirjoittaja.write(this.sakeisto() + '\n');
            }
            kirjoittaja.close();
            
           
        
        return runo;
        
    }
    /**
     * Metodi arpoo säkeistön rivimäärän ja palauttaa kokoamansa säkeistön.
     * 
     * 
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
     * 
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
     * 
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
