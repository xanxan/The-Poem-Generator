/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package superlabra.runogeneraattori;


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
        Syotteenlukija moi = new Syotteenlukija();
        Tiedostonlukija scanneri = new Tiedostonlukija();
        
        File tiedosto = new File ("testitiedosto.txt");
        Tiedostonkirjaaja kirjaaja = new Tiedostonkirjaaja();
        System.out.println("anna lisättävä sana");
        String lisattava = moi.LueSyote();
        kirjaaja.lisaaSana(tiedosto, lisattava);
        System.out.println("anna sana");
        String sana = moi.LueSyote();
        if (scanneri.onkoSanaVarastossa(sana, tiedosto)) {
            System.out.println("sana on varastossa");
        } else {
            System.out.println("sana ei ole varastossa");
        }
        
    }
}
