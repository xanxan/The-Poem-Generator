/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sanavarasto;

import java.util.ArrayList;
import sovelluslogiikka.Arpoja;

/**
 *Luokan tehtävänä on säilyttää annettuja sanalistoja ja poimia sanoja 
 *listoista sattumanvaraisesti.
 * 
 * @author anna
 */
public class Sanavarasto {
    private ArrayList<String> substantiivit;
    private ArrayList<String> adjektiivit;
    private ArrayList<String> verbit;
    private ArrayList<String> numeraalit;
    private ArrayList<String> partikkelit;
    private ArrayList<String> pronominit;
    private ArrayList<String> prepositiot;
    private ArrayList<String> monikko;
    private Arpoja arpoja;
          
    public Sanavarasto(Arpoja arpoja) {
        
        this.arpoja = arpoja;
    }
    
    public void setSubstantiivit(ArrayList<String> lista) {
        
        this.substantiivit = lista;
    }
    
    public void setAdjektiivit(ArrayList<String> lista) {
        
        this.adjektiivit = lista;
    }
    
    public void setVerbit(ArrayList<String> lista) {
        
        this.verbit = lista;
    }
    
    public void setNumeraalit(ArrayList<String> lista) {
        
        this.numeraalit = lista;
    }
    
    public void setPartikkelit(ArrayList<String> lista) {
        
        this.partikkelit = lista;
    }
    
    public void setPronominit(ArrayList<String> lista) {
        
        this.pronominit = lista;
    }
    
    public void setPrepositiot(ArrayList<String> lista) {
        
        this.prepositiot = lista;
    }
    
    public void setMonikko(ArrayList<String> lista) {
        
        this.monikko = lista;
    }
    
    
    public ArrayList<String> getSubstantiivit() {
        return this.substantiivit;
    }
    
    public ArrayList<String> getAdjektiivit() {
        return this.adjektiivit;
    }
    
    public ArrayList<String> getVerbit() {
        return this.verbit;
    }
    
    public ArrayList<String> getNumeraalit() {
        return this.numeraalit;
    }
    
    public ArrayList<String> getPartikkelit() {
        return this.partikkelit;
    }
    
    public ArrayList<String> getPronominit() {
        return this.pronominit;
    }
    
    public ArrayList<String> getPrepositiot() {
        return this.prepositiot;
    }
    
    public ArrayList<String> getMonikko() {
        return this.monikko;
    }
    /**
     *Metodi valitsee satunnaisesti sanan annetusta listasta ja palauttaa sen.
     * 
     * @param lista Sanalista
     * @return sana Palauttaa satunnaisen sanan.
     * 
     */
    public String valitseSatunnainenSana(ArrayList<String> lista) {
        
        String sana;
        sana = lista.get(arpoja.SatunnainenLuku(lista.size()));
        
        return sana;
    }
}
