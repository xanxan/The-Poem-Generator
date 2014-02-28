/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


/**
 *Luokan tehtävänä on lukea ja etsiä tiedostoista tarvittavat tiedot.
 * 
 * 
 * @author anna
 */
public class Tiedostonlukija {
   
    
    public Tiedostonlukija() {
        
      
    }
    /**
     * Metodi tulostaa sille annetun tiedoston sisällön. 
     * 
     * @param tiedosto tulostettava tiedosto
     * @return tiedoston sisältö stringiin talletettuna.
     * 
     */
    public String tulostaTiedosto(File tiedosto) throws FileNotFoundException {
        Scanner lukija = new Scanner(tiedosto);
        String runo = "";
        
        while (lukija.hasNextLine()) {
            runo += lukija.nextLine();
        }
        lukija.close();
        
        return runo;
    }
    /**
     * Metodi tarkastaa löytyykö sille parametrina annettu sana halutusta
     * tiedostosta ja palauttaa tulosta vastaavan totuusarvon.
     * 
     * @param tiedosto Tiedosto josta sana etsitään.
     * @param sana Etsittävä sana.
     * @return true jos sana löytyi, false jos ei löytynyt.
     * 
     */
    public boolean onkoSanaVarastossa(String sana, File tiedosto) throws FileNotFoundException {
        Scanner lukija = new Scanner(tiedosto); 
        
        while (lukija.hasNextLine()) {
            String rivi = lukija.nextLine();
            
            if (rivi.equals(sana)) {
                  return true;
            }
        }

        lukija.close();
        
        return false;
    }
    
    /**
     * Metodi luo Array -tyyppisen listan annetun tiedoston sisällöstä ja 
     * palauttaa sen.
     * 
     * @param tiedosto Tiedosto jonka sisältö muutetaan listaksi.
     * @return luotu Array-lista.
     * 
     * 
     */
     public ArrayList<String> luoLista(File tiedosto) throws FileNotFoundException {
        Scanner lukija = new Scanner(tiedosto);
        ArrayList<String> lista = new ArrayList();
        
        while (lukija.hasNextLine()) {
            String rivi = lukija.nextLine();
            lista.add(rivi);
        }
        
        lukija.close();
        
        return lista;
        
    }
}
