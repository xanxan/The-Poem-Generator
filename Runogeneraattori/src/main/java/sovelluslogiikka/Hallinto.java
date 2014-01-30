/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

import sanavarasto.Sanavarasto;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author anna
 */
public class Hallinto {
    
    private Tiedostonlukija lukija;
    private Tiedostonkirjaaja kirjaaja;
    private Sanavarasto varasto;
    
    public Hallinto(Tiedostonlukija lukija, Tiedostonkirjaaja kirjaaja, Arpoja arpoja) {
        this.kirjaaja = kirjaaja;
       
        this.lukija = lukija;
        this.varasto = new Sanavarasto(arpoja); 
    }
    
    public void lisaaUusiSana(File tiedosto, String sana) throws IOException {
        this.kirjaaja.lisaaSana(tiedosto, sana);
    }
    
    public void alustaOhjelma() throws FileNotFoundException {
        File adjektiivit = new File ("adjektiivit.txt");
        File substantiivit = new File ("substantiivit.txt");
        File verbit = new File ("verbit.txt");
        File numeraalit = new File ("numeraalit.txt");
        File pronominit = new File ("pronominit.txt");
        File partikkelit = new File ("partikkelit.txt");
        
        ArrayList<String> adj = this.lukija.luoLista(adjektiivit);
        ArrayList<String> subs = this.lukija.luoLista(substantiivit);
        ArrayList<String> verb = this.lukija.luoLista(verbit);
        ArrayList<String> part = this.lukija.luoLista(partikkelit);
        ArrayList<String> pron = this.lukija.luoLista(pronominit);
        ArrayList<String> num = this.lukija.luoLista(numeraalit);
       
        this.varasto.setAdjektiivit(adj);
        this.varasto.setNumeraalit(num);
        this.varasto.setPartikkelit(part);
        this.varasto.setPronominit(pron);
        this.varasto.setSubstantiivit(subs);
        this.varasto.setVerbit(verb);
    }
}
