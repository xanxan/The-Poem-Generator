/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package superlabra.runogeneraattori;


import sanavarasto.Lauseenrakentaja;
import sovelluslogiikka.Arpoja;
import sovelluslogiikka.Hallinto;
import sovelluslogiikka.Runokone;
import sovelluslogiikka.Syotteenlukija;
import sovelluslogiikka.Tiedostonkirjaaja;
import sovelluslogiikka.Tiedostonlukija;

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
        
       Tiedostonlukija lukija = new Tiedostonlukija();
      Tiedostonkirjaaja kirjaaja = new Tiedostonkirjaaja(lukija);
      Arpoja arpoja = new Arpoja();
       Hallinto hallinto = new Hallinto(lukija, kirjaaja, arpoja);
       hallinto.alustaOhjelma();
       Lauseenrakentaja rakentaja = new Lauseenrakentaja(arpoja);
        System.out.println(rakentaja.Rakenne1());
    }
}
