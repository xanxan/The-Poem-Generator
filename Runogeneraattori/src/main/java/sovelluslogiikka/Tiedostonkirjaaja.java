/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Tästä luokasta käsin suoritetaan tiedostoihin tehtävät muutokset.
 * 
 * 
 * @author anna
 */
public class Tiedostonkirjaaja {
  
    private FileWriter kirjoittaja;
    private Tiedostonlukija lukija;
   
    
    public Tiedostonkirjaaja(Tiedostonlukija lukija) {
        this.lukija = lukija;
       
    }
    /**
     * Metodi lisää sanan haluttuun tiedostoon.
     * 
     * @param sana Lisättävä sana.
     * @param tiedosto Tiedosto johon uusi sana lisätään.
     * @return true jos lisäys onnistui, false jos sana löytyi jo varastosta.
     * 
     */
    public boolean lisaaSana(File tiedosto, String sana) throws IOException {
         if (!this.lukija.onkoSanaVarastossa(sana, tiedosto)) {
              this.kirjoittaja = new FileWriter(tiedosto, true);
              kirjoittaja.append(sana + '\n');
              kirjoittaja.close();
              return true;
         }
         return false;
    }
    /**
     * Metodi poistaa halutun sanan annetusta tiedostosta.
     * 
     * @param tiedosto Kohdetiedosto
     * @param sana Poistettava sana
     * @return true jos poisto onnistuu, false jos sanaa ei löydy varastosta.
     * 
     */
    
    public boolean poistaSana(File tiedosto, String sana) throws FileNotFoundException, IOException {
        if (this.lukija.onkoSanaVarastossa(sana, tiedosto)) {
            this.kirjoittaja = new FileWriter(tiedosto, true);
            kirjoittaja.close();
            return true;
        }
        return false;
    }
    /**
     * Metodi poistaa kaiken sisällön annetusta tiedostosta.
     * @param tiedosto Tyhjennettävä tiedosto
     * @return true jos tyhjennys onnistui, false jos tiedosto on jo tyhjä.
     * 
     * 
     */
    
    public boolean tyhjennaLista(File tiedosto) throws IOException {
            this.kirjoittaja = new FileWriter(tiedosto);
            if (tiedosto.length() != 0) {
                kirjoittaja.write("");
                kirjoittaja.close();
                return true;
            }
            return false;
    }
    
    /**
     * Metodi kirjoittaa Stringin sisällön haluttuun tiedostoon ja palauttaa tiedoston.
     * 
     * @param tiedostonimi Tiedoston nimi
     * @param teksti Tiedoston sisältö
     * @return luotu tiedosto.
     */
    public File luoTiedostoksi(String tiedostonimi, String teksti) throws IOException {
        File file = new File(tiedostonimi);
        this.kirjoittaja = new FileWriter(file);
        kirjoittaja.write(teksti); 
        kirjoittaja.close();
            
         
        return file;
    }
  
}
