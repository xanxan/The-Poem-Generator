/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import sanavarasto.Sanavarasto;

/**
 * Luokan päätehtäviä ovat ohjelman alustaminen ja runokoneen käynnistäminen.
 * Muita tehtäviä ovat taustasiällön hallinnointi.
 * 
 *
 * @author anna
 */
public class Hallinto {
    
    private Tiedostonlukija lukija;
    private Tiedostonkirjaaja kirjaaja;
    private Sanavarasto varasto;
    private Runokone kone;
    
    public Hallinto(Tiedostonlukija lukija, Tiedostonkirjaaja kirjaaja, Arpoja arpoja) throws FileNotFoundException {
        this.kirjaaja = kirjaaja;
       
        this.lukija = lukija;
        this.varasto = new Sanavarasto(arpoja); 
        this.alustaOhjelma();
        this.kone = new Runokone(arpoja, varasto);
    }
    /**
     * Metodi lisää uuden sanan haluttuun tiedostoon kutsumalla
     * metodia Tiedostonkirjaaja-luokasta ja antamalla sille tarvittavat parametrit. 
     * 
     * @param tiedosto Tiedosto johon uusi sana lisätään.
     * @param sana Uusi lisättävä sana.
     * 
     */
    public void lisaaUusiSana(File tiedosto, String sana) throws IOException {
        this.kirjaaja.lisaaSana(tiedosto, sana);
    }
    
    public Sanavarasto getVarasto() {
        
        return varasto;
    }
    
    public Tiedostonlukija getLukija() {
        return this.lukija;
    }
    
    public Runokone getKone() {
        return kone;
    }
    
    public Tiedostonkirjaaja getKirjaaja() {
        return kirjaaja;
    }
    /**
     * Metodi alustaa ohjelman toimintakuntoon listaamalla annettujen
     * tiedostojen sanalistat ja lisäämällä ne sanavarastoon.
     * 
     * 
     * 
     */
    private void alustaOhjelma() throws FileNotFoundException {
        File adjektiivit = new File ("adjektiivit.txt");
        File substantiivit = new File ("substantiivit.txt");
        File verbit = new File ("verbit.txt");
        File numeraalit = new File ("numeraalit.txt");
        File pronominit = new File ("pronominit.txt");
        File partikkelit = new File ("partikkelit.txt");
        File monikko = new File ("monikko.txt");
        File prepositiot = new File ("prepositiot.txt");
        
        ArrayList<String> adj = this.lukija.luoLista(adjektiivit);
        ArrayList<String> subs = this.lukija.luoLista(substantiivit);
        ArrayList<String> verb = this.lukija.luoLista(verbit);
        ArrayList<String> part = this.lukija.luoLista(partikkelit);
        ArrayList<String> pron = this.lukija.luoLista(pronominit);
        ArrayList<String> num = this.lukija.luoLista(numeraalit);
        ArrayList<String> mon = this.lukija.luoLista(monikko);
        ArrayList<String> pre = this.lukija.luoLista(prepositiot);
       
        this.varasto.setAdjektiivit(adj);
        this.varasto.setNumeraalit(num);
        this.varasto.setPartikkelit(part);
        this.varasto.setPronominit(pron);
        this.varasto.setSubstantiivit(subs);
        this.varasto.setVerbit(verb);
        this.varasto.setPrepositiot(pre);
        this.varasto.setMonikko(mon);
    }
    /**
     * Metodi käynnistää runokoneen ja palauttaa metodin kirjoitaRuno laatiman
     * runon.
     * 
     * @return runo Palauttaa ohjelman tuottaman runon.
     * 
     */
    public String kaynnistaRunokone() throws IOException {
       String runo = kone.kirjoitaRuno();
       return runo;
    }
}
