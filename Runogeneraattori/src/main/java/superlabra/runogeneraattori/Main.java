/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package superlabra.runogeneraattori;


import Sovelluslogiikka.Arpoja;
import Sovelluslogiikka.Runokone;
import Sovelluslogiikka.Syotteenlukija;
import Sovelluslogiikka.Tiedostonkirjaaja;
import Sovelluslogiikka.Tiedostonlukija;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Scanner;


/**
 *
 * @author anna
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
       Syotteenlukija lukija = new Syotteenlukija();
      
       Arpoja arpoja = new Arpoja();
       
       Tiedostonlukija l = new Tiedostonlukija(arpoja);
        Tiedostonkirjaaja kirjaaja = new Tiedostonkirjaaja(l);
        Runokone runokone = new Runokone(arpoja, kirjaaja, l);
       
        System.out.println("Anna lisättävä sanat ja lopuksi 'lopeta':");
        while (true) {
            System.out.println("Sana:");
            String sana = lukija.LueSyote();
            if (sana.equals("lopeta")) {
                break;
            }
            System.out.println("Sanaluokka");
            String sanaluokka = lukija.LueSyote();
   
            
            File luokka = new File(sanaluokka + ".txt");
          
            kirjaaja.lisaaSana(luokka, sana);
            
        }
        
        System.out.println("Tulostetaan runo:");
        File runo = runokone.kirjoitaRuno();
        l.tulostaTiedosto(runo);
    }
}
