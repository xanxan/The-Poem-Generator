/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package superlabra.runogeneraattori;


import Sovelluslogiikka.Arpoja;
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
       Arpoja arpoja = new Arpoja();
       int luku = 0;
       while (luku < 10) {
           System.out.println(arpoja.SatunnainenLuku(10));
           luku++;
       }
    }
}
