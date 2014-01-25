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
    private Arpoja arpoja;
    private List<String> lista;
    
    public Tiedostonlukija(Arpoja arpoja) {
       this.arpoja = arpoja;
      
    }
    
    public void tulostaTiedosto(File tiedosto) throws FileNotFoundException {
        this.lukija = new Scanner(tiedosto);
        while (lukija.hasNextLine()) {
            System.out.println(lukija.nextLine());
        }
        lukija.close();
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
       
        
        while (lukija.hasNextLine()) {
            String rivi = lukija.nextLine();
            lista.add(rivi);
        }
        
        lukija.close();
        String sana;
        sana = lista.get(arpoja.SatunnainenLuku(lista.size()));
        
        return sana;
    }
}
