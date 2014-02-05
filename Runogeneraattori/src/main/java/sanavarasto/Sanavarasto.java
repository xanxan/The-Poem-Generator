/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sanavarasto;

import sovelluslogiikka.Arpoja;

import java.util.ArrayList;

/**
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
    private Arpoja arpoja;
          
    public Sanavarasto(Arpoja arpoja) {
        
        this.arpoja = arpoja;
    }
    
    public void setSubstantiivit(ArrayList<String> lista) {
        if (lista == null) {
            System.out.println("substantiivit null!");
            return;
        }
        this.substantiivit = lista;
    }
    
    public void setAdjektiivit(ArrayList<String> lista) {
        if (lista == null) {
            System.out.println("adjektiivit null!");
            return;
        }
        this.adjektiivit = lista;
    }
    
    public void setVerbit(ArrayList<String> lista) {
        if (lista == null) {
            System.out.println("verbit null!");
            return;
        }
        this.verbit = lista;
    }
    
    public void setNumeraalit(ArrayList<String> lista) {
        if (lista == null) {
            System.out.println("numeraalit null!");
            return;
        }
        this.numeraalit = lista;
    }
    
    public void setPartikkelit(ArrayList<String> lista) {
        if (lista == null) {
            System.out.println("partikkelit null!");
            return;
        }
        this.partikkelit = lista;
    }
    
    public void setPronominit(ArrayList<String> lista) {
        if (lista == null) {
            System.out.println("pronominit null!");
            return;
        }
        this.pronominit = lista;
    }
    
    
    public ArrayList<String> getSubstantiivit() {
                if (substantiivit == null) {
            System.out.println("substantiivit null!");
            
        }
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
    
    public String valitseSatunnainenSana(ArrayList<String> lista) {
        
       
       
        String sana;
        sana = lista.get(arpoja.SatunnainenLuku(lista.size()-1));
        
        return sana;
    }
}
