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
    
    public Tiedostonkirjaaja() {
     
       
    }
    
    public void lisaaSana(File tiedosto, String sana) throws IOException {
         this.kirjoittaja = new FileWriter(tiedosto, true);
         kirjoittaja.append(sana + '\n');
         kirjoittaja.close();
    }
}
