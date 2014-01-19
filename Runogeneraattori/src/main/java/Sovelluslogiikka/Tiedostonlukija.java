/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sovelluslogiikka;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


/**
 *
 * @author anna
 */
public class Tiedostonlukija {
    
    private Scanner lukija;
    private Random arpoja;
    private List<String> lista;
    
    public Tiedostonlukija() {
       
      
    }
    
    public boolean onkoSanaVarastossa(String sana, File tiedosto) throws FileNotFoundException {
        this.lukija = new Scanner(tiedosto); 
        while (lukija.hasNextLine()) {
          String rivi = lukija.nextLine();
          if (rivi.equals(sana)) {
              return true;
          }
        }

        lukija.close();
        return false;
    }
    
    public String valitseSatunnainenSana(File tiedosto) throws FileNotFoundException {
        this.lukija = new Scanner(tiedosto);
        this.lista = new ArrayList<String>();
        this.arpoja = new Random();
        
        while (lukija.hasNextLine()) {
            String rivi = lukija.nextLine();
            lista.add(rivi);
        }
        
        lukija.close();
        String sana = lista.get(arpoja.nextInt(lista.size()));
        
        return sana;
    }
}
