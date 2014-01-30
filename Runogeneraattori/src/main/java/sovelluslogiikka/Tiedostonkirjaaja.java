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
 *
 * @author anna
 */
public class Tiedostonkirjaaja {
  
    private FileWriter kirjoittaja;
    private Tiedostonlukija lukija;
    private Runokone kone;
    
    public Tiedostonkirjaaja(Tiedostonlukija lukija) {
        this.lukija = lukija;
       
    }
    
    public boolean lisaaSana(File tiedosto, String sana) throws IOException {
         if (!this.lukija.onkoSanaVarastossa(sana, tiedosto)) {
              this.kirjoittaja = new FileWriter(tiedosto, true);
              kirjoittaja.append(sana + '\n');
              kirjoittaja.close();
              return true;
         }
         return false;
    }
    
    public boolean poistaSana(File tiedosto, String sana) throws FileNotFoundException, IOException {
        if (this.lukija.onkoSanaVarastossa(sana, tiedosto)) {
            this.kirjoittaja = new FileWriter(tiedosto, true);
            kirjoittaja.close();
            return true;
        }
        return false;
    }
    
    public boolean tyhjennaLista(File tiedosto) throws IOException {
            this.kirjoittaja = new FileWriter(tiedosto, true);
            if (tiedosto.length() != 0) {
                kirjoittaja.write("");
                kirjoittaja.close();
                return true;
            }
            return false;
    }
  
}
