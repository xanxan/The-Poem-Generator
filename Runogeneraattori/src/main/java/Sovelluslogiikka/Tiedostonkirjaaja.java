/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sovelluslogiikka;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author anna
 */
public class Tiedostonkirjaaja {
  
    private FileWriter kirjoittaja;
    private Tiedostonlukija lukija;
    
    public Tiedostonkirjaaja() {
        this.lukija = new Tiedostonlukija();
       
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
}
