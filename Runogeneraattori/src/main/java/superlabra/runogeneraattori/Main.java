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
import sanavarasto.Sanavarasto;


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
      Tiedostonlukija lukija = new Tiedostonlukija();
      Sanavarasto varasto = new Sanavarasto(arpoja);
      File adjektiivit = new File("tiedostonkirjaajaTest.txt");
        Tiedostonkirjaaja kirjaaja = new Tiedostonkirjaaja(lukija);
        Hallinto hallinto = new Hallinto(lukija, kirjaaja, arpoja);
        File runo = hallinto.kaynnistaRunokone();
        lukija.tulostaTiedosto(runo);
        
        
    }
}
