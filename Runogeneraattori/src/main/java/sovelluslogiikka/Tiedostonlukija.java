/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


/**
 *
 * @author anna
 */
public class Tiedostonlukija {
    private Scanner lukija;
   
    
    public Tiedostonlukija() {
        
      
    }
    
    public void tulostaTiedosto(File tiedosto) throws FileNotFoundException {
        Scanner lukija = new Scanner(tiedosto);
        while (lukija.hasNextLine()) {
            System.out.println(lukija.nextLine());
        }
        lukija.close();
    }
    
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
